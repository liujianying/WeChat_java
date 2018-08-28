package com.tencent.mm.plugin.voip.ui;

import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.sdk.platformtools.x;

class e$11 implements Runnable {
    final /* synthetic */ e oSe;

    e$11(e eVar) {
        this.oSe = eVar;
    }

    public final void run() {
        if (e.k(this.oSe)) {
            if (e.h(this.oSe)) {
                this.oSe.oRM.setVisibility(4);
                this.oSe.oRL.setVisibility(0);
                x.i("MicroMsg.Voip.VoipVideoFragment", "steve: change to big hw texture view!");
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(13);
                int indexOfChild = this.oSe.oQr.indexOfChild(e.m(this.oSe));
                this.oSe.oQr.removeView(this.oSe.oRM);
                this.oSe.oQr.addView(this.oSe.oRL, indexOfChild + 1, layoutParams);
                ((c) this.oSe.oQd.get()).a(this.oSe.oRL);
            }
            e.m(this.oSe).setVisibility(4);
            e.l(this.oSe).setVisibility(0);
            this.oSe.oRL.setVisibility(0);
            e.a(this.oSe, false);
            return;
        }
        if (!e.h(this.oSe)) {
            this.oSe.oRL.setVisibility(4);
            this.oSe.oQr.removeView(this.oSe.oRL);
            this.oSe.oQr.addView(this.oSe.oRM);
            ((c) this.oSe.oQd.get()).a(this.oSe.oRM);
        }
        e.l(this.oSe).setVisibility(4);
        this.oSe.oRM.setVisibility(0);
        this.oSe.oRM.bringToFront();
        e.m(this.oSe).setVisibility(0);
        e.a(this.oSe, true);
    }
}
