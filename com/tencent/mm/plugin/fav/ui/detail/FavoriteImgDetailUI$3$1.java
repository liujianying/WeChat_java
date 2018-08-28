package com.tencent.mm.plugin.fav.ui.detail;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.3;

class FavoriteImgDetailUI$3$1 implements Runnable {
    final /* synthetic */ Bitmap jcY;
    final /* synthetic */ 3 jcZ;

    FavoriteImgDetailUI$3$1(3 3, Bitmap bitmap) {
        this.jcZ = 3;
        this.jcY = bitmap;
    }

    public final void run() {
        FavoriteImgDetailUI.a(this.jcZ.jcT, this.jcZ.jcX, this.jcY);
    }

    public final String toString() {
        return super.toString() + "|renderView";
    }
}
