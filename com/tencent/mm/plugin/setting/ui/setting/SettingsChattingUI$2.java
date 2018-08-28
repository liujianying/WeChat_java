package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

class SettingsChattingUI$2 implements OnClickListener {
    final /* synthetic */ SettingsChattingUI mSa;

    SettingsChattingUI$2(SettingsChattingUI settingsChattingUI) {
        this.mSa = settingsChattingUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ArrayList arrayList;
        h.mEJ.h(14553, new Object[]{Integer.valueOf(5), Integer.valueOf(2), ""});
        h.mEJ.a(324, 0, 1, false);
        SettingsChattingUI.a(this.mSa, false);
        SettingsChattingUI settingsChattingUI = this.mSa;
        SettingsChattingUI settingsChattingUI2 = this.mSa;
        this.mSa.getString(i.app_tip);
        SettingsChattingUI.a(settingsChattingUI, com.tencent.mm.ui.base.h.a(settingsChattingUI2, this.mSa.getString(i.app_waiting), true, new 1(this)));
        List<bd> bdm = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().bdm();
        if (bdm != null) {
            x.i("MicroMsg.WalletConvDelCheckLogic", "checkGetUnProcessorWalletConversation, msgInfoList size: %s", new Object[]{Integer.valueOf(bdm.size())});
            Collection hashSet = new HashSet();
            for (bd bdVar : bdm) {
                if (!(hashSet.contains(bdVar.field_talker) || ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().Yq(bdVar.field_talker) == null || !e.af(bdVar))) {
                    hashSet.add(bdVar.field_talker);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(hashSet);
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            SettingsChattingUI.b(this.mSa);
            return;
        }
        SettingsChattingUI.a(this.mSa).dismiss();
        com.tencent.mm.ui.base.h.a(this.mSa, false, this.mSa.getString(i.wallet_clearall_conversation_note, new Object[]{Integer.valueOf(arrayList.size())}), null, this.mSa.getString(i.goto_conversation), this.mSa.getString(i.clearall_conversation), new 2(this, arrayList), new 3(this), -1, c.alert_btn_color_warn);
    }
}
