package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import java.io.File;

class NetworkDiagnoseReportUI$3 implements OnClickListener {
    final /* synthetic */ NetworkDiagnoseReportUI oDY;

    NetworkDiagnoseReportUI$3(NetworkDiagnoseReportUI networkDiagnoseReportUI) {
        this.oDY = networkDiagnoseReportUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addFlags(268435456);
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"WeChat_Log@qq.com"});
        intent.putExtra("android.intent.extra.SUBJECT", NetworkDiagnoseReportUI.a(this.oDY));
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(NetworkDiagnoseReportUI.bP())));
        intent.setType("text/plain");
        this.oDY.startActivity(intent);
    }
}
