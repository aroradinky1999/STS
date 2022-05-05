package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter					// all setter methods. 
@Getter					// all getter methods 
@ToString				// toString() method 
//@NoArgsConstructor			// empty constructor 
@RequiredArgsConstructor			// parameterized constructor 
public class Product {
@Id
private int pid;
@NotEmpty
@Size(min=2 , message="user name atleast 2 characters")
private String pname;
private float price;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}

}
