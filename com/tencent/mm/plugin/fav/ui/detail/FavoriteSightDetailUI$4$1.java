package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.4;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class FavoriteSightDetailUI$4$1 implements c {
    final /* synthetic */ 4 jdr;

    FavoriteSightDetailUI$4$1(4 4) {
        this.jdr = 4;
    }

    public final void a(l lVar) {
        int i = (!FavoriteSightDetailUI.a(this.jdr.jdp).aLd() || FavoriteSightDetailUI.j(this.jdr.jdp).t(FavoriteSightDetailUI.a(this.jdr.jdp))) ? 0 : 1;
        if (i != 0 && FavoriteSightDetailUI.b(this.jdr.jdp).rAw == 0) {
            lVar.e(0, this.jdr.jdp.getString(i.favorite_share_with_friend));
        }
        lVar.e(3, this.jdr.jdp.getString(i.favorite_edit_tag_tips));
        lVar.e(2, this.jdr.jdp.mController.tml.getString(i.app_delete));
    }
}
