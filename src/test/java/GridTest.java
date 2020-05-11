import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GridTest {
    @Test
    void expectsNumberOfLiveNeighbours() {
        List<Cell> aliveCellList = AliveCells();
        Grid grid = new Grid(aliveCellList);

        int liveNeighbour = grid.aliveNeighbour(createCell(1, 1));

        assertEquals(3, liveNeighbour);
    }

    private List<Cell> AliveCells() {
        return Arrays.asList(createCell(1, 1)
                , createCell(1, 2)
                , createCell(2, 1)
                , createCell(2, 2));
    }

    private Cell createCell(int xCoordinate, int yCoordinate) {
        return new Cell(xCoordinate, yCoordinate);
    }
}
