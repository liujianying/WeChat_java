package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bte extends a {
    public String bHt;
    public String bJK;
    public String bWr;
    public int bxk;
    public String fuu;
    public String kJG;
    public int offset;
    public int ozm;
    public LinkedList<ps> pKZ = new LinkedList();
    public String pLi;
    public int scene;
    public String sqA;
    public LinkedList<btg> sqB = new LinkedList();
    public int sqC;
    public String sqD;
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.fuu != null) {
                aVar.g(1, this.fuu);
            }
            if (this.bJK != null) {
                aVar.g(2, this.bJK);
            }
            if (this.bWr != null) {
                aVar.g(3, this.bWr);
            }
            aVar.fT(4, this.offset);
            if (this.bHt != null) {
                aVar.g(5, this.bHt);
            }
            aVar.fT(6, this.scene);
            if (this.url != null) {
                aVar.g(7, this.url);
            }
            if (this.kJG != null) {
                aVar.g(8, this.kJG);
            }
            aVar.d(9, 8, this.pKZ);
            if (this.sqA != null) {
                aVar.g(10, this.sqA);
            }
            aVar.d(11, 8, this.sqB);
            aVar.fT(12, this.ozm);
            aVar.fT(13, this.bxk);
            if (this.pLi != null) {
                aVar.g(14, this.pLi);
            }
            aVar.fT(15, this.sqC);
            if (this.sqD == null) {
                return 0;
            }
            aVar.g(16, this.sqD);
            return 0;
        } else if (i == 1) {
            if (this.fuu != null) {
                h = f.a.a.b.b.a.h(1, this.fuu) + 0;
            } else {
                h = 0;
            }
            if (this.bJK != null) {
                h += f.a.a.b.b.a.h(2, this.bJK);
            }
            if (this.bWr != null) {
                h += f.a.a.b.b.a.h(3, this.bWr);
            }
            h += f.a.a.a.fQ(4, this.offset);
            if (this.bHt != null) {
                h += f.a.a.b.b.a.h(5, this.bHt);
            }
            h += f.a.a.a.fQ(6, this.scene);
            if (this.url != null) {
                h += f.a.a.b.b.a.h(7, this.url);
            }
            if (this.kJG != null) {
                h += f.a.a.b.b.a.h(8, this.kJG);
            }
            h += f.a.a.a.c(9, 8, this.pKZ);
            if (this.sqA != null) {
                h += f.a.a.b.b.a.h(10, this.sqA);
            }
            h = ((h + f.a.a.a.c(11, 8, this.sqB)) + f.a.a.a.fQ(12, this.ozm)) + f.a.a.a.fQ(13, this.bxk);
            if (this.pLi != null) {
                h += f.a.a.b.b.a.h(14, this.pLi);
            }
            h += f.a.a.a.fQ(15, this.sqC);
            if (this.sqD != null) {
                h += f.a.a.b.b.a.h(16, this.sqD);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.pKZ.clear();
            this.sqB.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            bte bte = (bte) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bte.fuu = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bte.bJK = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bte.bWr = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bte.offset = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bte.bHt = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bte.scene = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bte.url = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bte.kJG = aVar3.vHC.readString();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ps psVar = new ps();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = psVar.a(aVar4, psVar, a.a(aVar4))) {
                        }
                        bte.pKZ.add(psVar);
                    }
                    return 0;
                case 10:
                    bte.sqA = aVar3.vHC.readString();
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        btg btg = new btg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btg.a(aVar4, btg, a.a(aVar4))) {
                        }
                        bte.sqB.add(btg);
                    }
                    return 0;
                case 12:
                    bte.ozm = aVar3.vHC.rY();
                    return 0;
                case 13:
                    bte.bxk = aVar3.vHC.rY();
                    return 0;
                case 14:
                    bte.pLi = aVar3.vHC.readString();
                    return 0;
                case 15:
                    bte.sqC = aVar3.vHC.rY();
                    return 0;
                case 16:
                    bte.sqD = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
