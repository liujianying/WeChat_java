package com.tencent.mm.plugin.appbrand.ui.banner;

import com.tencent.mm.plugin.appbrand.jsapi.h;
import java.util.HashMap;
import java.util.Map;

public final class c extends h {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onStickyStatusChange";

    public final void ab(String str, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isSticky", Boolean.valueOf(z));
        x(hashMap).aC(str, 0).ahM();
    }
}
