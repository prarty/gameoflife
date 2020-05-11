import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenerationTest {
    @Test
    void expectsNextGenerationOfBlockPattern() {
        List<Cell> aliveCellList = createCellsForBlock();
        Generation currentGeneration = new Generation(aliveCellList);

        List<Cell> aliveNextGeneration = currentGeneration.nextGeneration();

        assertEquals(4, aliveNextGeneration.size());
    }

    @Test
    void expectsNextGenerationOfOscillatorPattern() {
        List<Cell> aliveCellList = createCellsForOscillator();
        Generation currentGeneration = new Generation(aliveCellList);

        List<Cell> aliveNextGeneration = currentGeneration.nextGeneration();

        assertEquals(3, aliveNextGeneration.size());
    }

    @Test
    void expectsNextGenerationOfToadPattern() {
        List<Cell> aliveCellList = createCellsForToadPattern();
        Generation currentGeneration = new Generation(aliveCellList);

        List<Cell> aliveNextGeneration = currentGeneration.nextGeneration();

        assertEquals(6, aliveNextGeneration.size());
    }

    private List<Cell> createCellsForBlock() {
        return Arrays.asList(createCell(1, 1)
                , createCell(1, 2)
                , createCell(2, 1)
                , createCell(2, 2));
    }

    private List<Cell> createCellsForOscillator() {
        return Arrays.asList(createCell(1, 1)
                , createCell(1, 0)
                , createCell(1, 2));
    }

    private List<Cell> createCellsForToadPattern() {
        return Arrays.asList(createCell(1, 1)
                , createCell(1, 2)
                , createCell(1, 3)
                , createCell(2, 2)
                , createCell(2, 3)
                , createCell(2, 4));
    }

    private Cell createCell(int xCoordinate, int yCoordinate) {
        return new Cell(xCoordinate, yCoordinate);
    }
}
