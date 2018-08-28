package com.tencent.mm.wallet_core.ui.formview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnFocusChangeListener;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.y;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class EditHintPasswdView extends RelativeLayout implements OnFocusChangeListener {
    private static final int uZo = a$e.edit_passwd_bg_selector;
    private OnFocusChangeListener eYB;
    private int oTn;
    private TenpaySecureEditText uZp;
    private int uZq;
    private int uZr;
    private int uZs;
    private a uZt;

    public interface a {
        void fE(boolean z);
    }

    public EditHintPasswdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.uZp = null;
        this.uZq = 6;
        this.oTn = 1;
        this.uZr = uZo;
        this.uZs = 1;
        this.uZt = null;
        this.eYB = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.PwdAttr, i, 0);
        this.oTn = obtainStyledAttributes.getInteger(k.PwdAttr_format, 1);
        this.uZr = obtainStyledAttributes.getResourceId(k.PwdAttr_EditTextBg, uZo);
        this.uZs = obtainStyledAttributes.getInteger(k.PwdAttr_PwdEncryptType, 1);
        obtainStyledAttributes.recycle();
        this.uZp = (TenpaySecureEditText) y.gq(context).inflate(g.hint_view_passwd, this, true).findViewById(f.wallet_content);
        b.a(this.uZp, this.oTn);
        this.uZq = getNumberSize();
        if (this.uZp != null) {
            this.uZp.setBackgroundResource(this.uZr);
            this.uZp.setImeOptions(6);
            this.uZp.setInputType(128);
            this.uZp.addTextChangedListener(new 1(this));
            this.uZp.setOnFocusChangeListener(this);
            super.setEnabled(true);
            super.setClickable(true);
            return;
        }
        x.e("MicroMsg.EditHintPasswdView", "hy: no edit text view");
    }

    public EditHintPasswdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final String getMd5Value() {
        if (this.uZp != null) {
            return ac.ce(this.uZp.getText().toString());
        }
        x.w("MicroMsg.EditHintPasswdView", "hy: edit view is null");
        return "";
    }

    private boolean ZF() {
        if (this.uZp == null || this.uZp.getInputLength() != this.uZq) {
            return false;
        }
        return true;
    }

    private int getNumberSize() {
        switch (this.oTn) {
            case 1:
                return 6;
            case 3:
                return 3;
            case 4:
                return 4;
            case 8:
                return 4;
            default:
                x.i("MicroMsg.EditHintPasswdView", "hy: error or not set format. use default");
                return 6;
        }
    }

    public final void setOnInputValidListener(a aVar) {
        this.uZt = aVar;
    }

    public final a getOnEditInputValidListener() {
        return this.uZt;
    }

    public final void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.eYB = onFocusChangeListener;
    }

    public final OnFocusChangeListener getOnFocusChangeListener() {
        return this.eYB;
    }

    public final void setEncrType(int i) {
        this.uZs = i;
    }

    public final int getEncrType() {
        return this.uZs;
    }

    public final void setEditTextSize(float f) {
        if (this.uZp != null) {
            this.uZp.setTextSize(f);
        }
    }

    public final void setEditTextMaxLength(int i) {
        if (this.uZp != null) {
            InputFilter[] filters = this.uZp.getFilters();
            InputFilter[] inputFilterArr = new InputFilter[(filters.length + 1)];
            for (int i2 = 0; i2 < filters.length; i2++) {
                inputFilterArr[i2] = filters[i2];
            }
            inputFilterArr[inputFilterArr.length - 1] = new LengthFilter(i);
            this.uZp.setFilters(inputFilterArr);
        }
    }

    public final String getText() {
        if (this.uZp != null) {
            return com.tencent.mm.wallet_core.ui.formview.c.a.a(this.uZs, this.uZp);
        }
        x.w("MicroMsg.EditHintPasswdView", "hy: no edit view");
        return "";
    }

    public final void bqn() {
        if (this.uZp != null) {
            this.uZp.ClearInput();
        }
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(b.b(getContext(), 960.0f), i), getDefaultSize(b.b(getContext(), 720.0f), i2));
        int measuredWidth = getMeasuredWidth();
        int i3 = this.uZq == 0 ? measuredWidth / 6 : measuredWidth / this.uZq;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(i3, 1073741824);
        setMeasuredDimension(getDefaultSize(measuredWidth, makeMeasureSpec), getDefaultSize(i3, makeMeasureSpec2));
        super.onMeasure(makeMeasureSpec, makeMeasureSpec2);
    }

    public final void onFocusChange(View view, boolean z) {
        if (this.eYB != null) {
            this.eYB.onFocusChange(this, z);
        }
        if (this.uZt != null) {
            this.uZt.fE(ZF());
        }
    }

    public final int getFormat() {
        return this.oTn;
    }
}
