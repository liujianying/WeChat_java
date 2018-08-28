package com.tencent.mm.app;

import android.content.Intent;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import java.util.HashMap;

public final class j {
    static ApplicationLike applicationLike;
    static String byA = "";
    static long bya;
    String byB;
    String byC;
    long byD;
    long byE;

    public j(ApplicationLike applicationLike) {
        applicationLike = applicationLike;
        b.applicationLike = applicationLike;
    }

    static void a(ApplicationLike applicationLike) {
        if (applicationLike != null) {
            if (applicationLike == null || applicationLike.getApplication() == null) {
                throw new TinkerRuntimeException("tinkerApplication is null");
            }
            Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
            HashMap aK = (tinkerResultIntent == null || ShareIntentUtil.aE(tinkerResultIntent) != 0) ? null : ShareIntentUtil.aK(tinkerResultIntent);
            if (aK != null) {
                a.PATCH_REV = (String) aK.get("patch.rev");
                x.w("MicroMsg.MMApplicationLikeImpl", "application set patch rev:%s", a.PATCH_REV);
            }
        }
    }
}
