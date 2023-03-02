package org.example;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Quote> list = new LinkedList<>();

        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.print("명령 ) ");
            String cmd = sc.nextLine();
            if(cmd.equals("종료")){
                return;
            }else if (cmd.equals("등록")){
                System.out.print("명언 : ");
                String quote = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
                Quote q = new Quote(++Quote.numberOfQuotes,quote, author);
                list.add(q);
                System.out.println(Quote.numberOfQuotes+ "번 명언이 등록되었습니다.");

            }else if(cmd.equals(("목록"))){
                System.out.print("번호 / 작가 / 명언\n");
                System.out.print("----------------------\n");
                for(int i=list.size()-1; i>=0; i--){
                    System.out.println(list.get(i));
                }
            }else if(cmd.matches("삭제\\?id=[0-9]+")){
                int id = Integer.parseInt(cmd.split("=")[1]);
                boolean isExist =false;
                for(Quote q : list){
                    if(q.getId()== id) {
                        list.remove(q);
                        System.out.print(id+"번 명언이 삭제되었습니다.\n");
                        isExist = true;
                        break;
                    }
                }
                if(!isExist)System.out.print(id+"번 명언은 존재하지 않습니다.\n");
            }
        }
    }
}

class Quote{
    static int numberOfQuotes=0;
    int id;
    String content ;
    String author;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Quote (){}

    public Quote(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }
    @Override
    public String toString(){
        return this.id+" / "+ this.author+" / "+this.content;
    }

}