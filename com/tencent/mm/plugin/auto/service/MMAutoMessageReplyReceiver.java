package com.tencent.mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ah;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;

public class MMAutoMessageReplyReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String j = s.j(intent, "key_username");
        if (j != null) {
            Bundle resultsFromIntent = ah.getResultsFromIntent(intent);
            CharSequence charSequence = resultsFromIntent != null ? resultsFromIntent.getCharSequence("key_voice_reply_text") : null;
            if (charSequence == null) {
                x.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "username %s reply null", new Object[]{j});
                return;
            }
            x.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "username %s reply %s", new Object[]{j, charSequence.toString()});
            g.bcT().D(j, charSequence.toString(), com.tencent.mm.model.s.hQ(j));
        }
    }
}
