package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.cct;
import com.tencent.mm.protocal.c.ccu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

class MallIndexOSUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ MallIndexOSUI kZI;

    MallIndexOSUI$4(MallIndexOSUI mallIndexOSUI) {
        this.kZI = mallIndexOSUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String[] strArr;
        final cct cct = MallIndexOSUI.e(this.kZI).prp;
        final boolean z = MallIndexOSUI.e(this.kZI).prq;
        if (z) {
            strArr = new String[(cct.rFB.size() + 1)];
            strArr[cct.rFB.size()] = this.kZI.getString(i.wallet_index_ui_opt_wallet_switch);
        } else {
            strArr = new String[cct.rFB.size()];
        }
        for (int i = 0; i < cct.rFB.size(); i++) {
            strArr[i] = ab.a(((ccu) cct.rFB.get(i)).syp);
        }
        h.a(this.kZI.mController.tml, null, strArr, null, false, new c() {
            public final void ju(int i) {
                if (i < cct.rFB.size()) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", ab.a(((ccu) cct.rFB.get(i)).syv));
                    d.b(MallIndexOSUI$4.this.kZI, "webview", ".ui.tools.WebViewUI", intent);
                } else if (z) {
                    MallIndexOSUI$4.this.kZI.bcb();
                }
            }
        });
        return true;
    }
}
