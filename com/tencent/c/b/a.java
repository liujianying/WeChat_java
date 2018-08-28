package com.tencent.c.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.c.c.b.d;
import com.tencent.c.d.a.b;
import com.tencent.c.d.a.c;
import com.tencent.c.d.a.e;
import com.tencent.c.d.a.f;
import com.tencent.c.d.a.g;
import com.tencent.c.f.h;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public Context mContext = null;
    public b vhS;

    public a(Context context) {
        this.mContext = context;
        this.vhS = new b(context);
    }

    public static d cFc() {
        d dVar = new d();
        try {
            int i;
            dVar.vjk = Build.FINGERPRINT;
            dVar.vjl = com.tencent.c.f.d.cFw();
            dVar.dMB = Build.BRAND;
            dVar.model = Build.MODEL;
            dVar.vjm = VERSION.SDK_INT;
            dVar.vjn = Build.CPU_ABI;
            dVar.platform = com.tencent.c.f.d.acu("ro.board.platform");
            if (f.cFg()) {
                i = 2;
            } else {
                Object obj;
                Object<com.tencent.c.d.b.d.a> cFh = com.tencent.c.d.b.d.cFh();
                if ((cFh.isEmpty() ? 1 : null) == null) {
                    List<b> arrayList = new ArrayList(3);
                    arrayList.add(new g());
                    arrayList.add(new com.tencent.c.d.a.d());
                    if (com.tencent.c.d.b.f.cFi()) {
                        arrayList.add(new c());
                    }
                    for (com.tencent.c.d.b.d.a aVar : cFh) {
                        if (aVar != null) {
                            for (b a : arrayList) {
                                a.a(aVar);
                            }
                        }
                    }
                    for (b cFe : arrayList) {
                        if (cFe.cFe()) {
                            obj = 1;
                            break;
                        }
                    }
                }
                obj = null;
                if (obj != null) {
                    i = 2;
                } else if (e.cFf()) {
                    i = 1;
                } else {
                    if (!com.tencent.c.d.a.a.aco("/system/bin/debuggerd")) {
                        obj = 1;
                    } else if (!com.tencent.c.d.a.a.aco("/system/bin/debuggerd64")) {
                        i = 1;
                    } else if (!com.tencent.c.d.a.a.aco("/system/bin/ddexe")) {
                        i = 1;
                    } else if (!com.tencent.c.d.a.a.acp("/system/etc/install-recovery.sh")) {
                        i = 1;
                    } else if (com.tencent.c.d.a.a.acp("/system/bin/install-recovery.sh")) {
                        h.i("BootScriptChecker : everything seems ok");
                        obj = null;
                    } else {
                        i = 1;
                    }
                    i = obj != null ? 1 : 0;
                }
            }
            dVar.root = i;
        } catch (Exception e) {
        }
        return dVar;
    }

    public static com.tencent.c.c.b.b a(Context context, com.tencent.c.a.a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        byte[] bArr;
        com.tencent.c.c.b.b bVar = new com.tencent.c.c.b.b();
        bVar.viC = i;
        bVar.viD = null;
        bVar.viE = aVar.byT;
        String str = aVar.vhN;
        if (str == null) {
            bArr = null;
        } else {
            int length = str.length() / 2;
            bArr = new byte[length];
            char[] toCharArray = str.toCharArray();
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) (((byte) "0123456789ABCDEF".indexOf(toCharArray[i3 + 1])) | (((byte) "0123456789ABCDEF".indexOf(toCharArray[i3])) << 4));
            }
        }
        bVar.viF = bArr;
        List<byte[]> bJ = com.tencent.c.f.a.bJ(context, aVar.byT);
        if (bJ.size() > 1) {
            bVar.viU = new ArrayList();
            for (byte[] bArr2 : bJ) {
                bVar.viU.add(bArr2);
            }
        }
        bVar.viG = aVar.fileSize;
        bVar.viH = aVar.vhM;
        bVar.viI = aVar.versionCode;
        bVar.viJ = aVar.versionName;
        bVar.viK = 0;
        if (aVar.dPU == 1) {
            bVar.viK |= 1;
        }
        bVar.viK |= 2;
        if (!(aVar.vhO.startsWith("/data") || aVar.vhO.startsWith("/system"))) {
            bVar.viK |= 4;
        }
        bVar.viL = com.tencent.c.f.a.act(aVar.vhO);
        bVar.viM = 0;
        bVar.viN = 0;
        bVar.viO = 0;
        bVar.viP = null;
        bVar.viQ = 0;
        bVar.viR = false;
        bVar.viS = 0;
        bVar.viT = 0;
        return bVar;
    }
}
