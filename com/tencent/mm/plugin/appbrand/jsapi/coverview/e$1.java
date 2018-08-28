package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.e.a;
import com.tencent.mm.plugin.appbrand.page.p;
import java.util.HashMap;
import java.util.Map;

class e$1 implements OnClickListener {
    final /* synthetic */ b fIk;
    final /* synthetic */ p fJO;
    final /* synthetic */ e fPP;

    e$1(e eVar, b bVar, p pVar) {
        this.fPP = eVar;
        this.fIk = bVar;
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
