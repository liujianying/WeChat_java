package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.q.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.s;

public class QrcodeInvoiceUI extends MMActivity {
    private Dialog eXG = null;
    private int eYg = 0;
    private TextView eYk;
    private b eYu = null;
    private Bitmap eZA;
    private o eZB = null;
    private ImageView eZC;
    private View eZD;
    private float eZE = 0.0f;
    private OnClickListener eZF = new 5(this);
    private OnClickListener eZG = new 6(this);
    private InvoiceQrcodeTextView eZt;
    private InvoiceQrcodeTextView eZu;
    private InvoiceQrcodeTextView eZv;
    private InvoiceQrcodeTextView eZw;
    private InvoiceQrcodeTextView eZx;
    private InvoiceQrcodeTextView eZy;
    private InvoiceQrcodeTextView eZz;

    static /* synthetic */ void c(QrcodeInvoiceUI qrcodeInvoiceUI) {
        LayoutParams attributes = qrcodeInvoiceUI.getWindow().getAttributes();
        if (attributes.screenBrightness > qrcodeInvoiceUI.eZE) {
            attributes.screenBrightness = qrcodeInvoiceUI.eZE;
            qrcodeInvoiceUI.getWindow().setAttributes(attributes);
        }
    }

    static /* synthetic */ void d(QrcodeInvoiceUI qrcodeInvoiceUI) {
        LayoutParams attributes = qrcodeInvoiceUI.getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            qrcodeInvoiceUI.eZE = attributes.screenBrightness;
            attributes.screenBrightness = 0.85f;
            qrcodeInvoiceUI.getWindow().setAttributes(attributes);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.QrcodeInvoiceUI", "index Oncreate");
        this.eYg = getIntent().getIntExtra("invoice_id", 0);
        setMMTitle(R.l.invoice_qrcode_title);
    }

    public void onResume() {
        getWindow().setSoftInputMode(3);
        super.onResume();
        initView();
    }

