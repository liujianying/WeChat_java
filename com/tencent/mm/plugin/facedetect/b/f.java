package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ab.j;
import com.tencent.mm.plugin.facedetect.b.j.a;
import com.tencent.mm.plugin.facedetect.b.j.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

final class f extends j {
    a iMj = new a();
    b iMk = new b();

    f() {
    }

    public final int getType() {
        return 931;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/registerfacersa";
    }

    public final e Id() {
        return this.iMk;
    }

    protected final d Ic() {
        return this.iMj;
    }

    public final int KP() {
        return 1;
    }
}
