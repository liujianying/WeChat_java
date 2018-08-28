package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.sdk.platformtools.al.a;

class AbstractVideoView$1 implements a {
    final /* synthetic */ AbstractVideoView qED;

    AbstractVideoView$1(AbstractVideoView abstractVideoView) {
        this.qED = abstractVideoView;
    }

    public final boolean vD() {
        if (!this.qED.isPlaying()) {
            return false;
        }
        if (this.qED.qEp) {
            if (this.qED.gbe != null) {
                this.qED.gbe.bx(this.qED.getSessionId(), this.qED.getMediaId());
            }
            this.qED.qEp = false;
        }
        this.qED.mH(this.qED.getCurrPosSec());
        AbstractVideoView.a(this.qED, this.qED.isPlaying());
        return true;
    }
}
