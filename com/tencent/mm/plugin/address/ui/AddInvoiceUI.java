package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.i;
import com.tencent.mm.plugin.address.ui.InvoiceEditView.c;
import com.tencent.mm.plugin.q.a.b;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.protocal.c.big;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

public class AddInvoiceUI extends MMActivity implements e, c {
    private int GG = 0;
    private String bXd = "";
    private TextView ePz;
    private Dialog eXG = null;
    private int eYg = 0;
    private Button eYh = null;
    private Button eYi = null;
    private TextView eYj;
    private TextView eYk;
    private TextView eYl = null;
    private InvoiceEditView eYm;
    private InvoiceEditView eYn;
    private InvoiceEditView eYo;
    private InvoiceEditView eYp;
    private InvoiceEditView eYq;
    private InvoiceEditView eYr;
    private InvoiceEditView eYs;
    private InvoiceEditView eYt;
    private b eYu = null;
    private b eYv = new b();
    private boolean eYw = false;
    private boolean eYx = false;

    static /* synthetic */ void o(AddInvoiceUI addInvoiceUI) {
        au.DF().a(new i(addInvoiceUI.eYv), 0);
        au.DF().a(1180, addInvoiceUI);
        if (addInvoiceUI.eYg != 0) {
            x.i("MicroMsg.AddInvoiceUI", "modify save invoice " + addInvoiceUI.eYv.toString());
        }
        addInvoiceUI.eXG = h.a((Context) addInvoiceUI, "", true, null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.eYw = intent.getBooleanExtra("launch_from_webview", false);
        this.eYx = intent.getBooleanExtra("launch_from_invoicelist_webview", false);
        au.DF().a(1191, this);
        x.d("MicroMsg.AddInvoiceUI", "index Oncreate");
        this.eYv = new b();
        this.eYg = getIntent().getIntExtra("invoice_id", 0);
        if (this.eYg == 0) {
            setMMTitle(R.l.settings_add_invoice);
        } else {
            setMMTitle(R.l.settings_modify_invoice);
        }
        initView();
    }

    public final void initView() {
        this.GG = 0;
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.h.invoice_sv);
        if (mMScrollView != null) {
            mMScrollView.a(mMScrollView, mMScrollView);
        }
        this.eYh = (Button) findViewById(R.h.invoice_person_btn);
        if (this.eYh != null) {
            this.eYh.setVisibility(0);
        }
        this.eYi = (Button) findViewById(R.h.invoice_company_btn);
        if (this.eYi != null) {
            this.eYi.setVisibility(0);
        }
        if (this.eYg == 0 && this.eYi != null) {
            this.eYi.setActivated(true);
        }
        if (this.eYi != null) {
            this.eYi.setOnTouchListener(new 1(this));
        }
        if (this.eYh != null) {
            this.eYh.setOnTouchListener(new 2(this));
        }
        this.eYm = (InvoiceEditView) findViewById(R.h.invoice_title_type);
        this.eYn = (InvoiceEditView) findViewById(R.h.invoice_title);
        this.eYo = (InvoiceEditView) findViewById(R.h.invoice_person_title);
        this.eYp = (InvoiceEditView) findViewById(R.h.invoice_tax_number);
        this.eYq = (InvoiceEditView) findViewById(R.h.invoice_company_address);
        this.eYr = (InvoiceEditView) findViewById(R.h.invoice_phone_number);
        this.eYs = (InvoiceEditView) findViewById(R.h.invoice_bank_name);
        this.eYt = (InvoiceEditView) findViewById(R.h.invoice_bank_number);
        this.eYp.eYS = true;
        this.eYp.eYL = true;
        this.eYp.setOnInputValidChangeListener(this);
        this.eYm.setOnInputValidChangeListener(this);
        this.eYn.setOnInputValidChangeListener(this);
        this.eYo.setOnInputValidChangeListener(this);
        this.eYq.setOnInputValidChangeListener(this);
        this.eYr.setOnInputValidChangeListener(this);
        this.eYs.setOnInputValidChangeListener(this);
        this.eYt.setOnInputValidChangeListener(this);
        if (this.eYg != 0) {
            this.ePz = (TextView) findViewById(R.h.tip_tv);
            this.ePz.setVisibility(8);
            this.eYk = (TextView) findViewById(R.h.type_tv);
            this.eYu = a.Zw().jp(this.eYg);
            if (this.eYu != null && this.eYu.type != null && this.eYu.type.equals("0")) {
                this.eYk.setText(getString(R.l.invoice_company_type_title));
            } else if (!(this.eYu == null || this.eYu.type == null || !this.eYu.type.equals("1"))) {
                this.eYk.setText(getString(R.l.invoice_personal_type_title));
            }
            this.eYk.setVisibility(0);
            this.eYi.setVisibility(8);
            this.eYh.setVisibility(8);
            if (this.eYu != null) {
                this.eYm.setValStr(this.eYu.type);
                this.eYn.setValStr(this.eYu.title);
                this.eYo.setValStr(this.eYu.knB);
                this.eYp.setValStr(this.eYu.knC);
                this.eYq.setValStr(this.eYu.knI);
                this.eYr.setValStr(this.eYu.knG);
                this.eYs.setValStr(this.eYu.knE);
                this.eYt.setValStr(this.eYu.knD);
            }
        }
        if (this.eYx || this.eYw) {
            this.eYl = (TextView) findViewById(R.h.jsapi_tips_tv);
            if (this.eYl != null) {
                this.eYl.setVisibility(0);
            }
        } else {
            this.eYl = (TextView) findViewById(R.h.jsapi_tips_tv);
            if (this.eYl != null) {
                this.eYl.setVisibility(8);
            }
        }
        setBackBtn(new 3(this));
        a(0, getString(R.l.app_save), new 4(this), s.b.tmX);
        enableOptionMenu(false);
        ZB();
    }

