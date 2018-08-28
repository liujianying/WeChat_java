package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.ad;

class RemoteDebugMoveView$1 implements Runnable {
    final /* synthetic */ RemoteDebugMoveView fts;

    RemoteDebugMoveView$1(RemoteDebugMoveView remoteDebugMoveView) {
        this.fts = remoteDebugMoveView;
    }

    public final void run() {
        this.fts.setX((float) (RemoteDebugMoveView.a(this.fts) - RemoteDebugMoveView.b(this.fts)));
        this.fts.setY((float) ((int) (a.getDensity(ad.getContext()) * 120.0f)));
    }
}
