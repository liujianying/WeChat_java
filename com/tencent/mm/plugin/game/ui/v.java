package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.s.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class v implements OnClickListener {
    private int fdx = 13;
    private int jNv;
    private int kcP;
    private Context mContext;
    private int mPosition;

    public v(Context context) {
        this.mContext = context;
    }

    public final void cI(int i, int i2) {
        this.jNv = i;
        this.kcP = 1301;
        this.mPosition = i2;
    }

    public final void onClick(View view) {
        if (view.getTag() != null) {
            String str;
            if (view.getTag() instanceof s) {
                s sVar = (s) view.getTag();
                if (!bi.cX(sVar.jMr)) {
                    str = ((h) sVar.jMr.get(0)).jNq;
                    if (bi.oW(str)) {
                        x.e("MicroMsg.GameURLClickListener", "message's jumpurl is null");
                        return;
                    }
                    an.a(this.mContext, this.fdx, this.kcP, this.mPosition, c.an(this.mContext, str), 0, sVar.field_appId, this.jNv, sVar.field_msgType, sVar.field_gameMsgId, sVar.jNb, null);
                }
            } else if (view.getTag() instanceof String) {
                str = (String) view.getTag();
                if (!bi.oW(str)) {
                    an.a(this.mContext, this.fdx, this.kcP, this.mPosition, c.an(this.mContext, str), this.jNv, null);
                }
            }
        }
    }
}
