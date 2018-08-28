package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.ab.l;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;

public final class k implements a {
    private static k tXu;
    HashSet<Long> tXv = new HashSet();
    a tXw;

    private k() {
    }

    public static k cxA() {
        if (tXu == null) {
            tXu = new k();
        }
        return tXu;
    }

    public final boolean gL(long j) {
        return this.tXv.contains(Long.valueOf(j));
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, l lVar) {
        if (this.tXw != null) {
            this.tXw.a(j, j2, i, i2, obj, i3, i4, lVar);
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, l lVar) {
        if (this.tXw != null) {
            this.tXw.a(j, j2, i, i2, obj, i3, i4, str, lVar);
        } else {
            au.HU();
            x.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] hdImg end at background, msgLocalId:%d", new Object[]{Long.valueOf(c.FT().dW(j2).field_msgId)});
            b.b(ad.getContext(), r2, false);
        }
        this.tXv.remove(Long.valueOf(j2));
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        if (this.tXw != null) {
            this.tXw.a(j, j2, i, i2, obj);
        }
        this.tXv.remove(Long.valueOf(j2));
    }
}
