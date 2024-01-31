public class MineEscape {
    private Map map;
    private int numGold;
    private int[] numKeys;


    public MineEscape(String filename) {
        try {
            map = new Map(filename);
            numGold = 0;
            numKeys = new int[3];
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private MapCell findNextCell(MapCell cell) {
        final int cellNumNeighbors = 4;
        MapCell  withItem = null, next = null , locked = null;
        // Rule 1: If curr is adjacent to the exit cell, go to the exit cell
        for (int i = 0; i < cellNumNeighbors; i++) {
            MapCell neighbour = cell.getNeighbour(i);
            if (neighbour != null && !neighbour.isWall() && !neighbour.isLava() && !neighbour.isMarked()) {
                if (!neighbour.isLockCell()) {
                    if (neighbour.isExit()) {
                        return neighbour;
                    }else if( (neighbour.isGoldCell() || neighbour.isKeyCell()) &&  withItem == null){
                        withItem = neighbour;
                    }else if (neighbour.isFloor() &&  next == null){
                        next = neighbour;
                    }
                }else  {
                    if (numKeys[getKeyIndex(neighbour)] > 0 && locked == null) {
                        locked = neighbour;
                    }
                }
            }
        }

        MapCell[] neighbours = {withItem, next, locked};
        for (MapCell cell1: neighbours) {
            if (cell1 != null) {
                return cell1;
            }
        }
        return null;
    }

    private int getKeyIndex(MapCell lockedDoor) {
        if (lockedDoor.isRed()) {
            return 0;
        } else if (lockedDoor.isGreen()) {
            return 1;
        } else if (lockedDoor.isBlue()) {
            return 2;
        }
        return -1; // Should not happen if the input is a locked door cell
    }


    public String findEscapePath() {
        ArrayStack<MapCell> stack = new ArrayStack<>();
        MapCell startCell = map.getStart();
        stack.push(startCell);
        startCell.markInStack();

        boolean running = true;

        StringBuilder pathBuilder = new StringBuilder("Path: ");
        pathBuilder.append(startCell.getID()).append(" ");
        while (!stack.isEmpty() && running) {
            MapCell curr = stack.peek();

            if (curr.isExit()) {
                running = false; // exit the loop immediately
                break;
            }

            if (curr.isKeyCell()) {
                // Determine the color of the key and update numKeys accordingly
                if (curr.isRed()) {
                    numKeys[0]++;
                } else if (curr.isGreen()) {
                    numKeys[1]++;
                } else if (curr.isBlue()) {
                    numKeys[2]++;
                }

                // Pick up the key and change the cell to a floor cell
                curr.changeToFloor();
            }

            if (curr.isGoldCell()) {
                // Update numGold accordingly and pick up the gold
                numGold++;
                curr.changeToFloor();
            }

            if (curr.isLava()) {
                // Reset numGold to 0 if adjacent to lava
                numGold = 0;
            }

            MapCell next = findNextCell(curr);

            if (next == null) {
                curr.markOutStack();
                stack.pop();
            } else {
                // Update path string
                pathBuilder.append(next.getID()).append(" ");
                // Push next onto stack
                stack.push(next);
                next.markInStack();

                if (next.isLockCell()) {
                    // Determine color of the locked door
                    if (next.isRed()) {
                        // Unlock the door and update numKeys accordingly
                        numKeys[0]--;
                        next.changeToFloor();
                    } else if (next.isGreen()) {
                        numKeys[1]--;
                        next.changeToFloor();
                    } else if (next.isBlue()) {
                        numKeys[2]--;
                        next.changeToFloor();
                    }
                }
            }
        }

        if (!running) {
            // Construct and return the path string
            return pathBuilder.append(numGold).append("G").toString();
        } else {
            return "No solution found";
        }
    }

}
