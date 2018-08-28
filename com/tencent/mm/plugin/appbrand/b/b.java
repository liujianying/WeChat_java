package com.tencent.mm.plugin.appbrand.b;

import android.annotation.SuppressLint;
import android.support.v4.e.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.r.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class b {
    final String TAG;
    final g fdO;
    public final c fjj;
    public final a<a, b> fjk = new a();
    public final e fjl = new e() {
        @SuppressLint({"SwitchIntDef"})
        public final void onTrimMemory(int i) {
            switch (i) {
                case 5:
                    break;
                case 10:
                case 15:
                    if (i != 10) {
                        if (i == 15) {
                            h.mEJ.a(386, 7, 1, false);
                            break;
                        }
                    }
                    h.mEJ.a(386, 8, 1, false);
                    break;
                    break;
                default:
                    return;
            }
            g gVar = b.this.fdO;
            x.i("MicroMsg.AppBrandOnMemoryWarningReceiveEvent", "memory warning receive event dispatch, appId:%s, initialized:%b, level:%d", new Object[]{gVar.mAppId, Boolean.valueOf(gVar.dti), Integer.valueOf(i)});
            if (gVar.dti) {
                Map hashMap = new HashMap();
                hashMap.put("level", Integer.valueOf(i));
                new k().a(gVar.fcy).x(hashMap).ahM();
            }
            if (b.this.fjj.acv() == a.fjg && d.qVQ) {
                x.i(b.this.TAG, "onTrimMemory level %d, finishRuntime", new Object[]{Integer.valueOf(i)});
                b.a(b.this);
            }
        }
    };

    public b(g gVar) {
        this.TAG = String.format("MicroMsg.AppBrand.AppRunningStateController[%s]", new Object[]{gVar.mAppId});
        this.fdO = gVar;
        this.fjj = new 2(this, gVar);
    }

    public final void a(a aVar) {
        if (aVar != null && a.fjh != this.fjj.acv()) {
            synchronized (this.fjk) {
                this.fjk.put(aVar, this);
            }
        }
    }
}
