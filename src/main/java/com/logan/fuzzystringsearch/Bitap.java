package com.logan.fuzzystringsearch;

import java.math.BigInteger;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bitap search algorithm
 */
public class Bitap {

   private final Logger logger = LoggerFactory.getLogger(this.getClass());
   private final String needle;
   private final Map<Character, Long> bitMatrix;

   private final Set<Character> alphabet = new HashSet<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
         'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '-', ' '));

   public Bitap(final String needle) {
      this.needle = needle.toLowerCase();
      this.bitMatrix = createBitMatrix();
   }

   private final Map<Character, Long> createBitMatrix() {
      return alphabet.stream().map(c -> bitmaskNeedle(c))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
   }

   private Map.Entry<Character, Long> bitmaskNeedle(final Character c) {
      long mask = ~0; // start with all 1s
      for (int pos = 0; pos < needle.length(); pos++) {
         if (c.equals(needle.charAt(needle.length() - 1 - pos))) {
            mask &= ~(1L << pos);
         }
      }
      return new AbstractMap.SimpleEntry<>(c, (mask << 1));
   }

   public String search(final String haystack) {
      if (logger.isDebugEnabled()) {
         bitMatrix.forEach(
               (k, v) -> logger.debug(String.format("%032d [%s]", new BigInteger(Long.toBinaryString((long) v)), k)));
      }
      return null;
   }
}