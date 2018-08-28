package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class amo extends a {
    public int create_time;
    public int huK;
    public String hwg;
    public int peW;
    public String rIw;
    public String rPn;
    public bao rPo;
    public int rPp;
    public int rPq;
    public String rPr;
    public String rrW;
    public long ruW;
    public int state;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rIw != null) {
                aVar.g(1, this.rIw);
            }
            if (this.rrW != null) {
                aVar.g(2, this.rrW);
            }
            aVar.T(3, this.ruW);
            aVar.fT(4, this.state);
            if (this.rPn != null) {
                aVar.g(5, this.rPn);
            }
            aVar.fT(6, this.peW);
            if (this.rPo != null) {
                aVar.fV(7, this.rPo.boi());
                this.rPo.a(aVar);
            }
            aVar.fT(8, this.create_time);
            aVar.fT(9, this.huK);
            aVar.fT(10, this.rPp);
            aVar.fT(11, this.rPq);
            if (this.rPr != null) {
                aVar.g(12, this.rPr);
            }
            if (this.hwg == null) {
                return 0;
            }
            aVar.g(13, this.hwg);
            return 0;
        } else if (i == 1) {
            if (this.rIw != null) {
                h = f.a.a.b.b.a.h(1, this.rIw) + 0;
            } else {
                h = 0;
            }
            if (this.rrW != null) {
                h += f.a.a.b.b.a.h(2, this.rrW);
            }
            h = (h + f.a.a.a.S(3, this.ruW)) + f.a.a.a.fQ(4, this.state);
            if (this.rPn != null) {
                h += f.a.a.b.b.a.h(5, this.rPn);
            }
            h += f.a.a.a.fQ(6, this.peW);
            if (this.rPo != null) {
                h += f.a.a.a.fS(7, this.rPo.boi());
            }
            h = (((h + f.a.a.a.fQ(8, this.create_time)) + f.a.a.a.fQ(9, this.huK)) + f.a.a.a.fQ(10, this.rPp)) + f.a.a.a.fQ(11, this.rPq);
            if (this.rPr != null) {
                h += f.a.a.b.b.a.h(12, this.rPr);
            }
            if (this.hwg != null) {
                h += f.a.a.b.b.a.h(13, this.hwg);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            amo amo = (amo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    amo.rIw = aVar3.vHC.readString();
                    return 0;
                case 2:
                    amo.rrW = aVar3.vHC.readString();
                    return 0;
                case 3:
                    amo.ruW = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    amo.state = aVar3.vHC.rY();
                    return 0;
                case 5:
                    amo.rPn = aVar3.vHC.readString();
                    return 0;
                case 6:
                    amo.peW = aVar3.vHC.rY();
                    return 0;
                case 7:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bao bao = new bao();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bao.a(aVar4, bao, a.a(aVar4))) {
                        }
                        amo.rPo = bao;
                    }
                    return 0;
                case 8:
                    amo.create_time = aVar3.vHC.rY();
                    return 0;
                case 9:
                    amo.huK = aVar3.vHC.rY();
                    return 0;
                case 10:
                    amo.rPp = aVar3.vHC.rY();
                    return 0;
                case 11:
                    amo.rPq = aVar3.vHC.rY();
                    return 0;
                case 12:
                    amo.rPr = aVar3.vHC.readString();
                    return 0;
                case 13:
                    amo.hwg = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
