package com.tencent.mm.plugin.sns.data;

import com.tencent.mm.protocal.c.bon;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    public ConcurrentHashMap<String, CharSequence> nkP = new ConcurrentHashMap();

    public final void a(bon bon, CharSequence charSequence) {
        this.nkP.put(bon.smh + "-" + bon.smk + "-" + bon.jSA, charSequence);
    }
}
