package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd.d;
import com.tencent.mm.storage.bo;

class ShakeSayHiListUI$7 implements OnItemClickListener {
    final /* synthetic */ ShakeSayHiListUI nbq;

    ShakeSayHiListUI$7(ShakeSayHiListUI shakeSayHiListUI) {
        this.nbq = shakeSayHiListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bo boVar = (bo) ShakeSayHiListUI.b(this.nbq).getItem(i);
        if (boVar != null && boVar.field_content != null) {
            d YY = d.YY(boVar.field_content);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", YY.otZ);
            intent.putExtra("Contact_Encryptusername", YY.tbT);
            intent.putExtra("Contact_Alias", YY.cCR);
            intent.putExtra("Contact_Nick", YY.nickname);
            intent.putExtra("Contact_QuanPin", YY.eLA);
            intent.putExtra("Contact_PyInitial", YY.eLz);
            intent.putExtra("Contact_Sex", YY.sex);
            intent.putExtra("Contact_Signature", YY.signature);
            intent.putExtra("Contact_Scene", YY.scene);
            intent.putExtra("Contact_FMessageCard", true);
            intent.putExtra("Contact_City", YY.getCity());
            intent.putExtra("Contact_Province", YY.getProvince());
            intent.putExtra("Contact_Content", bi.oW(boVar.field_sayhicontent) ? this.nbq.getString(R.l.chatting_from_verify_lbs_tip) : boVar.field_sayhicontent);
            intent.putExtra("Contact_verify_Scene", YY.scene);
            intent.putExtra("Contact_Uin", YY.lWQ);
            intent.putExtra("Contact_QQNick", YY.eLB);
            intent.putExtra("Contact_Mobile_MD5", YY.tbE);
            intent.putExtra("User_From_Fmessage", true);
            intent.putExtra("Contact_from_msgType", 37);
            intent.putExtra("Verify_ticket", YY.juZ);
            intent.putExtra("Contact_ShowFMessageList", true);
            intent.putExtra("Contact_Source_FMessage", YY.scene);
            au.HU();
            ab Yg = c.FR().Yg(YY.otZ);
            if (!(Yg == null || ((int) Yg.dhP) < 0 || a.gd(Yg.field_type))) {
                int i2 = YY.bOh;
                if (i2 == 0 || i2 == 2 || i2 == 5) {
                    intent.putExtra("User_Verify", true);
                }
                intent.putExtra("Contact_IsLBSFriend", true);
                intent.putExtra("Sns_from_Scene", 18);
            }
            com.tencent.mm.plugin.shake.a.ezn.d(intent, this.nbq);
        }
    }
}
