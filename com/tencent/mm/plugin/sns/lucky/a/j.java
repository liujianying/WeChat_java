package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.ab.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Map;

public final class j implements a {
    public static String TAG = "MicroMsg.NewYearSnsTips2016NotifyLsn";

    public final void a(d.a aVar) {
        x.i(TAG, "receivemsg NewYearSnsTips2016NotifyLsn");
        b.kB(74);
        if (aVar == null || aVar.dIN == null) {
            x.e(TAG, "onPreAddMessage cmdAM is null");
            return;
        }
        i iVar = new i();
        String a = ab.a(aVar.dIN.rcl);
        iVar.gVP = new StringBuffer();
        Map z = bl.z(a, "sysmsg");
        iVar.nmb.clear();
        if (z == null) {
            x.i("MicroMsg.NewYearSnsTips", "errr for paser %s", new Object[]{a});
            b.kB(75);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                String str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr = new Object[2];
                objArr[0] = i2 == 0 ? "" : String.valueOf(i2);
                objArr[1] = "BeginTime";
                long WV = bi.WV((String) z.get(String.format(str, objArr)));
                iVar.gVP.append("BeginTime:" + WV + ";");
                str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr2 = new Object[2];
                objArr2[0] = i2 == 0 ? "" : String.valueOf(i2);
                objArr2[1] = "EndTime";
                long WV2 = bi.WV((String) z.get(String.format(str, objArr2)));
                iVar.gVP.append("EndTime:" + WV2 + ";");
                str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr3 = new Object[2];
                objArr3[0] = i2 == 0 ? "" : String.valueOf(i2);
                objArr3[1] = "ActionID";
                str = bi.aG((String) z.get(String.format(str, objArr3)), "");
                iVar.gVP.append("ActionID:" + str + ";");
                if (bi.oW(str)) {
                    break;
                }
                String str2 = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr4 = new Object[2];
                objArr4[0] = i2 == 0 ? "" : String.valueOf(i2);
                objArr4[1] = "TipsMessage";
                String aG = bi.aG((String) z.get(String.format(str2, objArr4)), "");
                iVar.gVP.append("TipsMessage:" + aG + ";\n");
                h hVar = new h();
                hVar.nlY = str;
                hVar.nlo = WV;
                hVar.hcQ = WV2;
                hVar.nlZ = aG;
                iVar.nmb.add(hVar);
                i = i2 + 1;
            }
            if (iVar.nmb.size() == 0) {
                b.kB(76);
            }
        }
        x.i("MicroMsg.NewYearSnsTips", "dump NewYearSnsTips " + iVar.gVP.toString());
        g.Ek();
        g.Ei().DT().a(aa.a.sSs, a);
        g.Ek();
        g.Ei().DT().lm(true);
    }
}
