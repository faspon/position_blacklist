package com.fasp.blacklist;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BlockedPositionNotFoundException extends RuntimeException {

  BlockedPositionNotFoundException(Long id) {
    super("Could not find blocked position " + id);
  }
    
}
