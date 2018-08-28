package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.a$i;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.al.b;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.a.e;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i$b;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class BindMobileUI extends MMWizardActivity {
    private String bTi;
    private String countryCode = null;
    private String dYy = null;
    private i eFY;
    private BindWordingContent eGQ;
    private int eGR;
    private TextView eGX;
    private Button eGY;
    private TextView eGZ;
    private EditText eGp;
    private LinearLayout eGq;
    private TextView eGs;
    private TextView eGt;
    private CheckBox eGu;
    private String eGw = null;
    private TextView eHa;
    private CheckBox eHb;
    private LinearLayout eHc;
    private ImageView eHd;
    private boolean eHe;

    static /* synthetic */ void a(BindMobileUI bindMobileUI, final String str) {
        if (bindMobileUI.eFY == null) {
            bindMobileUI.eFY = new i(i$b.eNI, bindMobileUI, new a() {
                public final void e(int i, Bundle bundle) {
                    boolean z = true;
                    if (i == 1) {
                        if (BindMobileUI.this.eHe) {
                            BindMobileUI bindMobileUI = BindMobileUI.this;
                            boolean z2 = !BindMobileUI.this.eGu.isChecked();
                            if (BindMobileUI.this.eHb.isChecked()) {
                                z = false;
                            }
                            BindMobileStatusUI.c(bindMobileUI, z2, z);
                            BindMobileUI.this.exit(-1);
                            return;
                        }
                        Intent intent = new Intent(BindMobileUI.this, BindMobileStatusUI.class);
                        intent.putExtra("kstyle_bind_wording", BindMobileUI.this.eGQ);
                        intent.putExtra("kstyle_bind_recommend_show", BindMobileUI.this.eGR);
                        intent.putExtra("Kfind_friend_by_mobile_flag", BindMobileUI.this.eGu.isChecked());
                        intent.putExtra("Krecom_friends_by_mobile_flag", BindMobileUI.this.eHb.isChecked());
                        MMWizardActivity.D(BindMobileUI.this, intent);
                    } else if (i == 2) {
                        BindMobileUI.d(BindMobileUI.this, str);
                    }
                }
            });
            bindMobileUI.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, bindMobileUI.eFY);
        }
        bindMobileUI.eFY.pE(str);
        if (bindMobileUI.eHe) {
            bindMobileUI.eFY.eND = false;
        }
    }

    static /* synthetic */ void c(BindMobileUI bindMobileUI, String str) {
        String string = bindMobileUI.mController.tml.getString(a$j.bind_mcontact_verify_mobile_number);
        h.a(bindMobileUI.mController.tml, String.format("%s\n%s", new Object[]{bindMobileUI.mController.tml.getString(a$j.bind_mcontact_verify_mobile_number_hint), str}), string, new 1(bindMobileUI, str), null);
    }

    static /* synthetic */ void d(BindMobileUI bindMobileUI, String str) {
        Intent intent = new Intent(bindMobileUI, BindMobileVerifyUI.class);
        intent.putExtra("bindmcontact_mobile", str);
        intent.putExtra("kstyle_bind_wording", bindMobileUI.eGQ);
        intent.putExtra("kstyle_bind_recommend_show", bindMobileUI.eGR);
        intent.putExtra("Kfind_friend_by_mobile_flag", bindMobileUI.eGu.isChecked());
        intent.putExtra("Krecom_friends_by_mobile_flag", bindMobileUI.eHb.isChecked());
        intent.putExtra("is_bind_for_chatroom_upgrade", bindMobileUI.eHe);
        D(bindMobileUI, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(a$j.bind_mcontact_security_title);
        this.dYy = bi.aG(getIntent().getStringExtra("country_name"), "");
        this.countryCode = bi.aG(getIntent().getStringExtra("couttry_code"), "");
        this.eGw = bi.aG(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.eGQ = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.eGR = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.eHe = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
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
        DT(1);
        return true;
    }

    protected final void initView() {
        this.eGp = (EditText) findViewById(f.bind_mcontact_mobile);
        this.eGq = (LinearLayout) findViewById(f.country_code_ll);
        this.eGs = (TextView) findViewById(f.country_name);
        this.eGt = (TextView) findViewById(f.country_code);
        this.eGX = (TextView) findViewById(f.bind_mcontact_title_tv);
        this.eGY = (Button) findViewById(f.bind_m_contact_bind_mobile);
        this.eGZ = (TextView) findViewById(f.bind_mcontact_skip_bind);
        this.eGX.setText(getString(a$j.bind_mcontact_security_bander_hint));
        this.eHa = (TextView) findViewById(f.bind_m_contact_bind_mobile_hint);
        this.eHc = (LinearLayout) findViewById(f.bind_mcontact_sync_contact_cb_ll);
        this.eHb = (CheckBox) findViewById(f.bind_mcontact_agree_cb_recom_friend);
        this.eGu = (CheckBox) findViewById(f.bind_mcontact_agree_cb);
        this.eHd = (ImageView) findViewById(f.bind_mcontact_icon);
        if (this.eGQ != null) {
            if (this.eGQ.title != null && this.eGQ.title.length() > 0) {
                this.eGX.setText(this.eGQ.title);
            }
            if (this.eGQ.content != null && this.eGQ.content.length() > 0) {
                this.eHa.setText(this.eGQ.content);
            }
            switch (this.eGQ.brl.intValue()) {
                case 0:
                    this.eHd.setImageResource(e.bind_mcontact_protect);
                    break;
                case 1:
                    this.eHd.setImageResource(e.bind_mcontact_warning);
                    break;
                case 2:
                    this.eHd.setImageResource(e.bind_mcontact_reco_friends);
                    break;
            }
        }
        switch (this.eGR) {
            case 0:
                this.eHc.setVisibility(0);
                this.eHb.setVisibility(0);
                this.eHa.setVisibility(8);
                break;
            case 1:
                this.eHc.setVisibility(8);
                this.eHb.setVisibility(8);
                this.eHa.setVisibility(0);
                break;
        }
        if (bi.oW(this.dYy) && bi.oW(this.countryCode)) {
            String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            x.d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()" + simCountryIso);
            if (bi.oW(simCountryIso)) {
                x.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
            } else {
                b.a j = b.j(this, simCountryIso, getString(a$j.country_code));
                if (j == null) {
                    x.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
                } else {
                    this.dYy = j.dYy;
                    this.countryCode = j.dYx;
                }
            }
        }
        if (!(this.dYy == null || this.dYy.equals(""))) {
            this.eGs.setText(this.dYy);
        }
        if (!(this.countryCode == null || this.countryCode.equals(""))) {
            this.eGt.setText("+" + this.countryCode);
        }
        if (!(this.eGw == null || this.eGw.equals(""))) {
            this.eGp.setText(this.eGw);
        }
        this.eGY.setOnClickListener(new 2(this));
        this.eGZ.setOnClickListener(new 3(this));
        if (this.eHe) {
            setMMTitle(a$j.bind_mcontact_bind_for_chatroom_title);
            this.eHd.setVisibility(8);
            this.eGX.setText(a$j.bind_mcontact_for_chatroom_title);
            this.eHc.setVisibility(8);
            this.eHb.setVisibility(8);
            this.eHb.setChecked(false);
            this.eGu.setVisibility(0);
            this.eGu.setChecked(false);
            this.eHa.setVisibility(8);
            this.eHa.setText(getString(a$j.bind_mcontact_bind_mobile_warnning_hint));
            this.eGZ.setVisibility(8);
            this.eGY.setText(a$j.bind_mcontact_bind_for_chatroom_title);
            setBackBtn(new 4(this));
        }
        this.eGq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", BindMobileUI.this.dYy);
                intent.putExtra("couttry_code", BindMobileUI.this.countryCode);
                com.tencent.mm.plugin.account.a.a.ezn.b(intent, BindMobileUI.this);
            }
        });
        this.eGq.setOnClickListener(new 6(this));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case a$i.AppCompatTheme_buttonStyle /*100*/:
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
        return g.bind_mcontact_input_phonenum;
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
