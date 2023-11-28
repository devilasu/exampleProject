package com.grd.hosp.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grd.Util.SessionUtil;
import com.grd.hosp.entity.HospitalEntity;
import com.grd.hosp.service.MainService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {
	
	@Autowired
	MainService mainService;
	
	@GetMapping("/")
	public String mainPage(Model model) throws Exception{
		return mainService.mainPage(model);
	}
	
	@GetMapping("/log")
	public String logPage(Model model) throws Exception{
		File file = new File("/was/logs/logback.log");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		String result = "";
		while((line = br.readLine()) != null) {
			result += line + System.lineSeparator();
		}
		model.addAttribute("logData", result);
		return "log";
	}
}
