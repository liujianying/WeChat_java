package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class yb extends a {
    public String bHD;
    public LinkedList<xv> rDS = new LinkedList();
    public LinkedList<yd> rDT = new LinkedList();
    public String rDU;
    public String rDV;
    public LinkedList<yc> rDW = new LinkedList();
    public int rDX;
    public boolean rDY;
    public int type;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD != null) {
                aVar.g(1, this.bHD);
            }
            aVar.fT(2, this.type);
            aVar.d(3, 8, this.rDS);
            aVar.d(4, 8, this.rDT);
            if (this.rDU != null) {
                aVar.g(5, this.rDU);
            }
            if (this.rDV != null) {
                aVar.g(6, this.rDV);
            }
            aVar.d(7, 8, this.rDW);
            aVar.fT(8, this.rDX);
            aVar.av(9, this.rDY);
            return 0;
        } else if (i == 1) {
            if (this.bHD != null) {
                h = f.a.a.b.b.a.h(1, this.bHD) + 0;
            } else {
                h = 0;
            }
            h = ((h + f.a.a.a.fQ(2, this.type)) + f.a.a.a.c(3, 8, this.rDS)) + f.a.a.a.c(4, 8, this.rDT);
            if (this.rDU != null) {
                h += f.a.a.b.b.a.h(5, this.rDU);
            }
            if (this.rDV != null) {
                h += f.a.a.b.b.a.h(6, this.rDV);
            }
            return ((h + f.a.a.a.c(7, 8, this.rDW)) + f.a.a.a.fQ(8, this.rDX)) + (f.a.a.b.b.a.ec(9) + 1);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rDS.clear();
            this.rDT.clear();
            this.rDW.clear();
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
            yb ybVar = (yb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ybVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ybVar.type = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        xv xvVar = new xv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xvVar.a(aVar4, xvVar, a.a(aVar4))) {
                        }
                        ybVar.rDS.add(xvVar);
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        yd ydVar = new yd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ydVar.a(aVar4, ydVar, a.a(aVar4))) {
                        }
                        ybVar.rDT.add(ydVar);
                    }
                    return 0;
                case 5:
                    ybVar.rDU = aVar3.vHC.readString();
                    return 0;
                case 6:
                    ybVar.rDV = aVar3.vHC.readString();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        yc ycVar = new yc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ycVar.a(aVar4, ycVar, a.a(aVar4))) {
                        }
                        ybVar.rDW.add(ycVar);
                    }
                    return 0;
                case 8:
                    ybVar.rDX = aVar3.vHC.rY();
                    return 0;
                case 9:
                    ybVar.rDY = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
