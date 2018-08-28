package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bi;

class FavBaseUI$2 implements a {
    final /* synthetic */ FavBaseUI iYp;
    long iYq = 0;

    FavBaseUI$2(FavBaseUI favBaseUI) {
        this.iYp = favBaseUI;
    }

    public final void a(String str, l lVar) {
        this.iYp.iYd.removeCallbacks(FavBaseUI.h(this.iYp));
        if (bi.bI(this.iYq) > 200) {
            this.iYq = bi.VG();
            this.iYp.iYd.post(FavBaseUI.h(this.iYp));
            return;
        }
        this.iYp.iYd.postDelayed(FavBaseUI.h(this.iYp), 200);
    }
}
