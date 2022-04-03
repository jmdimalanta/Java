package com.jmdimalanta.dojooverflow.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tags")
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 5, max = 200, message = "The subject must be between 5 to 200 char!")
	private String subject;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "question_tags",
			joinColumns = @JoinColumn(name = "tag_id"),
			inverseJoinColumns = @JoinColumn(name = "question_id")
			)
	private List<Question> questionTagged;
	
	public Tag() {

	}

	public Tag(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getId() {
		return id;
	}

	public List<Question> getQuestionTagged() {
		return questionTagged;
	}

	public void setQuestionTagged(List<Question> questionTagged) {
		this.questionTagged = questionTagged;
	}

}
