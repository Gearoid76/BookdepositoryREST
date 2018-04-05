package fi.haagahelia.bookdepository.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title, author, year,isdn, price;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn (name ="categoryid")
	private Category category;
	
	public Book() {}

	public Book(String title, String author, String year, String isdn, String price, Category category) {
		super();
		//notice id is not present..for a reason its automatically generated
		this.title = title;
		this.author = author;
		this.year = year;
		this.isdn = isdn;
		this.price = price;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getIsdn() {
		return isdn;
	}

	public void setIsdn(String isdn) {
		this.isdn = isdn;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isdn=" + isdn
				+ ", price=" + price + ", category=" + category + "]";
		else 
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isdn=" + isdn
					+ ", price=" + price + "]";
	}
	
	
	
}
