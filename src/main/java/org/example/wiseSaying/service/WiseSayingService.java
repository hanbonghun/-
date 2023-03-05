package org.example.wiseSaying.service;
import org.example.Util;
import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.repository.WiseSayingRepository;

import java.util.List;
import java.util.stream.Collectors;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;
    public WiseSayingService( ) {
        this.wiseSayingRepository = new WiseSayingRepository();
    }

    public long write(String content, String author) {
        return wiseSayingRepository.write(content, author);
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayingRepository.remove(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSayingRepository.modify(wiseSaying, content, author);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public WiseSaying findById(long id) {
        return wiseSayingRepository.findById(id);
    }

    public void build() {
        List<WiseSaying> wiseSayings = wiseSayingRepository.findAll();
        Util.file.mkdir("prodBuild");
        String json = "[" + wiseSayings
                .stream()
                .map(wiseSaying -> wiseSaying.toJson())
                .collect(Collectors.joining(",")) + "]";

        Util.file.saveToFile("prodBuild/data.json", json);
    }
}
