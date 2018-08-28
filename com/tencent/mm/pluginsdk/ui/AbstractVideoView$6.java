package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.plugin.sight.decode.ui.b;

class AbstractVideoView$6 implements b {
    final /* synthetic */ AbstractVideoView qED;

    AbstractVideoView$6(AbstractVideoView abstractVideoView) {
        this.qED = abstractVideoView;
    }

    public final void ajO() {
    }

    public final void kV(int i) {
        if (this.qED.x(i, true)) {
            this.qED.bS(false);
        }
        this.qED.qEk.setIsPlay(true);
    }
}
