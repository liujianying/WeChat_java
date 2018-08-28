package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class o extends bhp {
    public String bXu;
    public int hUm = 268513600;
    public String hUn = "请求不成功，请稍候再试";
    public String kRq;
    public String mxM;
    public String qYe;
    public a qYw;
    public String qYx;

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
            aVar.fT(2, this.hUm);
            if (this.hUn != null) {
                aVar.g(3, this.hUn);
            }
            if (this.kRq != null) {
                aVar.g(4, this.kRq);
            }
            if (this.bXu != null) {
                aVar.g(5, this.bXu);
            }
            if (this.mxM != null) {
                aVar.g(7, this.mxM);
            }
            if (this.qYe != null) {
                aVar.g(8, this.qYe);
            }
            if (this.qYw != null) {
                aVar.fV(9, this.qYw.boi());
                this.qYw.a(aVar);
            }
            if (this.qYx == null) {
                return 0;
            }
            aVar.g(10, this.qYx);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.hUm);
            if (this.hUn != null) {
                fS += f.a.a.b.b.a.h(3, this.hUn);
            }
            if (this.kRq != null) {
                fS += f.a.a.b.b.a.h(4, this.kRq);
            }
            if (this.bXu != null) {
                fS += f.a.a.b.b.a.h(5, this.bXu);
            }
            if (this.mxM != null) {
                fS += f.a.a.b.b.a.h(7, this.mxM);
            }
            if (this.qYe != null) {
                fS += f.a.a.b.b.a.h(8, this.qYe);
            }
            if (this.qYw != null) {
                fS += f.a.a.a.fS(9, this.qYw.boi());
            }
            if (this.qYx != null) {
                fS += f.a.a.b.b.a.h(10, this.qYx);
            }
            return fS;
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
            o oVar = (o) objArr[1];
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
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        oVar.six = flVar;
                    }
                    return 0;
                case 2:
                    oVar.hUm = aVar3.vHC.rY();
                    return 0;
                case 3:
                    oVar.hUn = aVar3.vHC.readString();
                    return 0;
                case 4:
                    oVar.kRq = aVar3.vHC.readString();
                    return 0;
                case 5:
                    oVar.bXu = aVar3.vHC.readString();
                    return 0;
                case 7:
                    oVar.mxM = aVar3.vHC.readString();
                    return 0;
                case 8:
                    oVar.qYe = aVar3.vHC.readString();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar5.a(aVar4, aVar5, bhp.a(aVar4))) {
                        }
                        oVar.qYw = aVar5;
                    }
                    return 0;
                case 10:
                    oVar.qYx = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
