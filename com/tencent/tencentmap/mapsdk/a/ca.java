package com.tencent.tencentmap.mapsdk.a;

final class ca<K, V> {
    bz<K, V> a;
    bz<K, V> b;

    ca() {
    }

    public final void a(bz<K, V> bzVar) {
        if (bzVar.c != null) {
            bzVar.c.d = bzVar.d;
        } else {
            this.b = bzVar.d;
            if (this.b != null) {
                this.b.c = null;
            }
        }
        if (bzVar.d != null) {
            bzVar.d.c = bzVar.c;
            return;
        }
        this.a = bzVar.c;
        if (this.a != null) {
            this.a.d = null;
        }
    }

    public final void b(bz<K, V> bzVar) {
        if (this.a == null) {
            this.a = bzVar;
            this.b = bzVar;
            return;
        }
        bzVar.c = this.a;
        this.a.d = bzVar;
        this.a = bzVar;
        this.a.d = null;
    }
}
