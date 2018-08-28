package d.a.a;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import java.util.LinkedList;

public final class e extends a {
    public String vHf;
    public String vHg;
    public String vHh;
    public String vHi;
    public String vHj;
    public int vHk;
    public d vHl;
    public b vHm;
    public b vHn;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.vHf != null) {
                aVar.g(1, this.vHf);
            }
            if (this.vHg != null) {
                aVar.g(2, this.vHg);
            }
            if (this.vHh != null) {
                aVar.g(3, this.vHh);
            }
            if (this.vHi != null) {
                aVar.g(4, this.vHi);
            }
            if (this.vHj != null) {
                aVar.g(5, this.vHj);
            }
            aVar.fT(6, this.vHk);
            if (this.vHl != null) {
                aVar.fV(7, this.vHl.boi());
                this.vHl.a(aVar);
            }
            if (this.vHm != null) {
                aVar.b(8, this.vHm);
            }
            if (this.vHn == null) {
                return 0;
            }
            aVar.b(9, this.vHn);
            return 0;
        } else if (i == 1) {
            if (this.vHf != null) {
                h = f.a.a.b.b.a.h(1, this.vHf) + 0;
            } else {
                h = 0;
            }
            if (this.vHg != null) {
                h += f.a.a.b.b.a.h(2, this.vHg);
            }
            if (this.vHh != null) {
                h += f.a.a.b.b.a.h(3, this.vHh);
            }
            if (this.vHi != null) {
                h += f.a.a.b.b.a.h(4, this.vHi);
            }
            if (this.vHj != null) {
                h += f.a.a.b.b.a.h(5, this.vHj);
            }
            h += f.a.a.a.fQ(6, this.vHk);
            if (this.vHl != null) {
                h += f.a.a.a.fS(7, this.vHl.boi());
            }
            if (this.vHm != null) {
                h += f.a.a.a.a(8, this.vHm);
            }
            if (this.vHn != null) {
                h += f.a.a.a.a(9, this.vHn);
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
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.vHf = aVar3.vHC.readString();
                    return 0;
                case 2:
                    eVar.vHg = aVar3.vHC.readString();
                    return 0;
                case 3:
                    eVar.vHh = aVar3.vHC.readString();
                    return 0;
                case 4:
                    eVar.vHi = aVar3.vHC.readString();
                    return 0;
                case 5:
                    eVar.vHj = aVar3.vHC.readString();
                    return 0;
                case 6:
                    eVar.vHk = aVar3.vHC.rY();
                    return 0;
                case 7:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        d dVar = new d();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        eVar.vHl = dVar;
                    }
                    return 0;
                case 8:
                    eVar.vHm = aVar3.cJR();
                    return 0;
                case 9:
                    eVar.vHn = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
