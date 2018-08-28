package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

class FriendPreference$1 implements OnClickListener {
    final /* synthetic */ String lWS;
    final /* synthetic */ FriendPreference lWT;

    FriendPreference$1(FriendPreference friendPreference, String str) {
        this.lWT = friendPreference;
        this.lWS = str;
    }

    public final void onClick(View view) {
        String[] stringArray;
        if (FriendPreference.a(this.lWT) == null || bi.oW(FriendPreference.a(this.lWT).dHL)) {
            stringArray = FriendPreference.b(this.lWT).getResources().getStringArray(R.c.profile_alert_short);
        } else {
            stringArray = FriendPreference.b(this.lWT).getResources().getStringArray(R.c.profile_alert_all);
        }
        if (a.ezo.vq()) {
            List F = bi.F(stringArray);
            F.add(FriendPreference.b(this.lWT).getResources().getString(R.l.chatting_phone_download_wxpb));
            stringArray = (String[]) F.toArray(new String[F.size()]);
            h.mEJ.h(11621, new Object[]{Integer.valueOf(2), Integer.valueOf(3)});
        }
        com.tencent.mm.ui.base.h.a(FriendPreference.b(this.lWT), null, stringArray, null, new 1(this, stringArray));
    }
}
