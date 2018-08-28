package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ab.j;
import com.tencent.mm.model.ba$b;
import com.tencent.mm.model.ba.a;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

final class c extends j {
    a oEP = new a();
    ba$b oEQ = new ba$b();

    c() {
    }

    public final int getType() {
        return 617;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/verifyvoiceprintrsa";
    }

    public final e Id() {
        return this.oEQ;
    }

    protected final d Ic() {
        return this.oEP;
    }

    public final int KP() {
        return 1;
    }
}
