package com.tencent.mm.plugin.cdndownloader.d;

import java.util.HashSet;

public final class a<E> extends HashSet<E> {
    private b hKq;

    public a(b bVar) {
        this.hKq = bVar;
    }

    private synchronized void aAn() {
        this.hKq.aAm();
    }

    private synchronized void aAo() {
        this.hKq.remove();
    }

    private synchronized void aAp() {
        this.hKq.clear();
    }

    public final synchronized boolean add(E e) {
        boolean add;
        add = super.add(e);
        aAn();
        return add;
    }

    public final void clear() {
        super.clear();
        aAp();
    }

    public final synchronized boolean remove(Object obj) {
        boolean remove;
        remove = super.remove(obj);
        aAo();
        return remove;
    }
}
