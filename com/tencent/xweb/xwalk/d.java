package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.xweb.c.b.b;
import org.xwalk.core.XWalkCookieManager;

public final class d implements b {
    XWalkCookieManager vEK = new XWalkCookieManager();

    public final void init(Context context) {
    }

    public final void sync() {
        if (this.vEK != null) {
            this.vEK.flushCookieStore();
        }
    }
}
