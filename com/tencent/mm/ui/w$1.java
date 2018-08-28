package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.b;

class w$1 implements OnClickListener {
    final /* synthetic */ Activity mr;
    final /* synthetic */ Intent tnx;
    final /* synthetic */ String val$url;

    w$1(String str, Activity activity, Intent intent) {
        this.val$url = str;
        this.mr = activity;
        this.tnx = intent;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.a(322, 23, 1, true);
        h hVar = h.mEJ;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(4023);
        objArr[1] = String.format("%b|%s", new Object[]{Boolean.valueOf(bi.oW(this.val$url)), this.val$url});
        hVar.h(11098, objArr);
        au.hold();
        if (bi.oW(this.val$url)) {
            this.mr.startActivity(this.tnx);
            b.E(this.mr, this.tnx);
        } else {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.val$url);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            intent.putExtra("needRedirect", false);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
            d.b(this.mr, "webview", ".ui.tools.WebViewUI", intent);
        }
        x.ca(this.mr);
    }
}
