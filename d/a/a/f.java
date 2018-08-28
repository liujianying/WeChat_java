package d.a.a;

import com.tencent.mm.bk.a;

public final class f extends a {
    public String sbY;
    public String sbZ;
    public int sca;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sbY != null) {
                aVar.g(1, this.sbY);
            }
            if (this.sbZ != null) {
                aVar.g(2, this.sbZ);
            }
            aVar.fT(3, this.sca);
            return 0;
        } else if (i == 1) {
            if (this.sbY != null) {
                h = f.a.a.b.b.a.h(1, this.sbY) + 0;
            } else {
                h = 0;
            }
            if (this.sbZ != null) {
                h += f.a.a.b.b.a.h(2, this.sbZ);
            }
            return h + f.a.a.a.fQ(3, this.sca);
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
            f fVar = (f) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fVar.sbY = aVar3.vHC.readString();
                    return 0;
                case 2:
                    fVar.sbZ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    fVar.sca = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
