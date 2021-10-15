/* =======================================================================
 * |
 * | Author: Armando Ramos Jr
 * |
 * | Purpose: This class exist because it computes and returns all of 
 * |          the computations and checks whether or not the rectangles are 
 * |          equals, proportional, equivalent, similar, and concentric.
 * |
 * | Inherits From: java.awt.Rectangle
 * |
 * | Interfaces: None
 * |
 * | +-----------------------------------------------------------------------|
 * | Constants:
 * |    ACCEPTABLE_DIFFERENCE - The difference between two number which stops
 * |        being equal to, this is the value because all double values are to
 * |        be round to two decimal places
 * |    SCALE_BY_GREATER_THAN - used in the scaleBy, the minimum value not
 * |        inclusive that scaleBy allows
 * |    ORIGIN - The origin on a graph, at the point (0,0)
 * |    DEFAULT_SIZE - When constructing a BetterRectangle and no size is give
 * |        the default of 1 will be used
 * | +-----------------------------------------------------------------------|
 * | Constructors:
 * |    BetterRectangle()
 * |            Constructor for the game of craps
 * |    BetterRectangle(int width,int height)
 * |            Constructor with point at the origin and a width and height
 * |            specified by the parameter
 * |    BetterRectangle(int xCoordinate, int yCoordinate, int width, int height)
 * |            Constructor with point, width, and height all specified as ints
 * |    BetterRectangle(BetterRectangle rectangle)
 * |            Constructor with the same values as the rectangle given as a
 * |            parameter
 * |
 * |  Class Methods:
 * |    None
 * |
 * |  Instance Methods:
 * |    getArea - int
 * |    getPerimeter - int
 * |    getSlope - int
 * |    getMipPoint- int
 * |    toString - String
 * |    getRoundedSlope - String
 * |    equals(Object rectangle) - boolean
 * |    isProportional(BetterRectangle rectangleTwo) - boolean
 * |    isEquivalent(BetterRectangle rectangleTwo) - boolean
 * |    isSimilar(BetterRectangle rectangleTwo) - boolean
 * |    isConcentric(BetterRectangle rectangleTwo)- boolean
 * |    scaleBy(int scale) - boolean
 * |*======================================================================= */

import java.awt.Point;      //Used to give Mid-Point and with a constant of at the origin
import java.awt.Rectangle;  //Imports all the methods to be used


public class BetterRectangle extends Rectangle
{

    public final double ACCEPTABLE_DIFFERENCE = 0.001;
    public final int SCALE_BY_GREATER_THAN = 0;
    public final Point ORIGIN = new Point(0, 0);
    public final int DEFAULT_SIZE = 1;

    /**
     * Constructs a default BetterRectangle.
     * The default BetterRectangle is at the origin (0,0) with lengths of 1 for
     * width and height
     */
    public BetterRectangle()
    {
        super.setLocation(ORIGIN);
        super.setSize(DEFAULT_SIZE, DEFAULT_SIZE);
    }

    /**
     * Constructs a BetterRectangle with given lengths.
     * The BetterRectangle created here will be at the origin (0,0) with the
     * given size for width and height
     *
     * @param width  - length of the width
     * @param height - length of the height
     */
    public BetterRectangle(int width, int height)
    {
        super.setLocation(ORIGIN);
        super.setSize(width, height);
    }

    /**
     * Constructs a BetterRectangle with given lengths and coordinate of the
     * top-left corner.
     * The BetterRectangle is created with custom origin, width, and height
     *
     * @param xCoordinate - The X Coordinate for the top-left corner
     * @param yCoordinate - The Y coordinate for the top left corner
     * @param width       - length of the width
     * @param height      - length of the height
     */
    public BetterRectangle(int xCoordinate, int yCoordinate, int width, int height)
    {
        super.setLocation(xCoordinate, yCoordinate);
        super.setSize(width, height);
    }

