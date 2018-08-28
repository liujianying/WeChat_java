package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import com.tencent.mm.bg.d;

class b$3 implements Runnable {
    final /* synthetic */ b lYu;

    b$3(b bVar) {
        this.lYu = bVar;
    }

    public final void run() {
        this.lYu.ay(4, null);
        if (this.lYu.lYs.getIntent().getIntExtra("Kdel_from", -1) == 1) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            d.b(this.lYu.lYs, "shake", ".ui.ShakeReportUI", intent);
        }
    }
}
