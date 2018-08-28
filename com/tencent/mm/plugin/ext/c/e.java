package com.tencent.mm.plugin.ext.c;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.plugin.ext.c.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.d.a.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public class e {
    public static e iKR = null;
    public Context mContext = null;

    public static e aJh() {
        if (iKR != null) {
            return iKR;
        }
        e eVar;
        synchronized (e.class) {
            if (iKR == null) {
                iKR = new e();
            }
            eVar = iKR;
        }
        return eVar;
    }

    private e() {
    }

    public static void L(String str, int i, int i2) {
        h.mEJ.h(14869, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static void M(String str, int i, int i2) {
        h.mEJ.h(14868, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static Cursor aJi() {
        x.i("MicroMsg.ExtQrCodeHandler", "hy: release temp mapping");
        c.clearCache();
        return a.BA(1);
    }

    public static b as(String str, boolean z) {
        return d.aJg().ar(str, z);
    }

    public final a a(b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = (a) new 1(this, new a(), bVar).a(aJj());
        String str = "MicroMsg.ExtQrCodeHandler";
        String str2 = "hy: resolved qrcode: %s, using: %d ms";
        Object[] objArr = new Object[2];
        objArr[0] = aVar != null ? aVar.toString() : "null";
        objArr[1] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        x.i(str, str2, objArr);
        return aVar;
    }

    public static ag aJj() {
        return new ag(Looper.getMainLooper());
    }
}
