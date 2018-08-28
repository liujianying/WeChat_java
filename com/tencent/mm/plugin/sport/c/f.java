package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bvq;
import com.tencent.mm.protocal.c.bvr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import java.util.Date;
import java.util.TimeZone;

public final class f extends l implements k {
    private b diG = null;
    private e diJ = null;
    private bvq ooY;

    public f(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        int i5;
        x.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep %s, %s, %s, %s, %s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        a aVar = new a();
        aVar.dIG = new bvq();
        aVar.dIH = new bvr();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/uploaddevicestep";
        aVar.dIF = 1261;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.ooY = (bvq) this.diG.dID.dIL;
        this.ooY.byN = str;
        this.ooY.bKv = str2;
        this.ooY.ssb = i;
        this.ooY.ssc = i2;
        this.ooY.blZ = i3;
        bvq bvq = this.ooY;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset() / TbsLog.TBSLOG_CODE_SDK_BASE;
        if (timeZone.useDaylightTime() && timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        bvq.ssd = String.valueOf(i5 + (rawOffset / 3600));
        this.ooY.ssf = str3;
        this.ooY.ssi = i4;
    }

    public final int getType() {
        return 1261;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }
}
