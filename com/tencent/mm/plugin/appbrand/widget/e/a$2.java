package com.tencent.mm.plugin.appbrand.widget.e;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

class a$2 implements Runnable {
    final /* synthetic */ JSONObject fHi;
    final /* synthetic */ p fJO;
    final /* synthetic */ int fKG;
    final /* synthetic */ f fPe;
    final /* synthetic */ a gMm;
    final /* synthetic */ View val$view;

    a$2(a aVar, p pVar, int i, View view, JSONObject jSONObject, f fVar) {
        this.gMm = aVar;
        this.fJO = pVar;
        this.fKG = i;
        this.val$view = view;
        this.fHi = jSONObject;
        this.fPe = fVar;
    }

    public final void run() {
        this.gMm.a(this.fJO, this.fHi, a.aql(), this.fPe);
    }
}
