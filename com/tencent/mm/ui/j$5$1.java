package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.j.5;

class j$5$1 implements Runnable {
    final /* synthetic */ DialogInterface tjh;
    final /* synthetic */ 5 tji;

    j$5$1(5 5, DialogInterface dialogInterface) {
        this.tji = 5;
        this.tjh = dialogInterface;
    }

    public final void run() {
        au.HU();
        if (c.isSDCardAvailable()) {
            Intent intent = new Intent();
            intent.putExtra("had_detected_no_sdcard_space", true);
            d.b(this.tji.tjf.tiY, "clean", ".ui.CleanUI", intent);
        } else {
            s.gH(this.tji.tjf.tiY);
        }
        this.tjh.dismiss();
        h.mEJ.a(282, 1, 1, false);
    }
}
