package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.File;

class NetworkDiagnoseReportUI$4 implements OnClickListener {
    final /* synthetic */ NetworkDiagnoseReportUI oDY;

    NetworkDiagnoseReportUI$4(NetworkDiagnoseReportUI networkDiagnoseReportUI) {
        this.oDY = networkDiagnoseReportUI;
    }

    public final void onClick(View view) {
        if (!bi.oW(NetworkDiagnoseReportUI.bP())) {
            File file = new File(NetworkDiagnoseReportUI.bP());
            if (file.exists()) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(file), "text/plain");
                intent.addFlags(268435456);
                this.oDY.startActivity(intent);
            }
        }
    }
}
