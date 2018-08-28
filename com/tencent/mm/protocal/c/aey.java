package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aey extends bhp {
    public String cad;
    public String dxh;
    public int end_time;
    public String huU;
    public String huW;
    public String huX;
    public String huY;
    public String hwh;
    public int mXn;
    public String mXo;
    public String mXp;
    public String mXq;
    public String mXs;
    public boolean mXt;
    public boolean rIO;
    public boolean rIP;
    public String rIQ;
    public String rIR;
    public int rIS;
    public String rIT;
    public int rIU;
    public String rIV;
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
            aVar.av(2, this.rIO);
            aVar.av(3, this.rIP);
            if (this.rIQ != null) {
                aVar.g(4, this.rIQ);
            }
            if (this.rIR != null) {
                aVar.g(5, this.rIR);
            }
            aVar.fT(6, this.rIS);
            if (this.rIT != null) {
                aVar.g(7, this.rIT);
            }
            aVar.fT(8, this.rIU);
            if (this.huU != null) {
                aVar.g(9, this.huU);
            }
            if (this.cad != null) {
                aVar.g(10, this.cad);
            }
            if (this.title != null) {
                aVar.g(11, this.title);
            }
            if (this.huX != null) {
                aVar.g(12, this.huX);
            }
            if (this.huY != null) {
                aVar.g(13, this.huY);
            }
            if (this.hwh != null) {
                aVar.g(14, this.hwh);
            }
            if (this.huW != null) {
                aVar.g(15, this.huW);
            }
            if (this.dxh != null) {
                aVar.g(16, this.dxh);
            }
            aVar.fT(17, this.mXn);
            if (this.mXo != null) {
                aVar.g(18, this.mXo);
            }
            if (this.mXp != null) {
                aVar.g(19, this.mXp);
            }
            if (this.mXq != null) {
                aVar.g(20, this.mXq);
            }
            aVar.fT(21, this.end_time);
            if (this.mXs != null) {
                aVar.g(22, this.mXs);
            }
            if (this.rIV != null) {
                aVar.g(23, this.rIV);
            }
            aVar.av(24, this.mXt);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + (f.a.a.b.b.a.ec(2) + 1)) + (f.a.a.b.b.a.ec(3) + 1);
            if (this.rIQ != null) {
                fS += f.a.a.b.b.a.h(4, this.rIQ);
            }
            if (this.rIR != null) {
                fS += f.a.a.b.b.a.h(5, this.rIR);
            }
            fS += f.a.a.a.fQ(6, this.rIS);
            if (this.rIT != null) {
                fS += f.a.a.b.b.a.h(7, this.rIT);
            }
            fS += f.a.a.a.fQ(8, this.rIU);
            if (this.huU != null) {
                fS += f.a.a.b.b.a.h(9, this.huU);
            }
            if (this.cad != null) {
                fS += f.a.a.b.b.a.h(10, this.cad);
            }
            if (this.title != null) {
                fS += f.a.a.b.b.a.h(11, this.title);
            }
            if (this.huX != null) {
                fS += f.a.a.b.b.a.h(12, this.huX);
            }
            if (this.huY != null) {
                fS += f.a.a.b.b.a.h(13, this.huY);
            }
            if (this.hwh != null) {
                fS += f.a.a.b.b.a.h(14, this.hwh);
            }
            if (this.huW != null) {
                fS += f.a.a.b.b.a.h(15, this.huW);
            }
            if (this.dxh != null) {
                fS += f.a.a.b.b.a.h(16, this.dxh);
            }
            fS += f.a.a.a.fQ(17, this.mXn);
            if (this.mXo != null) {
                fS += f.a.a.b.b.a.h(18, this.mXo);
            }
            if (this.mXp != null) {
                fS += f.a.a.b.b.a.h(19, this.mXp);
            }
            if (this.mXq != null) {
                fS += f.a.a.b.b.a.h(20, this.mXq);
            }
            fS += f.a.a.a.fQ(21, this.end_time);
            if (this.mXs != null) {
                fS += f.a.a.b.b.a.h(22, this.mXs);
            }
            if (this.rIV != null) {
                fS += f.a.a.b.b.a.h(23, this.rIV);
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
            aey aey = (aey) objArr[1];
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
                        aey.six = flVar;
                    }
                    return 0;
                case 2:
                    aey.rIO = aVar3.cJQ();
                    return 0;
                case 3:
                    aey.rIP = aVar3.cJQ();
                    return 0;
                case 4:
                    aey.rIQ = aVar3.vHC.readString();
                    return 0;
                case 5:
                    aey.rIR = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aey.rIS = aVar3.vHC.rY();
                    return 0;
                case 7:
                    aey.rIT = aVar3.vHC.readString();
                    return 0;
                case 8:
                    aey.rIU = aVar3.vHC.rY();
                    return 0;
                case 9:
                    aey.huU = aVar3.vHC.readString();
                    return 0;
                case 10:
                    aey.cad = aVar3.vHC.readString();
                    return 0;
                case 11:
                    aey.title = aVar3.vHC.readString();
                    return 0;
                case 12:
                    aey.huX = aVar3.vHC.readString();
                    return 0;
                case 13:
                    aey.huY = aVar3.vHC.readString();
                    return 0;
                case 14:
                    aey.hwh = aVar3.vHC.readString();
                    return 0;
                case 15:
                    aey.huW = aVar3.vHC.readString();
                    return 0;
                case 16:
                    aey.dxh = aVar3.vHC.readString();
                    return 0;
                case 17:
                    aey.mXn = aVar3.vHC.rY();
                    return 0;
                case 18:
                    aey.mXo = aVar3.vHC.readString();
                    return 0;
                case 19:
                    aey.mXp = aVar3.vHC.readString();
                    return 0;
                case 20:
                    aey.mXq = aVar3.vHC.readString();
                    return 0;
                case 21:
                    aey.end_time = aVar3.vHC.rY();
                    return 0;
                case 22:
                    aey.mXs = aVar3.vHC.readString();
                    return 0;
                case 23:
                    aey.rIV = aVar3.vHC.readString();
                    return 0;
                case 24:
                    aey.mXt = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
