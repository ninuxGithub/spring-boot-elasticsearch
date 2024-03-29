package com.example.elasticsearch.model;

import java.io.Serializable;

public class Author implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1882009914498264848L;

	/**
	 * 作者id
	 */
	private Long id;
	/**
	 * 作者姓名
	 */
	private String name;
	/**
	 * 作者简介
	 */
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}

}
