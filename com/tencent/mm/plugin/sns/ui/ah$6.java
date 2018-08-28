package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

class ah$6 implements d {
    final /* synthetic */ ah nQf;

    ah$6(ah ahVar) {
        this.nQf = ahVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                if (9 - this.nQf.nPY.nQj.size() <= 0) {
                    x.e("MicroMsg.PicWidget", "has select the max image count");
                    return;
                }
                h.mEJ.h(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
                l.a(this.nQf.bGc, 11, new Intent(), 2, 2);
                return;
            case 1:
                int size = 9 - this.nQf.nPY.nQj.size();
                if (size <= 0) {
                    x.e("MicroMsg.PicWidget", "has select the max image count");
                    return;
                }
                String string = this.nQf.bGc.getSharedPreferences(ad.chY(), 0).getString("gallery", "1");
                h.mEJ.h(13822, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
                if (string.equalsIgnoreCase("0")) {
                    l.O(this.nQf.bGc);
                    return;
                } else {
                    l.a(this.nQf.bGc, 9, size, 4, 1, false, null);
                    return;
                }
            default:
                return;
        }
    }
}
