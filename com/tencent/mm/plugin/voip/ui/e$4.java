package com.tencent.mm.plugin.voip.ui;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class e$4 implements OnClickListener {
    final /* synthetic */ e oSe;

    e$4(e eVar) {
        this.oSe = eVar;
    }

    public final void onClick(View view) {
        boolean z;
        e.c(this.oSe, !e.k(this.oSe));
        e eVar = this.oSe;
        if (e.k(this.oSe)) {
            z = false;
        } else {
            z = true;
        }
        Point d = e.d(eVar, z);
        e.l(this.oSe).dU(d.x, d.y);
        x.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
        if ((this.oSe.oRO & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (!e.h(this.oSe)) {
                this.oSe.oRL.setVisibility(4);
                this.oSe.oQr.removeView(this.oSe.oRL);
                this.oSe.oQr.addView(this.oSe.oRM);
                ((c) this.oSe.oQd.get()).a(this.oSe.oRM);
                e.a(this.oSe, true);
                x.i("MicroMsg.Voip.VoipVideoFragment", "steve: change hw texture view!");
            }
            e.l(this.oSe).setVisibility(4);
            this.oSe.oRM.setVisibility(0);
            this.oSe.oRM.bringToFront();
            e.m(this.oSe).setVisibility(0);
        } else {
            e.l(this.oSe).setVisibility(0);
            this.oSe.oRM.setVisibility(4);
            e.l(this.oSe).bringToFront();
            e.m(this.oSe).setVisibility(0);
        }
        h.mEJ.h(11079, new Object[]{Integer.valueOf(3)});
    }
}
