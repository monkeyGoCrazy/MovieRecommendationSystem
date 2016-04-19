package com.dbms.domain;

/**
 * Created by mengleisun on 4/18/16.
 */
public class GenreLanguageCount {
    public String genre;
    public String language;
    public int count;
    public void setGenre(String genre) {this.genre = genre;}
    public void setLanguage(String language) {this.language = language;}
    public String getLanguage() { return language;}
    public String getGenre() {return this.genre;}
    public void setCount(int count) {this.count = count;}
    public int getCount() {return this.count;}
}
