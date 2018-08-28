package com.tencent.mm.plugin.appbrand.g.a;

import android.util.Log;
import com.tencent.mm.plugin.appbrand.g.a.f.3;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.d;
import org.json.JSONObject;

class i$1 implements d {
    final /* synthetic */ f geC;
    final /* synthetic */ i geD;

    i$1(i iVar, f fVar) {
        this.geD = iVar;
        this.geC = fVar;
    }

    public final void aR(String str, String str2) {
        x.e("MicroMsg.V8EngineWorkerManager", "handleException(%s), stackTrace : %s", new Object[]{str, str2});
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", str);
            jSONObject.put("stack", str2);
        } catch (Throwable e) {
            x.e("MicroMsg.V8EngineWorkerManager", Log.getStackTraceString(e));
        }
        f fVar = this.geC;
        fVar.gem.r(new 3(fVar, String.format("WeixinWorker.errorHandler(%s)", new Object[]{jSONObject})));
    }
}
