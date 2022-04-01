package com.polewearshop.studio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.polewearshop.studio.bo.StudioBO;
import com.polewearshop.studio.model.Studio;

@Controller
@RequestMapping("/studio")
public class StudioController {

	@Autowired
	private StudioBO studioBO;
	
	//studio main
	@RequestMapping("/main_view")
	public String studioMainView(Model model) {
		model.addAttribute("viewName", "studio/main");
		return "template/layout";
	}
	
	//시설안내
	@RequestMapping("/facility_info_view")
	public String studioBranchView(
			Model model,
			@RequestParam("studioId") int studioId)
					{
		Studio studio = studioBO.getStudioById(studioId);
		
		model.addAttribute("studio", studio);
		model.addAttribute("viewName", "studio/facility_info");
		return "template/layout";
	}
	
	//이용안내
	@RequestMapping("/use_info_view")
	public String userInfoView(
			Model model,
			@RequestParam("studioId") int studioId)
					{
		
		Studio studio = studioBO.getStudioById(studioId);
		
		model.addAttribute("studio", studio);
		model.addAttribute("viewName", "studio/use_info");
		return "template/layout";
	}
	
	//예약현황
	@RequestMapping("/reserve_status_view")
	public String reserveStatusView(
			Model model,
			@RequestParam("studioId") int studioId)
					{
		
		Studio studio = studioBO.getStudioById(studioId);
		
		model.addAttribute("studio", studio);
		model.addAttribute("viewName", "studio/reserve_status");
		return "template/layout";
	}
	
	//오시는길
	@RequestMapping("/directions_view")
	public String directionView(
			Model model,
			@RequestParam("studioId") int studioId)
					{
		
		Studio studio = studioBO.getStudioById(studioId);
		
		model.addAttribute("studio", studio);
		model.addAttribute("viewName", "studio/directions");
		return "template/layout";
	}
}
