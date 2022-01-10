package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {

    private final Boolean value;

    public JsonBoolean(Boolean bool) {
        value = bool;
    }

    @Override
    public String toJson() {
        // ToDo
        return value.toString();
    }
}
