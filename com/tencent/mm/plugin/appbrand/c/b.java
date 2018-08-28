package com.tencent.mm.plugin.appbrand.c;

import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.c.d.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public final class b {
    public a dVu = new 1(this);
    public Vector<com.tencent.mm.plugin.appbrand.c.d.b> fnS = new Vector();
    public Vector<d.a> fnT = new Vector();
    public HashMap<String, c> fnU = new HashMap();
    public j.a fnV = new 2(this);

    static /* synthetic */ void a(b bVar, boolean z, String str, String str2, String str3) {
        if (bVar.fnS != null && bVar.fnS.size() > 0) {
            Iterator it = bVar.fnS.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.plugin.appbrand.c.d.b) it.next()).a(z, str, str2, str3);
            }
        }
    }

    public final void a(com.tencent.mm.plugin.appbrand.c.d.b bVar) {
        if (this.fnS != null && bVar != null) {
            this.fnS.remove(bVar);
        }
    }

    public final void a(d.a aVar) {
        if (this.fnT != null && aVar != null) {
            this.fnT.remove(aVar);
        }
    }

    public static boolean rq(String str) {
        a rs = e.abk().rs(str);
        if (rs != null) {
            return g.ND().lw(rs.mediaId);
        }
        x.e("MicroMsg.AppbrandCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[]{str});
        return false;
    }

    public final void rr(String str) {
        this.fnU.remove(str);
    }
}
