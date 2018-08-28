package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

class g$40 implements OnClickListener {
    final /* synthetic */ String bAj;
    final /* synthetic */ String pWG;
    final /* synthetic */ i qiH;
    final /* synthetic */ JsapiPermissionWrapper qiI;
    final /* synthetic */ g qiK;
    final /* synthetic */ String val$url;

    g$40(g gVar, String str, String str2, String str3, i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        this.qiK = gVar;
        this.bAj = str;
        this.pWG = str2;
        this.val$url = str3;
        this.qiH = iVar;
        this.qiI = jsapiPermissionWrapper;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(14217, new Object[]{this.bAj, Integer.valueOf(5), this.pWG, this.val$url, Integer.valueOf(3)});
        g.dS(this.qiK, this.qiH);
        dialogInterface.dismiss();
    }
}
