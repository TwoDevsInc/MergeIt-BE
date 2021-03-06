package com.twodevs.MergeIt.controllers;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twodevs.MergeIt.models.entities.Comment;
import com.twodevs.MergeIt.models.entities.File;
import com.twodevs.MergeIt.models.entities.Task;
import com.twodevs.MergeIt.models.entities.dto.CommentDTO;
import com.twodevs.MergeIt.models.entities.dto.FileDTO;
import com.twodevs.MergeIt.models.services.CommentService;
import com.twodevs.MergeIt.models.services.TaskService;


@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("/all")
	public ResponseEntity<List<CommentDTO>> getComments(){
		List<CommentDTO> comment = commentService.findAll().stream().map(c -> new CommentDTO(c)).collect(Collectors.toList());
		return new ResponseEntity<>(comment, HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CommentDTO> getCommentById(@PathVariable Integer id){
		CommentDTO comment = new CommentDTO(commentService.findById(id));
		return new ResponseEntity<>(comment, HttpStatus.OK);
	}
	
	@GetMapping("/commentsByTask/{id_task}")
	public ResponseEntity<List<CommentDTO>> getCommentByTaskId(@PathVariable Integer id_task){
		List<CommentDTO> comments = commentService.findByTaskId(id_task).stream().map(c -> new CommentDTO(c)).collect(Collectors.toList());
		return new ResponseEntity<>(comments, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<CommentDTO> addComment(@RequestBody Comment comment){
		CommentDTO newComment = new CommentDTO(commentService.save(comment));
		return new ResponseEntity<>(newComment, HttpStatus.CREATED);
	}
	
	@PostMapping("/addCommentTo/{id_task}")
	public ResponseEntity<CommentDTO> addFileToTask(@RequestBody Comment comment,@PathVariable Integer id_task){
		
		Task task = taskService.findById(id_task);		
		comment.setTask(task);
		comment.setCreatedAt(LocalDate.now());
		
		CommentDTO newComment = new CommentDTO(commentService.save(comment));
		return new ResponseEntity<>(newComment, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<CommentDTO> updateComment(@RequestBody Comment comment){
		CommentDTO commentUpdated = new CommentDTO(commentService.save(comment));
		return new ResponseEntity<>(commentUpdated, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> updateComment(@PathVariable("id") Integer id){
		commentService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
