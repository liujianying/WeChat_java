package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;

public final class c implements e, f {
    public l bKq;
    public Context context;
    public a eNU;
    private ag handler = new ag(Looper.getMainLooper());
    public p tipDialog;

    public c(Context context, a aVar) {
        this.context = context;
        this.eNU = aVar;
    }

    public final void a(int i, int i2, l lVar) {
        final int i3 = i2 != 0 ? (int) ((((long) i) * 100) / ((long) i2)) : 0;
        this.handler.post(new Runnable() {
            public final void run() {
                if (c.this.tipDialog != null) {
                    c.this.tipDialog.setMessage(c.this.context.getString(j.app_loading_data) + i3 + "%");
                }
            }
        });
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 139) {
            g.DF().b(139, this);
        } else if (lVar.getType() == 138) {
            g.DF().b(138, this);
        }
        if (i2 == 0 && i == 0) {
            this.eNU.Yk();
        } else {
            x.e("MicroMsg.DoInit", "do init failed, err=" + i + "," + i2);
            this.eNU.Yk();
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
    }
}
