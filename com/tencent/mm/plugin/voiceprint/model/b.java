package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ab.j;
import com.tencent.mm.model.az$b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

final class b extends j {
    a oEN = new a();
    az$b oEO = new az$b();

    b() {
    }

    public final int getType() {
        return 618;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getvoiceprintticketrsa";
    }

    public final e Id() {
        return this.oEO;
    }

    protected final d Ic() {
        return this.oEN;
    }

    public final int KP() {
        return 1;
    }
}
