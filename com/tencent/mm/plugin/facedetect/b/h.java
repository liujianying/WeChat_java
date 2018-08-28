package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ab.j;
import com.tencent.mm.plugin.facedetect.b.i.a;
import com.tencent.mm.plugin.facedetect.b.i.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

final class h extends j {
    a iMn = new a();
    b iMo = new b();

    h() {
    }

    public final int getType() {
        return 733;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getbioconfigrsa";
    }

    public final e Id() {
        return this.iMo;
    }

    protected final d Ic() {
        return this.iMn;
    }

    public final int KP() {
        return 1;
    }
}
