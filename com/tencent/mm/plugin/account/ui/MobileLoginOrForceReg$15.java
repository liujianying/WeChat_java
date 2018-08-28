package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.sdk.platformtools.bi;

class MobileLoginOrForceReg$15 implements OnClickListener {
    final /* synthetic */ MobileLoginOrForceReg eTx;

    MobileLoginOrForceReg$15(MobileLoginOrForceReg mobileLoginOrForceReg) {
        this.eTx = mobileLoginOrForceReg;
    }

    public final void onClick(View view) {
        if (bi.oW(MobileLoginOrForceReg.g(this.eTx))) {
            Intent intent = new Intent();
            a.pU("R200_900_phone");
            intent.putExtra("regsetinfo_ticket", MobileLoginOrForceReg.h(this.eTx));
            intent.putExtra("regsetinfo_user", MobileLoginOrForceReg.e(this.eTx));
            intent.putExtra("regsetinfo_pwd", MobileLoginOrForceReg.d(this.eTx));
            intent.putExtra("regsetinfo_ismobile", 4);
            intent.putExtra("regsetinfo_isForce", true);
            intent.putExtra("regsession_id", MobileLoginOrForceReg.i(this.eTx));
            intent.putExtra("regsetinfo_NextControl", MobileLoginOrForceReg.j(this.eTx));
            intent.putExtra("mobile_check_type", MobileLoginOrForceReg.k(this.eTx));
            intent.putExtra("key_reg_style", MobileLoginOrForceReg.l(this.eTx));
            intent.setClass(this.eTx, RegSetInfoUI.class);
            this.eTx.startActivity(intent);
            return;
        }
        MobileLoginOrForceReg.m(this.eTx);
    }
}
