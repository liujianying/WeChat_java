package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.plugin.sns.ui.j.1;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class j$1$1 implements Runnable {
    int count = 20;
    final /* synthetic */ int hW;
    final /* synthetic */ int nMc;
    final /* synthetic */ int nMd;
    final /* synthetic */ 1 nMe;
    final /* synthetic */ View val$view;

    j$1$1(1 1, int i, int i2, int i3, View view) {
        this.nMe = 1;
        this.hW = i;
        this.nMc = i2;
        this.nMd = i3;
        this.val$view = view;
    }

    public final void run() {
        this.nMe.nMb.kww.setSelectionFromTop(this.hW + this.nMe.nMb.kww.getHeaderViewsCount(), this.nMc + this.nMd);
        this.count--;
        x.d("MicroMsg.TimelineClickListener", "count: %s, delt: %s", new Object[]{Integer.valueOf(this.count), Integer.valueOf(Math.abs(this.val$view.getTop() - (this.nMc + this.nMd)))});
        if (this.count <= 0 || Math.abs(this.val$view.getTop() - (this.nMc + this.nMd)) < 5) {
            x.d("MicroMsg.TimelineClickListener", "count: %s", new Object[]{Integer.valueOf(this.count)});
            this.nMe.nMb.nuc.notifyDataSetChanged();
            return;
        }
        new ag().postDelayed(this, 5);
    }
}
