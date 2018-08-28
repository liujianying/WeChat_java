package com.tencent.mm.ipcinvoker.extension;

import com.tencent.mm.ipcinvoker.g.b;
import junit.framework.Assert;

public final class e<T> {
    private volatile T dna;
    private Class<T> targetClass;

    public e(Class<T> cls) {
        Assert.assertNotNull(cls);
        this.targetClass = cls;
    }

    public final T get() {
        if (this.dna == null) {
            synchronized (this) {
                if (this.dna == null) {
                    this.dna = b.i(this.targetClass);
                }
            }
        }
        return this.dna;
    }
}
