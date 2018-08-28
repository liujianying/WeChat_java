package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI.1;

class RegByMobileSetPwdUI$1$2 implements OnClickListener {
    final /* synthetic */ String eGk;
    final /* synthetic */ 1 eVI;

    RegByMobileSetPwdUI$1$2(1 1, String str) {
        this.eVI = 1;
        this.eGk = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this.eVI.eVH, MobileVerifyUI.class);
        intent.putExtra("bindmcontact_mobile", this.eGk);
        intent.putExtra("mobile_verify_purpose", 5);
        this.eVI.eVH.startActivityForResult(intent, 10001);
    }
}
