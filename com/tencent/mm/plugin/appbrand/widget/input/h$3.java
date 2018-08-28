package com.tencent.mm.plugin.appbrand.widget.input;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.d.f.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.ab.a;
import com.tencent.mm.plugin.appbrand.widget.input.h.5;
import com.tencent.mm.sdk.platformtools.bi;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class h$3 implements ab {
    final /* synthetic */ WeakReference fQJ;
    final /* synthetic */ int fQL;
    final /* synthetic */ h gGK;
    final /* synthetic */ c gGM;
    final /* synthetic */ String gGN;

    public h$3(h hVar, WeakReference weakReference, c cVar, int i, String str) {
        this.gGK = hVar;
        this.fQJ = weakReference;
        this.gGM = cVar;
        this.fQL = i;
        this.gGN = str;
    }

    public final void a(String str, int i, a aVar) {
        try {
            p pVar = (p) this.fQJ.get();
            if (pVar != null) {
                JSONObject put = new JSONObject().put("value", str).put("keyCode", ((z) this.gGM.aph()).getLastKeyPressed()).put("inputId", this.fQL).put("cursor", i);
                if (a.gIW.equals(aVar)) {
                    b bVar = new b();
                    bVar.aC(pVar.mAppId, pVar.hashCode());
                    bVar.mData = put.put(SlookAirButtonFrequentContactAdapter.DATA, this.gGN).toString();
                    bVar.ahM();
                    return;
                }
                String str2;
                switch (5.gGO[aVar.ordinal()]) {
                    case 1:
                        str2 = "onKeyboardComplete";
                        break;
                    case 2:
                        str2 = "onKeyboardConfirm";
                        break;
                    default:
                        str2 = null;
                        break;
                }
                if (!bi.oW(str2)) {
                    pVar.j(str2, put.toString(), 0);
                }
            }
        } catch (Exception e) {
        }
    }
}
