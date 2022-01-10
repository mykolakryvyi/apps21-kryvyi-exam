package json;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    Map<String, Json> mp = new HashMap<>();

    public JsonObject(JsonPair... jsonPairs) {
        for (JsonPair jsonPair : jsonPairs) {
            mp.put(jsonPair.key, jsonPair.value);
        }
        // ToDo
    }

    @Override
    public String toJson() {
        StringBuilder result = new StringBuilder("{");
        int kk = 0;
        for (Map.Entry<String, Json> stringJsonEntry : mp.entrySet()) {
            result.append("\"").append(stringJsonEntry.getKey()).append("\":").append(stringJsonEntry.getValue().toJson());
            if(kk != mp.size() - 1){
                result.append(",");
            }
            kk++;
        }
        result.append("}");
        return result.toString();
    }

    public void add(JsonPair jsonPair) {
        mp.put(jsonPair.key, jsonPair.value);
    }

    public Json find(String name) {
        return mp.get(name);
    }

    public JsonObject projection(String... names) {
        JsonObject result = new JsonObject();
        for (Map.Entry<String, Json> stringJsonEntry : mp.entrySet()) {
            for (String name : names) {
                if(name.equals(stringJsonEntry.getKey())){
                    result.add(new JsonPair(stringJsonEntry.getKey(), stringJsonEntry.getValue()));
                }
            }
        }
        return result;
    }
}
