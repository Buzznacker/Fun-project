package re.badwa.funproject.adapter.impl;

import re.badwa.funproject.Main;
import re.badwa.funproject.action.actions.MoveDotAction;
import re.badwa.funproject.adapter.Adapter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class KeyAdapter implements KeyListener, Adapter {

    private final Set<Integer> characters = new HashSet<>();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        this.characters.add(e.getKeyCode());
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        this.characters.remove(e.getKeyCode());
    }

    @Override
    public void onTick(Main main) {
        // Credits to Badware for this fuck fest of keystrokes code.
        if ((characters.contains(38) && characters.contains(39)) || (characters.contains(87) && characters.contains(68))) {
            main.getActions().offer(
                    new MoveDotAction(
                            main.getDot().getLocation().getX() + 1,
                            main.getDot().getLocation().getY() - 1));
        } else if ((characters.contains(40) && characters.contains(39)) || (characters.contains(83) && characters.contains(68))) {
            main.getActions().offer(
                    new MoveDotAction(
                            main.getDot().getLocation().getX() + 1,
                            main.getDot().getLocation().getY() + 1));
        } else if ((characters.contains(40) && characters.contains(37)) || (characters.contains(83) && characters.contains(65))) {
            main.getActions().offer(
                    new MoveDotAction(
                            main.getDot().getLocation().getX() - 1,
                            main.getDot().getLocation().getY() + 1));
        } else if ((characters.contains(38) && characters.contains(37)) || (characters.contains(87) && characters.contains(65))) {
            main.getActions().offer(
                    new MoveDotAction(
                            main.getDot().getLocation().getX() - 1,
                            main.getDot().getLocation().getY() - 1));
        } else if (characters.contains(38) || characters.contains(87)) {
            main.getActions().offer(
                    new MoveDotAction(
                            main.getDot().getLocation().getX(),
                            main.getDot().getLocation().getY() - 1));
        } else if (characters.contains(40) || characters.contains(83)) {
            main.getActions().offer(
                    new MoveDotAction(
                            main.getDot().getLocation().getX(),
                            main.getDot().getLocation().getY() + 1));
        } else if (characters.contains(37) || characters.contains(65)) {
            main.getActions().offer(
                    new MoveDotAction(
                            main.getDot().getLocation().getX() - 1,
                            main.getDot().getLocation().getY()));
        } else if (characters.contains(39) || characters.contains(68)) {
            main.getActions().offer(
                    new MoveDotAction(
                            main.getDot().getLocation().getX() + 1,
                            main.getDot().getLocation().getY()));
        }
    }
}
