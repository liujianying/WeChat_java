package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.e.b.h;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.bottle.a.h.a;
import junit.framework.Assert;

public class h$d extends h implements e {
    public a hka = null;
    private int hkd = 0;

    public h$d(Context context, a aVar) {
        boolean z = false;
        super(context, false);
        String str = "must call back onFin";
        if (aVar != null) {
            z = true;
        }
        Assert.assertTrue(str, z);
        au.DF().a(JsApiMakeVoIPCall.CTRL_INDEX, this);
        this.hka = aVar;
    }

    public final boolean wk() {
        String fileName = super.getFileName();
        boolean wk = super.wk();
        super.reset();
        if (!wk) {
            au.DF().b(JsApiMakeVoIPCall.CTRL_INDEX, this);
            this.hka = null;
            return false;
        } else if (c.auc() > 0) {
            au.DF().a(new g(fileName, this.bER), 0);
            return true;
        } else {
            au.DF().b(JsApiMakeVoIPCall.CTRL_INDEX, this);
            if (this.hka == null) {
                return false;
            }
            this.hka.ci(1, 16);
            return false;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == JsApiMakeVoIPCall.CTRL_INDEX) {
            if (this.hka != null) {
                this.hkd = ((g) lVar).aui();
                this.hka.ci(i, i2);
            }
            this.hka = null;
            au.DF().b(JsApiMakeVoIPCall.CTRL_INDEX, this);
        }
    }
}
