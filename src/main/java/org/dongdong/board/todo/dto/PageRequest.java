package org.dongdong.board.todo.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import lombok.ToString;

@ToString
public class PageRequest {
    private int page = 1;
    private int size = 10;

    // T, C, W, TC, TCW
    private String type;
    private String keyword;

    public String getLink() {

        if(keyword == null || type == null) {
            return "";
        }

        StringBuffer buffer = new StringBuffer();

        buffer.append("&type="+type);

        try {
            buffer.append("&keyword="+URLEncoder.encode(keyword,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return buffer.toString();

    }

    public String getPageLink() {

        StringBuffer buffer = new StringBuffer();

        buffer.append("?page=" + page + "&size=" + size);

        buffer.append(getLink());

        return buffer.toString();

    }

    public String[] getArr() {
        if(type == null || keyword == null) {
            return null;
        }

        return type.split("");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }


    public int getOffset() {
        return (this.page - 1) * this.size;
    }

    public int getLimit() {
        return this.size;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public void setPage(int page) {
        if(page < 1) {
            page = 1;
            return;
        }

        if (page > 10000) {
            page = 100;
            return;
        }

        this.page = page;
    }

    public void setSize(int size) {
        if (size < 10) {
            this.size = 10;
            return;
        }

        if (size > 100) {
            this.size = 100;
            return;
        }

        this.size = size;
    }
}
