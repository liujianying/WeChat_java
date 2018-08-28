package com.tencent.mm.plugin.emoji.a.a;

import java.util.Iterator;

class c$a implements Iterator<f> {
    final /* synthetic */ c iex;
    private int mIndex;

    private c$a(c cVar) {
        this.iex = cVar;
        this.mIndex = 0;
    }

    /* synthetic */ c$a(c cVar, byte b) {
        this(cVar);
    }

    public final /* synthetic */ Object next() {
        c cVar = this.iex;
        int i = this.mIndex;
        this.mIndex = i + 1;
        return cVar.oJ(i);
    }

    public final boolean hasNext() {
        return this.mIndex < this.iex.size();
    }

    public final void remove() {
    }
}
