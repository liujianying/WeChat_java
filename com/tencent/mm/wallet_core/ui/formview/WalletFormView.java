package com.tencent.mm.wallet_core.ui.formview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.a.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;
import com.tenpay.android.wechat.TenpaySecureEditText;
import junit.framework.Assert;

public final class WalletFormView extends LinearLayout implements OnFocusChangeListener {
    private TextView gsY;
    private TextView mqU;
    private WalletIconImageView mqW;
    private TextView mqX;
    private OnFocusChangeListener mqZ;
    private OnClickListener mra;
    private int mrd;
    private String mre;
    private int mrf;
    private String mrg;
    private int mrh;
    private int mri;
    private int mrj;
    private String mrk;
    private int mrl;
    private String mrm;
    private int mrn;
    private int mro;
    private String mrp;
    private int mrq;
    private int mrr;
    private int mrs;
    private boolean mrt;
    private boolean mru;
    private boolean mrv;
    private int mrw;
    private int mrx;
    private int mry;
    private a uZA;
    private b uZB;
    private int uZC;
    private int uZD;
    private int uZE;
    private int uZF;
    @Deprecated
    private int uZG;
    private int uZH;
    public TenpaySecureEditText uZy;
    private a uZz;

    public WalletFormView(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        super(context, attributeSet);
        this.gsY = null;
        this.mqU = null;
        this.uZy = null;
        this.mqW = null;
        this.mqX = null;
        this.uZz = null;
        this.mqZ = null;
        this.mra = null;
        this.uZA = null;
        this.uZB = null;
        this.mrd = -1;
        this.uZC = this.mrd;
        this.uZD = 100;
        this.mre = "";
        this.mrf = 0;
        this.mrg = "";
        this.mrh = 8;
        this.mri = -1;
        this.mrj = 4;
        this.mrk = "";
        this.mrl = 8;
        this.mrm = "";
        this.uZE = -1;
        this.mrn = 19;
        this.mro = c.normal_text_color;
        this.mrp = "";
        this.uZF = 0;
        this.mrq = Integer.MAX_VALUE;
        this.mrr = 1;
        this.mrs = e.mm_trans;
        this.mrt = true;
        this.mru = false;
        this.mrv = true;
        this.mrw = 1;
        this.mrx = 5;
        this.mry = c.list_devider_color;
        this.uZG = 0;
        this.uZH = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a$k.WalletFormAttrs, i, 0);
        this.mrd = obtainStyledAttributes.getResourceId(a$k.WalletFormAttrs_layoutRes, this.mrd);
        int resourceId = obtainStyledAttributes.getResourceId(a$k.WalletFormAttrs_titleText, 0);
        if (resourceId != 0) {
            this.mre = context.getString(resourceId);
        }
        this.mri = obtainStyledAttributes.getResourceId(a$k.WalletFormAttrs_infoIvRes, this.mri);
        resourceId = obtainStyledAttributes.getResourceId(a$k.WalletFormAttrs_tipsText, 0);
        if (resourceId != 0) {
            this.mrk = context.getString(resourceId);
        }
        this.mrj = obtainStyledAttributes.getInteger(a$k.WalletFormAttrs_infoIvVisibility, this.mrj);
        this.mrf = obtainStyledAttributes.getInteger(a$k.WalletFormAttrs_titleTvVisibility, this.mrf);
        this.mrl = obtainStyledAttributes.getInteger(a$k.WalletFormAttrs_tipsTvVisibility, this.mrl);
        this.mrh = obtainStyledAttributes.getInteger(a$k.WalletFormAttrs_prefilledTvVisibility, this.mrh);
        resourceId = obtainStyledAttributes.getResourceId(a$k.WalletFormAttrs_prefilledText, 0);
        if (resourceId != 0) {
            this.mrg = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(a$k.WalletFormAttrs_contentHint, 0);
        if (resourceId != 0) {
            this.mrm = context.getString(resourceId);
        }
        this.uZE = obtainStyledAttributes.getDimensionPixelSize(a$k.WalletFormAttrs_contentHintSize, -1);
        this.mrn = obtainStyledAttributes.getInteger(a$k.WalletFormAttrs_contentGravity, this.mrn);
        this.mro = obtainStyledAttributes.getColor(a$k.WalletFormAttrs_contentTextColor, this.mro);
        resourceId = obtainStyledAttributes.getResourceId(a$k.WalletFormAttrs_contentText, 0);
        if (resourceId != 0) {
            this.mrp = context.getString(resourceId);
        }
        this.uZF = obtainStyledAttributes.getInt(a$k.WalletFormAttrs_contentFormat, this.uZF);
        this.mrq = obtainStyledAttributes.getInteger(a$k.WalletFormAttrs_contentMaxSize, this.mrq);
        this.mrr = obtainStyledAttributes.getInteger(a$k.WalletFormAttrs_contentMinSize, this.mrr);
        this.mrs = obtainStyledAttributes.getResourceId(a$k.WalletFormAttrs_contentBackground, this.mrs);
        this.mrt = obtainStyledAttributes.getBoolean(a$k.WalletFormAttrs_contentEnabled, this.mrt);
        this.mru = obtainStyledAttributes.getBoolean(a$k.WalletFormAttrs_contentClickable, this.mru);
        this.mrv = obtainStyledAttributes.getBoolean(a$k.WalletFormAttrs_contentEnabled, this.mrv);
        this.mrw = obtainStyledAttributes.getInteger(a$k.WalletFormAttrs_android_inputType, this.mrw);
        this.mrx = obtainStyledAttributes.getInteger(a$k.WalletFormAttrs_android_imeOptions, this.mrx);
        this.uZD = obtainStyledAttributes.getInteger(a$k.WalletFormAttrs_encryptType, this.uZD);
        this.mry = obtainStyledAttributes.getInteger(a$k.WalletFormAttrs_contentHintTextColor, this.mry);
        this.uZC = obtainStyledAttributes.getResourceId(a$k.WalletFormAttrs_longTitleLayoutRes, this.uZC);
        this.uZG = obtainStyledAttributes.getInteger(a$k.WalletFormAttrs_typeface, 0);
        this.uZH = obtainStyledAttributes.getInteger(a$k.WalletFormAttrs_walletTypeFace, -1);
        if (this.uZG == 1 && this.uZH == -1) {
            this.uZH = 4;
        }
        obtainStyledAttributes.recycle();
        if (this.mrd > 0) {
            z = true;
        }
        Assert.assertTrue(z);
        setOrientation(1);
        if (bi.oW(this.mre) || this.mre.length() <= 6) {
            inflate(context, this.mrd, this);
        } else {
            inflate(context, this.uZC, this);
        }
        this.gsY = (TextView) findViewById(f.wallet_title);
        this.mqU = (TextView) findViewById(f.wallet_prefilled);
        this.uZy = (TenpaySecureEditText) findViewById(f.wallet_content);
        this.mqW = (WalletIconImageView) findViewById(f.wallet_info);
        this.mqX = (TextView) findViewById(f.wallet_tips_msg);
    }

