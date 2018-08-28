package com.tencent.mm.plugin.game.widget;

import java.util.LinkedList;

public final class b<E> extends LinkedList<E> {
    private a kgZ;

    public b(a aVar) {
        this.kgZ = aVar;
    }

    public final synchronized E pop() {
        E pop;
        pop = super.pop();
        if (this.kgZ != null) {
            this.kgZ.aSK();
        }
        return pop;
    }

    public final void push(E e) {
        super.push(e);
        if (this.kgZ != null) {
            this.kgZ.aSJ();
        }
    }
}
