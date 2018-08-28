package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

class ab$1 implements Runnable {
    final /* synthetic */ ab nGb;

    ab$1(ab abVar) {
        this.nGb = abVar;
    }

    public final void run() {
        try {
            ab.a(this.nGb).await();
        } catch (InterruptedException e) {
        }
        this.nGb.contentView.post(new 1(this));
    }
}
