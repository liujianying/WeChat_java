package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

class aa$3 implements OnClickListener {
    final /* synthetic */ String ewu;
    final /* synthetic */ Context val$context;

    aa$3(String str, Context context) {
        this.ewu = str;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.ewu);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
        a.ezn.j(intent, this.val$context);
    }
}
