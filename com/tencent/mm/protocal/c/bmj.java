package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bmj extends bhp {
    public String cad;
    public String dxh;
    public int end_time;
    public String huU;
    public String huW;
    public String huX;
    public String huY;
    public int hwF;
    public String hwh;
    public int mXk;
    public int mXn;
    public String mXo;
    public String mXp;
    public String mXq;
    public String mXr;
    public String mXs;
    public boolean mXt;
    public String title;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.hwF);
            if (this.huU != null) {
                aVar.g(3, this.huU);
            }
            if (this.cad != null) {
                aVar.g(4, this.cad);
            }
            if (this.title != null) {
                aVar.g(5, this.title);
            }
            if (this.huX != null) {
                aVar.g(6, this.huX);
            }
            if (this.huY != null) {
                aVar.g(7, this.huY);
            }
            if (this.hwh != null) {
                aVar.g(8, this.hwh);
            }
            if (this.huW != null) {
                aVar.g(9, this.huW);
            }
            if (this.dxh != null) {
                aVar.g(10, this.dxh);
            }
            aVar.fT(11, this.mXk);
            aVar.fT(12, this.mXn);
            if (this.mXo != null) {
                aVar.g(13, this.mXo);
            }
            if (this.mXp != null) {
                aVar.g(14, this.mXp);
            }
            if (this.mXq != null) {
                aVar.g(19, this.mXq);
            }
            if (this.mXr != null) {
                aVar.g(21, this.mXr);
            }
            aVar.fT(22, this.end_time);
            if (this.mXs != null) {
                aVar.g(23, this.mXs);
            }
            aVar.av(24, this.mXt);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.hwF);
            if (this.huU != null) {
                fS += f.a.a.b.b.a.h(3, this.huU);
            }
            if (this.cad != null) {
                fS += f.a.a.b.b.a.h(4, this.cad);
            }
            if (this.title != null) {
                fS += f.a.a.b.b.a.h(5, this.title);
            }
            if (this.huX != null) {
                fS += f.a.a.b.b.a.h(6, this.huX);
            }
            if (this.huY != null) {
                fS += f.a.a.b.b.a.h(7, this.huY);
            }
            if (this.hwh != null) {
                fS += f.a.a.b.b.a.h(8, this.hwh);
            }
            if (this.huW != null) {
                fS += f.a.a.b.b.a.h(9, this.huW);
            }
            if (this.dxh != null) {
                fS += f.a.a.b.b.a.h(10, this.dxh);
            }
            fS = (fS + f.a.a.a.fQ(11, this.mXk)) + f.a.a.a.fQ(12, this.mXn);
            if (this.mXo != null) {
                fS += f.a.a.b.b.a.h(13, this.mXo);
            }
            if (this.mXp != null) {
                fS += f.a.a.b.b.a.h(14, this.mXp);
            }
            if (this.mXq != null) {
                fS += f.a.a.b.b.a.h(19, this.mXq);
            }
            if (this.mXr != null) {
                fS += f.a.a.b.b.a.h(21, this.mXr);
            }
            fS += f.a.a.a.fQ(22, this.end_time);
            if (this.mXs != null) {
                fS += f.a.a.b.b.a.h(23, this.mXs);
            }
            return fS + (f.a.a.b.b.a.ec(24) + 1);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bmj bmj = (bmj) objArr[1];
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
                        bmj.six = flVar;
                    }
                    return 0;
                case 2:
                    bmj.hwF = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bmj.huU = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bmj.cad = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bmj.title = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bmj.huX = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bmj.huY = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bmj.hwh = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bmj.huW = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bmj.dxh = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bmj.mXk = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bmj.mXn = aVar3.vHC.rY();
                    return 0;
                case 13:
                    bmj.mXo = aVar3.vHC.readString();
                    return 0;
                case 14:
                    bmj.mXp = aVar3.vHC.readString();
                    return 0;
                case 19:
                    bmj.mXq = aVar3.vHC.readString();
                    return 0;
                case 21:
                    bmj.mXr = aVar3.vHC.readString();
                    return 0;
                case 22:
                    bmj.end_time = aVar3.vHC.rY();
                    return 0;
                case 23:
                    bmj.mXs = aVar3.vHC.readString();
                    return 0;
                case 24:
                    bmj.mXt = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
