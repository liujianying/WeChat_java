package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.page.p;

class c$2 implements OnTouchListener {
    final /* synthetic */ b fIk;
    final /* synthetic */ p fJO;
    final /* synthetic */ c fPL;

    c$2(c cVar, b bVar, p pVar) {
        this.fPL = cVar;
        this.fIk = bVar;
        this.fJO = pVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        a.a(this.fJO, view, motionEvent, this.fIk.getString("data", ""), "webview".equals(this.fIk.getString("sendTo", null)));
        return true;
    }
}
