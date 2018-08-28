package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.mm.g.a.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.protocal.c.add;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class b extends d {
    private boolean iiQ = false;
    private String iiv;
    private e ijL;
    private g ijT;

    public b(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
        }
        this.iiv = str;
    }

    public b(String str, byte b) {
        if (bi.oW(str)) {
            x.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
        }
        this.iiv = str;
        this.iiQ = true;
    }

    public final void run() {
        if (this.ijL != null) {
            this.ijL.zI(getKey());
        } else {
            x.w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
        }
        EmojiGroupInfo br = i.aEA().igy.br(getKey(), true);
        if (this.iiQ || br == null || br.field_sync != 2 || br.field_status != 7) {
            this.ijT = new g(this.iiv);
            au.DF().a(this.ijT, 0);
            add add = new add();
            com.tencent.mm.storage.emotion.i ZE = i.aEA().igB.ZE(this.iiv);
            if (!(ZE == null || ZE.field_content == null)) {
                try {
                    add.aG(ZE.field_content);
                } catch (Throwable e) {
                    x.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "exception:%s", new Object[]{bi.i(e)});
                }
            }
            if (add.rHx == null) {
                au.DF().a(new l(this.iiv, 15), 0);
                return;
            }
            return;
        }
        cs csVar = new cs();
        csVar.bKf.bKg = getKey();
        csVar.bKf.bIH = 2;
        csVar.bKf.success = true;
        a.sFg.m(csVar);
    }

    public final String getKey() {
        return this.iiv == null ? "" : this.iiv;
    }

    public final void a(e eVar) {
        this.ijL = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            b bVar = (b) obj;
            if (!(bi.oW(this.iiv) || bi.oW(bVar.getKey()) || !this.iiv.equals(bVar.getKey()))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
        if (this.ijT == null || bi.oW(this.ijT.dVk)) {
            x.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "failed cancel exchange emotion pack.");
            return;
        }
        com.tencent.mm.modelcdntran.g.ND().lx(this.ijT.dVk);
        x.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", new Object[]{this.ijT.dVk});
    }
}
