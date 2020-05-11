import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Represents an entity to find next generation of a cell based on convey game of life rules
class Generation {
    private List<Cell> aliveCellList;
    private List<Cell> nextGeneration;
    private Grid grid;

    Generation(List<Cell> aliveCellList) {
        this.aliveCellList = aliveCellList;
        this.nextGeneration = new ArrayList<>();
        this.grid = new Grid(aliveCellList);
    }

    List<Cell> nextGeneration() {
        aliveCellList.forEach(this::activeCellNextGeneration);
        List<Cell> deadCells = grid.deadCellList()
                                   .stream()
                                   .distinct()
                                   .collect(Collectors.toList());
        deadCells.forEach(this::deadCellNextGeneration);
        displayNextGeneration();
        return nextGeneration;
    }

    private void displayNextGeneration() {
        nextGeneration = nextGeneration.stream().distinct().collect(Collectors.toList());
        nextGeneration.forEach(cell -> System.out.println("("
                + cell.xCoordinate() + " , "
                + cell.yCoordinate() + ")"));
    }

    private void deadCellNextGeneration(Cell deadCell) {
        int aliveNeighbourCount = grid.aliveNeighbour(deadCell);
        if(aliveNeighbourCount == 3) {
            nextGeneration.add(deadCell);
        }
    }

    private void activeCellNextGeneration(Cell aliveCell) {
        int aliveNeighbourCount = grid.aliveNeighbour(aliveCell);
        if(aliveNeighbourCount == 2 || aliveNeighbourCount == 3) {
            nextGeneration.add(aliveCell);
        }
    }
}