package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import com.tencent.mm.ui.base.n.d;

class FlipView$4 implements d {
    final /* synthetic */ String fQh;
    final /* synthetic */ String fYI;
    final /* synthetic */ FlipView nNe;
    final /* synthetic */ String sl;

    FlipView$4(FlipView flipView, String str, String str2, String str3) {
        this.nNe = flipView;
        this.fQh = str;
        this.fYI = str2;
        this.sl = str3;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        n Nl = af.byo().Nl(this.fQh);
        if (Nl == null) {
            x.i("MicroMsg.FlipView", "error beacause info null");
            return;
        }
        n Nl2;
        switch (menuItem.getItemId()) {
            case 0:
                if (Nl.field_type != 15) {
                    l.i(this.fYI, FlipView.e(this.nNe));
                    return;
                } else {
                    FlipView.NL(this.fQh);
                    return;
                }
            case 1:
                if (Nl.field_type != 15) {
                    Intent intent = new Intent();
                    intent.putExtra("Retr_File_Name", this.fYI);
                    intent.putExtra("Retr_Compress_Type", 0);
                    intent.putExtra("Retr_Msg_Type", 0);
                    if (Nl != null) {
                        intent.putExtra("Retr_FromMainTimeline", this.nNe.bBX());
                        intent.putExtra("Retr_KSnsId", i.g(Nl));
                    }
                    a.ezn.l(intent, FlipView.e(this.nNe));
                    return;
                }
                new StringBuilder().append(an.s(af.getAccSnsPath(), this.sl)).append(i.e((ate) Nl.bAJ().sqc.ruA.get(0)));
                FlipView.NM(this.fQh);
                return;
            case 2:
                ch chVar;
                pt ptVar;
                if (Nl.field_type != 15) {
                    chVar = new ch();
                    String str = this.fQh;
                    String str2 = this.sl;
                    if (str2 == null || bi.oW(str)) {
                        x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
                        chVar.bJF.bJL = j.favorite_fail_argument_error;
                    } else if (af.bxX()) {
                        x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                        chVar.bJF.bJL = j.favorite_fail_system_error;
                    } else {
                        Nl2 = af.byo().Nl(str);
                        if (Nl2 == null) {
                            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                            chVar.bJF.bJL = j.favorite_fail_attachment_not_exists;
                        } else {
                            com.tencent.mm.plugin.sns.i.a.a(chVar, Nl2, str2);
                        }
                    }
                    chVar.bJF.bJM = 13;
                    chVar.bJF.activity = (Activity) FlipView.e(this.nNe);
                    com.tencent.mm.sdk.b.a.sFg.m(chVar);
                    if (this.nNe.bBX()) {
                        ptVar = new pt();
                        ptVar.caz.bSZ = i.g(Nl);
                        ptVar.caz.bKW = Nl.bBe();
                        com.tencent.mm.sdk.b.a.sFg.m(ptVar);
                        return;
                    }
                    return;
                } else if (Nl != null) {
                    if (Nl.xb(32)) {
                        chVar = new ch();
                        com.tencent.mm.plugin.sns.i.a.a(chVar, Nl);
                        chVar.bJF.bJM = 14;
                        chVar.bJF.activity = (Activity) FlipView.e(this.nNe);
                        com.tencent.mm.sdk.b.a.sFg.m(chVar);
                    } else {
                        FlipView.o(this.nNe.bBX(), Nl.bBe());
                    }
                    if (this.nNe.bBX()) {
                        ptVar = new pt();
                        ptVar.caz.bSZ = i.g(Nl);
                        ptVar.caz.bKW = Nl.bBe();
                        com.tencent.mm.sdk.b.a.sFg.m(ptVar);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case 3:
                Intent intent2 = new Intent();
                intent2.putExtra("k_expose_msg_id", this.nNe.getSnsId());
                Nl2 = af.byo().fi(this.nNe.getSnsId());
                intent2.putExtra("k_username", Nl2 == null ? "" : Nl2.field_userName);
                intent2.putExtra("showShare", false);
                intent2.putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect33");
                intent2.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                com.tencent.mm.bg.d.b(FlipView.e(this.nNe), "webview", ".ui.tools.WebViewUI", intent2);
                return;
            case 4:
                x.i("MicroMsg.FlipView", "request deal QBAR string");
                cb cbVar = new cb();
                cbVar.bJq.activity = (Activity) FlipView.e(this.nNe);
                cbVar.bJq.bHL = FlipView.f(this.nNe);
                cbVar.bJq.bJr = FlipView.g(this.nNe);
                cbVar.bJq.bJs = FlipView.h(this.nNe);
                ate a = aj.a(Nl, this.sl);
                if (a != null) {
                    cbVar.bJq.imagePath = a.jPK;
                    cbVar.bJq.bJw = a.rVV;
                }
                cbVar.bJq.scene = 38;
                if (FlipView.e(this.nNe) instanceof Activity) {
                    cbVar.bJq.bJx = ((Activity) FlipView.e(this.nNe)).getIntent().getBundleExtra("_stat_obj");
                }
                if (this.nNe instanceof SnsInfoFlip) {
                    SnsInfoFlip snsInfoFlip = (SnsInfoFlip) this.nNe;
                    av fromScene = snsInfoFlip.getFromScene();
                    x.d("MicroMsg.FlipView", "from Scene: %s", new Object[]{fromScene.tag});
                    if (fromScene.tag.equals(av.tbn.tag) || fromScene.tag.equals(av.tbo.tag) || fromScene.tag.equals(av.tbp.tag)) {
                        cbVar.bJq.bJt = 5;
                        if (bi.oW(snsInfoFlip.username)) {
                            x.i("MicroMsg.FlipView", "empty username");
                            snsInfoFlip.username = "";
                        }
                        cbVar.bJq.bhd = snsInfoFlip.username;
                    } else if (fromScene.tag.equals(av.tbm.tag)) {
                        cbVar.bJq.bJt = 3;
                    } else {
                        x.i("MicroMsg.FlipView", "other scene_from: %s", new Object[]{fromScene.tag});
                    }
                }
                com.tencent.mm.sdk.b.a.sFg.m(cbVar);
                return;
            case 5:
                if (Nl.bAJ().sqc.ruA.size() != 0) {
                    Intent intent3 = new Intent();
                    if (Nl.field_type == 1) {
                        int position = this.nNe.getPosition();
                        int size = Nl.bAJ().sqc.ruA.size();
                        if (size <= 1 || position <= 1 || position > size) {
                            position = 0;
                        } else {
                            position--;
                        }
                        String g = FlipView.g(this.fYI, FlipView.e(this.nNe));
                        if (g != null) {
                            intent3.putExtra("sns_send_data_ui_image_path", g);
                            intent3.putExtra("sns_send_data_ui_image_position", position);
                        } else {
                            return;
                        }
                    }
                    intent3.putExtra("sns_send_data_ui_activity", true);
                    intent3.putExtra("sns_local_id", this.fQh);
                    com.tencent.mm.bg.d.e(FlipView.e(this.nNe), ".ui.chatting.ChattingSendDataToDeviceUI", intent3);
                    return;
                }
                return;
            case 6:
                this.nNe.NK(this.fYI);
                return;
            default:
                return;
        }
    }
}
