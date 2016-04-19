package com.dbms.domain;

/**
 * Created by mengleisun on 4/18/16.
 */
public class RatingLanguageCount {
    public double rating;
    public String language;
    public int count;
    public void setRating(double rating) {this.rating = rating;}
    public void setLanguage(String language) {this.language = language;}
    public String getLanguage() { return language;}
    public double getRating() {return rating;}
    public void setCount(int count) {this.count = count;}
    public int getCount() {return this.count;}
}
