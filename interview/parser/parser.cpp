/*
top 3 most visited sites
*/
#include <iostream>
#include <vector>
#include <sstream>
#include <fstream>
#include <unordered_map>
#include <algorithm>
#include <string>
using namespace std;

bool sortByVal(const pair<string, int> &a,
               const pair<string, int> &b)
{
    return (a.second > b.second);
}

void getTop3Visited(string filename) {
    vector<string> row;
    unordered_map<string, float> hm;
    ifstream myFile(filename);
    if(!myFile.is_open()) throw std::runtime_error("Could not open file");
    string line, sitename;
    while(getline(myFile, line)) {
        stringstream ss(line);

        while (getline(ss, line, ',')) {
            if (line.find("\"") != string::npos) {
                string cur;
                getline(ss, cur, '\"');
                sitename = line +cur;
                row.push_back(sitename);
            }
            else if(line != "") {
                row.push_back(line);
            }
        }

        sitename = sitename == "" ? row[2] : sitename;
        hm[sitename] = hm.find(sitename) == hm.end() ? 1 : hm[sitename]+1;

        row.clear();
        sitename = "";
    }

    vector<pair<string, int>> toSort;
    for (auto const& [key, val] : hm) {
        toSort.push_back(make_pair(key, val));
    }

    sort(toSort.begin(), toSort.end(), sortByVal);

    for(pair<string, int> cur: toSort) {
        cout << cur.first << ":" << to_string(cur.second) << endl;
    }
}

void getTotalInputOutput(string filename) {
    vector<string> row;
    unordered_map<string, pair<float, float>> hm;
    ifstream myFile(filename);
    if(!myFile.is_open()) throw std::runtime_error("Could not open file");
    string line, sitename;
    float inputBytes, outputBytes;
    while(getline(myFile, line)) {
        stringstream ss(line);
        while (getline(ss, line, ',')) {
            if (line.find("\"") != string::npos) {
                string cur;
                getline(ss, cur, '\"');
                sitename = line +cur;
                row.push_back(sitename);
            }
            else if(line != "") {
                row.push_back(line);
            }
        }

        sitename = sitename == "" ? row[2] : sitename;

        string::size_type sz;     // alias of size_t
        if(row[3] != "input_bytes") {
            inputBytes = stof (row[3],&sz);
            outputBytes = stof (row[4],&sz);
            hm[sitename].first = hm.find(sitename) == hm.end() ? inputBytes : hm[sitename].first + inputBytes;
            hm[sitename].second = hm.find(sitename) == hm.end() ? inputBytes : hm[sitename].second + inputBytes;
        }

        row.clear();
        sitename = "";
    }

    for(auto const &[key, val] : hm) {
        cout << key << ":\t\t" << to_string(val.first) << "," << to_string(val.second) << endl;
    }
}


int main() {
    getTop3Visited("screen_share_interview_data.csv");
    getTotalInputOutput("screen_share_interview_data.csv");
    return 0;
}