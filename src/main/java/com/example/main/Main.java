package com.example.main;

import com.example.config.ProjectConfig;
import com.example.model.Comment;
import com.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var service = c.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setAuthor("Carlos");
        comment.setText("Example text");

        String value = service.publishComment(comment);
        logger.info(value);
    }
}