//Write a function to find the rectangular intersection of two given love rectangles.
////////////////////////////////////////////////////////////////////////////////
// definitions on other classes
public class Rectangle {

  // coordinates of bottom left corner
  Integer leftX;
  Integer bottomY;

  // dimensions
  Integer width;
  Integer height;

  public Rectangle(Integer leftX, Integer bottomY, Integer width, Integer height) {
      this.leftX = leftX;
      this.bottomY = bottomY;
      this.width  = width;
      this.height = height;
  }

  public Rectangle() {}

  public String toString() {
      return String.format("(%d, %d, %d, %d)", leftX, bottomY, width, height);
  }
}

public class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(){}

    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
////////////////////////////////////////////////////////////////////////////////

// MY VERSION
public class findRectOverlap{
    public static Rectangle findIntersection(Rectangle rect1, Rectangle rect2){
        int x1Start = rect1.leftX;
        int x1End = rect1.leftX + rect1.width;
        int y1Start = rect1.bottomY;
        int y1End = rect1.bottomY - rect1.height;

        int x2Start = rect2.leftX;
        int x2End = rect2.leftX + rect2.width;
        int y2Start = rect2.bottomY;
        int y2End = rect2.bottomY - rect2.height;

        int highestStartX = Math.max(x1Start, x2Start);
        int highestStartY = Math.min(y1Start, y2Start);

        int lowestEndX = Math.min(x1End, x2End);
        int lowestEndY = Math.max(y1End, y2End);

        Point highestStartPoint = new Point(highestStartX, highestStartY);
        Point lowestEndPoint = new Point(lowestEndX, lowestEndY);

        System.out.println("highestStartPoint: " + highestStartPoint.toString());
        System.out.println("lowestEndPoint: " + lowestEndPoint.toString());

        if(highestStartPoint.x >= lowestEndPoint.x ||
           highestStartPoint.y <= lowestEndPoint.y){
               return new Rectangle(null, null, null, null);
           }

        int overlapWidth = lowestEndPoint.x - highestStartPoint.x;
        int overlapHeight = highestStartPoint.y - lowestEndPoint.y;

        return new Rectangle(highestStartPoint.x, highestStartPoint.y, overlapWidth, overlapHeight);
    }

    public static void main(String[] args){
        Rectangle rect1 = new Rectangle(1, 4, 3, 3);
        Rectangle rect2 = new Rectangle(2, 3, 2, 1);

        Rectangle ans = findIntersection(rect1, rect2);
        System.out.println(ans.toString());
    }
}

// MORE READABLE
public class RangeOverlap {

  Integer startPoint;
  Integer length;

  public RangeOverlap(Integer startPoint, Integer length) {
      this.startPoint = startPoint;
      this.length = length;
  }
}

public RangeOverlap findRangeOverlap(int point1, int length1, int point2, int length2) {

  // find the highest start point and lowest end point.
  // the highest ("rightmost" or "upmost") start point is
  // the start point of the overlap.
  // the lowest end point is the end point of the overlap.
  int highestStartPoint = Math.max(point1, point2);
  int lowestEndPoint = Math.min(point1 + length1, point2 + length2);

  // return null overlap if there is no overlap
  if (highestStartPoint >= lowestEndPoint) {
      return new RangeOverlap(null, null);
  }

  // compute the overlap length
  int overlapLength = lowestEndPoint - highestStartPoint;

  return new RangeOverlap(highestStartPoint, overlapLength);
}

public Rectangle findRectangularOverlap(Rectangle rect1, Rectangle rect2) {

  // get the x and y overlap points and lengths
  RangeOverlap xOverlap = findRangeOverlap(rect1.leftX, rect1.width, rect2.leftX, rect2.width);
  RangeOverlap yOverlap = findRangeOverlap(rect1.bottomY, rect1.height, rect2.bottomY, rect2.height);

  // return null rectangle if there is no overlap
  if (xOverlap.length == null || yOverlap.length == null) {
      return new Rectangle();
  }

  return new Rectangle(
      xOverlap.startPoint,
      yOverlap.startPoint,
      xOverlap.length,
      yOverlap.length
  );
}
