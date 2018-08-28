package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.g.a.ft;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.sdk.b.c;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class g {
    Set<String> ihv;
    c<ft> ihw;
    private a ihx;

    public g() {
        this.ihw = new 1(this);
        this.ihx = new 2(this);
        this.ihv = Collections.synchronizedSet(new HashSet());
        i.aEu().ihj = this.ihx;
        this.ihw.cht();
    }
}
