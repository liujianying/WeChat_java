package com.tencent.mm.ak;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelstat.h;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.afj;
import com.tencent.mm.protocal.c.afk;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.io.File;
import java.util.Map;
import junit.framework.Assert;

public final class k extends l implements com.tencent.mm.network.k {
    String TAG;
    bd bGS;
    private long bJC;
    int dHI;
    private int dTO;
    final f dVg;
    public final long dVh;
    private int dVi;
    private h dVj;
    String dVk;
    int dVl;
    private String dVm;
    public String dVn;
    int dVo;
    public boolean dVp;
    private int dVq;
    private String dVr;
    private int dVs;
    boolean dVt;
    private i$a dVu;
    private final b diG;
    e diJ;
    long dlN;
    private int startOffset;
    long startTime;
    private int token;

    public k(long j, long j2, int i, f fVar) {
        this(j, j2, i, fVar, -1);
    }

    public k(long j, long j2, int i, f fVar, int i2) {
        e b;
        this.TAG = "MicroMsg.NetSceneGetMsgImg";
        this.dVj = null;
        this.bJC = -1;
        this.bGS = null;
        this.dVk = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.dVl = 0;
        this.dVm = "";
        this.dVn = "";
        this.dHI = 0;
        this.dVo = -1;
        this.dVp = false;
        this.dVq = -1;
        this.dVr = null;
        this.dVs = 0;
        this.token = -1;
        this.dVt = false;
        this.dVu = new 2(this);
        boolean z = j >= 0 && j2 >= 0 && fVar != null;
        Assert.assertTrue(z);
        this.dVg = fVar;
        this.dTO = i;
        this.dVh = j;
        this.dlN = j;
        this.bJC = j2;
        this.dVq = i2;
        e b2 = o.Pf().b(Long.valueOf(this.dlN));
        if (i == 1) {
            this.dlN = (long) b2.dTU;
            b = o.Pf().b(Long.valueOf(this.dlN));
        } else {
            b = b2;
        }
        this.TAG += "[" + this.dlN + "]";
        a aVar = new a();
        aVar.dIG = new afj();
        aVar.dIH = new afk();
        aVar.uri = "/cgi-bin/micromsg-bin/getmsgimg";
        aVar.dIF = 109;
        aVar.dII = 10;
        aVar.dIJ = 1000000010;
        this.diG = aVar.KT();
        afj afj = (afj) this.diG.dID.dIL;
        this.bGS = ((i) g.l(i.class)).bcY().dW(j2);
        afj.rdW = b.offset;
        afj.rdV = b.dHI;
        x.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", new Object[]{Integer.valueOf(b.offset), Integer.valueOf(b.dHI), bi.cjd()});
        afj.rcq = this.bGS.field_msgSvrId;
        afj.rcj = new bhz().VO(this.bGS.field_talker);
        afj.rck = new bhz().VO((String) g.Ei().DT().get(2, null));
        afj.rJr = i;
        if (b.offset == 0) {
            this.dVj = new h(109, false, (long) b.dHI);
        }
        this.dVi = 8192;
        if (fVar != null) {
            ah.A(new 1(this, fVar, b.offset, b.dHI));
        }
    }

