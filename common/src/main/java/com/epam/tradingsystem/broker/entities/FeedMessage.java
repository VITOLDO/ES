package com.epam.tradingsystem.broker.entities;

/*
 * @author Alyona Kolesnyk 
 * 
 * This is PoJo for working with RSS news
 */
public class FeedMessage {
	private String title;
	private String description;
	private String link;
	private String author;
	private String guid;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	private volatile int hashCode;

	public int hashCode() {
		final int prime = 17;
		int result = hashCode;
		if (result == 0) {
			result = 37;
			result = prime * result * author.hashCode();
			result = prime * result * description.hashCode();
			result = prime * result * guid.hashCode();
			result = prime * result * link.hashCode();
			result = prime * result * title.hashCode();
			hashCode = result;
		}
		return result;
	}

	@Override
	public String toString() {
		return "FeedMessage [title=" + title + ", description=" + description
				+ ", link=" + link + ", author=" + author + ", guid=" + guid
				+ "]";
	}
}
