package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ab.j;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

final class a extends j {
    com.tencent.mm.model.ay.a oEL = new com.tencent.mm.model.ay.a();
    b oEM = new b();

    a() {
    }

    public final int getType() {
        return 616;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getvoiceprintresourcersa";
    }

    public final e Id() {
        return this.oEM;
    }

    protected final d Ic() {
        return this.oEL;
    }

    public final int KP() {
        return 1;
    }
}
