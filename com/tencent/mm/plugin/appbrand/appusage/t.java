package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ah;
import com.tencent.mm.storage.aa.a;

public final class t extends ah {
    public final void transfer(int i) {
        if (gV(i)) {
            g.Ei().DT().a(a.sTW, Boolean.valueOf(false));
        }
    }

    public final boolean gV(int i) {
        int i2 = 1;
        int i3 = i != 0 ? 1 : 0;
        if (i >= 637927936) {
            i2 = 0;
        }
        return i2 & i3;
    }

    public final String getTag() {
        return "MicroMsg.AppBrand.DuplicateUsageUsernameSetFlagDataTransfer";
    }
}
