package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.console.Shell.a;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class Shell$6 implements a {
    Shell$6() {
    }

    public final void n(Intent intent) {
        af.exm = intent.getIntExtra("key", 0);
        af.exn = intent.getIntExtra("val", 0);
        af.exo = intent.getStringExtra("str");
        x.w("MicroMsg.Shell", "dkshell set [%d %d] [%s]", new Object[]{Integer.valueOf(af.exm), Integer.valueOf(af.exn), af.exo});
        if (10009 == af.exm) {
            int i = af.exn;
            Shell.AV();
        } else if (10014 == af.exm && ad.cic()) {
            o.PM().a(7, 1, "");
        } else if (10015 == af.exm && ad.cid()) {
            gi giVar = new gi();
            giVar.bPw.type = 13;
            com.tencent.mm.sdk.b.a.sFg.m(giVar);
        }
    }
}
