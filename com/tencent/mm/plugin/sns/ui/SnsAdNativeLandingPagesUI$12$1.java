package com.tencent.mm.plugin.sns.ui;

import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.12;
import com.tencent.mm.sdk.platformtools.x;

class SnsAdNativeLandingPagesUI$12$1 implements OnPreDrawListener {
    final /* synthetic */ RecyclerView nSW;
    final /* synthetic */ 12 nSX;

    SnsAdNativeLandingPagesUI$12$1(12 12, RecyclerView recyclerView) {
        this.nSX = 12;
        this.nSW = recyclerView;
    }

    public final boolean onPreDraw() {
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "afterOnCreateView %d, %d", new Object[]{Integer.valueOf(this.nSX.nSR.nHH.getHeight()), Integer.valueOf(this.nSX.nSR.hmW)});
        this.nSW.getViewTreeObserver().removeOnPreDrawListener(this);
        this.nSX.nSR.nSF = this.nSX.nSR.nSF - 1;
        SnsAdNativeLandingPagesUI.f(this.nSX.nSR);
        return true;
    }
}
