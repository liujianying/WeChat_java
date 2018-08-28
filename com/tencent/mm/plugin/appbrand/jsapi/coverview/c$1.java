package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.u$b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.c.a;
import com.tencent.mm.plugin.appbrand.page.p;
import java.util.HashMap;
import java.util.Map;

class c$1 implements OnClickListener {
    final /* synthetic */ u$b fIk;
    final /* synthetic */ p fJO;
    final /* synthetic */ c fPL;

    c$1(c cVar, u$b u_b, p pVar) {
        this.fPL = cVar;
        this.fIk = u_b;
        this.fJO = pVar;
    }

    public final void onClick(View view) {
        if (this.fIk.ie("clickable")) {
            a aVar = new a((byte) 0);
            Map hashMap = new HashMap();
            hashMap.put("data", this.fIk.getString("data", ""));
            aVar.a(this.fJO);
            aVar.x(hashMap);
            if ("webview".equals(this.fIk.getString("sendTo", null))) {
                aVar.h(new int[]{this.fJO.hashCode()});
                return;
            }
            aVar.ahM();
        }
    }
}
