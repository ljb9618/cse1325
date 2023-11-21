#include <vector>
#include <iostream>
#include <sstream>
#include <fstream>
#include "Index.h"
#include "Location.h"

int main() 
{
    vector<string> filenames = 
    { "glimpse.txt", "captain.txt", "america.txt", "spider.txt" };
    Index index;
    for (const auto& filename : filenames) 
    {
        ifstream file(filename);
        if (!file.is_open()) {
            cerr << "File opening error" << endl;
            return 1;
        }
        string line;
        int numLine = 1;
        while (getline(file, line)) 
        {
            istringstream iss(line);
            string word;
            while (iss >> word) 
            {
                index.addWord(word, filename, numLine);
            }
            numLine++;
        }
        file.close();
    }
    cout << index;
    
    return 0;
}