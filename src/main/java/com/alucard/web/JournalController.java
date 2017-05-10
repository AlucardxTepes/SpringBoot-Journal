package com.alucard.web;

import com.alucard.domain.JournalEntry;
import com.alucard.repository.JournalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alucard on 5/9/2017.
 */
@RestController
public class JournalController {

  private static List<JournalEntry> entries = new ArrayList<JournalEntry>();
  static {
    try {
      entries.add(new JournalEntry("Learn about the Spring Framework",
              "I will learn info on the Spring Framework to create Java Web Applications",
              "01/04/2017"));
      entries.add(new JournalEntry("Learn iOS dev",
              "Learn the basics of iOS app development using Swift",
              "20/5/2017"));
      entries.add(new JournalEntry("Learn TDD for Android",
              "Learn test driven development in Android",
              "05/10/2017"));
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @Autowired
  JournalRepository journalRepository;

  @RequestMapping("/")
  public String index(Model m) {
    m.addAttribute("journal", journalRepository.findAll());
    return "index";
  }

  @RequestMapping("/journal/all")
  public List<JournalEntry> getAll() throws ParseException {
    return entries;
  }

  @RequestMapping("/journal/findBy/title/{title}")
  public List<JournalEntry> findByTitleContains(@PathVariable String title) throws ParseException {
    return entries.stream()
            .filter(entry -> entry.getTitle().toLowerCase().contains(title.toLowerCase()))
            .collect(Collectors.toList());
  }

  @RequestMapping(value = "/journal", method = RequestMethod.POST)
  public JournalEntry add(@RequestBody JournalEntry entry) {
    entries.add(entry);
    return entry;
  }
}
