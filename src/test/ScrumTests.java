package test;

import controller.Controller;
import controller.ControllerEditNameListDialog;
import controller.ControllerTaskList;
import core.ScrumTask;
import core.ScrumTasksList;
import javafx.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ScrumTests {

    @org.junit.jupiter.api.Test
    void addNew() {
        ControllerTaskList controllerTaskList = new ControllerTaskList("New list");

        controllerTaskList.addTaskFromStr("New task", "01.10.2002");
        controllerTaskList.addTaskFromStr("asdfg", "");
        controllerTaskList.addTaskFromStr("", "11.03.2293");
        controllerTaskList.addTaskFromStr("   ", "17.11.2022");
        controllerTaskList.addTaskFromStr("N", "11.11.1111");
        controllerTaskList.addTaskFromStr("123", "");
        controllerTaskList.addTaskFromStr("321", "11.03.2293");
        controllerTaskList.addTaskFromStr("task", "07.07.2007");

        assertEquals(Arrays.asList(new ScrumTask("New task", "01.10.2002"),
                new ScrumTask("asdfg", ""), new ScrumTask("", "11.03.2293"),
                new ScrumTask("   ", "17.11.2022"),
                new ScrumTask("N", "11.11.1111"),
                new ScrumTask("123", ""),
                new ScrumTask("321", "11.03.2293"),
                new ScrumTask("task", "07.07.2007")), controllerTaskList.getNewList());


    }

    @org.junit.jupiter.api.Test
    void scrumTask() {
        ScrumTask scrumTask1 = new ScrumTask("New task", "01.10.2002");
        ScrumTask scrumTask2 = new ScrumTask("New task", "01.10.2002");

        assertTrue(scrumTask1.equals(scrumTask2));

        scrumTask1.setTaskDate("02.10.2000");
        scrumTask1.setTaskName("qwqw");

        assertFalse(scrumTask1.equals(scrumTask2));

        ScrumTasksList list = new ScrumTasksList();
        list.setName("name");

        assertEquals("name", list.getListName());

        list.add(scrumTask1);
        list.add(scrumTask2);

        assertEquals(Arrays.asList(new ScrumTask("qwqw", "02.10.2000"), new ScrumTask("New task", "01.10.2002")),
                list.getList());

        list.remove(0);

        assertEquals(Arrays.asList(new ScrumTask("New task", "01.10.2002")), list.getList());
    }
}