package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.ui.e.a;

class NormalUserFooterPreference$c$4 implements b {
    final /* synthetic */ c lXI;
    final /* synthetic */ String lXJ;
    final /* synthetic */ String lXK;

    NormalUserFooterPreference$c$4(c cVar, String str, String str2) {
        this.lXI = cVar;
        this.lXJ = str;
        this.lXK = str2;
    }

    public final boolean pm(String str) {
        String stringExtra = NormalUserFooterPreference.b(this.lXI.lXw).getIntent().getStringExtra("room_name");
        Intent intent = new Intent(NormalUserFooterPreference.b(this.lXI.lXw), SayHiWithSnsPermissionUI.class);
        intent.putExtra("Contact_User", NormalUserFooterPreference.a(this.lXI.lXw).field_username);
        intent.putExtra("Contact_Nick", NormalUserFooterPreference.a(this.lXI.lXw).field_nickname);
        intent.putExtra("Contact_RemarkName", NormalUserFooterPreference.a(this.lXI.lXw).field_conRemark);
        if (NormalUserFooterPreference.l(this.lXI.lXw) == 14 || NormalUserFooterPreference.l(this.lXI.lXw) == 8) {
            intent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(this.lXI.lXw).getIntent().getStringExtra("Contact_RoomNickname"));
        }
        intent.putExtra("Contact_Scene", NormalUserFooterPreference.l(this.lXI.lXw));
        intent.putExtra("room_name", stringExtra);
        intent.putExtra("source_from_user_name", this.lXJ);
        intent.putExtra("source_from_nick_name", this.lXK);
        intent.putExtra("sayhi_with_sns_perm_send_verify", true);
        intent.putExtra("sayhi_with_sns_perm_add_remark", true);
        intent.putExtra("sayhi_with_sns_perm_set_label", false);
        intent.putExtra(a.ths, str);
        NormalUserFooterPreference.b(this.lXI.lXw).startActivity(intent);
        return true;
    }
}
