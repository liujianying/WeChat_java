package com.tencent.mm.plugin.webview.model;

import android.content.ContentValues;
import com.tencent.mm.bt.h;
import com.tencent.mm.g.c.cg;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.b;
import com.tencent.mm.sdk.platformtools.av.c;

public final class e implements c<Integer, Long> {
    public static final String[] diD = new String[]{i.a(fgt, "JsLogBlockList")};
    private static final a fgt = cg.wI();
    public final h dCZ;
    public final av<Integer, Long> pRc = new av(this, au.Em().lnJ.getLooper(), 100, 20, 300000, 1000);
    private long pRd;

    public e(h hVar) {
        this.dCZ = hVar;
    }

    public final void bTV() {
        this.pRc.li(true);
    }

    public final boolean Sc() {
        if (this.dCZ.inTransaction()) {
            return false;
        }
        this.pRd = this.dCZ.dO(Thread.currentThread().getId());
        if (this.pRd > 0) {
            return true;
        }
        return false;
    }

    public final void a(av<Integer, Long> avVar, b<Integer, Long> bVar) {
        switch (bVar.sIz) {
            case 1:
                ContentValues contentValues = new ContentValues(2);
                contentValues.put("logId", (Integer) bVar.qSV);
                contentValues.put("liftTime", (Long) bVar.values);
                this.dCZ.replace("JsLogBlockList", "logId", contentValues);
                return;
            case 2:
                this.dCZ.delete("JsLogBlockList", "logId=" + bVar.qSV, null);
                return;
            default:
                return;
        }
    }

    public final void Sd() {
        if (this.pRd > 0) {
            this.dCZ.gp(this.pRd);
        }
    }
}
