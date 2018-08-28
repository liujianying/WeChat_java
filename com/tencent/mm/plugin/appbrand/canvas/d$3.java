package com.tencent.mm.plugin.appbrand.canvas;

import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import org.json.JSONArray;

class d$3 implements Runnable {
    final /* synthetic */ d fna;
    final /* synthetic */ JSONArray fnb;
    final /* synthetic */ a fnc;

    d$3(d dVar, JSONArray jSONArray, a aVar) {
        this.fna = dVar;
        this.fnb = jSONArray;
        this.fnc = aVar;
    }

    public final void run() {
        this.fna.fmO = this.fnb;
        this.fna.fmN = true;
        if (this.fnc != null) {
            this.fnc.adq();
        }
    }
}
