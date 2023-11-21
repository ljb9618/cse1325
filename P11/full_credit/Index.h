#ifndef _INDEX_H
#define _INDEX_H
#include <set>
#include <map>
using namespace std;
class Location;
typedef std::set<Location> Locations;
typedef string Word;

class Location;
class Index 
{
public:
    void addWord(const Word& word, const string& filename, int line);

private:
    using Indexmap = map<Word, Locations>;
    Indexmap index;
    friend std::ostream& operator<<(std::ostream& ost, const Index& index);
};

#endif