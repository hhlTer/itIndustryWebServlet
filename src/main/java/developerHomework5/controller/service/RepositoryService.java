package developerHomework5.controller.service;

import java.util.HashMap;
import java.util.Map;

public class RepositoryService {
    private static final RepositoryService INSTANCE = new RepositoryService();
    public static RepositoryService getINSTANCE() {
        return INSTANCE;
    }

    private Map<Class, Object> repositoryMap = new HashMap<>();

    private RepositoryService(){
        register(new HibernateSessionCreater());
//        register(new TableService());
        register(new CrudRepository());
    }

    public <T> T getService(Class<T> clazz){
        return (T) repositoryMap.get(clazz);
    }
    private void register(Object o){
        repositoryMap.put(o.getClass(), o);
    }
}
