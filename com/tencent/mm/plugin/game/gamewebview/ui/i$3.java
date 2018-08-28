package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

class i$3 implements d {
    final /* synthetic */ i jKv;

    i$3(i iVar) {
        this.jKv = iVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (!this.jKv.jIJ.isFinishing() && !this.jKv.jIJ.tlP) {
            if (i.h(menuItem)) {
                menuItem.getMenuInfo();
                return;
            }
            switch (menuItem.getItemId()) {
                case 1:
                    this.jKv.aTi();
                    return;
                case 2:
                    this.jKv.aTj();
                    return;
                case 3:
                    this.jKv.aTp();
                    return;
                case 6:
                    this.jKv.aTk();
                    return;
                case 7:
                    this.jKv.aTn();
                    return;
                case 9:
                    this.jKv.aTq();
                    return;
                case 10:
                    this.jKv.aTr();
                    return;
                case 12:
                    i.a(this.jKv);
                    return;
                case 27:
                    this.jKv.aTh();
                    return;
                case 28:
                    this.jKv.refresh();
                    return;
                case 29:
                    this.jKv.aTo();
                    return;
                case 30:
                    this.jKv.aTl();
                    return;
                case 31:
                    this.jKv.jKc.getPageView().fq(true);
                    return;
                case 32:
                    this.jKv.aTm();
                    return;
                default:
                    return;
            }
        }
    }
}
