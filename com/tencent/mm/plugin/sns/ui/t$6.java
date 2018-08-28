package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

class t$6 implements d {
    final /* synthetic */ int hW;
    final /* synthetic */ t nNL;
    final /* synthetic */ n nNM;
    final /* synthetic */ ate nmM;

    t$6(t tVar, n nVar, ate ate, int i) {
        this.nNL = tVar;
        this.nNM = nVar;
        this.nmM = ate;
        this.hW = i;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int itemId = menuItem.getItemId();
        x.d("MicroMsg.GalleryTitleManager", "showAlert " + itemId);
        switch (itemId) {
            case 2:
                if (this.nNM != null && this.nNM.bAJ().sqc != null) {
                    if (this.nNM.field_type != 15) {
                        l.i(an.s(af.getAccSnsPath(), this.nmM.ksA) + i.l(this.nmM), this.nNL.context);
                        return;
                    } else {
                        t.NP(this.nNM.bBe());
                        return;
                    }
                }
                return;
            case 3:
                if (this.nNM != null && this.nNM.bAJ().sqc != null) {
                    if (this.nNM.bAJ().sqc.ruz == 1) {
                        this.nNL.NO(an.s(af.getAccSnsPath(), this.nmM.ksA) + i.l(this.nmM));
                        return;
                    }
                    t.NQ(this.nNM.bBe());
                    return;
                }
                return;
            case 4:
                t tVar = this.nNL;
                long j = this.nNM.field_snsId;
                n fi = af.byo().fi(j);
                if (j != 0 && fi != null) {
                    Intent intent = new Intent();
                    intent.putExtra("k_username", fi.field_userName);
                    intent.putExtra("k_expose_msg_id", j);
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                    com.tencent.mm.bg.d.b(tVar.context, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                }
                return;
            case 6:
                if (this.nNM != null && this.nNM.bAJ().sqc != null) {
                    t.a(this.nNL, this.nNM, this.nmM);
                    return;
                }
                return;
            case 7:
                Bundle bundle = new Bundle();
                bundle.putString("stat_msg_id", "sns_" + i.eF(this.nNM.field_snsId));
                bundle.putString("stat_send_msg_user", this.nNM.field_userName);
                bundle.putInt("stat_scene", 3);
                t.a(this.nNL, bundle);
                return;
            case 8:
                t.a(this.nNL, this.nNM, this.nmM, this.hW);
                return;
            default:
                return;
        }
    }
}
