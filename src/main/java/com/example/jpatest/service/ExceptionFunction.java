package com.example.jpatest.service;

public interface ExceptionFunction<T,R> {
    R apply(T r) throws Exception;
}
