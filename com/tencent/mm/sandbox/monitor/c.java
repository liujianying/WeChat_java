package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.a.g;
import com.tencent.mm.c.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sandbox.b;
import com.tencent.mm.sandbox.updater.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public abstract class c implements b {
    public static final String sDh = e.bnE;
    public int sDi;
    public int sDj;
    public int sDk;
    public String sDl;
    private boolean sDm = false;

    public c(int i, String str, int i2, boolean z) {
        this.sDj = i;
        this.sDl = str;
        this.sDi = i2;
        this.sDm = z;
        this.sDk = com.tencent.mm.a.e.cm(beJ());
        File file = new File(sDh);
        if (!file.exists()) {
            file.mkdirs();
        }
        x.d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + beJ() + " packOffset = " + this.sDk);
    }

    public String beJ() {
        return sDh + this.sDl + ".temp";
    }

    public String cgL() {
        return sDh + this.sDl + ".apk";
    }

    public final void deleteTempFile() {
        try {
            x.d("MM.GetUpdatePack", "deleteTempFile");
            File file = new File(beJ());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            x.e("MM.GetUpdatePack", "error in deleteTempFile");
        }
    }

    public static boolean VQ(String str) {
        if (com.tencent.mm.a.e.cn(sDh + str + ".temp")) {
            return true;
        }
        return false;
    }

    public static String VR(String str) {
        String str2 = sDh + str + ".apk";
        return (com.tencent.mm.a.e.cn(str2) && a.cE(str2)) ? str2 : null;
    }

    public static String Hw(String str) {
        return bq(str, false);
    }

    public static String bq(String str, boolean z) {
        String str2 = sDh + str + ".temp";
        String str3 = sDh + str + ".apk";
        if (com.tencent.mm.a.e.cn(str2) && !z && (a.cE(str2) || str.equalsIgnoreCase(g.cu(str2)))) {
            com.tencent.mm.a.e.i(sDh, str + ".temp", str + ".apk");
            return str3;
        }
        if (com.tencent.mm.a.e.cn(str3)) {
            if (a.cE(str3)) {
                x.i("MM.GetUpdatePack", "summertoken getReadyPack checkApkMd5 update pack ok");
                return str3;
            }
            str2 = null;
            try {
                str2 = com.tencent.mm.c.c.p(new File(str3));
                if (bi.oW(str2)) {
                    h.mEJ.a(322, 10, 1, false);
                    h.mEJ.h(11098, new Object[]{Integer.valueOf(4010)});
                }
            } catch (Exception e) {
                x.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + e.getMessage());
                h.mEJ.a(322, 9, 1, false);
                h.mEJ.h(11098, new Object[]{Integer.valueOf(4009), r10.getMessage()});
            }
            x.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", new Object[]{str2});
            if (!bi.oW(str2)) {
                x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", new Object[]{str2, i.cgX()});
                if (str2.equals(i.cgX())) {
                    x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
                    return str3;
                }
                x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
                h.mEJ.a(322, 11, 1, false);
                h hVar = h.mEJ;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(4011);
                objArr[1] = String.format("%s,%s", new Object[]{r10, str2});
                hVar.h(11098, objArr);
            } else if (str.equalsIgnoreCase(g.cu(str3))) {
                x.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
                return str3;
            }
            x.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
            com.tencent.mm.a.e.deleteFile(str3);
        }
        return null;
    }

    public final boolean cgM() {
        if (!this.sDm || ao.isWifi(ad.getContext())) {
            return false;
        }
        return true;
    }
}
