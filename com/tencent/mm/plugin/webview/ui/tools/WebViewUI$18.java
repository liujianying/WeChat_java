package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;

class WebViewUI$18 implements OnTouchListener {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$18(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (WebViewUI.G(this.pZJ) != null && WebViewUI.G(this.pZJ).getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pZJ, R.a.font_fade_out);
            loadAnimation.setAnimationListener(new 1(this));
            WebViewUI.G(this.pZJ).startAnimation(loadAnimation);
            WebViewUI.G(this.pZJ).setVisibility(8);
        }
        switch (motionEvent.getAction()) {
            case 0:
            case 1:
                if (!view.hasFocus()) {
                    view.requestFocus();
                    break;
                }
                break;
        }
        if (this.pZJ.mhH != null && (motionEvent.getAction() == 0 || motionEvent.getAction() == 5 || motionEvent.getAction() == 5 || motionEvent.getAction() == 261 || motionEvent.getAction() == 517)) {
            if (motionEvent.getPointerCount() > 1) {
                this.pZJ.mhH.getSettings().setBuiltInZoomControls(true);
                this.pZJ.mhH.getSettings().setSupportZoom(true);
            } else {
                this.pZJ.mhH.getSettings().setBuiltInZoomControls(false);
                this.pZJ.mhH.getSettings().setSupportZoom(false);
            }
        }
        return false;
    }
}
