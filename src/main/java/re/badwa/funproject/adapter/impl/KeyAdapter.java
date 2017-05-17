package re.badwa.funproject.adapter.impl;

import re.badwa.funproject.Main;
import re.badwa.funproject.action.actions.MoveDotAction;
import re.badwa.funproject.adapter.Adapter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Credits to Badware for making this keystroke system, cba to do it.
public class KeyAdapter implements KeyListener, Adapter {

    private int dUp = 0, dDown = 0, dLeft = 0, dRight = 0;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == Main.FORWARD_KEY) {
            dUp = -1; //up
        } else if (e.getKeyCode() == Main.LEFT_KEY) {
            dLeft = -1; //left
        } else if (e.getKeyCode() == Main.BACKWARD_KEY) {
            dDown = 1; //down
        } else if (e.getKeyCode() == Main.RIGHT_KEY) {
            dRight = 1; //right
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == Main.FORWARD_KEY) {
            dUp = 0; //up
        } else if (e.getKeyCode() == Main.LEFT_KEY) {
            dLeft = 0; //left
        } else if (e.getKeyCode() == Main.BACKWARD_KEY) {
            dDown = 0; //down
        } else if (e.getKeyCode() == Main.RIGHT_KEY) {
            dRight = 0; //right
        }
    }

    @Override
    public void onTick(Main main) {
        main.getActions().offer(
                new MoveDotAction(
                        main.getDot().getLocation().getX() + (dRight + dLeft),
                        main.getDot().getLocation().getY() + (dUp + dDown)));
    }
}