    public void onDestroy() {
        au.DF().b(1180, this);
        au.DF().b(1191, this);
        getWindow().setSoftInputMode(3);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("karea_result");
                    if (!bi.oW(stringExtra)) {
                        x.d("MicroMsg.AddInvoiceUI", "AREA_RESULT:" + stringExtra);
                        this.eYr.setValStr(stringExtra);
                    }
                    stringExtra = intent.getStringExtra("kpost_code");
                    if (!bi.oW(stringExtra)) {
                        x.d("MicroMsg.AddInvoiceUI", "post:" + stringExtra);
                        this.eYr.setValStr(stringExtra);
                    }
                    this.bXd = intent.getStringExtra("kwcode");
                    return;
                }
                return;
            case 3:
                if (i2 != -1) {
                    x.i("MicroMsg.AddInvoiceUI", "MallRecharge pay result : cancel");
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.mm_add_invoice_ui;
    }

    public final void a(int i, int i2, String str, l lVar) {
        Intent intent = null;
        x.i("MicroMsg.AddInvoiceUI", "errType " + i + ",errCode " + i2 + ",errMsg " + str);
        if (this.eXG != null) {
            this.eXG.dismiss();
        }
        if (i != 0 || i2 != 0) {
            h.a((Context) this, getString(R.l.invoice_save_fail), getString(R.l.app_tip), false, null);
        } else if (lVar.getType() == 1180) {
            big big = ((i) lVar).eXJ;
            if (!(big == null || big.siW == null || big.siW.size() <= 0 || big.siW.get(0) == null)) {
                this.GG = ((alj) big.siW.get(0)).group_id;
            }
            au.DF().b(1180, this);
            au.DF().a(new com.tencent.mm.plugin.address.model.b(), 0);
        } else if (lVar.getType() == 1191) {
            au.DF().b(1191, this);
            if (this.eYw) {
                x.i("MicroMsg.AddInvoiceUI", "isLaunchFromWebview true...");
                b bVar = this.eYv;
                if (bVar == null) {
                    x.e("MicroMsg.InvoiceUtil", "invoiceObj == null");
                } else {
                    intent = new Intent();
                    intent.putExtra("type", bVar.type);
                    if (bVar.type == null || !bVar.type.equals("1")) {
                        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE, bVar.title);
                        intent.putExtra("tax_number", bVar.knC);
                        intent.putExtra("company_address", bVar.knI);
                        intent.putExtra("telephone", bVar.knG);
                        intent.putExtra("bank_name", bVar.knE);
                        intent.putExtra("bank_account", bVar.knD);
                    } else {
                        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE, bVar.knB);
                    }
                }
                setResult(-1, intent);
                finish();
                return;
            }
            if (this.eYg == 0 && this.GG != 0) {
                intent = new Intent();
                intent.setClass(this, QrcodeInvoiceUI.class);
                intent.putExtra("invoice_id", this.GG);
                startActivity(intent);
                this.GG = 0;
            }
            finish();
        }
    }

    private boolean ZB() {
        boolean z = true;
        if ((this.eYi != null && this.eYi.isActivated()) || (this.eYu != null && this.eYu.type != null && this.eYu.type.equals("0"))) {
            boolean z2;
            this.eYp.setVisibility(0);
            this.eYq.setVisibility(0);
            this.eYr.setVisibility(0);
            this.eYs.setVisibility(0);
            this.eYt.setVisibility(0);
            this.eYn.setVisibility(0);
            this.eYo.setVisibility(8);
            if (!(this.eYi.isActivated() || this.eYu.type.equals("0"))) {
                z = false;
            }
            if (!this.eYn.ZF()) {
                if (this.eYn.getText().length() > 100) {
                    ac(getString(R.l.invoice_title), 100);
                }
                z = false;
            }
            if (this.eYi != null && this.eYi.isActivated() && this.eYn.getText().length() == 0) {
                z2 = false;
            } else {
                z2 = z;
            }
            enableOptionMenu(z2);
            if (this.eYp.ZF()) {
                if (this.eYj != null) {
                    this.eYj.setVisibility(8);
                }
            } else if (this.eYp.getText().length() > 0) {
                ViewStub viewStub = (ViewStub) findViewById(R.h.viewstub_tax_tips_vs);
                if (viewStub != null) {
                    viewStub.inflate();
                    this.eYj = (TextView) findViewById(R.h.viewstub_tax_tips_tv);
                }
                if (this.eYj != null) {
                    this.eYj.setVisibility(0);
                }
            }
            if (!this.eYq.ZF()) {
                if (this.eYq.getText().length() > 100) {
                    ac(getString(R.l.invoice_company_address), 100);
                }
                z2 = false;
            }
            if (!this.eYr.ZF()) {
                if (this.eYr.getText().length() > 100) {
                    ac(getString(R.l.invoice_phone_number), 100);
                }
                z2 = false;
            }
            if (!this.eYs.ZF()) {
                if (this.eYs.getText().length() > 100) {
                    ac(getString(R.l.invoice_bank_name), 100);
                }
                z2 = false;
            }
            if (this.eYt.ZF()) {
                return z2;
            }
            if (this.eYt.getText().length() <= 48) {
                return false;
            }
            ac(getString(R.l.invoice_bank_number), 39);
            return false;
        } else if ((this.eYh == null || !this.eYh.isActivated()) && (this.eYu == null || this.eYu.type == null || !this.eYu.type.equals("1"))) {
            this.eYp.setVisibility(0);
            this.eYq.setVisibility(0);
            this.eYr.setVisibility(0);
            this.eYs.setVisibility(0);
            this.eYt.setVisibility(0);
            this.eYo.setVisibility(8);
            this.eYn.setVisibility(0);
            this.eYo.setVisibility(8);
            if (!(this.eYh == null || this.eYh.isActivated() || this.eYi == null || this.eYi.isActivated())) {
                z = false;
            }
            if (!this.eYn.ZF()) {
                z = false;
            }
            if (!this.eYp.ZF()) {
                z = false;
            }
            if (!this.eYq.ZF()) {
                z = false;
            }
            if (!this.eYr.ZF()) {
                z = false;
            }
            if (!this.eYs.ZF()) {
                z = false;
            }
            if (this.eYt.ZF()) {
                return z;
            }
            return false;
        } else {
            this.eYp.setVisibility(8);
            this.eYq.setVisibility(8);
            this.eYr.setVisibility(8);
            this.eYs.setVisibility(8);
            this.eYt.setVisibility(8);
            this.eYn.setVisibility(8);
            this.eYo.setVisibility(0);
            if (!(this.eYh.isActivated() || this.eYu.type.equals("1"))) {
                z = false;
            }
            if (!this.eYo.ZF()) {
                if (this.eYo.getText().length() > 100) {
                    ac(getString(R.l.invoice_title), 100);
                }
                z = false;
            }
            if (this.eYh != null && this.eYh.isActivated() && this.eYo.getText().length() == 0) {
                z = false;
            }
            enableOptionMenu(z);
            return z;
        }
    }

    public final void ZC() {
        ZB();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        ZD();
        return true;
    }

    private void ZD() {
        boolean z;
        boolean z2 = true;
        if ((this.eYg == 0 || this.eYu == null || this.eYv.type == null || this.eYv.type.equals("") || this.eYv.type.equals(this.eYu.type)) && (this.eYg != 0 || this.eYv.type == null || this.eYv.type.equals(""))) {
            z = false;
        } else {
            z = true;
        }
        if (!(this.eYh == null || this.eYi == null || this.eYh.isActivated() || this.eYi.isActivated() || this.eYu != null)) {
            z = true;
        }
        if (this.eYn.ZG()) {
            z = true;
        }
        if (this.eYo.ZG()) {
            z = true;
        }
        if (this.eYp.ZG()) {
            z = true;
        }
        if (this.eYq.ZG()) {
            z = true;
        }
        if (this.eYr.ZG()) {
            z = true;
        }
        if (this.eYs.ZG()) {
            z = true;
        }
        if (!this.eYt.ZG()) {
            z2 = z;
        }
        if (z2) {
            h.a((Context) this, false, this.mController.tml.getString(R.l.invoice_back_modify_tip), "", this.mController.tml.getString(R.l.invoice_back_modify_confirm_tip), this.mController.tml.getString(R.l.invoice_back_cancel_tip), new 5(this), null);
            return;
        }
        setResult(0);
        finish();
    }

    private void ac(String str, int i) {
        h.a((Context) this, getString(R.l.invoice_bytes_limit_error, new Object[]{str, Integer.valueOf(i)}), getString(R.l.app_tip), false, null);
    }

    public final void ZE() {
        h.a((Context) this, getString(R.l.invoice_title_limit_error), getString(R.l.app_tip), false, null);
    }
}
