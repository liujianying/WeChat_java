package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.a;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class FavoriteImgDetailUI$6 implements c {
    final /* synthetic */ FavoriteImgDetailUI jcT;
    final /* synthetic */ a jcX;

    FavoriteImgDetailUI$6(FavoriteImgDetailUI favoriteImgDetailUI, a aVar) {
        this.jcT = favoriteImgDetailUI;
        this.jcX = aVar;
    }

    public final void a(l lVar) {
        if (FavoriteImgDetailUI.a(this.jcT)) {
            if (FavoriteImgDetailUI.b(this.jcT).aLd()) {
                lVar.e(2, this.jcT.mController.tml.getString(i.favorite_share_with_friend));
            }
            if (FavoriteImgDetailUI.b(this.jcT).aLe()) {
                lVar.e(1, this.jcT.mController.tml.getString(i.favorite_post_to_sns));
            }
            lVar.e(3, this.jcT.mController.tml.getString(i.favorite_save_image));
            if (!bi.oW(this.jcX.jdb)) {
                lVar.eR(4, com.tencent.mm.plugin.scanner.a.aB(this.jcX.bJr, this.jcX.jdb) ? i.favorite_reconize_image_wxcode : i.favorite_reconize_image_qrcode);
            }
        }
    }
}
