package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.a.g;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.amh;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.bou;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bpn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.List;

public final class m {
    private static final ThreadLocal<HashMap<String, Long>> nmc = new ThreadLocal();

    public static boolean LS(String str) {
        n Nl = af.byo().Nl(str);
        return a(Nl, aj.n(Nl));
    }

    public static boolean h(n nVar) {
        return a(nVar, aj.n(nVar));
    }

    public static boolean a(n nVar, boy boy) {
        atf bAW = nVar.bAW();
        if (nVar.field_type != 21) {
            return true;
        }
        if (bAW.ceS == 1) {
            return true;
        }
        if (q.GF().equals(nVar.field_userName)) {
            return true;
        }
        if (boy.smZ != null) {
            List<bou> list = boy.smZ.snC;
            if (list == null || list.size() == 0) {
                return false;
            }
            String GF = q.GF();
            for (bou bou : list) {
                if (GF.equals(bou.rdS)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int i(n nVar) {
        if (nVar == null) {
            return 0;
        }
        boy n = aj.n(nVar);
        if (n == null) {
            return 0;
        }
        bpn bpn = n.smZ;
        return (bpn == null || bpn.snC.size() == 0) ? 0 : bpn.snC.size();
    }

    public static long j(n nVar) {
        return b(nVar, null);
    }

    public static long b(n nVar, boy boy) {
        long j = 0;
        if (nVar == null) {
            return 0;
        }
        if (boy == null) {
            boy = aj.n(nVar);
        }
        if (boy == null) {
            return 0;
        }
        bpn bpn = boy.smZ;
        if (bpn == null) {
            return 0;
        }
        List<bou> list = bpn.snC;
        if (list == null) {
            return 0;
        }
        Object obj;
        String str = nVar.nJb;
        if (bi.oW(str)) {
            obj = g.u(nVar.field_content) + g.u(nVar.field_attrBuf);
        } else {
            String obj2 = str;
        }
        HashMap hashMap = (HashMap) nmc.get();
        if (hashMap != null && hashMap.containsKey(obj2)) {
            return ((Long) hashMap.get(obj2)).longValue();
        }
        for (bou bou : list) {
            amh amh = new amh();
            try {
                amh.aG(ab.a(bou.sml));
            } catch (Exception e) {
                x.e("MicrMsg.SnsLuckyUtil", e.getMessage() + "hbBuffer is error");
            }
            j += amh.cfh;
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        hashMap.put(obj2, Long.valueOf(j));
        nmc.set(hashMap);
        return j;
    }
}
