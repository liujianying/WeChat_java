package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class anm extends a {
    public String lPj;
    public String lRl;
    public String rFe;
    public String rQh;
    public String rQi;
    public String rQj;
    public String rQk;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.lRl == null) {
                throw new b("Not all required fields were included: product_id");
            } else if (this.lPj == null) {
                throw new b("Not all required fields were included: price");
            } else if (this.rFe == null) {
                throw new b("Not all required fields were included: currency_type");
            } else if (this.rQh == null) {
                throw new b("Not all required fields were included: session_data");
            } else {
                if (this.lRl != null) {
                    aVar.g(1, this.lRl);
                }
                if (this.lPj != null) {
                    aVar.g(2, this.lPj);
                }
                if (this.rFe != null) {
                    aVar.g(3, this.rFe);
                }
                if (this.rQh != null) {
                    aVar.g(4, this.rQh);
                }
                if (this.rQi != null) {
                    aVar.g(5, this.rQi);
                }
                if (this.rQj != null) {
                    aVar.g(6, this.rQj);
                }
                if (this.rQk == null) {
                    return 0;
                }
                aVar.g(7, this.rQk);
                return 0;
            }
        } else if (i == 1) {
            if (this.lRl != null) {
                h = f.a.a.b.b.a.h(1, this.lRl) + 0;
            } else {
                h = 0;
            }
            if (this.lPj != null) {
                h += f.a.a.b.b.a.h(2, this.lPj);
            }
            if (this.rFe != null) {
                h += f.a.a.b.b.a.h(3, this.rFe);
            }
            if (this.rQh != null) {
                h += f.a.a.b.b.a.h(4, this.rQh);
            }
            if (this.rQi != null) {
                h += f.a.a.b.b.a.h(5, this.rQi);
            }
            if (this.rQj != null) {
                h += f.a.a.b.b.a.h(6, this.rQj);
            }
            if (this.rQk != null) {
                h += f.a.a.b.b.a.h(7, this.rQk);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.lRl == null) {
                throw new b("Not all required fields were included: product_id");
            } else if (this.lPj == null) {
                throw new b("Not all required fields were included: price");
            } else if (this.rFe == null) {
                throw new b("Not all required fields were included: currency_type");
            } else if (this.rQh != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: session_data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            anm anm = (anm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    anm.lRl = aVar3.vHC.readString();
                    return 0;
                case 2:
                    anm.lPj = aVar3.vHC.readString();
                    return 0;
                case 3:
                    anm.rFe = aVar3.vHC.readString();
                    return 0;
                case 4:
                    anm.rQh = aVar3.vHC.readString();
                    return 0;
                case 5:
                    anm.rQi = aVar3.vHC.readString();
                    return 0;
                case 6:
                    anm.rQj = aVar3.vHC.readString();
                    return 0;
                case 7:
                    anm.rQk = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
