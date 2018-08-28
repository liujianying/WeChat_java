package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.bn;
import com.tencent.mm.ui.base.h;

class SendFeedBackUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SendFeedBackUI mQD;

    SendFeedBackUI$3(SendFeedBackUI sendFeedBackUI) {
        this.mQD = sendFeedBackUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String trim = SendFeedBackUI.a(this.mQD).getText().toString().trim();
        if (trim.length() > 0) {
            if (trim.startsWith("//traceroute")) {
                SendFeedBackUI.a(this.mQD).setText("");
                d.A(this.mQD.mController.tml, "traceroute", ".ui.NetworkDiagnoseIntroUI");
            } else {
                l jVar = new j(q.zO(), trim + " key " + bn.cmZ() + " local key " + bn.cmY() + "NetType:" + ao.getNetTypeString(this.mQD.getApplicationContext()) + " hasNeon: " + n.zp() + " isArmv6: " + n.zr() + " isArmv7: " + n.zq());
                g.DF().a(153, this.mQD);
                g.DF().a(jVar, 0);
                this.mQD.YC();
                SendFeedBackUI sendFeedBackUI = this.mQD;
                SendFeedBackUI sendFeedBackUI2 = this.mQD;
                this.mQD.getString(i.app_tip);
                SendFeedBackUI.a(sendFeedBackUI, h.a(sendFeedBackUI2, this.mQD.getString(i.app_sending), true, new 1(this, jVar)));
            }
        }
        return false;
    }
}
