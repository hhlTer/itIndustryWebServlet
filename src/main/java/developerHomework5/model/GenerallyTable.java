package developerHomework5.model;

import java.util.HashMap;
import java.util.Map;

public interface GenerallyTable {
    Map<String, String> fields = new HashMap<>();
    Map<String, String> getCortege();

    String[] getPrm();
    String getTableName();

    void fillTable(Map<String, String> map);
}
