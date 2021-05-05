package core;

import controller.ControllerTaskList;

import java.util.ArrayList;
import java.util.Objects;

public class ScrumBoard {
    private ArrayList<ScrumTasksList> board = new ArrayList<ScrumTasksList>();

    public ArrayList<ScrumTasksList> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ScrumTasksList> board) {
        this.board = board;
    }

    public void add(ScrumTasksList tasksList) {
        board.add(tasksList);
    }

    public void remove(ScrumTasksList tasksList) {
        board.remove(tasksList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrumBoard that = (ScrumBoard) o;
        return Objects.equals(getBoard(), that.getBoard());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBoard());
    }
}
