package core;

import controller.ControllerTaskList;

import java.util.ArrayList;

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
}
