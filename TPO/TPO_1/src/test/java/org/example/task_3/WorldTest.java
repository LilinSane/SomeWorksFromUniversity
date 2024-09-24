package org.example.task_3;

import org.example.task_3.Actions.Action;
import org.example.task_3.Emotes.Emote;
import org.example.task_3.Humans.Artur;
import org.example.task_3.Humans.DoubleHeaded;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTest {
    private Artur artur;
    private DoubleHeaded doubleHeaded;

    @BeforeEach
    void init() {
        artur = new Artur("Артур");
        doubleHeaded = new DoubleHeaded("Двухголовый");
    }

    //Artur tests
    @Test
    public void sawTest(){
        assertAll(
                () -> assertFalse(artur.isSaw()),
                () -> {
                    artur.getHead().setEmote(Emote.DILIGENT);
                    artur.saw();
                    assertTrue(artur.isSaw());
                },
                () -> {
                    artur.getHead().setEmote(Emote.JAW_HAPPENED);
                    artur.saw();
                    assertTrue(artur.isSaw());
                },
                () -> {
                    artur.getHead().setEmote(Emote.STUNNED);
                    artur.saw();
                    assertTrue(artur.isSaw());
                },
                () -> {
                    artur.getHead().setEmote(Emote.NERVOUS);
                    artur.saw();
                    assertFalse(artur.isSaw());
                },
                () -> {
                    artur.getHead().setEmote(Emote.SMILE);
                    artur.saw();
                    assertFalse(artur.isSaw());
                }
        );
    }

    @Test
    public void sawMoreStrangeThing(){
        assertAll(
                () -> assertFalse(artur.isSawMoreStrangeThings()),
                () -> {
                    artur.getHead().setEmote(Emote.DILIGENT);
                    artur.sawMoreStrangeThings();
                    assertFalse(artur.isSawMoreStrangeThings());
                },
                () -> {
                    artur.getHead().setEmote(Emote.JAW_HAPPENED);
                    artur.sawMoreStrangeThings();
                    assertTrue(artur.isSawMoreStrangeThings());
                },
                () -> {
                    artur.getHead().setEmote(Emote.STUNNED);
                    artur.sawMoreStrangeThings();
                    assertFalse(artur.isSawMoreStrangeThings());
                },
                () -> {
                    artur.getHead().setEmote(Emote.NERVOUS);
                    artur.sawMoreStrangeThings();
                    assertFalse(artur.isSawMoreStrangeThings());
                },
                () -> {
                    artur.getHead().setEmote(Emote.SMILE);
                    artur.sawMoreStrangeThings();
                    assertFalse(artur.isSawMoreStrangeThings());
                }
        );
    }

    //DoubleHeaded tests
    @Test
    public void leftTouches(){
        assertAll(
                () -> assertFalse(doubleHeaded.isLeftArmAction()),
                () -> {
                    doubleHeaded.getLeftArm().setAction(Action.GO);
                    doubleHeaded.leftTouches();
                    assertFalse(doubleHeaded.isLeftArmAction());
                },
                () -> {
                    doubleHeaded.getLeftArm().setAction(Action.SIT);
                    doubleHeaded.leftTouches();
                    assertFalse(doubleHeaded.isLeftArmAction());
                },
                () -> {
                    doubleHeaded.getLeftArm().setAction(Action.REST);
                    doubleHeaded.leftTouches();
                    assertFalse(doubleHeaded.isLeftArmAction());
                },
                () -> {
                    doubleHeaded.getLeftArm().setAction(Action.NOTHING);
                    doubleHeaded.leftTouches();
                    assertFalse(doubleHeaded.isLeftArmAction());
                },
                () -> {
                    doubleHeaded.getLeftArm().setAction(Action.TOUCHES);
                    doubleHeaded.leftTouches();
                    assertTrue(doubleHeaded.isLeftArmAction());
                }
        );
    }

    @Test
    public void rightNothing(){
        assertAll(
                () -> assertFalse(doubleHeaded.isRightArmAction()),
                () -> {
                    doubleHeaded.getRightArm().setAction(Action.GO);
                    doubleHeaded.rightNothing();
                    assertFalse(doubleHeaded.isRightArmAction());
                },
                () -> {
                    doubleHeaded.getRightArm().setAction(Action.SIT);
                    doubleHeaded.rightNothing();
                    assertFalse(doubleHeaded.isRightArmAction());
                },
                () -> {
                    doubleHeaded.getRightArm().setAction(Action.REST);
                    doubleHeaded.rightNothing();
                    assertFalse(doubleHeaded.isRightArmAction());
                },
                () -> {
                    doubleHeaded.getRightArm().setAction(Action.NOTHING);
                    doubleHeaded.rightNothing();
                    assertTrue(doubleHeaded.isRightArmAction());
                },
                () -> {
                    doubleHeaded.getRightArm().setAction(Action.TOUCHES);
                    doubleHeaded.rightNothing();
                    assertFalse(doubleHeaded.isRightArmAction());
                }
        );
    }

    @Test
    public void leftHeadSmile(){
        assertAll(
                () -> assertFalse(doubleHeaded.isLeftHeadSmile()),
                () -> {
                    doubleHeaded.getLeftHead().setEmote(Emote.NERVOUS);
                    doubleHeaded.leftHeadSmile();
                    assertFalse(doubleHeaded.isLeftHeadSmile());
                },
                () -> {
                    doubleHeaded.getLeftHead().setEmote(Emote.STUNNED);
                    doubleHeaded.leftHeadSmile();
                    assertFalse(doubleHeaded.isLeftHeadSmile());
                },
                () -> {
                    doubleHeaded.getLeftHead().setEmote(Emote.DILIGENT);
                    doubleHeaded.leftHeadSmile();
                    assertFalse(doubleHeaded.isLeftHeadSmile());
                },
                () -> {
                    doubleHeaded.getLeftHead().setEmote(Emote.JAW_HAPPENED);
                    doubleHeaded.leftHeadSmile();
                    assertFalse(doubleHeaded.isLeftHeadSmile());
                },
                () -> {
                    doubleHeaded.getLeftHead().setEmote(Emote.SMILE);
                    doubleHeaded.leftHeadSmile();
                    assertTrue(doubleHeaded.isLeftHeadSmile());
                }
        );
    }

    @Test
    public void rightHeadDiligent(){
        assertAll(
                () -> assertFalse(doubleHeaded.isLeftHeadSmile()),
                () -> {
                    doubleHeaded.getRightHead().setEmote(Emote.NERVOUS);
                    doubleHeaded.rightHeadDiligent();
                    assertFalse(doubleHeaded.isRightHeadDiligent());
                },
                () -> {
                    doubleHeaded.getRightHead().setEmote(Emote.STUNNED);
                    doubleHeaded.rightHeadDiligent();
                    assertFalse(doubleHeaded.isRightHeadDiligent());
                },
                () -> {
                    doubleHeaded.getRightHead().setEmote(Emote.DILIGENT);
                    doubleHeaded.rightHeadDiligent();
                    assertTrue(doubleHeaded.isRightHeadDiligent());
                },
                () -> {
                    doubleHeaded.getRightHead().setEmote(Emote.JAW_HAPPENED);
                    doubleHeaded.rightHeadDiligent();
                    assertFalse(doubleHeaded.isRightHeadDiligent());
                },
                () -> {
                    doubleHeaded.getRightHead().setEmote(Emote.SMILE);
                    doubleHeaded.rightHeadDiligent();
                    assertFalse(doubleHeaded.isRightHeadDiligent());
                }
        );
    }

    @Test
    void headsCount(){
        assertAll(
                () -> assertEquals(2, doubleHeaded.checkHeadCount()),
                () -> {
                    doubleHeaded.setHeadCount(3);
                    assertThrows(RuntimeException.class, () -> doubleHeaded.checkHeadCount());
                },
                () -> {
                    doubleHeaded.setHeadCount(1);
                    assertThrows(RuntimeException.class, () -> doubleHeaded.checkHeadCount());
                },
                () -> {
                    doubleHeaded.setHeadCount(2);
                    assertEquals(2, doubleHeaded.checkHeadCount());
                }
        );
    }

    @Test
    void armsCount(){
        assertAll(
                () -> assertEquals(2, doubleHeaded.checkArmCount()),
                () -> {
                    doubleHeaded.setArmCount(3);
                    assertThrows(RuntimeException.class, () -> doubleHeaded.checkArmCount());
                },
                () -> {
                    doubleHeaded.setArmCount(1);
                    assertThrows(RuntimeException.class, () -> doubleHeaded.checkArmCount());
                },
                () -> {
                    doubleHeaded.setArmCount(2);
                    assertEquals(2, doubleHeaded.checkArmCount());
                }
        );
    }

}
