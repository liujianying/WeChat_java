package com.tencent.mm.model;

import com.tencent.mm.ab.j;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.u.a;
import com.tencent.mm.protocal.u.b;

public final class ax extends j {
    private final a dBQ = new a();
    private final b dBR = new b();

    protected final d Ic() {
        return this.dBQ;
    }

    public final e Id() {
        return this.dBR;
    }

    public final int getType() {
        return 126;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/newreg";
    }
}
