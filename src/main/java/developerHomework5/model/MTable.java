package developerHomework5.model;

import java.util.HashMap;
import java.util.Map;

abstract class MTable implements GenerallyTable{
    @Override
    public Map<String, String> getCortege() {
        Map<String, String> result = new HashMap<>();
        String[] field = getPrm();
        String[] data = getAll();
        for (int i = 0; i < field.length; i++) {
            result.put(field[i], data[i]);
        }
        return result;
    }
}