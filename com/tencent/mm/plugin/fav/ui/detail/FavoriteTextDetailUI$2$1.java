package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.2;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class FavoriteTextDetailUI$2$1 implements c {
    final /* synthetic */ 2 jdA;

    FavoriteTextDetailUI$2$1(2 2) {
        this.jdA = 2;
    }

    public final void a(l lVar) {
        if (this.jdA.jdz.getIntent().getBooleanExtra("key_detail_can_share_to_friend", true)) {
            lVar.e(2, this.jdA.jdz.getString(i.favorite_share_with_friend));
        }
        lVar.e(0, this.jdA.jdz.getString(i.favorite_edit_menu));
        lVar.e(3, this.jdA.jdz.getString(i.favorite_edit_tag_tips));
        lVar.e(4, this.jdA.jdz.getString(i.app_delete));
    }
}
