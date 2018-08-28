package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.protocal.c.vx;

class FavoriteImgDetailUI$5 implements OnLongClickListener {
    final /* synthetic */ FavoriteImgDetailUI jcT;

    FavoriteImgDetailUI$5(FavoriteImgDetailUI favoriteImgDetailUI) {
        this.jcT = favoriteImgDetailUI;
    }

    public final boolean onLongClick(View view) {
        FavoriteImgDetailUI$a favoriteImgDetailUI$a = (FavoriteImgDetailUI$a) FavoriteImgDetailUI.c(this.jcT).get(((vx) view.getTag()).jdM);
        FavoriteImgDetailUI.a(this.jcT, favoriteImgDetailUI$a);
        if (!favoriteImgDetailUI$a.jda) {
            FavoriteImgDetailUI.b(favoriteImgDetailUI$a);
        }
        return true;
    }
}
