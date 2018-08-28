package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.mm.plugin.appbrand.jsapi.k.b.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.widget.c.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import org.json.JSONObject;

class b$1 implements Runnable {
    final /* synthetic */ ArrayList dha;
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JSONObject fHi;
    final /* synthetic */ b fXD;

    b$1(b bVar, l lVar, JSONObject jSONObject, ArrayList arrayList, int i) {
        this.fXD = bVar;
        this.fCl = lVar;
        this.fHi = jSONObject;
        this.dha = arrayList;
        this.doP = i;
    }

    public final void run() {
        if (this.fCl.Sx) {
            MMActivity c = b.c(this.fCl);
            b bVar = new b(c);
            int aQ = f.aQ(this.fHi.optString("itemColor", ""), Color.parseColor("#000000"));
            View view = (ViewGroup) View.inflate(c, h.mm_list_dialog, null);
            bVar.setContentView(view);
            ListView listView = (ListView) view.findViewById(g.list);
            listView.setAdapter(new a(this.dha, aQ));
            listView.setOnItemClickListener(new 1(this, bVar));
            bVar.setOnCancelListener(new 2(this));
            this.fCl.fdO.a(bVar);
        }
    }
}
