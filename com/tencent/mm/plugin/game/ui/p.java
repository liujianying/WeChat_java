package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class p extends b {
    public p(Context context, int i) {
        super(context);
        this.jNv = i;
    }

    public final void onClick(View view) {
        s sVar;
        Object tag = view.getTag();
        if (tag == null) {
            x.e("MicroMsg.GameMessageOnClickListener", "Tag is null.");
            sVar = null;
        } else if (tag instanceof Long) {
            s dH = ((c) g.l(c.class)).aSj().dH(((Long) tag).longValue());
            if (dH != null) {
                dH.aTW();
            }
            sVar = dH;
        } else {
            x.e("MicroMsg.GameMessageOnClickListener", "The tag of action listener is not instance of Long");
            sVar = null;
        }
        if (sVar == null) {
            x.e("MicroMsg.GameMessageContentClickListener", "The game message is null.");
            return;
        }
        switch (sVar.field_msgType) {
            case 5:
                if (!bi.oW(sVar.jMO)) {
                    an.a(this.mContext, 13, 1301, 3, com.tencent.mm.plugin.game.e.c.an(this.mContext, sVar.jMO), 0, sVar.field_appId, this.jNv, sVar.field_msgType, sVar.field_gameMsgId, sVar.jNb, null);
                    return;
                }
                return;
            case 6:
                if (!bi.oW(sVar.jML)) {
                    an.a(this.mContext, 13, 1301, 3, com.tencent.mm.plugin.game.e.c.an(this.mContext, sVar.jML), 0, sVar.field_appId, this.jNv, sVar.field_msgType, sVar.field_gameMsgId, sVar.jNb, null);
                    return;
                }
                return;
            case 10:
            case 11:
                if (bi.oW(sVar.jMj)) {
                    an.a(this.mContext, 13, 1301, 3, a(this.mContext, sVar), 0, sVar.field_appId, this.jNv, sVar.field_msgType, sVar.field_gameMsgId, sVar.jNb, null);
                    return;
                }
                an.a(this.mContext, 13, 1301, 3, com.tencent.mm.plugin.game.e.c.an(this.mContext, sVar.jMj), 0, sVar.field_appId, this.jNv, sVar.field_msgType, sVar.field_gameMsgId, sVar.jNb, null);
                return;
            default:
                an.a(this.mContext, 13, 1301, 3, a(this.mContext, sVar), 0, sVar.field_appId, this.jNv, sVar.field_msgType, sVar.field_gameMsgId, sVar.jNb, null);
                return;
        }
    }
}
