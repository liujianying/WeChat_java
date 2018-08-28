package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;

class WebViewInputFooter$2 implements OnTouchListener {
    final /* synthetic */ WebViewInputFooter qlJ;

    WebViewInputFooter$2(WebViewInputFooter webViewInputFooter) {
        this.qlJ = webViewInputFooter;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        WebViewInputFooter.g(this.qlJ);
        WebViewInputFooter.i(this.qlJ).setVisibility(8);
        WebViewInputFooter.f(this.qlJ).setImageResource(R.g.chatting_setmode_biaoqing_btn);
        WebViewInputFooter.a(this.qlJ, 0);
        return false;
    }
}
