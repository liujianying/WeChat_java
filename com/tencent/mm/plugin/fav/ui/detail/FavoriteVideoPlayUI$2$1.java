package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.2;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class FavoriteVideoPlayUI$2$1 implements c {
    final /* synthetic */ 2 jdO;

    FavoriteVideoPlayUI$2$1(2 2) {
        this.jdO = 2;
    }

    public final void a(l lVar) {
        if (this.jdO.jdN.jdJ) {
            if (e.cn(this.jdO.jdN.bOX)) {
                lVar.add(0, 1, 0, this.jdO.jdN.getString(i.favorite_share_with_friend));
            }
            lVar.add(0, 2, 0, this.jdO.jdN.getString(i.save_video_to_local));
        }
    }
}
