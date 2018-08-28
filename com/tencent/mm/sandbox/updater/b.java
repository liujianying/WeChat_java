package com.tencent.mm.sandbox.updater;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.protocal.c.aiw;
import com.tencent.mm.protocal.c.fk;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends c {
    private String[] bJe;
    private byte[] ccH;
    private byte[] erT;
    private byte[] erV;
    private int sDB = 0;
    private final int sDC = 5;
    private int sDD = 0;
    private a sDE;
    private a sDF = null;
    private a sDG = new 1(this);
    private int uin;

    public b(int i, String str, int i2, int i3, byte[] bArr, byte[] bArr2, String[] strArr, boolean z) {
        super(i, str, i2, z);
        this.bJe = strArr;
        if (strArr == null || strArr.length == 0) {
            this.bJe = new String[]{"short.weixin.qq.com"};
        }
        this.uin = i3;
        this.erT = bArr;
        this.ccH = bArr2;
    }

    public final void a(a aVar) {
        this.sDE = aVar;
        int i = this.sDB + 1;
        this.sDB = i;
        if (i > 1000) {
            x.d("MicroMsg.NetSceneGetUpdatePack", "doSceneCnt > DOSCENE_LIMIT, return");
            this.sDE.a(-1, -1, null);
        } else if (f.aM((long) this.sDj)) {
            aiw aiw = new aiw();
            fk fkVar = new fk();
            fkVar.rgt = d.qVN;
            fkVar.otY = 0;
            fkVar.iwE = this.uin;
            fkVar.rgs = com.tencent.mm.bk.b.bi(q.zz().getBytes());
            if (fkVar.rgs.lR.length >= 16) {
                fkVar.rgs = fkVar.rgs.Cz(16);
            }
            fkVar.rgu = com.tencent.mm.bk.b.bi(d.DEVICE_TYPE.getBytes());
            if (fkVar.rgu.lR.length >= 132) {
                fkVar.rgu = fkVar.rgu.Cz(132);
            }
            fkVar.rgr = com.tencent.mm.bk.b.bi(this.erT);
            if (fkVar.rgr.lR.length >= 36) {
                fkVar.rgr = fkVar.rgr.Cz(36);
            }
            aiw.shX = fkVar;
            aiw.rLv = this.sDi;
            aiw.rdW = this.sDk;
            aiw.rdV = this.sDj;
            a aVar2 = new a(this, this.bJe[this.sDD / 5], this.sDG);
            this.sDF = aVar2;
            aVar2.execute(new aiw[]{aiw});
        } else {
            x.e("MicroMsg.NetSceneGetUpdatePack", "SDCard full, packSize=[%s]", new Object[]{Integer.valueOf(this.sDj)});
            aVar.a(-1, -1, null);
        }
    }

    public final void cancel() {
        x.i("MicroMsg.NetSceneGetUpdatePack", "do cancel, updateType = " + this.sDi);
        if (this.sDF != null && !this.sDF.isCancelled()) {
            this.sDF.cancel(true);
        }
    }
}
