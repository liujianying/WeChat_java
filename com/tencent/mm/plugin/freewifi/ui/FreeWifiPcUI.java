package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;

public class FreeWifiPcUI extends MMActivity {
    private String appId;
    private String bLe;
    private Button eGn;
    private String jkJ;
    private Button jmT;
    private String jmZ;
    private TextView jnP;
    private int jnQ;
    private p jnR = null;

    static /* synthetic */ void a(FreeWifiPcUI freeWifiPcUI, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", str2);
        intent.setClass(freeWifiPcUI, FreeWifiErrorUI.class);
        freeWifiPcUI.finish();
        freeWifiPcUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.free_wifi_title);
        setBackBtn(new 1(this));
        this.appId = getIntent().getStringExtra("free_wifi_appid");
        this.jnQ = getIntent().getIntExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", 0);
        this.bLe = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET");
        this.jkJ = getIntent().getStringExtra("free_wifi_app_nickname");
        this.jmZ = getIntent().getStringExtra("free_wifi_privacy_url");
        this.jnP = (TextView) findViewById(R.h.free_wifi_pc_app_name_tv);
        this.eGn = (Button) findViewById(R.h.free_wifi_pc_ok_btn);
        this.jnP.setText("由" + this.jkJ + "提供");
        this.eGn.setOnClickListener(new 2(this));
        this.jmT = (Button) findViewById(R.h.free_wifi_pc_user_protocol_privacy_btn);
        this.jmT.setOnClickListener(new 3(this));
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        g.ezn.i(new Intent(), this);
        finish();
    }

    protected final int getLayoutId() {
        return R.i.free_wifi_pc_front_page;
    }
}
