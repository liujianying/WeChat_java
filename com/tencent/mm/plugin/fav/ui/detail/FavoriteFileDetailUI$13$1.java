package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.13;
import com.tencent.mm.plugin.fav.ui.m$i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n$c;

class FavoriteFileDetailUI$13$1 implements n$c {
    final /* synthetic */ 13 jcE;

    FavoriteFileDetailUI$13$1(13 13) {
        this.jcE = 13;
    }

    public final void a(l lVar) {
        if (this.jcE.jcC) {
            FavoriteFileDetailUI.j(this.jcE.jcx);
            if (!k.h(FavoriteFileDetailUI.a(this.jcE.jcx)) && FavoriteFileDetailUI.a(this.jcE.jcx).rAw == 0) {
                if (this.jcE.bpX == 8) {
                    lVar.e(0, this.jcE.jcx.getString(m$i.favorite_share_with_friend));
                } else if (this.jcE.bpX == 15) {
                    lVar.e(0, this.jcE.jcx.getString(m$i.favorite_share_with_friend));
                    lVar.e(4, this.jcE.jcx.getString(m$i.save_video_to_local));
                } else if (this.jcE.bpX == 4) {
                    lVar.e(0, this.jcE.jcx.getString(m$i.favorite_share_with_friend));
                    lVar.e(4, this.jcE.jcx.getString(m$i.save_video_to_local));
                } else {
                    lVar.e(0, this.jcE.jcx.getString(m$i.favorite_share_with_friend));
                    if (this.jcE.jcD && FavoriteFileDetailUI.b(this.jcE.jcx).aLe()) {
                        lVar.e(1, this.jcE.jcx.getString(m$i.favorite_post_to_sns));
                    }
                }
            }
        }
        if (this.jcE.jcD) {
            lVar.e(3, this.jcE.jcx.getString(m$i.favorite_edit_tag_tips));
            lVar.e(2, this.jcE.jcx.mController.tml.getString(m$i.app_delete));
        }
    }
}
