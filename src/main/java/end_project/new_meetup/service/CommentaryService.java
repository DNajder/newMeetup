package end_project.new_meetup.service;

import end_project.new_meetup.model.CommentaryModel;
import end_project.new_meetup.repository.CommentaryRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentaryService {

    private final CommentaryRepository commentaryRepository;

    public CommentaryService(CommentaryRepository commentaryRepository) {
        this.commentaryRepository = commentaryRepository;
    }


    public CommentaryModel saveComment (CommentaryModel commentaryModel){
        return commentaryRepository.save(commentaryModel);
    }
}
