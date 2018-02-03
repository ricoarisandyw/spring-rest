package com.ricoaw;

import javax.annotation.Nonnull;
import java.util.List;

public interface Assembler  <A, B> {

    @Nonnull
    A fromDto(@Nonnull B dto);

    @Nonnull
    List<A> fromDto(@Nonnull List<B> list);

    @Nonnull
    B fromEntity(@Nonnull A entity);
    
    @Nonnull
    List<B> fromEntity(@Nonnull List<A> entity);
}