package com.tencent.mm.plugin.topstory.ui.video;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class i {
    public boolean jMc;
    a oAb;
    boolean oAf;
    n oAg;
    ViewGroup oAh;

    public final void a(n nVar, boolean z) {
        if (this.jMc) {
            bId();
            return;
        }
        this.jMc = true;
        this.oAf = z;
        this.oAg = nVar;
        this.oAg.getControlBar().bIz();
        this.oAh.removeAllViews();
        if (this.oAg.getParent() != null) {
            ((ViewGroup) this.oAg.getParent()).removeView(this.oAg);
        }
        this.oAh.addView(this.oAg, new LayoutParams(-1, -1));
        this.oAg.setX(0.0f);
        this.oAg.setY(0.0f);
        bIc();
        if (this.oAb.bHN() || this.oAg.getPosition() + 1 < this.oAb.bHO().size()) {
            this.oAg.setShowFullScreenPlayNext(true);
        } else {
            this.oAg.setShowFullScreenPlayNext(false);
        }
        a.kB(6);
        com.tencent.mm.plugin.topstory.a.b.a aVar = this.oAb.bHU().oAm;
        if (aVar != null) {
            aVar.oyW = 1;
        }
    }

    public final void bIc() {
        if (this.oAh != null) {
            if (d.fS(19)) {
                this.oAh.setSystemUiVisibility(2);
            } else {
                this.oAh.setSystemUiVisibility(4098);
            }
        }
        this.oAb.baA().getWindow().addFlags(1024);
        if (this.oAf) {
            this.oAb.baA().setRequestedOrientation(0);
        } else {
            this.oAb.baA().setRequestedOrientation(8);
        }
        if (this.oAb.baA().getSupportActionBar() != null) {
            this.oAb.baA().getSupportActionBar().hide();
        }
    }

    public final void bId() {
        this.oAg.bIt();
        this.oAg.getControlBar().ajc();
        this.oAh.setSystemUiVisibility(0);
        this.oAh.removeView(this.oAg);
        this.oAb.baA().getWindow().clearFlags(1024);
        if (this.oAb.baA().getRequestedOrientation() == 0 || this.oAb.baA().getRequestedOrientation() == 6 || this.oAb.baA().getRequestedOrientation() == 8) {
            this.oAb.baA().setRequestedOrientation(1);
            if (this.oAb.baA().getSupportActionBar() != null) {
                this.oAb.baA().getSupportActionBar().hide();
            }
        }
        this.oAb.yf(this.oAg.getPosition());
        ah.i(new 1(this), 200);
    }
}
