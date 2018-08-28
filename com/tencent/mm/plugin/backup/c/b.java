package com.tencent.mm.plugin.backup.c;

import android.os.PowerManager.WakeLock;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.b.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class b extends d {
    private static b gTC;
    private d gTD;
    private c gTE;
    private a gTF;
    private a gTG;
    String gTH = "tickit";
    private WakeLock wakeLock = null;

    public static b arv() {
        if (gTC == null) {
            b bVar = new b();
            gTC = bVar;
            a(bVar);
        }
        return gTC;
    }

    public final void aqK() {
        gTC = null;
    }

    public final void l(Object... objArr) {
        ah.A(new 1(this, (String) objArr[0]));
    }

    public final a arw() {
        if (this.gTG == null) {
            this.gTG = new a();
        }
        return this.gTG;
    }

    public final d arx() {
        if (this.gTD == null) {
            this.gTD = new d();
        }
        return this.gTD;
    }

    public final c ary() {
        if (this.gTE == null) {
            this.gTE = new c();
        }
        return this.gTE;
    }

    public final a arz() {
        if (this.gTF == null) {
            this.gTF = new a();
        }
        return this.gTF;
    }

    public final void aqQ() {
        ah.A(new 2(this));
    }

    public final void aqR() {
        ah.A(new 3(this));
    }
}
