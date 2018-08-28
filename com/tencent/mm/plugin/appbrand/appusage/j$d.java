package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa.a;
import java.util.Arrays;

public final class j$d {
    public final String[] flZ = new String[9];

    public j$d() {
        Arrays.fill(this.flZ, "0");
        this.flZ[0] = (String) g.Ei().DT().get(a.sTF, "");
        this.flZ[1] = String.valueOf(g.Ei().DT().get(a.sTG, Long.valueOf(0)));
        this.flZ[2] = String.valueOf(bi.VE());
    }
}
