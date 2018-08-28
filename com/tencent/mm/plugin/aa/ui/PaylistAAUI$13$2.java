package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.aa.ui.PaylistAAUI.13;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n$d;

class PaylistAAUI$13$2 implements n$d {
    final /* synthetic */ 13 eEq;

    PaylistAAUI$13$2(13 13) {
        this.eEq = 13;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int i2 = 3;
        switch (menuItem.getItemId()) {
            case 1:
                if (!bi.oW(PaylistAAUI.a(this.eEq.eEl))) {
                    Intent intent = new Intent(this.eEq.eEl.mController.tml, LaunchAAUI.class);
                    intent.putExtra("enter_scene", 3);
                    intent.putExtra("chatroom_name", PaylistAAUI.a(this.eEq.eEl));
                    this.eEq.eEl.startActivity(intent);
                }
                if (this.eEq.eEp.qYn == a.ezM) {
                    i2 = 1;
                } else if (this.eEq.eEp.qYn == a.ezL) {
                    i2 = 2;
                }
                x.d("MicroMsg.PaylistAAUI", "test");
                h.mEJ.h(13721, new Object[]{Integer.valueOf(7), Integer.valueOf(i2)});
                return;
            case 2:
                h.mEJ.h(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(5)});
                com.tencent.mm.ui.base.h.a(this.eEq.eEl, i.aa_close_confirm, -1, i.aa_close_wording, i.app_cancel, new 1(this), null);
                return;
            default:
                return;
        }
    }
}
