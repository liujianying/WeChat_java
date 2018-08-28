package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;

public class NoSpaceProfile extends e {
    public static final String byu = (ad.getPackageName() + ":nospace");

    public final void onCreate() {
        k.cN(byu);
        k.setupBrokenLibraryHandler();
        w.initLanguage(ad.getContext());
        o.ve();
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }
}
