package com.tencent.mm.console;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.console.b.4;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ax.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

class b$4$1 implements Runnable {
    final /* synthetic */ 4 dhe;

    b$4$1(4 4) {
        this.dhe = 4;
    }

    public final void run() {
        try {
            String substring = this.dhe.dhd.substring(10);
            String str = e.bnC;
            au.HU();
            String str2 = c.Gq() + substring;
            x.i("MicroMsg.CommandProcessor", "summercmd copy -n subDir:%s, root:%s, accPath:%s destPath:%s, subPath:%s", new Object[]{substring, str, r1, str2, str2.substring(str.length())});
            for (int i = 0; i < this.dhe.dgZ; i++) {
                Object obj = ((a) this.dhe.dha.get(i)).sIK;
                if (!(bi.oW(obj) || str.contains(obj))) {
                    File file = new File(obj + r5);
                    if (file.exists() && file.isDirectory()) {
                        File file2 = new File(str2);
                        if (!file2.exists()) {
                            file2.mkdir();
                        }
                        x.i("MicroMsg.CommandProcessor", "summercmd copy -n done new:%s, old:%s, ret:%b", new Object[]{file2.getAbsolutePath(), file.getAbsolutePath(), Boolean.valueOf(j.q(file.getAbsolutePath(), file2.getAbsolutePath(), false))});
                        if (j.q(file.getAbsolutePath(), file2.getAbsolutePath(), false)) {
                            new ag(Looper.getMainLooper()).post(new 1(this));
                            return;
                        }
                    }
                }
            }
            new ag(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    h.bA(b$4$1.this.dhe.val$context, b$4$1.this.dhe.val$context.getString(R.l.copy_acc_fail));
                }
            });
        } catch (Exception e) {
            x.w("MicroMsg.CommandProcessor", "summercmd copy -n e:%s", new Object[]{e.getMessage()});
        }
    }
}
