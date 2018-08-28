package com.tencent.mm.plugin.webview.ui.tools;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.sdk.platformtools.bi;

class WebViewUI$23$44 implements Runnable {
    final /* synthetic */ String dho;
    final /* synthetic */ boolean gmc;
    final /* synthetic */ 23 pZM;
    final /* synthetic */ Bitmap qak;
    final /* synthetic */ int qal;

    WebViewUI$23$44(23 23, boolean z, Bitmap bitmap, String str, int i) {
        this.pZM = 23;
        this.gmc = z;
        this.qak = bitmap;
        this.dho = str;
        this.qal = i;
    }

    public final void run() {
        if (this.gmc) {
            this.pZM.pZJ.kd(true);
            return;
        }
        Boolean bool = null;
        String currentURL = this.pZM.pZJ.getCurrentURL();
        if (!bi.oW(currentURL)) {
            bool = (Boolean) WebViewUI.r(this.pZM.pZJ).get(currentURL);
        }
        this.pZM.pZJ.kd(Boolean.valueOf(bool == null ? false : bool.booleanValue()).booleanValue());
        if (this.qak != null && !this.qak.isRecycled()) {
            this.pZM.pZJ.b(this.dho, new BitmapDrawable(this.pZM.pZJ.getResources(), this.qak));
        } else if (!bi.oW(this.dho)) {
            this.pZM.pZJ.addTextOptionMenu(0, this.dho, new 1(this));
        }
        this.pZM.pZJ.AL(this.qal);
    }
}
