package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a;
import com.tencent.mm.sdk.platformtools.ag;

class SnsAdNativeLandingTestUI$a$1 implements SnsAdNativeLandingTestUI$a$a {
    final /* synthetic */ ag hlG;
    final /* synthetic */ SnsAdNativeLandingTestUI$a$a nTj;
    final /* synthetic */ a nTk;

    SnsAdNativeLandingTestUI$a$1(a aVar, ag agVar, SnsAdNativeLandingTestUI$a$a snsAdNativeLandingTestUI$a$a) {
        this.nTk = aVar;
        this.hlG = agVar;
        this.nTj = snsAdNativeLandingTestUI$a$a;
    }

    public final void cg(final String str, final int i) {
        this.hlG.post(new Runnable() {
            public final void run() {
                SnsAdNativeLandingTestUI$a$1.this.nTj.cg(str, i);
            }
        });
    }

    public final void MY(String str) {
        this.hlG.post(new 2(this, str));
    }

    public final void MZ(final String str) {
        this.hlG.post(new Runnable() {
            public final void run() {
                SnsAdNativeLandingTestUI$a$1.this.nTj.MZ(str);
            }
        });
    }
}
