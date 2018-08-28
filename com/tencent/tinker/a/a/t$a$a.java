package com.tencent.tinker.a.a;

public abstract class t$a$a<T> implements Comparable<T> {
    public int off;

    public t$a$a(int i) {
        this.off = i;
    }

    public boolean equals(Object obj) {
        return compareTo(obj) == 0;
    }
}
