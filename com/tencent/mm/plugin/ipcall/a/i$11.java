package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.ab.d;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.ii;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Map;

class i$11 implements a {
    final /* synthetic */ i kpj;

    i$11(i iVar) {
        this.kpj = iVar;
    }

    public final void a(d.a aVar) {
        x.i("MicroMsg.SubCoreIPCall", "WeChatOut onRecieveMsg");
        String a = ab.a(aVar.dIN.rcl);
        if (a == null || a.length() == 0) {
            x.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, msgContent is null");
            return;
        }
        Map z = bl.z(a, "sysmsg");
        if (z == null) {
            x.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, values is null");
            return;
        }
        int i;
        int i2;
        String substring;
        if (z.containsKey(".sysmsg.WeChatOut.AccountRedDotType")) {
            i = bi.getInt((String) z.get(".sysmsg.WeChatOut.AccountRedDotType"), -1);
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountRedDotType: %d", new Object[]{Integer.valueOf(i)});
            au.HU();
            c.DT().a(aa.a.sQW, Integer.valueOf(i));
            i2 = i;
        } else {
            i2 = -1;
        }
        if (z.containsKey(".sysmsg.WeChatOut.AcctRD")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut AcctRD: %d", new Object[]{Integer.valueOf(bi.getInt((String) z.get(".sysmsg.WeChatOut.AcctRD"), 0))});
            if (bi.getInt((String) z.get(".sysmsg.WeChatOut.AcctRD"), 0) != 0) {
                au.HU();
                c.DT().a(aa.a.sQV, Boolean.valueOf(true));
                h.mEJ.h(13254, new Object[]{Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(-1), Integer.valueOf(-1)});
            } else {
                au.HU();
                c.DT().a(aa.a.sQV, Boolean.valueOf(false));
            }
        }
        if (z.containsKey(".sysmsg.WeChatOut.TabRD")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRD: %d", new Object[]{Integer.valueOf(bi.getInt((String) z.get(".sysmsg.WeChatOut.TabRD"), 0))});
            if (bi.getInt((String) z.get(".sysmsg.WeChatOut.TabRD"), 0) != 0) {
                au.HU();
                c.DT().a(aa.a.sRi, Boolean.valueOf(true));
                h.mEJ.h(13254, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1)});
            } else {
                au.HU();
                c.DT().a(aa.a.sRi, Boolean.valueOf(false));
            }
        }
        if (z.containsKey(".sysmsg.WeChatOut.RechargeRD")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeRD: %d", new Object[]{Integer.valueOf(bi.getInt((String) z.get(".sysmsg.WeChatOut.RechargeRD"), 0))});
            if (bi.getInt((String) z.get(".sysmsg.WeChatOut.RechargeRD"), 0) != 0) {
                au.HU();
                c.DT().a(aa.a.sRc, Boolean.valueOf(true));
                h.mEJ.h(13254, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1)});
            } else {
                au.HU();
                c.DT().a(aa.a.sRc, Boolean.valueOf(false));
            }
        }
        if (z.containsKey(".sysmsg.WeChatOut.RechargeWording")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWording: %s", new Object[]{(String) z.get(".sysmsg.WeChatOut.RechargeWording")});
            au.HU();
            c.DT().a(aa.a.sRb, substring);
        }
        if (z.containsKey(".sysmsg.WeChatOut.PackagePurchaseWording")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut PackagePurchaseWording: %s", new Object[]{(String) z.get(".sysmsg.WeChatOut.PackagePurchaseWording")});
            au.HU();
            c.DT().a(aa.a.sRd, substring);
        }
        if (z.containsKey(".sysmsg.WeChatOut.AccountWording")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountWording: %s", new Object[]{(String) z.get(".sysmsg.WeChatOut.AccountWording")});
            au.HU();
            c.DT().a(aa.a.sQX, substring);
        }
        if (z.containsKey(".sysmsg.WeChatOut.RechargeWordingVersion")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWordingVersion: %d", new Object[]{Integer.valueOf(bi.getInt((String) z.get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0))});
            au.HU();
            c.DT().a(aa.a.sRm, Integer.valueOf(i));
        }
        if (z.containsKey(".sysmsg.WeChatOut.TabWording")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut TabWording: %s", new Object[]{(String) z.get(".sysmsg.WeChatOut.TabWording")});
            au.HU();
            c.DT().a(aa.a.sRh, substring);
        }
        if (z.containsKey(".sysmsg.WeChatOut.AccountActivityWording")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWording: %s", new Object[]{(String) z.get(".sysmsg.WeChatOut.AccountActivityWording")});
            au.HU();
            c.DT().a(aa.a.sQY, substring);
        }
        if (z.containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingClearType : %d", new Object[]{Integer.valueOf(bi.getInt((String) z.get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0))});
            au.HU();
            c.DT().a(aa.a.sQZ, Integer.valueOf(i));
        }
        if (z.containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingVersion: %d", new Object[]{Integer.valueOf(bi.getInt((String) z.get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0))});
            au.HU();
            c.DT().a(aa.a.sRa, Integer.valueOf(i));
        }
        if (z.containsKey(".sysmsg.WeChatOut.TabRedDotType")) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRedDotType: %d", new Object[]{Integer.valueOf(bi.getInt((String) z.get(".sysmsg.WeChatOut.TabRedDotType"), 0))});
            h.mEJ.h(13254, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(i)});
            au.HU();
            c.DT().a(aa.a.sRj, Integer.valueOf(i));
        }
        i = a.indexOf("<ActivityInfo>");
        i2 = a.indexOf("</ActivityInfo>");
        if (i > 0 && i2 > 0 && i2 > i) {
            substring = a.substring(i, i2 + 15);
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut ActivityInfo: %s", new Object[]{substring});
            com.tencent.mm.plugin.ipcall.a.g.a EN = com.tencent.mm.plugin.ipcall.a.g.a.EN(substring);
            if (EN != null && bi.oW(EN.bHD) && bi.oW(EN.jOS)) {
                x.i("MicroMsg.SubCoreIPCall", "clear activity");
                au.HU();
                c.DT().a(aa.a.sRv, Boolean.valueOf(false));
                au.HU();
                c.DT().a(aa.a.sRw, "");
            } else if (EN != null) {
                if (!bi.oW(EN.ksv)) {
                    o.Pe().a(EN.ksv, null);
                }
                au.HU();
                c.DT().a(aa.a.sRv, Boolean.valueOf(true));
                au.HU();
                c.DT().a(aa.a.sRw, substring);
            }
        }
        com.tencent.mm.sdk.b.a.sFg.m(new ii());
        com.tencent.mm.sdk.b.a.sFg.m(new sa());
    }
}
