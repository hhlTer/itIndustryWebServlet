package developerHomework5.model;

import java.util.HashMap;
import java.util.Map;

public class RepositoryTables {
    private static RepositoryTables INSTANCE = new RepositoryTables();

    public static RepositoryTables getINSTANCE() {
        return INSTANCE;
    }

    private Map<String, GenerallyTable> tableMap = new HashMap<>();

    private RepositoryTables(){
        register(new Project());
        register(new Developer());
        register(new Company());
        register(new Customer());
    }

    private void register(GenerallyTable gt) {
        tableMap.put(gt.getTableName(), gt);
    }

    public Map<String, GenerallyTable> getTableMap() {
        return tableMap;
    }
}
