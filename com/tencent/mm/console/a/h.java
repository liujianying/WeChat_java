package com.tencent.mm.console.a;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bn;
import java.util.Calendar;

public final class h implements a {
    static {
        b.a(new h(), new String[]{"//sport"});
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        if (x.getLogLevel() > 1) {
            return false;
        }
        if (strArr.length < 2) {
            return true;
        }
        String str = strArr[1];
        Object obj = -1;
        switch (str.hashCode()) {
            case -734972924:
                if (str.equals("setdevicestep")) {
                    obj = null;
                    break;
                }
                break;
            case 94746189:
                if (str.equals("clear")) {
                    obj = 1;
                    break;
                }
                break;
            case 1761741959:
                if (str.equals("setextapistep")) {
                    obj = 2;
                    break;
                }
                break;
            case 1840324855:
                if (str.equals("updatehistorystep")) {
                    obj = 3;
                    break;
                }
                break;
        }
        Calendar instance;
        switch (obj) {
            case null:
                int intValue = Integer.valueOf(strArr[2]).intValue();
                ((com.tencent.mm.plugin.sport.b.b) g.l(com.tencent.mm.plugin.sport.b.b.class)).J(202, bi.ciZ() / 10000);
                ((com.tencent.mm.plugin.sport.b.b) g.l(com.tencent.mm.plugin.sport.b.b.class)).J(201, (long) intValue);
                instance = Calendar.getInstance();
                instance.set(11, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                ((com.tencent.mm.plugin.sport.b.b) g.l(com.tencent.mm.plugin.sport.b.b.class)).a("", "gh_43f2581f6fd6", (int) (instance.getTimeInMillis() / 1000), (int) (System.currentTimeMillis() / 1000), intValue, bn.cmZ());
                break;
            case 1:
                ((com.tencent.mm.plugin.sport.b.b) g.l(com.tencent.mm.plugin.sport.b.b.class)).bFw();
                Process.killProcess(Process.myPid());
                break;
            case 2:
                fh fhVar = new fh();
                fhVar.bNx.action = 2;
                fhVar.bNx.bNA = (long) Integer.valueOf(strArr[2]).intValue();
                fhVar.bNx.bNB = 1;
                com.tencent.mm.sdk.b.a.sFg.a(fhVar, Looper.getMainLooper());
                break;
            case 3:
                instance = Calendar.getInstance();
                instance.add(5, -1);
                instance.set(10, 23);
                instance.set(12, 59);
                instance.set(13, 59);
                long timeInMillis = instance.getTimeInMillis();
                instance.add(5, -120);
                instance.set(10, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                ((com.tencent.mm.plugin.sport.b.b) g.l(com.tencent.mm.plugin.sport.b.b.class)).a(instance.getTimeInMillis(), timeInMillis, null);
                break;
        }
        return true;
    }
}
