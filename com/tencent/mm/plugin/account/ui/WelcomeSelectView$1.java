package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.a;

class WelcomeSelectView$1 implements OnClickListener {
    final /* synthetic */ WelcomeSelectView eXw;

    WelcomeSelectView$1(WelcomeSelectView welcomeSelectView) {
        this.eXw = welcomeSelectView;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("not_auth_setting", true);
        intent.putExtra("from_login_history", true);
        a.ezn.p(intent, this.eXw.getContext());
    }
}
