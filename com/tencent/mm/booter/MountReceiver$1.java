package com.tencent.mm.booter;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;

class MountReceiver$1 extends ag {
    final /* synthetic */ MountReceiver cWT;

    MountReceiver$1(MountReceiver mountReceiver, Looper looper) {
        this.cWT = mountReceiver;
        super(looper);
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        String str = "MicroMsg.MountReceiver";
        String str2 = "dkmount action:%s hasuin:%b ContextNull:%b SdcardFull:%b";
        Object[] objArr = new Object[4];
        objArr[0] = MountReceiver.a(this.cWT);
        objArr[1] = Boolean.valueOf(au.HX());
        if (MountReceiver.b(this.cWT) != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Boolean.valueOf(f.Aa());
        x.d(str, str2, objArr);
        if (MountReceiver.b(this.cWT) != null && f.Aa()) {
            s.gI(MountReceiver.b(this.cWT));
        }
    }
}
