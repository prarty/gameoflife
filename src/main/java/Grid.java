import java.util.ArrayList;
import java.util.List;

//Represents an entity to store status of live and dead coordinates in 2 Dimension
class Grid {
    private List<Cell> aliveCellList;
    private List<Cell> deadCells;

    Grid(List<Cell> aliveCellList) {
        this.aliveCellList = aliveCellList;
        deadCells = new ArrayList<>();
    }

    int aliveNeighbour(Cell aliveCell) {
        int activeNeighbour = 0;
        List<Cell> cellNeighbourList = aliveCell.neighbours();
        updateDeadCells(cellNeighbourList);
        for(Cell cell : cellNeighbourList) {
            if(aliveCellList.contains(cell)) {
                activeNeighbour++;
            }
        }
        return activeNeighbour;
    }

    List<Cell> deadCellList() {
        return deadCells;
    }

    private void updateDeadCells(List<Cell> cellNeighbourList) {
        deadCells.addAll(cellNeighbourList);
    }
}