package re.badwa.funproject.action.actions;

import lombok.RequiredArgsConstructor;
import re.badwa.funproject.Main;
import re.badwa.funproject.action.Action;
import re.badwa.funproject.location.Location;

@RequiredArgsConstructor
public class MoveDotAction implements Action {

    private final int x;
    private final int y;

    @Override
    public void onTick(Main main) {
        main.getDot().setLocation(new Location(x, y));
    }
}
