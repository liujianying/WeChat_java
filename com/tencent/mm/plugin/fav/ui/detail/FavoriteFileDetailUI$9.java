package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;

class FavoriteFileDetailUI$9 implements OnClickListener {
    final /* synthetic */ FavoriteFileDetailUI jcx;

    FavoriteFileDetailUI$9(FavoriteFileDetailUI favoriteFileDetailUI) {
        this.jcx = favoriteFileDetailUI;
    }

    public final void onClick(View view) {
        String b = b.b(FavoriteFileDetailUI.a(this.jcx));
        if (4 == FavoriteFileDetailUI.c(this.jcx)) {
            FavoriteFileDetailUI.d(this.jcx);
            FavoriteFileDetailUI.e(this.jcx);
            return;
        }
        FavoriteFileDetailUI.a(this.jcx, b);
    }
}
