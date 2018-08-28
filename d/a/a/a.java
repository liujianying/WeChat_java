package d.a.a;

import java.util.LinkedList;

public final class a extends com.tencent.mm.bk.a {
    public String rJm;
    public String url;
    public String vGR;
    public String vGS;
    public int vGT;
    public f vGU;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.vGR != null) {
                aVar.g(1, this.vGR);
            }
            if (this.vGS != null) {
                aVar.g(2, this.vGS);
            }
            aVar.fT(3, this.vGT);
            if (this.url != null) {
                aVar.g(4, this.url);
            }
            if (this.vGU != null) {
                aVar.fV(5, this.vGU.boi());
                this.vGU.a(aVar);
            }
            if (this.rJm == null) {
                return 0;
            }
            aVar.g(6, this.rJm);
            return 0;
        } else if (i == 1) {
            if (this.vGR != null) {
                h = f.a.a.b.b.a.h(1, this.vGR) + 0;
            } else {
                h = 0;
            }
            if (this.vGS != null) {
                h += f.a.a.b.b.a.h(2, this.vGS);
            }
            h += f.a.a.a.fQ(3, this.vGT);
            if (this.url != null) {
                h += f.a.a.b.b.a.h(4, this.url);
            }
            if (this.vGU != null) {
                h += f.a.a.a.fS(5, this.vGU.boi());
            }
            if (this.rJm != null) {
                h += f.a.a.b.b.a.h(6, this.rJm);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = com.tencent.mm.bk.a.a(aVar2); h > 0; h = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aVar4.vGR = aVar3.vHC.readString();
                    return 0;
                case 2:
                    aVar4.vGS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aVar4.vGT = aVar3.vHC.rY();
                    return 0;
                case 4:
                    aVar4.url = aVar3.vHC.readString();
                    return 0;
                case 5:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        f fVar = new f();
                        f.a.a.a.a aVar5 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fVar.a(aVar5, fVar, com.tencent.mm.bk.a.a(aVar5))) {
                        }
                        aVar4.vGU = fVar;
                    }
                    return 0;
                case 6:
                    aVar4.rJm = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
