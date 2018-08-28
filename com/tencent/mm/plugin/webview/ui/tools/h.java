package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMWebView;

public final class h {
    String gsE;
    boolean qaV = false;
    MMWebView qaW;
    WebViewUI qaX;
    int qaY;

    public h(WebViewUI webViewUI) {
        this.qaX = webViewUI;
    }

    final void bWM() {
        this.qaX.lF(bWN());
        s sVar = this.qaX.mController;
        if (VERSION.SDK_INT >= 21) {
            sVar.getSupportActionBar().setElevation(1.0f);
        }
        View findViewById = this.qaX.findViewById(R.h.webview_logo_container);
        if (findViewById != null) {
            findViewById.setBackgroundColor(bWN());
        }
        int color = this.qaX.getResources().getColor(R.e.webview_x5logo_text_color);
        findViewById = this.qaX.findViewById(R.h.x5_logo_url);
        if (findViewById != null && (findViewById instanceof TextView)) {
            ((TextView) findViewById).setTextColor(color);
        }
        findViewById = this.qaX.findViewById(R.h.info_txt);
        if (findViewById != null && (findViewById instanceof TextView)) {
            ((TextView) findViewById).setTextColor(color);
        }
        findViewById = this.qaX.findViewById(R.h.x5_logo_img);
        if (findViewById != null && (findViewById instanceof ImageView)) {
            ((ImageView) findViewById).setImageResource(R.k.webview_logo_qqbrowser_light);
        }
    }

    public final int bWN() {
        Object obj = null;
        if (this.qaX != null) {
            Object obj2;
            String str = this.gsE;
            if (bi.oW(str)) {
                str = this.qaX.getRawUrl();
            }
            if (bi.oW(str) || !(str.startsWith("http://mp.weixin.qq.com/s?") || str.startsWith("https://mp.weixin.qq.com/s?"))) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            obj = obj2;
        }
        if (obj != null) {
            return this.qaX.getResources().getColor(R.e.webview_mp_actionbar_color);
        }
        return this.qaX.getResources().getColor(R.e.webview_actionbar_color);
    }
}
