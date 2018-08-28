package com.tencent.mm.console;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.console.b.3;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ax.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

class b$3$1 implements Runnable {
    final /* synthetic */ 3 dhb;

    b$3$1(3 3) {
        this.dhb = 3;
    }

    public final void run() {
        try {
            String str = e.bnC;
            au.HU();
            String Gj = c.Gj();
            au.HU();
            String FL = c.FL();
            x.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d, root:%s, pkgFullPath:%s, sysPath:%s, pkgPath:%s", new Object[]{Integer.valueOf(this.dhb.dgZ), str, Gj, FL, Gj.substring(str.length())});
            for (int i = 0; i < this.dhb.dgZ; i++) {
                Object obj = ((a) this.dhb.dha.get(i)).sIK;
                if (!(bi.oW(obj) || str.contains(obj))) {
                    File file = new File(obj + r5);
                    if (file.exists() && file.isDirectory()) {
                        x.i("MicroMsg.CommandProcessor", "summercmd copypackage done pkgFullPath:%s, old:%s, ret:%b", new Object[]{Gj, file.getAbsolutePath(), Boolean.valueOf(j.q(file.getAbsolutePath(), Gj, false))});
                        if (j.q(file.getAbsolutePath(), Gj, false)) {
                            new ag(Looper.getMainLooper()).post(new 1(this));
                            return;
                        }
                    }
                }
            }
            new ag(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    h.bA(b$3$1.this.dhb.val$context, b$3$1.this.dhb.val$context.getString(R.l.copy_acc_fail));
                }
            });
        } catch (Exception e) {
            x.w("MicroMsg.CommandProcessor", "summercmd copypackage e:%s", new Object[]{e.getMessage()});
        }
    }
}
