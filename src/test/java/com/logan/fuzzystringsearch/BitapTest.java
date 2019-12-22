package com.logan.fuzzystringsearch;

import org.junit.jupiter.api.*;
/**
 * BitapTest
 */
public class BitapTest {

   @Test
   public void test() {
      Bitap bitap = new Bitap("ALF RED");
      bitap.search("c alf red b");
   }
   
}