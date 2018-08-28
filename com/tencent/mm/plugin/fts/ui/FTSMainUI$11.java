package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

class FTSMainUI$11 implements e {
    final /* synthetic */ FTSMainUI jxp;
    final /* synthetic */ String jxq;

    FTSMainUI$11(FTSMainUI fTSMainUI, String str) {
        this.jxp = fTSMainUI;
        this.jxq = str;
    }

    public final void a(int i, int i2, String str, l lVar) {
        g.DF().b(f$k.AppCompatTheme_ratingBarStyle, this);
        if (i == 4 && i2 == -4) {
            FTSMainUI.i(this.jxp);
            h.a(this.jxp, n$g.search_contact_not_found, 0, true, null);
            return;
        }
        FTSMainUI.i(this.jxp);
        if (i == 0 && i2 == 0) {
            bja bcS = ((f) lVar).bcS();
            Intent intent;
            if (bcS.rHb > 0) {
                if (bcS.rHc.isEmpty()) {
                    h.a(this.jxp, n$g.search_contact_not_found, 0, true, null);
                    return;
                }
                intent = new Intent();
                ((com.tencent.mm.api.h) g.l(com.tencent.mm.api.h.class)).a(intent, (biy) bcS.rHc.getFirst(), this.jxp.jvZ);
                d.b(this.jxp, "profile", ".ui.ContactInfoUI", intent);
                return;
            } else if (bi.oV(ab.a(bcS.rvi)).length() > 0) {
                if (2 == bcS.sjj) {
                    this.jxp.jvZ = 15;
                } else if (1 == bcS.sjj) {
                    this.jxp.jvZ = 1;
                }
                intent = new Intent();
                ((com.tencent.mm.api.h) g.l(com.tencent.mm.api.h.class)).a(intent, bcS, this.jxp.jvZ);
                if (this.jxp.jvZ == 15) {
                    intent.putExtra("Contact_Search_Mobile", this.jxq.trim());
                }
                intent.putExtra("add_more_friend_search_scene", 2);
                d.b(this.jxp, "profile", ".ui.ContactInfoUI", intent);
                return;
            } else {
                return;
            }
        }
        switch (i2) {
            case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                a eV = a.eV(str);
                if (eV != null) {
                    h.a(this.jxp, eV.desc, eV.bHD, true, null);
                    break;
                }
                break;
            case -4:
                Toast.makeText(this.jxp, this.jxp.getString(n$g.search_contact_err_no_code), 0).show();
                break;
        }
        x.w("MicroMsg.FTS.FTSMainUI", String.format("Search contact failed: %d, %d.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
    }
}
