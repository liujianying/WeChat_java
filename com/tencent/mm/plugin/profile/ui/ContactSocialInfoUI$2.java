package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.profile.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h.c;

class ContactSocialInfoUI$2 implements c {
    final /* synthetic */ ContactSocialInfoUI lVD;
    final /* synthetic */ String[] lVE;

    ContactSocialInfoUI$2(ContactSocialInfoUI contactSocialInfoUI, String[] strArr) {
        this.lVD = contactSocialInfoUI;
        this.lVE = strArr;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                if (ContactSocialInfoUI.a(this.lVD) != null && ContactSocialInfoUI.a(this.lVD).length() != 0) {
                    int lastIndexOf = ContactSocialInfoUI.a(this.lVD).lastIndexOf(32) + 1;
                    if (lastIndexOf > 0) {
                        ContactSocialInfoUI.a(this.lVD, ContactSocialInfoUI.a(this.lVD).substring(lastIndexOf));
                        return;
                    }
                    return;
                }
                return;
            case 1:
                if (ContactSocialInfoUI.a(this.lVD) != null && ContactSocialInfoUI.a(this.lVD).length() != 0) {
                    String substring = ContactSocialInfoUI.a(this.lVD).substring(0, ContactSocialInfoUI.a(this.lVD).lastIndexOf(32));
                    if (substring != null && substring.length() != 0) {
                        s.b(ContactSocialInfoUI.b(this.lVD), substring.trim());
                        return;
                    }
                    return;
                }
                return;
            case 2:
                if (this.lVE != null && this.lVE.length > 2 && ContactSocialInfoUI.c(this.lVD) != null && ContactSocialInfoUI.b(this.lVD) != null) {
                    if (!(ContactSocialInfoUI.c(this.lVD) == null || bi.oW(ContactSocialInfoUI.c(this.lVD).dHL))) {
                        ContactSocialInfoUI.a(this.lVD, ContactSocialInfoUI.b(this.lVD).field_username, ContactSocialInfoUI.c(this.lVD).dHL);
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
        a.ezn.k(intent, this.lVD);
    }
}
