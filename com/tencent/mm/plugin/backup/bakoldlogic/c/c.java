package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.a.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.bk.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.x;
import com.tencent.mm.plugin.backup.h.y;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.protocal.c.ez;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

public final class c extends b {
    private static int progress;
    private int dHI = 0;
    private String filePath;
    public x gXK = new x();
    private y gXL = new y();
    private f has = null;
    private byte[] hat;
    private byte[] key;
    private int offset = 0;
    private int start = 0;
    private int type;

    public c(String str, int i, LinkedList<ey> linkedList, String str2, f fVar, byte[] bArr) {
        this.gXK.hcI = str;
        this.gXK.hcJ = i;
        this.type = i;
        if (i == 1) {
            ez ezVar = new ez();
            ezVar.hbG = linkedList;
            ezVar.hbF = linkedList.size();
            try {
                this.hat = ezVar.toByteArray();
                this.dHI = this.hat.length;
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BakSceneDataPush", "backList to buffer error");
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.BakSceneDataPush", e, "", new Object[0]);
            }
        } else {
            this.filePath = str2;
            this.dHI = e.cm(str2);
        }
        int i2 = this.dHI % 16;
        this.gXK.hcK = (16 - i2) + this.dHI;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BakSceneDataPush", "BakSceneDataPush init:%s  type:%d, localTotalLen:%d, reqDataSize:%d", new Object[]{this.gXK.hcI, Integer.valueOf(this.gXK.hcJ), Integer.valueOf(this.dHI), Integer.valueOf(this.gXK.hcK)});
        this.has = fVar;
        this.key = bArr;
    }

    public static void setProgress(int i) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BakSceneDataPush", "setProgress %d", new Object[]{Integer.valueOf(i)});
        progress = i;
    }

    public final boolean ass() {
        int i;
        byte[] bArr;
        long j = 524288;
        if (this.type == 1) {
            i = this.dHI;
            bArr = this.hat;
        } else {
            if (((long) (this.dHI - this.offset)) <= 524288) {
                j = (long) (this.dHI - this.offset);
            }
            i = (int) j;
            int i2 = 3;
            bArr = null;
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0 && bArr == null) {
                    if (!bi.oW(this.filePath)) {
                        String str = this.filePath;
                        au.HU();
                        if (str.startsWith(com.tencent.mm.model.c.Gg())) {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BakSceneDataPush", "md5:%s", new Object[]{this.filePath.substring(this.filePath.lastIndexOf("/") + 1)});
                            EmojiInfo zi = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(r4);
                            if (zi == null || (zi.field_reserved4 & EmojiInfo.tcW) != EmojiInfo.tcW) {
                                bArr = e.e(this.filePath, this.offset, i);
                                i2 = i3;
                            } else {
                                bArr = new byte[i];
                                System.arraycopy(((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(zi), this.offset, bArr, 0, i);
                                i2 = i3;
                            }
                        }
                    }
                    bArr = e.e(this.filePath, this.offset, i);
                    i2 = i3;
                } else if (bArr == null) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BakSceneDataPush", "read file error, offset%d, len:%d", new Object[]{Integer.valueOf(this.offset), Integer.valueOf(i)});
                }
            }
            if (bArr == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BakSceneDataPush", "read file error, offset%d, len:%d", new Object[]{Integer.valueOf(this.offset), Integer.valueOf(i)});
            }
        }
        this.start = this.offset;
        this.offset = i + this.start;
        if (this.key != null) {
            boolean z;
            byte[] bArr2 = this.key;
            if (this.offset == this.dHI) {
                z = true;
            } else {
                z = false;
            }
            bArr = AesEcb.aesCryptEcb(bArr, bArr2, true, z);
        }
        this.gXK.hcL = this.start;
        this.gXK.hcM = (bArr == null ? 0 : bArr.length) + this.start;
        this.gXK.hbs = new com.tencent.mm.bk.b(bArr);
        this.gXK.hcO = progress;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BakSceneDataPush", "doSecne %s---total:%d, start:%d, offset:%d, data.len:%d", new Object[]{this.gXK.hcI, Integer.valueOf(this.dHI), Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.gXK.hcM)});
        return super.ass();
    }

    public final a asj() {
        return this.gXL;
    }

    public final a ask() {
        return this.gXK;
    }

    public final void mI(int i) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BakSceneDataPush", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[]{this.gXL.hcI, Integer.valueOf(this.gXL.hcJ), Integer.valueOf(this.gXL.hcL), Integer.valueOf(this.gXL.hcM), Integer.valueOf(this.gXL.hcd)});
        if (this.gXL.hcd != 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BakSceneDataPush", "status:%d", new Object[]{Integer.valueOf(this.gXL.hcd)});
            g(4, this.gXL.hcd, "error");
            return;
        }
        this.has.a(this.gXK.hcM - this.gXK.hcL, this.dHI, this);
        if (this.offset == this.dHI) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BakSceneDataPush", "back complete: %s,  %d", new Object[]{this.gXK.hcI, Integer.valueOf(this.dHI)});
            g(0, 0, "success");
            return;
        }
        ass();
    }

    public final int getType() {
        return 5;
    }
}
