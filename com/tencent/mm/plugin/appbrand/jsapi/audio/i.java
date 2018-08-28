package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.Vector;
import org.json.JSONObject;

public final class i extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 295;
    public static final String NAME = "operateRecorder";
    private static Vector<String> fHT = new Vector();
    private b fIC;
    private p fID;
    private int fIE;
    private b fIs;

    public static final class a extends h {
        private static final int CTRL_INDEX = 296;
        private static final String NAME = "onRecorderStateChange";
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        boolean z;
        com.tencent.mm.plugin.appbrand.a.a(lVar.mAppId, new 3(this, lVar, jSONObject, i));
        MMActivity c = c(lVar);
        if (c == null) {
            x.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, pageContext is null");
            lVar.E(i, f("fail", null));
            z = false;
        } else {
            z = com.tencent.mm.pluginsdk.permission.a.a(c, "android.permission.RECORD_AUDIO", 116, "", "");
            if (z) {
                com.tencent.mm.plugin.appbrand.a.pZ(lVar.mAppId);
            }
        }
        if (z) {
            this.fID = d(lVar);
            if (this.fID == null) {
                lVar.E(i, f("fail", null));
                return;
            } else if (jSONObject == null) {
                x.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, data is null");
                lVar.E(i, f("fail:data is null", null));
                return;
            } else {
                String str = lVar.mAppId;
                x.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder appId:%s, data:%s", new Object[]{str, jSONObject.toString()});
                if (this.fIC == null) {
                    this.fIC = new b(this, lVar, i);
                }
                this.fIC.fFd = i;
                this.fIC.appId = str;
                this.fIC.fII = jSONObject.toString();
                this.fIC.processName = ad.getProcessName();
                if (this.fIs == null) {
                    this.fIs = new 1(this, str, lVar, i);
                }
                this.fIC.fIs = this.fIs;
                this.fIC.ahT();
                return;
            }
        }
        x.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, requestPermission fail");
        lVar.E(i, f("fail:system permission denied", null));
    }
}
