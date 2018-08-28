package com.tencent.xweb.sys;

import android.content.Context;
import android.webkit.CookieSyncManager;

public final class b implements com.tencent.xweb.c.b.b {
    CookieSyncManager vCK;

    public final void init(Context context) {
        this.vCK = CookieSyncManager.createInstance(context);
    }

    public final void sync() {
        if (this.vCK != null) {
            this.vCK.sync();
        }
    }
}
