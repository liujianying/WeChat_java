package com.tencent.mm.ui.contact;

import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;

class q$2 implements l {
    final /* synthetic */ q ukB;

    q$2(q qVar) {
        this.ukB = qVar;
    }

    public final void b(j jVar) {
        switch (jVar.bjW) {
            case IX5WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
            case IX5WebViewClient.ERROR_HOST_LOOKUP /*-2*/:
            case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                if (jVar.joH.bWm.equals(q.d(this.ukB))) {
                    q.c(this.ukB);
                    return;
                }
                return;
            case 0:
                if (q.a(this.ukB) != null && q.a(this.ukB).equals(q.a(this.ukB))) {
                    q.a(this.ukB, jVar.jrx);
                    q.a(this.ukB, jVar.jsx);
                    if (jVar.jsx.size() > 0) {
                        switch (((com.tencent.mm.plugin.fts.a.a.l) jVar.jsx.get(0)).type) {
                            case 131072:
                                q.c(this.ukB, jVar.jsx);
                                break;
                            case 131075:
                                q.d(this.ukB, jVar.jsx);
                                break;
                            case 131076:
                                q.e(this.ukB, jVar.jsx);
                                break;
                            default:
                                x.i("MicroMsg.MMSearchContactAdapter", "not support search");
                                break;
                        }
                    }
                    q.a(this.ukB, jVar.joH.bWm, q.c(this.ukB));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
