package io.quarkus.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;

import io.quarkus.cache.CacheInvalidateAll.List;

/**
 * When a method annotated with {@link CacheInvalidateAll} is invoked, Quarkus will remove all entries from the cache.
 * <p>
 * This annotation can be combined with multiple other caching annotations on a single method. Caching operations will always
 * be executed in the same order: {@link CacheInvalidateAll} first, then {@link CacheInvalidate} and finally
 * {@link CacheResult}.
 * <p>
 * The underlying caching provider can be chosen and configured in the Quarkus {@link application.properties} file.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(List.class)
public @interface CacheInvalidateAll {

    /**
     * The name of the cache.
     */
    @Nonbinding
    String cacheName();

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface List {
        CacheInvalidateAll[] value();
    }
}
