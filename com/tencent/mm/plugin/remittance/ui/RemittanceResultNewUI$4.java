package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.bi;

class RemittanceResultNewUI$4 implements Runnable {
    final /* synthetic */ RemittanceResultNewUI mDp;

    RemittanceResultNewUI$4(RemittanceResultNewUI remittanceResultNewUI) {
        this.mDp = remittanceResultNewUI;
    }

    public final void run() {
        if (RemittanceResultNewUI.c(this.mDp) == 33 || RemittanceResultNewUI.c(this.mDp) == 32 || RemittanceResultNewUI.c(this.mDp) == 48) {
            this.mDp.finish();
        } else if (bi.oW(RemittanceResultNewUI.d(this.mDp)) || RemittanceResultNewUI.e(this.mDp)) {
            this.mDp.finish();
        } else {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", RemittanceResultNewUI.d(this.mDp));
            intent.putExtra("finish_direct", false);
            d.e(this.mDp, ".ui.chatting.ChattingUI", intent);
        }
    }
}
