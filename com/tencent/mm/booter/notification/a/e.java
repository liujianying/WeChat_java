package com.tencent.mm.booter.notification.a;

import android.media.AudioManager;
import android.text.format.Time;
import com.tencent.mm.g.a.su;
import com.tencent.mm.k.a;
import com.tencent.mm.k.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.HashSet;
import java.util.Set;

public final class e {
    private static final Set<String> cZg;
    public boolean cZh;

    static {
        Set hashSet = new HashSet();
        cZg = hashSet;
        hashSet.add("readerapp");
        cZg.add("blogapp");
        cZg.add("newsapp");
    }

    public static boolean eO(String str) {
        if (af.Wr("keep_chatting_silent" + str)) {
            x.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: FALSE");
            return true;
        }
        x.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: TRUE");
        return false;
    }

    public static boolean a(boolean[] zArr, boolean z, boolean z2) {
        boolean z3;
        if (z || z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        zArr[0] = zArr[0] & z;
        zArr[1] = zArr[1] & z2;
        return z3;
    }

    public static boolean a(boolean[] zArr, boolean z) {
        boolean z2;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        zArr[0] = zArr[0] & z;
        zArr[1] = zArr[1] & z;
        return z2;
    }

    public static boolean eP(String str) {
        boolean z = true;
        boolean contains = cZg.contains(str);
        String str2 = "MicroMsg.Notification.Silent.Handle";
        String str3 = "check is NOT Siler User: %B";
        Object[] objArr = new Object[1];
        if (contains) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        return contains;
    }

    public static boolean yg() {
        Time time = new Time();
        time.setToNow();
        if (a.aQ(time.hour, time.minute)) {
            return false;
        }
        x.w("MicroMsg.Notification.Silent.Handle", "no shake & sound notification during background deactive time");
        return true;
    }

    public static boolean yh() {
        x.i("MicroMsg.Notification.Silent.Handle", "check is Sound Mode: %B", new Object[]{Boolean.valueOf(f.Am())});
        return f.Am();
    }

    public static boolean fx(int i) {
        boolean z;
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Sound: %B", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public static boolean a(String str, bd bdVar) {
        boolean z;
        boolean z2 = true;
        if (!f.fr(str) || f.e(bdVar)) {
            z = false;
        } else {
            z = true;
        }
        String str2 = "MicroMsg.Notification.Silent.Handle";
        String str3 = "check is NOT Must Mute: %B";
        Object[] objArr = new Object[1];
        if (z) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        x.i(str2, str3, objArr);
        return z;
    }

    public static boolean yi() {
        boolean z;
        boolean z2 = true;
        try {
            su suVar = new su();
            suVar.cdE.bOh = 2;
            com.tencent.mm.sdk.b.a.sFg.m(suVar);
            z = suVar.cdF.cdG;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Notification.Silent.Handle", e, "", new Object[0]);
            z = false;
        }
        String str = "MicroMsg.Notification.Silent.Handle";
        String str2 = "check is Voip NOT Calling: %B";
        Object[] objArr = new Object[1];
        if (z) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        x.d(str, str2, objArr);
        return z;
    }

    public static boolean o(int i, String str) {
        boolean AR;
        if (f.fW(i)) {
            if (f.fm(str)) {
                AR = f.AR();
            } else if (f.fn(str)) {
                AR = f.AS();
            }
            x.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", new Object[]{Boolean.valueOf(AR)});
            return AR;
        }
        AR = true;
        x.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", new Object[]{Boolean.valueOf(AR)});
        return AR;
    }

    public static boolean yj() {
        boolean Ao = f.Ao();
        if (yk() == 0) {
            Ao = false;
        }
        x.i("MicroMsg.Notification.Silent.Handle", "check is Shake Mode: %B, System AudioManager Mode: %d", new Object[]{Boolean.valueOf(Ao), Integer.valueOf(yk())});
        return Ao;
    }

    public static int yk() {
        return ((AudioManager) ad.getContext().getSystemService("audio")).getRingerMode();
    }

    public static boolean fy(int i) {
        boolean z;
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Shake: %B", new Object[]{Boolean.valueOf(z)});
        return z;
    }
}
