package com.tencent.mm.plugin.voiceprint.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class BaseVoicePrintUI$10 implements OnTouchListener {
    private long kHe = 0;
    final /* synthetic */ BaseVoicePrintUI oFR;
    private boolean oFT = false;

    BaseVoicePrintUI$10(BaseVoicePrintUI baseVoicePrintUI) {
        this.oFR = baseVoicePrintUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                BaseVoicePrintUI.a(this.oFR, false);
                if (!bi.oW(this.oFR.oFo)) {
                    this.kHe = System.currentTimeMillis();
                    BaseVoicePrintUI.f(this.oFR).setPressed(true);
                    BaseVoicePrintUI.l(this.oFR);
                    this.oFR.bJa();
                    BaseVoicePrintUI.m(this.oFR).sendEmptyMessageDelayed(1, 300);
                    x.i("MicroMsg.BaseVoicePrintUI", "mic press down");
                    break;
                }
                break;
            case 1:
            case 3:
                BaseVoicePrintUI.f(this.oFR).setPressed(false);
                BaseVoicePrintUI.m(this.oFR).removeMessages(1);
                if (System.currentTimeMillis() - this.kHe < 300) {
                    x.d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
                    BaseVoicePrintUI.a(this.oFR, false);
                } else {
                    BaseVoicePrintUI.a(this.oFR, true);
                }
                x.i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", new Object[]{Integer.valueOf(motionEvent.getAction()), Boolean.valueOf(BaseVoicePrintUI.n(this.oFR))});
                BaseVoicePrintUI.g(this.oFR).stop();
                BaseVoicePrintUI.e(this.oFR).SO();
                BaseVoicePrintUI.a(this.oFR).wk();
                if (!BaseVoicePrintUI.n(this.oFR)) {
                    BaseVoicePrintUI.c(this.oFR).setErr(R.l.voice_print_err_time);
                    BaseVoicePrintUI.c(this.oFR).bJp();
                    break;
                }
                BaseVoicePrintUI baseVoicePrintUI = this.oFR;
                x.d("MicroMsg.BaseVoicePrintUI", "releaseMic");
                if (!baseVoicePrintUI.oFJ.oFz) {
                    baseVoicePrintUI.oFP.SO();
                    baseVoicePrintUI.oFI.setErr(R.l.voice_print_err_time);
                    baseVoicePrintUI.oFI.bJp();
                    baseVoicePrintUI.oFK = null;
                }
                baseVoicePrintUI.oFG.setVisibility(8);
                baseVoicePrintUI.oFI.bJn();
                baseVoicePrintUI.oFI.setTipText(baseVoicePrintUI.oFo);
                x.d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", new Object[]{BaseVoicePrintUI.d(this.oFR)});
                if (!bi.oW(BaseVoicePrintUI.d(this.oFR))) {
                    this.oFR.bJc();
                }
                this.kHe = 0;
                this.oFT = false;
                BaseVoicePrintUI.a(this.oFR, false);
                break;
        }
        return false;
    }
}
