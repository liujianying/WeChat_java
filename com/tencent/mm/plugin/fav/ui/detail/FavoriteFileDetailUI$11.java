package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class FavoriteFileDetailUI$11 implements OnClickListener {
    final /* synthetic */ FavoriteFileDetailUI jcx;

    FavoriteFileDetailUI$11(FavoriteFileDetailUI favoriteFileDetailUI) {
        this.jcx = favoriteFileDetailUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.FavoriteFileDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[]{Integer.valueOf(FavoriteFileDetailUI.b(this.jcx).field_id), Long.valueOf(FavoriteFileDetailUI.b(this.jcx).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(this.jcx).field_itemStatus)});
        if (f.zZ()) {
            if (FavoriteFileDetailUI.b(this.jcx).aLg() || bi.oW(FavoriteFileDetailUI.a(this.jcx).rzo)) {
                b.l(FavoriteFileDetailUI.b(this.jcx));
            } else if (FavoriteFileDetailUI.f(this.jcx)) {
                FavoriteFileDetailUI.b(this.jcx).field_itemStatus = 7;
                b.b(FavoriteFileDetailUI.a(this.jcx), 18);
            } else {
                b.a(FavoriteFileDetailUI.b(this.jcx), FavoriteFileDetailUI.a(this.jcx), true);
            }
            FavoriteFileDetailUI.g(this.jcx);
            return;
        }
        h.i(this.jcx.mController.tml, i.favorite_no_sdcard, i.favorite);
    }
}
