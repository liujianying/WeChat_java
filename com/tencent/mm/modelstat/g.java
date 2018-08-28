package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class g {
    private final String bXW;
    private a ejG = null;

    public g(String str) {
        this.bXW = str;
    }

    public final a RZ() {
        a aVar = null;
        if (this.ejG != null) {
            return this.ejG;
        }
        a aVar2;
        String str = this.bXW + "mobileinfo.ini";
        File file = new File(str);
        if (file.exists()) {
            a aVar3 = new a(str);
            aVar2 = new a();
            aVar2.ejH = bi.f(aVar3.Xo("ispCode"));
            aVar2.ispName = aVar3.getValue("ispName");
            aVar2.bID = bi.f(aVar3.Xo("subType"));
            aVar2.extraInfo = aVar3.getValue("extraInfo");
            long lastModified = file.lastModified();
            if (CdnLogic.kMediaTypeBeatificFile == af.exm && af.exn > 0) {
                lastModified = bi.VF() - ((long) af.exn);
                x.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig DK_TEST_MOBILEINFOFILE_MODTIME val:%d lm:%d", new Object[]{Integer.valueOf(af.exn), Long.valueOf(lastModified)});
                af.exn = 0;
            }
            if (lastModified > 0 && bi.bH(lastModified) > 259200000) {
                x.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig  diff:%d file:%s cache expired remove!", new Object[]{Long.valueOf(bi.bH(lastModified)), str});
                aVar2.ejI = true;
            }
            x.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig MobileInfo subType:%d ispCode:%d ispName:%s extraInfo:%s expired:%b", new Object[]{Integer.valueOf(aVar2.bID), Integer.valueOf(aVar2.ejH), aVar2.ispName, aVar2.extraInfo, Boolean.valueOf(aVar2.ejI)});
        } else {
            x.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig file not exist :%s", new Object[]{str});
            aVar2 = null;
        }
        this.ejG = aVar2;
        if (this.ejG == null || this.ejG.ejI) {
            Context context = ad.getContext();
            if (context == null) {
                x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem MMApplicationContext is null");
            } else {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem ConnectivityManager is null");
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem getActiveNetworkInfo is null");
                    } else if (activeNetworkInfo.getType() == 1) {
                        x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem net type is wifi");
                    } else {
                        aVar = new a();
                        aVar.bID = activeNetworkInfo.getSubtype();
                        aVar.ejH = ao.getISPCode(context);
                        aVar.ispName = ao.getISPName(context);
                        aVar.extraInfo = activeNetworkInfo.getExtraInfo();
                        x.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem subType:%d ispCode:%d ispName:%s extraInfo:%s", new Object[]{Integer.valueOf(aVar.bID), Integer.valueOf(aVar.ejH), aVar.ispName, aVar.extraInfo});
                    }
                }
            }
            if (aVar == null) {
                x.v("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem failed , use old.");
                return this.ejG;
            }
            this.ejG = aVar;
            aVar2 = this.ejG;
            if (aVar2 == null) {
                x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig info is null");
            } else if (bi.oW(str)) {
                x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig path is null");
            } else {
                a aVar4 = new a(str);
                aVar4.cX("ispCode", aVar2.ejH);
                aVar4.fT("ispName", aVar2.ispName);
                aVar4.cX("subType", aVar2.bID);
                aVar4.fT("extraInfo", aVar2.extraInfo);
            }
            return this.ejG;
        }
        x.v("MicroMsg.MobileInfoStorage ReportDataFlow", "checkInfo mobile info cache Read file succ.");
        return this.ejG;
    }
}
