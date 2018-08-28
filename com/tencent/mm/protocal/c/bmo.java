package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bmo extends bhp {
    public bhy rKi;
    public bhy rKj;
    public bhy rKk;
    public float rYk;
    public int rgC;
    public int skL;
    public bhy skM;
    public bhy skN;
    public bhy skO;
    public bhy skP;
    public bhy skQ;
    public int skR;
    public int skS;
    public String skT;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.skM == null) {
                throw new b("Not all required fields were included: SongName");
            } else if (this.skN == null) {
                throw new b("Not all required fields were included: SongSinger");
            } else if (this.rKj == null) {
                throw new b("Not all required fields were included: SongAlbum");
            } else if (this.rKk == null) {
                throw new b("Not all required fields were included: SongAlbumUrl");
            } else if (this.skO == null) {
                throw new b("Not all required fields were included: SongWifiUrl");
            } else if (this.skP == null) {
                throw new b("Not all required fields were included: SongWapLinkUrl");
            } else if (this.skQ == null) {
                throw new b("Not all required fields were included: SongWebUrl");
            } else if (this.rKi == null) {
                throw new b("Not all required fields were included: SongLyric");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                aVar.fT(2, this.rgC);
                aVar.fT(3, this.skL);
                aVar.l(4, this.rYk);
                if (this.skM != null) {
                    aVar.fV(5, this.skM.boi());
                    this.skM.a(aVar);
                }
                if (this.skN != null) {
                    aVar.fV(6, this.skN.boi());
                    this.skN.a(aVar);
                }
                if (this.rKj != null) {
                    aVar.fV(7, this.rKj.boi());
                    this.rKj.a(aVar);
                }
                if (this.rKk != null) {
                    aVar.fV(8, this.rKk.boi());
                    this.rKk.a(aVar);
                }
                if (this.skO != null) {
                    aVar.fV(9, this.skO.boi());
                    this.skO.a(aVar);
                }
                if (this.skP != null) {
                    aVar.fV(10, this.skP.boi());
                    this.skP.a(aVar);
                }
                if (this.skQ != null) {
                    aVar.fV(11, this.skQ.boi());
                    this.skQ.a(aVar);
                }
                if (this.rKi != null) {
                    aVar.fV(12, this.rKi.boi());
                    this.rKi.a(aVar);
                }
                aVar.fT(13, this.skR);
                aVar.fT(14, this.skS);
                if (this.skT == null) {
                    return 0;
                }
                aVar.g(15, this.skT);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((fS + f.a.a.a.fQ(2, this.rgC)) + f.a.a.a.fQ(3, this.skL)) + (f.a.a.b.b.a.ec(4) + 4);
            if (this.skM != null) {
                fS += f.a.a.a.fS(5, this.skM.boi());
            }
            if (this.skN != null) {
                fS += f.a.a.a.fS(6, this.skN.boi());
            }
            if (this.rKj != null) {
                fS += f.a.a.a.fS(7, this.rKj.boi());
            }
            if (this.rKk != null) {
                fS += f.a.a.a.fS(8, this.rKk.boi());
            }
            if (this.skO != null) {
                fS += f.a.a.a.fS(9, this.skO.boi());
            }
            if (this.skP != null) {
                fS += f.a.a.a.fS(10, this.skP.boi());
            }
            if (this.skQ != null) {
                fS += f.a.a.a.fS(11, this.skQ.boi());
            }
            if (this.rKi != null) {
                fS += f.a.a.a.fS(12, this.rKi.boi());
            }
            fS = (fS + f.a.a.a.fQ(13, this.skR)) + f.a.a.a.fQ(14, this.skS);
            if (this.skT != null) {
                fS += f.a.a.b.b.a.h(15, this.skT);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.skM == null) {
                throw new b("Not all required fields were included: SongName");
            } else if (this.skN == null) {
                throw new b("Not all required fields were included: SongSinger");
            } else if (this.rKj == null) {
                throw new b("Not all required fields were included: SongAlbum");
            } else if (this.rKk == null) {
                throw new b("Not all required fields were included: SongAlbumUrl");
            } else if (this.skO == null) {
                throw new b("Not all required fields were included: SongWifiUrl");
            } else if (this.skP == null) {
                throw new b("Not all required fields were included: SongWapLinkUrl");
            } else if (this.skQ == null) {
                throw new b("Not all required fields were included: SongWebUrl");
            } else if (this.rKi != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SongLyric");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bmo bmo = (bmo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            bhy bhy;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        bmo.six = flVar;
                    }
                    return 0;
                case 2:
                    bmo.rgC = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bmo.skL = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bmo.rYk = aVar3.vHC.readFloat();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bmo.skM = bhy;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bmo.skN = bhy;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bmo.rKj = bhy;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bmo.rKk = bhy;
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bmo.skO = bhy;
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bmo.skP = bhy;
                    }
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bmo.skQ = bhy;
                    }
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bmo.rKi = bhy;
                    }
                    return 0;
                case 13:
                    bmo.skR = aVar3.vHC.rY();
                    return 0;
                case 14:
                    bmo.skS = aVar3.vHC.rY();
                    return 0;
                case 15:
                    bmo.skT = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
