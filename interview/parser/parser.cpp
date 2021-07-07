/*
top 3 most visited sites
*/
#include <iostream>
#include <vector>
#include <sstream>
#include <fstream>
#include <unordered_map>
using namespace std;

vector<string> getTop3Visited(string filename) {
    vector<string> ans, row;
    unordered_map<string, float> hm;
    ifstream myFile(filename);
    if(!myFile.is_open()) throw std::runtime_error("Could not open file");
    string line, val, sitename;
    bool foundCommaInSite = false;
    while(getline(myFile, line)) {
        stringstream ss(line);

        while (getline(ss, line, ',')) {
            if (line.find("\"") != string::npos) {
                string cur;
                getline(ss, cur, '\"');
                sitename = line +cur;
                row.push_back(line);
                foundCommaInSite = true;
                continue;
            }
            if(line != "") {
                row.push_back(line);
            }
        }

        sitename = sitename == "" ? row[2] : sitename;
        hm[sitename] = hm.find(sitename) == hm.end() ? 1 : hm[sitename]+1;

        row.clear();
        sitename = "";
    }
    for (auto const& [key, val] : hm) {
        cout << key << ':' << val << endl;
    }
    return ans;
}



int main() {
    getTop3Visited("screen_share_interview_data.csv");
    return 0;
}