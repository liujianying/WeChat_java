package com.tencent.mm.plugin.webview.ui.tools;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.6;
import com.tencent.mm.ui.base.h;

class OpenFileChooserUI$6$1 implements Runnable {
    final /* synthetic */ 6 pWi;

    OpenFileChooserUI$6$1(6 6) {
        this.pWi = 6;
    }

    public final void run() {
        if (this.pWi.pWh.jCt == 7 && this.pWi.pWh.jCU == 2) {
            h.a(this.pWi.pWh, this.pWi.pWh.getString(R.l.webview_jssdk_choose_video_exceed_20M), this.pWi.pWh.getString(R.l.app_tip), this.pWi.pWh.getString(R.l.app_i_known), false, new 1(this));
            return;
        }
        Toast.makeText(this.pWi.pWh, this.pWi.pWh.getString(R.l.video_export_file_too_big), 0).show();
        this.pWi.pWh.setResult(1);
        this.pWi.pWh.finish();
    }
}
