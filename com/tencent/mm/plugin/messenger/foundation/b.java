package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.protocal.c.qx;

public final class b implements q {
    public final void a(pm pmVar, byte[] bArr, boolean z, s sVar) {
        switch (pmVar.rtM) {
            case 7:
                ((i) g.l(i.class)).FW().Yp(ab.a(((qx) new qx().aG(bArr)).rvi));
                return;
            default:
                return;
        }
    }
}
