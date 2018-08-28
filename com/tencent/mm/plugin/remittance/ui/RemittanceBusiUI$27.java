package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class RemittanceBusiUI$27 implements Runnable {
    final /* synthetic */ RemittanceBusiUI mBt;

    RemittanceBusiUI$27(RemittanceBusiUI remittanceBusiUI) {
        this.mBt = remittanceBusiUI;
    }

    public final void run() {
        RemittanceBusiUI.t(this.mBt).setText(RemittanceBusiUI.s(this.mBt));
        CharSequence dx = e.dx(e.gT(RemittanceBusiUI.u(this.mBt)), 10);
        if (!bi.oW(RemittanceBusiUI.v(this.mBt))) {
            dx = this.mBt.getString(i.remittance_collect_block, new Object[]{dx, RemittanceBusiUI.v(this.mBt)});
        }
        RemittanceBusiUI.w(this.mBt).setText(j.a(this.mBt, dx, RemittanceBusiUI.w(this.mBt).getTextSize()));
        if (RemittanceBusiUI.h(this.mBt) != null) {
            if (RemittanceBusiUI.h(this.mBt).mwN != 1) {
                RemittanceBusiUI.x(this.mBt).setVisibility(8);
                return;
            } else if (!bi.oW(RemittanceBusiUI.h(this.mBt).mwO)) {
                if (RemittanceBusiUI.h(this.mBt).mwW == 1) {
                    RemittanceBusiUI.x(this.mBt).setRoundCorner(true);
                } else {
                    RemittanceBusiUI.x(this.mBt).setRoundCorner(false);
                }
                int b = b.b(this.mBt, 36.0f);
                RemittanceBusiUI.x(this.mBt).i(RemittanceBusiUI.h(this.mBt).mwO, b, b, -1);
                return;
            } else if (!bi.oW(RemittanceBusiUI.u(this.mBt))) {
                if (RemittanceBusiUI.h(this.mBt).mwW == 1) {
                    a.b.n(RemittanceBusiUI.x(this.mBt), RemittanceBusiUI.u(this.mBt));
                    return;
                } else {
                    a.b.a(RemittanceBusiUI.x(this.mBt), RemittanceBusiUI.u(this.mBt));
                    return;
                }
            }
        }
        RemittanceBusiUI.x(this.mBt).setVisibility(8);
    }
}
