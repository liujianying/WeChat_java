package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.b;

final class ad implements b {
    private int aFG = 2;
    private boolean aHi;

    ad() {
    }

    public final int getLogLevel() {
        return this.aFG;
    }

    public final void setLogLevel(int i) {
        this.aFG = i;
        if (!this.aHi) {
            aj.aHt.get();
            new StringBuilder("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.").append((String) aj.aHt.get()).append(" DEBUG");
            this.aHi = true;
        }
    }
}
