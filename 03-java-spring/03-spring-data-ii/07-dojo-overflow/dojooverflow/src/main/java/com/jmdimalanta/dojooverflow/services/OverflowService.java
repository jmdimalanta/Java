package com.jmdimalanta.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmdimalanta.dojooverflow.models.Answer;
import com.jmdimalanta.dojooverflow.models.Question;
import com.jmdimalanta.dojooverflow.models.Tag;
import com.jmdimalanta.dojooverflow.repositories.AnswerRepository;
import com.jmdimalanta.dojooverflow.repositories.QuestionRepository;
import com.jmdimalanta.dojooverflow.repositories.TagRepository;

@Service
public class OverflowService {
	@Autowired
	private AnswerRepository aRepo;
	@Autowired
	private QuestionRepository qRepo;
	@Autowired
	private TagRepository tRepo;
	
	public Tag getOneTag(String subject) {
		return this.tRepo.findBySubject(subject);
	}
	
	//Split tags, creates tags and gets one tag
	public ArrayList<Tag> splitTags(String tags) {
		ArrayList<Tag> tagsForQuestions = new ArrayList<Tag>();
		String[] tagsToProcess = tags.split(", ");
		for(String s : tagsToProcess) {
			if(this.tRepo.existsBySubject(s)) {
				Tag tagToAdd = this.getOneTag(s);
				tagsForQuestions.add(tagToAdd);
			} else {
				Tag newTag = new Tag();
				newTag.setSubject(s);
				this.tRepo.save(newTag);
				tagsForQuestions.add(this.getOneTag(s));
			}
		}
		
		return tagsForQuestions;
	}
	
	public Question createQuestion(Question question) {
		question.setTaggers(this.splitTags(question.getTagsFromFrontEnd()));
		return this.qRepo.save(question);
	}
	
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
	
	public List<Question> getAllQuestions(){
		return this.qRepo.findAll();
	}
	
	public Question findOneQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
}
