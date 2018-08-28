package com.tencent.mm.plugin.sns.ui;

import android.graphics.BitmapFactory.Options;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.sdk.platformtools.c;

class SnsBrowseUI$3 implements OnPreDrawListener {
    final /* synthetic */ SnsBrowseUI nTH;

    SnsBrowseUI$3(SnsBrowseUI snsBrowseUI) {
        this.nTH = snsBrowseUI;
    }

    public final boolean onPreDraw() {
        this.nTH.nTu.getViewTreeObserver().removeOnPreDrawListener(this);
        SnsBrowseUI.a(this.nTH, this.nTH.nTu.getWidth());
        SnsBrowseUI.b(this.nTH, this.nTH.nTu.getHeight());
        SnsBrowseUI.c(this.nTH, this.nTH.nTu.getWidth());
        SnsBrowseUI.d(this.nTH, this.nTH.nTu.getHeight());
        af.byl();
        String C = g.C(this.nTH.nTu.getCntMedia());
        if (C != null) {
            Options VZ = c.VZ(C);
            SnsBrowseUI.d(this.nTH, (int) (((float) VZ.outHeight) * (((float) SnsBrowseUI.b(this.nTH)) / ((float) VZ.outWidth))));
            if (SnsBrowseUI.c(this.nTH) > this.nTH.nTu.getHeight()) {
                SnsBrowseUI.d(this.nTH, this.nTH.nTu.getHeight());
            }
        }
        this.nTH.hDi.fh(SnsBrowseUI.b(this.nTH), SnsBrowseUI.c(this.nTH));
        this.nTH.hDi.a(this.nTH.nTu, SnsBrowseUI.d(this.nTH), null);
        this.nTH.bCZ();
        return true;
    }
}
