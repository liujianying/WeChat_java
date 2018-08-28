package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.appbrand.jsapi.k.b.1;
import com.tencent.mm.plugin.appbrand.widget.c.b;
import java.util.HashMap;
import java.util.Map;

class b$1$1 implements OnItemClickListener {
    final /* synthetic */ b fXE;
    final /* synthetic */ 1 fXF;

    b$1$1(1 1, b bVar) {
        this.fXF = 1;
        this.fXE = bVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Map hashMap = new HashMap();
        hashMap.put("tapIndex", Integer.valueOf(i));
        this.fXF.fCl.E(this.fXF.doP, this.fXF.fXD.f("ok", hashMap));
        this.fXE.dismiss();
    }
}
