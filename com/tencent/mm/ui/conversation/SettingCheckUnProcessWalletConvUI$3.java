package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.storage.ai;

class SettingCheckUnProcessWalletConvUI$3 implements OnItemClickListener {
    final /* synthetic */ SettingCheckUnProcessWalletConvUI urE;

    SettingCheckUnProcessWalletConvUI$3(SettingCheckUnProcessWalletConvUI settingCheckUnProcessWalletConvUI) {
        this.urE = settingCheckUnProcessWalletConvUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ai FU = SettingCheckUnProcessWalletConvUI.b(this.urE).FU(i);
        if (FU != null) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", FU.field_username);
            intent.putExtra("chat_from_scene", 4);
            d.e(this.urE, ".ui.chatting.ChattingUI", intent);
        }
    }
}
