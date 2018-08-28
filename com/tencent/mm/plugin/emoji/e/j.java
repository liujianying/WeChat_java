package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.m;
import java.util.HashMap;

public final class j {
    public int hou = 79;
    public boolean igc = true;
    public long igd = 863913600000L;
    public int ige = 19;
    public m igf;
    public HashMap<String, m> igg = new HashMap();

    public final void aEe() {
        if (this.igf != null) {
            this.igf.field_continuCount = 0;
            this.igg.put(this.igf.field_prodcutID, this.igf);
            i.aEA().igE.a(this.igf);
            this.igf = null;
        }
    }

    public final void a(m mVar, boolean z) {
        if (mVar == null) {
            x.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateLastRewardTipInfo failed. reward tip info is null.");
            return;
        }
        int i = (this.igf == null || this.igf.field_prodcutID.equalsIgnoreCase(mVar.field_prodcutID)) ? 1 : 0;
        if (i == 0) {
            this.igf.field_continuCount = 0;
            this.igg.put(this.igf.field_prodcutID, this.igf);
            i.aEA().igE.a(this.igf);
        }
        this.igf = mVar;
        if (z) {
            this.igf.field_modifyTime = 0;
            this.igf.field_showTipsTime = System.currentTimeMillis();
            this.igf.field_totalCount = 0;
            this.igf.field_continuCount = 0;
        } else {
            if (i != 0) {
                this.igf.field_continuCount++;
            } else {
                this.igf.field_continuCount = 1;
            }
            this.igf.field_totalCount++;
            this.igf.field_modifyTime = System.currentTimeMillis();
        }
        this.igg.put(this.igf.field_prodcutID, this.igf);
        i.aEA().igE.a(this.igf);
    }

    public final void bh(String str, int i) {
        if (bi.oW(str)) {
            x.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag failed. no such product id.");
        } else if (this.igg == null || !this.igg.containsKey(str)) {
            x.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag map no contains this product id :%s", new Object[]{str});
        } else {
            ((m) this.igg.get(str)).field_flag = i;
            ((m) this.igg.get(str)).field_setFlagTime = System.currentTimeMillis();
        }
    }
}
