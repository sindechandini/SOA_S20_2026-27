package com.klu.bookApplication;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository  extends  JpaRepository<book,Integer>

{

}