package d.a.a;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class b extends a {
    public int srY;
    public String url;
    public f vGU;
    public String vGV;
    public String vGW;
    public String vGX;
    public String vGY;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.vGU != null) {
                aVar.fV(1, this.vGU.boi());
                this.vGU.a(aVar);
            }
            if (this.url != null) {
                aVar.g(2, this.url);
            }
            if (this.vGV != null) {
                aVar.g(3, this.vGV);
            }
            if (this.vGW != null) {
                aVar.g(4, this.vGW);
            }
            aVar.fT(5, this.srY);
            if (this.vGX != null) {
                aVar.g(6, this.vGX);
            }
            if (this.vGY == null) {
                return 0;
            }
            aVar.g(7, this.vGY);
            return 0;
        } else if (i == 1) {
            if (this.vGU != null) {
                fS = f.a.a.a.fS(1, this.vGU.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.url != null) {
                fS += f.a.a.b.b.a.h(2, this.url);
            }
            if (this.vGV != null) {
                fS += f.a.a.b.b.a.h(3, this.vGV);
            }
            if (this.vGW != null) {
                fS += f.a.a.b.b.a.h(4, this.vGW);
            }
            fS += f.a.a.a.fQ(5, this.srY);
            if (this.vGX != null) {
                fS += f.a.a.b.b.a.h(6, this.vGX);
            }
            if (this.vGY != null) {
                fS += f.a.a.b.b.a.h(7, this.vGY);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        f fVar = new f();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fVar.a(aVar4, fVar, a.a(aVar4))) {
                        }
                        bVar.vGU = fVar;
                    }
                    return 0;
                case 2:
                    bVar.url = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bVar.vGV = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bVar.vGW = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bVar.srY = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bVar.vGX = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bVar.vGY = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
