package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.m.i;

class FavoriteFileDetailUI$12 implements OnClickListener {
    final /* synthetic */ FavoriteFileDetailUI jcx;

    FavoriteFileDetailUI$12(FavoriteFileDetailUI favoriteFileDetailUI) {
        this.jcx = favoriteFileDetailUI;
    }

    public final void onClick(View view) {
        if (FavoriteFileDetailUI.b(this.jcx).isDownloading()) {
            b.d(FavoriteFileDetailUI.a(this.jcx));
            FavoriteFileDetailUI.h(this.jcx).setText(i.favorite_item_restart_download);
        } else {
            b.n(FavoriteFileDetailUI.b(this.jcx));
            FavoriteFileDetailUI.h(this.jcx).setText(i.favorite_item_restart_upload);
        }
        FavoriteFileDetailUI.i(this.jcx);
    }
}
