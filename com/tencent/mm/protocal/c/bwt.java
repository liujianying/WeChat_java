package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bwt extends bhd {
    public String jTu;
    public String jTv;
    public int otY;
    public String rsZ;
    public bhy rtW;
    public byo rta;
    public bws rtc;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rta == null) {
                throw new b("Not all required fields were included: VoiceAttr");
            } else if (this.rtc == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.rtW == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.rsZ != null) {
                    aVar.g(2, this.rsZ);
                }
                if (this.rta != null) {
                    aVar.fV(3, this.rta.boi());
                    this.rta.a(aVar);
                }
                if (this.rtc != null) {
                    aVar.fV(4, this.rtc.boi());
                    this.rtc.a(aVar);
                }
                if (this.rtW != null) {
                    aVar.fV(5, this.rtW.boi());
                    this.rtW.a(aVar);
                }
                aVar.fT(6, this.otY);
                if (this.jTv != null) {
                    aVar.g(7, this.jTv);
                }
                if (this.jTu == null) {
                    return 0;
                }
                aVar.g(8, this.jTu);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rsZ != null) {
                fS += f.a.a.b.b.a.h(2, this.rsZ);
            }
            if (this.rta != null) {
                fS += f.a.a.a.fS(3, this.rta.boi());
            }
            if (this.rtc != null) {
                fS += f.a.a.a.fS(4, this.rtc.boi());
            }
            if (this.rtW != null) {
                fS += f.a.a.a.fS(5, this.rtW.boi());
            }
            fS += f.a.a.a.fQ(6, this.otY);
            if (this.jTv != null) {
                fS += f.a.a.b.b.a.h(7, this.jTv);
            }
            if (this.jTu != null) {
                fS += f.a.a.b.b.a.h(8, this.jTu);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rta == null) {
                throw new b("Not all required fields were included: VoiceAttr");
            } else if (this.rtc == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.rtW != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bwt bwt = (bwt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bwt.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bwt.rsZ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byo byo = new byo();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byo.a(aVar4, byo, bhd.a(aVar4))) {
                        }
                        bwt.rta = byo;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bws bws = new bws();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bws.a(aVar4, bws, bhd.a(aVar4))) {
                        }
                        bwt.rtc = bws;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bwt.rtW = bhy;
                    }
                    return 0;
                case 6:
                    bwt.otY = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bwt.jTv = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bwt.jTu = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
