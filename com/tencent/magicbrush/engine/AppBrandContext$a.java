package com.tencent.magicbrush.engine;

import java.util.TimerTask;

public class AppBrandContext$a extends TimerTask {
    public int bnu;
    public boolean bnv;
    final /* synthetic */ AppBrandContext bnw;

    public AppBrandContext$a(AppBrandContext appBrandContext, int i, boolean z) {
        this.bnw = appBrandContext;
        this.bnu = i;
        this.bnv = z;
    }

    public final void run() {
        if (!AppBrandContext.b(this.bnw)) {
            AppBrandContext.d(this.bnw).post(new 1(this));
        } else if (!this.bnv) {
            AppBrandContext.c(this.bnw).add(Integer.valueOf(this.bnu));
        }
    }
}
