package com.tencent.mm.plugin.freewifi.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiErrorUI extends MMActivity {
    private ImageView jmK;
    private TextView jmL;
    private TextView jmM;
    private TextView jmN;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.free_wifi_title);
        this.jmK = (ImageView) findViewById(R.h.free_wifi_error);
        if (getIntent().getIntExtra("free_wifi_show_detail_error", 0) == 1) {
            this.jmK.setImageResource(R.g.free_wifi_detail_error);
        }
        this.jmL = (TextView) findViewById(R.h.free_wifi_errmsg);
        this.jmM = (TextView) findViewById(R.h.free_wifi_detail_errmsg1);
        this.jmN = (TextView) findViewById(R.h.free_wifi_detail_errmsg2);
        CharSequence stringExtra = getIntent().getStringExtra("free_wifi_error_ui_error_msg");
        CharSequence stringExtra2 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail1");
        CharSequence stringExtra3 = getIntent().getStringExtra("free_wifi_error_ui_error_msg_detail12");
        if (!m.isEmpty(stringExtra)) {
            this.jmL.setText(stringExtra);
        }
        if (!m.isEmpty(stringExtra2)) {
            this.jmM.setText(stringExtra2);
        }
        if (!m.isEmpty(stringExtra3)) {
            this.jmN.setText(stringExtra3);
        }
        setBackBtn(new 1(this));
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.free_wifi_error;
    }
}
