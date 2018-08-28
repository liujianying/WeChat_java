package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.be.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.g.a.pc;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;

class NearbyFriendsUI$10 implements OnItemClickListener {
    final /* synthetic */ NearbyFriendsUI lCf;

    NearbyFriendsUI$10(NearbyFriendsUI nearbyFriendsUI) {
        this.lCf = nearbyFriendsUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (NearbyFriendsUI.o(this.lCf) > 0 || NearbyFriendsUI.p(this.lCf) > 0) {
            i--;
        }
        if (a.cbf() && NearbyFriendsUI.m(this.lCf) != null) {
            i--;
        }
        if (NearbyFriendsUI.q(this.lCf)) {
            i--;
        }
        if (i >= 0 && i < NearbyFriendsUI.r(this.lCf).size()) {
            aqp aqp = (aqp) NearbyFriendsUI.r(this.lCf).get(i);
            Intent intent;
            if (c.tR(aqp.eJH)) {
                String b = c.b(aqp);
                x.d("MicroMsg.NearbyFriend", "poi item click, go:" + bi.oV(b));
                if (!bi.oW(b)) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", b);
                    intent.putExtra("geta8key_scene", 25);
                    intent.putExtra("stastic_scene", 12);
                    d.b(this.lCf.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                }
                return;
            }
            String str = aqp.hbL;
            au.HU();
            ai Yg = com.tencent.mm.model.c.FR().Yg(str);
            if (com.tencent.mm.l.a.gd(Yg.field_type)) {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", str);
                intent2.putExtra("Contact_Scene", 18);
                intent2.putExtra("Sns_from_Scene", 18);
                intent2.putExtra("lbs_ticket", aqp.rEJ);
                intent2.putExtra("Contact_IsLbsGotoChatting", true);
                if (str != null && str.length() > 0) {
                    if (Yg.ckW()) {
                        h.mEJ.k(10298, str + ",18");
                    }
                    pc pcVar = new pc();
                    pcVar.bZW.intent = intent2;
                    pcVar.bZW.username = str;
                    com.tencent.mm.sdk.b.a.sFg.m(pcVar);
                    com.tencent.mm.plugin.nearby.a.ezn.d(intent2, this.lCf);
                    return;
                }
                return;
            }
            intent = new Intent();
            intent.putExtra("Contact_User", aqp.hbL);
            intent.putExtra("Contact_Alias", aqp.eJM);
            intent.putExtra("Contact_Nick", aqp.hcS);
            intent.putExtra("Contact_Distance", aqp.rTd);
            intent.putExtra("Contact_Signature", aqp.eJK);
            intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aq(aqp.eJQ, aqp.eJI, aqp.eJJ));
            intent.putExtra("Contact_Sex", aqp.eJH);
            intent.putExtra("Contact_IsLBSFriend", true);
            intent.putExtra("Contact_Scene", 18);
            intent.putExtra("Contact_VUser_Info", aqp.rTf);
            intent.putExtra("Contact_VUser_Info_Flag", aqp.rTe);
            intent.putExtra("Contact_KWeibo_flag", aqp.rTi);
            intent.putExtra("Contact_KWeibo", aqp.rTg);
            intent.putExtra("Contact_KWeiboNick", aqp.rTh);
            intent.putExtra("Contact_KSnsIFlag", aqp.rTk.eJS);
            intent.putExtra("Contact_KSnsBgId", aqp.rTk.eJU);
            intent.putExtra("Contact_KSnsBgUrl", aqp.rTk.eJT);
            intent.putExtra("lbs_ticket", aqp.rEJ);
            intent.putExtra("Contact_IsLbsGotoChatting", true);
            if (aqp.eJR != null) {
                com.tencent.mm.ac.d dVar = new com.tencent.mm.ac.d();
                dVar.field_brandList = aqp.eJR;
                dVar.field_brandFlag = aqp.rTl.eJV;
                dVar.field_brandIconURL = aqp.rTl.eJY;
                dVar.field_extInfo = aqp.rTl.eJW;
                dVar.field_brandInfo = aqp.rTl.eJX;
                intent.putExtra("KBrandInfo_item", new MCacheItem(dVar));
            }
            intent.putExtra("Sns_from_Scene", 18);
            com.tencent.mm.plugin.nearby.a.ezn.d(intent, this.lCf);
        }
    }
}
