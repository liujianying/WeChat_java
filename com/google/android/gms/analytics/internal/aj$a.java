package com.google.android.gms.analytics.internal;

import com.google.android.gms.c.j;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;

public final class aj$a<V> {
    private final V aIi;
    private final j<V> aIj;
    private V aIk;

    aj$a(j<V> jVar, V v) {
        w.ah(jVar);
        this.aIj = jVar;
        this.aIi = v;
    }

    static aj$a<Integer> c(String str, int i, int i2) {
        return new aj$a(j.a(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    static aj$a<String> c(String str, String str2, String str3) {
        return new aj$a(j.o(str, str3), str2);
    }

    static aj$a<Long> d(String str, long j, long j2) {
        return new aj$a(j.a(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    static aj$a<Boolean> h(String str, boolean z) {
        return new aj$a(j.j(str, z), Boolean.valueOf(z));
    }

    public final V get() {
        return this.aIk != null ? this.aIk : (f.aNr && j.isInitialized()) ? this.aIj.pX() : this.aIi;
    }
}
