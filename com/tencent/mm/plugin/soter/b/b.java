package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.ab.j;
import com.tencent.mm.plugin.soter.b.c.a;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

final class b extends j {
    a ont = new a();
    com.tencent.mm.plugin.soter.b.c.b onu = new com.tencent.mm.plugin.soter.b.c.b();

    b() {
    }

    public final int getType() {
        return 627;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/updatesoteraskrsa";
    }

    public final e Id() {
        return this.onu;
    }

    protected final d Ic() {
        return this.ont;
    }

    public final int KP() {
        return 1;
    }
}
