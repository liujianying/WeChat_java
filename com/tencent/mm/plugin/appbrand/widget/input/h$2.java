package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.jsapi.d.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.z.b;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class h$2 implements b {
    final /* synthetic */ WeakReference fQJ;
    final /* synthetic */ h gGK;
    final /* synthetic */ c gGM;
    final /* synthetic */ String gGN;

    public h$2(h hVar, WeakReference weakReference, c cVar, String str) {
        this.gGK = hVar;
        this.fQJ = weakReference;
        this.gGM = cVar;
        this.gGN = str;
    }

    public final boolean lV(int i) {
        if (i != 67) {
            return false;
        }
        p pVar = (p) this.fQJ.get();
        if (pVar != null) {
            try {
                int inputId = this.gGM.getInputId();
                f.b bVar = new f.b();
                JSONObject put = new JSONObject().put("value", "").put("data", this.gGN).put("cursor", 0).put("inputId", inputId).put("keyCode", 8);
                h a = bVar.a(pVar);
                a.mData = put.toString();
                a.ahM();
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandInputJsApiHandler", "onKeyUpPostIme DEL, e = %s", new Object[]{e});
            }
        }
        return true;
    }
}
