package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ab.j;
import com.tencent.mm.plugin.facedetect.b.k.a;
import com.tencent.mm.plugin.facedetect.b.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

final class g extends j {
    a iMl = new a();
    b iMm = new b();

    g() {
    }

    public final int getType() {
        return 930;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/verifyfacersa";
    }

    public final e Id() {
        return this.iMm;
    }

    protected final d Ic() {
        return this.iMl;
    }

    public final int KP() {
        return 1;
    }
}
