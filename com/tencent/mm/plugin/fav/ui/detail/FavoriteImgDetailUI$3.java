package com.tencent.mm.plugin.fav.ui.detail;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.a;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class FavoriteImgDetailUI$3 implements Runnable {
    final /* synthetic */ FavoriteImgDetailUI jcT;
    final /* synthetic */ a jcX;

    FavoriteImgDetailUI$3(FavoriteImgDetailUI favoriteImgDetailUI, a aVar) {
        this.jcT = favoriteImgDetailUI;
        this.jcX = aVar;
    }

    public final void run() {
        Bitmap a = k.a(this.jcX.bOz, FavoriteImgDetailUI.b(this.jcT), false);
        if (a == null) {
            x.d("MicroMsg.FavoriteImgDetailUI", "get big img fail");
            a = FavoriteImgDetailUI.a(this.jcT, this.jcX.bOz);
        }
        ah.A(new 1(this, a));
    }
}
