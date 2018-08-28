package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.appbrand.a.g;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.ArrayList;

@a(19)
public class WxaLuckyMoneyPrepareUI extends WxaLuckyMoneyBaseUI implements c, f {
    private TextView hXQ = null;
    private TextView hXT;
    private h.a kLx = h.a.kKZ;
    private a kMe = null;
    private LuckyMoneyNumInputView kMf = null;
    private WxaLuckyMoneyMoneyInputView kMg = null;
    private LuckyMoneyTextInputView kMh = null;
    private Button kMi = null;
    private LinearLayout kMj;
    protected View kMk;
    private TextView kMl;
    private MMScrollView kMm;
    private TextView kMn;
    private int kMo = 0;
    private com.tencent.mm.plugin.luckymoney.ui.a kMp = new com.tencent.mm.plugin.luckymoney.ui.a();
    protected MyKeyboardWindow mKeyboard;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        this.kMe = new d();
        this.kMe.a(this, getIntent());
    }

    public final MMActivity baA() {
        return this;
    }

    public final void baB() {
    }

    public final void Ga(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(i.wallet_unknown_err);
        }
        com.tencent.mm.ui.base.h.a(this, str, null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }

    protected final void initView() {
        setBackBtn(new 10(this));
        this.kMh = (LuckyMoneyTextInputView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_wish_et);
        this.kMh.setHintText(getString(i.lucky_money_default_wish));
        String stringExtra = getIntent().getStringExtra("defaultWishingWord");
        x.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initView defaultWishingWord = %s", new Object[]{stringExtra});
        if (!bi.oW(stringExtra)) {
            this.kMh.setHintText(stringExtra);
        }
        this.kMi = (Button) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_btn);
        this.mKeyboard = (MyKeyboardWindow) findViewById(com.tencent.mm.plugin.wxpay.a.f.tenpay_num_keyboard);
        this.kMk = findViewById(com.tencent.mm.plugin.wxpay.a.f.tenpay_keyboard_layout);
        this.hXT = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_amount_tips);
        this.kMf = (LuckyMoneyNumInputView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_num_et);
        this.kMg = (WxaLuckyMoneyMoneyInputView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_amount_et);
        this.hXQ = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_total_amount);
        this.kMm = (MMScrollView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_sv);
        this.kMn = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_notice_tips);
        this.kMj = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_range_ll);
        this.kMl = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_range_result);
        setMMTitle(i.lucky_money_to_send_title);
        if (this.kLx == h.a.kKZ) {
            this.kMg.setTitle(getString(i.lucky_money_total_amount_title));
            this.kMg.setShowGroupIcon(true);
        } else {
            this.kMg.setTitle(getString(i.lucky_money_unit_amount_title));
            this.kMg.setShowGroupIcon(false);
        }
        this.kMg.setOnInputValidChangerListener(this);
        this.kMg.setHint(getString(i.lucky_money_money_hint));
        this.kMf.setOnInputValidChangerListener(this);
        this.kMf.setHint(getString(i.lucky_money_num_hint));
        this.kMf.setNum("");
        this.kMh.setOnInputValidChangerListener(this);
        EditText editText = (EditText) this.kMg.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_et);
        EditText editText2 = (EditText) this.kMf.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_et);
        e.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) this.mController.tml.getSystemService("input_method")).showSoftInput(editText, 0);
        editText.addTextChangedListener(new 17(this));
        editText.setOnClickListener(new 2(this, editText, editText2));
        editText.requestFocus();
        TextView textView = (TextView) this.kMg.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_amount_unit_title);
        if (textView != null) {
            textView.setOnClickListener(new 3(this, editText, editText2));
        }
        e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.mController.tml.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new 4(this, editText, editText2));
        ((MMEditText) this.kMh.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_text)).setOnFocusChangeListener(new 5(this, editText, editText2));
        g gVar = g.kKP;
        if (this.kLx == h.a.kKZ) {
            this.kMg.setMaxAmount(gVar.kKT);
        } else {
            this.kMg.setMaxAmount(gVar.kKR);
        }
        this.kMg.setMinAmount(gVar.kKS);
        this.kMf.setMaxNum(gVar.kKQ);
        h.a aVar = h.a.kKZ;
        this.kMf.setMinNum(1);
        this.kMg.setMaxLen(12);
        String string = getString(i.lucky_money_f2f_random_tip_prefix);
        String string2 = getString(i.lucky_money_group_tips_change_to_fixed);
        String string3 = getString(i.lucky_money_f2f_fixed_tip_prefix);
        String string4 = getString(i.lucky_money_group_tips_change_to_random);
        com.tencent.mm.plugin.wallet_core.ui.h hVar = new com.tencent.mm.plugin.wallet_core.ui.h(this);
        CharSequence spannableString = new SpannableString(string + string2);
        spannableString.setSpan(hVar, string.length(), string.length() + string2.length(), 33);
        SpannableString spannableString2 = new SpannableString(string3 + string4);
        com.tencent.mm.plugin.wallet_core.ui.h hVar2 = new com.tencent.mm.plugin.wallet_core.ui.h(this);
        spannableString2.setSpan(hVar2, string3.length(), string3.length() + string4.length(), 33);
        hVar.pvm = new 14(this, spannableString2);
        hVar2.pvm = new 15(this, spannableString);
        this.hXT.setMovementMethod(LinkMovementMethod.getInstance());
        this.hXT.setText(spannableString);
        this.hXT.setVisibility(0);
        this.kMi.setClickable(false);
        this.kMi.setEnabled(false);
        this.kMi.setOnClickListener(new 11(this, stringExtra));
        this.kMp.a(this.kMf);
        this.kMp.a(this.kMg);
        this.kMp.a(this.kMh);
        this.kMp.f((TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_error_tips));
        if (this.kMm != null) {
            this.kMm.setOnTouchListener(new 12(this));
        }
        this.kMg.setType(this.kLx);
        addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.lucky_money_help_btn, new 13(this));
        int intExtra = getIntent().getIntExtra("range", 0);
        x.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initRange range = %d", new Object[]{Integer.valueOf(intExtra)});
        this.kMj.setVisibility(8);
        if (intExtra == 0) {
            this.kMo = 0;
        } else if (intExtra == 1) {
            this.kMo = 1;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(getString(i.wxa_lucky_money_range_friend));
            arrayList.add(getString(i.wxa_lucky_money_range_public));
            this.kMj.setVisibility(0);
            this.kMl.setText((CharSequence) arrayList.get(this.kMo));
            this.kMj.setOnClickListener(new 16(this, arrayList));
        }
    }

    public void onBackPressed() {
        setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.kMp.clear();
        if (this.kMe != null) {
            this.kMe.onDestroy();
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.wxa_lucky_money_prepare_ui;
    }

    protected final void z(View view, int i) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(com.tencent.mm.plugin.wxpay.a.f.tenpay_num_keyboard);
        this.kMk = findViewById(com.tencent.mm.plugin.wxpay.a.f.tenpay_keyboard_layout);
        View findViewById = findViewById(com.tencent.mm.plugin.wxpay.a.f.tenpay_push_down);
        EditText editText = (EditText) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_et);
        if (this.mKeyboard != null && editText != null && this.kMk != null) {
            e.setNoSystemInputOnEditText(editText);
            editText.setOnFocusChangeListener(new 6(this, i, editText));
            editText.setOnClickListener(new 7(this, i, editText));
            TextView textView = (TextView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_amount_unit_title);
            if (textView != null) {
                textView.setOnClickListener(new 8(this, editText, view, i));
            }
            findViewById.setOnClickListener(new 9(this));
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.kMk == null || !this.kMk.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.kMk.setVisibility(8);
        return true;
    }

    protected final void Wq() {
        if (this.kMk != null && this.kMk.isShown()) {
            this.kMk.setVisibility(8);
        }
    }

    public final void baD() {
        double d;
        double d2;
        if (this.kMg.baC() == 3 || this.kMf.baC() == 3) {
            d = 0.0d;
            d2 = 0.0d;
        } else {
            int input = this.kMf.getInput();
            d2 = this.kMg.getInput();
            if (this.kLx == h.a.kLa) {
                d2 *= (double) input;
                d = this.kMg.getInput();
            } else {
                d = input > 0 ? this.kMg.getInput() / ((double) input) : 0.0d;
            }
        }
        boolean bbv = this.kMp.bbv();
        g gVar = g.kKP;
        if (bbv) {
            x.i("MicroMsg.WxaLuckyMoneyPrepareUI", "has error");
            this.kMi.setClickable(false);
            this.kMi.setEnabled(false);
        } else {
            boolean z;
            if (d2 == 0.0d || d == 0.0d) {
                z = true;
            } else if (d2 > gVar.kKT && gVar.kKT > 0.0d) {
                this.kMp.tn(getString(i.lucky_money_total_amount_max_limit_tips, new Object[]{Math.round(gVar.kKT), bi.aG(gVar.kKW, "")}));
                z = true;
            } else if (d > 0.0d) {
                x.i("MicroMsg.WxaLuckyMoneyPrepareUI", "perAmount " + d);
                if (this.kLx == h.a.kLa) {
                    if (d > gVar.kKR && gVar.kKR > 0.0d) {
                        this.kMp.tn(getString(i.lucky_money_per_amount_max_limit_tips, new Object[]{Math.round(gVar.kKR), bi.aG(gVar.kKW, "")}));
                        z = true;
                    }
                    z = false;
                } else {
                    if (d > gVar.kKU && gVar.kKU > 0.0d) {
                        this.kMp.tn(getString(i.lucky_money_per_amount_max_limit_tips, new Object[]{Math.round(gVar.kKU), bi.aG(gVar.kKW, "")}));
                        this.kMf.onError();
                        this.kMg.onError();
                        z = true;
                    }
                    z = false;
                }
                x.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for max value");
                if (!z) {
                    if (this.kLx == h.a.kLa) {
                        if (d < gVar.kKS) {
                            this.kMp.tn(getString(i.lucky_money_per_amount_min_limit_tips, new Object[]{e.A(gVar.kKS), bi.aG(gVar.kKW, "")}));
                            z = true;
                        }
                    } else if (d < 0.01d) {
                        this.kMp.tn(getString(i.lucky_money_per_amount_min_limit_tips, new Object[]{"0.01", bi.aG(gVar.kKW, "")}));
                        this.kMf.onError();
                        this.kMg.onError();
                        z = true;
                    }
                }
                x.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for min value");
            } else {
                z = false;
            }
            if (z) {
                this.kMi.setClickable(false);
                this.kMi.setEnabled(false);
            } else {
                this.kMi.setClickable(true);
                this.kMi.setEnabled(true);
            }
        }
        String str = gVar.kKV;
        if (bi.oW(str)) {
            this.hXQ.setText(e.B(d2));
        } else {
            this.hXQ.setText(str + e.A(d2));
        }
    }
}
