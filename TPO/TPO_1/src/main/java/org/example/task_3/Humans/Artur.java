package org.example.task_3.Humans;

import lombok.Getter;
import lombok.Setter;
import org.example.task_3.Heads.Head;

@Getter
@Setter
public class Artur extends Human{
    Head head;
    boolean isSaw;
    boolean isSawMoreStrangeThings;

    public Artur(String name) {
        super(name);
        head = new Head();
        isSaw = false;
        isSawMoreStrangeThings = false;
    }

    public void saw(){
        switch (head.getEmote()) {
            case DILIGENT, JAW_HAPPENED, STUNNED -> isSaw = true;
            case NERVOUS, SMILE -> isSaw = false;
        }
    }

    public void sawMoreStrangeThings(){
        switch (head.getEmote()) {
            case JAW_HAPPENED -> isSawMoreStrangeThings = true;
            case NERVOUS, SMILE, DILIGENT, STUNNED -> isSawMoreStrangeThings = false;
        }
    }

}
