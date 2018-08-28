package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.g.a.dj;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class i$1 implements c {
    final /* synthetic */ i kKy;

    i$1(i iVar) {
        this.kKy = iVar;
    }

    public final void a(l lVar) {
        lVar.a(1, this.kKy.getString(h.app_share_to_weixin), 0);
        if (this.kKy.type == 1) {
            lVar.a(3, this.kKy.getString(h.plugin_favorite_opt), 0);
        } else if (this.kKy.type == 2 && this.kKy.activity.getIntent().getBooleanExtra("kFavCanDel", true)) {
            lVar.a(5, this.kKy.getString(h.favorite_edit_tag_tips_1), 0);
            lVar.a(4, this.kKy.getString(h.app_delete), 0);
        }
        dj djVar = new dj();
        djVar.bLf.bJC = this.kKy.bJC;
        a.sFg.m(djVar);
        if (djVar.bLg.bKE || g.m(ad.getContext(), 4)) {
            lVar.a(6, this.kKy.getString(h.download_other_open), 0);
        }
    }
}
