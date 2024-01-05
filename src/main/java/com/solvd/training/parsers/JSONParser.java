package com.solvd.training.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.training.model.Client;
import com.solvd.training.model.Employee;
import com.solvd.training.model.Project;
import com.solvd.training.model.Task;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static com.solvd.training.utils.LoggerUtil.log;

public class JSONParser {

    private final String jsonPath;

    public JSONParser(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public void parseJSON() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream inputStream = new FileInputStream(jsonPath)) {
            Map<String, Object> companyData = mapper.readValue(inputStream, Map.class);
            parseNestedObjects(companyData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseNestedObjects(Map<String, Object> data) {
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            Object value = entry.getValue();
            System.out.println(value);
        }
    }
}
