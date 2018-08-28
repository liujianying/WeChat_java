package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

class ad$5 implements Runnable {
    final /* synthetic */ ad nPa;

    ad$5(ad adVar) {
        this.nPa = adVar;
    }

    public final void run() {
        x.i("MicroMsg.SightWidget", "showProgress");
        ad adVar = this.nPa;
        MMActivity mMActivity = this.nPa.bGc;
        this.nPa.bGc.getString(i$j.app_tip);
        adVar.eHw = h.a(mMActivity, this.nPa.bGc.getString(i$j.sns_sight_send_wait), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                ad$5.this.nPa.nOW = null;
                ad$5.this.nPa.nOR = false;
                ah.M(ad$5.this.nPa.nOY);
            }
        });
    }
}
