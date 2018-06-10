package developerHomework5.controller.service;

import developerHomework5.model.GenerallyTable;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class TableService {
    Map<String, String> parameterMap = new HashMap<>();
    public void fillTable(GenerallyTable table, HttpServletRequest request){
        String[] fields;
        String[] parameters;
        fields = table.getPrm();
        parameters = new String[table.getPrm().length];
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = request.getParameter(fields[i]);
        }
        fillMap(fields, parameters);
        table.fillTable(parameterMap);
    }

    private void fillMap(String[] fields, String[] parameters) {
//        IntStream.range(0, fields.length)
//                .forEach(i -> parameterMap.put(fields[i], parameters[i]));
        for (int i = 0; i < fields.length; i++) {
            parameterMap.put(fields[i], parameters[i]);
        }
    }

}


