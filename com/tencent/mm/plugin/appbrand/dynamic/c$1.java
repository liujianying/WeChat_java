package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.sv;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c fuB;

    c$1(c cVar) {
        this.fuB = cVar;
    }

    public final void a(int i, int i2, String str, b bVar) {
        x.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        s.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        g gVar = this.fuB.fut;
        if (i == 0 && i2 == 0) {
            if (this.fuB.fuq == 1 && !this.fuB.fux) {
                this.fuB.fux = true;
                h.mEJ.h(14452, new Object[]{this.fuB.fuu + "-" + this.fuB.appId, Integer.valueOf(9), Long.valueOf(System.currentTimeMillis())});
            }
            sv svVar = (sv) bVar.dIE.dIL;
            String cfV = svVar.rwb != null ? svVar.rwb.cfV() : "";
            if (gVar != null) {
                if (!bi.oW(cfV)) {
                    gVar.field_data = cfV;
                } else if (this.fuB.fut == null || TextUtils.isEmpty(this.fuB.fut.field_data)) {
                    j.aeV().C(this.fuB.doU, 627, 4);
                }
                gVar.field_interval = svVar.djl;
                gVar.field_updateTime = System.currentTimeMillis();
                Bundle bundle = (Bundle) f.a("com.tencent.mm", gVar.wH(), com.tencent.mm.plugin.appbrand.dynamic.j.b.b.class);
                if (bundle != null) {
                    bundle.getBoolean("result", false);
                }
                if (this.fuB.Sx) {
                    c.a(this.fuB.doR, gVar);
                    if (this.fuB.fuq == 1 && !this.fuB.fuy) {
                        this.fuB.fuy = true;
                        h.mEJ.h(14452, new Object[]{this.fuB.fuu + "-" + this.fuB.appId, Integer.valueOf(11), Long.valueOf(System.currentTimeMillis())});
                    }
                    if (gVar.field_interval > 0) {
                        this.fuB.aeP();
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.DynamicPageViewIPCProxy", "not running");
                return;
            }
            return;
        }
        h.mEJ.a(638, 0, 1, false);
        if (this.fuB.fuq == 1 && !this.fuB.fux) {
            h.mEJ.h(14452, new Object[]{this.fuB.fuu + "-" + this.fuB.appId, Integer.valueOf(10), Long.valueOf(System.currentTimeMillis())});
        }
        b.e(this.fuB.fuA, (gVar != null ? (long) gVar.field_interval : 10) * 1000);
        if (this.fuB.fut == null || TextUtils.isEmpty(this.fuB.fut.field_data)) {
            j.aeV().C(this.fuB.doU, 627, 2);
        }
    }
}
