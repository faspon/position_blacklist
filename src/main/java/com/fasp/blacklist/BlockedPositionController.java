package com.fasp.blacklist;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasp.blacklist.entity.BlockedPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RestController
public class BlockedPositionController {

  @Autowired
  private ApplicationContext applicationContext;
  private final BlockedPositionRepository repository;

  BlockedPositionController(BlockedPositionRepository repository) {
    this.repository = repository;
  }

  @GetMapping(value = "/", produces = "text/plain")
  public String index() {
    RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext
            .getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
    Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping
            .getHandlerMethods();
    String endpoints = map.keySet().stream()
    .filter( null)
    .map(t -> t.toString()).collect(Collectors.joining("\n"));
    return "Endpoints:\n\n" + endpoints;
  }

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/blockedpositions")
  List<BlockedPosition> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/blockedpositions")
  BlockedPosition newEmployee(@RequestBody BlockedPosition newBlockedPosition) {
    return repository.save(newBlockedPosition);
  }

  // Single item
  
  @GetMapping("/blockedpositions/{id}")
  BlockedPosition one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new BlockedPositionNotFoundException(id));
  }

  @PutMapping("/blockedpositions/{id}")
  BlockedPosition replaceBlockedPosition(@RequestBody BlockedPosition newBlockedPosition, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(pos -> {
        pos.setName(newBlockedPosition.getName());
        pos.setId(newBlockedPosition.getId());
        return repository.save(pos);
      })
      .orElseGet(() -> {
        return repository.save(newBlockedPosition);
      });
  }

  @DeleteMapping("/blockedpositions/{id}")
  void deleteBlockedPosition(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
