#ifndef _SHAPE_H
#define _SHAPE_H
#include <string>

using std::string;
class Shape
        {
public:
    virtual string name() const = 0;
    virtual double area() const = 0;
    string toString();
};

#endif