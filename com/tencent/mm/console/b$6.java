package com.tencent.mm.console;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class b$6 implements e {
    final /* synthetic */ boolean dhi;
    final /* synthetic */ Context val$context;

    b$6(boolean z, Context context) {
        this.dhi = z;
        this.val$context = context;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa NetSceneManualAuth onSceneEnd [%d, %d, %s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 4 || i2 == -102 || this.dhi) {
            new i().a(g.Eh().dpP.dJs, new e() {
                public final void a(int i, int i2, String str, l lVar) {
                    x.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa  NetSceneGetCert onSceneEnd [%d, %d, %s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (i == 4 && i2 == -102) {
                        ah.A(new 1(this));
                        return;
                    }
                    Toast.makeText(b$6.this.val$context, "DefaultRSA check pass", 0).show();
                    b.B(b$6.this.val$context, "");
                }
            });
        } else {
            ah.A(new Runnable() {
                public final void run() {
                    b.B(b$6.this.val$context, "RSA(req) fatal err, must recheck!!!");
                }
            });
        }
    }
}
