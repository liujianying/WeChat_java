package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.FavCleanUI.5.1;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

class FavCleanUI$5$1$1 implements Runnable {
    final /* synthetic */ List iYC;
    final /* synthetic */ Dialog iYD;
    final /* synthetic */ 1 iYE;

    FavCleanUI$5$1$1(1 1, List list, Dialog dialog) {
        this.iYE = 1;
        this.iYC = list;
        this.iYD = dialog;
    }

    public final void run() {
        b.bb(this.iYC);
        ah.A(new 1(this));
    }
}