    public WalletFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void setTitleText(String str) {
        this.mre = str;
        cDU();
    }

    public final void cDS() {
        if (this.uZy != null) {
            this.uZy.setPadding(0, 0, 0, 0);
        }
    }

    public final void set3DesValStr(String str) {
        if (this.uZy == null) {
            return;
        }
        if (this.uZB == null || !this.uZB.d(this, str)) {
            this.uZy.set3DesEncrptData(str);
            setSelection(getInputLength());
        }
    }

    public final String getMD5Value() {
        String oV = bi.oV(this.uZy.getText().toString());
        if (this.uZB != null && this.uZB.bqk()) {
            oV = this.uZB.e(this, oV);
        }
        return ac.ce(oV);
    }

    public final void setImeOptions(int i) {
        if (this.uZy != null) {
            this.uZy.setImeOptions(i);
        }
    }

    public final void setInputType(int i) {
        if (this.uZy != null) {
            this.uZy.setInputType(i);
        }
    }

    public final void setText(String str) {
        if (this.uZy == null) {
            return;
        }
        if (this.uZB == null || !this.uZB.c(this, str)) {
            this.uZy.setText(str);
            this.uZy.setSelection(getInputLength());
        }
    }

    @SuppressLint({"ResourceType"})
    public final void setContentTextColorRes(int i) {
        this.mro = i;
        if (this.uZy != null) {
            this.uZy.setTextColor(getResources().getColor(this.mro));
        }
    }

    public final void setContentTextColor(int i) {
        if (this.uZy != null) {
            this.uZy.setTextColor(i);
        }
    }

    private void bql() {
        if (this.mqW != null && !bi.oW(getText()) && this.uZy != null && this.uZy.isEnabled() && this.uZy.isClickable() && this.uZy.isFocusable() && this.uZy.isFocused()) {
            this.mqW.setToClearState(new 2(this));
        } else if (this.mqW != null) {
            this.mqW.cfD();
        } else {
            x.v("MicroMsg.WalletFormView", "hy: no info iv");
        }
    }

    public final a getInputValidChangeListener() {
        return this.uZz;
    }

