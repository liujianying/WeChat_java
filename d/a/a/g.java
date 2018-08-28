package d.a.a;

import com.tencent.mm.bk.a;

public final class g extends a {
    public String lRX;
    public String vHo;
    public String vHp;
    public String vHq;
    public String vHr;
    public String vHs;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.lRX != null) {
                aVar.g(1, this.lRX);
            }
            if (this.vHo != null) {
                aVar.g(2, this.vHo);
            }
            if (this.vHp != null) {
                aVar.g(3, this.vHp);
            }
            if (this.vHq != null) {
                aVar.g(4, this.vHq);
            }
            if (this.vHr != null) {
                aVar.g(5, this.vHr);
            }
            if (this.vHs == null) {
                return 0;
            }
            aVar.g(6, this.vHs);
            return 0;
        } else if (i == 1) {
            if (this.lRX != null) {
                h = f.a.a.b.b.a.h(1, this.lRX) + 0;
            } else {
                h = 0;
            }
            if (this.vHo != null) {
                h += f.a.a.b.b.a.h(2, this.vHo);
            }
            if (this.vHp != null) {
                h += f.a.a.b.b.a.h(3, this.vHp);
            }
            if (this.vHq != null) {
                h += f.a.a.b.b.a.h(4, this.vHq);
            }
            if (this.vHr != null) {
                h += f.a.a.b.b.a.h(5, this.vHr);
            }
            if (this.vHs != null) {
                h += f.a.a.b.b.a.h(6, this.vHs);
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
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.lRX = aVar3.vHC.readString();
                    return 0;
                case 2:
                    gVar.vHo = aVar3.vHC.readString();
                    return 0;
                case 3:
                    gVar.vHp = aVar3.vHC.readString();
                    return 0;
                case 4:
                    gVar.vHq = aVar3.vHC.readString();
                    return 0;
                case 5:
                    gVar.vHr = aVar3.vHC.readString();
                    return 0;
                case 6:
                    gVar.vHs = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
