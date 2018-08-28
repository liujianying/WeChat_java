package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.j;

class NormalUserFooterPreference$j$1 implements OnClickListener {
    final /* synthetic */ j lXQ;

    NormalUserFooterPreference$j$1(j jVar) {
        this.lXQ = jVar;
    }

    public final void onClick(View view) {
        NormalUserFooterPreference.b(this.lXQ.lXw).getIntent().removeExtra("Accept_NewFriend_FromOutside");
        Intent intent = new Intent(NormalUserFooterPreference.b(this.lXQ.lXw), SayHiWithSnsPermissionUI.class);
        intent.putExtra("Contact_User", NormalUserFooterPreference.a(this.lXQ.lXw).field_username);
        intent.putExtra("Contact_Nick", NormalUserFooterPreference.a(this.lXQ.lXw).field_nickname);
        intent.putExtra("Contact_RemarkName", NormalUserFooterPreference.a(this.lXQ.lXw).field_conRemark);
        if (NormalUserFooterPreference.l(this.lXQ.lXw) == 14 || NormalUserFooterPreference.l(this.lXQ.lXw) == 8) {
            intent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(this.lXQ.lXw).getIntent().getStringExtra("Contact_RoomNickname"));
        }
        intent.putExtra("Contact_Scene", NormalUserFooterPreference.l(this.lXQ.lXw));
        intent.putExtra("Verify_ticket", NormalUserFooterPreference.y(this.lXQ.lXw));
        intent.putExtra("sayhi_with_sns_perm_send_verify", false);
        intent.putExtra("sayhi_with_sns_perm_add_remark", true);
        intent.putExtra("sayhi_with_sns_perm_set_label", true);
        NormalUserFooterPreference.b(this.lXQ.lXw).startActivity(intent);
    }
}
