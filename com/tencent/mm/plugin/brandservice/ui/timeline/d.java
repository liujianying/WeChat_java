package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.aa.a;

public final class d {
    public static boolean avi() {
        return (((Integer) g.Ei().DT().get(a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(0))).intValue() & 2) > 0;
    }
}
