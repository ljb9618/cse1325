public class line {
    private double x1;

    private double y1;

    private double x2;

    private double y2;

    private Color c;

    line(double x1, double y1, double x2, double y2, Color c) {
        this.x1 = x1;

        this.y1 = y1;

        this.x2 = x2;

        this.y2 = y2;

        this.c = c;
    }

    double length() {
        double lengthOfx = x2-x1;

        double lengthOfy = y2-y1;

        double length = Math.sqrt(Math.pow(lengthOfx,2) + Math.pow(lengthOfy,2));

        return length;
    }

    public String toString() {
        String LineInfo = "";

        LineInfo = c + " (" + x1 + "," + y1 + ")-(" + x2 + "," + y2 + ") ";

        return LineInfo;
    }
}