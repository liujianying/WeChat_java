package com.tencent.mm.modelvideo;

import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static void a(r rVar, int i) {
        if (rVar == null) {
            x.w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
            return;
        }
        int i2;
        long VG = bi.VG();
        o.Ta();
        String nK = s.nK(rVar.getFileName());
        long j = 0;
        long j2 = 0;
        if (c.oZ(nK)) {
            i2 = 1;
            b bVar = new b();
            j = bVar.oY(nK);
            j2 = bVar.eyA != null ? bVar.eyA.eyw : 0;
        } else {
            x.i("MicroMsg.AtomStatUtil", "download video finish, but it is not mp4 file.");
            i2 = 0;
        }
        long j3 = rVar.bYu;
        nK = r.nH(rVar.Tm());
        long j4 = (long) rVar.dHI;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j3).append(";").append(nK).append(";");
        stringBuilder.append(j4).append(";");
        stringBuilder.append(i2).append(";").append(j).append(";");
        stringBuilder.append(j2).append(";").append(i);
        x.d("MicroMsg.AtomStatUtil", "report moov content : " + stringBuilder.toString() + " cost time: " + bi.bI(VG));
        h.mEJ.h(11098, new Object[]{Integer.valueOf(8000), r0});
    }
}
