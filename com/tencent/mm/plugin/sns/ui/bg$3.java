package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class bg$3 implements OnClickListener {
    final /* synthetic */ bg ohJ;

    bg$3(bg bgVar) {
        this.ohJ = bgVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
        if (view.getTag() instanceof r) {
            r rVar = (r) view.getTag();
            bsu bsu = rVar.nMH;
            n Nl = af.byo().Nl(rVar.bKW);
            if (this.ohJ.nMm != null) {
                this.ohJ.nMm.bxT().v(Nl);
            }
            if (bsu.sqi == null) {
                x.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
                return;
            }
            String str = bsu.sqi.username;
            String str2 = bsu.sqi.path;
            x.i("MicroMsg.TimeLineClickEvent", "username: " + str + "pagepath: " + str2);
            qu quVar = new qu();
            quVar.cbq.userName = str;
            quVar.cbq.cbs = str2;
            quVar.cbq.scene = 1009;
            quVar.cbq.bGG = bsu.ksA + ":" + bsu.hbL;
            Bundle bundle = new Bundle();
            bundle.putString("stat_send_msg_user", Nl.field_userName);
            bundle.putString("stat_msg_id", "sns_" + i.eF(Nl.field_snsId));
            a.sFg.m(quVar);
        }
    }
}
