package com.tencent.mm.plugin.fav.ui;

import android.os.SystemClock;
import com.tencent.mm.plugin.fav.ui.a.a;
import com.tencent.mm.sdk.platformtools.x;

class FavBaseUI$9 implements Runnable {
    final /* synthetic */ FavBaseUI iYp;

    FavBaseUI$9(FavBaseUI favBaseUI) {
        this.iYp = favBaseUI;
    }

    public final void run() {
        a aMc = this.iYp.aMc();
        if (aMc.isEmpty() || SystemClock.elapsedRealtime() - FavBaseUI.e(this.iYp) >= 400) {
            FavBaseUI.f(this.iYp);
            FavBaseUI.a(this.iYp, SystemClock.elapsedRealtime());
            x.v("MicroMsg.FavoriteBaseUI", "do refresh job");
            aMc.notifyDataSetChanged();
            this.iYp.a(aMc);
            if (this.iYp.iXX) {
                x.v("MicroMsg.FavoriteBaseUI", "do scroll to first");
                this.iYp.iYa.setSelection(0);
                this.iYp.iXX = false;
                return;
            }
            return;
        }
        x.d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", new Object[]{Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavBaseUI.e(this.iYp)), Integer.valueOf(400)});
        this.iYp.dvh.postDelayed(this, 200);
    }
}
