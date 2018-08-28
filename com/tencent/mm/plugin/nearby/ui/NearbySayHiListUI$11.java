package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.be.a;
import com.tencent.mm.g.a.i;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bd.d;

class NearbySayHiListUI$11 implements OnItemClickListener {
    final /* synthetic */ NearbySayHiListUI lCB;

    NearbySayHiListUI$11(NearbySayHiListUI nearbySayHiListUI) {
        this.lCB = nearbySayHiListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (NearbySayHiListUI.d(this.lCB).getHeaderViewsCount() > 0) {
            i -= NearbySayHiListUI.d(this.lCB).getHeaderViewsCount();
        }
        ba baVar = (ba) NearbySayHiListUI.b(this.lCB).getItem(i);
        if (baVar != null && baVar.field_content != null) {
            d YY = d.YY(baVar.field_content);
            Intent intent = new Intent();
            if (a.cbf()) {
                intent.putExtra("Chat_User", baVar.field_sayhiencryptuser);
                intent.putExtra("lbs_mode", true);
                intent.putExtra("add_scene", 18);
                com.tencent.mm.plugin.nearby.a.ezn.e(intent, this.lCB);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", bi.oW(YY.otZ) ? baVar.field_sayhiuser : YY.otZ);
                intent2.putExtra("Contact_Alias", YY.cCR);
                intent2.putExtra("Contact_Nick", YY.nickname);
                intent2.putExtra("Contact_QuanPin", YY.eLA);
                intent2.putExtra("Contact_PyInitial", YY.eLz);
                intent2.putExtra("Contact_Sex", YY.sex);
                intent2.putExtra("Contact_Signature", YY.signature);
                intent2.putExtra("Contact_Scene", YY.scene);
                intent2.putExtra("Contact_FMessageCard", true);
                intent2.putExtra("Contact_City", YY.getCity());
                intent2.putExtra("Contact_Province", YY.getProvince());
                intent2.putExtra("Contact_Content", bi.oW(baVar.field_sayhicontent) ? this.lCB.getString(R.l.chatting_from_verify_lbs_tip) : baVar.field_sayhicontent);
                intent2.putExtra("Contact_verify_Scene", YY.scene);
                intent2.putExtra("Contact_Uin", YY.lWQ);
                intent2.putExtra("Contact_QQNick", YY.eLB);
                intent2.putExtra("Contact_Mobile_MD5", YY.tbE);
                intent2.putExtra("User_From_Fmessage", true);
                intent2.putExtra("Contact_from_msgType", 37);
                intent2.putExtra("Verify_ticket", YY.juZ);
                intent2.putExtra("Contact_Source_FMessage", YY.scene);
                intent2.putExtra("Contact_ShowFMessageList", true);
                au.HU();
                ab Yg = c.FR().Yg(YY.otZ);
                if (!(Yg == null || ((int) Yg.dhP) < 0 || com.tencent.mm.l.a.gd(Yg.field_type))) {
                    int i2 = YY.bOh;
                    if (i2 == 0 || i2 == 2 || i2 == 5) {
                        intent2.putExtra("User_Verify", true);
                    }
                    intent2.putExtra("Contact_IsLBSFriend", true);
                    intent2.putExtra("Sns_from_Scene", 18);
                }
                com.tencent.mm.plugin.nearby.a.ezn.d(intent2, this.lCB);
            }
            i iVar = new i();
            iVar.bGn.scene = YY.scene;
            com.tencent.mm.sdk.b.a.sFg.m(iVar);
        }
    }
}
