package com.tencent.mm.plugin.appbrand.game;

import android.content.SharedPreferences;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

public final class l {
    final d fAr;
    private final a fAs;
    private final f fAt;
    private volatile Boolean fAu = null;

    l(d dVar, b bVar) {
        this.fAr = dVar;
        this.fAt = (f) bVar.y(f.class);
        this.fAs = new a(this, this.fAr, this.fAt);
    }

    public final boolean agn() {
        if (this.fAu == null) {
            boolean z;
            long VG = bi.VG();
            SharedPreferences chZ = ad.chZ();
            int i = chZ != null ? chZ.getInt("useisolatectxwxalibrary", 0) : 0;
            if (i == 1) {
                z = true;
            } else {
                if (i != -1) {
                    a aVar = a.b.dnp;
                    c fJ = a.fJ("100378");
                    if (fJ == null || !fJ.isValid()) {
                        z = false;
                    } else if (bi.getInt((String) fJ.ckq().get("useisolatectxwxalibrary"), 0) == 1) {
                        z = true;
                    }
                }
                z = false;
            }
            this.fAu = Boolean.valueOf(z);
            x.i("MicroMsg.WAGameWeixinJSContextLogic", "read ShouldUseIsolateCtxWxaLibrary cost time = [%d], mShouldAllowIsolateCtx: [%b]", new Object[]{Long.valueOf(bi.bI(VG)), this.fAu});
        }
        return this.fAu.booleanValue();
    }

    public final void ago() {
        if (this.fAt == null) {
            x.e("MicroMsg.WAGameWeixinJSContextLogic", "injectWeixinJSContextLogic error. not support SubContextAddon.");
            return;
        }
        com.tencent.mm.plugin.appbrand.g.a agg = this.fAt.agg();
        if (agg == null || !agg.afV()) {
            x.e("MicroMsg.WAGameWeixinJSContextLogic", "bindMainJSContext Main Context is [" + agg + "]");
            return;
        }
        agg.addJavascriptInterface(this.fAs, "WeixinJSContext");
        this.fAs.aad();
    }
}
