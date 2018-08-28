package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.37;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i$a;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class FTSSOSHomeWebViewUI$b extends d {
    c qeA = new d(this, (byte) 0);
    c qeB = new b(this, (byte) 0);
    c qeC = new c(this, (byte) 0);
    final /* synthetic */ FTSSOSHomeWebViewUI qeq;
    c qez = new a(this, (byte) 0);

    private class a extends b {
        private a() {
        }

        /* synthetic */ a(FTSSOSHomeWebViewUI$b fTSSOSHomeWebViewUI$b, byte b) {
            this();
        }

        public final void enter() {
            super.enter();
            FTSSOSHomeWebViewUI.F(FTSSOSHomeWebViewUI$b.this.qeq);
        }

        public final void exit() {
            super.exit();
            FTSSOSHomeWebViewUI.G(FTSSOSHomeWebViewUI$b.this.qeq).setBackgroundColor(FTSSOSHomeWebViewUI$b.this.qeq.getResources().getColor(R.e.transparent));
        }

        public final boolean j(Message message) {
            switch (message.what) {
                case 0:
                case 13:
                    if (FTSSOSHomeWebViewUI$b.this.qeq.getTotalQuery().length() > 0) {
                        FTSSOSHomeWebViewUI$b.this.qeq.bXk().aQY();
                        FTSSOSHomeWebViewUI$b.this.qeq.bXk().jzo.clearFocus();
                        FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI$b.this.qeq, 0);
                        FTSSOSHomeWebViewUI.H(FTSSOSHomeWebViewUI$b.this.qeq).AZ(a.b.qfr);
                        FTSSOSHomeWebViewUI.g(FTSSOSHomeWebViewUI$b.this.qeq, a.b.qfr);
                        FTSSOSHomeWebViewUI$b.this.qeq.qdi.setBackgroundResource(R.e.white);
                        FTSSOSHomeWebViewUI.z(FTSSOSHomeWebViewUI$b.this.qeq).clear();
                        break;
                    }
                    break;
                case 1:
                    FTSSOSHomeWebViewUI$b.this.qeq.bXk().aQY();
                    FTSSOSHomeWebViewUI.I(FTSSOSHomeWebViewUI$b.this.qeq).AZ(a.b.qfr);
                    FTSSOSHomeWebViewUI.g(FTSSOSHomeWebViewUI$b.this.qeq, a.b.qfr);
                    FTSSOSHomeWebViewUI$b.this.qeq.qdi.setBackgroundResource(R.e.white);
                    FTSSOSHomeWebViewUI.z(FTSSOSHomeWebViewUI$b.this.qeq).clear();
                    FTSSOSHomeWebViewUI.J(FTSSOSHomeWebViewUI$b.this.qeq);
                    break;
                case 3:
                    FTSSOSHomeWebViewUI$b.this.qeq.qdn = true;
                    FTSSOSHomeWebViewUI$b.this.b(FTSSOSHomeWebViewUI$b.this.qeA);
                    break;
                case 4:
                    FTSSOSHomeWebViewUI$b.this.qeq.qdn = true;
                    FTSSOSHomeWebViewUI$b.this.b(FTSSOSHomeWebViewUI$b.this.qeB);
                    break;
                case 5:
                    if (FTSSOSHomeWebViewUI$b.this.qeq.bXk().getEditText().hasFocus() && FTSSOSHomeWebViewUI$b.this.qeq.getTotalQuery().length() > 0) {
                        FTSSOSHomeWebViewUI.A(FTSSOSHomeWebViewUI$b.this.qeq);
                    }
                    if (FTSSOSHomeWebViewUI$b.this.qeq.bXk().getEditText().hasFocus() && FTSSOSHomeWebViewUI$b.this.qeq.getTotalQuery().length() == 0) {
                        FTSSOSHomeWebViewUI$b.this.qeq.bXk().aQY();
                        FTSSOSHomeWebViewUI.I(FTSSOSHomeWebViewUI$b.this.qeq).AZ(a.b.qfr);
                        FTSSOSHomeWebViewUI.g(FTSSOSHomeWebViewUI$b.this.qeq, a.b.qfr);
                        FTSSOSHomeWebViewUI$b.this.qeq.qdi.setBackgroundResource(R.e.white);
                        FTSSOSHomeWebViewUI.z(FTSSOSHomeWebViewUI$b.this.qeq).clear();
                        FTSSOSHomeWebViewUI$b.this.qeq.I(new Runnable() {
                            public final void run() {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d K = FTSSOSHomeWebViewUI.K(FTSSOSHomeWebViewUI$b.this.qeq);
                                if (K.qhq) {
                                    x.i("MicroMsg.JsApiHandler", "onFocusSearchInput success, ready");
                                    ah.A(new 37(K, i$a.a("onFocusSearchInput", null, K.qhs, K.qht)));
                                    return;
                                }
                                x.e("MicroMsg.JsApiHandler", "onFocusSearchInput fail, not ready");
                            }
                        });
                        FTSSOSHomeWebViewUI$b.this.qeq.qdj.setVoiceImageButtonVisibile(8);
                        h.mEJ.h(15521, new Object[]{Integer.valueOf(FTSSOSHomeWebViewUI$b.this.qeq.scene), Integer.valueOf(3), FTSSOSHomeWebViewUI$b.this.qeq.bXk().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI$b.this.qeq.qdD)});
                        break;
                    }
                case 14:
                    FTSSOSHomeWebViewUI$b.this.qeq.bXk().aQY();
                    FTSSOSHomeWebViewUI$b.this.qeq.bXk().jzo.clearFocus();
                    FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI$b.this.qeq, 0);
                    FTSSOSHomeWebViewUI.H(FTSSOSHomeWebViewUI$b.this.qeq).aa(a.b.qfr, false);
                    FTSSOSHomeWebViewUI.g(FTSSOSHomeWebViewUI$b.this.qeq, a.b.qfr);
                    FTSSOSHomeWebViewUI$b.this.qeq.qdi.setBackgroundResource(R.e.white);
                    FTSSOSHomeWebViewUI.z(FTSSOSHomeWebViewUI$b.this.qeq).clear();
                    FTSSOSHomeWebViewUI$b.this.b(FTSSOSHomeWebViewUI$b.this.qeB);
                    FTSSOSHomeWebViewUI$b.this.qeq.qdn = true;
                    break;
                case 15:
                    if (FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI$b.this.qeq) != null && FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI$b.this.qeq).getVisibility() == 0) {
                        MotionEvent motionEvent = (MotionEvent) message.obj;
                        FTSMainUIEducationLayout c = FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI$b.this.qeq);
                        x.v("MicroMsg.FTS.FTSMainUIEducationLayout", "action %d", new Object[]{Integer.valueOf(motionEvent.getAction())});
                        switch (motionEvent.getAction()) {
                            case 0:
                                for (TextView textView : c.jzN.values()) {
                                    int[] iArr = new int[2];
                                    textView.getLocationOnScreen(iArr);
                                    if (new Rect(iArr[0], iArr[1], iArr[0] + textView.getWidth(), iArr[1] + textView.getHeight()).contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                        if (textView != null) {
                                            c.jzR = textView;
                                            c.fto = motionEvent.getRawX();
                                            c.ftp = motionEvent.getRawY();
                                            c.jzP = System.currentTimeMillis();
                                            break;
                                        }
                                    }
                                }
                                TextView textView2 = null;
                                if (textView2 != null) {
                                    c.jzR = textView2;
                                    c.fto = motionEvent.getRawX();
                                    c.ftp = motionEvent.getRawY();
                                    c.jzP = System.currentTimeMillis();
                                    break;
                                }
                                break;
                            case 1:
                            case 9:
                                if (c.jzR != null) {
                                    x.v("MicroMsg.FTS.FTSMainUIEducationLayout", "action up deltaX %f, deltaY %f, time interval %d", new Object[]{Float.valueOf(motionEvent.getRawX() - c.fto), Float.valueOf(motionEvent.getRawY() - c.ftp), Long.valueOf(System.currentTimeMillis() - c.jzP)});
                                    if (Math.abs(motionEvent.getRawX() - c.fto) <= c.gcx && Math.abs(r0) <= c.gcx && System.currentTimeMillis() - c.jzP < 200 && c.jxn != null) {
                                        c.jxn.onClick(c.jzR);
                                    }
                                    c.jzR = null;
                                    break;
                                }
                                break;
                            case 3:
                                c.jzR = null;
                                break;
                        }
                    }
                    break;
            }
            return super.j(message);
        }

        public final String getName() {
            return "InitSate";
        }
    }

    protected FTSSOSHomeWebViewUI$b(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, String str, Looper looper) {
        this.qeq = fTSSOSHomeWebViewUI;
        super(str, looper);
        a(this.qez);
        a(this.qeA);
        a(this.qeB);
        a(this.qeC);
        b(this.qez);
    }

    public final void bXx() {
        this.qeq.qdj.setVoiceImageButtonVisibile(0);
        b(this.qez);
    }

    public final boolean bXy() {
        com.tencent.mm.sdk.d.a cjn = cjn();
        return cjn == this.qeA || cjn == this.qeB || cjn == this.qeC;
    }
}
