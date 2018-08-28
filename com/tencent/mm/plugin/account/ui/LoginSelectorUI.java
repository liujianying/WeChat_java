package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.a.b;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public class LoginSelectorUI extends MMActivity implements OnClickListener {
    private TextView eRS;
    private View eRT;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleVisibility(8);
        a.ezo.vo();
        g.Eg();
        com.tencent.mm.kernel.a.DB();
        initView();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.select_login_reg;
    }

    public void onResume() {
        super.onResume();
        g.Eg();
        com.tencent.mm.kernel.a.DB();
    }

    protected final void initView() {
        Button button = (Button) findViewById(f.select_login_btn);
        Button button2 = (Button) findViewById(f.select_register_btn);
        this.eRS = (TextView) findViewById(f.select_country);
        this.eRT = findViewById(f.select_country_ly);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        this.eRS.setText(w.h(this.mController.tml, b.language_setting, j.app_lang_sys));
        this.eRT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("not_auth_setting", true);
                a.ezn.p(intent, LoginSelectorUI.this.mController.tml);
            }
        });
        if (e.sFE) {
            a.ezo.g(this);
        } else {
            a.ezo.bb(this);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Intent be = a.ezn.be(this);
            be.addFlags(67108864);
            be.putExtra("can_finish", true);
            startActivity(be);
            finish();
            com.tencent.mm.ui.base.b.gF(this);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onClick(View view) {
        Intent intent;
        if (f.select_login_btn == view.getId()) {
            intent = new Intent(this, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 1);
            startActivity(intent);
        } else if (f.select_register_btn != view.getId()) {
        } else {
            if (d.qVQ) {
                String string = getString(j.create_forbiden_uri, new Object[]{"0x" + Integer.toHexString(d.qVN), w.chP()});
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", string);
                intent2.putExtra("showShare", false);
                intent2.putExtra("show_bottom", false);
                intent2.putExtra("needRedirect", false);
                intent2.putExtra("neverGetA8Key", true);
                intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
                intent2.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
                a.ezn.j(intent2, this);
                return;
            }
            intent = new Intent(this, RegByMobileRegAIOUI.class);
            intent.putExtra("login_type", 0);
            startActivity(intent);
        }
    }
}
