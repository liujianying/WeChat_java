package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.offline.c.a;

class OfflineAlertView$4 implements OnClickListener {
    final /* synthetic */ OfflineAlertView lKX;

    OfflineAlertView$4(OfflineAlertView offlineAlertView) {
        this.lKX = offlineAlertView;
    }

    public final void onClick(View view) {
        a.dY(this.lKX.getContext());
    }
}
