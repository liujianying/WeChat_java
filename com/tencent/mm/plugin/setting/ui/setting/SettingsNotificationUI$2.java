package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;

class SettingsNotificationUI$2 implements OnClickListener {
    final /* synthetic */ SettingsNotificationUI mTf;

    SettingsNotificationUI$2(SettingsNotificationUI settingsNotificationUI) {
        this.mTf = settingsNotificationUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        f.bh(false);
        bd bdVar = new bd();
        bdVar.eX(2);
        bdVar.ay(System.currentTimeMillis());
        bdVar.setType(1);
        bdVar.ep("weixin");
        bdVar.setContent(this.mTf.mController.tml.getString(i.settings_new_voip_msg_weixin_close_tips, new Object[]{Build.MODEL}));
        com.tencent.mm.model.bd.i(bdVar);
        ai Yq = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().Yq("weixin");
        if (Yq != null) {
            Yq.setContent(this.mTf.mController.tml.getString(i.settings_new_voip_msg_weixin_close_tips, new Object[]{Build.MODEL}));
            Yq.eV(Yq.field_unReadCount + 1);
            ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().a(Yq, "weixin");
        } else {
            Yq = new ai();
            Yq.setContent(this.mTf.mController.tml.getString(i.settings_new_voip_msg_weixin_close_tips, new Object[]{Build.MODEL}));
            Yq.setUsername("weixin");
            Yq.eV(1);
            ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().d(Yq);
        }
        h.mEJ.a(500, 3, 1, false);
        as.j(false, true);
    }
}
