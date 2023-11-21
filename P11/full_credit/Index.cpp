#include "Location.h"
#include "Index.h"


void Index::addWord(const Word &word, const std::string &filename, int line)
{
    Word lowercaseWord = word;
    transform(lowercaseWord.begin(), lowercaseWord.end(), lowercaseWord.begin(), ::tolower);

    while (!lowercaseWord.empty() && !isalnum(lowercaseWord.front())) 
    {
        lowercaseWord.erase(lowercaseWord.begin());
    }

    while (!lowercaseWord.empty() && !isalnum(lowercaseWord.back())) 
    {
        lowercaseWord.pop_back();
    }

    if (lowercaseWord.empty()) {
        cerr << "Invalid word" << endl;
        return;
    }
    index[lowercaseWord].insert(Location(filename, line));
}

std::ostream& operator<<(std::ostream& ost, const Index& index) 
{
    for (auto it = index.index.begin(); it != index.index.end(); ++it) 
    {
        ost << it->first << ":";

        for (auto It = it->second.begin(); It != it->second.end(); ++It)
        {
            ost << " " << *It;
        }
        ost << endl;
    }
    return ost;
}