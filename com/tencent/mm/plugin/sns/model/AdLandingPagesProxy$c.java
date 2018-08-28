package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a;
import com.tencent.mm.sdk.platformtools.x;

class AdLandingPagesProxy$c implements a {
    public long id;
    final /* synthetic */ AdLandingPagesProxy nmu;

    private AdLandingPagesProxy$c(AdLandingPagesProxy adLandingPagesProxy) {
        this.nmu = adLandingPagesProxy;
    }

    /* synthetic */ AdLandingPagesProxy$c(AdLandingPagesProxy adLandingPagesProxy, byte b) {
        this(adLandingPagesProxy);
    }

    public final void start() {
        this.nmu.CLIENT_CALL("start", new Object[]{Long.valueOf(this.id)});
    }

    public final void wo(int i) {
        x.v("AdLandingPagesProxy", "progress %d", Integer.valueOf(i));
        this.nmu.CLIENT_CALL("progress", new Object[]{Long.valueOf(this.id), Integer.valueOf(i)});
    }

    public final void bxj() {
        this.nmu.CLIENT_CALL("paused", new Object[]{Long.valueOf(this.id)});
    }

    public final void bxk() {
        this.nmu.CLIENT_CALL("stopped", new Object[]{Long.valueOf(this.id)});
    }

    public final void bxl() {
        this.nmu.CLIENT_CALL("succeed", new Object[]{Long.valueOf(this.id)});
    }

    public final void bxm() {
        this.nmu.CLIENT_CALL("failed", new Object[]{Long.valueOf(this.id)});
    }

    public final void bxn() {
        this.nmu.CLIENT_CALL("resumed", new Object[]{Long.valueOf(this.id)});
    }
}
