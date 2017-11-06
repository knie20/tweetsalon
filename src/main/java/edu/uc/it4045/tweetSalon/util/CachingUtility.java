package edu.uc.it4045.tweetSalon.util;


import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.CacheAccess;
import org.apache.commons.jcs.access.exception.CacheException;

/**
 * Utility class that caches frequently used information for fast performance.
 * For now, this class is used to cache the bearer token for the Twitter API
 */
public class CachingUtility {
    private CacheAccess<String, String> cache = null;

    public CachingUtility() {
        try {
            cache = JCS.getInstance("default");
        }catch (CacheException e){
            System.out.println( String.format( "Problem initializing cache: %s", e.getMessage() ) );
        }
    }

    public void putInCache(String name, String obj){
        cache.put(name, obj);
    }

    public String getFromCache(String name){
        return cache.get(name);
    }

    public void removeFromCache(String name){
        cache.remove(name);
    }
}
