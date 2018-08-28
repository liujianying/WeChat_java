package com.tencent.mm.sandbox.updater;

import android.util.Base64;
import com.tencent.mm.c.i;
import com.tencent.mm.c.i.a;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.bsy;
import com.tencent.mm.protocal.c.bsz;
import com.tencent.mm.protocal.c.bta;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class e {
    public String clientVersion;
    public final int fileSize;
    public final Integer knd;
    public HashMap<Integer, LinkedList<avn>> kne = new HashMap();
    public final Integer knf;
    public final Integer kng;
    public final String knh;
    public final String kni;
    public final String knj;
    public String knk;
    public String knl;
    public String knm;
    public String knn;
    public String kno;
    public int versionCode;

    public e(bta bta) {
        if (bta == null) {
            this.knd = Integer.valueOf(1);
            this.knh = "";
            this.kni = "";
            this.knf = Integer.valueOf(-1);
            this.kng = Integer.valueOf(-1);
            this.knj = "";
            this.fileSize = 0;
            this.knk = "";
            this.knl = "";
            this.versionCode = 0;
            this.clientVersion = "";
            this.knm = "";
            this.knn = "";
            this.kno = "";
            return;
        }
        if (bta.sqv != null) {
            this.kni = bta.sqv.rwt;
            this.knh = bta.sqv.jPK;
            this.fileSize = bta.sqv.ruE;
        } else {
            this.kni = "";
            this.knh = "";
            this.fileSize = 0;
        }
        this.knd = Integer.valueOf(bta.state);
        this.kng = Integer.valueOf(bta.squ);
        if (!(bta.sqs == null || bta.sqs.isEmpty())) {
            int size = bta.sqs.size();
            for (int i = 0; i < size; i++) {
                bsz bsz = (bsz) bta.sqs.get(i);
                if (!(bsz.sqr == null || bsz.sqr.isEmpty())) {
                    this.kne.put(Integer.valueOf(bsz.type), bsz.sqr);
                }
            }
        }
        this.knf = Integer.valueOf(bta.sqt);
        this.knj = bta.rsQ;
        if (bta.sqx == null || bta.sqx.isEmpty()) {
            this.knk = "";
            this.knl = "";
            this.versionCode = 0;
            this.clientVersion = "";
            this.knm = "";
            this.knn = "";
            this.kno = "";
            return;
        }
        Iterator it = bta.sqx.iterator();
        while (it.hasNext()) {
            bsy bsy = (bsy) it.next();
            if (!(bsy == null || bi.oW(bsy.aAL))) {
                if (bsy.aAL.equalsIgnoreCase("newApkMd5")) {
                    this.knk = bsy.value;
                } else if (bsy.aAL.equalsIgnoreCase("oldApkMd5")) {
                    this.knl = bsy.value;
                } else if (bsy.aAL.equalsIgnoreCase("versionCode")) {
                    this.versionCode = bi.WU(bsy.value);
                } else if (bsy.aAL.equalsIgnoreCase("clientVersion")) {
                    this.clientVersion = bsy.value;
                } else if (bsy.aAL.equalsIgnoreCase("alphaTitle")) {
                    this.knm = EJ(bsy.value);
                } else if (bsy.aAL.equalsIgnoreCase("alphaContent")) {
                    this.knn = EJ(bsy.value);
                } else if (bsy.aAL.equalsIgnoreCase("alphaUrl")) {
                    this.kno = bsy.value;
                }
            }
        }
    }

    public final String cgW() {
        String substring = this.knh.substring(0, this.knh.lastIndexOf(47) + 1);
        String substring2 = this.knh.substring(this.knh.lastIndexOf(47) + 1);
        i iVar = new i(substring, Integer.valueOf(this.versionCode).intValue());
        iVar.a(new a(this.knl, this.knk, this.kni, substring2, this.fileSize));
        return iVar.uv();
    }

    public final String toString() {
        return "responseState:" + this.knd + "\ncdnUrl:" + this.knh + "\nfileMd5:" + this.kni + "\npackageType:" + this.knf + "\nnetworkType:" + this.kng + "\npatchId:" + this.knj;
    }

    public static boolean EI(String str) {
        if (bi.oW(str) || str.length() != 10) {
            return false;
        }
        try {
            int intValue = Integer.decode(str).intValue();
            if ((intValue & 255) < 0 || (intValue & 255) > 31) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("Tinker.TinkerSyncResponse", e, "checkAplhVersion failed.", new Object[0]);
            return false;
        }
    }

    private static String EJ(String str) {
        if (bi.oW(str)) {
            return "";
        }
        return new String(Base64.decode(str, 0));
    }
}
