package com.tencent.mm.model.d;

import android.content.Context;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.d.b.2;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class b$1 implements Runnable {
    final /* synthetic */ b dFo;

    public b$1(b bVar) {
        this.dFo = bVar;
    }

    public final void run() {
        File file = new File(b.bO() + "MMSQL.trace");
        if (!file.exists()) {
            x.w("MicroMsg.SQLTraceManager", "SqlTrace file is not  exists");
        } else if (g.Eg().Dx()) {
            long currentTimeMillis = System.currentTimeMillis();
            long bD = b.bD(ad.getContext());
            boolean z = false;
            if (bD > currentTimeMillis) {
                z = true;
            } else if (currentTimeMillis - bD > 86400000) {
                z = true;
            } else if (currentTimeMillis - bD > b.a(this.dFo) && b.b(this.dFo)) {
                z = true;
            }
            x.i("MicroMsg.SQLTraceManager", "check need upload ,file size is %d,time out  %b", new Object[]{Long.valueOf(file.length()), Boolean.valueOf(z)});
            if (z && r2 > b.c(this.dFo)) {
                b bVar = this.dFo;
                Context context = ad.getContext();
                String packageName = ad.getContext().getPackageName();
                try {
                    PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context.getPackageManager(), new Object[]{packageName, new 2(bVar)});
                } catch (Exception e) {
                    bVar.byR[0] = -1;
                    bVar.byR[1] = -1;
                    bVar.byR[2] = -1;
                }
                if (b.d(this.dFo)[1] != 0 || b.e(this.dFo) > 1) {
                    x.i("MicroMsg.SQLTraceManager", "start file upload ,file length is %d ", new Object[]{Long.valueOf(file.length())});
                    if (file.length() > b.f(this.dFo)) {
                        x.e("MicroMsg.SQLTraceManager", "log file invaild format");
                    } else {
                        String jg = b.jg(b.bO() + "MMSQL.trace");
                        x.i("MicroMsg.SQLTraceManager", "read content success");
                        this.dFo.jf(jg);
                    }
                    x.i("MicroMsg.SQLTraceManager", "set last Upload Time %d ", new Object[]{Long.valueOf(System.currentTimeMillis())});
                    b.a(this.dFo, file);
                    b.g(this.dFo);
                    b.h(this.dFo);
                    b.c(ad.getContext(), System.currentTimeMillis());
                    return;
                }
                x.i("MicroMsg.SQLTraceManager", "wait for get packageStats");
                b.i(this.dFo);
            }
        } else {
            x.w("MicroMsg.SQLTraceManager", "acc not ready ");
        }
    }
}
