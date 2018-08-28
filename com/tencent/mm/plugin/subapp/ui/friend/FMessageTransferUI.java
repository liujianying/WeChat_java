package com.tencent.mm.plugin.subapp.ui.friend;

import android.os.Bundle;
import com.tencent.mm.az.d;
import com.tencent.mm.model.au;
import com.tencent.mm.ui.MMActivity;

public class FMessageTransferUI extends MMActivity {
    private int bzH;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("friend_message_transfer_username");
        d.SF().YK(stringExtra);
        d.SF().clR();
        String action = getIntent().getAction();
        String str = "friend_message_accept_" + stringExtra;
        this.bzH = 2130706432 | (Integer.MAX_VALUE & stringExtra.hashCode());
        au.getNotification().cancel(this.bzH);
        if (str.equals(action)) {
            a.g(this.mController.tml, stringExtra, true);
        }
        finish();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
