#ifndef _SHAPE_H
#define _SHAPE_H
#include <string>

using std::string;
class Shape
        {
public:
    virtual string name() const;
    virtual double area() const;
    string toString();
};

#endif