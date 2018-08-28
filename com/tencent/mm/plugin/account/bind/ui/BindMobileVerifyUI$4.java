package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.a;

class BindMobileVerifyUI$4 implements OnClickListener {
    final /* synthetic */ BindMobileVerifyUI eHl;

    BindMobileVerifyUI$4(BindMobileVerifyUI bindMobileVerifyUI) {
        this.eHl = bindMobileVerifyUI;
    }

    public final void onClick(View view) {
        this.eHl.YC();
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("bindmcontact_mobile", BindMobileVerifyUI.b(this.eHl));
        bundle.putInt("voice_verify_type", 4);
        intent.putExtras(bundle);
        a.ezn.f(this.eHl, intent);
    }
}
