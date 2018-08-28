package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ahj;
import com.tencent.mm.protocal.c.ahk;
import com.tencent.mm.sandbox.updater.Updater.3;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.Map;

class Updater$3$1 implements e {
    final /* synthetic */ com.tencent.mm.network.e dpX;
    final /* synthetic */ 3 sEx;

    Updater$3$1(3 3, com.tencent.mm.network.e eVar) {
        this.sEx = 3;
        this.dpX = eVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(TbsListener$ErrorCode.INCRUPDATE_INSTALL_SUCCESS, Updater.f(this.sEx.sEw));
        Updater.a(this.sEx.sEw, null);
        if (i == 0 && i2 == 0) {
            long j;
            o oVar = (o) lVar;
            if (((ahj) oVar.efk.dID.dIL).hcE == 0) {
                String str2 = ((ahk) oVar.efk.dIE.dIL).jSA;
                if (!bi.oW(str2)) {
                    Map z = bl.z(str2, "resourcecontrolinfo");
                    if (z != null) {
                        str2 = (String) z.get(".resourcecontrolinfo.enableupdate");
                        String str3 = (String) z.get(".resourcecontrolinfo.expiredtime");
                        x.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate getDisableUpdateTime values[%s]", new Object[]{z});
                        if (bi.getInt(str2, 1) == 0) {
                            j = bi.getLong(str3, 0);
                            if (j > System.currentTimeMillis() / 1000) {
                                x.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", new Object[]{Long.valueOf(j), Long.valueOf(System.currentTimeMillis() / 1000)});
                                h.mEJ.a(405, 0, 1, true);
                                return;
                            }
                        }
                    }
                }
            }
            j = 0;
            if (j > System.currentTimeMillis() / 1000) {
                x.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", new Object[]{Long.valueOf(j), Long.valueOf(System.currentTimeMillis() / 1000)});
                h.mEJ.a(405, 0, 1, true);
                return;
            }
        }
        x.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService after checkcontrol");
        h.mEJ.a(405, 59, 1, true);
        Intent intent = new Intent(this.sEx.sEw.getContext(), UpdaterService.class);
        Updater.a(this.sEx.sEw, intent, this.dpX, this.sEx.sEv);
        intent.putExtra("intent_extra_run_in_foreground", true);
        intent.putExtra("intent_extra_download_mode", 2);
        this.sEx.sEw.getContext().startService(intent);
    }
}
