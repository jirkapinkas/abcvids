package cz.jiripinkas.abcvids.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "vids_item")
public class Item {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length = 200, nullable = false)
	private String name = "";

	@Column(length = 200, nullable = false, unique = true)
	private String shortName = "";

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Column(nullable = false, length = Integer.MAX_VALUE)
	@Basic(fetch = FetchType.LAZY)
	private String description = "";

	@Column(length = 300, nullable = false)
	private String keywords = "";

	@Column(name = "seo_description", length = 500, nullable = false)
	private String seoDescription = "";

	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	@Column(length = 300, nullable = false)
	private String url = "";

	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getSeoDescription() {
		return seoDescription;
	}

	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
