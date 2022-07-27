package com.tlglearning.fizzbuzz;

import com.tlglearning.fizzbuzz.model.Analysis;
import com.tlglearning.fizzbuzz.model.State;
import java.util.Set;

public class FizzBuzz {

  private static final int DEFAULT_UPPER_BOUND = 100;

  public static void main(String[] args) {
    try {
      int upperBound = (args.length > 0) ? Integer.parseInt(args[0]) : DEFAULT_UPPER_BOUND;
      if (upperBound <= 0) {
        throw new IllegalArgumentException();
      }
      Analysis analysis = new Analysis();
      for (int counter = 1; counter <= upperBound; counter++) { //count from 1-100 and print results
        Set<State> result = analysis.analyze(counter);
        //if the results are a number print number else print Fizz or buzz
        System.out.println(result.isEmpty() ? counter : result);
      }
    } catch (IllegalArgumentException e) {
      System.out.printf("Usage: java %1$s [upperBound]%n", FizzBuzz.class.getName());
      System.out.println("Where: upperBound is a positive integer, with a default of 100");
      throw new RuntimeException("FizzBuzz Halted!", e);
    } finally {
      System.out.println("Thanks for playing FizzBuzz!");
    }
  }

}
