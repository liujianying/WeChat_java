package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.b.b.h;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.ui.chatting.viewitems.c.e;

class c$e$2 implements h {
    final /* synthetic */ c$c uaC;
    final /* synthetic */ e uaF;

    c$e$2(e eVar, c$c c_c) {
        this.uaF = eVar;
        this.uaC = c_c;
    }

    public final void Kc() {
    }

    public final void n(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            this.uaC.uar.setVisibility(4);
            this.uaC.uas.setVisibility(0);
            return;
        }
        this.uaC.uar.setImageBitmap(bitmap);
        this.uaC.uar.setVisibility(0);
        this.uaC.uas.setVisibility(4);
    }

    public final void Kd() {
    }

    public final String Ke() {
        return "CHAT#" + k.bq(this);
    }
}
