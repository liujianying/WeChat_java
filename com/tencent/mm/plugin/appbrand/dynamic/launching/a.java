package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.util.Base64;
import com.tencent.mm.ab.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.g.a.1;
import com.tencent.mm.plugin.appbrand.dynamic.k.b;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.protocal.c.aqn;
import com.tencent.mm.protocal.c.cgw;
import com.tencent.mm.protocal.c.chy;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Callable;

public final class a implements Callable<j> {
    final String appId;
    final int bPh;
    final int cbu;
    final int fwV;
    final String fwW;
    final int scene;

    public a(String str, int i, int i2, int i3, int i4, String str2) {
        this.appId = str;
        this.bPh = i;
        this.cbu = i2;
        this.scene = i3;
        this.fwV = i4;
        this.fwW = str2;
    }

    /* renamed from: afo */
    public final j call() {
        j jVar = new j();
        jVar.field_appId = this.appId;
        i abc = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.l(com.tencent.mm.plugin.appbrand.widget.a.a.class)).abc();
        if (abc == null) {
            return null;
        }
        chy chy = new chy();
        chy.rRb = b.ke(this.bPh);
        chy.riv = this.cbu;
        chy.sBT = this.fwV;
        chy.otY = this.scene;
        chy.sBU = 0;
        if (abc.a(jVar, new String[]{"appId", "pkgType", "widgetType"})) {
            if ((jVar.field_jsApiInfo != null) && jVar.field_launchAction != null && 1 == jVar.field_launchAction.qZk && jVar.field_versionInfo != null && jVar.field_versionInfo.riv >= this.cbu) {
                com.tencent.mm.bu.a.post(new 1(new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, false, chy)));
                return jVar;
            }
        }
        if (this.fwW != null && this.fwW.length() > 0) {
            try {
                aqn aqn = new aqn();
                aqn.aG(Base64.decode(this.fwW, 0));
                jVar = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.l(com.tencent.mm.plugin.appbrand.widget.a.a.class)).abc().a(this.appId, this.bPh, this.fwV, aqn);
                if (aqn.rTb != null) {
                    String ai = ((c) g.l(c.class)).aaN().ai(this.appId, this.bPh);
                    cgw cgw = new cgw();
                    cgw.sBd = ai;
                    cgw.riv = aqn.rTb.riv;
                    if (this.bPh == 10102) {
                        cgw.sBc = aqn.rTb.sAy;
                        ((c) g.l(c.class)).aaN().a(this.appId, cgw, this.bPh);
                    } else if (this.bPh == 10002) {
                        cgw.sBc = aqn.rTb.sAx;
                        ((c) g.l(c.class)).aaN().a(this.appId, cgw, this.bPh);
                    }
                }
                return jVar;
            } catch (Exception e) {
                x.e("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch data parse fail[%s]", new Object[]{this.fwW});
            }
        }
        com.tencent.mm.plugin.appbrand.dynamic.g.a aVar = new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, true, chy);
        com.tencent.mm.ab.a.a b = w.b(aVar.diG);
        aVar.a(b.errType, b.errCode, b.Yy, (aqn) b.dIv);
        return aVar.fxo;
    }
}
