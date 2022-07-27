package com.tlglearning.fizzbuzz.model;

import java.util.EnumSet;
import java.util.Set;

public class Analysis { //this makes it so it has to return whatever is in the state

  public Set<State> analyze(int value) {

    Set<State> result = EnumSet.noneOf(State.class);

    if (value % 3 == 0) { //when a value is divisible by 3, print fizz
      result.add(State.FIZZ);
    }

    if (value % 5 == 0) { //when a value is divisible by 3, print buzz
      result.add(State.BUZZ);
    }

    return result;

  }

}
