package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class d extends com.tencent.mm.plugin.emoji.sync.d {
    private e ijL;
    private l ijU;
    private EmojiInfo ijV;
    private String mKey;

    public d(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.BKGLoader.EmojiUploadTask", "[cpan] can not create task. md5 is null.");
        }
        this.mKey = str;
        this.ijV = i.aEA().igx.Zy(this.mKey);
    }

    public final void run() {
        if (this.ijL != null) {
            this.ijL.zI(this.mKey);
        } else {
            x.w("MicroMsg.BKGLoader.EmojiUploadTask", "call back is null.");
        }
        if (this.ijV == null) {
            this.ijL.j(this.mKey, 1, false);
            return;
        }
        this.ijU = new f(this.ijV);
        au.DF().a(this.ijU, 0);
    }

    public final String getKey() {
        return this.mKey;
    }

    public final void a(e eVar) {
        this.ijL = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof d)) {
            d dVar = (d) obj;
            if (!(bi.oW(this.mKey) || bi.oW(dVar.mKey) || !this.mKey.equals(dVar.mKey))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
    }
}
