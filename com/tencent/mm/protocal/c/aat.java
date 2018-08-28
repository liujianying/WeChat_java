package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aat extends bhd {
    public String hFm;
    public String pnl;
    public String rFZ;
    public String rGa;
    public String rki;
    public String ruF;
    public String signature;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ruF == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.rFZ == null) {
                throw new b("Not all required fields were included: group_id");
            } else if (this.pnl == null) {
                throw new b("Not all required fields were included: time_stamp");
            } else if (this.hFm == null) {
                throw new b("Not all required fields were included: nonce_str");
            } else if (this.signature == null) {
                throw new b("Not all required fields were included: signature");
            } else if (this.rki == null) {
                throw new b("Not all required fields were included: from_url");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.ruF != null) {
                    aVar.g(2, this.ruF);
                }
                if (this.rFZ != null) {
                    aVar.g(3, this.rFZ);
                }
                if (this.pnl != null) {
                    aVar.g(4, this.pnl);
                }
                if (this.hFm != null) {
                    aVar.g(5, this.hFm);
                }
                if (this.signature != null) {
                    aVar.g(6, this.signature);
                }
                if (this.rki != null) {
                    aVar.g(7, this.rki);
                }
                if (this.rGa == null) {
                    return 0;
                }
                aVar.g(8, this.rGa);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.ruF != null) {
                fS += f.a.a.b.b.a.h(2, this.ruF);
            }
            if (this.rFZ != null) {
                fS += f.a.a.b.b.a.h(3, this.rFZ);
            }
            if (this.pnl != null) {
                fS += f.a.a.b.b.a.h(4, this.pnl);
            }
            if (this.hFm != null) {
                fS += f.a.a.b.b.a.h(5, this.hFm);
            }
            if (this.signature != null) {
                fS += f.a.a.b.b.a.h(6, this.signature);
            }
            if (this.rki != null) {
                fS += f.a.a.b.b.a.h(7, this.rki);
            }
            if (this.rGa != null) {
                fS += f.a.a.b.b.a.h(8, this.rGa);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.ruF == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.rFZ == null) {
                throw new b("Not all required fields were included: group_id");
            } else if (this.pnl == null) {
                throw new b("Not all required fields were included: time_stamp");
            } else if (this.hFm == null) {
                throw new b("Not all required fields were included: nonce_str");
            } else if (this.signature == null) {
                throw new b("Not all required fields were included: signature");
            } else if (this.rki != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: from_url");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aat aat = (aat) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        aat.shX = fkVar;
                    }
                    return 0;
                case 2:
                    aat.ruF = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aat.rFZ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    aat.pnl = aVar3.vHC.readString();
                    return 0;
                case 5:
                    aat.hFm = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aat.signature = aVar3.vHC.readString();
                    return 0;
                case 7:
                    aat.rki = aVar3.vHC.readString();
                    return 0;
                case 8:
                    aat.rGa = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
