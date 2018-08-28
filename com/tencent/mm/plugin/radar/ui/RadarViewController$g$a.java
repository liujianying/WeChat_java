package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.plugin.radar.ui.RadarViewController.g;
import com.tencent.mm.protocal.c.beq;

final class RadarViewController$g$a implements Runnable {
    final /* synthetic */ beq mlh;
    final /* synthetic */ g mnd;
    final /* synthetic */ View mne;
    final /* synthetic */ e mnf;

    RadarViewController$g$a(g gVar, View view, beq beq, e eVar) {
        this.mnd = gVar;
        this.mne = view;
        this.mlh = beq;
        this.mnf = eVar;
    }

    public final void run() {
        RadarViewController.g(this.mnd.mmN).a(this.mne, this.mlh, this.mnf);
        RadarViewController.f(this.mnd.mmN).bpP();
    }
}
