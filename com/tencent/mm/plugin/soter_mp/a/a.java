package com.tencent.mm.plugin.soter_mp.a;

import android.app.Activity;
import com.tencent.mm.plugin.soter_mp.b.d;
import com.tencent.mm.plugin.soter_mp.b.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public final class a {
    public static final int oob = 1;
    private static final /* synthetic */ int[] ooc = new int[]{oob};

    public static c a(Activity activity, d dVar, e eVar) {
        if ((dVar.oot & 1) != 0 && com.tencent.d.a.a.hy(ad.getContext())) {
            return new b(new WeakReference(activity), dVar, eVar);
        }
        x.e("MicroMsg.SoterControllerFactory", "hy: no matching: %d", new Object[]{Byte.valueOf(dVar.oot)});
        return null;
    }
}