    protected final int Cc() {
        if (this.dTO == 0) {
            return 100;
        }
        return 1280;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    protected final void cancel() {
        if (!(bi.oW(this.dVk) || com.tencent.mm.modelcdntran.g.ND() == null)) {
            x.d(this.TAG, "cancel recv task");
            com.tencent.mm.modelcdntran.g.ND().lx(this.dVk);
        }
        super.cancel();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        afj afj = (afj) this.diG.dID.dIL;
        e b = o.Pf().b(Long.valueOf(this.dlN));
        if (b.dTK == 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(111, 195, 1, false);
            x.e(this.TAG, "doScene id:%d  img:%s", new Object[]{Long.valueOf(this.dlN), b});
            return -1;
        } else if (b.status != 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(111, 194, 1, false);
            x.e(this.TAG, "doSceneError, id:%d, status:%d", new Object[]{Long.valueOf(b.dTK), Integer.valueOf(b.status)});
            return -1;
        } else {
            Object obj;
            if (b.dTL.startsWith("SERVERID://")) {
                this.dVm = com.tencent.mm.a.g.u(b.dTL.getBytes());
                this.dVn = o.Pf().o(this.dVm, null, ".temp");
                b.lH(this.dVm + ".temp");
                o.Pf().a(Long.valueOf(this.dlN), b);
            } else {
                this.dVm = b.dTL;
                this.dVn = o.Pf().o(this.dVm, null, "");
            }
            x.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", new Object[]{Long.valueOf(b.dTK), Integer.valueOf(this.dTO), Integer.valueOf(b.offset), Integer.valueOf(b.dHI), r4, this.dVm, this.dVn});
            if (this.startTime == 0) {
                this.startTime = bi.VF();
                this.startOffset = b.offset;
                this.dVl = this.dTO == 1 ? com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE : com.tencent.mm.modelcdntran.b.MediaType_IMAGE;
            }
            String str = afj.rcj.siM;
            long j = afj.rcq;
            if (bi.oW(b.dTV)) {
                obj = null;
            } else {
                Map z = bl.z(b.dTV, "msg");
                if (z == null) {
                    x.e(this.TAG, "parse cdnInfo failed. [%s]", new Object[]{b.dTV});
                    obj = null;
                } else {
                    String str2;
                    String str3;
                    this.dHI = 0;
                    if (this.dTO != 1) {
                        str = (String) z.get(".msg.img.$cdnmidimgurl");
                        this.dHI = bi.getInt((String) z.get(".msg.img.$length"), 0);
                        str2 = str;
                    } else {
                        str = (String) z.get(".msg.img.$cdnbigimgurl");
                        this.dHI = bi.getInt((String) z.get(".msg.img.$hdlength"), 0);
                        str2 = str;
                    }
                    if (this.dTO != 1) {
                        str = (String) z.get(".msg.img.$tpurl");
                        if (!bi.oW(str)) {
                            this.dHI = bi.getInt((String) z.get(".msg.img.$tplength"), 0);
                            str3 = str;
                        }
                        str3 = str;
                    } else {
                        str = (String) z.get(".msg.img.$tphdurl");
                        if (!bi.oW(str)) {
                            this.dHI = bi.getInt((String) z.get(".msg.img.$tphdlength"), 0);
                        }
                        str3 = str;
                    }
                    x.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s] [%s]", new Object[]{Integer.valueOf(this.dTO), Integer.valueOf(this.dHI), str2, str3});
                    if (bi.oW(str2) && bi.oW(str3)) {
                        x.e(this.TAG, "cdntra get cdnUrlfailed.");
                        obj = null;
                    } else {
                        str = (String) z.get(".msg.img.$aeskey");
                        if (bi.oW(str)) {
                            x.e(this.TAG, "cdntra get aes key failed.");
                            obj = null;
                        } else {
                            this.dVk = d.a("downimg", (long) b.dTR, this.bGS.field_talker, this.bGS.field_msgId);
                            if (bi.oW(this.dVk)) {
                                x.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[]{Long.valueOf(this.dlN)});
                                obj = null;
                            } else {
                                String str4 = (String) z.get(".msg.img.$md5");
                                if (bi.oW(str3) && !bi.oW(str4) && (bi.oW((String) z.get(".msg.img.$cdnbigimgurl")) || this.dTO == 1)) {
                                    com.tencent.mm.plugin.p.b.aWB();
                                    String de = com.tencent.mm.plugin.p.b.FY().de(str4, this.dHI);
                                    int cm = com.tencent.mm.a.e.cm(de);
                                    int i = this.dHI - cm;
                                    String str5 = this.TAG;
                                    String str6 = "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s";
                                    Object[] objArr = new Object[8];
                                    objArr[0] = Integer.valueOf(this.dHI);
                                    objArr[1] = str4;
                                    objArr[2] = z.get(".msg.img.$cdnbigimgurl");
                                    objArr[3] = Boolean.valueOf(this.dTO == 1);
                                    objArr[4] = Integer.valueOf(cm);
                                    objArr[5] = de;
                                    objArr[6] = Integer.valueOf(i);
                                    objArr[7] = this.dVn;
                                    x.i(str5, str6, objArr);
                                    if (bi.oW(de)) {
                                        this.dVr = str4;
                                        this.dVs = this.dHI;
                                    } else if (i >= 0 && i <= 16) {
                                        boolean fN = j.fN(de, this.dVn);
                                        x.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", new Object[]{de, this.dVn, Boolean.valueOf(fN)});
                                        a(b, this.dHI, this.dHI, 0, null);
                                        if (this.bGS != null) {
                                            ((i) g.l(i.class)).bcY().a(new c(this.bGS.field_talker, "update", this.bGS));
                                        }
                                        com.tencent.mm.plugin.report.service.h.mEJ.h(13267, new Object[]{str2, Long.valueOf(this.bGS.field_msgSvrId), str4, Long.valueOf(this.bGS.field_createTime / 1000), this.bGS.field_talker, Integer.valueOf(3), Integer.valueOf(cm)});
                                        obj = 1;
                                    }
                                }
                                com.tencent.mm.modelcdntran.i iVar = new com.tencent.mm.modelcdntran.i();
                                iVar.field_mediaId = this.dVk;
                                iVar.field_fullpath = this.dVn;
                                iVar.field_fileType = this.dVl;
                                iVar.field_totalLen = this.dHI;
                                iVar.field_aesKey = str;
                                iVar.field_fileId = str2;
                                iVar.field_priority = com.tencent.mm.modelcdntran.b.dOk;
                                iVar.dPV = this.dVu;
                                iVar.field_chattype = s.fq(this.bGS.field_talker) ? 1 : 0;
                                if (!bi.oW(str3)) {
                                    str = (String) z.get(".msg.img.$tpauthkey");
                                    iVar.field_fileType = 19;
                                    iVar.field_authKey = str;
                                    iVar.dPW = str3;
                                    iVar.field_fileId = "";
                                }
                                x.i(this.TAG, "cdnautostart %s %b", new Object[]{"image_" + this.bGS.field_msgId, Boolean.valueOf(com.tencent.mm.modelcdntran.g.ND().dPa.contains("image_" + this.bGS.field_msgId))});
                                if (com.tencent.mm.modelcdntran.g.ND().dPa.contains("image_" + this.bGS.field_msgId)) {
                                    com.tencent.mm.modelcdntran.g.ND().dPa.remove("image_" + this.bGS.field_msgId);
                                    iVar.field_autostart = true;
                                } else {
                                    iVar.field_autostart = false;
                                }
                                if (com.tencent.mm.modelcdntran.g.ND().b(iVar, this.dVq)) {
                                    x.d(this.TAG, "add recv task");
                                    obj = 1;
                                } else {
                                    com.tencent.mm.plugin.report.service.h.mEJ.a(111, 196, 1, false);
                                    x.e(this.TAG, "addRecvTask failed :%s", new Object[]{this.dVk});
                                    this.dVk = "";
                                    obj = null;
                                }
                            }
                        }
                    }
                }
            }
            if (obj != null) {
                x.d(this.TAG, "cdntra this img use cdn : %s", new Object[]{this.dVk});
                return 0;
            }
            x.d(this.TAG, "cdntra this img NOT USE CDN: %s", new Object[]{this.dVk});
            b.lK("");
            b.bWA = 4096;
            o.Pf().a(Long.valueOf(this.dlN), b);
            afj.rdW = b.offset;
            afj.rdX = this.dVi;
            afj.rdV = b.dHI;
            if (this.dVj != null) {
                this.dVj.Sa();
            }
            return a(eVar, this.diG, this);
        }
    }

    public final int getType() {
        return 109;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 3 && i3 == -1 && !bi.oW(this.dVk)) {
            x.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[]{this.dVk});
        } else if (i2 == 0 && i3 == 0) {
            afk afk = (afk) ((b) qVar).dIE.dIL;
            e b = o.Pf().b(Long.valueOf(this.dlN));
            Object obj = null;
            if (afk.rdX <= 0) {
                x.e(this.TAG, "flood control, malformed data_len");
                obj = -1;
            } else if (afk.rtW == null || afk.rdX != afk.rtW.siI) {
                x.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
                obj = -1;
            } else if (afk.rdW < 0 || afk.rdW + afk.rdX > afk.rdV) {
                x.e(this.TAG, "flood control, malformed start pos");
                obj = -1;
            } else if (afk.rdW != b.offset) {
                x.e(this.TAG, "flood control, malformed start_pos");
                obj = -1;
            } else if (afk.rdV <= 0) {
                x.e(this.TAG, "flood control, malformed total_len");
                obj = -1;
            }
            if (obj != null) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(111, 192, 1, false);
                com.tencent.mm.plugin.report.service.h.mEJ.h(10420, new Object[]{Integer.valueOf(-1), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.dVl), Integer.valueOf(this.dHI - this.startOffset)});
                this.diJ.a(4, -1, "", this);
                return;
            }
            if (a(b, afk.rdV, afk.rdW, afk.rdX, afk.rtW.siK.lR) && a(this.dIX, this.diJ) < 0) {
                this.diJ.a(3, -1, "", this);
            }
        } else {
            if (i2 == 4) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(111, 193, 1, false);
                com.tencent.mm.plugin.report.service.h.mEJ.h(10420, new Object[]{Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.dVl), Integer.valueOf(this.dHI - this.startOffset)});
            }
            this.diJ.a(i2, i3, str, this);
        }
    }

    private boolean a(e eVar, int i, int i2, int i3, byte[] bArr) {
        String str;
        eVar.hL(i);
        eVar.setOffset(i2 + i3);
        this.dVi = i3;
        if (bArr != null) {
            com.tencent.mm.a.e.e(this.dVn, bArr);
        }
        x.d(this.TAG, "onGYNetEnd : offset = " + eVar.offset + " totalLen = " + eVar.dHI + " stack:[%s]", new Object[]{bi.cjd()});
        if (eVar.OM()) {
            String str2 = this.dVn;
            if (str2 == null || str2.equals("")) {
                str2 = "";
            } else {
                byte[] e = com.tencent.mm.a.e.e(str2, 0, 2);
                if (e == null || e.length < 2) {
                    str2 = "";
                } else {
                    str = ".jpg";
                    byte b = e[0];
                    if (b < (byte) 0) {
                        b += 256;
                    }
                    byte b2 = e[1];
                    if (b2 < (byte) 0) {
                        b2 += 256;
                    }
                    str2 = (b == (byte) 66 && b2 == (byte) 77) ? ".bmp" : (b == (byte) -1 && b2 == (byte) -40) ? ".jpg" : (b == (byte) -119 && b2 == (byte) 80) ? ".png" : (b == (byte) 71 && b2 == (byte) 73) ? ".gif" : str;
                }
            }
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            boolean checkIsImageLegal = MMBitmapFactory.checkIsImageLegal(this.dVn, decodeResultLogger);
            File file = new File(this.dVn);
            if (checkIsImageLegal) {
                str = o.Pf().o(this.dVm, null, str2);
                x.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", new Object[]{str2, this.dVm, this.dVn, str});
                file.renameTo(new File(str));
                eVar.lH(this.dVm + str2);
                eVar.lG(FileOp.mO(str));
                eVar.hP(this.dTO);
                if (o.Pf().a(Long.valueOf(this.dlN), eVar) >= 0) {
                    x.e(this.TAG, "onGYNetEnd : update img fail");
                    this.diJ.a(3, -1, "", this);
                    return false;
                }
                if (this.dVg != null) {
                    ah.A(new 3(this, eVar));
                }
                x.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", new Object[]{Boolean.valueOf(eVar.OM()), this.dVk});
                if (!eVar.OM()) {
                    return true;
                }
                if (bi.oW(this.dVk)) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(10420, new Object[]{Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.dVl), Integer.valueOf(i - this.startOffset)});
                }
                boolean z = false;
                if (this.dVo > 0) {
                    z = o.Pf().a(str, eVar.dTN, this.dVo, 1, this.bGS.cGC, this.bGS.cGD);
                }
                if (z) {
                    eVar.cGG = 1;
                    eVar.dUl = true;
                    ((i) g.l(i.class)).bcY().a(this.bGS.field_msgId, this.bGS);
                }
                o.Pf().a(Long.valueOf(this.dlN), eVar);
                x.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", new Object[]{this.dVn, str, eVar.dTL, this.dVr});
                if (this.dVj != null) {
                    this.dVj.bz((long) eVar.dHI);
                }
                if (!bi.oW(this.dVr) && this.dVs > 0) {
                    com.tencent.mm.plugin.p.b.aWB();
                    com.tencent.mm.plugin.p.b.FY().y(this.dVr, this.dVs, str);
                }
                this.diJ.a(0, 0, "", this);
                return false;
            }
            file.delete();
            if (decodeResultLogger.getDecodeResult() >= 2000) {
                com.tencent.mm.plugin.report.service.h.mEJ.k(12712, KVStatHelper.getKVStatString(this.dVn, 2, decodeResultLogger));
            }
        }
        str = null;
        if (o.Pf().a(Long.valueOf(this.dlN), eVar) >= 0) {
            if (this.dVg != null) {
                ah.A(new 3(this, eVar));
            }
            x.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", new Object[]{Boolean.valueOf(eVar.OM()), this.dVk});
            if (!eVar.OM()) {
                return true;
            }
            if (bi.oW(this.dVk)) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(10420, new Object[]{Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.dVl), Integer.valueOf(i - this.startOffset)});
            }
            boolean z2 = false;
            if (this.dVo > 0) {
                z2 = o.Pf().a(str, eVar.dTN, this.dVo, 1, this.bGS.cGC, this.bGS.cGD);
            }
            if (z2) {
                eVar.cGG = 1;
                eVar.dUl = true;
                ((i) g.l(i.class)).bcY().a(this.bGS.field_msgId, this.bGS);
            }
            o.Pf().a(Long.valueOf(this.dlN), eVar);
            x.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", new Object[]{this.dVn, str, eVar.dTL, this.dVr});
            if (this.dVj != null) {
                this.dVj.bz((long) eVar.dHI);
            }
            if (!bi.oW(this.dVr) && this.dVs > 0) {
                com.tencent.mm.plugin.p.b.aWB();
                com.tencent.mm.plugin.p.b.FY().y(this.dVr, this.dVs, str);
            }
            this.diJ.a(0, 0, "", this);
            return false;
        }
        x.e(this.TAG, "onGYNetEnd : update img fail");
        this.diJ.a(3, -1, "", this);
        return false;
    }
}
