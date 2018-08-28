package com.tencent.mm.plugin.appbrand.canvas;

import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import org.json.JSONArray;

class d$4 implements Runnable {
    final /* synthetic */ d fna;
    final /* synthetic */ JSONArray fnb;
    final /* synthetic */ a fnc;

    d$4(d dVar, JSONArray jSONArray, a aVar) {
        this.fna = dVar;
        this.fnb = jSONArray;
        this.fnc = aVar;
    }

    public final void run() {
        if (this.fna.fmO == null) {
            this.fna.fmO = this.fnb;
        } else {
            for (int i = 0; i < this.fnb.length(); i++) {
                this.fna.fmO.put(this.fnb.opt(i));
            }
        }
        this.fna.fmN = true;
        if (this.fnc != null) {
            this.fnc.adq();
        }
    }
}
