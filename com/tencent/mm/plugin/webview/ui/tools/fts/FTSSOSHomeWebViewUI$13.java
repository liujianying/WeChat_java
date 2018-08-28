package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsoluteLayout;
import com.tencent.mm.sdk.d.d.c;

class FTSSOSHomeWebViewUI$13 implements OnTouchListener {
    final /* synthetic */ AbsoluteLayout pOj;
    final /* synthetic */ FTSSOSHomeWebViewUI qeq;

    FTSSOSHomeWebViewUI$13(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, AbsoluteLayout absoluteLayout) {
        this.qeq = fTSSOSHomeWebViewUI;
        this.pOj = absoluteLayout;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.qeq.bXk().getEditText().clearFocus();
        this.qeq.YC();
        FTSSOSHomeWebViewUI$b a = FTSSOSHomeWebViewUI.a(this.qeq);
        c cVar = a.sJQ;
        if (cVar != null) {
            cVar.sendMessage(Message.obtain(a.sJQ, 15, motionEvent));
        }
        return this.pOj.onTouchEvent(motionEvent);
    }
}
