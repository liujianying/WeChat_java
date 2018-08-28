package com.tencent.tencentmap.mapsdk.a;

import java.util.Comparator;

class ks$1 implements Comparator<ke> {
    final /* synthetic */ ks a;

    ks$1(ks ksVar) {
        this.a = ksVar;
    }

    /* renamed from: a */
    public int compare(ke keVar, ke keVar2) {
        return Float.compare(keVar.w(), keVar2.w());
    }
}
