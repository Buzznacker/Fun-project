package re.badwa.funproject;

import lombok.Getter;
import re.badwa.funproject.action.Action;
import re.badwa.funproject.adapter.Adapter;
import re.badwa.funproject.adapter.impl.KeyAdapter;
import re.badwa.funproject.dot.impl.BasicDot;
import re.badwa.funproject.dot.Dot;
import re.badwa.funproject.location.Location;
import re.badwa.funproject.ui.FunPanel;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Main {

    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 800;

    private final Set<Adapter> adapters = new HashSet<>();

    @Getter
    private final Queue<Action> actions = new PriorityQueue<>();

    @Getter
    private Dot dot;

    @Getter
    private FunPanel funPanel;

    private Main() {
        startProgram();
    }

    public static void main(String[] args) {
        new Main();
    }

    private void startProgram() {
        KeyAdapter keyAdapter = new KeyAdapter();
        adapters.add(keyAdapter);
        dot = new BasicDot(new Location(25, 20));
        funPanel = new FunPanel(this, keyAdapter);
        createFrame();
        startLoop();
    }

    private void createFrame() {
        JFrame frame = new JFrame("Fun Project");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(funPanel);
        frame.setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void startLoop() {
        while (true) {
            try {
                Thread.sleep(8);
                actions.forEach(action -> action.onTick(this));
                actions.clear();
                adapters.forEach(adapter -> adapter.onTick(this));
                funPanel.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
