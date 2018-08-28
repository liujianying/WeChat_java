package com.tencent.mm.ui;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.mm.R;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.bk.b;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Map;

class HomeUI$18 implements n {
    final /* synthetic */ HomeUI tjS;

    HomeUI$18(HomeUI homeUI) {
        this.tjS = homeUI;
    }

    public final void onNewXmlReceived(String str, Map<String, String> map, a aVar) {
        if (ai.oV(str).equals("showprivacypolicy") && map != null) {
            String str2 = (String) map.get(".sysmsg.showprivacypolicy.device_id");
            HomeUI.a(this.tjS, (String) map.get(".sysmsg.showprivacypolicy.doublecheck_content"));
            HomeUI.b(this.tjS, (String) map.get(".sysmsg.showprivacypolicy.doublecheck_ok"));
            HomeUI.c(this.tjS, (String) map.get(".sysmsg.showprivacypolicy.doublecheck_cancel"));
            boolean equals = "yes".equals(map.get(".sysmsg.showprivacypolicy.needbirthday"));
            boolean equals2 = "yes".equals(map.get(".sysmsg.showprivacypolicy.needopenplatform"));
            boolean equals3 = "yes".equals(map.get(".sysmsg.showprivacypolicy.needconfirm"));
            g.Ei().DT().a(aa.a.sZR, Boolean.valueOf(equals));
            g.Ei().DT().a(aa.a.sZS, Boolean.valueOf(equals2));
            g.Ei().DT().a(aa.a.sZT, Boolean.valueOf(equals3));
            b bi = b.bi(q.zz().getBytes());
            bi.Cz(16);
            x.i("MicroMsg.LauncherUI.HomeUI", "deviceId:%s, localDeviceId:%s, doubleCheckContent:%s, doubleCheckOk:%s, doubleCheckCancel:%s, needBirthday:%s, needOpenPlatform:%s, needConfirm:%s", new Object[]{str2, Base64.encodeToString(bi.toByteArray(), 2), HomeUI.r(this.tjS), HomeUI.s(this.tjS), HomeUI.t(this.tjS), Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(equals3)});
            if (ai.oW(str2) || str2.equals(r4)) {
                String obj = g.Ei().DT().get(274436, "").toString();
                MMFragmentActivity d = HomeUI.d(this.tjS);
                int i = R.l.license_read_url;
                Object[] objArr = new Object[5];
                objArr[0] = w.chP();
                objArr[1] = obj;
                objArr[2] = "login";
                objArr[3] = Integer.valueOf(1);
                objArr[4] = Integer.valueOf(equals2 ? 1 : 0);
                str2 = d.getString(i, objArr);
                Bundle bundle;
                if (com.tencent.mm.al.b.ml(obj)) {
                    x.i("MicroMsg.LauncherUI.HomeUI", "eu true, needconfirm: %s", new Object[]{Boolean.valueOf(equals3)});
                    if (equals3) {
                        HomeUI.a(this.tjS, str2, HomeUI.d(this.tjS).getString(R.l.gdpr_warn_privacy_url, new Object[]{w.chP()}));
                    } else {
                        bundle = new Bundle();
                        bundle.putString("close_dialog_msg", HomeUI.r(this.tjS));
                        bundle.putString("close_dialog_cancel", HomeUI.t(this.tjS));
                        bundle.putString("close_dialog_ok", HomeUI.s(this.tjS));
                        bundle.putBoolean("close_dialog_ok_close", false);
                        HomeUI.a(this.tjS, str2, bundle);
                    }
                } else {
                    x.i("MicroMsg.LauncherUI.HomeUI", "eu false");
                    bundle = new Bundle();
                    bundle.putString("close_dialog_msg", HomeUI.d(this.tjS).getString(R.l.license_disagree_tip));
                    bundle.putString("close_dialog_cancel", HomeUI.d(this.tjS).getString(R.l.logout_menu_logout));
                    bundle.putString("close_dialog_ok", HomeUI.d(this.tjS).getString(R.l.license_read_again));
                    bundle.putBoolean("close_dialog_ok_close", false);
                    HomeUI.a(this.tjS, str2, bundle);
                }
                com.tencent.mm.ui.base.b.gG(HomeUI.d(this.tjS));
                return;
            }
            x.i("MicroMsg.LauncherUI.HomeUI", "device id not match");
        }
    }
}
