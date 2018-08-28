package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.b;

class DynamicGridView$b$a implements OnPreDrawListener {
    private final int Sv;
    private final View omG;
    private final int omH;
    final /* synthetic */ b omI;

    DynamicGridView$b$a(b bVar, View view, int i, int i2) {
        this.omI = bVar;
        this.omG = view;
        this.omH = i;
        this.Sv = i2;
    }

    public final boolean onPreDraw() {
        this.omI.omz.getViewTreeObserver().removeOnPreDrawListener(this);
        this.omI.omz.olQ = this.omI.omz.olQ + b.a(this.omI);
        this.omI.omz.olR = this.omI.omz.olR + b.b(this.omI);
        DynamicGridView.a(this.omI.omz, this.omH, this.Sv);
        this.omG.setVisibility(0);
        if (this.omI.omz.omr != null) {
            this.omI.omz.omr.setVisibility(4);
        }
        return true;
    }
}
