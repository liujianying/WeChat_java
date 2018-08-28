package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI$a.a;
import com.tencent.mm.sdk.platformtools.x;

class SnsAdNativeLandingTestUI$9 implements a {
    final /* synthetic */ SnsAdNativeLandingTestUI nTe;

    SnsAdNativeLandingTestUI$9(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        this.nTe = snsAdNativeLandingTestUI;
    }

    public final void cg(String str, int i) {
        if (!SnsAdNativeLandingTestUI.a(this.nTe).isPlaying()) {
            SnsAdNativeLandingTestUI.a(this.nTe).setLoop(false);
            if (!str.equals(SnsAdNativeLandingTestUI.a(this.nTe).getVideoPath())) {
                SnsAdNativeLandingTestUI.a(this.nTe).setVideoPath(str);
            }
            if (this.nTe.nTd.getIsPlay()) {
                SnsAdNativeLandingTestUI.a(this.nTe).x(SnsAdNativeLandingTestUI.d(this.nTe));
                SnsAdNativeLandingTestUI.a(this.nTe).start();
            }
        }
    }

    public final void MY(String str) {
        x.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", str);
    }

    public final void MZ(String str) {
        SnsAdNativeLandingTestUI.a(this.nTe).setVideoPath(str);
        SnsAdNativeLandingTestUI.a(this.nTe).setLoop(true);
        if (this.nTe.nTd.getIsPlay()) {
            SnsAdNativeLandingTestUI.a(this.nTe).x(SnsAdNativeLandingTestUI.d(this.nTe));
            SnsAdNativeLandingTestUI.a(this.nTe).start();
        }
    }
}
