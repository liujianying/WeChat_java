package com.tencent.mm.plugin.gallery.model;

import java.util.LinkedList;

public final class f<E> extends LinkedList<E> {
    private byte[] dsN = new byte[0];

    public final E aRy() {
        E poll;
        synchronized (this.dsN) {
            if (size() > 0) {
                poll = super.poll();
            } else {
                poll = null;
            }
        }
        return poll;
    }

    public final boolean bb(E e) {
        boolean contains;
        synchronized (this.dsN) {
            contains = super.contains(e);
        }
        return contains;
    }

    public final void bB(E e) {
        synchronized (this.dsN) {
            if (bb(e)) {
                super.remove(e);
            }
        }
    }

    public final boolean add(E e) {
        boolean add;
        synchronized (this.dsN) {
            add = super.add(e);
        }
        return add;
    }

    public final int size() {
        int size;
        synchronized (this.dsN) {
            size = super.size();
        }
        return size;
    }
}
