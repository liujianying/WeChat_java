package com.tencent.mm.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.ui.tools.bag.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.l;

class MMAppMgr$9 implements a {
    final /* synthetic */ MMAppMgr tnp;

    MMAppMgr$9(MMAppMgr mMAppMgr) {
        this.tnp = mMAppMgr;
    }

    public final boolean vD() {
        if (this.tnp.vLK >= 30) {
            return false;
        }
        if (!l.fv(ad.getContext()) && !this.tnp.tnl && g.Eg().Dx()) {
            this.tnp.vLL = true;
            j.qcm.bWV();
            return false;
        } else if (this.tnp.tnl && this.tnp.vLL && g.Eg().Dx()) {
            this.tnp.vLL = false;
            j.qcm.nc(true);
            return false;
        } else {
            MMAppMgr mMAppMgr = this.tnp;
            mMAppMgr.vLK++;
            return true;
        }
    }
}
