package d.a.a;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class d extends a {
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
            if (this.rJm != null) {
                aVar.g(4, this.rJm);
            }
            if (this.url != null) {
                aVar.g(5, this.url);
            }
            if (this.vGU == null) {
                return 0;
            }
            aVar.fV(6, this.vGU.boi());
            this.vGU.a(aVar);
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
            if (this.rJm != null) {
                h += f.a.a.b.b.a.h(4, this.rJm);
            }
            if (this.url != null) {
                h += f.a.a.b.b.a.h(5, this.url);
            }
            if (this.vGU != null) {
                h += f.a.a.a.fS(6, this.vGU.boi());
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
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dVar.vGR = aVar3.vHC.readString();
                    return 0;
                case 2:
                    dVar.vGS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    dVar.vGT = aVar3.vHC.rY();
                    return 0;
                case 4:
                    dVar.rJm = aVar3.vHC.readString();
                    return 0;
                case 5:
                    dVar.url = aVar3.vHC.readString();
                    return 0;
                case 6:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        f fVar = new f();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fVar.a(aVar4, fVar, a.a(aVar4))) {
                        }
                        dVar.vGU = fVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
