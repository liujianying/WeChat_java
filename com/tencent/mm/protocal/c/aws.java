package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class aws extends bhd {
    public String eJn;
    public String ksA;
    public int rZT;
    public aw rmQ;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rZT);
            if (this.ksA != null) {
                aVar.g(3, this.ksA);
            }
            if (this.eJn != null) {
                aVar.g(4, this.eJn);
            }
            if (this.rmQ == null) {
                return 0;
            }
            aVar.fV(5, this.rmQ.boi());
            this.rmQ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.rZT);
            if (this.ksA != null) {
                fS += f.a.a.b.b.a.h(3, this.ksA);
            }
            if (this.eJn != null) {
                fS += f.a.a.b.b.a.h(4, this.eJn);
            }
            if (this.rmQ != null) {
                fS += f.a.a.a.fS(5, this.rmQ.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aws aws = (aws) objArr[1];
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
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        aws.shX = fkVar;
                    }
                    return 0;
                case 2:
                    aws.rZT = aVar3.vHC.rY();
                    return 0;
                case 3:
                    aws.ksA = aVar3.vHC.readString();
                    return 0;
                case 4:
                    aws.eJn = aVar3.vHC.readString();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aw awVar = new aw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awVar.a(aVar4, awVar, bhd.a(aVar4))) {
                        }
                        aws.rmQ = awVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