    /**
     * Constructs a BetterRectangle with the given BetterRectangle.
     * The BetterRectangle is created with the values of another BetterRectangle
     *
     * @param rectangle - The other BetterRectangle whos values will be used in
     *                  this BetterRectangle
     */
    public BetterRectangle(BetterRectangle rectangle)
    {
        int xCoordinate = (int) rectangle.getX();
        int yCoordinate = (int) rectangle.getY();
        int width = (int) rectangle.getWidth();
        int height = (int) rectangle.getHeight();

        super.setLocation(xCoordinate, yCoordinate);
        setSize(width, height);
    }

    /**
     * Calculates the area of the rectangle.
     * getArea - Computes the area of the rectangle by multiplying the width and
     * height
     *
     * @return - int value of the area of the rectangle
     */
    public int getArea()
    {
        int area = (int) (getWidth() * getHeight());
        return area;
    }

    /**
     * Calculates the perimeter of the rectangle.
     * getPerimeter - Computes the perimeter by adding the 4 sides of the
     * rectangle
     *
     * @return - int value of the perimeter
     */
    public int getPerimeter()
    {
        int perimeter = (int) ((getWidth() + getHeight()) + (getWidth() + getHeight()));
        return perimeter;
    }

    /**
     * Calculates the slope of the rectangle.
     * getSlope - Computes the slope by dividing the height by the width
     *
     * @return - double value of the slope of the rectangle
     */
    public double getSlope()
    {
        double slope = 0.0;
        if (!(getWidth() == 0))
        {
            slope = getHeight() / getWidth();
        }
        return slope;
    }

    /**
     * Calculates the mid-point of the rectangle.
     * getMidPoint - Computes the mid-point by dividing the width and height by
     * 2, rounding
     * the number to the nearest integer and then adding the x coordinate with
     * the width and the y coordinate with the height
     *
     * @return - Point of the mid-point of the rectangle
     */
    public Point getMidPoint()
    {
        int midWidth = (int) Math.round(getWidth() / 2);
        int midHeight = (int) Math.round(getHeight() / 2);
        Point midPoint = new Point(((int) getX() + midWidth), ((int) getY()) + midHeight);
        return midPoint;
    }

    /**
     * Overrides the toString from Rectangle.
     * toString - Overrides to include area, perimeter, slope, and mid-point
     *
     * @return - String with all the data of the rectangle
     */
    @Override
    public String toString()
    {
        String rectangle = String.format("BetterRectangle[x=" + (int) getX() + ", y=" + (int) getY()
                + ", width=" + (int) getWidth() + ", height=" + (int) getHeight() + ", area=" + getArea() + ", perimeter=" + getPerimeter()
                + ", slope=" + getRoundedSlope() + ", mid-point=" + getMidPoint() + "]");
        return rectangle;
    }

    /**
     * Gets the slope of the rectangle and rounds it.
     * getRoundedSlope - ROunds
     *
     * @return -
     */
    public String getRoundedSlope()
    {
        String roundedSlope = String.format("%.2f", getSlope());
        return roundedSlope;
    }

    /**
     * Compares two BetterRectangle to see if they are equal.
     * equals - Compares two BetterRectangles to see if they have the same width
     * and height, I choose to only check the width and height because if the
     * width and height are the same then so are the area, perimeter, slope, and
     * mid-point in respect to the rectangle. That makes them equal, just
     * because two object that are exactly the same are not in the same place
     * does not make them not the same anymore.
     *
     * @param rectangle - Object another rectangle
     *
     * @return - boolean, true is the two BetterRectangles are equal, false if
     *         they are not
     */
    @Override
    public boolean equals(Object rectangle)
    {
        boolean equals = false;
        BetterRectangle rectangleTwo = (BetterRectangle) rectangle;

        int widthRecOne = (int) getWidth();
        int widthRecTwo = (int) rectangleTwo.getWidth();
        int heightRecOne = (int) getHeight();
        int heightRecTwo = (int) rectangleTwo.getHeight();

        if ((widthRecOne == widthRecTwo) && (heightRecOne == heightRecTwo))
        {
            equals = true;
            return equals;
        }
        else
        {
            equals = false;
            return equals;
        }

    }

