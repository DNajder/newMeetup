package end_project.new_meetup.service;

import end_project.new_meetup.converters.CommentaryConverter;
import end_project.new_meetup.dto.CommentaryDTO;
import end_project.new_meetup.model.CommentaryModel;
import end_project.new_meetup.repository.CommentaryRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentaryService {

    private final CommentaryRepository commentaryRepository;
    private final CommentaryConverter commentaryConverter;

    public CommentaryService(CommentaryRepository commentaryRepository, CommentaryConverter commentaryConverter) {
        this.commentaryRepository = commentaryRepository;
        this.commentaryConverter = commentaryConverter;
    }


    public CommentaryModel saveComment (CommentaryModel commentaryModel){
        return commentaryRepository.save(commentaryModel);
    }

    public List<CommentaryDTO> displayAllCommentBiEventId(String parametr){
        List<CommentaryModel> commentaryModels = commentaryRepository.findAllByEventId(parametr);
        return commentaryModels.stream().map(commentaryConverter::convertModelToDTO).sorted(Comparator.comparing(CommentaryDTO::getAddTime).reversed()).collect(Collectors.toList());
    }

}
