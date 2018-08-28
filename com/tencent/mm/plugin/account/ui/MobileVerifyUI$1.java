package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.a.h;
import java.util.TimerTask;

class MobileVerifyUI$1 extends TimerTask {
    final /* synthetic */ MobileVerifyUI eUo;

    MobileVerifyUI$1(MobileVerifyUI mobileVerifyUI) {
        this.eUo = mobileVerifyUI;
    }

    public final void run() {
        this.eUo.eTZ.post(new Runnable() {
            public final void run() {
                MobileVerifyUI.b(MobileVerifyUI$1.this.eUo);
                if (MobileVerifyUI.c(MobileVerifyUI$1.this.eUo) >= 0) {
                    MobileVerifyUI$1.this.eUo.eTZ.setText(MobileVerifyUI$1.this.eUo.getResources().getQuantityString(h.mobileverify_send_code_tip, (int) MobileVerifyUI.c(MobileVerifyUI$1.this.eUo), new Object[]{Integer.valueOf((int) MobileVerifyUI.c(MobileVerifyUI$1.this.eUo))}));
                    return;
                }
                MobileVerifyUI$1.this.eUo.eTZ.setVisibility(8);
                MobileVerifyUI$1.this.eUo.eTY.setVisibility(0);
                MobileVerifyUI.d(MobileVerifyUI$1.this.eUo);
                MobileVerifyUI$1.this.eUo.eTY.setEnabled(true);
                MobileVerifyUI$1.this.eUo.eTY.setText(MobileVerifyUI$1.this.eUo.getString(a$j.mobileverify_nocode));
            }
        });
    }
}
