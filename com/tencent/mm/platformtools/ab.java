package com.tencent.mm.platformtools;

import com.tencent.mm.bk.b;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;

public final class ab {
    public static bhy O(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        bhy bhy = new bhy();
        bhy.bq(bArr);
        return bhy;
    }

    public static byte[] a(bhy bhy) {
        if (bhy == null || bhy.siK == null) {
            return null;
        }
        return bhy.siK.toByteArray();
    }

    public static byte[] a(bhy bhy, byte[] bArr) {
        return (bhy == null || bhy.siK == null) ? bArr : bhy.siK.toByteArray();
    }

    public static String a(bhz bhz) {
        if (bhz == null) {
            return null;
        }
        return bhz.siM;
    }

    public static bhz oT(String str) {
        if (str == null) {
            return null;
        }
        bhz bhz = new bhz();
        bhz.VO(str);
        return bhz;
    }

    public static String a(b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.cfV();
    }

    public static String b(bhy bhy) {
        if (bhy == null || bhy.siK == null) {
            return null;
        }
        return bhy.siK.cfV();
    }
}
