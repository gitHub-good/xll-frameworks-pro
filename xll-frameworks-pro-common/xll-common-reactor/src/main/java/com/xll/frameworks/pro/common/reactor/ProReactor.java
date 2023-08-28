package com.xll.frameworks.pro.common.reactor;

import reactor.core.publisher.Flux;

import java.util.List;

public final class ProReactor{

    public static <T> Flux<T> createFlux(T t){
        return Flux.just(t);
    }

    public static <T> Flux<T> createFlux(List<T> t){
        return Flux.fromStream(t.stream());
    }
}
