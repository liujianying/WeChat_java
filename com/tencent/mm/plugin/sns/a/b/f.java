package com.tencent.mm.plugin.sns.a.b;

import android.util.Base64;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bqw;
import com.tencent.mm.protocal.c.bqx;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class f {
    public static void a(String str, d dVar) {
        n Nk = af.byo().Nk(str);
        if (Nk != null) {
            bsu bAJ = Nk.bAJ();
            if (bAJ != null) {
                p.a(bAJ.nNV, dVar);
                return;
            }
            x.v("SnsAdExtUtil", "timeLineObject null, snsId %s", new Object[]{str});
            return;
        }
        x.v("SnsAdExtUtil", "snsInfo null, snsId %s", new Object[]{str});
    }

    public static String a(long j, Object... objArr) {
        af.byi();
        StringBuilder stringBuilder = new StringBuilder(i.n(objArr));
        a(j, stringBuilder);
        return stringBuilder.toString();
    }

    public static void a(long j, StringBuilder stringBuilder) {
        e eZ = af.byr().eZ(j);
        if (eZ != null) {
            bsu bAJ = eZ.bAJ();
            if (bAJ != null) {
                bqx nn = p.nn(bAJ.nNV);
                stringBuilder.append(",").append(nn == null ? -1 : nn.source);
                stringBuilder.append(",").append(p.a(nn));
                return;
            }
            x.v("SnsAdExtUtil", "l timeLineObject null, snsId %d", new Object[]{Long.valueOf(j)});
            stringBuilder.append(",,");
            return;
        }
        x.v("SnsAdExtUtil", "l snsInfo null, snsId %d", new Object[]{Long.valueOf(j)});
        stringBuilder.append(",,");
    }

    public static String a(bsu bsu) {
        if (bsu != null) {
            return Lu(bsu.nNV);
        }
        x.v("SnsAdExtUtil", "getSnsStatExt timeLineObject null");
        return null;
    }

    private static String Lu(String str) {
        if (bi.oW(str)) {
            return "";
        }
        byte[] decode = Base64.decode(str, 0);
        bqw bqw = new bqw();
        try {
            bqw.aG(decode);
            return p.a(bqw.soW);
        } catch (IOException e) {
            x.e("SnsAdExtUtil", "", new Object[]{e});
            return "";
        }
    }
}
