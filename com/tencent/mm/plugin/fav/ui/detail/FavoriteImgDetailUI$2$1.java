package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.2;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class FavoriteImgDetailUI$2$1 implements c {
    final /* synthetic */ 2 jcU;

    FavoriteImgDetailUI$2$1(2 2) {
        this.jcU = 2;
    }

    public final void a(l lVar) {
        if (FavoriteImgDetailUI.a(this.jcU.jcT)) {
            lVar.e(2, this.jcU.jcT.getString(i.favorite_share_with_friend));
        }
        lVar.e(0, this.jcU.jcT.getString(i.favorite_edit_tag_tips));
        lVar.e(1, this.jcU.jcT.mController.tml.getString(i.app_delete));
    }
}
