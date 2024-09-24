package org.example.task_3.Humans;

import lombok.Getter;
import lombok.Setter;
import org.example.task_3.Actions.Action;

public abstract class Human {
    String name;
    @Getter
    @Setter
    Action action;

    public Human(String name) {
        this.name = name;
    }
}
