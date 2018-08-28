package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.y;
import com.tencent.mm.h.a;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.b;

class w$7 implements OnClickListener {
    final /* synthetic */ Activity ews;
    final /* synthetic */ a ewv;
    final /* synthetic */ Intent tnx;

    w$7(Intent intent, Activity activity, a aVar) {
        this.tnx = intent;
        this.ews = activity;
        this.ewv = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.tnx != null) {
            if (!(this.ews instanceof LauncherUI)) {
                this.ews.finish();
            }
            if (bi.oW(this.ewv.url)) {
                this.ews.startActivity(this.tnx);
                b.E(this.ews, this.tnx);
            } else {
                Intent intent = new Intent();
                StringBuilder stringBuilder = new StringBuilder(this.ewv.url);
                stringBuilder.append("&wechat_real_lang=" + w.chP());
                intent.putExtra("rawUrl", stringBuilder.toString());
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
                d.b(this.ews, "webview", ".ui.tools.WebViewUI", intent);
            }
            x.ca(this.ews);
            y yVar = new y();
            yVar.bHg.bHh = true;
            com.tencent.mm.sdk.b.a.sFg.m(yVar);
        }
    }
}
