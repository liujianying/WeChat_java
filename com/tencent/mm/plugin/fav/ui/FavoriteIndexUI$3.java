package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

class FavoriteIndexUI$3 implements Runnable {
    final /* synthetic */ List iYC;
    final /* synthetic */ Dialog iYD;
    final /* synthetic */ FavoriteIndexUI jbh;

    FavoriteIndexUI$3(FavoriteIndexUI favoriteIndexUI, List list, Dialog dialog) {
        this.jbh = favoriteIndexUI;
        this.iYC = list;
        this.iYD = dialog;
    }

    public final void run() {
        b.bb(this.iYC);
        ah.A(new 1(this));
    }
}
