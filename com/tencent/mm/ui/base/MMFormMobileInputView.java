package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.ui.y;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.m;

public class MMFormMobileInputView extends LinearLayout {
    private Context mContext;
    private int tuo;
    private int[] tup;
    private EditText tur;
    private EditText tus;
    private String tut;
    private String tuu;
    private final int tuv;
    private a tuw;

    @TargetApi(11)
    public MMFormMobileInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.tuo = -1;
        this.tut = "";
        this.tuu = "";
        this.tuv = 13;
        this.tuw = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.FormItemView, i, 0);
        this.tuo = obtainStyledAttributes.getResourceId(m.FormItemView_form_hint, -1);
        obtainStyledAttributes.recycle();
        y.gq(context).inflate(h.mm_form_mobile_input_view, this);
        this.mContext = context;
    }

    public MMFormMobileInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        this.tur = (EditText) findViewById(g.country_code);
        this.tus = (EditText) findViewById(g.mobile_number);
        if (this.tur == null || this.tus == null) {
            x.w("MicroMsg.MMFormMobileInputView", "countryCodeET : %s, mobileNumberET : %s", new Object[]{this.tur, this.tus});
        } else if (this.tuo != -1) {
            this.tus.setHint(this.tuo);
        }
        if (this.tur != null && this.tus != null) {
            if (this.tur.hasFocus() || this.tus.hasFocus()) {
                lI(true);
            } else {
                lI(false);
            }
            1 1 = new 1(this);
            this.tur.setOnFocusChangeListener(1);
            this.tus.setOnFocusChangeListener(1);
            this.tus.addTextChangedListener(new c(this.tus, null, 20));
            this.tus.addTextChangedListener(new 2(this));
            this.tur.addTextChangedListener(new 3(this));
        }
    }

    public void setOnCountryCodeChangedListener(a aVar) {
        this.tuw = aVar;
    }

    public final void lI(boolean z) {
        dn(this.tur);
        if (z) {
            this.tur.setBackgroundResource(f.input_bar_bg_active);
        } else {
            this.tur.setBackgroundResource(f.input_bar_bg_normal);
        }
        do(this.tur);
        dn(this.tus);
        if (z) {
            this.tus.setBackgroundResource(f.input_bar_bg_active);
        } else {
            this.tus.setBackgroundResource(f.input_bar_bg_normal);
        }
        do(this.tus);
    }

    private void dn(View view) {
        this.tup = new int[]{view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
    }

    private void do(View view) {
        if (this.tup != null) {
            view.setPadding(this.tup[0], this.tup[1], this.tup[2], this.tup[3]);
        }
    }

    public void setCountryCode(String str) {
        if (this.tur != null) {
            this.tur.setText(str);
        } else {
            x.e("MicroMsg.MMFormMobileInputView", "countryCodeET is null!");
        }
    }

    public void setHint(String str) {
        if (this.tus != null) {
            this.tus.setHint(str);
        } else {
            x.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
        }
    }

    public void setMobileNumber(String str) {
        if (this.tus != null) {
            this.tus.setText(str);
        } else {
            x.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
        }
    }

    public String getMobileNumber() {
        if (this.tus != null) {
            return ap.Ww(this.tus.getText().toString());
        }
        return "";
    }

    public String getCountryCode() {
        if (this.tur != null) {
            return this.tur.getText().toString().trim();
        }
        return "";
    }

    public EditText getCountryCodeEditText() {
        return this.tur;
    }

    public EditText getMobileNumberEditText() {
        return this.tus;
    }
}
