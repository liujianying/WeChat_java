package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bzh extends bhd {
    public int rth;
    public long see;
    public int sef;
    public String svt;
    public b svu;
    public b svv;
    public String svw;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.svt == null) {
                throw new f.a.a.b("Not all required fields were included: ToBizUserName");
            } else if (this.svv == null) {
                throw new f.a.a.b("Not all required fields were included: CapInfo");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                aVar.fT(2, this.sef);
                if (this.svt != null) {
                    aVar.g(3, this.svt);
                }
                aVar.fT(4, this.rth);
                if (this.svu != null) {
                    aVar.b(5, this.svu);
                }
                if (this.svv != null) {
                    aVar.b(6, this.svv);
                }
                aVar.T(7, this.see);
                if (this.svw == null) {
                    return 0;
                }
                aVar.g(8, this.svw);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.sef);
            if (this.svt != null) {
                fS += f.a.a.b.b.a.h(3, this.svt);
            }
            fS += f.a.a.a.fQ(4, this.rth);
            if (this.svu != null) {
                fS += f.a.a.a.a(5, this.svu);
            }
            if (this.svv != null) {
                fS += f.a.a.a.a(6, this.svv);
            }
            fS += f.a.a.a.S(7, this.see);
            if (this.svw != null) {
                fS += f.a.a.b.b.a.h(8, this.svw);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.svt == null) {
                throw new f.a.a.b("Not all required fields were included: ToBizUserName");
            } else if (this.svv != null) {
                return 0;
            } else {
                throw new f.a.a.b("Not all required fields were included: CapInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bzh bzh = (bzh) objArr[1];
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
                        bzh.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bzh.sef = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bzh.svt = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bzh.rth = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bzh.svu = aVar3.cJR();
                    return 0;
                case 6:
                    bzh.svv = aVar3.cJR();
                    return 0;
                case 7:
                    bzh.see = aVar3.vHC.rZ();
                    return 0;
                case 8:
                    bzh.svw = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
