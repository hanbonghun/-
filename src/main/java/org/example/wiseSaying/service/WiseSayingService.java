package org.example.wiseSaying.service;

import org.example.Container;
import org.example.Rq;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private long lastWiseSaying;
    private final List<WiseSaying> wiseSayingList;

    public WiseSayingService( ) {
        this.lastWiseSaying = 0;
        this.wiseSayingList = new ArrayList<>();
    }

    public long write(String content, String author) {
        long id = ++lastWiseSaying;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayingList.add(wiseSaying);
        return lastWiseSaying;
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayingList.remove(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthorName(author);
    }

    public WiseSaying findById(long id) {
        for(WiseSaying wiseSaying : wiseSayingList){
            if(wiseSaying.getId()==id){
                return wiseSaying;
            }
        }
        return null;
    }

    public List<WiseSaying> findAll() {
        return wiseSayingList;
    }
}
