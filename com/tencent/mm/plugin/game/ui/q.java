package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class q implements OnClickListener {
    int hop;
    private d jMa;
    String kbt = null;
    protected Context mContext;

    public q(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof d) {
            this.jMa = (d) view.getTag();
            x.i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.jMa.field_appId);
            if (g.r(this.mContext, this.jMa.field_appId)) {
                x.d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.jMa.field_appId + ", pkg = " + this.jMa.field_packageName + ", openId = " + this.jMa.field_openId);
                f.ah(this.mContext, this.jMa.field_appId);
                an.a(this.mContext, this.jMa.scene, this.jMa.bYq, this.jMa.position, 3, this.jMa.field_appId, this.hop, this.jMa.bHF, this.jMa.jLt);
                return;
            }
            x.i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", new Object[]{this.kbt});
            if (bi.oW(this.kbt)) {
                x.e("MicroMsg.GamePreemptiveCliclListener", "null or nill preemptive url");
                return;
            }
            c.an(this.mContext, this.kbt);
            an.a(this.mContext, this.jMa.scene, this.jMa.bYq, this.jMa.position, 11, this.jMa.field_appId, this.hop, this.jMa.bHF, this.jMa.jLt);
            return;
        }
        x.e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
    }
}
