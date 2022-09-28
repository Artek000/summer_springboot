package com.springboot.springbootrestservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.springboot.springbootrestservice.model.Tovar;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TovarServiceImpl implements TovarService {

    private static final File DATA_FILE = new File("data.yaml");

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));

    private static final Map<Integer, Tovar> TOVAR_REPOSITORY_MAP = new HashMap<>();
    private static final AtomicInteger TOVAR_ID_HOLDER = new AtomicInteger();

    @PostConstruct
    @SneakyThrows
    public void init() {
        DATA_FILE.createNewFile();
    }

    @Override
    public void create(Tovar tovar) {
        int tovarId = TOVAR_ID_HOLDER.incrementAndGet();
        tovar.setId(tovarId);
        TOVAR_REPOSITORY_MAP.put(tovarId, tovar);
    }

    @Override
    @SneakyThrows
    public List<Tovar> readAll() {
        return Arrays.asList(OBJECT_MAPPER.readValue(DATA_FILE, Tovar[].class));
    }

    @Override
    public Tovar read(int id) {
        return TOVAR_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Tovar tovar, int id) {
        if (TOVAR_REPOSITORY_MAP.containsKey(id)) {
            tovar.setId(id);
            TOVAR_REPOSITORY_MAP.put(id, tovar);
            return true;
        }

        return false;
    }
    @Override
    public boolean delete(int id) {
        return TOVAR_REPOSITORY_MAP.remove(id) != null;
    }

    @Override
    public int about(){
        return TOVAR_REPOSITORY_MAP.size();
    }

    @Override
    @SneakyThrows
    public void save_tovars() {
        OBJECT_MAPPER.writeValue(DATA_FILE, new ArrayList<>(TOVAR_REPOSITORY_MAP.values()));
        //readAll();
       // final Map<String, Tovar> TOVAR_LIST = new HashMap<>();
        //for(Tovar tovar: TOVAR_REPOSITORY_MAP.values()){}
        //System.out.println(TOVAR_REPOSITORY_MAP.values());
        //PrintWriter writer;
            //writer = new PrintWriter(new File("C:\\Users\\Артем\\Desktop\\summer practise\\Project\\src\\main\\resources\\static\\yml_data\\data.yml"));
            //Yaml yaml = new Yaml();
//            for ( Map.Entry<Integer, Tovar> entry : TOVAR_REPOSITORY_MAP.entrySet()) {
//                Integer key = entry.getKey();
//                Tovar tovar = entry.getValue();
//
//            }
            //yaml.dump(readAll().get(1), writer);



    }
}
