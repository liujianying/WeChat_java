package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.plugin.account.friend.a.w.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class BindGoogleContactIntroUI extends MMActivity implements e {
    private ImageView eEQ;
    private TextView eER;
    private Button eES;
    private Button eET;
    private boolean eEU = false;
    private boolean eEV = false;
    private String eEW;
    private ProgressDialog eEX;
    private w eEY;
    private int eEZ;
    private OnClickListener eFa = new 1(this);
    private OnClickListener eFb = new OnClickListener() {
        public final void onClick(View view) {
            h.a(BindGoogleContactIntroUI.this.mController.tml, true, BindGoogleContactIntroUI.this.getString(j.unbind_gcontact_confirm), "", BindGoogleContactIntroUI.this.getString(j.unbind_gcontact_btn_setting), BindGoogleContactIntroUI.this.getString(j.app_cancel), new 1(this), new 2(this));
        }
    };

    static /* synthetic */ void b(BindGoogleContactIntroUI bindGoogleContactIntroUI) {
        bindGoogleContactIntroUI.eEY = new w(a.eKN, bindGoogleContactIntroUI.eEW, w.eKG);
        g.DF().a(bindGoogleContactIntroUI.eEY, 0);
        bindGoogleContactIntroUI.getString(j.app_tip);
        bindGoogleContactIntroUI.eEX = h.a(bindGoogleContactIntroUI, bindGoogleContactIntroUI.getString(j.app_waiting), true, new 4(bindGoogleContactIntroUI));
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.bindgooglecontactintro;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(j.bind_gcontact_title_setting);
        this.eEZ = getIntent().getIntExtra("enter_scene", 0);
        this.eEU = m.cl(this);
        if (this.eEU) {
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
        }
    }

    protected void onResume() {
        super.onResume();
        this.eEW = (String) g.Ei().DT().get(208903, null);
        if (TextUtils.isEmpty(this.eEW)) {
            this.eEV = false;
        } else {
            this.eEV = true;
        }
        initView();
        if (this.eEV) {
            this.eET.setVisibility(0);
            this.eES.setVisibility(8);
            this.eER.setVisibility(0);
            this.eER.setText(getString(j.bind_gcontact_contenct_binded, new Object[]{this.eEW}));
            this.eET.setOnClickListener(this.eFb);
        } else {
            WE();
        }
        g.DF().a(487, this);
    }

    protected void onStop() {
        super.onStop();
        g.DF().b(487, this);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BindGoogleContactIntroUI.this.finish();
                return true;
            }
        });
        this.eEQ = (ImageView) findViewById(f.setting_bind_google_account_icon);
        this.eER = (TextView) findViewById(f.setting_bind_google_account_text);
        this.eES = (Button) findViewById(f.setting_bind_google_account_btn);
        this.eET = (Button) findViewById(f.setting_unbind_google_account_btn);
    }

    private void WE() {
        this.eET.setVisibility(8);
        this.eES.setVisibility(0);
        this.eEQ.setVisibility(0);
        this.eER.setVisibility(0);
        this.eER.setText(j.bind_gcontact_contenct_setting);
        this.eES.setText(j.bind_gcontact_btn_setting);
        this.eES.setOnClickListener(this.eFa);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            if (i == 2005) {
                this.eEU = intent.getBooleanExtra("gpservices", false);
            }
        } else if (i == 2005) {
            this.eEU = intent.getBooleanExtra("gpservices", false);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        String str2 = "MicroMsg.GoogleContact.BindGoogleContactIntroUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        x.i(str2, str3, objArr);
        if (this.eEX != null && this.eEX.isShowing()) {
            this.eEX.dismiss();
        }
        if (i == 0 && i2 == 0) {
            g.Ei().DT().set(208903, "");
            g.Ei().DT().set(208901, "");
            g.Ei().DT().set(208902, "");
            g.Ei().DT().set(208905, Boolean.valueOf(true));
            g.Ei().DT().lm(true);
            WE();
            h.bA(this, getString(j.unbind_gcontact_success_tip));
            return;
        }
        x.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "unbind failed");
        Toast.makeText(this, j.gcontact_unbind_failed_msg, 0).show();
    }
}
