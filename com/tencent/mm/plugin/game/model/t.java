package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class t implements OnClickListener {
    public int jNv;
    private Context mContext;

    public t(Context context) {
        this.mContext = context;
    }

    public t(Context context, int i) {
        this.mContext = context;
        this.jNv = i;
    }

    public final void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            x.e("MicroMsg.GameMessageClickListener", "v.getTag is null");
            return;
        }
        a aVar = (a) view.getTag();
        if (aVar.jNw == null) {
            x.e("MicroMsg.GameMessageClickListener", "message is null");
        } else if (aVar.jNs == null) {
            x.e("MicroMsg.GameMessageClickListener", "jumpId is null");
        } else {
            s$d s_d = (s$d) aVar.jNw.jMw.get(aVar.jNs);
            if (s_d == null) {
                x.e("MicroMsg.GameMessageClickListener", "jumpInfo is null");
                return;
            }
            int a = a(this.mContext, aVar.jNw, s_d, aVar.jNw.field_appId, aVar.bYq);
            if (a != 0) {
                an.a(this.mContext, 13, aVar.bYq, aVar.position, a, 0, aVar.jNw.field_appId, this.jNv, aVar.jNw.jNa, aVar.jNw.field_gameMsgId, aVar.jNw.jNb, null);
            }
        }
    }

    public static int a(Context context, s sVar, s$d s_d, String str, int i) {
        int i2 = 0;
        switch (s_d.jNj) {
            case 1:
                if (!g.r(context, str)) {
                    return h(context, str, i);
                }
                f.ah(context, str);
                return 3;
            case 2:
                if (!g.r(context, str)) {
                    return 0;
                }
                f.ah(context, str);
                return 3;
            case 3:
                return h(context, str, i);
            case 4:
                if (sVar != null) {
                    sVar.field_isRead = true;
                    ((c) com.tencent.mm.kernel.g.l(c.class)).aSj().c(sVar, new String[0]);
                }
                Intent intent = new Intent();
                intent.setClassName(context, "com.tencent.mm.plugin.game.ui.GameMessageUI");
                intent.putExtra("game_report_from_scene", i);
                context.startActivity(intent);
                return 6;
            case 5:
                String str2 = s_d.iCI;
                if (!bi.oW(str2)) {
                    i2 = com.tencent.mm.plugin.game.e.c.an(context, str2);
                }
                return i2;
            default:
                x.i("MicroMsg.GameMessageClickListener", "unknown msg jump type = " + s_d.jNj);
                return 0;
        }
    }

    private static int h(Context context, String str, int i) {
        if (bi.oW(str)) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence("game_app_id", str);
        bundle.putInt("game_report_from_scene", i);
        return com.tencent.mm.plugin.game.e.c.b(context, str, null, bundle);
    }
}
