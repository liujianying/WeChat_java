package com.tencent.mm.plugin.appbrand.game.e;

public abstract class c implements Runnable {
    e<c> fDn;

    public abstract void execute();

    public void run() {
        execute();
        if (this.fDn != null) {
            this.fDn.j(this);
        }
    }
}
