package glacialExpedition.models.states;

import java.util.ArrayList;
import java.util.Collection;

import static glacialExpedition.common.ExceptionMessages.STATE_NAME_NULL_OR_EMPTY;

public class StateImpl implements State {
    private static String name;
    private static Collection<String> exhibits;

    public StateImpl(String name) {
        setName(name);
        exhibits = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<String> getExhibits() {
        return exhibits;
    }

    public static void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(STATE_NAME_NULL_OR_EMPTY);
        }
        StateImpl.name = name;
    }

    public static void setExhibits(Collection<String> exhibits) {
        StateImpl.exhibits = exhibits;
    }
}
