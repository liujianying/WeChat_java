package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.g.a.ik;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.e;

class b$1 extends c<ik> {
    b$1() {
        this.sFo = ik.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((ik) bVar) instanceof ik) {
            e.post(new 1(this), "IPCall_SyncAddressBook");
        }
        return false;
    }
}
