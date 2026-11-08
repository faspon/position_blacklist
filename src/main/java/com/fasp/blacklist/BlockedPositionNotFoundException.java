package com.fasp.blacklist;

public class BlockedPositionNotFoundException extends RuntimeException {

  BlockedPositionNotFoundException(Long id) {
    super("Could not find blocked position " + id);
  }
    
}