    public final boolean cDT() {
        return this.uZy != null ? this.uZy.isFocusable() : false;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
        cDU();
        if (getPrefilledTv() != null) {
            getPrefilledTv().setText(this.mrg);
            getPrefilledTv().setVisibility(this.mrh);
        }
        if (getInfoIv() != null) {
            getInfoIv().setImageResource(this.mri);
            getInfoIv().setVisibility(this.mrj);
        }
        if (getTipsTv() != null) {
            getTipsTv().setText(this.mrk);
            getTipsTv().setVisibility(this.mrl);
        }
        Context context = getContext();
        if (this.uZy != null) {
            if (this.uZH >= 0) {
                this.uZy.setTypeface(Typeface.createFromAsset(context.getAssets(), com.tencent.mm.wallet_core.ui.e.Hc(this.uZH)));
            }
            if (this.uZE == -1) {
                this.uZy.setHint(this.mrm);
            } else {
                CharSequence spannableString = new SpannableString(this.mrm);
                spannableString.setSpan(new AbsoluteSizeSpan(this.uZE, false), 0, spannableString.length(), 33);
                this.uZy.setHint(new SpannedString(spannableString));
            }
            this.uZy.setGravity(this.mrn);
            this.uZy.setTextColor(this.mro);
            setText(this.mrp);
            b.a(this.uZy, this.uZF);
            this.uZy.setBackgroundResource(this.mrs);
            this.uZy.setEnabled(this.mrt);
            this.uZy.setFocusable(this.mrv);
            this.uZy.setClickable(this.mru);
            this.uZy.setHintTextColor(this.mry);
            setImeOptions(this.mrx);
            setInputType(this.mrw);
            this.uZy.addTextChangedListener(new 1(this));
            this.uZy.setOnFocusChangeListener(this);
        }
        bql();
        if (this.uZy != null) {
            if (this.mrw == 2) {
                this.uZy.setKeyListener(new 3(this));
            } else if (this.mrw == 4) {
                this.uZy.setKeyListener(new 4(this));
            } else if (this.mrw == 128) {
                this.uZy.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.uZy.setKeyListener(new 5(this));
                this.uZy.setRawInputType(18);
            } else if (this.mrw == 3) {
                this.uZy.setKeyListener(new 6(this));
            } else {
                this.uZy.setInputType(this.mrw);
            }
            if (this.mrq != -1) {
                this.uZy.setFilters(new InputFilter[]{new LengthFilter(this.mrq)});
            }
        }
    }

    public final void setHint(CharSequence charSequence) {
        if (this.uZy == null) {
            return;
        }
        if (this.uZE == -1) {
            this.uZy.setHint(charSequence);
            return;
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new AbsoluteSizeSpan(this.uZE, false), 0, spannableString.length(), 33);
        this.uZy.setHint(new SpannedString(spannableString));
    }

    public final void setContentClickable(boolean z) {
        if (this.uZy != null) {
            this.uZy.setClickable(z);
        }
    }

    public final void setContentFocusable(boolean z) {
        if (this.uZy != null) {
            this.uZy.setFocusable(z);
        }
    }

    public final void setContentEnabled(boolean z) {
        if (this.uZy != null) {
            this.uZy.setEnabled(z);
        }
    }

    public final void setFilterChar(char[] cArr) {
    }

