package com.tencent.mm.plugin.masssend.a;

import android.content.ContentValues;
import com.tencent.mm.a.g;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.asz;
import com.tencent.mm.protocal.c.ata;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import junit.framework.Assert;

public final class f extends l implements k {
    boolean dJO;
    private int dTO;
    a dYW;
    public b diG;
    private e diJ;
    int enO;
    private a lar;
    int retCode;

    public f(a aVar, boolean z) {
        this(aVar, z, 0);
    }

    public f(a aVar, boolean z, int i) {
        int i2 = 1;
        this.lar = null;
        this.dYW = null;
        this.retCode = 0;
        this.enO = 0;
        this.dJO = false;
        this.lar = aVar;
        this.dTO = i;
        aVar.createTime = bi.VF();
        if (aVar.msgType == 43) {
            aVar.status = 104;
            o.Ta();
            aVar.lan = s.nM(s.nL(aVar.bch()));
            o.Ta();
            aVar.bxj = s.nM(s.nK(aVar.bch()));
            this.enO = 2500;
            if (aVar.videoSource == 2) {
                this.enO = 2500;
            }
        } else if (aVar.msgType == 34) {
            this.enO = 40;
            aVar.status = 104;
            aVar.bxj = com.tencent.mm.modelvoice.o.nM(aVar.bch());
            aVar.lan = 0;
        } else if (aVar.msgType == 3) {
            int i3;
            this.enO = 40;
            if (i == 1) {
                this.enO = 1250;
                i3 = 1;
            } else {
                i3 = 0;
            }
            aVar.lao = i3;
            aVar.status = 104;
            aVar.lan = 0;
            StringBuilder stringBuilder = new StringBuilder();
            au.HU();
            aVar.bxj = com.tencent.mm.a.e.cm(stringBuilder.append(c.Gb()).append(aVar.bch()).toString());
        } else if (aVar.msgType == 1) {
            this.enO = 1;
            aVar.status = 104;
            aVar.bxj = aVar.bch().getBytes().length;
            aVar.lan = 0;
        } else {
            x.d("MicroMsg.NetSceneMasSend", "error msgtype:" + aVar.msgType);
            Assert.assertTrue("error msgtype:" + aVar.msgType, false);
        }
        b.a aVar2 = new b.a();
        aVar2.dIG = new asz();
        aVar2.dIH = new ata();
        aVar2.uri = "/cgi-bin/micromsg-bin/masssend";
        aVar2.dIF = 193;
        aVar2.dII = 84;
        aVar2.dIJ = 1000000084;
        this.diG = aVar2.KT();
        asz asz = (asz) this.diG.dID.dIL;
        asz.rVj = g.u(aVar.bcj().getBytes());
        asz.rVu = aVar.lak;
        asz.rVi = aVar.bcj();
        aVar.ehf = bi.VF();
        asz.rVk = aVar.bcg();
        asz.jQd = aVar.msgType;
        asz.rVl = aVar.lal;
        if (!z) {
            i2 = 0;
        }
        asz.rVv = i2;
        asz.rJr = i;
        this.dYW = new a();
    }

