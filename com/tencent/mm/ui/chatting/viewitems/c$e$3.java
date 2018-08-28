package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.ak.a.c.g;
import com.tencent.mm.ak.a.d.b;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.c.e;

class c$e$3 implements g {
    final /* synthetic */ a tZG;
    final /* synthetic */ c$c uaC;
    final /* synthetic */ e uaF;

    c$e$3(e eVar, c$c c_c, a aVar) {
        this.uaF = eVar;
        this.uaC = c_c;
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
