package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMBaseActivity;

public class InviteRemindDialog extends MMBaseActivity {
    private TextView eGX;
    private TextView oPY;
    private String talker = "";
    private int type = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.i.mm_voip_invite_alert);
        this.eGX = (TextView) findViewById(R.h.mm_alert_msg_title);
        this.oPY = (TextView) findViewById(R.h.mm_alert_msg_content);
        this.talker = getIntent().getStringExtra("InviteRemindDialog_User");
        this.type = getIntent().getIntExtra("InviteRemindDialog_Type", 0);
        if (this.type == 0) {
            this.eGX.setText(getString(R.l.voip_send_request_title));
            this.oPY.setText(getString(R.l.voip_invite_remind_tip));
        } else if (this.type == 1) {
            this.eGX.setText(getString(R.l.voip_voice_send_request_title));
            this.oPY.setText(getString(R.l.voip_voice_invite_remind_tip));
        }
        findViewById(R.h.mm_alert_ok_btn).setOnClickListener(new 1(this));
        findViewById(R.h.mm_alert_cancel_btn).setOnClickListener(new 2(this));
    }

    public void finish() {
        super.finish();
    }

    public static void k(Context context, String str, int i) {
        Intent intent = new Intent(context, InviteRemindDialog.class);
        intent.putExtra("InviteRemindDialog_User", str);
        intent.putExtra("InviteRemindDialog_Type", i);
        context.startActivity(intent);
    }
}
