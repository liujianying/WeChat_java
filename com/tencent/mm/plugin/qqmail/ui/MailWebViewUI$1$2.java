package com.tencent.mm.plugin.qqmail.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.qqmail.ui.MailWebViewUI.1;

class MailWebViewUI$1$2 implements Runnable {
    final /* synthetic */ String fYD;
    final /* synthetic */ 1 mhM;

    MailWebViewUI$1$2(1 1, String str) {
        this.mhM = 1;
        this.fYD = str;
    }

    public final void run() {
        Toast.makeText(this.mhM.mhK, this.fYD, 0).show();
    }
}
