import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Represents an entity in 2 dimensional space
class Cell {
    private int xCoordinate;
    private int yCoordinate;

    Cell(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    List<Cell> neighbours() {
        List <Cell> neighbourList = new ArrayList<>();
        for(int x = -1; x < 2; x++) {
            for(int y = -1; y < 2; y++) {
                neighbourList.add(createCell(x, y));
            }
        }
        neighbourList.remove(new Cell(xCoordinate, yCoordinate));
        return neighbourList;
    }

    int xCoordinate() {
        return xCoordinate;
    }

    int yCoordinate() {
        return yCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Cell)) return false;
        Cell cell = (Cell) o;
        return xCoordinate == cell.xCoordinate &&
                yCoordinate == cell.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }

    private Cell createCell(int x, int y) {
        return new Cell(xCoordinate + x, yCoordinate + y);
    }
}
