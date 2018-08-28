package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.6;
import com.tencent.mm.ui.base.h;

class OpenFileChooserUI$6$2 implements Runnable {
    final /* synthetic */ 6 pWi;

    OpenFileChooserUI$6$2(6 6) {
        this.pWi = 6;
    }

    public final void run() {
        h.a(this.pWi.pWh, this.pWi.pWh.getString(R.l.webview_jssdk_choose_video_type_not_support), this.pWi.pWh.getString(R.l.app_tip), this.pWi.pWh.getString(R.l.app_i_known), false, new 1(this));
    }
}
