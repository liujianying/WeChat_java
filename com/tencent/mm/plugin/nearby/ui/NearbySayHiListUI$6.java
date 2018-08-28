package com.tencent.mm.plugin.nearby.ui;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.ui.base.h;

class NearbySayHiListUI$6 implements OnClickListener {
    final /* synthetic */ NearbySayHiListUI lCB;

    NearbySayHiListUI$6(NearbySayHiListUI nearbySayHiListUI) {
        this.lCB = nearbySayHiListUI;
    }

    public final void onClick(View view) {
        NearbySayHiListUI.a(this.lCB, new c(2, 0.0f, 0.0f, 0, 0, "", ""));
        au.DF().a(NearbySayHiListUI.f(this.lCB), 0);
        NearbySayHiListUI nearbySayHiListUI = this.lCB;
        ActionBarActivity actionBarActivity = this.lCB.mController.tml;
        this.lCB.getString(R.l.app_tip);
        NearbySayHiListUI.a(nearbySayHiListUI, h.a(actionBarActivity, this.lCB.getString(R.l.nearby_friend_clearing_location), true, new 1(this)));
        com.tencent.mm.plugin.report.service.h.mEJ.k(11429, "0");
    }
}
