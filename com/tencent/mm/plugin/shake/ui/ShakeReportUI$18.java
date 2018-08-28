package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l$b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;

class ShakeReportUI$18 implements OnClickListener {
    public long mZx = 0;
    final /* synthetic */ ShakeReportUI nbh;

    ShakeReportUI$18(ShakeReportUI shakeReportUI) {
        this.nbh = shakeReportUI;
    }

    public final void onClick(View view) {
        if (!bi.oW((String) ShakeReportUI.p(this.nbh).getTag()) && ShakeReportUI.L(this.nbh) != null) {
            d L = ShakeReportUI.L(this.nbh);
            String str = L.field_username;
            Intent intent;
            if (11 != L.field_type) {
                au.HU();
                ab Yg = c.FR().Yg(str);
                if (a.gd(Yg.field_type)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", str);
                    intent2.putExtra("Sns_from_Scene", 22);
                    if (str != null && str.length() > 0) {
                        if (Yg.ckW()) {
                            h.mEJ.k(10298, str + "," + ShakeReportUI.M(this.nbh));
                            intent2.putExtra("Contact_Scene", ShakeReportUI.M(this.nbh));
                        }
                        com.tencent.mm.plugin.shake.a.ezn.d(intent2, this.nbh);
                        return;
                    }
                    return;
                }
                if ((L.field_reserved1 & 8) > 0) {
                    h.mEJ.k(10298, L.field_username + "," + ShakeReportUI.M(this.nbh));
                }
                intent = new Intent();
                intent.putExtra("Contact_User", L.field_username);
                intent.putExtra("Contact_Nick", L.field_nickname);
                intent.putExtra("Contact_Distance", L.field_distance);
                intent.putExtra("Contact_Signature", L.field_signature);
                intent.putExtra("Contact_Province", L.getProvince());
                intent.putExtra("Contact_City", L.getCity());
                intent.putExtra("Contact_Sex", L.field_sex);
                intent.putExtra("Contact_IsLBSFriend", true);
                intent.putExtra("Contact_VUser_Info", L.field_reserved3);
                intent.putExtra("Contact_VUser_Info_Flag", L.field_reserved1);
                intent.putExtra("Contact_KSnsIFlag", L.field_snsFlag);
                intent.putExtra("Contact_KSnsBgUrl", L.field_sns_bgurl);
                intent.putExtra("Contact_Scene", ShakeReportUI.M(this.nbh));
                intent.putExtra("Sns_from_Scene", 22);
                com.tencent.mm.plugin.shake.a.ezn.d(intent, this.nbh);
            } else if (System.currentTimeMillis() - this.mZx > 3000) {
                this.mZx = System.currentTimeMillis();
                if (L.field_reserved3 == null || L.field_reserved3.split(",").length != 3 || L.field_reserved3.split(",")[0] == null || L.field_reserved3.split(",")[0].equals("")) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", L.getCity());
                    intent.putExtra("scene", 27);
                    intent.putExtra("stastic_scene", 5);
                    com.tencent.mm.bg.d.b(ad.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                } else {
                    String[] split = L.field_reserved3.split(",");
                    qu quVar = new qu();
                    quVar.cbq.userName = split[0];
                    quVar.cbq.cbs = bi.aG(split[1], "");
                    quVar.cbq.cbt = bi.getInt(split[2], 0);
                    quVar.cbq.scene = 1077;
                    com.tencent.mm.sdk.b.a.sFg.m(quVar);
                }
                l$b l_b = ShakeReportUI.C(this.nbh).mWP;
                if (l_b != null && (l_b instanceof com.tencent.mm.plugin.shake.d.a.h)) {
                    com.tencent.mm.plugin.shake.d.a.h.a(L);
                    com.tencent.mm.plugin.shake.d.a.h.b(L);
                }
            }
        }
    }
}
