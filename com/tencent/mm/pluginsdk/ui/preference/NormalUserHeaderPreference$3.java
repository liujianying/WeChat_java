package com.tencent.mm.pluginsdk.ui.preference;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ab;

class NormalUserHeaderPreference$3 implements OnClickListener {
    final /* synthetic */ NormalUserHeaderPreference qPp;

    NormalUserHeaderPreference$3(NormalUserHeaderPreference normalUserHeaderPreference) {
        this.qPp = normalUserHeaderPreference;
    }

    public final void onClick(View view) {
        NormalUserHeaderPreference.c(this.qPp);
        NormalUserHeaderPreference normalUserHeaderPreference = this.qPp;
        au.HU();
        ab Yg = c.FR().Yg(normalUserHeaderPreference.guS.field_username);
        if (!(Yg == null || ((int) Yg.dhP) == 0 || !Yg.field_username.equals(normalUserHeaderPreference.guS.field_username))) {
            normalUserHeaderPreference.guS = Yg;
        }
        Intent intent;
        if (a.gd(normalUserHeaderPreference.guS.field_type)) {
            intent = new Intent();
            intent.setClassName(normalUserHeaderPreference.mContext, "com.tencent.mm.ui.contact.ContactRemarkInfoModUI");
            intent.putExtra("Contact_Scene", normalUserHeaderPreference.mZZ);
            intent.putExtra("Contact_User", normalUserHeaderPreference.guS.field_username);
            intent.putExtra("Contact_RoomNickname", normalUserHeaderPreference.bGc.getIntent().getStringExtra("Contact_RoomNickname"));
            ((Activity) normalUserHeaderPreference.mContext).startActivity(intent);
            return;
        }
        intent = new Intent();
        intent.setClassName(normalUserHeaderPreference.mContext, "com.tencent.mm.ui.contact.ModRemarkNameUI");
        intent.putExtra("Contact_Scene", normalUserHeaderPreference.mZZ);
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", normalUserHeaderPreference.guS.field_username);
        intent.putExtra("Contact_Nick", normalUserHeaderPreference.guS.field_nickname);
        intent.putExtra("Contact_RemarkName", normalUserHeaderPreference.guS.field_conRemark);
        ((Activity) normalUserHeaderPreference.mContext).startActivity(intent);
    }
}
