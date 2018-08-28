package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.ak.a.c.g;
import com.tencent.mm.ak.a.d.b;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.c.c;
import com.tencent.mm.ui.chatting.viewitems.c.d;

class c$d$3 implements g {
    final /* synthetic */ a tZG;
    final /* synthetic */ c uaC;
    final /* synthetic */ d uaD;

    c$d$3(d dVar, c cVar, a aVar) {
        this.uaD = dVar;
        this.uaC = cVar;
        this.tZG = aVar;
    }

    public final void me(String str) {
    }

    public final Bitmap a(String str, b bVar) {
        return null;
    }

    public final void a(String str, View view, b bVar) {
        if (bVar.bitmap != null) {
            this.uaC.uad.getViewTreeObserver().addOnPreDrawListener(new 1(this, bVar.bitmap));
        }
    }
}
