import java.util.Arrays;
import java.util.List;

public class GameOfLife {
    public static void main(String[] args) {
        List<Cell> aliveCellList = Arrays.asList(createCell(1, 1)
                , createCell(1, 2)
                , createCell(1, 3)
                , createCell(2, 2)
                , createCell(2, 3)
                , createCell(2, 4));
        Generation currentGeneration = new Generation(aliveCellList);

        currentGeneration.nextGeneration();
    }

    private static Cell createCell(int xCoordinate, int yCoordinate) {
        return new Cell(xCoordinate, yCoordinate);
    }
}
