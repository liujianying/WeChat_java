package com.tencent.mm.plugin.backup.backuppcmodel;

import android.os.Looper;
import android.os.PowerManager.WakeLock;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.b.a;
import com.tencent.mm.plugin.backup.backuppcmodel.c.5;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;

public final class b extends d {
    private static b gWq;
    private a gTG;
    private c gWr;
    private e gWs;
    private d gWt;
    private a gWu;
    private WakeLock wakeLock = null;

    public static b arV() {
        if (gWq == null) {
            b bVar = new b();
            gWq = bVar;
            a(bVar);
        }
        return gWq;
    }

    public final void aqK() {
        gWq = null;
    }

    public final void l(Object... objArr) {
        ((Boolean) objArr[0]).booleanValue();
        new ag(Looper.getMainLooper()).postDelayed(new 5(arV().arW()), 100);
    }

    public final a arw() {
        if (this.gTG == null) {
            this.gTG = new a();
        }
        return this.gTG;
    }

    public final c arW() {
        if (this.gWr == null) {
            this.gWr = new c();
        }
        return this.gWr;
    }

    public final e arX() {
        if (this.gWs == null) {
            this.gWs = new e();
        }
        return this.gWs;
    }

    public final d arY() {
        if (this.gWt == null) {
            this.gWt = new d();
        }
        return this.gWt;
    }

    public final a arZ() {
        if (this.gWu == null) {
            this.gWu = new a();
        }
        return this.gWu;
    }

    public final void aqQ() {
        ah.A(new 1(this));
    }

    public final void aqR() {
        ah.A(new 2(this));
    }
}
