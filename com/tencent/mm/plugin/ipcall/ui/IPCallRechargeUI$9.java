package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;

class IPCallRechargeUI$9 implements c {
    final /* synthetic */ IPCallRechargeUI kxB;

    IPCallRechargeUI$9(IPCallRechargeUI iPCallRechargeUI) {
        this.kxB = iPCallRechargeUI;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                x.i("MicroMsg.IPCallRechargeUI", "start restore");
                IPCallRechargeUI.i(this.kxB).start();
                h.mEJ.a(257, 14, 1, true);
                Intent intent = new Intent();
                intent.putExtra("key_action_type", 200002);
                intent.putExtra("key_force_google", true);
                d.b(this.kxB, "wallet_index", ".ui.WalletIapUI", intent, 2002);
                IPCallRechargeUI iPCallRechargeUI = this.kxB;
                if (iPCallRechargeUI.isFinishing()) {
                    x.i("MicroMsg.IPCallRechargeUI", "[showLoadingDialog] acitivity is finished.");
                    return;
                }
                Context context = iPCallRechargeUI.mController.tml;
                iPCallRechargeUI.getString(R.l.app_tip);
                iPCallRechargeUI.kuy = com.tencent.mm.ui.base.h.a(context, iPCallRechargeUI.getString(R.l.ip_call_loading_tip), false, null);
                return;
            default:
                return;
        }
    }
}
