package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class c extends d {
    private String iiv;
    private e ijL;

    public c(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
        }
        this.iiv = str;
    }

    public final void run() {
        if (this.ijL != null) {
            this.ijL.zI(getKey());
        } else {
            x.w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
        }
        EmojiGroupInfo br = i.aEA().igy.br(EmojiGroupInfo.tcy, false);
        br.field_flag = 0;
        i.aEA().igy.a(br);
        if (this.ijL != null) {
            this.ijL.j(getKey(), 2, true);
        }
    }

    public final String getKey() {
        return this.iiv == null ? "" : this.iiv;
    }

    public final void a(e eVar) {
        this.ijL = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof c)) {
            c cVar = (c) obj;
            if (!(bi.oW(this.iiv) || bi.oW(cVar.getKey()) || !this.iiv.equals(cVar.getKey()))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
    }
}
