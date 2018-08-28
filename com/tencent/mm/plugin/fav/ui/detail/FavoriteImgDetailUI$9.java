package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.g.a.mu;
import com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class FavoriteImgDetailUI$9 extends c<mu> {
    final /* synthetic */ FavoriteImgDetailUI jcT;

    FavoriteImgDetailUI$9(FavoriteImgDetailUI favoriteImgDetailUI) {
        this.jcT = favoriteImgDetailUI;
        this.sFo = mu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mu muVar = (mu) bVar;
        String str = muVar.bXK.filePath;
        a aVar = null;
        for (a aVar2 : FavoriteImgDetailUI.c(this.jcT).values()) {
            a aVar22;
            if (!str.equals(com.tencent.mm.plugin.fav.a.b.b(aVar22.bOz))) {
                aVar22 = aVar;
            }
            aVar = aVar22;
        }
        if (aVar != null) {
            aVar.jdb = bi.aG(muVar.bXK.result, "");
            aVar.bJr = muVar.bXK.bJr;
            aVar.bJs = muVar.bXK.bJs;
            if (!bi.oW(aVar.jdb) && aVar.fUH.ofo.isShowing()) {
                FavoriteImgDetailUI.a(this.jcT, aVar);
            }
        }
        return true;
    }
}
