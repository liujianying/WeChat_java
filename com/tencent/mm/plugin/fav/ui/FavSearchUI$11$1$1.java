package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.fav.ui.FavSearchUI.11.1;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.snackbar.b;

class FavSearchUI$11$1$1 implements Runnable {
    final /* synthetic */ Dialog iYD;
    final /* synthetic */ 1 iZX;

    FavSearchUI$11$1$1(1 1, Dialog dialog) {
        this.iZX = 1;
        this.iYD = dialog;
    }

    public final void run() {
        if (this.iYD != null) {
            this.iYD.dismiss();
        }
        b.h(this.iZX.iZW.iZQ, this.iZX.iZW.iZQ.getString(i.fav_finish_sent));
        ah.i(new 1(this), 1800);
    }
}
