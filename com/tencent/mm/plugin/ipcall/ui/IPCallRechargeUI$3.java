package com.tencent.mm.plugin.ipcall.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class IPCallRechargeUI$3 extends ag {
    final /* synthetic */ IPCallRechargeUI kxB;

    IPCallRechargeUI$3(IPCallRechargeUI iPCallRechargeUI) {
        this.kxB = iPCallRechargeUI;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1002:
                this.kxB.kxx.setVisibility(0);
                IPCallRechargeUI.k(this.kxB);
                return;
            default:
                x.w("MicroMsg.IPCallRechargeUI", "unknow message, cannt handle.");
                return;
        }
    }
}
