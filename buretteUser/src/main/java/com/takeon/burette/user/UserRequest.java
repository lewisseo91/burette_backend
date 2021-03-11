package com.takeon.burette.user;

import java.util.List;

public class UserRequest {
    private int type;
    private String title;
    private String subTitle;
    private List<String> thumbnail; // List<String> 가능성 있음
    private String contents;
    private List<String> tags;
    private int category;

    public UserRequest(int type, String title, String subTitle, List<String> thumbnail, String contents, List<String> tags, int category) {
        this.type = type;
        this.title = title;
        this.subTitle = subTitle;
        this.thumbnail = thumbnail;
        this.contents = contents;
        this.tags = tags;
        this.category = category;
    }
}
