package com.alucard.web;

import com.alucard.repository.JournalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Alucard on 5/9/2017.
 */
@Controller
public class JournalController {

  @Autowired
  JournalRepository journalRepository;

  @RequestMapping("/")
  public String index(Model m) {
    m.addAttribute("journal", journalRepository.findAll());
    return "index";
  }
}
