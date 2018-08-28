package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.c.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceConnectedRouterActivateStateUI extends MMActivity {
    private String appId;
    private String bKv;
    private String byN;
    private TextView iCA;
    private b<a> iCB = new 1(this);
    private final int iCx = 90000;
    private ExdeviceConnectedRouterStateView iCy;
    private TextView iCz;
    private String isU;
    private String ssid;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.ConnectedRouterActivateStateUi", "create activity");
        setMMTitle(R.l.exdevice_connected_router_title);
        setBackBtn(new 2(this));
        this.iCy = (ExdeviceConnectedRouterStateView) findViewById(R.h.exdevice_connected_router_connect_state);
        this.iCz = (TextView) findViewById(R.h.exdevice_connected_router_connect_info);
        this.iCA = (TextView) findViewById(R.h.exdevice_connected_router_connect_tips);
        try {
            Uri parse = Uri.parse(getIntent().getStringExtra("key_connected_router"));
            this.byN = parse.getQueryParameter("deviceid");
            this.bKv = parse.getQueryParameter("devicetype");
            this.isU = parse.getQueryParameter("clientinfo");
            this.appId = parse.getQueryParameter("appid");
            if (bi.oW(this.byN) || bi.oW(this.bKv) || bi.oW(this.isU) || bi.oW(this.appId)) {
                x.e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", new Object[]{parse.toString()});
                finish();
            }
            this.ssid = parse.getQueryParameter("ssid");
            x.d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", new Object[]{parse.toString(), this.byN, this.bKv, this.isU, this.ssid});
            if (this.ssid == null) {
                this.ssid = "";
            }
        } catch (Exception e) {
            x.d("MicroMsg.ConnectedRouterActivateStateUi", e.toString());
        }
        ph(1);
        au.DF().a(new a(this.byN, this.bKv, this.isU, this.appId, this.iCB), 0);
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
    }

    protected final void ph(int i) {
        this.iCy.setOnClickListener(null);
        x.d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.iCy.setImageResource(R.k.connected_router_state_normal);
                this.iCy.setState(1);
                this.iCz.setText(R.l.exdevice_connected_router_connecting);
                return;
            case 2:
                this.iCy.setImageResource(R.k.connected_router_state_succ);
                this.iCy.setState(2);
                this.iCz.setText(getString(R.l.exdevice_connected_router_success, new Object[]{this.ssid}));
                addTextOptionMenu(0, getString(R.l.exdevice_connected_router_complete), new 3(this));
                return;
            case 3:
                this.iCy.setImageResource(R.k.connected_router_state_error);
                this.iCy.setState(3);
                this.iCy.iCE = 2;
                this.iCz.setText(R.l.exdevice_connected_router_error);
                this.iCA.setText(getString(R.l.exdevice_connected_router_error_tips, new Object[]{this.ssid}));
                return;
            case 4:
                this.iCy.setImageResource(R.k.connected_router_state_error);
                this.iCy.setState(3);
                this.iCy.iCE = 2;
                this.iCz.setText(R.l.exdevice_connected_router_error);
                this.iCA.setText(getString(R.l.exdevice_connected_router_network_error));
                return;
            case 5:
                this.iCy.setImageResource(R.k.connected_router_state_error);
                this.iCy.setState(3);
                this.iCy.iCE = 2;
                this.iCz.setText(R.l.exdevice_connected_router_error);
                this.iCA.setText(getString(R.l.exdevice_connected_router_system_error));
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.exdevice_connected_router_state;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        aHQ();
        return true;
    }

    private void aHQ() {
        finish();
        Intent intent = new Intent();
        intent.putExtra("From_fail_notify", true);
        x.d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
        d.e(this, "com.tencent.mm.ui.LauncherUI", intent);
    }
}
