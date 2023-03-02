package org.example.wiseSaying.controller;
import org.example.Container;
import org.example.Rq;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.LinkedList;
import java.util.List;

public class WiseSayingController {
    private long lastWiseSaying;
    private final List<WiseSaying> wiseSayingList;

    public WiseSayingController(  ){
        lastWiseSaying =1;
        wiseSayingList = new LinkedList<>();
    }
    public void write() {
        long id = lastWiseSaying;
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine().trim();
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine().trim();
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayingList.add(wiseSaying);
        System.out.printf("%d번 명언이 등록되었습니다.\n",lastWiseSaying++);
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------");

        for (int i = wiseSayingList.size()-1; i >=0; i--) {
            System.out.println(wiseSayingList.get(i));
        }
    }

    public void remove( Rq rq ) {
        int id = rq.getIntParam("id",-1);
        if(id==-1){
            System.out.println("id(정수)를 입력하세요.");
            return;
        }
        WiseSaying wiseSaying = findById(id);
        if(wiseSaying==null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
            return;
        }
        wiseSayingList.remove(wiseSaying);
        System.out.printf("%d번 명언이 삭제되었습니다.\n",id);
    }

    public void modify(Rq rq) {
        int id = rq.getIntParam("id",-1);
        if(id==-1){
            System.out.println("id(정수)를 입력하세요.");
            return;
        }
        WiseSaying wiseSaying = findById(id);
        if(wiseSaying==null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
            return;
        }
        System.out.printf("명언(기존) : %s\n",wiseSaying.getContent());
        System.out.printf("작가(기존) : %s\n",wiseSaying.getAuthorName());
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine().trim();
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine().trim();
        wiseSaying.setContent(content);
        wiseSaying.setAuthorName(author);
        System.out.printf("%d번 명언이 수정되었습니다.\n",id);
    }

    public WiseSaying findById(int id){
        for(WiseSaying wiseSaying : wiseSayingList){
            if(wiseSaying.getId()==id){
                return wiseSaying;
            }
        }
        return null;
    }
}
