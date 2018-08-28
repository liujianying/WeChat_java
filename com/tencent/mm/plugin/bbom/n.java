package com.tencent.mm.plugin.bbom;

import android.content.SharedPreferences;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

public final class n implements e {
    static n hex;

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 4 && !au.DF().foreground) {
            switch (i2) {
                case -999999:
                    new ag().post(new 1(this));
                    return;
                case -311:
                case -310:
                case -205:
                case -72:
                case -9:
                case -6:
                case -4:
                case -3:
                    au.getNotification().eK(ad.getContext().getString(R.l.main_err_relogin));
                    au.hold();
                    return;
                case -140:
                    x.e("MicroMsg.NewSyncErrorProcessor", "alpha need whitelist : [%s]", new Object[]{str});
                    if (bi.oW(str)) {
                        au.getNotification().eK(ad.getContext().getString(R.l.main_err_relogin));
                    } else {
                        au.getNotification().eK(str);
                    }
                    au.hold();
                    return;
                case -100:
                    au.getNotification().eK(ad.getContext().getString(R.l.main_err_another_place));
                    com.tencent.mm.platformtools.x.ca(ad.getContext());
                    au.hold();
                    return;
                case -17:
                case DownloadResult.CODE_URL_EMPTY /*-16*/:
                    SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("system_config_prefs", 0);
                    long j = sharedPreferences.getLong("recomended_update_ignore", -1);
                    if (j == -1 || bi.bG(j) >= 86400) {
                        int i3;
                        al notification = au.getNotification();
                        if (i2 == -17) {
                            i3 = 2;
                        } else {
                            i3 = 1;
                        }
                        notification.fp(i3);
                        sharedPreferences.edit().putLong("recomended_update_ignore", bi.VE()).commit();
                        h.mEJ.a(405, 27, 1, true);
                        return;
                    }
                    x.d("MicroMsg.NewSyncErrorProcessor", "skip update notification, last check=" + j);
                    return;
                default:
                    return;
            }
        }
    }
}
