package com.tencent.mm.model;

import com.tencent.mm.ab.d;
import com.tencent.mm.by.a.a;
import com.tencent.mm.storage.bd;

class e$a$2 implements a<com.tencent.mm.plugin.messenger.foundation.a.a> {
    final /* synthetic */ String bAd;
    final /* synthetic */ d.a dAr;
    final /* synthetic */ bd dAs;
    final /* synthetic */ String dAt;
    final /* synthetic */ boolean dAu;
    final /* synthetic */ e.a dAv;

    e$a$2(e.a aVar, d.a aVar2, bd bdVar, String str, String str2, boolean z) {
        this.dAv = aVar;
        this.dAr = aVar2;
        this.dAs = bdVar;
        this.dAt = str;
        this.bAd = str2;
        this.dAu = z;
    }

    public final /* synthetic */ void aD(Object obj) {
        ((com.tencent.mm.plugin.messenger.foundation.a.a) obj).b(this.dAr, this.dAs, this.dAt, this.bAd, this.dAu);
    }
}
