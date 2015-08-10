package org.msuhail.java.home_project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Inventory")
public class Inventory {
@Id
public String name;
public String Description;
public int price;
public String ImageURL;
public String Category;
public int quantity;
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getImageURL() {
	return ImageURL;
}
public void setImageURL(String imageURL) {
	ImageURL = imageURL;
}
public String getCategory() {
	return Category;
}
public void setCategory(String category) {
	Category = category;
}
	

}
