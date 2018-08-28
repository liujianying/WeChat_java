package com.tencent.mm.plugin.appbrand.ui.autofill;

import com.tencent.mm.plugin.appbrand.ui.autofill.b.2;
import com.tencent.mm.protocal.c.ej;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;

class b$2$1 implements c {
    final /* synthetic */ 2 gxJ;

    b$2$1(2 2) {
        this.gxJ = 2;
    }

    public final void a(l lVar) {
        x.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_list.size %d", new Object[]{Integer.valueOf(this.gxJ.gxI.gxx.reO.size())});
        Iterator it = this.gxJ.gxI.gxx.reO.iterator();
        while (it.hasNext()) {
            ej ejVar = (ej) it.next();
            if (bi.oW(ejVar.reM) || bi.oW(ejVar.reN)) {
                x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_id or show_phone is empty, continue");
            } else {
                lVar.e(this.gxJ.gxI.gxx.reO.indexOf(ejVar), ejVar.reN);
            }
        }
    }
}
