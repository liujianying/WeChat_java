package com.tencent.mm.plugin.hp.b;

import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.hp.a.b;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class g$2 implements Runnable {
    final /* synthetic */ String[] dhB;
    final /* synthetic */ g kmJ;

    g$2(g gVar, String[] strArr) {
        this.kmJ = gVar;
        this.dhB = strArr;
    }

    public final void run() {
        int i;
        String str = e.bnE + "/Download/2017-07-28_19-43-39.apk";
        String str2 = e.bnE + "/Download/39-50-diff.apk";
        String str3 = e.bnE + "/Download/new_50.apk";
        String str4 = "ab099f75f740be5d88e178d662a36779";
        if (this.dhB.length >= 3 && !bi.oW(this.dhB[2])) {
            str = this.dhB[2];
        }
        if (this.dhB.length >= 4 && !bi.oW(this.dhB[3])) {
            str2 = this.dhB[3];
        }
        if (this.dhB.length >= 5 && !bi.oW(this.dhB[4])) {
            str3 = this.dhB[4];
        }
        if (this.dhB.length >= 6 && !bi.oW(this.dhB[5])) {
            str4 = this.dhB[5];
        }
        if (com.tencent.mm.a.e.cn(str3)) {
            i = 0;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            i = b.b(str, str2, str3, str4);
            x.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk use :%d retCode：%d", new Object[]{Long.valueOf((System.currentTimeMillis() - currentTimeMillis) / 1000), Integer.valueOf(i)});
        }
        if (i == 0) {
            x.i("MicroMsg.Tinker.TinkerBootsCommand", "show dialog for install");
            x.i("MicroMsg.Tinker.TinkerBootsCommand", "New Apk md5:%s", new Object[]{g.cu(str3)});
            i.bk(ad.getContext(), str3);
            x.i("MicroMsg.Tinker.TinkerBootsCommand", "md5 is equal.");
            return;
        }
        x.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk failed.");
    }
}
