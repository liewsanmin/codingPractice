/**
H-Tree Construction

Construct an H-tree, given its center (x and y coordinates), starting_length
and depth. You can assume that you have a drawLine method.

As a reminder, this is an example of an H-tree.

How to construct an H-tree?

An H-tree can be constructed by starting with a line segment of arbitrary
length, drawing two segments of the same length at right angles to the first
through its endpoints, and continuing in the same vein, reducing (dividing) the
 length of the line segments drawn at each stage by √2.


algo:
 We will start from the center point. Compute the coordinates of the 4 tips of
 the H. Then we shall draw the 3 line segments of the H, i.e. left and right
 vertical of the H, and the connection of the two vertical segments. We will
 update the length and recursively draw 4 half-size H-trees of order one less
 than the current depth.

 Runtime Complexity: Every call of drawHTree invokes 9 expressions of O(1) and
  4 calls of drawHTree until depth (denoted as D) reaches 0, therefore T(D) =
  9 + 4 * T(D-1), meaning T(D) = O(4^D), where T is the time complexity
  function and D is the depth of the H-Tree.

 Space Complexity: Recursive calls will add overhead since we store recursive
 calls in the execution stack. The space occupied in the stack will be O(D) in
  the worst case scenario. The stack space occupied will be no more than O(D)
  since a sibling drawHTree will not called before the current one being
  executed returns (i.e. finishes its execution).
*/

function drawLine(xOne, yOne, xTwo, yTwo):
// draws line, assume implementation available

function drawHTree(x, y, length, depth):

  if (depth == 0) return

  x0 = x - length/2
  x1 = x + length/2
  y0 = y - length/2
  y1 = y + length/2

  // draw the 3 line segments of the H-Tree
  drawLine(x0, y0, x0, y1)
  drawLine(x1, y0, x1, y1)
  drawLine(x0,  y, x1,  y)

  newLength = length/√2

  drawHTree(x0, y0, newLength, depth-1)	// lower left  H-tree
  drawHTree(x0, y1, newLength, depth-1)	// upper left  H-tree
  drawHTree(x1, y0, newLength, depth-1)	// lower right H-tree
  drawHTree(x1, y1, newLength, depth-1)	// upper right H-tree
