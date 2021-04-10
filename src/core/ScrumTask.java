package core;

import java.time.LocalDate;
import java.util.Date;

public class ScrumTask {
    private String name;
    private String date;

    public ScrumTask(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return name + "  " + date;
    }
}
