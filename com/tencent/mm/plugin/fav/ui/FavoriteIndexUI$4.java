package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

class FavoriteIndexUI$4 implements Runnable {
    final /* synthetic */ List iYC;
    final /* synthetic */ Dialog iYD;
    final /* synthetic */ FavoriteIndexUI jbh;
    final /* synthetic */ String[] jbk;

    FavoriteIndexUI$4(FavoriteIndexUI favoriteIndexUI, List list, String[] strArr, Dialog dialog) {
        this.jbh = favoriteIndexUI;
        this.iYC = list;
        this.jbk = strArr;
        this.iYD = dialog;
    }

    public final void run() {
        FavoriteIndexUI.a(this.iYC, this.jbk);
        ah.A(new 1(this));
    }
}
