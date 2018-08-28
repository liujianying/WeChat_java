package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;

class c$3 implements Runnable {
    final /* synthetic */ c lVT;

    c$3(c cVar) {
        this.lVT = cVar;
    }

    public final void run() {
        this.lVT.ay(4, null);
        if (this.lVT.bGc.getIntent().getIntExtra("Kdel_from", -1) == 1) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            d.b(this.lVT.bGc, "shake", ".ui.ShakeReportUI", intent);
        }
    }
}
