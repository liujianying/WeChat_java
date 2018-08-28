package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ExdeviceRankListHeaderView$1 implements OnClickListener {
    final /* synthetic */ ExdeviceRankListHeaderView iFP;

    ExdeviceRankListHeaderView$1(ExdeviceRankListHeaderView exdeviceRankListHeaderView) {
        this.iFP = exdeviceRankListHeaderView;
    }

    public final void onClick(View view) {
        if (ExdeviceRankListHeaderView.a(this.iFP)) {
            ExdeviceRankListHeaderView.b(this.iFP);
        }
        if (ExdeviceRankListHeaderView.c(this.iFP) != null) {
            ExdeviceRankListHeaderView.c(this.iFP).onClick(this.iFP);
        }
    }
}
