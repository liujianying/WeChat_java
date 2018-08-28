package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;

public interface d extends com.tencent.mm.kernel.c.a {

    public interface a {
        LocalUsageInfo alV();
    }

    public enum b {
        ;

        static {
            gPz = 1;
            gPA = 2;
            gPB = new int[]{gPz, gPA};
        }
    }

    AppBrandRecentView a(Context context, int i, a aVar);

    void aoX();

    b aoY();

    void cN(Context context);

    AppBrandRecentView z(Context context, int i);
}
