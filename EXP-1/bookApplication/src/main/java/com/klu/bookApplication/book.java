package com.klu.bookApplication;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class book {
 @Id
 int bno;
 String bname;
 int bpages;
 //generate getters and setters
 //generate toString
 public int getBno() {
  return bno;
 }
 public void setBno(int bno) {
  this.bno = bno;
 }
 public String getBname() {
  return bname;
 }
 public void setBname(String bname) {
  this.bname = bname;
 }
 public int getBpages() {
  return bpages;
 }
 public void setBpages(int bpages) {
  this.bpages = bpages;
 }
 @Override
 public String toString() {
  return "Book [bno=" + bno + ", bname=" + bname + ", bpages=" + bpages + "]";
 }


}