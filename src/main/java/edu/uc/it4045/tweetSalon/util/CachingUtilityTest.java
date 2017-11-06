package edu.uc.it4045.tweetSalon.util;

import org.junit.jupiter.api.Test;

class CachingUtilityTest {
    @Test
    void putInCache() {
        CachingUtility cacheUtil = new CachingUtility();
        cacheUtil.putInCache("hello", "goodbye");
    }

    @Test
    void getFromCache() {
        CachingUtility cacheUtil = new CachingUtility();
        System.out.println(cacheUtil.getFromCache("hi"));
    }

}