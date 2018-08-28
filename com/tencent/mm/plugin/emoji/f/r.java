package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bvu;
import com.tencent.mm.protocal.c.bvv;
import com.tencent.mm.protocal.c.tc;
import com.tencent.mm.protocal.c.td;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.y.h;
import junit.framework.Assert;

public final class r extends l implements k {
    private EmojiInfo bIk;
    private long dTS;
    private final b diG;
    private e diJ;
    private boolean iiu;

    public r(String str, String str2, EmojiInfo emojiInfo, long j) {
        this(str, str2, emojiInfo, j, (byte) 0);
    }

    private r(String str, String str2, EmojiInfo emojiInfo, long j, byte b) {
        int i = 1;
        this.iiu = true;
        this.dTS = 0;
        boolean z = (str2 == null || str2.length() <= 0 || emojiInfo == null) ? false : true;
        Assert.assertTrue(z);
        this.dTS = j;
        this.bIk = emojiInfo;
        a aVar = new a();
        aVar.dIG = new bvu();
        aVar.dIH = new bvv();
        aVar.uri = "/cgi-bin/micromsg-bin/sendemoji";
        aVar.dIF = 175;
        aVar.dII = 68;
        aVar.dIJ = 1000000068;
        this.diG = aVar.KT();
        i.aEA().igx.a(ad.getContext(), emojiInfo);
        bvu bvu = (bvu) this.diG.dID.dIL;
        tc tcVar = new tc();
        tcVar.rwt = emojiInfo.Xh();
        tcVar.rwx = str;
        tcVar.jTu = str2;
        tcVar.rdV = emojiInfo.field_size;
        tcVar.rwv = emojiInfo.getContent();
        tcVar.hcE = emojiInfo.field_type;
        tcVar.rco = bf.Ir();
        tcVar.rwy = 0;
        if (str2.endsWith("@chatroom")) {
            i = 2;
        }
        if (emojiInfo.field_catalog == EmojiInfo.tcG) {
            tcVar.rww = "56,2," + i;
        } else if (emojiInfo.field_catalog == EmojiInfo.tcF) {
            tcVar.rww = "56,1," + i;
        }
        bvu.rwA.add(tcVar);
        bvu.ssl = bvu.rwA.size();
    }

    public final int getType() {
        return 175;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 8192;
        this.diJ = eVar2;
        tc tcVar = (tc) ((bvu) this.diG.dID.dIL).rwA.get(0);
        if (this.iiu) {
            x.d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + tcVar.rwt);
            tcVar.rwu = new bhy();
            tcVar.rdW = 0;
            return a(eVar, this.diG, this);
        }
        byte[] bArr;
        int i2 = this.bIk.field_size - this.bIk.field_start;
        if (i2 <= 8192) {
            i = i2;
        }
        if ((this.bIk.field_reserved4 & EmojiInfo.tcW) == EmojiInfo.tcW) {
            Object a = com.tencent.mm.plugin.emoji.e.e.aDM().a(this.bIk);
            if (bi.bC(a)) {
                x.w("MicroMsg.emoji.NetSceneUploadEmoji", "buffer is null.");
                bArr = new byte[0];
            } else {
                Object obj = new byte[i];
                x.d("MicroMsg.emoji.NetSceneUploadEmoji", "total length:%d dataLen:%d", new Object[]{Integer.valueOf(a.length), Integer.valueOf(i)});
                System.arraycopy(a, this.bIk.field_start, obj, 0, i);
                bArr = obj;
            }
        } else {
            bArr = this.bIk.eI(this.bIk.field_start, i);
        }
        if (EmojiLogic.ak(bArr) == EmojiInfo.tcx && this.iiu) {
            x.e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
            this.bIk.cnw();
            return -1;
        } else if (bArr == null || bArr.length <= 0) {
            x.e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
            return -1;
        } else {
            i2 = bArr.length;
            tcVar.rdW = this.bIk.field_start;
            tcVar.rwu = new bhy().b(com.tencent.mm.bk.b.bi(bArr));
            if (f.eZ(tcVar.jTu)) {
                au.HU();
                tcVar.rco = com.tencent.mm.ac.a.e.lg(c.FT().dW(this.dTS).cqb);
                x.d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", new Object[]{tcVar.rco});
            }
            x.d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.bIk.field_start + ", total:" + this.bIk.field_size + ", len:" + i2);
            return a(eVar, this.diG, this);
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            bvu bvu = (bvu) ((b) qVar).dID.dIL;
            bvv bvv = (bvv) ((b) qVar).dIE.dIL;
            if (bvu.rwA.size() != bvv.rwA.size()) {
                x.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + bvv.rwA.size() + ", resp size:" + bvu.rwA.size());
                this.diJ.a(i2, i3, str, this);
                return;
            }
            td tdVar = (td) bvv.rwA.get(0);
            if (tdVar.rwt == null || !tdVar.rwt.equals(this.bIk.Xh()) || tdVar.rdW < this.bIk.field_start) {
                x.e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + tdVar.rdW + ", size=" + this.bIk.field_size);
                this.diJ.a(4, -2, "", this);
                this.bIk.field_start = 0;
                i.aEA().igx.q(this.bIk);
                return;
            } else if (bvv.six.rfn != 0) {
                x.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. resp.BaseResponse.Ret:%d", new Object[]{Integer.valueOf(bvv.six.rfn)});
                this.diJ.a(4, -2, "", this);
                return;
            } else {
                if (this.iiu) {
                    this.iiu = false;
                }
                if (tdVar.rdW >= tdVar.rdV) {
                    x.d("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + tdVar.rwz);
                    au.HU();
                    bd dW = c.FT().dW(this.dTS);
                    x.d("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", new Object[]{Integer.valueOf(tdVar.rwz), Integer.valueOf(af.exn)});
                    if (10007 == af.exm && af.exn != 0) {
                        tdVar.rwz = af.exn;
                        af.exn = 0;
                    }
                    dW.ax((long) tdVar.rwz);
                    au.HU();
                    c.FT().a(this.dTS, dW);
                    this.bIk.field_start = 0;
                    this.bIk.field_lastUseTime = System.currentTimeMillis();
                    this.bIk.field_state = EmojiInfo.tcP;
                    i.aEA().igx.q(this.bIk);
                    if (dW.aQm()) {
                        com.tencent.mm.modelstat.b.ehL.a(dW, h.g(dW));
                    } else {
                        com.tencent.mm.modelstat.b.ehL.f(dW);
                    }
                    this.diJ.a(i2, i3, "", this);
                    return;
                }
                this.bIk.field_start = tdVar.rdW;
                this.bIk.field_lastUseTime = System.currentTimeMillis();
                i.aEA().igx.q(this.bIk);
                if (a(this.dIX, this.diJ) < 0) {
                    this.diJ.a(3, -1, "", this);
                    return;
                }
                return;
            }
        }
        x.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed errtype:" + i2 + " errcode:" + i3);
        this.diJ.a(i2, i3, str, this);
    }

    protected final int Cc() {
        return 256;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }
}
