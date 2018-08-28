package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.e;

public final class q {
    public static void a(a aVar, String str, bd.a aVar2, a aVar3) {
        if (ab.XR(str)) {
            CharSequence g = ((b) g.l(b.class)).g(aVar2.tbI, "openim_card_type_name", b.a.eui);
            if (TextUtils.isEmpty(g)) {
                aVar3.ubY.setText(R.l.chatting_personal_card);
            } else {
                aVar3.ubY.setText(g);
            }
            aVar3.ubX.setBackgroundResource(R.g.default_avatar);
            b.r(aVar3.ubX, str);
            String str2 = aVar2.tbK;
            String str3 = aVar2.tbJ;
            if (ai.oW(str2)) {
                Object obj = str3;
            } else {
                g = ((b) g.l(b.class)).a(aVar.tTq.getContext(), str2, str3, aVar3.ubZ.getTextSize());
            }
            if (TextUtils.isEmpty(g)) {
                aVar3.ubZ.setVisibility(8);
                return;
            }
            aVar3.ubZ.setVisibility(0);
            aVar3.ubZ.setText(g);
        }
    }

    public static void a(a aVar, String str, String str2, boolean z, boolean z2) {
        if (z && z2) {
            str2 = com.tencent.mm.model.bd.iC(str2);
        }
        au.HU();
        bd.a GR = c.FT().GR(str2);
        if (GR != null) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", GR.otZ);
            intent.putExtra("Contact_Alias", GR.cCR);
            intent.putExtra("Contact_Nick", GR.nickname);
            intent.putExtra("Contact_QuanPin", GR.eLA);
            intent.putExtra("Contact_PyInitial", GR.eLz);
            intent.putExtra("Contact_Uin", GR.lWQ);
            intent.putExtra("Contact_Mobile_MD5", GR.tbE);
            intent.putExtra("Contact_full_Mobile_MD5", GR.tbF);
            intent.putExtra("Contact_QQNick", GR.cmJ());
            intent.putExtra("User_From_Fmessage", false);
            intent.putExtra("Contact_Scene", GR.scene);
            intent.putExtra("Contact_FMessageCard", true);
            intent.putExtra("Contact_RemarkName", GR.eLE);
            intent.putExtra("Contact_VUser_Info_Flag", GR.pOR);
            intent.putExtra("Contact_VUser_Info", GR.csP);
            intent.putExtra("Contact_BrandIconURL", GR.lUI);
            intent.putExtra("Contact_Province", GR.getProvince());
            intent.putExtra("Contact_City", GR.getCity());
            intent.putExtra("Contact_Sex", GR.sex);
            intent.putExtra("Contact_Signature", GR.signature);
            intent.putExtra("Contact_ShowUserName", true);
            intent.putExtra("Contact_KSnsIFlag", 0);
            intent.putExtra("Contact_Source_FMessage", 17);
            intent.putExtra("source_from_user_name", str);
            intent.putExtra("source_from_nick_name", r.gS(str));
            intent.putExtra(e.a.ths, GR.qOy);
            intent.putExtra("key_add_contact_openim_appid", GR.tbI);
            intent.putExtra("key_add_contact_custom_detail", GR.tbL);
            if ((GR.pOR & 8) > 0) {
                if (!ai.oW(str)) {
                    au.HU();
                    if (c.FR().Yg(str).ckW()) {
                        intent.putExtra("Contact_Scene", 41);
                        h.mEJ.k(10298, GR.otZ + ",41");
                    }
                }
                intent.putExtra("Contact_Scene", 17);
                h.mEJ.k(10298, GR.otZ + ",17");
            }
            if (ab.XR(GR.otZ) && GR.scene == 0) {
                intent.putExtra("Contact_Scene", 17);
            }
            d.b(aVar.tTq.getContext(), "profile", ".ui.ContactInfoUI", intent);
            com.tencent.mm.bh.a.Cy(GR.scene);
        }
    }
}
