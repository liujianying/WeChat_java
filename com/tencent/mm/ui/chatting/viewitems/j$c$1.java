package com.tencent.mm.ui.chatting.viewitems;

import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ui.chatting.viewitems.j.a;
import com.tencent.mm.ui.chatting.viewitems.j.c;

class j$c$1 implements Runnable {
    final /* synthetic */ a ubn;
    final /* synthetic */ c ubp;

    j$c$1(c cVar, a aVar) {
        this.ubp = cVar;
        this.ubn = aVar;
    }

    public final void run() {
        this.ubn.jBN.setLayoutParams(new LayoutParams(-2, -2));
        this.ubn.jBT.setLayoutParams(new LayoutParams(this.ubn.jBN.getWidth(), this.ubn.jBN.getHeight()));
    }
}
