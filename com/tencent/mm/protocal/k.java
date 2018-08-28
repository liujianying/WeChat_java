package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.fk;
import com.tencent.mm.protocal.c.fl;
import com.tencent.mm.sdk.platformtools.x;

public final class k {

    public interface a {
        boolean a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2);
    }

    public interface b {
        byte[] Ie();

        int If();

        boolean cgo();
    }

    public interface c {
        int G(byte[] bArr);

        boolean cgo();
    }

    public static class d {
        public byte[] bjP = new byte[0];
        public long bufferSize = 0;
        public y qWA = new y("", "", 0);
        public int qWs = 0;
        public int qWt = 0;
        public String qWu = "";
        public String qWv = "";
        public int qWw = 0;
        public boolean qWx = true;
        public a qWy;
        public byte[] qWz;

        public void eK(int i) {
            this.qWs = i;
        }

        public int getCmdId() {
            return 0;
        }

        public boolean cgo() {
            return false;
        }

        public boolean LB() {
            return this.qWx;
        }
    }

    public static class e {
        public long bufferSize = 0;
        public int qWB = -99;
        public int qWC = 255;
        public String qWD = "";

        public int getCmdId() {
            return 0;
        }

        public boolean cgo() {
            return false;
        }
    }

    public static fk a(d dVar) {
        fk fkVar = new fk();
        fkVar.rgt = dVar.qWt;
        fkVar.otY = dVar.qWw;
        fkVar.iwE = dVar.qWs;
        fkVar.rgs = com.tencent.mm.bk.b.bi(dVar.qWv.getBytes());
        if (fkVar.rgs.lR.length >= 16) {
            fkVar.rgs = fkVar.rgs.Cz(16);
        }
        fkVar.rgu = com.tencent.mm.bk.b.bi(dVar.qWu.getBytes());
        if (fkVar.rgu.lR.length >= 132) {
            fkVar.rgu = fkVar.rgu.Cz(132);
        }
        fkVar.rgr = com.tencent.mm.bk.b.bi(dVar.bjP);
        if (fkVar.rgr.lR.length >= 36) {
            fkVar.rgr = fkVar.rgr.Cz(36);
        }
        return fkVar;
    }

    public static void a(e eVar, fl flVar) {
        if (flVar.rgv != null) {
            eVar.qWD = flVar.rgv.siM;
            return;
        }
        eVar.qWD = "";
        x.e("MicroMsg.MMBase", "ErrMsg is Null!!!!!!");
    }
}
