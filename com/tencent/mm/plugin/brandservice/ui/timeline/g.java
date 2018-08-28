package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.storage.q;
import java.util.HashMap;

public final class g {
    int hrZ;
    int hsa;
    HashMap<Long, a> hsb = new HashMap();

    public final void a(q qVar, boolean z) {
        a aVar = (a) this.hsb.get(Long.valueOf(qVar.field_msgId));
        if (aVar != null) {
            aVar.rju = z ? 1 : 2;
        }
    }
}