    /**
     * Checks if two BetterRectangles have the same slope.
     * isProportional - Calculates the difference between the two slopes, if the
     * difference is insignificant enough then they will be considered
     * proportional
     *
     * @param rectangle - the second rectangle being compared to the first
     *
     * @return - boolean, true if proportional, false if not
     */
    public boolean isProportional(BetterRectangle rectangle)
    {
        boolean isProportional = false;
        double slopeRecOne = getSlope();
        double slopeRecTwo = rectangle.getSlope();
        if (Math.abs(slopeRecOne - slopeRecTwo) <= ACCEPTABLE_DIFFERENCE)
        {
            isProportional = true;
            return isProportional;
        }
        else
        {
            isProportional = false;
            return isProportional;
        }
    }

    /**
     * Checks if two BetterRectangles have the same perimeter.
     * isEquivalent - Checks if the perimeter of the rectangles are the same
     *
     * @param rectangle - the second BetterRectangle being compared to the first
     *
     * @return - boolean, true if equivalent, false if not
     */
    public boolean isEquivalent(BetterRectangle rectangle)
    {
        boolean isEquivalent = false;
        int perimeterOne = getPerimeter();
        int perimeterTwo = rectangle.getPerimeter();

        if (perimeterOne == perimeterTwo)
        {
            isEquivalent = true;
            return isEquivalent;
        }
        else
        {
            return isEquivalent;
        }
    }

    /**
     * Checks if two BetterRectangles have the same area.
     * isSimilar - Checks if the area of the rectangles are the same
     *
     * @param rectangle - the second BetterRectangle being compared to the first
     *
     * @return - boolean, true if similar, false if not
     */
    public boolean isSimilar(BetterRectangle rectangle)
    {
        boolean isSimilar = false;
        int areaOne = getArea();
        int areaTwo = rectangle.getArea();

        if (areaOne == areaTwo)
        {
            isSimilar = true;
            return isSimilar;
        }
        else
        {
            return isSimilar;
        }

    }

    /**
     * Checks if two BetterRectangles have the same mid-point.
     * isConcentric - Checks if the area of the mid-point are the same
     *
     * @param rectangle - the second BetterRectangle being compared to the first
     *
     * @return - boolean, true if concentric, false if not
     */
    public boolean isConcentric(BetterRectangle rectangle)
    {
        Point midPointOne = getMidPoint();
        Point midPointTwo = rectangle.getMidPoint();

        boolean isConcentric = false;

        if (((midPointOne.x == midPointTwo.x)) && ((midPointTwo.y == midPointTwo.y)))
        {
            isConcentric = true;
            return isConcentric;
        }
        else
        {
            return isConcentric;
        }

    }

    /**
     * Increases the scale of the BetterRectangle.
     * scaleBy - Multiplies the width and the height by the scale and checks
     * that it did it correctly
     *
     * @param scale - the number that the BetterRectangle would be scaled to,
     *              only integers and must be greater than 0
     *
     * @return - boolean, true if scaled correctly, false if not or scale is
     *         smaller than what is allowed
     */
    public boolean scaleBy(int scale)
    {
        double originalWidth = getWidth();
        double originalHeight = getHeight();
        boolean scaledBy = false;

        if (scale <= SCALE_BY_GREATER_THAN)
        {
            return scaledBy;
        }
        else
        {
            setSize((int) (getWidth() * scale), (int) (getHeight() * scale));
        }

        if (getWidth() == (originalWidth * scale) && getHeight() == (originalHeight * scale))
        {
            scaledBy = true;
            return scaledBy;
        }
        else
        {
            scaledBy = false;
            return scaledBy;
        }

    }
}