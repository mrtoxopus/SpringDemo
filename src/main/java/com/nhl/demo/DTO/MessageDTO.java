package com.nhl.demo.DTO;

import com.nhl.demo.controller.HelloWorldController;

public class MessageDTO {
    
    private long id;
    
    private String title;
    
    private String content;
    
    private long authorId;

    public MessageDTO(String title, String content) {
            this.title = title;
            this.content = content;
    }

    public long getId() {
        return id;
    }

    public MessageDTO(Long id, String message, String content, Long authorId){
        this.id = id;
        this.title = message;
        this.content = content;
        this.authorId = authorId;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }
}
