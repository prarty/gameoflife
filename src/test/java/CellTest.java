import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CellTest {
    @Test
    void expectsCellToBeCreated() {
        Cell cell = new Cell(1, 1);

        Assertions.assertNotNull(cell);
    }

    @Test
    void expectsListOfNeighbour() {
        Cell cell = new Cell(1, 1);

        List<Cell> neighbourList = cell.neighbours();

        assertEquals(8, neighbourList.size());
    }
}
