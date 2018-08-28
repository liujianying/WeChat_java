package com.tencent.mm.plugin.fav.ui.detail;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.14;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.base.h;

class FavoriteFileDetailUI$14$1 implements Runnable {
    final /* synthetic */ 14 jcI;

    FavoriteFileDetailUI$14$1(14 14) {
        this.jcI = 14;
    }

    public final void run() {
        h.i(this.jcI.jcx.mController.tml, i.video_file_play_faile, i.video_play_err);
        Bitmap a = k.a(FavoriteFileDetailUI.a(this.jcI.jcx), FavoriteFileDetailUI.b(this.jcI.jcx));
        ImageView imageView = (ImageView) this.jcI.jcx.findViewById(e.videoplayer_maskview);
        if (imageView != null) {
            imageView.setImageBitmap(a);
            imageView.setVisibility(0);
        }
    }
}
