package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI.2;
import java.util.ArrayList;

class SettingsChattingUI$2$2 implements OnClickListener {
    final /* synthetic */ 2 mSb;
    final /* synthetic */ ArrayList mSc;

    SettingsChattingUI$2$2(2 2, ArrayList arrayList) {
        this.mSb = 2;
        this.mSc = arrayList;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(14553, new Object[]{Integer.valueOf(5), Integer.valueOf(4), ""});
        SettingsChattingUI.a(this.mSb.mSa, true);
        if (this.mSc.size() <= 1) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", (String) this.mSc.get(0));
            intent.addFlags(67108864);
            d.e(this.mSb.mSa, ".ui.chatting.ChattingUI", intent);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putStringArrayListExtra("key_conversation_list", this.mSc);
        d.e(this.mSb.mSa, ".ui.conversation.SettingCheckUnProcessWalletConvUI", intent2);
    }
}
