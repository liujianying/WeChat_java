package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class chn extends a {
    public chq sBA;
    public chs sBB;
    public chr sBC;
    public cht sBD;
    public chm sBE;
    public chp sBy;
    public cho sBz;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sBy != null) {
                aVar.fV(1, this.sBy.boi());
                this.sBy.a(aVar);
            }
            if (this.sBz != null) {
                aVar.fV(2, this.sBz.boi());
                this.sBz.a(aVar);
            }
            if (this.sBA != null) {
                aVar.fV(3, this.sBA.boi());
                this.sBA.a(aVar);
            }
            if (this.sBB != null) {
                aVar.fV(4, this.sBB.boi());
                this.sBB.a(aVar);
            }
            if (this.sBC != null) {
                aVar.fV(5, this.sBC.boi());
                this.sBC.a(aVar);
            }
            if (this.sBD != null) {
                aVar.fV(6, this.sBD.boi());
                this.sBD.a(aVar);
            }
            if (this.sBE == null) {
                return 0;
            }
            aVar.fV(7, this.sBE.boi());
            this.sBE.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.sBy != null) {
                fS = f.a.a.a.fS(1, this.sBy.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.sBz != null) {
                fS += f.a.a.a.fS(2, this.sBz.boi());
            }
            if (this.sBA != null) {
                fS += f.a.a.a.fS(3, this.sBA.boi());
            }
            if (this.sBB != null) {
                fS += f.a.a.a.fS(4, this.sBB.boi());
            }
            if (this.sBC != null) {
                fS += f.a.a.a.fS(5, this.sBC.boi());
            }
            if (this.sBD != null) {
                fS += f.a.a.a.fS(6, this.sBD.boi());
            }
            if (this.sBE != null) {
                fS += f.a.a.a.fS(7, this.sBE.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            chn chn = (chn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        chp chp = new chp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chp.a(aVar4, chp, a.a(aVar4))) {
                        }
                        chn.sBy = chp;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cho cho = new cho();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cho.a(aVar4, cho, a.a(aVar4))) {
                        }
                        chn.sBz = cho;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        chq chq = new chq();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chq.a(aVar4, chq, a.a(aVar4))) {
                        }
                        chn.sBA = chq;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        chs chs = new chs();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chs.a(aVar4, chs, a.a(aVar4))) {
                        }
                        chn.sBB = chs;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        chr chr = new chr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chr.a(aVar4, chr, a.a(aVar4))) {
                        }
                        chn.sBC = chr;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cht cht = new cht();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cht.a(aVar4, cht, a.a(aVar4))) {
                        }
                        chn.sBD = cht;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        chm chm = new chm();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chm.a(aVar4, chm, a.a(aVar4))) {
                        }
                        chn.sBE = chm;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
