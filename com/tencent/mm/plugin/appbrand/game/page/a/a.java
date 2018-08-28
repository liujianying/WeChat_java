package com.tencent.mm.plugin.appbrand.game.page.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.mm.plugin.appbrand.game.page.d;
import com.tencent.mm.plugin.appbrand.page.a.c;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;

public final class a implements c {
    private final d fDa;
    public int fDb = 0;

    public a(d dVar) {
        this.fDa = dVar;
    }

    public final void ahh() {
        this.fDb = com.tencent.mm.plugin.appbrand.page.a.c.a.gpo;
        cG(false);
        if (VERSION.SDK_INT >= 21 && (this.fDa.mContext instanceof Activity)) {
            Window window = ((Activity) this.fDa.mContext).getWindow();
            if (window != null) {
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
                ((b) this.fDa.gnn).dl(false);
            }
        }
    }

    public final void ahi() {
        this.fDb = com.tencent.mm.plugin.appbrand.page.a.c.a.gpp;
        cG(true);
        ((b) this.fDa.gnn).dl(true);
    }

    public final void agE() {
        if (this.fDb == 0) {
            this.fDb = this.fDa.fdO.fcv.foR.foW ? com.tencent.mm.plugin.appbrand.page.a.c.a.gpo : com.tencent.mm.plugin.appbrand.page.a.c.a.gpp;
        }
        switch (1.fDc[this.fDb - 1]) {
            case 1:
                ahh();
                return;
            case 2:
                ahi();
                return;
            default:
                return;
        }
    }

    private void cG(boolean z) {
        if (this.fDa.mContext instanceof Activity) {
            Window window = ((Activity) this.fDa.mContext).getWindow();
            if (z) {
                j.c(window, true);
            } else {
                j.c(window, false);
            }
        }
    }
}
