class Sum {
    public static int sumOfAreas(Shape[] array) {
        // write your code here
        int area = 0;
        for (Shape shape : array) {
            if (shape.getClass() == Shape.class) {
                area += 0;
            } else if (shape.getClass() == Square.class) {
                area += (int) Math.pow(((Square) shape).getSide(), 2);
            } else if (shape.getClass() == Rectangle.class) {
                area += ((Rectangle) shape).getHeight() * ((Rectangle) shape).getWidth();
            }
        }
        return area;
    }
}

//Don't change the code below
class Shape {
}

class Square extends Shape {
    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}