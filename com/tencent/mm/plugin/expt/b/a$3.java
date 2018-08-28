package com.tencent.mm.plugin.expt.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements e {
    final /* synthetic */ a iHY;

    a$3(a aVar) {
        this.iHY = aVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ExptService", "scene[%d] errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(lVar.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (lVar instanceof b) {
            a.d(this.iHY);
        }
    }
}
