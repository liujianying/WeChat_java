package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class LoginUI$6 implements OnClickListener {
    final /* synthetic */ LoginUI eSk;

    LoginUI$6(LoginUI loginUI) {
        this.eSk = loginUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.eSk, MobileInputUI.class);
        int[] iArr = new int[5];
        iArr[0] = 2;
        intent.putExtra("mobile_input_purpose", 1);
        intent.putExtra("kv_report_login_method_data", iArr);
        intent.putExtra("from_switch_account", LoginUI.g(this.eSk));
        this.eSk.startActivity(intent);
        this.eSk.finish();
    }
}
