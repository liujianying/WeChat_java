package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.u;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class SandBoxProfile extends e {
    public static final String byu = (ad.getPackageName() + ":sandbox");

    public final void onCreate() {
        c bj = c.bj(ad.getContext());
        k.setupBrokenLibraryHandler();
        k.b("MMProtocalJni", SandBoxProfile.class.getClassLoader());
        k.b(a.sFa, SandBoxProfile.class.getClassLoader());
        MMProtocalJni.setClientPackVersion(d.qVN);
        u uVar = new u(bj);
        try {
            uVar.ez("SANDBOX");
            af.exb = bi.a(uVar.eA(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
            x.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + af.exb);
        } catch (Error e) {
        }
        o.ve();
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return byu;
    }
}
