package com.tencent.mm.plugin.profile.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aa.g;
import com.tencent.mm.aa.g.b;
import com.tencent.mm.aa.q;
import com.tencent.mm.sdk.platformtools.x;

class FriendPreference$2 implements b {
    final /* synthetic */ g dGE;
    final /* synthetic */ String dhF;
    final /* synthetic */ String lVF;
    final /* synthetic */ FriendPreference lWT;

    FriendPreference$2(FriendPreference friendPreference, g gVar, String str, String str2) {
        this.lWT = friendPreference;
        this.dGE = gVar;
        this.dhF = str;
        this.lVF = str2;
    }

    public final int bd(int i, int i2) {
        this.dGE.Ku();
        x.i("MicroMsg.FriendPreference", "onSceneEnd: errType=%d, errCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            if (FriendPreference.a(this.lWT, this.lVF, q.Kp().jU(this.dhF))) {
                Toast.makeText(this.lWT.mContext, this.lWT.mContext.getString(R.l.contact_info_save_avater_ok), 0).show();
                return 0;
            }
        }
        Toast.makeText(this.lWT.mContext, this.lWT.mContext.getString(R.l.contact_info_save_avater_fail), 0).show();
        return 0;
    }
}
