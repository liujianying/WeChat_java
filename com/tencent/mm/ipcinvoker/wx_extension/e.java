package com.tencent.mm.ipcinvoker.wx_extension;

import android.content.Context;
import com.tencent.mm.ipcinvoker.g.1;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import junit.framework.Assert;

public final class e implements c {

    private static final class a {
        private static final e dno = new e();
    }

    /* synthetic */ e(byte b) {
        this();
    }

    private e() {
        Context context = ((h) g.Ef().DM()).dsQ;
        1 1 = new 1(this);
        Assert.assertNotNull(context);
        com.tencent.mm.ipcinvoker.e.dmA = context;
        1 12 = new 1();
        1.a(12);
        1.a(new g$2());
        1.b(12);
        b.i("IPC.IPCInvokerBoot", "setup IPCInvoker(process : %s, application : %s)", new Object[]{com.tencent.mm.ipcinvoker.e.Cs(), Integer.valueOf(context.hashCode())});
        if (ad.cie()) {
            com.tencent.mm.ipcinvoker.g.fD("com.tencent.mm:tools");
        }
    }
}
