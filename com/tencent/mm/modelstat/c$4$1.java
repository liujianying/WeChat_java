package com.tencent.mm.modelstat;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.q;
import com.tencent.mm.bk.b;
import com.tencent.mm.modelstat.c.4;
import com.tencent.mm.modelstat.c.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.adl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class c$4$1 implements Runnable {
    final /* synthetic */ adl eiy;
    final /* synthetic */ 4 eiz;

    c$4$1(4 4, adl adl) {
        this.eiz = 4;
        this.eiy = adl;
    }

    public final void run() {
        String str = null;
        this.eiz.eiw.ao("LAST_UPDATE_CONFIG", bi.VE());
        String str2;
        if (this.eiy.rHS == null || this.eiy.rHS.lR.length <= 0 || this.eiy.rHQ == null || this.eiy.rHQ.lR.length <= 0) {
            Integer num;
            Integer valueOf;
            String str3 = "MicroMsg.ClickFlowStatReceiver";
            str2 = "OnSceneEnd NetSceneUpdateEventConfig failed, eventsampleconf:%s, versionbuffer:%s";
            Object[] objArr = new Object[2];
            if (this.eiy.rHS == null) {
                num = null;
            } else {
                num = Integer.valueOf(this.eiy.rHS.lR.length);
            }
            objArr[0] = num;
            if (this.eiy.rHQ != null) {
                valueOf = Integer.valueOf(this.eiy.rHQ.lR.length);
            }
            objArr[1] = valueOf;
            x.e(str3, str2, objArr);
            return;
        }
        f.mDy.a(346, 3, 1, false);
        str2 = bi.bE(this.eiy.rHQ.lR);
        String value = this.eiz.eiw.getValue("versionBuffer");
        this.eiz.eiw.fT("versionBuffer", str2);
        b bVar = this.eiy.rHS;
        try {
            str = new String(q.x(bVar.lR), "UTF-8");
        } catch (Throwable e) {
            int i;
            Throwable th = e;
            String str4 = "MicroMsg.ClickFlowStatReceiver";
            String str5 = "decompress failed, configString length %d, msg:%s  [%s]";
            Object[] objArr2 = new Object[3];
            if (bVar == null) {
                i = 0;
            } else {
                i = bVar.lR.length;
            }
            objArr2[0] = Integer.valueOf(i);
            objArr2[1] = th.getMessage();
            objArr2[2] = bi.i(th);
            x.e(str4, str5, objArr2);
        }
        if (TextUtils.isEmpty(str)) {
            f.mDy.a(346, 2, 1, false);
            return;
        }
        boolean z;
        try {
            a nk = a.nk(str);
            e.b(this.eiz.eix, str.getBytes(), str.getBytes().length);
            c.a(this.eiz.eiu, nk);
            z = true;
        } catch (Throwable e2) {
            x.e("MicroMsg.ClickFlowStatReceiver", "readReportConfig failed :%s  [%s]", e2.getMessage(), bi.i(e2));
            z = false;
        }
        if (!str2.equals(value)) {
            long j;
            x.i("MicroMsg.ClickFlowStatReceiver", "idKeyStat, configOK:%b", Boolean.valueOf(z));
            f fVar = f.mDy;
            if (z) {
                j = 0;
            } else {
                j = 1;
            }
            fVar.a(346, j, 1, false);
        }
    }
}
