package com.springboot.springbootrestservice.service;

import com.springboot.springbootrestservice.model.Tovar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TovarServiceImpl implements TovarService {
    // Хранилище клиентов
    private static final Map<Integer, Tovar> TOVAR_REPOSITORY_MAP = new HashMap<>();

    // Переменная для генерации ID клиента
    private static final AtomicInteger TOVAR_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Tovar tovar) {
        final int tovarId = TOVAR_ID_HOLDER.incrementAndGet();
        tovar.setId(tovarId);
        TOVAR_REPOSITORY_MAP.put(tovarId, tovar);
    }

    @Override
    public List<Tovar> readAll() {
        return new ArrayList<>(TOVAR_REPOSITORY_MAP.values());
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
}
