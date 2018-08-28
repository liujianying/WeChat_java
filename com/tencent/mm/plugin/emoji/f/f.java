package com.tencent.mm.plugin.emoji.f;

import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.bvs;
import com.tencent.mm.protocal.c.bvt;
import com.tencent.mm.protocal.c.te;
import com.tencent.mm.protocal.c.tf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;

public final class f extends l implements k {
    private EmojiInfo bIk;
    private final b diG;
    private e diJ;
    private boolean iiu = true;

    public f(EmojiInfo emojiInfo) {
        this.bIk = emojiInfo;
        a aVar = new a();
        aVar.dIG = new te();
        aVar.dIH = new tf();
        aVar.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
        aVar.dIF = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_WRITE_FILE_FAILED;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        te teVar = (te) this.diG.dID.dIL;
        bvs bvs = new bvs();
        if (this.bIk != null) {
            i.aEA().igx.a(ad.getContext(), this.bIk);
            bvs.rwt = this.bIk.Xh();
            bvs.rdV = this.bIk.field_size;
            teVar.rwA.add(bvs);
        }
    }

    public final int getType() {
        return TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_WRITE_FILE_FAILED;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 8192;
        int i2 = -1;
        this.diJ = eVar2;
        bvs bvs = (bvs) ((te) this.diG.dID.dIL).rwA.get(0);
        int i3;
        Object a;
        byte[] bArr;
        Object obj;
        if (this.iiu) {
            x.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + bvs.rwt);
            bvs.rdW = 0;
            i3 = this.bIk.field_size + 0;
            if (i3 <= 8192) {
                i = i3;
            }
            if ((this.bIk.field_reserved4 & EmojiInfo.tcW) == EmojiInfo.tcW) {
                a = com.tencent.mm.plugin.emoji.e.e.aDM().a(this.bIk);
                if (bi.bC(a)) {
                    x.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
                    bArr = new byte[0];
                } else {
                    obj = new byte[i];
                    x.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d ", new Object[]{Integer.valueOf(a.length), Integer.valueOf(i)});
                    System.arraycopy(a, 0, obj, 0, i);
                    bArr = obj;
                }
            } else {
                bArr = this.bIk.eI(0, i);
            }
            if (bArr == null || bArr.length <= 0) {
                x.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
                return -1;
            }
            bvs.rdW = 0;
            bvs.ssk = new com.tencent.mm.bk.b(bArr);
            String str = "MicroMsg.emoji.NetSceneEmojiUpload";
            String str2 = "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(bArr.length);
            objArr[1] = Integer.valueOf(bvs.ssk.lR.length);
            objArr[2] = Integer.valueOf(this.bIk == null ? -1 : this.bIk.field_start);
            if (this.bIk != null) {
                i2 = this.bIk.field_size;
            }
            objArr[3] = Integer.valueOf(i2);
            x.i(str, str2, objArr);
            return a(eVar, this.diG, this);
        } else if (this.bIk == null || this.bIk.field_start == 0) {
            x.e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
            return -1;
        } else {
            i3 = this.bIk.field_size - this.bIk.field_start;
            if (i3 <= 8192) {
                i = i3;
            }
            if ((this.bIk.field_reserved4 & EmojiInfo.tcW) == EmojiInfo.tcW) {
                a = com.tencent.mm.plugin.emoji.e.e.aDM().a(this.bIk);
                if (bi.bC(a)) {
                    x.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
                    bArr = new byte[0];
                } else {
                    obj = new byte[i];
                    x.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d", new Object[]{Integer.valueOf(a.length), Integer.valueOf(i)});
                    System.arraycopy(a, this.bIk.field_start, obj, 0, i);
                    bArr = obj;
                }
            } else {
                bArr = this.bIk.eI(this.bIk.field_start, i);
            }
            if (bArr == null || bArr.length <= 0) {
                x.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
                return -1;
            }
            i3 = bArr.length;
            bvs.rdW = this.bIk.field_start;
            bvs.ssk = new com.tencent.mm.bk.b(bArr);
            x.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(bvs.ssk.lR.length)});
            x.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.bIk.field_start + ", total:" + this.bIk.field_size + ", len:" + i3);
            return a(eVar, this.diG, this);
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd  errtype:" + i2 + " errcode:" + i3);
        if (i2 == 0 && i3 == 0) {
            te teVar = (te) ((b) qVar).dID.dIL;
            tf tfVar = (tf) ((b) qVar).dIE.dIL;
            if (teVar.rwA.size() != tfVar.rwA.size()) {
                x.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + teVar.rwA.size() + ", resp size:" + tfVar.rwA.size());
                aEK();
                this.diJ.a(i2, i3, str, this);
                d(this.bIk, false);
                return;
            }
            bvt bvt = null;
            if (tfVar.rwA != null && tfVar.rwA.size() > 0) {
                bvt = (bvt) tfVar.rwA.get(0);
            }
            String str2;
            if (bvt == null || bvt.rwt == null || !bvt.rwt.equals(this.bIk.Xh()) || bvt.rdW < this.bIk.field_start) {
                int i4;
                String str3 = "MicroMsg.emoji.NetSceneEmojiUpload";
                str2 = "md5:%s invalid server return value. respInfo.TotalLen:%d respInfo.StartPos:%d emoji.getStart():%d emoji total:%d";
                Object[] objArr = new Object[5];
                objArr[0] = bvt.rwt;
                objArr[1] = Integer.valueOf(bvt.rdV);
                objArr[2] = Integer.valueOf(bvt == null ? -1 : bvt.rdW);
                if (this.bIk == null) {
                    i4 = -1;
                } else {
                    i4 = this.bIk.field_start;
                }
                objArr[3] = Integer.valueOf(i4);
                if (this.bIk == null) {
                    i4 = -1;
                } else {
                    i4 = this.bIk.field_size;
                }
                objArr[4] = Integer.valueOf(i4);
                x.e(str3, str2, objArr);
                aEK();
                this.diJ.a(4, -2, "", this);
                d(this.bIk, false);
                return;
            } else if (bvt != null && this.bIk != null && bvt.rfn != 0 && bvt.rdW == bvt.rdV && bvt.rdW > 0) {
                x.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", new Object[]{this.bIk.Xh(), Integer.valueOf(bvt.rfn), Integer.valueOf(bvt.rdW), Integer.valueOf(bvt.rdV)});
                aEK();
                this.diJ.a(i2, i3, "", this);
                return;
            } else if (tfVar.six.rfn == 0 && (bvt == null || bvt.rfn == 0)) {
                if (this.iiu) {
                    this.iiu = false;
                }
                if (bvt.rdW >= bvt.rdV) {
                    this.bIk.field_start = 0;
                    this.bIk.field_state = EmojiInfo.tcP;
                    this.bIk.field_needupload = EmojiInfo.tcU;
                    i.aEA().igx.p(this.bIk);
                    this.diJ.a(i2, i3, "", this);
                    d(this.bIk, true);
                    x.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
                    return;
                }
                x.i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", new Object[]{Integer.valueOf(bvt.rdW)});
                this.bIk.field_start = bvt.rdW;
                i.aEA().igx.p(this.bIk);
                if (a(this.dIX, this.diJ) < 0) {
                    this.diJ.a(3, -1, "", this);
                    d(this.bIk, false);
                    return;
                }
                return;
            } else {
                str2 = "MicroMsg.emoji.NetSceneEmojiUpload";
                String str4 = "onGYNetEnd failed. resp.BaseResponse.Ret:%d respInfo.Ret:%d";
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(tfVar.six.rfn);
                objArr2[1] = Integer.valueOf(bvt == null ? -1 : bvt.rfn);
                x.e(str2, str4, objArr2);
                aEK();
                this.diJ.a(i2, i3, "", this);
                return;
            }
        }
        aEK();
        this.diJ.a(i2, i3, str, this);
        d(this.bIk, false);
    }

    protected final int Cc() {
        return GLIcon.TOP;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    private void aEK() {
        this.bIk.field_start = 0;
        i.aEA().igx.p(this.bIk);
    }

    private static void d(EmojiInfo emojiInfo, boolean z) {
        if (emojiInfo != null && !bi.oW(emojiInfo.Xh())) {
            x.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", new Object[]{emojiInfo.Xh(), Boolean.valueOf(z)});
            cs csVar = new cs();
            csVar.bKf.bKg = emojiInfo.Xh();
            csVar.bKf.bIH = 0;
            csVar.bKf.success = z;
            com.tencent.mm.sdk.b.a.sFg.m(csVar);
        }
    }
}
