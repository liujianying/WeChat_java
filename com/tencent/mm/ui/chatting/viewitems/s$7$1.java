package com.tencent.mm.ui.chatting.viewitems;

import android.text.TextUtils;
import com.tencent.mm.ak.o;
import com.tencent.mm.ui.chatting.viewitems.s.7;

class s$7$1 implements Runnable {
    final /* synthetic */ String gtU;
    final /* synthetic */ String ucA;
    final /* synthetic */ 7 ucB;

    s$7$1(7 7, String str, String str2) {
        this.ucB = 7;
        this.gtU = str;
        this.ucA = str2;
    }

    public final void run() {
        o.Pj().a(this.gtU, this.ucB.ucz.ugw, s.f(this.ucB.ucn));
        this.ucB.ucz.ugx.setText(TextUtils.isEmpty(this.ucA) ? this.ucB.ucv : this.ucA);
    }
}
