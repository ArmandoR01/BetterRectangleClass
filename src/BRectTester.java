/* ============================================================================
 * |
 * | Author: Armando Ramos Jr
 * |
 * | Description: A program that that improves on the already made rectangle
 * |    class from java that changes the default rectangle to have a width and
 * |    height of 1, changes the equals method to check only if the sides are
 * |    equal in length, changes the toString to now include area, perimeter,
 * |    slope, and mid-point, while also adding methods to compute each, added
 * |    other methods to check if two rectangles are proportional, equivalent,
 * |    similar, and concentric, and lastly a method that scales the rectangle
 * |    to any integer greater than 0.
 * |
 * | Input: No User Input, input is "hard-coded" in 
 * |
 * | Output: An updated toString for each rectangle created, as well as separate
 * |    area, perimeter, slope, and midpoint for rectangle A, a comparison
 * |    between rectangle B and C checking and returning a boolean if both are
 * |    equal, proportional, equivalent, similar, and concentric and the expected
 * |    values, and lastly a before toString of rectangle D, calling the method
 * |    scaleBy twice to test with positive and negative numbers which returns
 * |    a boolean when completed, true for success and false for failure, and an
 * |    other toString after the scaleBy.
 * |
 * | Process: The program will start off by creating rectangles based on the
 * |    information "hard-coded" in as a test, after creating each rectangle it
 * |    will print the rectangle's corresponding toString, followed by a method
 * |    to call all assessor methods using rectangleA, then a method calling all
 * |    the utility methods using rectangleB and rectangleC, and finally the
 * |    mutator method using rectangleD while printing a toString before and
 * |    after.
 * |
 * | *======================================================================= */

public class BRectTester
{

    public static void main(String[] args)
    {
        BRectTester output = new BRectTester();

        BetterRectangle bRectA = new BetterRectangle(3, 4);
        System.out.println("A: " + output.printToString(bRectA));

        BetterRectangle bRectB = new BetterRectangle(bRectA);
        System.out.println("B: " + output.printToString(bRectB));

        BetterRectangle bRectC = new BetterRectangle(1, 1, 4, 3);
        System.out.println("C: " + output.printToString(bRectC));

        BetterRectangle bRectD = new BetterRectangle();
        System.out.println("D: " + output.printToString(bRectD));

        System.out.println(output.printAccessorMethods(bRectA));

        System.out.println(output.printUtilityMethods(bRectB, bRectC));

        System.out.println(output.printMutatorMethods(bRectD));
    }

    /**
     * Constructor for the BRectTester.
     * BRectTester gives access to the output methods
     */
    public BRectTester()
    {

    }

    /**
     * Makes a String variable the contents the the toStrign for the rectangle
     * provided.
     * printToString - used to the main to print the toString for the rectangle
     * passed in as the parameter
     *
     * @param rectangle - the rectangle which will be used to get the toString
     *                  from
     *
     * @return - String with the values of the toString
     */
    public String printToString(BetterRectangle rectangle)
    {
        String output = rectangle.toString();
        return output;
    }

    /**
     * Uses and creates a String with all the accessor method values using the
     * rectangles passed as the parameter.
     * printAcessorMethods - calls and creates a String variable with the values
     * of all the accessor methods
     *
     * @param rectangle - used to get which rectangle will be used with the
     *                  methods.
     *
     * @return - a String variable containing the results.
     */
    public String printAccessorMethods(BetterRectangle rectangle)
    {
        String coordinateMidPoint = "(" + rectangle.getMidPoint().x + "," + rectangle.getMidPoint().y + ")";
        String output = "\nAccessor methods being executed for Rectangle A..."
                + "\nA: " + rectangle.toString()
                + "\n   Area: " + rectangle.getArea()
                + "\n   Perimeter: " + rectangle.getPerimeter()
                + "\n   Slope: " + rectangle.getRoundedSlope()
                + "\n   MidPoint: " + coordinateMidPoint;
        return output;
    }

    /**
     * Uses and creates a String variable which compares the two rectangles
     * provided.
     * printUtilityMethods - Used to compare two rectangles for equals,
     * proportional, equivalent, similar, and concentric
     *
     * @param rectangleOne - The first rectangle used in the comparison between
     *                     two rectangles
     * @param rectangleTwo - The second rectangle used in the comparison between
     *                     two rectangles
     *
     * @return - a String Variable with the results showing true or false and
     *         its expected value
     */
    public String printUtilityMethods(BetterRectangle rectangleOne, BetterRectangle rectangleTwo)
    {
        String output = "\nUtility methods being executed for Rectangle B and C..."
                + "\nB: " + rectangleOne.toString()
                + "\nC: " + rectangleTwo.toString()
                + "\n   Equals?: " + rectangleOne.equals(rectangleTwo) + "\tExpected: false"
                + "\n   Proportional?: " + rectangleOne.isProportional(rectangleTwo) + "\tExpected: false"
                + "\n   Equivalent?: " + rectangleOne.isEquivalent(rectangleTwo) + "\tExpected: true"
                + "\n   Similar?: " + rectangleOne.isSimilar(rectangleTwo) + "\tExpected: true"
                + "\n   Concentric?: " + rectangleOne.isConcentric(rectangleTwo) + "\tExpected: false";

        return output;
    }

    /**
     * Method that uses and creates a String variable that has the result of the
     * scaleBy method
     * printMutatorMethods- Create a String variable that would then be printed
     * in the main method
     *
     * @param rectangle - the rectangle that would be used with the mutator
     *                  methods
     *
     * @return - a String variable with the result of the mutator method
     */
    public String printMutatorMethods(BetterRectangle rectangle)
    {
        String output = "\nMutator methods being executed for Rectangle D..."
                + "\nD: " + rectangle.toString()
                + "\n   Scale By 4? " + rectangle.scaleBy(4)
                + "\n   Scale By -4? " + rectangle.scaleBy(-4)
                + "\nD: " + rectangle.toString();

        return output;
    }

}