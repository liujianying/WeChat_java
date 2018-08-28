package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.account.a.b;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.a.h;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.widget.MMEditText.c;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileVerifyUI extends MMActivity {
    protected String bTi;
    String bgn;
    private Timer bno;
    protected EditText eGC;
    protected TextView eGD;
    protected ProgressDialog eHw = null;
    String eHy;
    SecurityImage eIX = null;
    private String[] eNC;
    private ContentResolver eNn;
    private String eNx;
    private d eRi;
    protected String eSE;
    protected boolean eSi = false;
    protected MMFormInputView eTX;
    protected TextView eTY;
    protected TextView eTZ;
    private int eTb;
    String eTo;
    int eTw;
    protected TextView eUa;
    protected Button eUb;
    protected ScrollView eUc;
    private c eUd;
    private long eUe = 0;
    private boolean eUf = false;
    private boolean eUg = false;
    Boolean eUh;
    private int eUi = 30;
    protected boolean eUj = false;
    protected boolean eUk = false;
    protected int eUl = -1;
    private b eUm;
    String eUn;
    int egg;

    static /* synthetic */ void d(MobileVerifyUI mobileVerifyUI) {
        mobileVerifyUI.eUf = false;
        if (mobileVerifyUI.bno != null) {
            mobileVerifyUI.bno.cancel();
        }
    }

    static /* synthetic */ int h(MobileVerifyUI mobileVerifyUI) {
        switch (mobileVerifyUI.eTb) {
            case 2:
                return 0;
            case 3:
                return 2;
            case 4:
                return 1;
            default:
                return 3;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eTw = getIntent().getIntExtra("key_reg_style", 1);
        this.eTb = getIntent().getIntExtra("mobile_verify_purpose", 0);
        this.eUn = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
        this.eTo = getIntent().getStringExtra("kintent_password");
        this.bgn = getIntent().getStringExtra("kintent_nickname");
        this.eUh = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
        this.eSi = getIntent().getBooleanExtra("from_deep_link", false);
        this.eSE = getIntent().getStringExtra("regsession_id");
        switch (this.eTb) {
            case 2:
                this.eUm = new o();
                if (this.eTo != null && this.eTo.length() >= 8) {
                    this.egg = 1;
                    break;
                } else {
                    this.egg = 4;
                    break;
                }
                break;
            case 3:
            case 5:
                this.eUm = new m(this.eTb);
                break;
            case 4:
                this.eUm = new n();
                break;
            default:
                x.e("MicroMsg.MobileVerifyUI", "wrong purpose %s", new Object[]{Integer.valueOf(this.eTb)});
                finish();
                return;
        }
        String string = getString(j.bind_mcontact_title_verify);
        if (com.tencent.mm.protocal.d.qVQ) {
            string = getString(j.app_name) + getString(j.alpha_version_alpha);
        }
        setMMTitle(string);
        this.eUi = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.eUj = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.eUk = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.bTi = getIntent().getExtras().getString("bindmcontact_mobile");
        this.eHy = a.Zu();
        initView();
        this.eUm.a(this);
        if (this.eUn != null) {
            this.eGC.setText(this.eUn);
            YO();
        } else if (this.eTb == 5) {
            this.eUm.jn(a.eUw);
        } else {
            this.eUd = new c(this, this);
            getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this.eUd);
        }
        this.eRi = new d();
    }

    public void onDestroy() {
        if (this.eUd != null) {
            getContentResolver().unregisterContentObserver(this.eUd);
            this.eUd = null;
        }
        if (this.eRi != null) {
            this.eRi.close();
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        this.eUm.start();
    }

    public void onPause() {
        super.onPause();
        this.eUm.stop();
    }

    protected final int getLayoutId() {
        return g.mobile_verify_ui;
    }

    private void YN() {
        if (!this.eUf) {
            this.bno = new Timer();
            this.eUf = true;
            this.eUe = (long) this.eUi;
            this.bno.schedule(new 1(this), 1000, 1000);
        }
    }

    public final void onKeyboardStateChanged() {
        if (this.mController.tmG == 1) {
            this.eUc.scrollTo(0, this.eUc.getChildAt(0).getMeasuredHeight() - this.eUc.getMeasuredHeight());
        } else {
            this.eUc.scrollTo(0, 0);
        }
    }

    protected final void initView() {
        x.d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.bTi);
        this.eTX = (MMFormInputView) findViewById(f.bind_mcontact_verify_num);
        this.eTX.setImeOption(5);
        this.eTX.setInputType(3);
        this.eGC = this.eTX.getContentEditText();
        this.eTY = (TextView) findViewById(f.mobileverify_resend_bt);
        this.eTZ = (TextView) findViewById(f.mobileverify_counting_tv);
        this.eGD = (TextView) findViewById(f.bind_mcontact_verify_hint);
        this.eGD.setText(this.bTi);
        this.bTi = ap.Ww(this.bTi);
        this.eTY.setText(getString(j.mobileverify_resend));
        this.eUa = (TextView) findViewById(f.bind_mcontact_verify_tip);
        this.eUb = (Button) findViewById(f.next_btn);
        this.eUc = (ScrollView) findViewById(f.scroll);
        this.eNC = getResources().getStringArray(b.sms_content);
        this.eUa.setText(Html.fromHtml(getString(j.regbymobile_reg_input_verify_tip)));
        InputFilter[] inputFilterArr = new InputFilter[]{new 5(this)};
        this.eTZ.setVisibility(0);
        this.eTZ.setText(getResources().getQuantityString(h.mobileverify_send_code_tip, this.eUi, new Object[]{Integer.valueOf(this.eUi)}));
        YN();
        this.eUg = false;
        this.eGC.setFilters(inputFilterArr);
        this.eGC.addTextChangedListener(new c(this.eGC, null, 12));
        this.eUb.setOnClickListener(new 6(this));
        this.eUb.setEnabled(false);
        this.eGC.setTextSize(15.0f);
        this.eGC.addTextChangedListener(new 7(this));
        this.eTY.setOnClickListener(new 8(this));
        this.eTY.setEnabled(false);
        setBackBtn(new 9(this));
        this.eGC.setOnEditorActionListener(new 10(this));
        this.eGC.setOnKeyListener(new 11(this));
    }

    private void YO() {
        YC();
        if (this.eGC.getText().toString().trim().equals("")) {
            com.tencent.mm.ui.base.h.i(this, j.bind_mcontact_verifynull, j.app_tip);
        } else {
            this.eUm.jn(a.eUv);
        }
    }

    private void YP() {
        this.eUg = false;
        this.eTY.setEnabled(false);
        this.eTZ.setVisibility(0);
        this.eTZ.setText(getResources().getQuantityString(h.mobileverify_send_code_tip, this.eUi, new Object[]{Integer.valueOf(this.eUi)}));
        this.eTY.setVisibility(8);
        YN();
        this.eUm.jn(a.eUw);
        com.tencent.mm.ui.base.h.bA(this, getString(j.mobile_code_sended));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        a.pU(this.eHy);
        if (!this.eUm.jn(a.eUu)) {
            finish();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("nofification_type");
            x.d("MicroMsg.MobileVerifyUI", "[oneliang][notificationType]%s", new Object[]{stringExtra});
            if (stringExtra != null && stringExtra.equals("no_reg_notification")) {
                YP();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean e(int r8, int r9, java.lang.String r10) {
        /*
        r7 = this;
        r3 = 0;
        r2 = 0;
        r1 = 1;
        r0 = com.tencent.mm.h.a.eV(r10);
        if (r0 == 0) goto L_0x000e;
    L_0x0009:
        r0.a(r7, r3, r3);
        r0 = r1;
    L_0x000d:
        return r0;
    L_0x000e:
        r0 = 4;
        if (r8 != r0) goto L_0x0014;
    L_0x0011:
        switch(r9) {
            case -75: goto L_0x0030;
            case -1: goto L_0x001c;
            default: goto L_0x0014;
        };
    L_0x0014:
        switch(r9) {
            case -100: goto L_0x0082;
            case -43: goto L_0x0040;
            case -41: goto L_0x004b;
            case -36: goto L_0x0056;
            case -34: goto L_0x0035;
            case -33: goto L_0x0074;
            case -32: goto L_0x0061;
            default: goto L_0x0017;
        };
    L_0x0017:
        r0 = r2;
    L_0x0018:
        if (r0 == 0) goto L_0x00c2;
    L_0x001a:
        r0 = r1;
        goto L_0x000d;
    L_0x001c:
        r0 = com.tencent.mm.kernel.g.DF();
        r0 = r0.Lg();
        r2 = 5;
        if (r0 != r2) goto L_0x0030;
    L_0x0027:
        r0 = com.tencent.mm.plugin.account.a.j.net_warn_server_down_tip;
        r2 = com.tencent.mm.plugin.account.a.j.net_warn_server_down;
        com.tencent.mm.ui.base.h.i(r7, r0, r2);
        r0 = r1;
        goto L_0x000d;
    L_0x0030:
        com.tencent.mm.platformtools.aa.ch(r7);
        r0 = r1;
        goto L_0x000d;
    L_0x0035:
        r0 = com.tencent.mm.plugin.account.a.j.bind_mcontact_err_freq_limit;
        r0 = android.widget.Toast.makeText(r7, r0, r2);
        r0.show();
        r0 = r1;
        goto L_0x0018;
    L_0x0040:
        r0 = com.tencent.mm.plugin.account.a.j.bind_mcontact_err_binded;
        r0 = android.widget.Toast.makeText(r7, r0, r2);
        r0.show();
        r0 = r1;
        goto L_0x0018;
    L_0x004b:
        r0 = com.tencent.mm.plugin.account.a.j.bind_mcontact_err_format;
        r0 = android.widget.Toast.makeText(r7, r0, r2);
        r0.show();
        r0 = r1;
        goto L_0x0018;
    L_0x0056:
        r0 = com.tencent.mm.plugin.account.a.j.bind_mcontact_err_unbinded_notbinded;
        r0 = android.widget.Toast.makeText(r7, r0, r2);
        r0.show();
        r0 = r1;
        goto L_0x0018;
    L_0x0061:
        r0 = com.tencent.mm.plugin.account.a.j.bind_mcontact_verify_error;
        r0 = r7.getString(r0);
        r3 = "";
        r4 = new com.tencent.mm.plugin.account.ui.MobileVerifyUI$12;
        r4.<init>(r7);
        com.tencent.mm.ui.base.h.a(r7, r0, r3, r4);
        r0 = r1;
        goto L_0x0018;
    L_0x0074:
        r0 = com.tencent.mm.plugin.account.a.j.bind_mcontact_verify_err_time_out_content;
        r3 = com.tencent.mm.plugin.account.a.j.bind_mcontact_verify_tip;
        r4 = new com.tencent.mm.plugin.account.ui.MobileVerifyUI$2;
        r4.<init>(r7);
        com.tencent.mm.ui.base.h.a(r7, r0, r3, r4);
        r0 = r1;
        goto L_0x0018;
    L_0x0082:
        com.tencent.mm.kernel.a.hold();
        r0 = r7.mController;
        r3 = r0.tml;
        com.tencent.mm.kernel.g.Eg();
        r0 = com.tencent.mm.kernel.a.Dh();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x00ba;
    L_0x0096:
        r0 = r7.mController;
        r0 = r0.tml;
        r4 = com.tencent.mm.plugin.account.a.j.main_err_another_place;
        r0 = com.tencent.mm.bp.a.af(r0, r4);
    L_0x00a0:
        r4 = r7.mController;
        r4 = r4.tml;
        r5 = com.tencent.mm.plugin.account.a.j.app_tip;
        r4 = r4.getString(r5);
        r5 = new com.tencent.mm.plugin.account.ui.MobileVerifyUI$3;
        r5.<init>(r7);
        r6 = new com.tencent.mm.plugin.account.ui.MobileVerifyUI$4;
        r6.<init>(r7);
        com.tencent.mm.ui.base.h.a(r3, r0, r4, r5, r6);
        r0 = r1;
        goto L_0x0018;
    L_0x00ba:
        com.tencent.mm.kernel.g.Eg();
        r0 = com.tencent.mm.kernel.a.Dh();
        goto L_0x00a0;
    L_0x00c2:
        r0 = new com.tencent.mm.platformtools.ah;
        r0.<init>(r8, r9, r10);
        r3 = r7.eRi;
        r0 = r3.a(r7, r0);
        if (r0 == 0) goto L_0x00d2;
    L_0x00cf:
        r0 = r1;
        goto L_0x000d;
    L_0x00d2:
        r0 = r2;
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.ui.MobileVerifyUI.e(int, int, java.lang.String):boolean");
    }

    protected final void co(boolean z) {
        Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
        intent.putExtra("kintent_hint", getString(j.settings_modify_password_tip));
        intent.putExtra("kintent_cancelable", z);
        startActivityForResult(intent, 0);
    }

    private void Yh() {
        Exception e;
        Cursor cursor;
        Throwable th;
        String str = null;
        Uri parse = Uri.parse("content://sms/inbox");
        this.eNn = getContentResolver();
        String[] strArr = new String[]{"body", "_id", "date"};
        String str2 = "( ";
        int i = 0;
        while (i < this.eNC.length) {
            String str3 = i == this.eNC.length + -1 ? str2 + " body like \"%" + this.eNC[i] + "%\" ) " : str2 + "body like \"%" + this.eNC[i] + "%\" or ";
            i++;
            str2 = str3;
        }
        String str4 = str2 + " and date > " + (System.currentTimeMillis() - 300000) + " ";
        x.v("MicroMsg.MobileVerifyUI", "sql where:" + str4);
        if (str4 != null && !str4.equals("")) {
            Cursor query;
            try {
                query = this.eNn.query(parse, strArr, str4, null, null);
                if (query != null) {
                    int i2 = -1;
                    long j = 0;
                    while (query.moveToNext()) {
                        try {
                            long j2 = query.getLong(2);
                            if (j2 > j) {
                                i2 = query.getPosition();
                            } else {
                                j2 = j;
                            }
                            j = j2;
                        } catch (Exception e2) {
                            e = e2;
                            cursor = query;
                            try {
                                x.e("MicroMsg.MobileVerifyUI", e.toString());
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                    return;
                                }
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                query = cursor;
                                if (!(query == null || query.isClosed())) {
                                    query.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            query.close();
                            throw th;
                        }
                    }
                    this.eNx = null;
                    if (i2 >= 0) {
                        query.moveToPosition(i2);
                        Matcher matcher = Pattern.compile("\\d{4,8}").matcher(query.getString(query.getColumnIndex("body")));
                        if (matcher.find()) {
                            str = matcher.group();
                        }
                        this.eNx = str;
                        if (!this.eUg) {
                            this.eUg = true;
                            this.eGC.setText(this.eNx);
                            YC();
                            if (!this.eGC.getText().toString().trim().equals("")) {
                                if (this.eHw != null) {
                                    this.eHw.dismiss();
                                    this.eHw = null;
                                }
                                this.eUm.jn(a.eUx);
                            }
                        }
                    }
                    if (query != null && !query.isClosed()) {
                        query.close();
                    }
                } else if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th4) {
                th = th4;
                query = null;
                query.close();
                throw th;
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.MobileVerifyUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.cjd();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.MobileVerifyUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 128:
                if (iArr[0] == 0) {
                    Yh();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
