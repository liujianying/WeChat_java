package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.c;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

class ShakeTvHistoryListUI$5 implements d {
    final /* synthetic */ ShakeTvHistoryListUI nbu;

    ShakeTvHistoryListUI$5(ShakeTvHistoryListUI shakeTvHistoryListUI) {
        this.nbu = shakeTvHistoryListUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                int i2;
                h.mEJ.h(12662, new Object[]{Integer.valueOf(1), bi.oV(ShakeTvHistoryListUI.d(this.nbu))});
                o buE = m.buE();
                String d = ShakeTvHistoryListUI.d(this.nbu);
                if (bi.oW(d)) {
                    i2 = -1;
                } else {
                    i2 = buE.diF.delete(buE.getTableName(), "username = '" + d + "'", null);
                    x.d("MicroMsg.ShakeTvHistoryStorage", "delMsgByUserName = " + i2);
                }
                if (i2 < 0) {
                    x.i("MicroMsg.ShakeTvHistoryListUI", "delete tv history fail, ret[%d]", new Object[]{Integer.valueOf(i2)});
                } else {
                    au.DF().a(new c(1, ShakeTvHistoryListUI.d(this.nbu)), 0);
                }
                ShakeTvHistoryListUI.a(this.nbu).a(null, null);
                return;
            default:
                return;
        }
    }
}
