package com.tlglearning.fizzbuzz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.EnumSet;
import java.util.Set;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class AnalysisTest {

  static final Set<State> fizzExpected = EnumSet.of(State.FIZZ);
  static final Set<State> buzzExpected = EnumSet.of(State.BUZZ);
  static final Set<State> fizzBuzzExpected = EnumSet.of(State.FIZZ, State.BUZZ);
  static final Set<State> neitherExpected = EnumSet.noneOf(State.class); //set.of() immutable

  final Analysis analysis = new Analysis(); //makes it so all tests use this before each test

  @ParameterizedTest //use parameter test whenever testing more than 1 thing.
  @ValueSource(ints = {3, 21, 999_999_999}) //tests all values of 3 between these numbers
  void analyze_fizz(int value) {
    assertEquals(fizzExpected, analysis.analyze(value)); //tests that the result is equal to value of 3
  }

  @ParameterizedTest
  @ValueSource(ints = {5, 10, 100_000_000}) //tests all values of 5 between these numbers
  void analyze_buzz(int value) {
    assertEquals(buzzExpected, analysis.analyze(value)); //tests that the result is equal to value of 5
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 15, 999_999_990}) //tests all values of 3 between these numbers
  void analyze_fizzBuzz(int value) {
        assertEquals(fizzBuzzExpected, analysis.analyze(value)); //tests that the result is equal to value of 3
  }

  @ParameterizedTest
  @CsvFileSource(resources = "neither.csv", numLinesToSkip = 1) //tests all values of 3 between these numbers
  void analyze_neither(int value) {
    assertEquals(neitherExpected, analysis.analyze(value)); //tests that the result is equal to value of 3
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, -3, -5, -15})
  void analyze_negative(int value) {
    assertThrows(IllegalArgumentException.class, new InvalidInvocation(analysis, value));
  }

}