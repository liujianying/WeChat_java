package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.g.a.cu;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;
import java.util.Map;

public final class e {
    private cu ihn = new cu();
    public final Map<String, Integer> iho = new HashMap();

    public final void g(String str, int i, int i2, String str2) {
        this.ihn.bKj.bKk = str;
        this.ihn.bKj.status = i;
        this.ihn.bKj.progress = i2;
        this.ihn.bKj.bKl = str2;
        a.sFg.m(this.ihn);
        if (i != 6) {
            this.iho.remove(str);
        } else if (i2 < 0 || i2 >= 100) {
            this.iho.remove(str);
        } else {
            this.iho.put(str, Integer.valueOf(i2));
        }
    }
}
