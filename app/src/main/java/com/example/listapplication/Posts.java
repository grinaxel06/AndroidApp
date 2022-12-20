package com.example.listapplication;

public class Posts {
    private final String name;
    private   int likes;
    private int comments;

    public boolean isLiked() {
        return isLiked;
    }

    private boolean isLiked = false;
    private int imageResourceId;

    public Posts(String name,int likes,int comments,int imageResourceId) {
        this.likes = likes;
        this.name = name;
        this.comments=comments;
        this.imageResourceId=imageResourceId;
    }

    public int getComments() {
        return comments;
    }

    public int getLikes() {
        return likes;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getName() {
        return name;
    }

    public void plusLike(){
        if(isLiked)likes--;
        else likes++;
        isLiked=!isLiked;
    }
    public void plusComments(){
        this.comments++;
    }

}
