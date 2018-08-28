package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.sdk.platformtools.al.a;

class AbstractVideoView$5 implements a {
    final /* synthetic */ AbstractVideoView qED;

    AbstractVideoView$5(AbstractVideoView abstractVideoView) {
        this.qED = abstractVideoView;
    }

    public final boolean vD() {
        if (AbstractVideoView.a(this.qED) <= 0) {
            return false;
        }
        if (!this.qED.isPlaying()) {
            return true;
        }
        AbstractVideoView.b(this.qED);
        return false;
    }
}
