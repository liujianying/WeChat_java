package com.tencent.mm.pluginsdk.ui.tools;

import java.util.HashMap;

abstract class g$c<K, V> {
    private HashMap<K, a> mTl;
    final /* synthetic */ g qSF;
    private final int qSK;
    private a qSQ;
    private a qSR;
    private int qSS;

    protected abstract void ca(V v);

    public g$c(g gVar, int i) {
        this.qSF = gVar;
        this.qSK = Math.max(1, i);
        this.mTl = new HashMap();
        this.qSQ = new a(this);
        this.qSR = new a(this);
        this.qSQ.qSU = this.qSR;
        this.qSR.qST = this.qSQ;
        this.qSS = 0;
    }

    private void a(a aVar) {
        aVar.qSU = this.qSQ.qSU;
        aVar.qSU.qST = aVar;
        this.qSQ.qSU = aVar;
        aVar.qST = this.qSQ;
    }

    private static void b(a aVar) {
        aVar.qST.qSU = aVar.qSU;
        aVar.qSU.qST = aVar.qST;
        aVar.qSU = null;
        aVar.qST = null;
    }

    public final void clear() {
        while (this.qSS > 0) {
            a aVar = this.qSR.qST;
            b(aVar);
            this.mTl.remove(aVar.qSV);
            ca(aVar.value);
            this.qSS--;
        }
    }

    public final V put(K k, V v) {
        synchronized (this) {
            a aVar = (a) this.mTl.get(k);
            if (aVar != null) {
                b(aVar);
                V v2 = aVar.value;
                aVar.value = v;
                a(aVar);
                return v2;
            }
            aVar = new a(this, k, v);
            a(aVar);
            this.mTl.put(k, aVar);
            this.qSS++;
            while (this.qSK < this.qSS) {
                aVar = this.qSR.qST;
                b(aVar);
                this.mTl.remove(aVar.qSV);
                ca(aVar.value);
                this.qSS--;
            }
            return null;
        }
    }

    public final V get(K k) {
        V v;
        synchronized (this) {
            a aVar = (a) this.mTl.get(k);
            if (aVar != null) {
                b(aVar);
                a(aVar);
                v = aVar.value;
            } else {
                v = null;
            }
        }
        return v;
    }

    public String toString() {
        String stringBuilder;
        synchronized (this) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (a aVar = this.qSQ.qSU; aVar != this.qSR; aVar = aVar.qSU) {
                stringBuilder2.append("[key:").append(aVar.qSV).append(", value:").append(aVar.value).append("]");
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }
}
