package org.example.task_3.Humans;

import lombok.Getter;
import lombok.Setter;
import org.example.task_3.Arms.Arm;
import org.example.task_3.Arms.LeftArm;
import org.example.task_3.Arms.RightArm;
import org.example.task_3.Heads.Head;
import org.example.task_3.Heads.LeftHead;
import org.example.task_3.Heads.RightHead;

@Setter
@Getter
public class DoubleHeaded extends Human{
    Head rightHead;
    Head leftHead;
    Arm leftArm;
    Arm rightArm;
    boolean isRightArmAction;
    boolean isLeftArmAction;
    boolean isRightHeadDiligent;
    boolean isLeftHeadSmile;
    int headCount;
    int armCount;

    public DoubleHeaded(String name) {
        super(name);
        rightHead = new RightHead();
        leftHead = new LeftHead();
        rightArm = new RightArm();
        leftArm = new LeftArm();
        isRightArmAction = false;
        isLeftArmAction = false;
        isRightHeadDiligent = false;
        isLeftHeadSmile = false;
        headCount = 2;
        armCount = 2;
    }

    public void leftTouches(){
        switch (leftArm.getAction()) {
            case TOUCHES -> isLeftArmAction = true;
            case GO, SIT, REST, NOTHING -> isLeftArmAction = false;
        }
    }

    public void rightNothing(){
        switch (rightArm.getAction()) {
            case NOTHING -> isRightArmAction = true;
            case GO, SIT, REST, TOUCHES -> isRightArmAction = false;
        }
    }

    public void leftHeadSmile(){
        switch (leftHead.getEmote()) {
            case SMILE -> isLeftHeadSmile = true;
            case NERVOUS, DILIGENT, JAW_HAPPENED, STUNNED -> isLeftHeadSmile = false;
        }
    }

    public void rightHeadDiligent(){
        switch (rightHead.getEmote()) {
            case DILIGENT -> isRightHeadDiligent = true;
            case NERVOUS, SMILE, JAW_HAPPENED, STUNNED -> isRightHeadDiligent = false;
        }
    }

    public int checkHeadCount(){
        if(this.headCount != 2){
            throw new RuntimeException("Может быть только 2 головы");
        }
        return headCount;
    }

    public int checkArmCount(){
        if(this.armCount != 2){
            throw new RuntimeException("Может быть только 2 руки");
        }
        return armCount;
    }
}
