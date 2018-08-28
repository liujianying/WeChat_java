package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class IPCallShareCouponCardUI$16 implements OnClickListener {
    final /* synthetic */ IPCallShareCouponCardUI kyi;

    IPCallShareCouponCardUI$16(IPCallShareCouponCardUI iPCallShareCouponCardUI) {
        this.kyi = iPCallShareCouponCardUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        IPCallShareCouponCardUI iPCallShareCouponCardUI = this.kyi;
        ActionBarActivity actionBarActivity = this.kyi.mController.tml;
        this.kyi.mController.tml.getString(R.l.app_tip);
        IPCallShareCouponCardUI.a(iPCallShareCouponCardUI, h.a(actionBarActivity, this.kyi.mController.tml.getString(R.l.twitter_loading), true, new 1(this)));
        IPCallShareCouponCardUI.c(this.kyi).a(this.kyi, this.kyi.mController.tml);
    }
}
