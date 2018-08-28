package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class za extends bhd {
    public String bPS;
    public int count;
    public String desc;
    public int rFc;
    public int rFd;
    public String rFe;
    public String rFf;
    public String rFg;
    public int scene;
    public String sign;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.bPS == null) {
                throw new b("Not all required fields were included: appid");
            } else if (this.rFf == null) {
                throw new b("Not all required fields were included: busi_id");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                aVar.fT(2, this.rFc);
                if (this.bPS != null) {
                    aVar.g(3, this.bPS);
                }
                if (this.desc != null) {
                    aVar.g(4, this.desc);
                }
                aVar.fT(5, this.rFd);
                if (this.rFe != null) {
                    aVar.g(6, this.rFe);
                }
                aVar.fT(7, this.count);
                aVar.fT(8, this.scene);
                if (this.rFf != null) {
                    aVar.g(9, this.rFf);
                }
                if (this.sign != null) {
                    aVar.g(10, this.sign);
                }
                if (this.rFg == null) {
                    return 0;
                }
                aVar.g(11, this.rFg);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.rFc);
            if (this.bPS != null) {
                fS += f.a.a.b.b.a.h(3, this.bPS);
            }
            if (this.desc != null) {
                fS += f.a.a.b.b.a.h(4, this.desc);
            }
            fS += f.a.a.a.fQ(5, this.rFd);
            if (this.rFe != null) {
                fS += f.a.a.b.b.a.h(6, this.rFe);
            }
            fS = (fS + f.a.a.a.fQ(7, this.count)) + f.a.a.a.fQ(8, this.scene);
            if (this.rFf != null) {
                fS += f.a.a.b.b.a.h(9, this.rFf);
            }
            if (this.sign != null) {
                fS += f.a.a.b.b.a.h(10, this.sign);
            }
            if (this.rFg != null) {
                fS += f.a.a.b.b.a.h(11, this.rFg);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.bPS == null) {
                throw new b("Not all required fields were included: appid");
            } else if (this.rFf != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: busi_id");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            za zaVar = (za) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        zaVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    zaVar.rFc = aVar3.vHC.rY();
                    return 0;
                case 3:
                    zaVar.bPS = aVar3.vHC.readString();
                    return 0;
                case 4:
                    zaVar.desc = aVar3.vHC.readString();
                    return 0;
                case 5:
                    zaVar.rFd = aVar3.vHC.rY();
                    return 0;
                case 6:
                    zaVar.rFe = aVar3.vHC.readString();
                    return 0;
                case 7:
                    zaVar.count = aVar3.vHC.rY();
                    return 0;
                case 8:
                    zaVar.scene = aVar3.vHC.rY();
                    return 0;
                case 9:
                    zaVar.rFf = aVar3.vHC.readString();
                    return 0;
                case 10:
                    zaVar.sign = aVar3.vHC.readString();
                    return 0;
                case 11:
                    zaVar.rFg = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
