package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class ak extends a {
    public String bHD;
    public String jOU;
    public String jPA;
    public int jPC;
    public String jQM;
    public boolean jQN;
    public boolean jQO;
    public String jQP;
    public String jQQ;
    public int jQR;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.jQM == null) {
                throw new b("Not all required fields were included: NavKey");
            } else {
                if (this.bHD != null) {
                    aVar.g(1, this.bHD);
                }
                if (this.jQM != null) {
                    aVar.g(2, this.jQM);
                }
                if (this.jOU != null) {
                    aVar.g(3, this.jOU);
                }
                aVar.av(4, this.jQN);
                aVar.av(5, this.jQO);
                if (this.jQP != null) {
                    aVar.g(6, this.jQP);
                }
                if (this.jQQ != null) {
                    aVar.g(7, this.jQQ);
                }
                aVar.fT(8, this.jQR);
                aVar.fT(9, this.jPC);
                if (this.jPA == null) {
                    return 0;
                }
                aVar.g(10, this.jPA);
                return 0;
            }
        } else if (i == 1) {
            if (this.bHD != null) {
                h = f.a.a.b.b.a.h(1, this.bHD) + 0;
            } else {
                h = 0;
            }
            if (this.jQM != null) {
                h += f.a.a.b.b.a.h(2, this.jQM);
            }
            if (this.jOU != null) {
                h += f.a.a.b.b.a.h(3, this.jOU);
            }
            h = (h + (f.a.a.b.b.a.ec(4) + 1)) + (f.a.a.b.b.a.ec(5) + 1);
            if (this.jQP != null) {
                h += f.a.a.b.b.a.h(6, this.jQP);
            }
            if (this.jQQ != null) {
                h += f.a.a.b.b.a.h(7, this.jQQ);
            }
            h = (h + f.a.a.a.fQ(8, this.jQR)) + f.a.a.a.fQ(9, this.jPC);
            if (this.jPA != null) {
                h += f.a.a.b.b.a.h(10, this.jPA);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.jQM != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NavKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ak akVar = (ak) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    akVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    akVar.jQM = aVar3.vHC.readString();
                    return 0;
                case 3:
                    akVar.jOU = aVar3.vHC.readString();
                    return 0;
                case 4:
                    akVar.jQN = aVar3.cJQ();
                    return 0;
                case 5:
                    akVar.jQO = aVar3.cJQ();
                    return 0;
                case 6:
                    akVar.jQP = aVar3.vHC.readString();
                    return 0;
                case 7:
                    akVar.jQQ = aVar3.vHC.readString();
                    return 0;
                case 8:
                    akVar.jQR = aVar3.vHC.rY();
                    return 0;
                case 9:
                    akVar.jPC = aVar3.vHC.rY();
                    return 0;
                case 10:
                    akVar.jPA = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
