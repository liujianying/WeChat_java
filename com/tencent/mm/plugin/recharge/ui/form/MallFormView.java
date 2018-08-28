package com.tencent.mm.plugin.recharge.ui.form;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class MallFormView extends LinearLayout implements OnFocusChangeListener {
    private TextView gsY;
    private TextView mqU;
    public EditText mqV;
    private WalletIconImageView mqW;
    private TextView mqX;
    private a mqY;
    private OnFocusChangeListener mqZ;
    private OnClickListener mra;
    private a mrb;
    private b mrc;
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
    public boolean mrz;

    public MallFormView(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        super(context, attributeSet);
        this.gsY = null;
        this.mqU = null;
        this.mqV = null;
        this.mqW = null;
        this.mqX = null;
        this.mqY = null;
        this.mqZ = null;
        this.mra = null;
        this.mrb = null;
        this.mrc = null;
        this.mrd = -1;
        this.mre = "";
        this.mrf = 0;
        this.mrg = "";
        this.mrh = 8;
        this.mri = -1;
        this.mrj = 4;
        this.mrk = "";
        this.mrl = 8;
        this.mrm = "";
        this.mrn = 19;
        this.mro = c.normal_text_color;
        this.mrp = "";
        this.mrq = Integer.MAX_VALUE;
        this.mrr = 1;
        this.mrs = a$e.mm_trans;
        this.mrt = true;
        this.mru = false;
        this.mrv = true;
        this.mrw = 1;
        this.mrx = 5;
        this.mry = c.list_devider_color;
        this.mrz = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.MallFormAttrs, i, 0);
        this.mrd = obtainStyledAttributes.getResourceId(k.MallFormAttrs_malllayoutRes, this.mrd);
        int resourceId = obtainStyledAttributes.getResourceId(k.MallFormAttrs_malltitleText, 0);
        if (resourceId != 0) {
            this.mre = context.getString(resourceId);
        }
        this.mri = obtainStyledAttributes.getResourceId(k.MallFormAttrs_mallinfoIvRes, this.mri);
        resourceId = obtainStyledAttributes.getResourceId(k.MallFormAttrs_malltipsText, 0);
        if (resourceId != 0) {
            this.mrk = context.getString(resourceId);
        }
        this.mrj = obtainStyledAttributes.getInteger(k.MallFormAttrs_mallinfoIvVisibility, this.mrj);
        this.mrf = obtainStyledAttributes.getInteger(k.MallFormAttrs_malltitleTvVisibility, this.mrf);
        this.mrl = obtainStyledAttributes.getInteger(k.MallFormAttrs_malltipsTvVisibility, this.mrl);
        this.mrh = obtainStyledAttributes.getInteger(k.MallFormAttrs_mallprefilledTvVisibility, this.mrh);
        resourceId = obtainStyledAttributes.getResourceId(k.MallFormAttrs_mallprefilledText, 0);
        if (resourceId != 0) {
            this.mrg = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(k.MallFormAttrs_mallcontentHint, 0);
        if (resourceId != 0) {
            this.mrm = context.getString(resourceId);
        }
        this.mrn = obtainStyledAttributes.getInteger(k.MallFormAttrs_mallcontentGravity, this.mrn);
        this.mro = obtainStyledAttributes.getColor(k.MallFormAttrs_mallcontentTextColor, this.mro);
        resourceId = obtainStyledAttributes.getResourceId(k.MallFormAttrs_mallcontentText, 0);
        if (resourceId != 0) {
            this.mrp = context.getString(resourceId);
        }
        this.mrq = obtainStyledAttributes.getInteger(k.MallFormAttrs_mallcontentMaxSize, this.mrq);
        this.mrr = obtainStyledAttributes.getInteger(k.MallFormAttrs_mallcontentMinSize, this.mrr);
        this.mrs = obtainStyledAttributes.getResourceId(k.MallFormAttrs_mallcontentBackground, this.mrs);
        this.mrt = obtainStyledAttributes.getBoolean(k.MallFormAttrs_mallcontentEnabled, this.mrt);
        this.mru = obtainStyledAttributes.getBoolean(k.MallFormAttrs_mallcontentClickable, this.mru);
        this.mrv = obtainStyledAttributes.getBoolean(k.MallFormAttrs_mallcontentEnabled, this.mrv);
        this.mrw = obtainStyledAttributes.getInteger(k.MallFormAttrs_android_inputType, this.mrw);
        this.mrx = obtainStyledAttributes.getInteger(k.MallFormAttrs_android_imeOptions, this.mrx);
        this.mry = obtainStyledAttributes.getInteger(k.MallFormAttrs_mallcontentHintTextColor, this.mry);
        obtainStyledAttributes.recycle();
        if (this.mrd > 0) {
            z = true;
        }
        Assert.assertTrue(z);
        setOrientation(1);
        inflate(context, this.mrd, this);
        this.gsY = (TextView) findViewById(f.mall_title);
        this.mqU = (TextView) findViewById(f.mall_prefilled);
        this.mqV = (EditText) findViewById(f.mall_content);
        this.mqW = (WalletIconImageView) findViewById(f.mall_info);
        this.mqX = (TextView) findViewById(f.mall_tips_msg);
    }

    public MallFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final EditText getContentEditText() {
        return this.mqV;
    }

    public final void setImeOptions(int i) {
        if (this.mqV != null) {
            this.mqV.setImeOptions(i);
        }
    }

    public final void setInputType(int i) {
        if (this.mqV != null) {
            this.mqV.setInputType(i);
        }
    }

    public final void setText(String str) {
        if (this.mqV != null) {
            this.mqV.setText(str);
            this.mqV.setSelection(getInputLength());
        }
    }

    public final void bql() {
        if (this.mqW != null && !bi.oW(getText()) && this.mqV != null && this.mqV.isEnabled() && this.mqV.isClickable() && this.mqV.isFocusable() && this.mqV.isFocused()) {
            this.mqW.setToClearState(new 2(this));
        } else if (this.mqW != null) {
            this.mqW.cfD();
        } else {
            x.v("MicroMsg.WalletFormView", "hy: no info iv");
        }
    }

    public final a getInputValidChangeListener() {
        return this.mqY;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
        if (getTitleTv() != null) {
            getTitleTv().setText(this.mre);
            getTitleTv().setVisibility(this.mrf);
        }
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
        getContext();
        if (this.mqV != null) {
            this.mqV.setHint(this.mrm);
            this.mqV.setGravity(this.mrn);
            this.mqV.setTextColor(this.mro);
            setText(this.mrp);
            this.mqV.setBackgroundResource(this.mrs);
            this.mqV.setEnabled(this.mrt);
            this.mqV.setFocusable(this.mrv);
            this.mqV.setClickable(this.mru);
            this.mqV.setHintTextColor(this.mry);
            setImeOptions(this.mrx);
            setInputType(this.mrw);
            this.mqV.addTextChangedListener(new 1(this));
            this.mqV.setOnFocusChangeListener(this);
        }
        bql();
        if (this.mqV != null) {
            if (this.mrw == 2) {
                this.mqV.setKeyListener(new NumberKeyListener() {
                    public final int getInputType() {
                        return 3;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                    }
                });
            } else if (this.mrw == 4) {
                this.mqV.setKeyListener(new 4(this));
            } else if (this.mrw == 128) {
                this.mqV.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.mqV.setKeyListener(new 5(this));
                this.mqV.setRawInputType(18);
            } else if (this.mrw == 3) {
                this.mqV.setKeyListener(new 6(this));
            } else {
                this.mqV.setInputType(this.mrw);
            }
            if (this.mrq != -1) {
                this.mqV.setFilters(new InputFilter[]{new LengthFilter(this.mrq)});
            }
        }
    }

    public final void setHint(String str) {
        if (this.mqV != null) {
            this.mqV.setHint(str);
        }
    }

    public final void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.mqV.setOnEditorActionListener(onEditorActionListener);
    }

    @SuppressLint({"WrongCall"})
    protected final void onMeasure(int i, int i2) {
        if (this.mrb == null || !this.mrb.bqi()) {
            super.onMeasure(i, i2);
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mrb != null && this.mrb.bqj()) {
            return true;
        }
        if (this.mqV != null && b(this.mqV, motionEvent) && !this.mqV.isClickable()) {
            x.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
            return true;
        } else if (!b(this.mqW, motionEvent) || motionEvent.getAction() != 1) {
            return false;
        } else {
            x.d("MicroMsg.WalletFormView", "hy: click on info iv");
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

    public final void bqm() {
        x.d("MicroMsg.WalletFormView", "shouldClearFocus: %s", new Object[]{Boolean.valueOf(this.mrz)});
        if (this.mrz) {
            getContentEditText().clearFocus();
        } else {
            this.mrz = true;
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
        if (this.mqV != null) {
            this.mqV.setSelection(i);
        }
    }

    public final a getEventDelegate() {
        return this.mrb;
    }

    public final b getLogicDelegate() {
        return this.mrc;
    }

    public final String getText() {
        if (this.mqV != null) {
            String obj = this.mqV.getText().toString();
            if (this.mrc == null || !this.mrc.bqk()) {
                return obj;
            }
            return this.mrc.Kq(obj);
        }
        x.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
        return "";
    }

    public final KeyListener getKeyListener() {
        if (this.mqV != null) {
            return this.mqV.getKeyListener();
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
        this.mqY = aVar;
    }

    public final void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.mqZ = onFocusChangeListener;
    }

    public final void setEventDelegate(a aVar) {
        this.mrb = aVar;
    }

    public final void setLogicDelegate(b bVar) {
        this.mrc = bVar;
    }

    public final void setKeyListener(KeyListener keyListener) {
        if (this.mqV != null) {
            this.mqV.setKeyListener(keyListener);
        }
    }

    public final boolean ZF() {
        if (this.mqV != null) {
            int length = this.mqV.getText() == null ? 0 : this.mqV.getText().length();
            if (length > this.mrq || length < this.mrr) {
                return false;
            }
            return this.mrc != null ? this.mrc.a(this) : true;
        } else {
            x.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
            return true;
        }
    }

    public final void bqn() {
        if (this.mqV != null) {
            this.mqV.setText("");
        }
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        if (this.mqV != null) {
            this.mqV.setFilters(inputFilterArr);
        }
    }

    public final int getInputLength() {
        return this.mqV != null ? this.mqV.getText().length() : 0;
    }

    public final void onFocusChange(View view, boolean z) {
        if (this.mqZ != null) {
            this.mqZ.onFocusChange(this, z);
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
}
