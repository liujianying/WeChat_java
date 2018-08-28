package com.tencent.mm.plugin.sns.ui;

import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.ui.ad.6;
import com.tencent.mm.plugin.sns.ui.ad.7;
import com.tencent.mm.protocal.c.ari;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ad$3 implements Runnable {
    final /* synthetic */ ad nPa;

    ad$3(ad adVar) {
        this.nPa = adVar;
    }

    public final void run() {
        ad adVar = this.nPa;
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(adVar.knh) || TextUtils.isEmpty(adVar.dwE)) {
            if (!adVar.nOW.o(adVar.videoPath, adVar.bOX, adVar.desc, adVar.bKg)) {
                x.i("MicroMsg.SightWidget", "commitInThread videopath " + FileOp.mI(adVar.videoPath) + " thumb: " + FileOp.mI(adVar.bOX));
                ah.A(new 7(adVar));
            }
            x.i("MicroMsg.SightWidget", "commitInThread cost time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } else {
            int i;
            ax axVar = adVar.nOW;
            String str = adVar.videoPath;
            String str2 = adVar.bOX;
            String str3 = adVar.desc;
            String str4 = adVar.bKg;
            String str5 = adVar.knh;
            String str6 = adVar.dwE;
            String str7 = af.getAccSnsTmpPath() + g.u(str.getBytes());
            ax.MI(str7);
            FileOp.y(str, str7);
            String str8 = af.getAccSnsTmpPath() + g.u(str2.getBytes());
            FileOp.y(str2, str8);
            ate c = ax.c("", str7, str8, str4, str5, str6);
            if (c == null) {
                x.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
                i = 0;
            } else {
                c.jOS = str3;
                if (bi.oW(c.bHD)) {
                    c.bHD = str3;
                }
                axVar.nsx.sqc.ruA.add(c);
                ari ari = new ari();
                ari.rTF = c.nkZ;
                axVar.nsy.rWc.add(ari);
                i = 1;
            }
            if (i == 0) {
                x.i("MicroMsg.SightWidget", "commitInThread videopath " + FileOp.mI(adVar.videoPath) + " thumb: " + FileOp.mI(adVar.bOX) + ",cdnUrl " + adVar.knh + "cdnThubmUrl " + adVar.dwE);
                ah.A(new 6(adVar));
            }
            x.i("MicroMsg.SightWidget", "commitInThread cost time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        x.i("MicroMsg.SightWidget", "removeRunnable showProgress");
        ah.M(this.nPa.nOZ);
        if (this.nPa.nOW != null) {
            ah.A(this.nPa.nOY);
        }
    }
}