    public final void initView() {
        findViewById(R.h.qrcode_invoice_sv);
        this.eZt = (InvoiceQrcodeTextView) findViewById(R.h.qrcode_invoice_title);
        if (this.eZt != null) {
            this.eZt.ZI();
        }
        this.eZu = (InvoiceQrcodeTextView) findViewById(R.h.qrcode_invoice_person_title);
        if (this.eZu != null) {
            this.eZu.ZI();
        }
        this.eZv = (InvoiceQrcodeTextView) findViewById(R.h.qrcode_invoice_tax_number);
        if (this.eZv != null) {
            this.eZv.ZI();
        }
        this.eZw = (InvoiceQrcodeTextView) findViewById(R.h.qrcode_invoice_company_address);
        if (this.eZw != null) {
            this.eZw.ZI();
        }
        this.eZx = (InvoiceQrcodeTextView) findViewById(R.h.qrcode_invoice_phone_number);
        if (this.eZx != null) {
            this.eZx.ZI();
        }
        this.eZy = (InvoiceQrcodeTextView) findViewById(R.h.qrcode_invoice_bank_name);
        if (this.eZy != null) {
            this.eZy.ZI();
        }
        this.eZz = (InvoiceQrcodeTextView) findViewById(R.h.qrcode_invoice_bank_number);
        if (this.eZz != null) {
            this.eZz.ZI();
        }
        this.eZv.eYS = true;
        this.eZv.eYL = true;
        if (this.eYg != 0) {
            this.eYk = (TextView) findViewById(R.h.qrcode_type_tv);
            this.eYu = a.Zw().jp(this.eYg);
            if (this.eYu == null) {
                x.i("MicroMsg.QrcodeInvoiceUI", "invoiceSvrObj is null ,now finish..");
                finish();
            }
            if (this.eYu != null && this.eYu.type != null && this.eYu.type.equals("0")) {
                this.eYk.setText(getString(R.l.invoice_company_type_title));
                this.eZu.setVisibility(8);
                if (this.eYu.knC == null || this.eYu.knC.equals("")) {
                    this.eZv.setVisibility(8);
                } else {
                    this.eZv.setVisibility(0);
                    this.eZv.setValStr(this.eYu.knC);
                }
                if (this.eYu.knI == null || this.eYu.knI.equals("")) {
                    this.eZw.setVisibility(8);
                } else {
                    this.eZw.setVisibility(0);
                    this.eZw.setValStr(this.eYu.knI);
                }
                if (this.eYu.knG == null || this.eYu.knG.equals("")) {
                    this.eZx.setVisibility(8);
                } else {
                    this.eZx.setVisibility(0);
                    this.eZx.setValStr(this.eYu.knG);
                }
                if (this.eYu.knE == null || this.eYu.knE.equals("")) {
                    this.eZy.setVisibility(8);
                } else {
                    this.eZy.setVisibility(0);
                    this.eZy.setValStr(this.eYu.knE);
                }
                if (this.eYu.knD == null || this.eYu.knD.equals("")) {
                    this.eZz.setVisibility(8);
                } else {
                    this.eZz.setVisibility(0);
                    this.eZz.setValStr(this.eYu.knD);
                }
            } else if (!(this.eYu == null || this.eYu.type == null || !this.eYu.type.equals("1"))) {
                this.eYk.setText(getString(R.l.invoice_personal_type_title));
                this.eZt.setVisibility(8);
                this.eZv.setVisibility(8);
                this.eZw.setVisibility(8);
                this.eZx.setVisibility(8);
                this.eZy.setVisibility(8);
                this.eZz.setVisibility(8);
            }
            this.eYk.setVisibility(0);
            if (this.eYu != null) {
                this.eZt.setValStr(this.eYu.title);
                this.eZu.setValStr(this.eYu.knB);
            }
            if (this.eZB == null) {
                View inflate = View.inflate(this, R.i.invoice_popup_window, null);
                inflate.setOnClickListener(new 3(this));
                this.eZD = inflate.findViewById(R.h.invoice_popup_qrcode_layout);
                this.eZC = (ImageView) inflate.findViewById(R.h.invoice_popup_qrcode_iv);
                this.eZB = new o(inflate, -1, -1, true);
                this.eZB.setClippingEnabled(false);
                this.eZB.update();
                this.eZB.setBackgroundDrawable(new ColorDrawable(16777215));
                this.eZB.setOnDismissListener(new 4(this));
            }
        } else {
            x.i("MicroMsg.QrcodeInvoiceUI", "serverId is 0,now finish...");
            finish();
        }
        setBackBtn(new 1(this));
        a(0, getString(R.l.app_edit), new 2(this), s.b.tmX);
        ImageView imageView;
        View findViewById;
        TextView textView;
        if (this.eYu == null || this.eYu.knJ == null || this.eYu.knJ.equals("")) {
            imageView = (ImageView) findViewById(R.h.invoice_qrcode_bar_area);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            findViewById = findViewById(R.h.invoice_qrcode_line);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            textView = (TextView) findViewById(R.h.qrcode_bitmap_tip_tv);
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        imageView = (ImageView) findViewById(R.h.invoice_qrcode_bar_area);
        if (imageView != null) {
            imageView.setVisibility(0);
            this.eZA = com.tencent.mm.bm.a.a.b(this, this.eYu.knJ, 0, 3);
            imageView.setImageBitmap(this.eZA);
            imageView.setOnClickListener(this.eZG);
        }
        findViewById = findViewById(R.h.invoice_qrcode_line);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        textView = (TextView) findViewById(R.h.qrcode_bitmap_tip_tv);
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void showPopupWindow(View view) {
        if (this.eZB != null && !this.eZB.isShowing()) {
            this.eZB.showAtLocation(view.getRootView(), 17, 0, 0);
            this.eZB.setFocusable(true);
            this.eZB.setTouchable(true);
            this.eZB.setBackgroundDrawable(new ColorDrawable(16777215));
            this.eZB.setOutsideTouchable(true);
            this.eZD.setVisibility(0);
            this.eZC.setOnClickListener(this.eZF);
            this.eZC.setImageBitmap(this.eZA);
            if (this.eZA != null) {
                x.e("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp != null");
            } else {
                x.i("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp == null");
            }
            this.eZB.update();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("karea_result");
                    if (!bi.oW(stringExtra)) {
                        x.d("MicroMsg.QrcodeInvoiceUI", "AREA_RESULT:" + stringExtra);
                        this.eZx.setValStr(stringExtra);
                    }
                    stringExtra = intent.getStringExtra("kpost_code");
                    if (!bi.oW(stringExtra)) {
                        x.d("MicroMsg.QrcodeInvoiceUI", "post:" + stringExtra);
                        this.eZx.setValStr(stringExtra);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                if (i2 != -1) {
                    x.i("MicroMsg.QrcodeInvoiceUI", "MallRecharge pay result : cancel");
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.mm_qrcode_invoice_ui;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        setResult(0);
        finish();
        return true;
    }
}
