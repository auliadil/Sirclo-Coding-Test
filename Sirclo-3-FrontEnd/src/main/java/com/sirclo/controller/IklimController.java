package com.sirclo.controller;

import java.util.LinkedList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.sirclo.model.IklimModel;
import com.sirclo.model.RowModel;
import com.sirclo.service.IklimServiceImp;

@Controller
public class IklimController {
	
	@Autowired
	private IklimServiceImp iklimService;
	
	@RequestMapping("/")
	private String home(Model model) {
		return "cek";
	}
	
	@RequestMapping(value = "/hasil", method= RequestMethod.GET)
    public String getIklim(@RequestParam(value="idKota", required = false) Optional<String> idKota, Model model) {
		long id = Long.parseLong(idKota.get());
		IklimModel iklim = iklimService.getIklimModel(id);
		LinkedList<RowModel> rowList = iklimService.getRowModel(iklim);
		long rataSuhu = iklimService.getRataSuhu(rowList);
		long rataPerbedaan = iklimService.getRataPerbedaan(rowList);
		model.addAttribute("iklim", iklim);
		model.addAttribute("rowList", rowList);
		model.addAttribute("rataSuhu", rataSuhu);
		model.addAttribute("rataPerbedaan", rataPerbedaan);
    	return "hasil";
    }
}