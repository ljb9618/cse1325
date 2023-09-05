public class TestLine {
    public static void main(String[] args) {
        line line1 = new line(9, 8, 7, 6, Color.ORANGE);

        line line2 = new line(5, 4, 3, 2, Color.BLACK);

        line line3 = new line(1, 1.453, 7.423, 6.342, Color.BROWN);

        line line4 = new line(5.234, 8.543, 12.934, 3.124, Color.GREY);


        System.out.println(line1.toString() + "has length " + line1.length());

        System.out.println(line2.toString() + "has length " + line2.length());

        System.out.println(line3.toString() + "has length " + line3.length());

        System.out.println(line4.toString() + "has length " + line4.length());
    }
}
