package com.tencent.mm.plugin.appbrand.debugger;

class RemoteDebugMoveView$2 implements Runnable {
    final /* synthetic */ RemoteDebugMoveView fts;

    RemoteDebugMoveView$2(RemoteDebugMoveView remoteDebugMoveView) {
        this.fts = remoteDebugMoveView;
    }

    public final void run() {
        if (this.fts.getY() + ((float) this.fts.getHeight()) > ((float) RemoteDebugMoveView.c(this.fts))) {
            this.fts.setY((float) (RemoteDebugMoveView.c(this.fts) - this.fts.getHeight()));
        }
    }
}
