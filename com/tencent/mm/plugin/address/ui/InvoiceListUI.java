package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.b.b.a;
import com.tencent.mm.plugin.address.e.d;
import com.tencent.mm.plugin.q.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.LinkedList;

public class InvoiceListUI extends MMActivity implements e {
    private b eYZ;
    private TextView eYl = null;
    private boolean eYw = false;
    private a eZa;
    private ListView eZb;
    private a eZc = null;
    private TextView eZd = null;
    private LinkedList<b> eZe = new LinkedList();
    private boolean eZf = false;
    private boolean eZg = false;
    private Object lockObj = new Object();

    static /* synthetic */ void a(InvoiceListUI invoiceListUI) {
        h.mEJ.h(14199, new Object[]{Integer.valueOf(2)});
        invoiceListUI.jt(0);
    }

    static /* synthetic */ void b(InvoiceListUI invoiceListUI, b bVar) {
        if (bVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (bVar.type != null && bVar.type.equals("0")) {
                if (!TextUtils.isEmpty(bVar.title)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.invoice_title));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.title);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.knC)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.invoice_tax_number));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.knC);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.knI)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.invoice_company_address));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.knI);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.knG)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.invoice_phone_number));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.knG);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.knE)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.invoice_bank_name));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.knE);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.knD)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.invoice_bank_number));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.knD);
                    stringBuilder.append(" \n");
                }
            } else if (!(bVar.type == null || !bVar.type.equals("1") || TextUtils.isEmpty(bVar.knB))) {
                stringBuilder.append(invoiceListUI.getString(R.l.invoice_title));
                stringBuilder.append("：");
                stringBuilder.append(bVar.knB);
                stringBuilder.append(" \n");
            }
            try {
                d.R(invoiceListUI.mController.tml, stringBuilder.toString());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.InvoiceListUI", e, "", new Object[0]);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.eYw = intent.getBooleanExtra("launch_from_webview", false);
        this.eZf = intent.getBooleanExtra("launch_from_appbrand", false);
        if (this.eYw || this.eZf) {
            this.eYw = true;
        }
        if (this.eYw) {
            au.HU();
            boolean booleanValue = ((Boolean) c.DT().get(aa.a.sUh, Boolean.valueOf(true))).booleanValue();
            x.i("MicroMsg.InvoiceListUI", "showDisclaimerDailog..isShowDisclaimerDialog " + booleanValue);
            if (booleanValue) {
                x.i("MicroMsg.InvoiceListUI", "showDisclaimerDialog");
                com.tencent.mm.ui.base.h.a(this, getString(R.l.invoice_third_party_disclaimer_content), getString(R.l.invoice_third_party_disclaimer_title), getString(R.l.I_known), false, new 6(this));
                au.HU();
                c.DT().a(aa.a.sUh, Boolean.valueOf(false));
            }
        }
        setMMTitle(R.l.settings_my_invoice_information);
        au.DF().a(1194, this);
        au.DF().a(1191, this);
        initView();
        ZH();
    }

    public void onDestroy() {
        au.DF().b(1194, this);
        au.DF().b(1191, this);
        super.onDestroy();
    }

    public void onResume() {
        au.DF().a(new com.tencent.mm.plugin.address.model.b(), 0);
        super.onResume();
    }

    private void ZH() {
        synchronized (this.lockObj) {
            com.tencent.mm.plugin.address.a.a.Zv();
            this.eZe = com.tencent.mm.plugin.address.a.a.Zw().eXD.knz;
            this.eZa.dEw = this.eZe;
            this.eZe.size();
            this.eZa.notifyDataSetChanged();
        }
    }

    public final void initView() {
        this.eZd = (TextView) findViewById(R.h.import_invoice_tv);
        if (this.eZd != null) {
            this.eZd.setVisibility(8);
        }
        if (this.eYw) {
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
        this.eZd.setOnClickListener(new 1(this));
        this.eZb = (ListView) findViewById(R.h.settings_lv_invoice);
        this.eZa = new a(this, this);
        this.eZb.setAdapter(this.eZa);
        this.eZb.setOnItemClickListener(new 2(this));
        this.eZb.setOnItemLongClickListener(new 3(this));
        this.eZa.notifyDataSetChanged();
        setBackBtn(new 4(this));
        addIconOptionMenu(0, R.l.settings_add_invoice, R.k.actionbar_icon_dark_add, new 5(this));
    }

    protected final int getLayoutId() {
        return R.i.invoice_list_ui;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0) {
            return;
        }
        if (lVar.getType() == 1191) {
            ZH();
            if (this.eYw) {
                com.tencent.mm.plugin.address.a.a.Zv();
                if (com.tencent.mm.plugin.address.a.a.Zw().eXD.knz.size() == 0 && !this.eZg) {
                    Intent intent = new Intent();
                    intent.setClass(this, AddInvoiceUI.class);
                    intent.putExtra("launch_from_webview", true);
                    startActivityForResult(intent, 1);
                }
            }
        } else if (lVar.getType() == 1194) {
            au.DF().a(new com.tencent.mm.plugin.address.model.b(), 0);
            this.eZg = true;
        }
    }

    private void jt(int i) {
        Intent intent = new Intent();
        if (i != 0) {
            intent.setClass(this, QrcodeInvoiceUI.class);
            intent.putExtra("invoice_id", i);
        } else {
            intent.setClass(this, AddInvoiceUI.class);
            intent.putExtra("launch_from_invoicelist_webview", this.eYw);
            intent.putExtra("invoice_id", i);
        }
        startActivity(intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (-1 == i2) {
                b bVar;
                if (intent == null) {
                    x.e("MicroMsg.InvoiceUtil", "intent is null");
                    bVar = null;
                } else {
                    bVar = new b();
                    bVar.type = intent.getStringExtra(DownloadSettingTable$Columns.TYPE);
                    if (bVar.type == null || !bVar.type.equals("1")) {
                        bVar.title = intent.getStringExtra("title");
                        bVar.knC = intent.getStringExtra("tax_number");
                        bVar.knI = intent.getStringExtra("company_address");
                        bVar.knG = intent.getStringExtra("telephone");
                        bVar.knE = intent.getStringExtra("bank_name");
                        bVar.knD = intent.getStringExtra("bank_account");
                    } else {
                        bVar.knB = intent.getStringExtra("title");
                    }
                }
                Intent intent2 = new Intent();
                intent2.putExtra("choose_invoice_title_info", com.tencent.mm.plugin.address.e.e.a(bVar));
                setResult(-1, intent2);
            } else {
                setResult(0);
            }
            finish();
        }
    }
}
