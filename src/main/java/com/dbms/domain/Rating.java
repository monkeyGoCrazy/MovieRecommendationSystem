package com.dbms.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Id;
import java.util.Date;

@Entity
@XmlRootElement
@Table(name = "Rating")
public class Rating {
    @Id
    @Column(name ="movietitle")
    private String movietitle;


    private float rating;
    private int votes;
    private float r1;
    private float r2;
    private float r3;
    private float r4;
    private float r5;
    private float r6;
    private float r7;
    private float r8;
    private float r9;
    private float r10;
    public String getMovietitle() {return this.movietitle;}
    public void setMovietitle(String movietitle) {this.movietitle = movietitle;}
    public float getRating() {return this.rating;}
    public void setRating(float rating) {this.rating = rating;}
    public int getVotes() {return this.votes;}
    public void setVotes(int votes) { this.votes = votes;}
    public float getR1() {return this.r1;}
    public void setR1(float r1) {this.r1 = r1;}
    public float getR2() {return this.r2;}
    public void setR2(float r2) {this.r2 = r2;}
    public float getR3() {return this.r3;}
    public void setR3(float r3) {this.r3 = r3;}
    public float getR4() {return this.r4;}
    public void setR4(float r4) {this.r4 = r4;}
    public float getR5() {return this.r5;}
    public void setR5(float r5) {this.r5 = r5;}
    public float getR6() {return this.r6;}
    public void setR6(float r6) {this.r6 = r6;}
    public float getR7() {return this.r7;}
    public void setR7(float r7) {this.r7 = r7;}
    public float getR8() {return this.r8;}
    public void setR8(float r8) {this.r8 = r8;}
    public float getR9() {return this.r9;}
    public void setR9(float r9) {this.r9 = r9;}
    public float getR10() {return this.r10;}
    public void setR10(float r10) {this.r10 = r10;}
}
