package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.sdk.platformtools.x;

class AbstractVideoView$8 implements Runnable {
    final /* synthetic */ AbstractVideoView qED;

    AbstractVideoView$8(AbstractVideoView abstractVideoView) {
        this.qED = abstractVideoView;
    }

    public final void run() {
        if (this.qED.jfO != null && this.qED.jfO.getVisibility() != 0) {
            x.i(this.qED.TAG, "%s show loading", new Object[]{this.qED.avy()});
            this.qED.jfO.setVisibility(0);
            if (this.qED.gbe != null) {
                this.qED.gbe.by(this.qED.getSessionId(), this.qED.getMediaId());
            }
        }
    }
}
