package ua.lviv.iot.spring.rest.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.spring.rest.model.Drug;

@RequestMapping("/drugs")
@RestController
public class DrugsController {
  private Map<Integer, Drug> drugs = new HashMap<>();
  private AtomicInteger idCounter = new AtomicInteger();

  @GetMapping
  public List<Drug> getAllDrugs() {
    return new LinkedList<Drug>(drugs.values());
  }

  @GetMapping(path = "/{id}")
  public Drug getDrug(@PathVariable("id") Integer drugId) {
    System.out.println(drugId);
    return drugs.get(drugId);
  }

  @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
  public Drug createDrug(@RequestBody Drug drug) {
    drug.setId(idCounter.incrementAndGet());
    drugs.put(drug.getId(), drug);
    return drug;
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Drug> deleteDrug(@PathVariable("id") Integer drugId) {
   HttpStatus status = drugs.remove(drugId)==null?HttpStatus.NOT_FOUND:HttpStatus.OK;
   return ResponseEntity.status(status).build();
 
  }
  @PutMapping(path= "/{id}")
  public Drug updateDrug(final @PathVariable ("id") Integer drugId, 
      final @RequestBody Drug drug) {
    drug.setId(drugId);
    return drugs.put(drugId, drug);
  }
}

