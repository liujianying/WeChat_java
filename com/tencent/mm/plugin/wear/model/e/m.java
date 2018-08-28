package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.c.brd;
import com.tencent.mm.protocal.c.cec;
import com.tencent.mm.protocal.c.cew;
import com.tencent.mm.protocal.c.cex;
import com.tencent.mm.protocal.c.cey;
import com.tencent.mm.protocal.c.cez;
import com.tencent.mm.protocal.c.cfd;
import com.tencent.mm.protocal.c.cgd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class m extends a {
    public final List<Integer> bSy() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_OUT));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_USERLIST));
        arrayList.add(Integer.valueOf(11025));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_NEED_REENTER));
        arrayList.add(Integer.valueOf(11026));
        arrayList.add(Integer.valueOf(11029));
        return arrayList;
    }

    protected final boolean zE(int i) {
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_USERLIST /*11023*/:
            case 11025:
                return true;
            default:
                return false;
        }
    }

    protected final byte[] p(int i, byte[] bArr) {
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_OUT /*11022*/:
                cez cez = new cez();
                try {
                    cez.aG(bArr);
                } catch (IOException e) {
                }
                a.bSl().pIS.a(new a(cez));
                a.bSl().pIO.PM(cez.szk);
                com.tencent.mm.plugin.wear.model.c.a.ee(2, cez.otY);
                com.tencent.mm.plugin.wear.model.c.a.zC(2);
                break;
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_USERLIST /*11023*/:
                cey cey = new cey();
                try {
                    cey.aG(bArr);
                } catch (IOException e2) {
                }
                g.bcT().D(cey.szk, cey.rBM, s.hQ(cey.szk));
                au.HU();
                c.FW().Ys(cey.szk);
                com.tencent.mm.plugin.wear.model.c.a.ee(3, cey.otY);
                com.tencent.mm.plugin.wear.model.c.a.zC(5);
                break;
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_NEED_REENTER /*11024*/:
                cew cew = new cew();
                try {
                    cew.aG(bArr);
                } catch (IOException e3) {
                }
                ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().o(ad.getContext(), cew.szk, cew.rwt);
                au.HU();
                c.FW().Ys(cew.szk);
                com.tencent.mm.plugin.wear.model.c.a.ee(7, cew.otY);
                com.tencent.mm.plugin.wear.model.c.a.zC(3);
                break;
            case 11025:
                cex cex = new cex();
                try {
                    cex.aG(bArr);
                } catch (IOException e4) {
                }
                g.bcT().D(cex.szk, cex.rBM, s.hQ(cex.szk));
                ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().o(ad.getContext(), cex.szk, cex.rwt);
                au.HU();
                c.FW().Ys(cex.szk);
                com.tencent.mm.plugin.wear.model.c.a.ee(8, cex.otY);
                com.tencent.mm.plugin.wear.model.c.a.zC(4);
                break;
            case 11026:
                cfd cfd = new cfd();
                try {
                    cfd.aG(bArr);
                } catch (IOException e5) {
                }
                a.bSl();
                cec cec = a.bSl().pIM.pJd.pJT;
                if (cec != null) {
                    x.i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", new Object[]{Integer.valueOf(cfd.szK), h.h("yyyy-MM-dd HH:mm:ss", cfd.szL / 1000)});
                    cgd cgd = new cgd();
                    brd brd = new brd();
                    brd.hcC = cfd.szK > 0 ? cfd.szK : 0;
                    brd.rxy = (int) (cfd.szL / 1000);
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(cfd.szL);
                    brd.spm = instance.get(1);
                    brd.spn = instance.get(2) + 1;
                    brd.spo = instance.get(5);
                    brd.spp = instance.get(11);
                    brd.spq = instance.get(12);
                    brd.spr = instance.get(13);
                    cgd.sAC.add(brd);
                    tq tqVar = new tq();
                    try {
                        tqVar.cfq.data = cgd.toByteArray();
                    } catch (IOException e6) {
                    }
                    tqVar.cfq.bIH = 4;
                    tqVar.cfq.byN = cec.szd;
                    tqVar.cfq.bKv = "gh_43f2581f6fd6";
                    com.tencent.mm.sdk.b.a.sFg.m(tqVar);
                    break;
                }
                x.e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
                break;
            case 11029:
                if (a.bSl().pIM.bSq() && com.tencent.mm.k.g.AT().getInt("WearLuckyBlock", 0) == 0) {
                    long j = 0;
                    try {
                        j = Long.valueOf(new String(bArr)).longValue();
                    } catch (Exception e7) {
                    }
                    to toVar = new to();
                    toVar.cfd.action = 1;
                    toVar.cfd.bIZ = j;
                    com.tencent.mm.sdk.b.a.sFg.a(toVar, Looper.getMainLooper());
                    com.tencent.mm.plugin.wear.model.c.a.ee(11, 0);
                    com.tencent.mm.plugin.wear.model.c.a.zC(11);
                    break;
                }
                return null;
                break;
        }
        return null;
    }
}
