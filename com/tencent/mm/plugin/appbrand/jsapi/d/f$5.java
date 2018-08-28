package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.jsapi.d.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class f$5 extends AppBrandInputInvokeHandler {
    final /* synthetic */ int doP;
    final /* synthetic */ WeakReference fQJ;
    final /* synthetic */ String fQK;
    final /* synthetic */ f fQP;

    f$5(f fVar, WeakReference weakReference, int i, String str) {
        this.fQP = fVar;
        this.fQJ = weakReference;
        this.doP = i;
        this.fQK = str;
    }

    public final void onInputDone(String str, int i, boolean z, boolean z2) {
        if (this.fQP.aiW()) {
            c.az(this);
        }
        if (this.fQJ.get() != null) {
            try {
                String jSONObject = new JSONObject().put("value", c.vT(str)).put("inputId", getInputId()).put("cursor", i).toString();
                if (z) {
                    ((p) this.fQJ.get()).j("onKeyboardConfirm", jSONObject, 0);
                }
                if (!z2) {
                    ((p) this.fQJ.get()).j("onKeyboardComplete", jSONObject, 0);
                }
            } catch (Throwable e) {
                x.e("MicroMsg.JsApiShowKeyboard", "dispatch input done, exp = %s", new Object[]{bi.i(e)});
            }
            if (!z2) {
                aiX();
            }
        }
    }

    public final void onInputInitialized() {
        if (this.fQJ.get() != null) {
            int inputId = getInputId();
            Map hashMap = new HashMap(1);
            hashMap.put("inputId", Integer.valueOf(inputId));
            ((p) this.fQJ.get()).E(this.doP, this.fQP.f("ok", hashMap));
            f.L(inputId, this.fQK);
            f.a(inputId, (p) this.fQJ.get());
        }
    }

    public final void onRuntimeFail() {
        c.az(this);
        if (this.fQJ.get() != null) {
            ((p) this.fQJ.get()).E(this.doP, this.fQP.f("fail", null));
            aiX();
        }
    }

    public final void onBackspaceWhenValueEmpty() {
        p pVar = (p) this.fQJ.get();
        if (pVar != null) {
            try {
                int inputId = getInputId();
                b bVar = new b();
                JSONObject put = new JSONObject().put("value", "").put("data", f.kJ(inputId)).put("cursor", 0).put("inputId", inputId).put("keyCode", 8);
                h a = bVar.a(pVar);
                a.mData = put.toString();
                a.ahM();
            } catch (Exception e) {
                x.e("MicroMsg.JsApiShowKeyboard", "onBackspaceWhenValueEmpty, e = %s", new Object[]{e});
            }
        }
    }

    public final void kL(int i) {
        try {
            p pVar = (p) this.fQJ.get();
            if (pVar != null) {
                pVar.j("onKeyboardShow", g.Dc().D("inputId", getInputId()).D("height", f.lO(i)).toString(), 0);
            }
        } catch (Exception e) {
        }
    }

    private void aiX() {
        p pVar = (p) this.fQJ.get();
        if (pVar != null && pVar.gns != null) {
            com.tencent.mm.plugin.appbrand.widget.input.g.apm().p(pVar.gns);
        }
    }
}
