package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import org.json.JSONObject;

class b$a implements Runnable {
    String fvT;
    JSONObject fvU;
    b fvV;
    com.tencent.mm.u.b.b$a fvW;
    b fvX;
    String process;

    private b$a() {
    }

    /* synthetic */ b$a(byte b) {
        this();
    }

    public final void run() {
        synchronized (this.fvX) {
            this.fvX.p(this.fvV.sF("lastTime"), Long.valueOf(System.currentTimeMillis()));
        }
        Parcelable bundle = new Bundle();
        bundle.putString("viewId", this.fvT);
        bundle.putString("jsApiInvokeData", this.fvU.toString());
        String j = d.j(this.fvU);
        CollectSession aZ = c.aZ(j, "after_jsapi_invoke");
        bundle.putString("__session_id", j);
        bundle.putParcelable("__cost_time_session", aZ);
        f.a(this.process, bundle, b.b.class, new com.tencent.mm.ipcinvoker.c<Bundle>() {
            public final /* synthetic */ void at(Object obj) {
                Bundle bundle = (Bundle) obj;
                b$a.this.fvW.aA(b$a.this.fvV.a(bundle.getBoolean("ret"), bundle.getString("reason", ""), null));
            }
        });
    }
}
