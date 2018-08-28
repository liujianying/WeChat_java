package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class axq extends a {
    public String eup;
    public String fky;
    public String hva;
    public String nickname;
    public String rcw;
    public String saL;
    public String saM;
    public String saN;
    public String saO;
    public String saP;
    public String saQ;
    public axr saR;
    public String saS;
    public int sex;
    public int source;
    public int type;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.eup != null) {
                aVar.g(1, this.eup);
            }
            if (this.nickname != null) {
                aVar.g(2, this.nickname);
            }
            aVar.fT(3, this.type);
            if (this.fky != null) {
                aVar.g(4, this.fky);
            }
            if (this.saL != null) {
                aVar.g(5, this.saL);
            }
            if (this.saM != null) {
                aVar.g(6, this.saM);
            }
            aVar.fT(7, this.source);
            if (this.saN != null) {
                aVar.g(8, this.saN);
            }
            if (this.saO != null) {
                aVar.g(9, this.saO);
            }
            if (this.saP != null) {
                aVar.g(10, this.saP);
            }
            if (this.saQ != null) {
                aVar.g(11, this.saQ);
            }
            if (this.saR != null) {
                aVar.fV(12, this.saR.boi());
                this.saR.a(aVar);
            }
            if (this.rcw != null) {
                aVar.g(13, this.rcw);
            }
            if (this.hva != null) {
                aVar.g(14, this.hva);
            }
            aVar.fT(15, this.sex);
            if (this.saS == null) {
                return 0;
            }
            aVar.g(16, this.saS);
            return 0;
        } else if (i == 1) {
            if (this.eup != null) {
                h = f.a.a.b.b.a.h(1, this.eup) + 0;
            } else {
                h = 0;
            }
            if (this.nickname != null) {
                h += f.a.a.b.b.a.h(2, this.nickname);
            }
            h += f.a.a.a.fQ(3, this.type);
            if (this.fky != null) {
                h += f.a.a.b.b.a.h(4, this.fky);
            }
            if (this.saL != null) {
                h += f.a.a.b.b.a.h(5, this.saL);
            }
            if (this.saM != null) {
                h += f.a.a.b.b.a.h(6, this.saM);
            }
            h += f.a.a.a.fQ(7, this.source);
            if (this.saN != null) {
                h += f.a.a.b.b.a.h(8, this.saN);
            }
            if (this.saO != null) {
                h += f.a.a.b.b.a.h(9, this.saO);
            }
            if (this.saP != null) {
                h += f.a.a.b.b.a.h(10, this.saP);
            }
            if (this.saQ != null) {
                h += f.a.a.b.b.a.h(11, this.saQ);
            }
            if (this.saR != null) {
                h += f.a.a.a.fS(12, this.saR.boi());
            }
            if (this.rcw != null) {
                h += f.a.a.b.b.a.h(13, this.rcw);
            }
            if (this.hva != null) {
                h += f.a.a.b.b.a.h(14, this.hva);
            }
            h += f.a.a.a.fQ(15, this.sex);
            if (this.saS != null) {
                h += f.a.a.b.b.a.h(16, this.saS);
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
            axq axq = (axq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    axq.eup = aVar3.vHC.readString();
                    return 0;
                case 2:
                    axq.nickname = aVar3.vHC.readString();
                    return 0;
                case 3:
                    axq.type = aVar3.vHC.rY();
                    return 0;
                case 4:
                    axq.fky = aVar3.vHC.readString();
                    return 0;
                case 5:
                    axq.saL = aVar3.vHC.readString();
                    return 0;
                case 6:
                    axq.saM = aVar3.vHC.readString();
                    return 0;
                case 7:
                    axq.source = aVar3.vHC.rY();
                    return 0;
                case 8:
                    axq.saN = aVar3.vHC.readString();
                    return 0;
                case 9:
                    axq.saO = aVar3.vHC.readString();
                    return 0;
                case 10:
                    axq.saP = aVar3.vHC.readString();
                    return 0;
                case 11:
                    axq.saQ = aVar3.vHC.readString();
                    return 0;
                case 12:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        axr axr = new axr();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = axr.a(aVar4, axr, a.a(aVar4))) {
                        }
                        axq.saR = axr;
                    }
                    return 0;
                case 13:
                    axq.rcw = aVar3.vHC.readString();
                    return 0;
                case 14:
                    axq.hva = aVar3.vHC.readString();
                    return 0;
                case 15:
                    axq.sex = aVar3.vHC.rY();
                    return 0;
                case 16:
                    axq.saS = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
