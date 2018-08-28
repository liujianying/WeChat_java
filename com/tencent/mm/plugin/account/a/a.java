package com.tencent.mm.plugin.account.a;

import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements n {
    public static volatile m ezn;
    public static volatile l ezo;

    public final void a(m mVar) {
        ezn = mVar;
    }

    public final void a(l lVar) {
        x.i("MicroMsg.AccountSyncApplication", "regitMMModelCallback %s", new Object[]{lVar});
        ezo = lVar;
    }
}
