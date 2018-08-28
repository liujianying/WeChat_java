package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.f.a;
import com.tencent.mm.sdk.platformtools.ad;

public class TMAssistantProfile extends e {
    public static final String byu = (ad.getPackageName() + ":TMAssistantDownloadSDKService");

    public final void onCreate() {
        a.bh(ad.getContext());
        k.cN(byu);
        k.setupBrokenLibraryHandler();
        o.ve();
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public String toString() {
        return byu;
    }
}
