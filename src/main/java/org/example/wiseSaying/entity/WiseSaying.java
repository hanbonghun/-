package org.example.wiseSaying.entity;

public class WiseSaying {
    private long id;
    private String content;
    private String authorName;

    public WiseSaying(long id, String content, String authorName) {
        this.id = id;
        this.content = content;
        this.authorName = authorName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorNmae) {
        this.authorName = authorNmae;
    }

    public String toString(){
        return getId()+" / "+getAuthorName()+" / "+getContent();
    }

    public String toJson() {
        return """
                {
                    "id": %d, 
                    "content":"%s",
                    "authorName":"%s"
                }
                """
                .stripIndent()
                .formatted(id, content, authorName);
    }
}
