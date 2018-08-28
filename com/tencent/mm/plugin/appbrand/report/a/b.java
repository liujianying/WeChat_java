package com.tencent.mm.plugin.appbrand.report.a;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class b implements f {
    private final g fdO;
    public boolean gmD = false;
    public Intent gqU;
    public boolean gqV = false;
    i gqW = null;
    private k gqX = null;
    public p gqY = null;
    public volatile g gqZ = null;
    private final String mAppId;

    public b(g gVar) {
        this.mAppId = gVar.mAppId;
        this.fdO = gVar;
        aea();
    }

    public final void aea() {
        if (!bi.oW(this.mAppId)) {
            j g = j.g(this.fdO);
            if (g != null) {
                String str = g.fdE;
                String d = a.d(g.aaD());
                this.gqZ = new d(d);
                this.gqW = i.a(this.fdO, str, this.gqZ);
                LinkedList linkedList = new LinkedList();
                linkedList.push(bi.oV(d));
                this.gqY = p.a(this.fdO, str, linkedList);
                this.gqX = k.b(this.fdO, str, this.gqZ);
                return;
            }
        }
        x.e("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", new Object[]{bi.i(new Throwable())});
        this.gqZ = g.grq;
        this.gqX = k.amQ();
        this.gqW = i.amP();
        this.gqY = p.amS();
    }

    public final void a(p pVar, p pVar2, aa aaVar) {
        p pVar3;
        if (aa.gpk == aaVar) {
            aea();
        }
        Object obj = (aa.gpk == aaVar || pVar2 == null || bi.oW(pVar2.ahc()) || pVar2 == pVar) ? 1 : null;
        g gVar = this.gqZ;
        if (obj != null) {
            pVar3 = null;
        } else {
            pVar3 = pVar2;
        }
        gVar.a(pVar, pVar3, aaVar);
        if (obj == null) {
            pVar2.gnC.t(new 1(this, pVar, pVar2));
        } else {
            a(pVar, null);
        }
    }

    final void a(p pVar, p pVar2) {
        if (pVar2 != null) {
            i iVar = this.gqW;
            pVar.ahc();
            iVar.i(pVar2);
            iVar.xP();
            p pVar3 = this.gqY;
            String ahc = pVar.ahc();
            pVar3.grK = (String) pVar3.gsD.peekFirst();
            pVar3.grL = 2;
            pVar3.grM = ahc;
            pVar3.gsD.push(pVar2.getURL());
            pVar3.gsC = pVar2.getURL();
            pVar3.k(pVar2);
        }
        this.gqX.j(pVar);
    }

    public final void c(p pVar) {
        this.gmD = true;
        this.gqZ.c(pVar);
        pVar.gnC.t(new 2(this, pVar));
    }

    public final void d(p pVar) {
        this.gqU = null;
        if (this.gqV) {
            this.gqV = false;
            return;
        }
        this.gqZ.d(pVar);
        this.gqX.j(pVar);
    }

    public final void h(long j, int i) {
        AppBrandSysConfig qa = a.qa(this.mAppId);
        int i2 = qa == null ? 0 : qa.frm.fii;
        h.mEJ.h(13543, new Object[]{this.mAppId, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i)});
    }
}
