package com.tencent.mm.pluginsdk.ui.chat;

import android.app.Activity;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

class n$9 implements b {
    final /* synthetic */ n qNT;

    n$9(n nVar) {
        this.qNT = nVar;
    }

    public final void cdF() {
        n.a(this.qNT, System.currentTimeMillis());
        x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[]{Long.valueOf(n.l(this.qNT))});
        x.d("VOICEDEBUG", "Start Record Time = %s", new Object[]{Long.valueOf(n.l(this.qNT))});
        n.b(this.qNT, false);
        n.c(this.qNT, true);
        n.d(this.qNT, true);
        n.b(this.qNT, 0);
        n.m(this.qNT);
        n.h(this.qNT);
        n.n(this.qNT).setVisibility(8);
        n.c(this.qNT, false);
        n.g(this.qNT).qHv = 3;
        n.g(this.qNT).b(n.f(this.qNT));
        n.ceX();
        if (n.f(this.qNT) != null) {
            if (n.f(this.qNT).getText() != null && n.f(this.qNT).getText().length() > 0) {
                n.f(this.qNT).setCursorVisible(true);
            }
            n.f(this.qNT).requestFocus();
            bi.hideVKB(n.k(this.qNT));
        }
        if (n.o(this.qNT) instanceof Activity) {
            ((Activity) n.o(this.qNT)).getWindow().addFlags(128);
        }
        n.p(this.qNT).setVisibility(4);
        n.q(this.qNT).setVisibility(4);
        n.r(this.qNT).setVisibility(8);
        n.f(this.qNT).setHint(this.qNT.getResources().getString(R.l.voice_input_panel_hint_content));
        n.j(this.qNT).ki(true);
    }

    public final void cdG() {
        n.j(this.qNT).ki(false);
        n.f(this.qNT).setHint(null);
    }

    public final void cdH() {
        x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        n.s(this.qNT);
        n.g(this.qNT).a(n.f(this.qNT));
        n.h(this.qNT);
        if (n.o(this.qNT) instanceof Activity) {
            ((Activity) n.o(this.qNT)).getWindow().clearFlags(128);
        }
        n.Co(2);
        n.j(this.qNT).ki(false);
        n.f(this.qNT).setHint(null);
    }

    public final void cdI() {
        x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[]{Long.valueOf(System.currentTimeMillis())});
        n.g(this.qNT).a(n.f(this.qNT));
        n.h(this.qNT);
        if (n.o(this.qNT) instanceof Activity) {
            ((Activity) n.o(this.qNT)).getWindow().clearFlags(128);
        }
        n.Co(3);
        n.j(this.qNT).ki(false);
        n.f(this.qNT).setHint(null);
    }

    public final void cdJ() {
        x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[]{Long.valueOf(System.currentTimeMillis())});
        n.s(this.qNT);
        n.g(this.qNT).a(n.f(this.qNT));
        n.h(this.qNT);
        if (n.o(this.qNT) instanceof Activity) {
            ((Activity) n.o(this.qNT)).getWindow().clearFlags(128);
        }
        n.Cp(1);
        n.j(this.qNT).ki(false);
        n.f(this.qNT).setHint(null);
    }

    public final void b(String[] strArr, Set<String> set) {
        if (strArr != null && strArr.length > 0 && strArr[0].length() > 0) {
            if (n.t(this.qNT)) {
                n.d(this.qNT, false);
                n.u(this.qNT);
            }
            n.g(this.qNT).a(n.f(this.qNT), strArr[0], true);
            if (n.f(this.qNT).getText().length() != 0) {
                n.f(this.qNT).setCursorVisible(true);
                n.f(this.qNT).requestFocus();
                bi.hideVKB(n.k(this.qNT));
            }
            if (!(n.v(this.qNT) || strArr[0].length() == 0)) {
                n.b(this.qNT, true);
                n.b(this.qNT, System.currentTimeMillis());
                x.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(n.w(this.qNT) - n.l(this.qNT))});
            }
            n.x(this.qNT).addAll(set);
        }
    }

    public final void ag(int i, int i2, int i3) {
        x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis())});
        n.s(this.qNT);
        n.g(this.qNT).a(n.f(this.qNT));
        n.h(this.qNT);
        if (n.o(this.qNT) instanceof Activity) {
            ((Activity) n.o(this.qNT)).getWindow().clearFlags(128);
        }
        n.Cp(i);
        if (i == 12) {
            n.b(this.qNT, R.l.voice_input_please_check_network);
        } else {
            n.b(this.qNT, R.l.app_err_system_busy_tip);
        }
        n.j(this.qNT).ki(false);
        n.f(this.qNT).setHint(null);
    }
}
