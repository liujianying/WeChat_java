package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.w;

class j$1 implements OnClickListener {
    final /* synthetic */ j tOS;

    j$1(j jVar) {
        this.tOS = jVar;
    }

    public final void onClick(View view) {
        g gVar = (g) this.tOS.bAG.O(g.class);
        if (gVar.gt(((Long) view.getTag()).longValue())) {
            int boX = gVar.boX();
            ((w) this.tOS.bAG.O(w.class)).cvN();
            j.a(this.tOS).czQ();
            j.b(this.tOS).setVisibility(0);
            j.b(this.tOS).EO(boX);
        }
    }
}
