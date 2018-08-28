package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;

class c$1 implements a {
    final /* synthetic */ c hlx;

    c$1(c cVar) {
        this.hlx = cVar;
    }

    public final boolean a(Preference preference, Object obj) {
        String str = (String) obj;
        int i = -1;
        if ("male".equalsIgnoreCase(str)) {
            i = 1;
        } else if ("female".equalsIgnoreCase(str)) {
            i = 2;
        }
        if (i > 0) {
            au.HU();
            c.DT().set(12290, Integer.valueOf(i));
        }
        return false;
    }
}
