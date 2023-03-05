package org.example.wiseSaying.repository;

import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private long lastWiseSayingId;
    private final List<WiseSaying> wiseSayingList;

    public WiseSayingRepository() {
        this.lastWiseSayingId = 0;
        this.wiseSayingList = new ArrayList<>();
    }

    public List<WiseSaying> findAll() {
        return wiseSayingList;
    }

    public WiseSaying findById(long id) {
        for(WiseSaying wiseSaying : wiseSayingList){
            if(wiseSaying.getId()==id){
                return wiseSaying;
            }
        }
        return null;
    }

    public long write(String content, String author) {
        long id = lastWiseSayingId+1;
        WiseSaying wiseSaying = new WiseSaying(id,content,author);
        wiseSayingList.add(wiseSaying);
        lastWiseSayingId = id;
        return id;
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayingList.remove(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthorName(author);
    }
}
