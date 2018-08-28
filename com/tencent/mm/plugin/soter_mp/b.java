package com.tencent.mm.plugin.soter_mp;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.soter_mp.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class b implements ar {
    private static com.tencent.mm.plugin.soter_mp.b.b onZ = new com.tencent.mm.plugin.soter_mp.b.b();
    private static a ooa = new a();

    public final HashMap<Integer, d> Ci() {
        x.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoter getBaseDBFactories");
        return null;
    }

    public final void gi(int i) {
        x.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoter clearPluginData");
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoter onAccountPostReset");
        if (!com.tencent.mm.sdk.b.a.sFg.d(onZ)) {
            com.tencent.mm.sdk.b.a.sFg.b(onZ);
        }
        if (!com.tencent.mm.sdk.b.a.sFg.d(ooa)) {
            com.tencent.mm.sdk.b.a.sFg.b(ooa);
        }
    }

    public final void bo(boolean z) {
        x.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoterMp onSdcardMount");
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoterMp onAccountRelease");
    }
}
