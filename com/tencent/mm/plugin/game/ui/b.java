package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class b implements OnClickListener {
    protected int iMc = 1301;
    protected int jNv;
    protected Context mContext;

    public b(Context context) {
        this.mContext = context;
        if (context == null) {
            throw new IllegalArgumentException("context is null.");
        }
    }

    protected static int a(Context context, s sVar) {
        if (sVar == null) {
            x.e("MicroMsg.GameMessageOnClickListener", "game message is null.");
            return 0;
        } else if (bi.oW(sVar.field_appId)) {
            x.e("MicroMsg.GameMessageOnClickListener", "message type : " + sVar.field_msgType + " ,message.field_appId is null.");
            return 0;
        } else {
            Bundle bundle = new Bundle();
            bundle.putCharSequence("game_app_id", sVar.field_appId);
            bundle.putInt("game_report_from_scene", 1301);
            return c.b(context, sVar.field_appId, null, bundle);
        }
    }
}
