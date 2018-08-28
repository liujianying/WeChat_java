package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class g$41 implements OnClickListener {
    final /* synthetic */ String bAj;
    final /* synthetic */ String pWG;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ String val$url;

    g$41(g gVar, String str, String str2, String str3, i iVar) {
        this.qiK = gVar;
        this.bAj = str;
        this.pWG = str2;
        this.val$url = str3;
        this.qiH = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(14217, new Object[]{this.bAj, Integer.valueOf(6), this.pWG, this.val$url, Integer.valueOf(3)});
        dialogInterface.dismiss();
        g.a(this.qiK, this.qiH, "add_download_task_straight:fail_network_not_wifi", null);
    }
}
