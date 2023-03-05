package org.example.wiseSaying.repository;

import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.table.WiseSayingTable;

import java.util.List;

public class WiseSayingRepository {
    private final WiseSayingTable wiseSayingTable;

    public WiseSayingRepository() {
        this.wiseSayingTable = new WiseSayingTable();
    }

    public List<WiseSaying> findAll() {
        return wiseSayingTable.findAll();
    }

    public WiseSaying findById(long id) {
        return wiseSayingTable.findById(id);
    }

    public long write(String content, String author) {
        long id = wiseSayingTable.getLastId()+1;
        WiseSaying wiseSaying = new WiseSaying(id,content,author);
        return wiseSayingTable.save(wiseSaying);
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayingTable.remove(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSayingTable.modify(wiseSaying, content, author);
    }
}
