package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceLikeView$1 implements OnClickListener {
    final /* synthetic */ ExdeviceLikeView iDj;

    ExdeviceLikeView$1(ExdeviceLikeView exdeviceLikeView) {
        this.iDj = exdeviceLikeView;
    }

    public final void onClick(View view) {
        if (ExdeviceLikeView.a(this.iDj) == null || ExdeviceLikeView.a(this.iDj).aHU() || ExdeviceLikeView.b(this.iDj) != 0) {
            x.d("MicroMsg.ExdeviceLikeView", "hy: loading or has liked or consumed. abort event");
            return;
        }
        x.d("MicroMsg.ExdeviceLikeView", "click listener is not null");
        this.iDj.setSelfLikeState(ExdeviceLikeView.pj(ExdeviceLikeView.b(this.iDj)));
        if (ExdeviceLikeView.b(this.iDj) == 1) {
            ExdeviceLikeView.c(this.iDj);
        }
        if (ExdeviceLikeView.a(this.iDj) != null) {
            ExdeviceLikeView.a(this.iDj).ju(ExdeviceLikeView.b(this.iDj));
        }
    }
}
