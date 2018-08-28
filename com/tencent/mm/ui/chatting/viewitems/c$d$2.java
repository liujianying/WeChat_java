package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.b.b$h;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.ui.chatting.viewitems.c.c;
import com.tencent.mm.ui.chatting.viewitems.c.d;

class c$d$2 implements b$h {
    final /* synthetic */ c uaC;
    final /* synthetic */ d uaD;

    c$d$2(d dVar, c cVar) {
        this.uaD = dVar;
        this.uaC = cVar;
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
