package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.profile.a;
import com.tencent.mm.plugin.profile.ui.FriendPreference.1;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h.c;

class FriendPreference$1$1 implements c {
    final /* synthetic */ String[] lVE;
    final /* synthetic */ 1 lWU;

    FriendPreference$1$1(1 1, String[] strArr) {
        this.lWU = 1;
        this.lVE = strArr;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                if (this.lWU.lWS != null && this.lWU.lWS.length() != 0) {
                    int lastIndexOf = this.lWU.lWS.lastIndexOf(32) + 1;
                    if (lastIndexOf > 0) {
                        FriendPreference.a(this.lWU.lWT, this.lWU.lWS.substring(lastIndexOf));
                        return;
                    }
                    return;
                }
                return;
            case 1:
                if (this.lWU.lWS != null && this.lWU.lWS.length() != 0) {
                    String substring = this.lWU.lWS.substring(0, this.lWU.lWS.lastIndexOf(32));
                    if (substring != null && substring.length() != 0) {
                        s.b(FriendPreference.c(this.lWU.lWT), substring.trim());
                        return;
                    }
                    return;
                }
                return;
            case 2:
                if (this.lVE != null && this.lVE.length > 2 && FriendPreference.a(this.lWU.lWT) != null && FriendPreference.c(this.lWU.lWT) != null) {
                    if (!(FriendPreference.a(this.lWU.lWT) == null || bi.oW(FriendPreference.a(this.lWU.lWT).dHL))) {
                        FriendPreference.a(this.lWU.lWT, FriendPreference.c(this.lWU.lWT).field_username, FriendPreference.a(this.lWU.lWT).dHL);
                        return;
                    }
                }
                return;
                break;
            case 3:
                break;
            default:
                return;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("fromScene", 2);
        intent.putExtra("reportArgs", bundle);
        a.ezn.k(intent, FriendPreference.b(this.lWU.lWT));
    }
}
