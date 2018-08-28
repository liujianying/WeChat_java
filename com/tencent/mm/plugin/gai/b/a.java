package com.tencent.mm.plugin.gai.b;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class a implements ar {
    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.SubCoreGai", "SubCoreGai onAccountPostReset!");
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreGai", "SubCoreGai onAccountRelease!");
    }
}
