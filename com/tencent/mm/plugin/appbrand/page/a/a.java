package com.tencent.mm.plugin.appbrand.page.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;

@TargetApi(21)
public final class a implements c {
    private int fDb = com.tencent.mm.plugin.appbrand.page.a.c.a.gpo;
    final p fNZ;

    /* renamed from: com.tencent.mm.plugin.appbrand.page.a.a$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] fDc = new int[com.tencent.mm.plugin.appbrand.page.a.c.a.amf().length];

        static {
            try {
                fDc[com.tencent.mm.plugin.appbrand.page.a.c.a.gpo - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                fDc[com.tencent.mm.plugin.appbrand.page.a.c.a.gpp - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public a(p pVar) {
        this.fNZ = pVar;
    }

    public final void ahh() {
        cY(false);
    }

    private void cY(boolean z) {
        this.fDb = com.tencent.mm.plugin.appbrand.page.a.c.a.gpo;
        com.tencent.mm.ui.statusbar.a.u(this.fNZ.getContentView(), this.fNZ.fdO.fcv.foN.adV());
        if (this.fNZ.gnn instanceof b) {
            1 1 = new 1(this);
            if (z) {
                this.fNZ.getContentView().post(1);
            } else {
                1.run();
            }
        }
        if (this.fNZ.mContext instanceof Activity) {
            Window window = ((Activity) this.fNZ.mContext).getWindow();
            if (window != null) {
                window.clearFlags(1024);
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & -1025);
            }
        }
    }

    public final void ahi() {
        this.fDb = com.tencent.mm.plugin.appbrand.page.a.c.a.gpp;
        com.tencent.mm.ui.statusbar.a.u(this.fNZ.getContentView(), true);
        if (this.fNZ.gnn instanceof b) {
            ((b) this.fNZ.gnn).dl(true);
        }
        if (this.fNZ.mContext instanceof Activity) {
            Window window = ((Activity) this.fNZ.mContext).getWindow();
            if (window != null) {
                window.addFlags(1024);
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility((decorView.getSystemUiVisibility() | 1024) | 256);
            }
        }
    }

    public final void agE() {
        switch (AnonymousClass2.fDc[this.fDb - 1]) {
            case 1:
                cY(true);
                return;
            case 2:
                ahi();
                return;
            default:
                return;
        }
    }
}
