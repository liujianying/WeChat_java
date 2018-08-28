package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.48;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.49;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.KeyboardLinearLayout.a;

class WebViewUI$44 implements a {
    final /* synthetic */ WebViewUI pZJ;
    final /* synthetic */ WebViewKeyboardLinearLayout qaz;

    WebViewUI$44(WebViewUI webViewUI, WebViewKeyboardLinearLayout webViewKeyboardLinearLayout) {
        this.pZJ = webViewUI;
        this.qaz = webViewKeyboardLinearLayout;
    }

    public final void qN(int i) {
        boolean z = true;
        x.i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = " + i);
        WebViewUI.a(this.pZJ, this.qaz, i);
        if (i == -3) {
            this.pZJ.pQY.bUv().pSF = 1;
            int keyBoardHeight = this.qaz.getKeyBoardHeight();
            if (keyBoardHeight > 0) {
                WebViewUI.bVX();
                WebViewUI.b(this.pZJ, keyBoardHeight);
            }
            WebViewUI.c(this.pZJ, keyBoardHeight);
            if (this.pZJ.mhH.getIsX5Kernel() || VERSION.SDK_INT >= 19) {
                WebViewUI.a(this.pZJ).post(new 1(this, keyBoardHeight));
            }
            if (WebViewUI.ak(this.pZJ) != null && WebViewUI.ak(this.pZJ).getVisibility() == 0) {
                WebViewUI.ak(this.pZJ).bYB();
            }
        } else {
            WebViewUI.c(this.pZJ, 0);
            WebViewUI.b(this.pZJ, 0);
        }
        WebViewUI webViewUI = this.pZJ;
        if (i == -3 && webViewUI.pYf != null) {
            if ((webViewUI.gcP.bVS().qVZ & 1) <= 0) {
                z = false;
            }
            x.d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = " + z);
            if (!(!z || webViewUI.pYf.getVisibility() == 0 || webViewUI.pXM.isShown())) {
                if (webViewUI.pYg == null) {
                    webViewUI.pYg = new al(Looper.getMainLooper(), new 48(webViewUI), false);
                }
                webViewUI.pYg.J(4000, 4000);
                View view = webViewUI.pYf;
                ((ImageView) view.findViewById(R.h.listen_model_notify_imageview)).setImageResource(R.k.net_warn_icon);
                TextView textView = (TextView) view.findViewById(R.h.listen_model_notify_text);
                textView.setTextSize(14.0f);
                textView.setText(R.l.wv_alert_input_tips);
                ((ImageButton) view.findViewById(R.h.listen_model_notify_btn)).setOnClickListener(new 49(webViewUI));
                webViewUI.pYf.setVisibility(0);
                h.mEJ.k(13125, webViewUI.getRawUrl());
            }
        }
        this.pZJ.pZI = i;
    }
}