    public final void cancel() {
        this.dJO = true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 2;
        int i2 = 0;
        this.diJ = eVar2;
        if (this.dJO) {
            x.d("MicroMsg.NetSceneMasSend", "isCancel");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        }
        this.enO--;
        if (this.enO < 0) {
            x.d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (this.lar == null) {
            x.d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (bi.oW(this.lar.bcj())) {
            x.d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (this.lar.lak == 0) {
            x.d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (this.lar.bxj <= 0) {
            x.d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (this.lar.status == 103 && this.lar.lan <= 0) {
            x.d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (this.lar.status == 103 || this.lar.status == 104) {
            asz asz = (asz) this.diG.dID.dIL;
            String bch;
            if (this.lar.msgType == 43) {
                int i3;
                bch = this.lar.bch();
                if (bi.oW(bch)) {
                    x.d("MicroMsg.NetSceneMasSend", "MasSendInfo.fileName is null");
                    this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                    i3 = -1;
                } else {
                    asz.rVm = new bhy();
                    asz.rVn = 0;
                    asz.rVr = new bhy();
                    asz.rVq = 0;
                    asz.rVs = 2;
                    asz.rVl = this.lar.lal;
                    if (this.lar.videoSource <= 0) {
                        i = 0;
                    }
                    asz.rVt = i;
                    asz.rVp = this.lar.lan;
                    asz.rVo = this.lar.bxj;
                    s.b k;
                    Object obj;
                    bhy bhy;
                    if (this.lar.status == 103) {
                        o.Ta();
                        k = s.k(s.nL(bch), this.lar.enI, 8000);
                        if (k.ret < 0 || k.bEG == 0) {
                            x.e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + bch + "]  Error ");
                            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                            i3 = -1;
                        } else {
                            x.d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + bch + "] read ret:" + k.ret + " readlen:" + k.bEG + " newOff:" + k.eon + " netOff:" + this.lar.enI);
                            if (k.eon < this.lar.enI) {
                                x.e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + bch + "] newOff:" + k.eon + " OldtOff:" + this.lar.enI);
                                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                                i3 = -1;
                            } else {
                                obj = new byte[k.bEG];
                                System.arraycopy(k.buf, 0, obj, 0, k.bEG);
                                asz.rVq = this.lar.enI;
                                bhy = new bhy();
                                bhy.bq(obj);
                                asz.rVr = bhy;
                            }
                        }
                    } else {
                        o.Ta();
                        k = s.k(s.nK(bch), this.lar.lam, 8000);
                        if (k.ret < 0 || k.bEG == 0) {
                            x.e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + bch + "]  Error ");
                            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                            i3 = -1;
                        } else {
                            x.d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + bch + "] read ret:" + k.ret + " readlen:" + k.bEG + " newOff:" + k.eon + " netOff:" + this.lar.lam);
                            if (k.eon < this.lar.lam) {
                                x.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + bch + "] newOff:" + k.eon + " OldtOff:" + this.lar.lam);
                                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                                i3 = -1;
                            } else if (k.eon >= com.tencent.mm.modelvideo.c.els) {
                                x.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + bch + "] maxsize:" + com.tencent.mm.modelvideo.c.els);
                                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                                i3 = -1;
                            } else {
                                obj = new byte[k.bEG];
                                System.arraycopy(k.buf, 0, obj, 0, k.bEG);
                                asz.rVn = this.lar.lam;
                                asz.rVq = this.lar.enI;
                                bhy = new bhy();
                                bhy.bq(obj);
                                asz.rVm = bhy;
                            }
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    return i3;
                }
            } else if (this.lar.msgType == 34) {
                asz.rVs = 0;
                asz.rVt = 0;
                asz.rVm = new bhy().bq(new byte[0]);
                asz.rVn = 0;
                asz.rVr = new bhy().bq(new byte[0]);
                asz.rVq = 0;
                asz.rVp = 0;
                asz.rVo = this.lar.bxj;
                com.tencent.mm.modelvoice.b ok = q.ok(this.lar.bch());
                if (ok == null) {
                    this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                    x.d("MicroMsg.NetSceneMasSend", "fileop is null");
                    i2 = -1;
                } else {
                    com.tencent.mm.modelvoice.g br = ok.br(this.lar.lam, 8000);
                    if (br.ret < 0) {
                        x.e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.lar.bch() + "] read ret:" + br.ret + " readlen:" + br.bEG + " newOff:" + br.eon + " netOff:" + this.lar.lam);
                        this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                        i2 = -1;
                    } else if (br.eon < this.lar.lam || br.eon >= 469000) {
                        x.e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.lar.bch() + "] read ret:" + br.ret + " readlen:" + br.bEG + " newOff:" + br.eon + " netOff:" + this.lar.lam);
                        this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                        i2 = -1;
                    } else if (this.lar.bxj <= 0) {
                        x.e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.lar.bch() + "] read totalLen:" + this.lar.bxj);
                        this.retCode = com.tencent.mm.compatible.util.g.getLine() + 10000;
                        i2 = -1;
                    } else {
                        Object obj2 = new byte[br.bEG];
                        System.arraycopy(br.buf, 0, obj2, 0, br.bEG);
                        asz.rVm = new bhy().bq(obj2);
                        asz.rVl = this.lar.lal;
                        asz.rVn = this.lar.lam;
                        asz.rVw = ok.getFormat();
                    }
                }
                if (i2 != 0) {
                    return -1;
                }
            } else if (this.lar.msgType == 3) {
                if (bi.oW(this.lar.bch())) {
                    x.d("MicroMsg.NetSceneMasSend", "getFilename is null");
                    this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                    i2 = -1;
                } else {
                    asz.rVs = 0;
                    asz.rVt = 0;
                    asz.rVm = new bhy().bq(new byte[0]);
                    asz.rVn = 0;
                    asz.rVr = new bhy().bq(new byte[0]);
                    asz.rVq = 0;
                    asz.rVp = 0;
                    asz.rVl = 0;
                    asz.rVp = this.lar.lan;
                    asz.rVo = this.lar.bxj;
                    asz.rJr = this.dTO;
                    StringBuilder stringBuilder = new StringBuilder();
                    au.HU();
                    bch = stringBuilder.append(c.Gb()).append(this.lar.bch()).toString();
                    i = this.lar.bxj - this.lar.lam;
                    if (i > 8000) {
                        i = 8000;
                    }
                    byte[] e = com.tencent.mm.a.e.e(bch, this.lar.lam, i);
                    if (bi.bC(e)) {
                        x.e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.lar.bch() + "]  Error ");
                        this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                        i2 = -1;
                    } else {
                        asz.rVn = this.lar.lam;
                        asz.rVq = this.lar.enI;
                        bhy bhy2 = new bhy();
                        bhy2.bq(e);
                        asz.rVm = bhy2;
                    }
                }
                if (i2 != 0) {
                    return -1;
                }
            } else if (this.lar.msgType == 1) {
                asz.rVm = new bhy().bq(this.lar.bch().getBytes());
                asz.rVo = this.lar.bxj;
                asz.rVl = 0;
                asz.rVn = 0;
                asz.rVr = new bhy().bq(new byte[0]);
                asz.rVq = 0;
                asz.rVp = 0;
                asz.rVs = 0;
                asz.rVt = 0;
            } else {
                x.d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.lar.msgType);
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            }
            return a(eVar, this.diG, this);
        } else {
            x.d("MicroMsg.NetSceneMasSend", "msg type :" + this.lar.msgType);
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        }
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        return 2500;
    }

    protected final void a(l.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneMasSend", "onGYNetEnd  errtype:" + i2 + " errCode:" + i3);
        if (i2 != 0 || i3 != 0) {
            x.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd FAILED errtype:" + i2 + " errCode:" + i3);
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            this.diJ.a(i2, i3, str, this);
        } else if (this.lar == null) {
            x.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            this.diJ.a(i2, i3, str, this);
        } else if (this.lar.status == 104 || this.lar.status == 103) {
            ata ata = (ata) this.diG.dIE.dIL;
            asz asz = (asz) this.diG.dID.dIL;
            if (asz.rVp > 0 && asz.rVr != null && asz.rVr.siK != null && !bi.bC(asz.rVr.siK.toByteArray()) && asz.rVq != ata.rVq - asz.rVr.siI) {
                x.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                this.diJ.a(3, -1, "doScene failed", this);
            } else if (asz.rVo <= 0 || asz.rVm == null || asz.rVm.siK == null || bi.bC(asz.rVm.siK.toByteArray()) || asz.rVn == ata.rVn - asz.rVm.siI) {
                this.lar.enK = bi.VE();
                int i4 = this.lar.status;
                if (i4 == 103) {
                    this.lar.enI = asz.rVr.siI + asz.rVq;
                    if (this.lar.enI >= this.lar.lan) {
                        this.lar.status = 199;
                    }
                } else if (i4 == 104) {
                    this.lar.lam = asz.rVm.siI + asz.rVn;
                    if (this.lar.lam >= this.lar.bxj) {
                        if (this.lar.lan > 0) {
                            this.lar.status = 103;
                        } else {
                            this.lar.status = 199;
                        }
                    }
                } else {
                    x.e("MicroMsg.NetSceneMasSend", "onGYNetEnd ERROR STATUS:" + i4);
                    this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                    this.diJ.a(3, -1, "doScene failed", this);
                    return;
                }
                if (this.lar.status == 199) {
                    b bco = h.bco();
                    a aVar = this.lar;
                    if (aVar != null) {
                        aVar.bWA = -1;
                        ContentValues contentValues = new ContentValues();
                        if ((aVar.bWA & 1) != 0) {
                            contentValues.put("clientid", aVar.bcg());
                        }
                        if ((aVar.bWA & 2) != 0) {
                            contentValues.put("status", Integer.valueOf(aVar.status));
                        }
                        if ((aVar.bWA & 4) != 0) {
                            contentValues.put("createtime", Long.valueOf(aVar.createTime));
                        }
                        if ((aVar.bWA & 8) != 0) {
                            contentValues.put("lastmodifytime", Long.valueOf(aVar.enK));
                        }
                        if ((aVar.bWA & 16) != 0) {
                            contentValues.put("filename", aVar.bch());
                        }
                        if ((aVar.bWA & 32) != 0) {
                            contentValues.put("thumbfilename", aVar.bci());
                        }
                        if ((aVar.bWA & 64) != 0) {
                            contentValues.put("tolist", aVar.bcj());
                        }
                        if ((aVar.bWA & 128) != 0) {
                            contentValues.put("tolistcount", Integer.valueOf(aVar.lak));
                        }
                        if ((aVar.bWA & 256) != 0) {
                            contentValues.put("msgtype", Integer.valueOf(aVar.msgType));
                        }
                        if ((aVar.bWA & 512) != 0) {
                            contentValues.put("mediatime", Integer.valueOf(aVar.lal));
                        }
                        if ((aVar.bWA & 1024) != 0) {
                            contentValues.put("datanetoffset", Integer.valueOf(aVar.lam));
                        }
                        if ((aVar.bWA & 2048) != 0) {
                            contentValues.put("datalen", Integer.valueOf(aVar.bxj));
                        }
                        if ((aVar.bWA & Downloads.RECV_BUFFER_SIZE) != 0) {
                            contentValues.put("thumbnetoffset", Integer.valueOf(aVar.enI));
                        }
                        if ((aVar.bWA & 8192) != 0) {
                            contentValues.put("thumbtotallen", Integer.valueOf(aVar.lan));
                        }
                        if ((aVar.bWA & 16384) != 0) {
                            contentValues.put("reserved1", Integer.valueOf(aVar.videoSource));
                        }
                        if ((aVar.bWA & 32768) != 0) {
                            contentValues.put("reserved2", Integer.valueOf(aVar.lao));
                        }
                        if ((aVar.bWA & 65536) != 0) {
                            contentValues.put("reserved3", aVar.dCX == null ? "" : aVar.dCX);
                        }
                        if ((aVar.bWA & 131072) != 0) {
                            contentValues.put("reserved4", aVar.dCY == null ? "" : aVar.dCY);
                        }
                        if (((int) bco.dCZ.insert("massendinfo", "clientid", contentValues)) != -1) {
                            au.HU();
                            Object obj = c.FW().Yq("masssendapp") == null ? 1 : null;
                            ai aiVar = new ai();
                            aiVar.setUsername("masssendapp");
                            aiVar.setContent(b.a(aVar));
                            aiVar.as(aVar.createTime);
                            aiVar.eX(0);
                            aiVar.eV(0);
                            if (obj != null) {
                                au.HU();
                                c.FW().d(aiVar);
                            } else {
                                au.HU();
                                c.FW().a(aiVar, "masssendapp");
                            }
                            bco.doNotify();
                        }
                    }
                    x.d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:" + (this.dYW != null ? this.dYW.Ad() : 0));
                    this.diJ.a(i2, i3, str, this);
                } else if (a(this.dIX, this.diJ) == -1) {
                    this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                    this.diJ.a(3, -1, "doScene failed", this);
                }
            } else {
                x.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                this.diJ.a(3, -1, "doScene failed", this);
            }
        } else {
            x.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.lar.status);
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 193;
    }
}
