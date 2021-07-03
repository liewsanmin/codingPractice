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
    string line, val;
    
    while(getline(myFile, line)) {
        stringstream ss(line);
        size_t found = line.find("\"");
        if (found != string::npos) {
            cout << "";
        }
        else {
            while (getline(ss, line, ',')) {
                row.push_back(line);
            }
            string sitename = row[2];
            if(hm.find(sitename) == hm.end()) {
                hm[sitename] = 1;
            }
            else {
                hm[sitename]++;
            }
            row.clear();
            
        }
    }
    for(auto const&[key, val] : hm) {
        cout << key << ":" << to_string(val) << endl;
    }
    return ans;
}


/*
total input and output
*/

int main() {
    getTop3Visited("screen_share_interview_data.csv");
}