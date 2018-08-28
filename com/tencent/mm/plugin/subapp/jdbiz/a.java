package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements com.tencent.mm.model.bv.a {
    c oqD = new 1(this);

    public final void a(com.tencent.mm.ab.d.a aVar) {
        x.i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
        by byVar = aVar.dIN;
        if (byVar == null) {
            x.e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
            return;
        }
        final b bVar = new b();
        bVar.MU(ab.a(byVar.rcl));
        x.i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + bi.aG(bVar.oqG, ""));
        if (bi.oW(bVar.oqG)) {
            x.e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
        } else if (bi.oW(bVar.oqH)) {
            x.e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
        } else if (!bVar.a(c.bGg().bGl())) {
            x.i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
        } else if (!c.bGo()) {
            x.e("MicroMsg.JDSysMsgNotifyLsn", "no entrance, ignore msg");
        } else if (bVar.oqG.equals("3")) {
            byVar.rcp = null;
            if (bi.oW(bVar.oqR) || bi.oW(bVar.jumpUrl) || bi.oW(bVar.oqS) || bi.oW(bVar.oqT) || bi.oW(bVar.oqQ)) {
                x.e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
            } else if (bVar.bFZ()) {
                x.i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            } else {
                c bGg = c.bGg();
                String str = bVar.oqH;
                if (bi.oW(str) ? false : bGg.oqW.containsKey(str)) {
                    x.i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + bVar.oqH);
                } else if (bVar.a(c.bGg().bGl())) {
                    bGg = c.bGg();
                    str = bVar.oqH;
                    if (!bi.oW(str)) {
                        bGg.oqW.put(str, Integer.valueOf(1));
                    }
                    x.i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + bVar.oqH);
                    new ag(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            a aVar = a.this;
                            b bVar = bVar;
                            au.HU();
                            int intValue = ((Integer) com.tencent.mm.model.c.DT().get(15, Integer.valueOf(0))).intValue();
                            String cl;
                            if (au.DF().foreground && 1 == intValue) {
                                JDRemindDialog.a(ad.getContext(), bVar.oqR, bVar.oqS, bVar.oqT, c.cl(bVar.jumpUrl, 5), bVar.oqH);
                                h.mEJ.h(11178, new Object[]{cl, c.bGg().bGl().oqH, Integer.valueOf(5)});
                                return;
                            }
                            cl = c.cl(bVar.jumpUrl, 4);
                            Bundle bundle = new Bundle();
                            bundle.putString("activity_id", bVar.oqH);
                            bundle.putString("jump_url", cl);
                            ((ao) au.getNotification()).a(37, ad.getContext().getString(R.l.app_pushcontent_title), bVar.oqQ, cl, "bizjd", bundle);
                            com.tencent.mm.sdk.b.a.sFg.b(aVar.oqD);
                            h.mEJ.h(11178, new Object[]{cl, c.bGg().bGl().oqH, Integer.valueOf(4)});
                        }
                    });
                } else {
                    x.i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
                }
            }
            c.b(bVar);
        } else if (bVar.oqG.equals("1")) {
            c.b(bVar);
        } else if (bVar.oqG.equals("2")) {
            c.b(bVar);
        }
        au.HU();
        com.tencent.mm.model.c.DT().lm(true);
    }
}
