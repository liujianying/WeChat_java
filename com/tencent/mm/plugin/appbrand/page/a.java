package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class a {
    private static final a glE = new 1();
    private static final HashMap<g, a> glF = new HashMap();
    private final g fdD;
    private int glG;
    private int glH;
    private a glI;

    /* synthetic */ a() {
        this(null);
    }

    static void b(p pVar) {
        if (pVar != null) {
            a t = t(pVar.fdO);
            x.i("MicroMsg.AppBrandActionBarSubTitleHintHelper", "applyToUpcomingPage, textId: %d, status: %s", new Object[]{Integer.valueOf(t.glH), t.glI});
            pVar.ks(t.glH);
            pVar.gnn.setOptionBtnStatus(t.glI);
        }
    }

    public static a t(g gVar) {
        if (gVar == null) {
            return glE;
        }
        a aVar = (a) glF.get(gVar);
        if (aVar != null) {
            return aVar;
        }
        aVar = new a(gVar);
        glF.put(gVar, aVar);
        return aVar;
    }

    private a(final g gVar) {
        this.glG = 0;
        this.glI = a.glL;
        this.fdD = gVar;
        if (gVar != null) {
            e.a(gVar.mAppId, new b() {
                public final void onDestroy() {
                    a.glF.remove(gVar);
                }
            });
        }
    }

    public final int a(a aVar) {
        int i = 0;
        switch (3.glK[aVar.ordinal()]) {
            case 1:
                i = j.app_brand_jsapi_getting_location;
                break;
            case 3:
                i = j.app_brand_jsapi_recording;
                break;
        }
        return a(i, aVar);
    }

    public int a(int i, a aVar) {
        try {
            x.i("MicroMsg.AppBrandActionBarSubTitleHintHelper", "blinkSubTitle, status: %s", new Object[]{aVar});
            this.fdD.fcz.getCurrentPage().getCurrentPageView().ks(i);
            this.fdD.fcz.getCurrentPage().getCurrentPageView().gnn.setOptionBtnStatus(aVar);
            this.glH = i;
            this.glI = aVar;
            int i2 = this.glG + 1;
            this.glG = i2;
            return i2;
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public void ln(int i) {
        x.i("MicroMsg.AppBrandActionBarSubTitleHintHelper", "dismissBlink, seq: %d, currentSeq: %d, status: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(this.glG), this.glI});
        if (i == this.glG) {
            try {
                this.fdD.fcz.getCurrentPage().getCurrentPageView().ks(0);
                p.runOnUiThread(new p$18(this.fdD.fcz.getCurrentPage().getCurrentPageView(), a.glL));
            } catch (NullPointerException e) {
            }
            this.glH = 0;
            this.glI = a.glL;
        }
    }
}
