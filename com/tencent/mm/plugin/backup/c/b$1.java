package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.f.e;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ b gTI;
    final /* synthetic */ String val$url;

    b$1(b bVar, String str) {
        this.gTI = bVar;
        this.val$url = str;
    }

    public final void run() {
        c ary = b.arv().ary();
        x.w("MicroMsg.BackupMoveRecoverServer", "~~~~~~~~~~~~  start by url:%s", new Object[]{this.val$url});
        au.DF().a(595, ary.gUj);
        au.DF().a(new e(r1), 0);
    }
}
