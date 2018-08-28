package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class d extends a {
    public String content;
    public int mce;
    public String mcf;
    public LinkedList<i> mcg = new LinkedList();
    public LinkedList<i> mch = new LinkedList();
    public LinkedList<i> mci = new LinkedList();
    public LinkedList<y> mcj = new LinkedList();
    public String mck;
    public int mcl = 5;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.content == null) {
                throw new b("Not all required fields were included: content");
            }
            aVar.fT(1, this.mce);
            if (this.mcf != null) {
                aVar.g(2, this.mcf);
            }
            aVar.d(3, 8, this.mcg);
            aVar.d(4, 8, this.mch);
            aVar.d(5, 8, this.mci);
            aVar.d(6, 8, this.mcj);
            if (this.mck != null) {
                aVar.g(7, this.mck);
            }
            if (this.content != null) {
                aVar.g(8, this.content);
            }
            aVar.fT(9, this.mcl);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.mce) + 0;
            if (this.mcf != null) {
                fQ += f.a.a.b.b.a.h(2, this.mcf);
            }
            fQ = (((fQ + f.a.a.a.c(3, 8, this.mcg)) + f.a.a.a.c(4, 8, this.mch)) + f.a.a.a.c(5, 8, this.mci)) + f.a.a.a.c(6, 8, this.mcj);
            if (this.mck != null) {
                fQ += f.a.a.b.b.a.h(7, this.mck);
            }
            if (this.content != null) {
                fQ += f.a.a.b.b.a.h(8, this.content);
            }
            return fQ + f.a.a.a.fQ(9, this.mcl);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.mcg.clear();
            this.mch.clear();
            this.mci.clear();
            this.mcj.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.content != null) {
                return 0;
            }
            throw new b("Not all required fields were included: content");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            i iVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dVar.mce = aVar3.vHC.rY();
                    return 0;
                case 2:
                    dVar.mcf = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        iVar = new i();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.mcg.add(iVar);
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        iVar = new i();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.mch.add(iVar);
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        iVar = new i();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        dVar.mci.add(iVar);
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        y yVar = new y();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = yVar.a(aVar4, yVar, a.a(aVar4))) {
                        }
                        dVar.mcj.add(yVar);
                    }
                    return 0;
                case 7:
                    dVar.mck = aVar3.vHC.readString();
                    return 0;
                case 8:
                    dVar.content = aVar3.vHC.readString();
                    return 0;
                case 9:
                    dVar.mcl = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
