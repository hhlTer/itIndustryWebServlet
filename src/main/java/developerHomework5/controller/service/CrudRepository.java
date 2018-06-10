package developerHomework5.controller.service;

import developerHomework5.controller.factory.CrudDaoFactory;
import developerHomework5.model.GenerallyTable;

import java.util.HashMap;
import java.util.Map;

public class CrudRepository {
    private Map<Class<? extends Object>, CrudDaoFactory> cache = new HashMap<>();

    public <T, K> CrudDaoFactory getCrudDaoFactory(Class<T> clazz){
        if (cache.containsKey(clazz)){
            return cache.get(clazz);
        }

        CrudDaoFactory<T, K> result = new CrudDaoFactory(clazz);
        cache.put(clazz, result);
        return result;
    }
}
