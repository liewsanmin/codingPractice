// ctci pg 344
// time - O(2^(r+c))
ArrayList<Point> getPath(boolean[][] maze){
    if(maze == null || maze.length == 0) return null;
    ArrayList<Point> path = new ArrayList<Point>();
    if(getPath(maze, maze.length - 1, maze[0].length - 1, path))
        return path;
    return null;
}

boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path){
    if(col < 0 || row < 0 || !maze[row][col])
        return false;
    boolean isAtOrigin = (row == 0) && (col == 0);

    if(isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row-1, col, path)){
        Point p = new Point(row, col);
        path.add(p);
        return true;
    }
    return false;
}


/*
optimized O(XY) by visiting cells only once
*/
ArrayList<Point> getPath(boolean[][] maze){
    if(maze == null || maze.length == 0) return null;

    ArrayList<Point> path = new ArrayList<Point>();
    HashMap<Point, Boolean> cache = new HashMap<Point, Boolean<>();
    int lastRow = maze.length - 1;
    int lastCol = maze[0].length - 1;
    if(getPath(maze, lastRow, lastCol, path, cache)){
        return path;
    }
    return null;
}

boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashMap<Point, Boolean> cache){
    if(col < 0 || row < 0 || !maze[row][col])
        return false;
    Point p = new Point(row, col);

    if(cache.containsKey(p))
        return cache.get(p);

    boolean isAtOrigin = (row == 0) && (col == 0);
    boolean success = false;

    if(isAtOrigin || getPath(maze, row, col-1, path, cache) || getPath(maze, row-1, col, path, cache)){
        path.add(p);
        success = true;
    }

    cache.put(p, success);
    return success;
}
