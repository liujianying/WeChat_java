package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.6;

class NearbySayHiListUI$6$1 implements OnCancelListener {
    final /* synthetic */ 6 lCD;

    NearbySayHiListUI$6$1(6 6) {
        this.lCD = 6;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(NearbySayHiListUI.f(this.lCD.lCB));
    }
}
