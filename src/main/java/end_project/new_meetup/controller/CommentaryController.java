package end_project.new_meetup.controller;


import end_project.new_meetup.converters.CommentaryConverter;
import end_project.new_meetup.dto.CommentaryDTO;
import end_project.new_meetup.service.CommentaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class CommentaryController {
//
//    private final CommentaryService commentaryService;
//    private final CommentaryConverter commentaryConverter;
//
//    @PostMapping({"/comment", "comment"})
//    public String commentaryAdding (@ModelAttribute @Valid CommentaryDTO commentaryDTO, BindingResult bindingResult, HttpServletRequest request, Model model) {
//
//        System.out.println(commentaryDTO);
//        if (bindingResult.hasErrors()) {
//            return "exactEventView";
//        }
//        Long eventId = Long.parseLong(request.getParameter("eid"));
//commentaryService.saveComment(commentaryConverter.convertDtoToModel(commentaryDTO, eventId));
//
//        return "commentarySuck";
//    }
}
