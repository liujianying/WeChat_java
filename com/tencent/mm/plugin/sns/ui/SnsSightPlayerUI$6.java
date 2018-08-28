package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n$d;

class SnsSightPlayerUI$6 implements n$d {
    final /* synthetic */ SnsSightPlayerUI obb;

    SnsSightPlayerUI$6(SnsSightPlayerUI snsSightPlayerUI) {
        this.obb = snsSightPlayerUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case 1:
                intent = new Intent();
                n Nl = af.byo().Nl(SnsSightPlayerUI.d(this.obb));
                if (Nl != null) {
                    x.i("MicroMsg.SnsSightPlayerUI", "expose id " + Nl.bAK());
                }
                intent.putExtra("k_expose_msg_id", Nl == null ? Integer.valueOf(0) : Nl.bAK());
                intent.putExtra("k_username", Nl == null ? "" : Nl.field_userName);
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                d.b(this.obb, "webview", ".ui.tools.WebViewUI", intent);
                return;
            case 2:
                n Nl2 = af.byo().Nl(SnsSightPlayerUI.d(this.obb));
                if (Nl2 != null) {
                    ch chVar = new ch();
                    a.a(chVar, Nl2);
                    chVar.bJF.activity = this.obb;
                    chVar.bJF.bJM = 17;
                    com.tencent.mm.sdk.b.a.sFg.m(chVar);
                    if (SnsSightPlayerUI.i(this.obb)) {
                        c cVar = new c(Nl2.bBn(), 11, 5, "", 2, SnsSightPlayerUI.a(this.obb).bAK());
                        g.Ek();
                        g.Eh().dpP.a(cVar, 0);
                        j.a(j.d.nke, j.c.njZ, e.nkl, 0, Nl2);
                    }
                    if (SnsSightPlayerUI.e(this.obb) == 0) {
                        pt ptVar = new pt();
                        ptVar.caz.bKW = Nl2.bBe();
                        ptVar.caz.bSZ = i.g(Nl2);
                        com.tencent.mm.sdk.b.a.sFg.m(ptVar);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                SnsSightPlayerUI.u(this.obb);
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_Type", 3);
                intent2.putExtra("select_is_ret", true);
                intent2.putExtra("mutil_select_is_ret", true);
                intent2.putExtra("image_path", SnsSightPlayerUI.c(this.obb));
                intent2.putExtra("Retr_Msg_Type", 11);
                d.b(this.obb, ".ui.transmit.SelectConversationUI", intent2, 4097);
                return;
            case 4:
                n Nl3 = af.byo().Nl(SnsSightPlayerUI.d(this.obb));
                if (Nl3 != null) {
                    intent = new Intent();
                    if (Nl3.bAJ().sqc.ruz == 15 && ((ate) Nl3.bAJ().sqc.ruA.get(0)) == null) {
                        x.w("MicroMsg.SnsSightPlayerUI", "send sight fail, mediaObj is null");
                        return;
                    }
                    intent.putExtra("exdevice_open_scene_type", 2);
                    intent.putExtra("sns_local_id", SnsSightPlayerUI.d(this.obb));
                    intent.putExtra("sns_send_data_ui_activity", true);
                    d.e(this.obb, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
