package cz.jiripinkas.abcvids.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vids_group")
public class Group {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length = 200, nullable = false)
	private String name;

	@Lob
	@Column(nullable = false, length = Integer.MAX_VALUE)
	@Basic(fetch = FetchType.LAZY)
	private String description;

	@Column(length = 300, nullable = false)
	private String keywords;

	@Column(name = "seo_description", length = 500, nullable = false)
	private String seoDescription;

	@OneToMany(mappedBy = "group")
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
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

}
