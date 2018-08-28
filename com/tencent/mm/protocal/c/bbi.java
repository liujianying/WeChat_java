package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bbi extends bhp {
    public String content;
    public String hwH;
    public boolean hxo;
    public String qZY;
    public String qZZ;
    public String sdu;
    public String sdv;
    public String sdw;
    public String sdx;
    public String sdy;
    public int status;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            if (this.qZY != null) {
                aVar.g(2, this.qZY);
            }
            if (this.qZZ != null) {
                aVar.g(3, this.qZZ);
            }
            aVar.fT(4, this.status);
            if (this.content != null) {
                aVar.g(5, this.content);
            }
            if (this.hwH != null) {
                aVar.g(6, this.hwH);
            }
            if (this.sdu != null) {
                aVar.g(7, this.sdu);
            }
            aVar.av(8, this.hxo);
            if (this.sdv != null) {
                aVar.g(9, this.sdv);
            }
            if (this.sdw != null) {
                aVar.g(10, this.sdw);
            }
            if (this.sdx != null) {
                aVar.g(11, this.sdx);
            }
            if (this.sdy == null) {
                return 0;
            }
            aVar.g(12, this.sdy);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.qZY != null) {
                fS += f.a.a.b.b.a.h(2, this.qZY);
            }
            if (this.qZZ != null) {
                fS += f.a.a.b.b.a.h(3, this.qZZ);
            }
            fS += f.a.a.a.fQ(4, this.status);
            if (this.content != null) {
                fS += f.a.a.b.b.a.h(5, this.content);
            }
            if (this.hwH != null) {
                fS += f.a.a.b.b.a.h(6, this.hwH);
            }
            if (this.sdu != null) {
                fS += f.a.a.b.b.a.h(7, this.sdu);
            }
            fS += f.a.a.b.b.a.ec(8) + 1;
            if (this.sdv != null) {
                fS += f.a.a.b.b.a.h(9, this.sdv);
            }
            if (this.sdw != null) {
                fS += f.a.a.b.b.a.h(10, this.sdw);
            }
            if (this.sdx != null) {
                fS += f.a.a.b.b.a.h(11, this.sdx);
            }
            if (this.sdy != null) {
                fS += f.a.a.b.b.a.h(12, this.sdy);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bbi bbi = (bbi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        bbi.six = flVar;
                    }
                    return 0;
                case 2:
                    bbi.qZY = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bbi.qZZ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bbi.status = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bbi.content = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bbi.hwH = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bbi.sdu = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bbi.hxo = aVar3.cJQ();
                    return 0;
                case 9:
                    bbi.sdv = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bbi.sdw = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bbi.sdx = aVar3.vHC.readString();
                    return 0;
                case 12:
                    bbi.sdy = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
