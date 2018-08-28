package com.tencent.mm.plugin.setting;

import android.content.Intent;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.e.g;
import java.util.Map;

class c$3 implements n {
    final /* synthetic */ c mOE;

    c$3(c cVar) {
        this.mOE = cVar;
    }

    public final void onNewXmlReceived(String str, Map<String, String> map, a aVar) {
        if (map != null) {
            String str2 = (String) map.get(".sysmsg.showtrustedfriends.wording");
            if (!bi.oW(str2)) {
                Intent intent = new Intent();
                intent.putExtra(g.thy, str2);
                d.b(ad.getContext(), "setting", ".ui.setting.SettingsTrustFriendUI", intent);
            }
        }
    }
}
