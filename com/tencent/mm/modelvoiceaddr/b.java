package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.o;
import com.tencent.mm.ab.o.4;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoiceaddr.g.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bys;
import com.tencent.mm.protocal.c.byu;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b extends a implements k {
    private e diJ;
    private int djl = TbsListener$ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR;
    private int ehi = 0;
    private boolean eoE = false;
    g eqa;
    private boolean eqb = false;
    private boolean eqc = false;
    private int eqd = 0;
    private bhz eqe = null;
    private String[] eqf = new String[0];
    private int eqg = 3960;
    private ag eqh = new 2(this, g.Em().lnJ.getLooper());
    private String filename = null;
    private int retCode = 0;

    public final void TR() {
        this.eoE = true;
    }

    public final String[] TS() {
        return this.eqf;
    }

    public final long TT() {
        return 0;
    }

    public final Set<String> TU() {
        g gVar = this.eqa;
        Set<String> hashSet = new HashSet();
        gVar.eqN.readLock().lock();
        for (a aVar : gVar.eqM.values()) {
            if (aVar.eqQ) {
                hashSet.add(aVar.eqP);
            }
        }
        gVar.eqN.readLock().unlock();
        return hashSet;
    }

    public b(String str, String str2, String str3) {
        this.filename = str;
        this.eqa = new g(str2);
        this.eqe = new bhz().VO(str3);
        x.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s", new Object[]{str, str2, str3});
    }

    public final boolean TV() {
        x.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
        this.eqh.removeMessages(291);
        if ((this.eqa.Uf() && this.eoE) || this.eqb) {
            x.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
            return false;
        }
        a iJ = this.eqa.iJ(this.ehi);
        if (iJ != null) {
            int min = Math.min(com.tencent.mm.a.e.cm(this.filename), iJ.eqS);
            x.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", new Object[]{Integer.valueOf(r3), Integer.valueOf(iJ.eqS), Integer.valueOf(min)});
            if (min <= 0) {
                x.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", new Object[]{this.filename});
                this.retCode = com.tencent.mm.compatible.util.g.getLine() + 40000;
                this.eqd = 0;
                TW();
                this.diJ.a(3, -1, "ReadFileLengthError", null);
                return false;
            }
            this.eqd = min - this.ehi;
            if (this.eqd < 0) {
                x.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", new Object[]{Integer.valueOf(this.eqd)});
                this.retCode = com.tencent.mm.compatible.util.g.getLine() + 40000;
                this.eqh.sendEmptyMessageDelayed(291, (long) (this.djl * 2));
                return false;
            }
            x.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", new Object[]{Integer.valueOf(this.eqd), Integer.valueOf(iJ.eqT), Integer.valueOf(this.djl)});
            if (this.eqd >= TbsListener$ErrorCode.INFO_CODE_MINIQB || iJ.eqT <= 5) {
                this.eqh.sendEmptyMessageDelayed(291, (long) this.djl);
            } else {
                x.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", new Object[]{Integer.valueOf(this.eqd)});
                this.eqh.sendEmptyMessageDelayed(291, (long) (this.djl * 2));
            }
            return true;
        }
        this.eqh.sendEmptyMessageDelayed(291, (long) (this.djl * 2));
        return true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bys();
        aVar.dIH = new byu();
        aVar.uri = "/cgi-bin/micromsg-bin/voicetrans";
        aVar.dIF = 235;
        aVar.dII = 381;
        aVar.dIJ = 1000000381;
        com.tencent.mm.ab.b KT = aVar.KT();
        KT.KV().qWx = false;
        bys bys = (bys) KT.dID.dIL;
        a iJ = this.eqa.iJ(this.ehi);
        if (iJ == null) {
            bys.rtW = new bhy();
            bys.rjC = this.ehi;
            bys.sso = "0";
            bys.rgC = 1;
            bys.ssq = 2;
            bys.rko = 0;
            bys.suD = this.eqa.Ue();
            bys.suC = bys.suD == null ? 0 : bys.suD.size();
            bys.shU = this.eqe;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            Iterator it = bys.suD.iterator();
            while (it.hasNext()) {
                stringBuilder.append(((bhz) it.next()).siM).append(", ");
            }
            stringBuilder.append("]");
            x.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", new Object[]{stringBuilder.toString(), Long.valueOf(System.currentTimeMillis())});
            return a(eVar, KT, this);
        }
        int i;
        iJ.eqQ = true;
        if (this.eqc) {
            iJ.eqR = true;
            bys.rtW = new bhy();
            x.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
        } else {
            if (this.eqd > this.eqg) {
                this.eqd = this.eqg;
                iJ.eqR = false;
            } else if (this.eqd <= this.eqg && (iJ.eqS != Integer.MAX_VALUE || this.eoE)) {
                iJ.eqR = true;
            }
            bys.rtW = new bhy().bq(com.tencent.mm.a.e.e(this.filename, this.ehi, this.eqd));
        }
        bys.rjC = this.ehi;
        bys.sso = iJ.eqP;
        if (iJ.eqR) {
            i = 1;
        } else {
            i = 0;
        }
        bys.rgC = i;
        bys.ssq = 2;
        i = iJ.eqT + 1;
        iJ.eqT = i;
        bys.rko = i;
        bys.suD = this.eqa.Ue();
        bys.suC = bys.suD == null ? 0 : bys.suD.size();
        bys.shU = this.eqe;
        x.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s", new Object[]{com.tencent.mm.compatible.util.g.Ac(), this.filename, Integer.valueOf(iJ.eqS), Integer.valueOf(this.ehi), Integer.valueOf(this.eqd), Integer.valueOf(bys.rtW.siI), Boolean.valueOf(iJ.eqR), Integer.valueOf(bys.rko), bys.suD, bys.shU});
        this.ehi = bys.rtW.siI + this.ehi;
        x.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", new Object[]{iJ.eqP, Integer.valueOf(this.ehi)});
        if (iJ.eqT == 1) {
            x.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", new Object[]{Long.valueOf(System.currentTimeMillis())});
        }
        x.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", new Object[]{Long.valueOf(System.currentTimeMillis())});
        return a(eVar, KT, this);
    }

    protected final int a(q qVar) {
        return com.tencent.mm.ab.l.b.dJm;
    }

    protected final int Cc() {
        return 2000;
    }

    protected final void a(l.a aVar) {
        x.w("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.Ac() + " setSecurityCheckError e: %s", new Object[]{aVar});
        if (aVar == l.a.dJj) {
            TW();
            this.diJ.a(3, -1, "SecurityCheckError", this);
        }
    }

    protected final boolean KZ() {
        return true;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", new Object[]{com.tencent.mm.compatible.util.g.Ac(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 3 && i3 == -1) {
            x.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", new Object[]{bi.cjd(), Long.valueOf(Thread.currentThread().getId())});
        }
        bys bys = (bys) ((com.tencent.mm.ab.b) qVar).dID.dIL;
        byu byu = (byu) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", new Object[]{bys.sso, Integer.valueOf(bys.rko), Long.valueOf(System.currentTimeMillis())});
            this.eqa.Y(byu.suH);
            if (this.eqa.Uf() && this.eoE) {
                x.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
                TX();
            }
            this.eqf = new String[]{this.eqa.getResult()};
            this.diJ.a(i2, i3, str, this);
            this.eqg = byu.suI <= 0 ? this.eqg : byu.suI;
            this.djl = byu.sga < 0 ? TbsListener$ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR : byu.sga;
            x.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", new Object[]{Integer.valueOf(this.eqg), Integer.valueOf(this.djl)});
            return;
        }
        x.i("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.Ac() + " onGYNetEnd file: %s errType:%s errCode:%s", new Object[]{this.filename, Integer.valueOf(i2), Integer.valueOf(i3)});
        TW();
        this.diJ.a(i2, i3, str, this);
    }

    public final void TW() {
        x.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.Ac());
        if (!this.eqc) {
            this.eqc = true;
            TX();
            o DF = g.DF();
            x.l("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", new Object[]{Integer.valueOf(hashCode())});
            DF.dJt.H(new 4(DF, r1));
            a iJ = this.eqa.iJ(this.ehi);
            if (iJ != null) {
                this.eqd = 0;
                g.Em().H(new 1(this, iJ));
            }
        }
    }

    private void TX() {
        x.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.Ac());
        if (this.eqh != null) {
            this.eqh.removeMessages(291);
        }
        this.eqb = true;
    }

    public final int getType() {
        return 235;
    }

    public final void iI(int i) {
        x.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", new Object[]{com.tencent.mm.compatible.util.g.Ac(), Integer.valueOf(i)});
        if (i < 0) {
            throw new IllegalStateException();
        }
        this.eqa.iI(i);
    }
}
