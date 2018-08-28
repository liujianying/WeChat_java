package com.tencent.pb.common.b;

import com.tencent.pb.common.c.c;

class d$2 implements Runnable {
    final /* synthetic */ d vcd;
    final /* synthetic */ int vce;
    final /* synthetic */ int vcf;

    d$2(d dVar, int i, int i2) {
        this.vcd = dVar;
        this.vce = i;
        this.vcf = i2;
    }

    public final void run() {
        if (this.vcd.hiW) {
            c.d("MicroMsg.Voip", new Object[]{this.vcd.TAG2, "onResp netscene already canceled, cmd:" + this.vcd.vcb});
        } else if (this.vcd.vbY != null) {
            this.vcd.vbY.a(this.vce, this.vcf, "", this.vcd);
        }
    }
}