    public final void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.uZy.setOnEditorActionListener(onEditorActionListener);
    }

    @SuppressLint({"WrongCall"})
    protected final void onMeasure(int i, int i2) {
        if (this.uZA == null || !this.uZA.cDW()) {
            super.onMeasure(i, i2);
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.uZA != null && this.uZA.cDX()) {
            return true;
        }
        if (this.uZy != null && b(this.uZy, motionEvent) && !this.uZy.isClickable()) {
            x.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
            return true;
        } else if (!b(this.mqW, motionEvent) || motionEvent.getAction() != 1) {
            return false;
        } else {
            x.d("MicroMsg.WalletFormView", "hy: click on info iv");
            bql();
            this.mqW.performClick();
            return true;
        }
    }

    private boolean b(View view, MotionEvent motionEvent) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        Rect rect;
        if (view != null) {
            rect = new Rect();
            view.getHitRect(rect);
            if (view == this.mqW) {
                rect.left -= 50;
                rect.right += 50;
                rect.top -= 25;
                rect.bottom += 25;
            }
        } else {
            rect = null;
        }
        if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return true;
        }
        return false;
    }

    private void cDU() {
        if (getTitleTv() != null) {
            getTitleTv().setText(this.mre);
            getTitleTv().setVisibility(this.mrf);
        }
    }

    public final TextView getTitleTv() {
        return this.gsY;
    }

    public final WalletIconImageView getInfoIv() {
        return this.mqW;
    }

    public final TextView getTipsTv() {
        return this.mqX;
    }

    public final TextView getPrefilledTv() {
        return this.mqU;
    }

    public final void setSelection(int i) {
        if (this.uZy != null) {
            this.uZy.setSelection(i);
        }
    }

    public final a getEventDelegate() {
        return this.uZA;
    }

    public final b getLogicDelegate() {
        return this.uZB;
    }

    public final String getText() {
        if (this.uZy != null) {
            String a = c.a.a(this.uZD, this.uZy);
            if (this.uZB == null || !this.uZB.bqk()) {
                return a;
            }
            return this.uZB.e(this, a);
        }
        x.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
        return "";
    }

    public final KeyListener getKeyListener() {
        if (this.uZy != null) {
            return this.uZy.getKeyListener();
        }
        x.w("MicroMsg.WalletFormView", "hy: no content et");
        return null;
    }

    public final void setMaxInputLength(int i) {
        this.mrq = i;
    }

    public final void setMinInputLength(int i) {
        this.mrr = i;
    }

    public final int getMaxInputLength() {
        return this.mrq;
    }

    public final int getMinInputLength() {
        return this.mrr;
    }

    public final void setBankcardTail(String str) {
        if (this.uZy != null) {
            this.uZy.setBankcardTailNum(str);
        }
    }

    public final int getEncrptType() {
        return this.uZD;
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public final void setOnInfoIvClickListener(OnClickListener onClickListener) {
        this.mra = onClickListener;
        if (getInfoIv() != null) {
            getInfoIv().setOnClickListener(this.mra);
        }
    }

    public final void setOnInputValidChangeListener(a aVar) {
        this.uZz = aVar;
    }

    public final void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.mqZ = onFocusChangeListener;
    }

    public final void setEventDelegate(a aVar) {
        this.uZA = aVar;
    }

    public final void setLogicDelegate(b bVar) {
        this.uZB = bVar;
    }

    public final void setEncryptType(int i) {
        this.uZD = i;
    }

    public final boolean isPhoneNum() {
        return this.uZy == null ? false : this.uZy.isPhoneNum();
    }

    public final void a(TextWatcher textWatcher) {
        if (this.uZy != null) {
            this.uZy.addTextChangedListener(textWatcher);
        }
    }

    public final void setKeyListener(KeyListener keyListener) {
        if (this.uZy != null) {
            this.uZy.setKeyListener(keyListener);
        }
    }

    public final boolean ZF() {
        if (this.uZy != null) {
            int inputLength = this.uZy.getInputLength();
            if (inputLength > this.mrq || inputLength < this.mrr) {
                return false;
            }
            if (this.uZB != null) {
                return this.uZB.a(this);
            }
            return true;
        }
        x.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
        return true;
    }

    public final void bqn() {
        if (this.uZy != null) {
            this.uZy.ClearInput();
        }
    }

    public final void bqm() {
        if (this.uZy != null) {
            this.uZy.clearFocus();
        }
    }

    public final boolean dX(View view) {
        if (getVisibility() != 0) {
            if (view != null) {
                view.setVisibility(8);
            }
            return true;
        } else if (bi.oW(getText())) {
            if (view != null) {
                view.setVisibility(4);
            }
            if (this.gsY == null) {
                return false;
            }
            this.gsY.setEnabled(true);
            return false;
        } else if (ZF()) {
            if (view != null) {
                view.setVisibility(4);
            }
            if (this.gsY != null) {
                this.gsY.setEnabled(true);
            }
            return true;
        } else {
            if (view != null) {
                view.setVisibility(0);
            }
            if (this.gsY == null) {
                return false;
            }
            this.gsY.setEnabled(false);
            return false;
        }
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        if (this.uZy != null) {
            this.uZy.setFilters(inputFilterArr);
        }
    }

    public final int getInputLength() {
        return this.uZy != null ? this.uZy.getInputLength() : 0;
    }

    public final void cDV() {
        if (this.uZy != null) {
            this.uZy.setFocusable(true);
            this.uZy.requestFocus();
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.uZy, 0);
        }
    }

    public final void d(WalletBaseUI walletBaseUI) {
        if (this.uZy != null) {
            this.uZy.setFocusable(true);
            this.uZy.requestFocus();
            walletBaseUI.cDJ();
        }
    }

    public final void setIsSecretAnswer(boolean z) {
        if (this.uZy != null) {
            this.uZy.setIsSecurityAnswerFormat(z);
        }
    }

    public final void onFocusChange(View view, boolean z) {
        if (this.mqZ != null) {
            this.mqZ.onFocusChange(this, z);
        }
        if (this.uZz != null) {
            this.uZz.fE(ZF());
        }
        if (ZF()) {
            if (this.gsY != null) {
                this.gsY.setEnabled(true);
            }
        } else if (this.gsY != null) {
            this.gsY.setEnabled(false);
        }
        bql();
    }

    public final void set3DesToView(String str) {
        if (this.uZy != null) {
            this.uZy.set3DesEncrptData(str);
        }
    }
}
