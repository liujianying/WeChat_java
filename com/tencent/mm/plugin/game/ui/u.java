package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.be;
import com.tencent.mm.plugin.game.model.be.a;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class u implements OnClickListener {
    private d jNE;
    int jNv = 0;
    String jTR = null;
    private int kcO;
    private Context mContext;

    public u(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof d) {
            this.jNE = (d) view.getTag();
            x.i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.jNE.field_appId);
            if (g.r(this.mContext, this.jNE.field_appId)) {
                x.d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.jNE.field_appId + ", pkg = " + this.jNE.field_packageName + ", openId = " + this.jNE.field_openId);
                an.a(this.mContext, this.jNE.scene, this.jNE.bYq, this.jNE.position, 3, this.jNE.field_appId, this.jNv, this.jTR);
                f.ah(this.mContext, this.jNE.field_appId);
                return;
            }
            int i;
            be.aUD();
            String str = this.jNE.cmP;
            if (bi.oW(str)) {
                x.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
                i = -1;
            } else {
                i = be.a(new a((byte) 0).Dz(str));
            }
            this.kcO = i;
            str = this.jNE.cmP;
            if (!bi.oW(str)) {
                str = str.replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
            }
            if (this.jNE.status == 3) {
                be.aUD();
                be.startToAuthorized(this.mContext, str);
            } else {
                be.aUD();
                be.am(this.mContext, str);
            }
            i = 5;
            if (this.jNE.status == 3) {
                i = 10;
            }
            an.a(this.mContext, this.jNE.scene, this.jNE.bYq, this.jNE.position, this.kcO == 4 ? 8 : i, this.jNE.field_appId, this.jNv, this.jNE.bHF, this.jTR);
            return;
        }
        x.e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
    }
}
