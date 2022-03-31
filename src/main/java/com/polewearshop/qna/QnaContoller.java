package com.polewearshop.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.polewearshop.comment.bo.CommentBO;
import com.polewearshop.comment.model.Comment;
import com.polewearshop.qna.bo.QnaBO;
import com.polewearshop.qna.model.Qna;

@Controller
@RequestMapping("/customer")
public class QnaContoller {

	@Autowired
	private QnaBO qnaBO;
	
	@Autowired
	private CommentBO commentBO;
	
	@RequestMapping("/qna_list_view")
	public String qnaListView(Model model) {

		List<Qna> qnaList =	qnaBO.getQnaList();
		
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("viewName", "customer/qna_list");
		return "template/layout";
	}
	
	@RequestMapping("/qna_create_view")
	public String qnaCreateView(Model model) {
		model.addAttribute("viewName", "customer/qna_create");
		return "template/layout";
	}
	
	@RequestMapping("/qna_detailed_view")
	public String qnaDetailedView(
			Model model,
			@RequestParam("qnaId") int qnaId) {
		
		Qna qna = qnaBO.getQnaById(qnaId);
		String type = "qna";
		List<Comment> commentList = commentBO.getCommentListByTypeAndBoardId(type, qnaId);
		
		model.addAttribute("commentList", commentList);
		model.addAttribute("qna", qna);
		model.addAttribute("viewName", "customer/qna_detailed");
		return "template/layout";
	}
	
}

