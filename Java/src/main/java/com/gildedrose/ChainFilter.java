package com.gildedrose;

import java.util.function.Consumer;

public interface ChainFilter<T> {

    /**
     * @return true:continue filter chain, false:stop filter chain
     */
    boolean apply(T t);

}
