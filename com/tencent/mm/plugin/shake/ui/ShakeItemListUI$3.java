package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.an.b;
import com.tencent.mm.an.c;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.model.au;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

class ShakeItemListUI$3 implements OnItemClickListener {
    final /* synthetic */ ShakeItemListUI mZA;
    final /* synthetic */ int mZC;

    ShakeItemListUI$3(ShakeItemListUI shakeItemListUI, int i) {
        this.mZA = shakeItemListUI;
        this.mZC = i;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar = (d) ShakeItemListUI.b(this.mZA).getItem(i);
        if (dVar != null) {
            e buC = m.buC();
            if (dVar == null) {
                x.w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
            } else {
                dVar.field_insertBatch = 1;
                dVar.bWA = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                if (-1 != buC.diF.update("shakeitem1", dVar.wH(), "shakeItemID=? and insertBatch=?", new String[]{dVar.field_shakeItemID, "2"})) {
                    buC.doNotify();
                }
            }
            int i2 = dVar.field_type;
            Intent intent;
            if (i2 == 4) {
                intent = new Intent();
                if (c.Qh()) {
                    b.b(i.c(dVar.field_lvbuffer, 0));
                } else {
                    b.PW();
                    intent.putExtra("key_mode", 1);
                    intent.putExtra("KGlobalShakeMusic", true);
                    b.c(i.c(dVar.field_lvbuffer, 0));
                }
                intent.putExtra("key_scene", 3);
                com.tencent.mm.bg.d.b(this.mZA, "music", ".ui.MusicMainUI", intent);
            } else if (i2 == 11) {
                if (System.currentTimeMillis() - this.mZA.mZx > 2000) {
                    this.mZA.mZx = System.currentTimeMillis();
                    if (dVar.field_reserved3 == null || dVar.field_reserved3.split(",").length != 3 || dVar.field_reserved3.split(",")[0] == null || dVar.field_reserved3.split(",")[0].equals("")) {
                        intent = new Intent();
                        intent.putExtra("rawUrl", dVar.getCity());
                        intent.putExtra("scene", 27);
                        intent.putExtra("stastic_scene", 5);
                        com.tencent.mm.bg.d.b(ad.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    } else {
                        String[] split = dVar.field_reserved3.split(",");
                        qu quVar = new qu();
                        quVar.cbq.userName = split[0];
                        quVar.cbq.cbs = bi.aG(split[1], "");
                        quVar.cbq.cbt = Integer.parseInt(split[2]);
                        quVar.cbq.scene = 1077;
                        a.sFg.m(quVar);
                    }
                    if (ShakeItemListUI.d(this.mZA)) {
                        h.a(dVar);
                        h.b(dVar);
                    }
                }
            } else if (k.vY(i2)) {
                k.a(dVar, this.mZA, true);
            } else {
                String str = dVar.field_username;
                au.HU();
                ab Yg = com.tencent.mm.model.c.FR().Yg(str);
                x.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + str + " display:" + dVar.field_nickname + " position:" + i + " contactName" + Yg.field_username);
                x.d("MicroMsg.ShakeItemListUI", "isContact:" + com.tencent.mm.l.a.gd(Yg.field_type) + "  contact:" + Yg);
                if (com.tencent.mm.l.a.gd(Yg.field_type)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", str);
                    intent2.putExtra("Contact_Scene", this.mZC == dVar.field_sex ? 23 : 24);
                    intent2.putExtra("Sns_from_Scene", 22);
                    if (str != null && str.length() > 0) {
                        if (Yg.ckW()) {
                            com.tencent.mm.plugin.report.service.h.mEJ.k(10298, dVar.field_username + "," + intent2.getIntExtra("Contact_Scene", 23));
                            intent2.putExtra("Contact_Scene", 23);
                        }
                        com.tencent.mm.plugin.shake.a.ezn.d(intent2, this.mZA);
                        return;
                    }
                    return;
                }
                x.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + str + " display:" + dVar.field_nickname + " position:" + i + " contactName" + Yg.field_username);
                Intent intent3 = new Intent();
                intent3.putExtra("Contact_User", dVar.field_username);
                intent3.putExtra("Contact_Nick", dVar.field_nickname);
                intent3.putExtra("Contact_Distance", dVar.field_distance);
                intent3.putExtra("Contact_Signature", dVar.field_signature);
                intent3.putExtra("Contact_Province", dVar.getProvince());
                intent3.putExtra("Contact_City", dVar.getCity());
                intent3.putExtra("Contact_Sex", dVar.field_sex);
                intent3.putExtra("Contact_IsLBSFriend", true);
                intent3.putExtra("Contact_VUser_Info", dVar.field_reserved3);
                intent3.putExtra("Contact_VUser_Info_Flag", dVar.field_reserved1);
                intent3.putExtra("Contact_Scene", this.mZC == dVar.field_sex ? 23 : 24);
                intent3.putExtra("Sns_from_Scene", 22);
                intent3.putExtra("Contact_KSnsIFlag", dVar.field_snsFlag);
                intent3.putExtra("Contact_KSnsBgUrl", dVar.field_sns_bgurl);
                if ((dVar.field_reserved1 & 8) > 0) {
                    com.tencent.mm.plugin.report.service.h.mEJ.k(10298, dVar.field_username + "," + intent3.getIntExtra("Contact_Scene", 23));
                }
                com.tencent.mm.plugin.shake.a.ezn.d(intent3, this.mZA);
            }
        }
    }
}
