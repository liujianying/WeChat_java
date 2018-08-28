package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$62 implements OnClickListener {
    final /* synthetic */ CheckBox oME;
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$62(WebViewUI webViewUI, CheckBox checkBox) {
        this.pZJ = webViewUI;
        this.oME = checkBox;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.oME != null && this.oME.isChecked()) {
            try {
                if (this.pZJ.gcO.aSn()) {
                    this.pZJ.gcO.ek(327792, 1);
                }
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "tryShowCloseWindowConfirmInfo, ex = " + e.getMessage());
            }
        }
        this.pZJ.pZc = true;
        WebViewUI.aS(this.pZJ);
        g.pXv.close();
        this.pZJ.finish();
    }
}
