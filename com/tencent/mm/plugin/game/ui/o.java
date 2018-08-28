package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.bi;

public final class o extends b {
    public o(Context context, int i) {
        super(context);
        this.jNv = i;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof s) {
            s sVar = (s) view.getTag();
            switch (sVar.field_msgType) {
                case 6:
                    if (!bi.oW(sVar.jMq)) {
                        an.a(this.mContext, 13, 1301, 5, c.an(this.mContext, sVar.jMq), 0, sVar.field_appId, this.jNv, sVar.field_msgType, sVar.field_gameMsgId, sVar.jNb, null);
                        return;
                    }
                    return;
                default:
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("game_app_id", sVar.field_appId);
                    bundle.putInt("game_report_from_scene", 1301);
                    an.a(this.mContext, 13, 1301, 5, c.b(this.mContext, sVar.field_appId, null, bundle), 0, sVar.field_appId, this.jNv, sVar.field_msgType, sVar.field_gameMsgId, sVar.jNb, null);
                    return;
            }
        }
    }
}
