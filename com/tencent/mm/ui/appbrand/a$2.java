package com.tencent.mm.ui.appbrand;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n$c;

class a$2 implements n$c {
    final /* synthetic */ a tre;

    a$2(a aVar) {
        this.tre = aVar;
    }

    public final void a(l lVar) {
        if (this.tre.trc == null) {
            x.e("MicroMsg.AppBrandSerivceActionSheet", "resetOnCreateMenuListener, state is null");
        } else {
            this.tre.trc.a(lVar);
        }
    }
}
