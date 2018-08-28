package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.w;

class WelcomeSelectView$3 implements OnClickListener {
    final /* synthetic */ WelcomeSelectView eXw;
    final /* synthetic */ Context val$context;

    WelcomeSelectView$3(WelcomeSelectView welcomeSelectView, Context context) {
        this.eXw = welcomeSelectView;
        this.val$context = context;
    }

    public final void onClick(View view) {
        if (d.qVQ) {
            String string = this.val$context.getString(j.create_forbiden_uri, new Object[]{"0x" + Integer.toHexString(d.qVN), w.chP()});
            Intent intent = new Intent();
            intent.putExtra("rawUrl", string);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            intent.putExtra("needRedirect", false);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
            a.ezn.j(intent, this.val$context);
            return;
        }
        Intent intent2 = new Intent(this.val$context, RegByMobileRegAIOUI.class);
        intent2.putExtra("login_type", 0);
        this.val$context.startActivity(intent2);
    }
}
