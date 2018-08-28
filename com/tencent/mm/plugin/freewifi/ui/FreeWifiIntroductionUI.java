package com.tencent.mm.plugin.freewifi.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiIntroductionUI extends MMActivity {
    private Button jlX;
    private Button jnr;
    private Button jns;
    private CheckBox jnt;
    private int source;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.jnr = (Button) findViewById(R.h.continue_btn);
        this.jnt = (CheckBox) findViewById(R.h.agree_user_agree_cb);
        this.jlX = (Button) findViewById(R.h.help_btn);
        this.jns = (Button) findViewById(R.h.user_agreemen_btn);
        this.source = getIntent().getIntExtra("free_wifi_source", 1);
        if (this.source == 3) {
            setMMTitle(R.l.mig_free_wifi_tile);
            ((TextView) findViewById(R.h.free_wifi_intro_tv)).setText(R.l.mig_free_wifi_intro_tips);
            ((TextView) findViewById(R.h.free_wifi_desc_tv)).setText(R.l.mig_free_wifi_desc);
            this.jlX.setVisibility(8);
        } else {
            setMMTitle(R.l.free_wifi_title);
        }
        setBackBtn(new 1(this));
        this.jnr.setOnClickListener(new 2(this));
        this.jnt.setOnCheckedChangeListener(new 3(this));
        this.jns.setOnClickListener(new 4(this));
        this.jlX.setOnClickListener(new 5(this));
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.free_wifi_intro;
    }
}
