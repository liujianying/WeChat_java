package com.tencent.mm.wallet_core.ui;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Rect;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils.TruncateAt;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.wallet_core.a.a;
import com.tencent.mm.wallet_core.c.v;
import com.tenpay.android.wechat.TenpaySecureEditText;

@Deprecated
public class EditHintView extends RelativeLayout implements OnFocusChangeListener {
    private int background;
    private OnFocusChangeListener eYB;
    private TextView eYC;
    private ImageView eYE;
    private String eYF;
    private String eYG;
    private int eYH;
    private int eYI;
    public boolean eYJ;
    private boolean eYL;
    private int eYM;
    private int eYN;
    private OnClickListener eYP;
    private boolean fTt;
    private int gravity;
    private int imeOptions;
    private int inputType;
    private int mode;
    public boolean tCA;
    private DatePickerDialog uYA;
    private int uYB;
    private int uYC;
    private c uYD;
    private a uYE;
    private b uYs;
    private TextView uYt;
    TenpaySecureEditText uYu;
    private int uYv;
    private int uYw;
    private int uYx;
    private boolean uYy;
    private String uYz;

    static /* synthetic */ void o(EditHintView editHintView) {
        int cDn;
        int i = 0;
        switch (editHintView.eYH) {
            case 3:
                editHintView.getContext();
                cDn = v.cDn();
                editHintView.getContext();
                i = v.cDo();
                break;
            case 4:
                editHintView.getContext();
                cDn = v.cDp();
                i = i.cvv_tip_title;
                break;
            case 9:
                cDn = g.wallet_phone_illustration_dialog;
                i = i.wallet_card_phone_illustraction;
                break;
            case 10:
                cDn = g.wallet_name_illustration_dialog;
                i = i.wallet_card_name_illustraction;
                break;
            default:
                cDn = -1;
                break;
        }
        if (cDn != -1) {
            if (editHintView.uYD == null) {
                editHintView.uYD = b.a(editHintView.getContext(), cDn, editHintView.getResources().getString(i), editHintView.getResources().getString(i.wallet_i_know_it), new 9(editHintView));
            }
            editHintView.uYD.show();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EditHintView(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
        r8 = this;
        r7 = 2;
        r3 = 6;
        r6 = -1;
        r5 = 0;
        r4 = 1;
        r8.<init>(r9, r10);
        r0 = "";
        r8.eYF = r0;
        r0 = "";
        r8.eYG = r0;
        r8.inputType = r4;
        r8.fTt = r4;
        r8.eYN = r6;
        r8.eYM = r4;
        r0 = 19;
        r8.gravity = r0;
        r8.uYv = r6;
        r8.eYH = r6;
        r8.eYL = r5;
        r8.uYw = r4;
        r8.uYx = r6;
        r8.background = r6;
        r8.eYI = r6;
        r8.eYJ = r4;
        r8.tCA = r4;
        r8.uYy = r4;
        r0 = 0;
        r8.uYz = r0;
        r8.mode = r5;
        r0 = 0;
        r8.uYA = r0;
        r8.uYB = r5;
        r8.uYC = r5;
        r0 = new com.tencent.mm.wallet_core.ui.EditHintView$8;
        r0.<init>(r8);
        r8.eYP = r0;
        r0 = 0;
        r8.uYD = r0;
        r0 = com.tencent.mm.plugin.wxpay.a.k.EditHintView;
        r0 = r9.obtainStyledAttributes(r10, r0, r11, r5);
        r1 = com.tencent.mm.plugin.wxpay.a.k.EditHintView_hint;
        r1 = r0.getResourceId(r1, r5);
        if (r1 == 0) goto L_0x005c;
    L_0x0056:
        r1 = r9.getString(r1);
        r8.eYF = r1;
    L_0x005c:
        r1 = com.tencent.mm.plugin.wxpay.a.k.EditHintView_tipmsg;
        r1 = r0.getResourceId(r1, r5);
        if (r1 == 0) goto L_0x006a;
    L_0x0064:
        r1 = r9.getString(r1);
        r8.eYG = r1;
    L_0x006a:
        r1 = com.tencent.mm.plugin.wxpay.a.k.EditHintView_android_inputType;
        r1 = r0.getInteger(r1, r4);
        r8.inputType = r1;
        r1 = com.tencent.mm.plugin.wxpay.a.k.EditHintView_editable;
        r1 = r0.getBoolean(r1, r4);
        r8.eYJ = r1;
        r1 = com.tencent.mm.plugin.wxpay.a.k.EditHintView_android_gravity;
        r2 = 19;
        r1 = r0.getInt(r1, r2);
        r8.gravity = r1;
        r1 = com.tencent.mm.plugin.wxpay.a.k.EditHintView_android_clickable;
        r1 = r0.getBoolean(r1, r4);
        r8.fTt = r1;
        r1 = com.tencent.mm.plugin.wxpay.a.k.EditHintView_maxLength;
        r1 = r0.getInteger(r1, r6);
        r8.eYN = r1;
        r1 = com.tencent.mm.plugin.wxpay.a.k.EditHintView_editType;
        r1 = r0.getInteger(r1, r5);
        r8.eYH = r1;
        r1 = com.tencent.mm.plugin.wxpay.a.k.EditHintView_android_imeOptions;
        r2 = 5;
        r1 = r0.getInteger(r1, r2);
        r8.imeOptions = r1;
        r1 = com.tencent.mm.plugin.wxpay.a.k.EditHintView_hintTextColor;
        r2 = com.tencent.mm.plugin.wxpay.a.c.black;
        r1 = r0.getColor(r1, r2);
        r8.uYx = r1;
        r1 = com.tencent.mm.plugin.wxpay.a.k.EditHintView_android_background;
        r1 = r0.getResourceId(r1, r6);
        r8.background = r1;
        r1 = com.tencent.mm.plugin.wxpay.a.k.EditHintView_hintTextBg;
        r2 = com.tencent.mm.plugin.wxpay.a.e.edittext_bg_selector;
        r1 = r0.getResourceId(r1, r2);
        r8.eYI = r1;
        r1 = com.tencent.mm.plugin.wxpay.a.k.EditHintView_minLength;
        r1 = r0.getInteger(r1, r4);
        r8.eYM = r1;
        r1 = com.tencent.mm.plugin.wxpay.a.k.EditHintView_android_singleLine;
        r1 = r0.getBoolean(r1, r4);
        r8.tCA = r1;
        r0.recycle();
        r0 = com.tencent.mm.ui.y.gq(r9);
        r1 = com.tencent.mm.plugin.wxpay.a.g.edit_hint_view;
        r1 = r0.inflate(r1, r8, r4);
        r0 = com.tencent.mm.plugin.wxpay.a.f.hint_et;
        r0 = r1.findViewById(r0);
        r0 = (com.tenpay.android.wechat.TenpaySecureEditText) r0;
        r8.uYu = r0;
        r0 = com.tencent.mm.plugin.wxpay.a.f.tip_tv;
        r0 = r1.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r8.eYC = r0;
        r0 = com.tencent.mm.plugin.wxpay.a.f.pre_filled_tv;
        r0 = r1.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r8.uYt = r0;
        r0 = com.tencent.mm.plugin.wxpay.a.f.info_iv;
        r0 = r1.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r8.eYE = r0;
        r0 = r8.uYu;
        r1 = r8.imeOptions;
        r0.setImeOptions(r1);
        r0 = r8.eYH;
        switch(r0) {
            case 0: goto L_0x0114;
            case 1: goto L_0x0220;
            case 2: goto L_0x027a;
            case 3: goto L_0x0293;
            case 4: goto L_0x028c;
            case 5: goto L_0x0283;
            case 6: goto L_0x02a4;
            case 7: goto L_0x022d;
            case 8: goto L_0x02b1;
            case 9: goto L_0x027a;
            case 10: goto L_0x02b7;
            case 11: goto L_0x0112;
            case 12: goto L_0x02c1;
            case 13: goto L_0x02cc;
            case 14: goto L_0x0246;
            case 15: goto L_0x0260;
            case 16: goto L_0x02cc;
            case 17: goto L_0x022d;
            default: goto L_0x0112;
        };
    L_0x0112:
        r8.inputType = r4;
    L_0x0114:
        r8.cDD();
        r0 = r8.uYu;
        r1 = r8.tCA;
        r0.setSingleLine(r1);
        r0 = r8.tCA;
        if (r0 != 0) goto L_0x012a;
    L_0x0122:
        r0 = r8.uYu;
        r1 = 1073741823; // 0x3fffffff float:1.9999999 double:5.304989472E-315;
        r0.setMaxLines(r1);
    L_0x012a:
        r0 = r8.eYE;
        r1 = r8.eYP;
        r0.setOnClickListener(r1);
        r0 = r8.uYu;
        r1 = new com.tencent.mm.wallet_core.ui.EditHintView$1;
        r1.<init>(r8);
        r0.addTextChangedListener(r1);
        r0 = r8.uYu;
        r0.setOnFocusChangeListener(r8);
        r0 = r8.eYF;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x014f;
    L_0x0148:
        r0 = r8.uYu;
        r1 = r8.eYF;
        r0.setHint(r1);
    L_0x014f:
        r0 = r8.eYG;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x015e;
    L_0x0157:
        r0 = r8.eYC;
        r1 = r8.eYG;
        r0.setText(r1);
    L_0x015e:
        r0 = r8.uYu;
        r1 = r8.gravity;
        r0.setGravity(r1);
        r0 = r8.inputType;
        if (r0 != r7) goto L_0x02d3;
    L_0x0169:
        r0 = r8.uYu;
        r1 = new com.tencent.mm.wallet_core.ui.EditHintView$2;
        r1.<init>(r8);
        r0.setKeyListener(r1);
    L_0x0173:
        r0 = r8.eYN;
        if (r0 == r6) goto L_0x0187;
    L_0x0177:
        r0 = r8.uYu;
        r1 = new android.text.InputFilter[r4];
        r2 = new android.text.InputFilter$LengthFilter;
        r3 = r8.eYN;
        r2.<init>(r3);
        r1[r5] = r2;
        r0.setFilters(r1);
    L_0x0187:
        super.setEnabled(r4);
        super.setClickable(r4);
        r0 = r8.fTt;
        if (r0 != 0) goto L_0x01bb;
    L_0x0191:
        r0 = r8.uYu;
        r0.setEnabled(r5);
        r0 = r8.uYu;
        r1 = r8.getResources();
        r2 = r8.uYx;
        r1 = r1.getColor(r2);
        r0.setTextColor(r1);
        r0 = r8.uYu;
        r0.setFocusable(r5);
        r0 = r8.uYu;
        r0.setClickable(r5);
        r0 = r8.uYu;
        r1 = com.tencent.mm.plugin.wxpay.a.e.transparent_background;
        r0.setBackgroundResource(r1);
        r0 = com.tencent.mm.plugin.wxpay.a.e.list_item_normal;
        r8.setBackgroundResource(r0);
    L_0x01bb:
        r0 = r8.eYJ;
        if (r0 != 0) goto L_0x0320;
    L_0x01bf:
        r8.eYL = r4;
        r0 = r8.uYu;
        r0.setEnabled(r5);
        r0 = r8.uYu;
        r1 = r8.getResources();
        r2 = com.tencent.mm.plugin.wxpay.a.c.link_color_pressed;
        r1 = r1.getColor(r2);
        r0.setTextColor(r1);
        r0 = r8.uYu;
        r0.setFocusable(r5);
        r0 = r8.uYu;
        r0.setClickable(r5);
        r0 = r8.uYu;
        r1 = com.tencent.mm.plugin.wxpay.a.e.transparent_background;
        r0.setBackgroundResource(r1);
        r0 = com.tencent.mm.plugin.wxpay.a.e.comm_list_item_selector;
        r8.setBackgroundResource(r0);
    L_0x01eb:
        r0 = r8.background;
        if (r0 <= 0) goto L_0x01f4;
    L_0x01ef:
        r0 = r8.background;
        r8.setBackgroundResource(r0);
    L_0x01f4:
        r0 = r8.eYC;
        if (r0 == 0) goto L_0x020b;
    L_0x01f8:
        r0 = r8.uYv;
        if (r0 == r6) goto L_0x020b;
    L_0x01fc:
        r0 = r8.eYC;
        r0 = r0.getLayoutParams();
        r1 = r8.uYv;
        r0.width = r1;
        r1 = r8.eYC;
        r1.setLayoutParams(r0);
    L_0x020b:
        r0 = com.tencent.mm.model.q.GS();
        if (r0 == 0) goto L_0x021f;
    L_0x0211:
        r0 = r8.uYu;
        r1 = new com.tencent.mm.wallet_core.a.a;
        r2 = r8.getEncryptType();
        r1.<init>(r2);
        r0.setSecureEncrypt(r1);
    L_0x021f:
        return;
    L_0x0220:
        r0 = 25;
        r8.eYN = r0;
        r0 = r8.uYu;
        r0.setIsBankcardFormat(r4);
        r8.inputType = r7;
        goto L_0x0114;
    L_0x022d:
        r8.eYN = r3;
        r0 = r8.eYC;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r8.uYu;
        r0.setIsPasswordFormat(r4);
        r0 = r8.uYu;
        r0.setImeOptions(r3);
        r0 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r8.inputType = r0;
        goto L_0x0114;
    L_0x0246:
        r0 = 3;
        r8.eYN = r0;
        r0 = r8.eYC;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r8.uYu;
        r0.setIsCvvPaymentFormat(r4);
        r0 = r8.uYu;
        r0.setImeOptions(r3);
        r0 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r8.inputType = r0;
        goto L_0x0114;
    L_0x0260:
        r0 = 4;
        r8.eYN = r0;
        r0 = r8.eYC;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r8.uYu;
        r0.setIsCvv4PaymentFormat(r4);
        r0 = r8.uYu;
        r0.setImeOptions(r3);
        r0 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r8.inputType = r0;
        goto L_0x0114;
    L_0x027a:
        r0 = 30;
        r8.eYN = r0;
        r0 = 3;
        r8.inputType = r0;
        goto L_0x0114;
    L_0x0283:
        r0 = 18;
        r8.eYN = r0;
        r0 = 4;
        r8.inputType = r0;
        goto L_0x0114;
    L_0x028c:
        r0 = 4;
        r8.eYN = r0;
        r8.inputType = r7;
        goto L_0x0114;
    L_0x0293:
        r8.eYJ = r5;
        r0 = r8.uYu;
        r0.setIsValidThru(r4);
        r0 = new com.tencent.mm.wallet_core.ui.EditHintView$7;
        r0.<init>(r8);
        r8.setOnClickListener(r0);
        goto L_0x0114;
    L_0x02a4:
        r8.eYN = r3;
        r0 = r8.eYC;
        r1 = 8;
        r0.setVisibility(r1);
        r8.inputType = r7;
        goto L_0x0114;
    L_0x02b1:
        r0 = 32;
        r8.inputType = r0;
        goto L_0x0114;
    L_0x02b7:
        r0 = r8.eYJ;
        if (r0 != 0) goto L_0x0114;
    L_0x02bb:
        r0 = r8.fTt;
        if (r0 == 0) goto L_0x0114;
    L_0x02bf:
        goto L_0x0114;
    L_0x02c1:
        r0 = 12;
        r8.eYN = r0;
        r0 = r8.uYu;
        r0.setIsMoneyAmountFormat(r4);
        goto L_0x0114;
    L_0x02cc:
        r0 = r8.uYu;
        r0.setIsSecurityAnswerFormat(r4);
        goto L_0x0114;
    L_0x02d3:
        r0 = r8.inputType;
        r1 = 4;
        if (r0 != r1) goto L_0x02e4;
    L_0x02d8:
        r0 = r8.uYu;
        r1 = new com.tencent.mm.wallet_core.ui.EditHintView$3;
        r1.<init>(r8);
        r0.setKeyListener(r1);
        goto L_0x0173;
    L_0x02e4:
        r0 = r8.inputType;
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r0 != r1) goto L_0x0306;
    L_0x02ea:
        r0 = r8.uYu;
        r1 = android.text.method.PasswordTransformationMethod.getInstance();
        r0.setTransformationMethod(r1);
        r0 = r8.uYu;
        r1 = new com.tencent.mm.wallet_core.ui.EditHintView$4;
        r1.<init>(r8);
        r0.setKeyListener(r1);
        r0 = r8.uYu;
        r1 = 18;
        r0.setRawInputType(r1);
        goto L_0x0173;
    L_0x0306:
        r0 = r8.inputType;
        r1 = 3;
        if (r0 != r1) goto L_0x0317;
    L_0x030b:
        r0 = r8.uYu;
        r1 = new com.tencent.mm.wallet_core.ui.EditHintView$5;
        r1.<init>(r8);
        r0.setKeyListener(r1);
        goto L_0x0173;
    L_0x0317:
        r0 = r8.uYu;
        r1 = r8.inputType;
        r0.setInputType(r1);
        goto L_0x0173;
    L_0x0320:
        r8.eYL = r5;
        r0 = r8.uYu;
        r1 = r8.eYI;
        r0.setBackgroundResource(r1);
        r0 = com.tencent.mm.plugin.wxpay.a.e.transparent_background;
        r8.setBackgroundResource(r0);
        goto L_0x01eb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.wallet_core.ui.EditHintView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public EditHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnInputValidChangeListener(b bVar) {
        this.uYs = bVar;
    }

    public void setTipWidth(int i) {
        this.uYv = b.b(getContext(), ((float) i) * 1.0f);
        if (this.eYC != null) {
            LayoutParams layoutParams = this.eYC.getLayoutParams();
            layoutParams.width = this.uYv;
            this.eYC.setLayoutParams(layoutParams);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.eYH == 7 || this.eYH == 17 || this.eYH == 14 || this.eYH == 15) {
            int i3;
            setMeasuredDimension(getDefaultSize(b.b(getContext(), 960.0f), i), getDefaultSize(b.b(getContext(), 720.0f), i2));
            int measuredWidth = getMeasuredWidth();
            if (this.eYH == 7 || this.eYH == 17) {
                i3 = measuredWidth / 6;
            } else if (this.eYH == 14) {
                i3 = measuredWidth / 3;
            } else {
                i3 = measuredWidth / 4;
            }
            i = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(i3, 1073741824);
            setMeasuredDimension(getDefaultSize(measuredWidth, i), getDefaultSize(i3, i2));
        }
        super.onMeasure(i, i2);
    }

    public void setHintStr(String str) {
        this.uYu.setHint(str);
    }

    public void setTipStr(String str) {
        this.eYC.setText(str);
    }

    public void setPreFilledStr(String str) {
        if (bi.oW(str)) {
            this.uYt.setText("");
            this.uYt.setVisibility(8);
            return;
        }
        this.uYt.setText(str);
        this.uYt.setVisibility(0);
    }

    public void setValStr(String str) {
        switch (this.eYH) {
            case 1:
                if (bi.oW(str) || str.length() > 5) {
                    this.uYu.setText(str);
                    this.uYu.setSelection(this.uYu.getText().length());
                    return;
                }
                this.uYu.setSelection(0);
                this.uYu.setBankcardTailNum(str);
                this.eYN = 24 - str.length();
                this.uYu.setFilters(new InputFilter[]{new LengthFilter(this.eYN)});
                return;
            default:
                this.uYu.setText(str);
                this.uYu.setSelection(this.uYu.getText().length());
                return;
        }
    }

    public void set3DesValStr(String str) {
        switch (this.eYH) {
            case 1:
                if (bi.oW(str) || str.length() > 5) {
                    this.uYu.set3DesEncrptData(str);
                    this.uYu.setSelection(this.uYu.getText().length());
                    return;
                }
                this.uYu.setSelection(0);
                this.uYu.set3DesEncrptData(str);
                this.eYN = 24 - str.length();
                this.uYu.setFilters(new InputFilter[]{new LengthFilter(this.eYN)});
                return;
            default:
                this.uYu.setText(str);
                this.uYu.setSelection(this.uYu.getText().length());
                return;
        }
    }

    private void setValStrForce(String str) {
        KeyListener keyListener = this.uYu.getKeyListener();
        this.uYu.setKeyListener(null);
        setEnabled(false);
        setClickable(false);
        setValStr(str);
        this.uYu.setKeyListener(keyListener);
    }

    public void setPreText(String str) {
        KeyListener keyListener = this.uYu.getKeyListener();
        this.uYu.setInputType(1);
        this.uYu.setKeyListener(null);
        setValStr(str);
        this.uYu.setKeyListener(keyListener);
        this.mode = 4;
    }

    public void setEditBG(int i) {
        if (this.uYu != null) {
            this.uYu.setBackgroundResource(i);
        }
    }

    public void setEncryptType(int i) {
        if (q.GS()) {
            this.uYu.setSecureEncrypt(new a(i));
        }
    }

    public void setTipTextColor(int i) {
        if (this.eYC != null) {
            this.eYC.setTextColor(i);
        }
    }

    public void setMaxLen(int i) {
        if (i != -1) {
            this.eYN = i;
            this.uYu.setFilters(new InputFilter[]{new LengthFilter(i)});
        }
    }

    public void setIdentifyCardType(int i) {
        this.uYw = i;
        if (i == 1) {
            this.uYu.setKeyListener(new 6(this));
        } else {
            this.uYu.setInputType(1);
        }
    }

    public String getText() {
        TenpaySecureEditText tenpaySecureEditText;
        switch (this.eYH) {
            case 0:
            case 8:
            case 10:
                return bi.aG(this.uYu.getText().toString(), "");
            case 1:
            case 13:
            case 16:
                tenpaySecureEditText = this.uYu;
                com.tencent.mm.wallet_core.b.cCO();
                return tenpaySecureEditText.getEncryptDataWithHash(false, com.tencent.mm.wallet_core.b.cCP());
            case 2:
            case 9:
                return bi.aG(this.uYu.getText().toString(), "");
            case 3:
                return bi.aG(this.uYz, "").replace("/", "");
            case 4:
            case 14:
            case 15:
                return this.uYu.get3DesEncrptData();
            case 5:
                return this.uYu.get3DesEncrptData();
            case 6:
                return this.uYu.get3DesVerifyCode();
            case 7:
                tenpaySecureEditText = this.uYu;
                com.tencent.mm.wallet_core.b.cCO();
                return tenpaySecureEditText.getEncryptDataWithHash(true, com.tencent.mm.wallet_core.b.cCP());
            default:
                return bi.aG(this.uYu.getText().toString(), "");
        }
    }

    public String getMD5Value() {
        String replace;
        if (this.eYH == 3) {
            replace = bi.aG(this.uYz, "").replace("/", "");
        } else {
            replace = this.uYu.getText().toString();
        }
        return ac.ce(replace);
    }

    public final boolean ZF() {
        if (!this.eYJ && !this.fTt) {
            return true;
        }
        switch (this.eYH) {
            case 1:
                return this.uYu.isBankcardNum();
            case 4:
                if (this.uYu.getInputLength() <= 0) {
                    return false;
                }
                return true;
            case 5:
                return this.uYu.isAreaIDCardNum(this.uYw);
            case 7:
            case 17:
                if (this.uYu.getInputLength() != 6) {
                    return false;
                }
                return true;
            case 8:
                return bi.WF(this.uYu.getText().toString());
            case 9:
                return this.uYu.isPhoneNum();
            case 12:
                return this.uYu.isMoneyAmount();
            case 14:
                if (this.uYu.getInputLength() != 3) {
                    return false;
                }
                return true;
            case 15:
                if (this.uYu.getInputLength() != 4) {
                    return false;
                }
                return true;
            default:
                if (this.uYu.getInputLength() < this.eYM) {
                    return false;
                }
                return true;
        }
    }

    public String get3DesEncrptData() {
        return this.uYu.get3DesEncrptData();
    }

    public void setEllipsize(TruncateAt truncateAt) {
        this.uYu.setEllipsize(truncateAt);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.eYJ = z;
        this.eYE.setEnabled(true);
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        this.fTt = z;
        if (z) {
            this.uYu.setEnabled(true);
            if (this.eYJ) {
                this.uYu.setTextColor(getResources().getColor(this.uYx));
            } else {
                this.uYu.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.link_color_pressed));
            }
            this.uYu.setFocusable(true);
            this.uYu.setClickable(true);
            return;
        }
        this.uYu.setEnabled(false);
        if (this.eYJ) {
            this.uYu.setTextColor(getResources().getColor(this.uYx));
        } else {
            this.uYu.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.lightgrey));
        }
        this.uYu.setFocusable(false);
        this.uYu.setClickable(false);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.eYJ) {
            boolean z = this.eYE.getVisibility() == 0 ? getValidRectOfInfoIv().contains((int) motionEvent.getX(), (int) motionEvent.getY()) : false;
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.eYB = onFocusChangeListener;
    }

    private void cDD() {
        if (this.eYH != 7 && this.eYH != 14 && this.eYH != 15) {
            if (!this.eYJ || bi.oW(getText())) {
                switch (this.eYH) {
                    case 1:
                        if (this.uYy) {
                            this.eYE.setVisibility(0);
                            this.eYE.setImageResource(h.wallet_scan_camera);
                            return;
                        }
                        this.eYE.setVisibility(8);
                        return;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                        this.eYE.setVisibility(0);
                        this.eYE.setImageResource(e.payinfoicon);
                        return;
                    default:
                        this.eYE.setVisibility(8);
                        return;
                }
            }
            this.eYE.setVisibility(0);
            this.eYE.setImageResource(e.list_clear);
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (this.eYB != null) {
            this.eYB.onFocusChange(this, z);
        }
        x.d("MicroMsg.EditHintView", "View:" + this.eYG + ", editType:" + this.eYH + " onFocusChange to " + z);
        if (this.eYL) {
            this.eYC.setEnabled(true);
        } else {
            this.eYC.setEnabled(false);
        }
    }

    public void setImeOptions(int i) {
        this.uYu.setImeOptions(i);
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.uYu.setOnEditorActionListener(onEditorActionListener);
    }

    public void setInfoIvVisible(int i) {
        this.eYE.setVisibility(i);
    }

    private Rect getValidRectOfInfoIv() {
        Rect rect = new Rect();
        this.eYE.getHitRect(rect);
        rect.left -= 50;
        rect.right += 50;
        rect.top -= 25;
        rect.bottom += 25;
        return rect;
    }

    public void setOnInfoListener(a aVar) {
        this.uYE = aVar;
    }

    public void setShowScanCamera(boolean z) {
        this.uYy = z;
        cDD();
    }

    private int getEncryptType() {
        switch (this.eYH) {
            case 1:
                return 50;
            case 4:
            case 14:
            case 15:
                return 30;
            case 6:
                return 60;
            case 7:
                return 20;
            case 13:
                return 40;
            case 16:
                return -20;
            case 17:
                return -10;
            default:
                return 0;
        }
    }
}
