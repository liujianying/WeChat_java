package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.b;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class BindMContactUI extends MMWizardActivity {
    private String bTi;
    private String countryCode = null;
    private String dYy = null;
    private i eFY;
    private boolean eFl = false;
    private boolean eGb = false;
    private boolean eGc = false;
    private EditText eGp;
    private LinearLayout eGq;
    private TextView eGr;
    private TextView eGs;
    private TextView eGt;
    private CheckBox eGu;
    private LinearLayout eGv;
    private String eGw = null;
    private boolean eGx = false;
    private boolean eGy = false;
    private boolean eGz = false;
    private int fromScene = 0;

    static /* synthetic */ void b(BindMContactUI bindMContactUI, String str) {
        if (bindMContactUI.eFY == null) {
            int i = b.eNI;
            if (bindMContactUI.eGy) {
                i = b.eNJ;
            }
            bindMContactUI.eFY = new i(i, bindMContactUI, new 6(bindMContactUI, str));
            bindMContactUI.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, bindMContactUI.eFY);
        }
        i iVar = bindMContactUI.eFY;
        boolean z = (bindMContactUI.eGb || bindMContactUI.eGc) ? false : true;
        iVar.eND = z;
        bindMContactUI.eFY.pE(str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(j.bind_mcontact_title_bind);
        this.dYy = bi.aG(getIntent().getStringExtra("country_name"), "");
        this.countryCode = bi.aG(getIntent().getStringExtra("couttry_code"), "");
        this.eGw = bi.aG(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.eFY != null) {
            getContentResolver().unregisterContentObserver(this.eFY);
            this.eFY.recycle();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        WN();
        return true;
    }

    private void WN() {
        if (this.eGb || this.eGc) {
            tob.clear();
            DT(1);
            return;
        }
        h.a(this, this.eGy ? j.bind_mcontact_exit_content_for_change_mobile : j.bind_mcontact_exit_content, this.eGy ? j.bind_mcontact_exit_tip_for_change_mobile : j.bind_mcontact_exit_tip, new 1(this), null);
    }

    protected final void initView() {
        this.eGb = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.eGc = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.eGx = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
        this.eGy = getIntent().getBooleanExtra("is_bind_for_change_mobile", false);
        this.eGz = getIntent().getBooleanExtra("is_bind_for_reset_pwd", false);
        this.eFl = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        x.i("MicroMsg.BindMContactUI", "bindScene:%d", new Object[]{Integer.valueOf(this.fromScene)});
        this.eGp = (EditText) findViewById(f.bind_mcontact_mobile);
        this.eGq = (LinearLayout) findViewById(f.country_code_ll);
        this.eGs = (TextView) findViewById(f.country_name);
        this.eGt = (TextView) findViewById(f.country_code);
        this.eGu = (CheckBox) findViewById(f.bind_mcontact_find_me_by_mobile_cb);
        this.eGv = (LinearLayout) findViewById(f.bind_mcontact_find_me_by_mobile_ll);
        this.eGr = (TextView) findViewById(f.setting_bind_mobile_binded_mobile);
        if (this.eGy) {
            String str = (String) g.Ei().DT().get(6, null);
            if (!bi.oW(str)) {
                String Fp;
                if (str.startsWith("+")) {
                    Fp = ap.Fp(str);
                    str = str.substring(Fp.length() + 1);
                } else {
                    Fp = "86";
                }
                ap apVar = new ap();
                str = ap.formatNumber(Fp, str);
                this.eGr.setText(getString(j.bind_mcontact_change_mobile_hint, new Object[]{str}));
            }
        }
        if (!(this.dYy == null || this.dYy.equals(""))) {
            this.eGs.setText(this.dYy);
        }
        if (!(this.countryCode == null || this.countryCode.equals(""))) {
            this.eGt.setText("+" + this.countryCode);
        }
        if (this.eGw == null || this.eGw.equals("")) {
            g.Em().a(new 2(this));
        } else {
            this.eGp.setText(this.eGw);
            this.eGp.setSelection(this.eGw.length());
        }
        if (com.tencent.mm.al.b.PD()) {
            this.eGv.setVisibility(4);
            this.eGu.setChecked(true);
        }
        addTextOptionMenu(0, getString(j.app_nextstep), new 3(this));
        this.eGp.requestFocus();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BindMContactUI.this.WN();
                return true;
            }
        });
        this.eGq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", BindMContactUI.this.dYy);
                intent.putExtra("couttry_code", BindMContactUI.this.countryCode);
                a.ezn.b(intent, BindMContactUI.this);
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case 100:
                this.dYy = bi.aG(intent.getStringExtra("country_name"), "");
                this.countryCode = bi.aG(intent.getStringExtra("couttry_code"), "");
                if (!this.dYy.equals("")) {
                    this.eGs.setText(this.dYy);
                }
                if (!this.countryCode.equals("")) {
                    this.eGt.setText("+" + this.countryCode);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.bindmcontact;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.BindMContactUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.cjd();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.BindMContactUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 128:
                if (iArr[0] == 0 && this.eFY != null) {
                    this.eFY.Yh();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
