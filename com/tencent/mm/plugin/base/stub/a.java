package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.q;
import com.tencent.mm.ui.base.h;

public final class a extends d {
    public a(Context context, String str, String str2, com.tencent.mm.plugin.base.stub.d.a aVar) {
        super(context, str, str2, aVar);
    }

    protected final void Vl() {
        h.a(this.context, R.l.game_openid_checker_fail_msg, R.l.app_tip, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.plugin.game.a.a aSm = com.tencent.mm.plugin.game.a.a.a.aSm();
                if (aSm != null) {
                    aSm.P(a.this.openId, q.GI(), a.this.appId);
                }
                a.this.hdE.dG(false);
            }
        });
    }
}
