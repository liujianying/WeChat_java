package com.tencent.mm.modelvideo;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

class n$2 implements Runnable {
    final /* synthetic */ String dAt;
    final /* synthetic */ long dUQ;
    final /* synthetic */ String dat;
    final /* synthetic */ n ene;
    final /* synthetic */ String[] enf;
    final /* synthetic */ String eng;
    final /* synthetic */ int enh;
    final /* synthetic */ String eni;
    final /* synthetic */ String enj;
    final /* synthetic */ long enk;
    final /* synthetic */ int enl;
    final /* synthetic */ int enm;
    final /* synthetic */ String enn;

    n$2(n nVar, String str, String[] strArr, String str2, String str3, int i, String str4, String str5, long j, long j2, int i2, int i3, String str6) {
        this.ene = nVar;
        this.dat = str;
        this.enf = strArr;
        this.dAt = str2;
        this.eng = str3;
        this.enh = i;
        this.eni = str4;
        this.enj = str5;
        this.dUQ = j;
        this.enk = j2;
        this.enl = i2;
        this.enm = i3;
        this.enn = str6;
    }

    public final void run() {
        a Lo = d.Lo(this.dat);
        if (Lo == null) {
            x.w("MicroMsg.SubCoreMediaRpt", "get media info is null. %s", new Object[]{this.dat});
            return;
        }
        int cm = e.cm(this.dat);
        String str = null;
        if (this.enf != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (String append : this.enf) {
                stringBuffer.append(append).append("|");
            }
            str = stringBuffer.toString();
        }
        int fJ = ao.fJ(ad.getContext());
        g.NE();
        String ls = b.ls(this.dat);
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(this.dAt).append(",").append(this.eng).append(",");
        stringBuffer2.append(this.enh).append(",").append(this.eni).append(",");
        stringBuffer2.append(this.enj).append(",").append(fJ).append(",");
        stringBuffer2.append(ls).append(",").append(this.dUQ).append(",");
        stringBuffer2.append(this.enk).append(",").append(cm).append(",");
        stringBuffer2.append(Lo.jdD).append(",").append(Lo.videoBitrate / BaseReportManager.MAX_READ_COUNT).append(",");
        stringBuffer2.append(Lo.dQF / BaseReportManager.MAX_READ_COUNT).append(",").append(Lo.ljG).append(",");
        stringBuffer2.append(Lo.width).append(",").append(Lo.height).append(",");
        stringBuffer2.append(str).append(",").append(Lo.nbS).append(",");
        stringBuffer2.append(this.enl).append(",").append(this.enm).append(",");
        stringBuffer2.append(c.OC(this.enn));
        x.i("MicroMsg.SubCoreMediaRpt", "download video rpt %s ", new Object[]{stringBuffer2.toString()});
        new com.tencent.mm.g.b.a.d(stringBuffer2.toString()).RD();
    }
}
