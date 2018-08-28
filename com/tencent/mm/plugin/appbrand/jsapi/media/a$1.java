package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.Closeable;
import java.nio.ByteBuffer;

class a$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ String fUc;
    final /* synthetic */ a fUd;

    a$1(a aVar, l lVar, String str, int i) {
        this.fUd = aVar;
        this.fCl = lVar;
        this.fUc = str;
        this.doP = i;
    }

    public final void run() {
        Closeable closeable = null;
        if (this.fCl.Sx) {
            a aVar = this.fCl.fdO.fcw;
            String str = this.fUc;
            h hVar = new h();
            if (aVar.a(str, hVar) == j.fkI) {
                closeable = new com.tencent.mm.plugin.appbrand.l.a((ByteBuffer) hVar.value);
            }
            if (closeable == null) {
                try {
                    this.fCl.E(this.doP, this.fUd.f("fail file not exists", null));
                } catch (Throwable th) {
                    bi.d(closeable);
                }
            } else {
                String adS = org.a.a.a.a.adS(this.fUc);
                if (this.fUd.tG(s.Uh(adS))) {
                    adS = this.fUd.tH(adS);
                    boolean d = a.d(adS, closeable);
                    if (d) {
                        this.fUd.tI(adS);
                        com.tencent.mm.pluginsdk.ui.tools.l.a(adS, this.fCl.getContext());
                    }
                    this.fCl.E(this.doP, this.fUd.f(d ? "ok" : "fail", null));
                } else {
                    this.fCl.E(this.doP, this.fUd.f("fail invalid file type", null));
                    bi.d(closeable);
                    return;
                }
            }
            bi.d(closeable);
        }
    }
}
