package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.sdk.platformtools.x;

class h$2 implements Runnable {
    final /* synthetic */ h kFD;
    final /* synthetic */ int kFE;

    h$2(h hVar, int i) {
        this.kFD = hVar;
        this.kFE = i;
    }

    public final void run() {
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker pos=%d", new Object[]{Integer.valueOf(this.kFE)});
        this.kFD.kFz.En(this.kFE);
    }
}
