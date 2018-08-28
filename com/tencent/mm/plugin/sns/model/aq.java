package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class aq {
    public static String aG(int i, String str) {
        String a = d.a("snsvideo", (long) i, "sns", str);
        if (bi.oW(a)) {
            return null;
        }
        return a;
    }

    public static String nJ(String str) {
        if (bi.oW(str)) {
            return "";
        }
        x.d("MicroMsg.SnsVideoLogic", "gen sns[%s] video file name [%s]", new Object[]{str, "SNS_" + str});
        return "SNS_" + str;
    }

    public static String Mr(String str) {
        if (bi.oW(str)) {
            return "";
        }
        int indexOf = str.indexOf("SNS_");
        if (indexOf < 0) {
            return "";
        }
        String str2 = "";
        try {
            return str.substring(indexOf + 4);
        } catch (Exception e) {
            return str2;
        }
    }

    public static String Ms(String str) {
        if (bi.oW(str)) {
            return null;
        }
        x.i("MicroMsg.SnsVideoLogic", "get sns video dir %s mediaId %s", new Object[]{an.s(af.getAccSnsPath(), str), str});
        return an.s(af.getAccSnsPath(), str);
    }

    public static String D(ate ate) {
        if (ate == null) {
            return null;
        }
        x.i("MicroMsg.SnsVideoLogic", "get sns video path %s", new Object[]{an.s(af.getAccSnsPath(), ate.ksA) + i.j(ate)});
        return an.s(af.getAccSnsPath(), ate.ksA) + i.j(ate);
    }

    public static String a(String str, ate ate) {
        String str2;
        if (ate == null) {
            str2 = null;
        } else {
            str2 = an.s(af.getAccSnsPath(), ate.ksA) + i.p(ate);
            x.i("MicroMsg.SnsVideoLogic", "get sns video tmp path %s", new Object[]{str2});
        }
        if (e.cn(str2)) {
            x.i("MicroMsg.SnsVideoLogic", "it needn't download video[%s] because of the video is self. %s", new Object[]{str, str2});
            return str2;
        }
        str2 = D(ate);
        boolean cn = e.cn(str2);
        r Mt = Mt(str);
        if (Mt == null) {
            if (cn) {
                x.i("MicroMsg.SnsVideoLogic", "it old version already download video[%s]. path :%s", new Object[]{str, str2});
                return str2;
            }
            x.i("MicroMsg.SnsVideoLogic", "video info is null and file is no exists, return null.[%s]", new Object[]{str});
            return null;
        } else if (cn && Mt.Tp()) {
            x.i("MicroMsg.SnsVideoLogic", "it had download sns video[%s] finish. %s", new Object[]{str, str2});
            return str2;
        } else {
            x.i("MicroMsg.SnsVideoLogic", "it don't download video[%s] finish. file[%b] status[%d], return null.", new Object[]{str, Boolean.valueOf(cn), Integer.valueOf(Mt.status)});
            return null;
        }
    }

    public static boolean cf(String str, int i) {
        if (bi.oW(str)) {
            x.w("MicroMsg.SnsVideoLogic", "init sns record, but snsLocalId is null");
            return false;
        }
        String nJ = nJ(str);
        r rVar = new r();
        rVar.fileName = nJ;
        rVar.createTime = bi.VE();
        rVar.status = 130;
        rVar.dQo = i;
        x.i("MicroMsg.SnsVideoLogic", "init sns Record filename %s, insert %b", new Object[]{nJ, Boolean.valueOf(o.Ta().a(rVar))});
        return o.Ta().a(rVar);
    }

    public static boolean c(r rVar, int i) {
        rVar.status = 130;
        rVar.dQo = i;
        rVar.bWA = 268435712;
        x.i("MicroMsg.SnsVideoLogic", "update sns Record filename %s, update %b", new Object[]{rVar.getFileName(), Boolean.valueOf(o.Ta().b(rVar))});
        return o.Ta().b(rVar);
    }

    public static boolean eA(String str, String str2) {
        int i;
        boolean a;
        r Mt = Mt(str);
        if (Mt == null) {
            Mt = new r();
            Mt.fileName = nJ(str);
            i = 1;
        } else {
            i = 0;
        }
        Mt.createTime = bi.VE();
        Mt.cas = str2;
        Mt.status = 199;
        if (i != 0) {
            a = o.Ta().a(Mt);
        } else {
            Mt.bWA = 33555200;
            a = o.Ta().b(Mt);
        }
        x.i("MicroMsg.SnsVideoLogic", "post sns video snsLocalId %s, md5 %s ret %b", new Object[]{str, str2, Boolean.valueOf(a)});
        return a;
    }

    public static r Mt(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return t.nW(nJ(str));
    }
}
