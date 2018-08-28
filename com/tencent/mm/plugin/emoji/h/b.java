package com.tencent.mm.plugin.emoji.h;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private final String TAG = "MicroMsg.emoji.UseSmileyTool";
    public int guC;
    public String ist;

    public b(int i) {
        this.guC = i;
    }

    public static void a(Intent intent, String str, Activity activity) {
        if (intent != null) {
            a(intent.getStringExtra("Select_Conv_User"), str, activity);
        }
    }

    public static void a(String str, String str2, Activity activity) {
        if (bi.oW(str)) {
            x.d("MicroMsg.emoji.UseSmileyTool", "talker name is invalid so can't go to chat room use.");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("smiley_product_id", str2);
        com.tencent.mm.plugin.emoji.b.ezn.e(intent, activity);
    }

    public final void p(Activity activity) {
        x.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
        Intent intent = new Intent();
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.fast_faded_in);
        intent.putExtra("MMActivity.OverrideExitAnimation", R.a.push_down_out);
        d.b(activity, ".ui.transmit.SelectConversationUI", intent, this.guC);
        activity.overridePendingTransition(R.a.push_up_in, R.a.fast_faded_out);
    }
}
