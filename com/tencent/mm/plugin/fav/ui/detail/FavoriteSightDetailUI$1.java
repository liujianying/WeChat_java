package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class FavoriteSightDetailUI$1 implements OnClickListener {
    final /* synthetic */ FavoriteSightDetailUI jdp;

    FavoriteSightDetailUI$1(FavoriteSightDetailUI favoriteSightDetailUI) {
        this.jdp = favoriteSightDetailUI;
    }

    public final void onClick(View view) {
        if (!a.by(view.getContext()) && !a.bw(view.getContext())) {
            x.i("MicroMsg.FavoriteSightDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[]{Integer.valueOf(FavoriteSightDetailUI.a(this.jdp).field_id), Long.valueOf(FavoriteSightDetailUI.a(this.jdp).field_localId), Integer.valueOf(FavoriteSightDetailUI.a(this.jdp).field_itemStatus)});
            if (FavoriteSightDetailUI.a(this.jdp).isDone()) {
                if (b.f(FavoriteSightDetailUI.b(this.jdp))) {
                    m.a(m.a.iWk, FavoriteSightDetailUI.a(this.jdp));
                    FavoriteSightDetailUI.a(this.jdp, true, view.getContext());
                    return;
                } else if (bi.oW(FavoriteSightDetailUI.b(this.jdp).rzo)) {
                    FavoriteSightDetailUI.a(this.jdp, false, view.getContext());
                    return;
                } else {
                    x.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
                }
            } else if (FavoriteSightDetailUI.a(this.jdp).aLh()) {
                if (bi.oW(FavoriteSightDetailUI.b(this.jdp).rzo)) {
                    FavoriteSightDetailUI.a(this.jdp, false, view.getContext());
                    return;
                }
            } else if (FavoriteSightDetailUI.a(this.jdp).isDownloading() || FavoriteSightDetailUI.a(this.jdp).aLf()) {
                if (FavoriteSightDetailUI.c(this.jdp).getVisibility() == 8) {
                    FavoriteSightDetailUI.a(this.jdp, false);
                    return;
                }
                return;
            }
            if (FavoriteSightDetailUI.a(this.jdp).aLg()) {
                b.l(FavoriteSightDetailUI.a(this.jdp));
            } else {
                b.m(FavoriteSightDetailUI.a(this.jdp));
            }
            FavoriteSightDetailUI.a(this.jdp, false);
        }
    }
}
