package com.solidprinciples.lsp;

public class LiskovSubstitutionPrinciple {

}

/*
The Liskov Substitution Principle (LSP) applies to inheritance hierarchies
such that derived classes must be completely substitutable for their base classes.
 */

class RectangleNotLsp {
    private double height;
    private double width;
    public void setHeight(double h) { height = h; }
    public void setWidth(double w) { width = w; }
}
class Square extends RectangleNotLsp {
    public void setHeight(double h) {
        super.setHeight(h);
        super.setWidth(h);
    }
    public void setWidth(double w) {
        super.setHeight(w);
        super.setWidth(w);
    }
}

/*
The above classes do not obey LSP because you cannot replace the Rectangle base class with its
derived class Square. The Square class has extra constraints,
i.e., the height and width must be the same. Therefore,
substituting the Rectangle with the Square class may result in unexpected behavior.

The solution to the above example is to create a separate abstract Shape class and
then have the Square and Rectangle classes inherit from it.
Consider the following code examples:

 */


