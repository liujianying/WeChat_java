package com.tencent.mm.d;

import android.graphics.Rect;
import com.tencent.mm.cache.a;
import com.tencent.mm.view.b.a.b;

class c$1 implements b {
    final /* synthetic */ c bCc;

    c$1(c cVar) {
        this.bCc = cVar;
    }

    public final void vU() {
        if (((a) this.bCc.vG()).dak.isIdentity()) {
            a aVar = (a) this.bCc.vG();
            aVar.dak.set(this.bCc.getMainMatrix());
        }
        Rect rect = new Rect();
        if (this.bCc.bBn.cfS() == null) {
            rect.set(0, 0, this.bCc.bBn.cfQ().getBaseBoardView().getBoardRect().width(), this.bCc.bBn.cfQ().getBaseBoardView().getBoardRect().height());
        } else {
            rect.set(0, 0, this.bCc.bBn.cfS().getWidth(), this.bCc.bBn.cfS().getHeight());
        }
        this.bCc.bBn.cfQ().getBaseBoardView().m(rect);
        c.a(this.bCc, 200, true, false);
        this.bCc.vP();
    }

    public final void onStart() {
        c.a(this.bCc, false);
        this.bCc.bBQ = false;
    }
}
