package com.www.demo.model.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
/**
 * 作者信息对象
 * @author www
 *
 */
@ConfigurationProperties(prefix="author")
@PropertySource("classpath:author.properties")
public class People {
	private String name;
	private String age;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}


	public People(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

}
