package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.ComponentName;
import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.i;

class EmojiStoreV2UI$5 implements IdleHandler {
    final /* synthetic */ EmojiStoreV2UI irY;

    EmojiStoreV2UI$5(EmojiStoreV2UI emojiStoreV2UI) {
        this.irY = emojiStoreV2UI;
    }

    public final boolean queueIdle() {
        x.i("MicroMsg.emoji.EmojiStoreV2UI", "now try to activity the tools process");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        this.irY.sendBroadcast(intent);
        return false;
    }
}
