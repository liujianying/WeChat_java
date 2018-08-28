package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;

class WebViewUI$61 implements OnClickListener {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$61(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void onClick(View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.pZJ, R.a.font_fade_out);
        loadAnimation.setAnimationListener(new 1(this));
        WebViewUI.G(this.pZJ).startAnimation(loadAnimation);
        WebViewUI.G(this.pZJ).setVisibility(8);
    }
}
