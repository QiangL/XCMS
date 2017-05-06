package com.didicms.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.didicms.entry.Msg;

@Controller
@RequestMapping("/upload")
public class Util {
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String uploadImg(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request) {
		String realPath = request.getServletContext().getRealPath("/img");
		String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
		Msg msg=new Msg();
		File newfile=new File(realPath+"/"+new Date().getTime()+suffix);
		try {
			file.transferTo(newfile);
			msg.code=1;
			msg.msg="";
			msg.date.put("src", "../img/"+newfile.getName());
		} catch (IllegalStateException | IOException e) {
			msg.code=-1;
			msg.msg="";
			msg.date.put("src", "");
			e.printStackTrace();
		}
		return JSON.toJSONString(msg);
		
	}

}
