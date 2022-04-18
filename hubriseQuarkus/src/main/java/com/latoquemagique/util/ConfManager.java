package com.latoquemagique.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hubriseModel.AuthResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import org.jboss.logging.Logger;

import javax.inject.Inject;

public class ConfManager {

    @Inject
    static Logger log;

    public static final String CONF_FILE = "config.json";
    private static FileWriter file;
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static JSONParser jSONParser = new JSONParser();
    public static void setMappingConfig(String keylocation, AuthResponse authResp)
            throws JsonProcessingException, ParseException {
        JSONObject conf = getJsonConf();
        String authRespAsString = objectMapper.writeValueAsString(authResp);
        JSONObject inside = (JSONObject) jSONParser.parse(authRespAsString);
        conf.put(keylocation, inside);
        try {
            file = new FileWriter(CONF_FILE);
            file.write(conf.toJSONString());
        } catch (IOException e) {
            log.error("Unable to write conf file", e);
        } finally {
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                log.error("Unable to write conf file", e);
            }
        }
    }

    private static JSONObject getJsonConf() {
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(CONF_FILE)) {
            return (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            log.error("Unable to read conf file", e);
        }
        return null;
    }

    public static String getAuthTokenByKeyLocation(String keylocation) {
        JSONObject globalConf = getJsonConf();
        JSONObject conf = (JSONObject) globalConf.get(keylocation);
        return (String) conf.get("access_token");
    }
}
