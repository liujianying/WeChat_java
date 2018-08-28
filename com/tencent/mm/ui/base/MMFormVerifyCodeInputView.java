package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.k;
import com.tencent.mm.w.a.m;

public class MMFormVerifyCodeInputView extends LinearLayout {
    private TextView eCm;
    private Button eVi;
    private al eeo;
    private OnFocusChangeListener jzz;
    private int layout;
    private Context mContext;
    private EditText meN;
    private int qyt;
    private int tuA;
    private int tuB;
    private OnClickListener tuC;
    private int tuo;
    private int[] tup;
    private TextView tuy;
    private int tuz;

    static /* synthetic */ void c(MMFormVerifyCodeInputView mMFormVerifyCodeInputView) {
        if (mMFormVerifyCodeInputView.tup != null) {
            mMFormVerifyCodeInputView.setPadding(mMFormVerifyCodeInputView.tup[0], mMFormVerifyCodeInputView.tup[1], mMFormVerifyCodeInputView.tup[2], mMFormVerifyCodeInputView.tup[3]);
        }
    }

    @TargetApi(11)
    public MMFormVerifyCodeInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.qyt = -1;
        this.tuo = -1;
        this.tuz = -1;
        this.layout = -1;
        this.tuA = 60;
        this.tuB = this.tuA;
        this.jzz = null;
        this.tuC = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.FormItemView, i, 0);
        this.tuo = obtainStyledAttributes.getResourceId(m.FormItemView_form_hint, -1);
        this.qyt = obtainStyledAttributes.getResourceId(m.FormItemView_form_title, -1);
        this.tuz = obtainStyledAttributes.getResourceId(m.FormItemView_form_btn_title, -1);
        this.layout = obtainStyledAttributes.getResourceId(m.FormItemView_form_layout, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
    }

    public MMFormVerifyCodeInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.eCm = (TextView) findViewById(g.title);
        this.meN = (EditText) findViewById(g.edittext);
        this.tuy = (TextView) findViewById(g.timer);
        this.eVi = (Button) findViewById(g.send_verify_code_btn);
        if (this.eCm == null || this.meN == null || this.tuy == null || this.eVi == null) {
            x.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", new Object[]{this.eCm, this.meN, this.tuy, this.eVi});
        } else {
            if (this.qyt != -1) {
                this.eCm.setText(this.qyt);
            }
            if (this.tuo != -1) {
                this.meN.setHint(this.tuo);
            }
            if (this.tuz != -1) {
                this.eVi.setText(this.tuz);
            }
        }
        if (this.meN != null) {
            this.meN.setOnFocusChangeListener(new 1(this));
        }
        if (this.eVi != null) {
            this.eVi.setOnClickListener(new 2(this));
        }
    }

    public void setFocusListener(OnFocusChangeListener onFocusChangeListener) {
        this.jzz = onFocusChangeListener;
    }

    public void setSendSmsBtnClickListener(OnClickListener onClickListener) {
        this.tuC = onClickListener;
    }

    public void setTitle(String str) {
        if (this.eCm != null) {
            this.eCm.setText(str);
        } else {
            x.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
        }
    }

    public void setHint(String str) {
        if (this.meN != null) {
            this.meN.setHint(str);
        } else {
            x.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        }
    }

    public void setTitle(int i) {
        if (this.eCm != null) {
            this.eCm.setText(i);
        } else {
            x.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
        }
    }

    public void setHint(int i) {
        if (this.meN != null) {
            this.meN.setHint(i);
        } else {
            x.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        }
    }

    public void setText(String str) {
        if (this.meN != null) {
            this.meN.setText(str);
        } else {
            x.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        }
    }

    public void setImeOption(int i) {
        if (this.meN != null) {
            this.meN.setImeOptions(i);
        } else {
            x.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        }
    }

    public void setSmsBtnText(int i) {
        if (this.eVi != null) {
            this.eVi.setText(i);
        } else {
            x.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
        }
    }

    public void setSmsBtnText(String str) {
        if (this.eVi != null) {
            this.eVi.setText(str);
        } else {
            x.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
        }
    }

    public final void cru() {
        this.eVi.setVisibility(8);
        this.tuy.setVisibility(0);
        this.tuy.setText(getContext().getString(k.mobile_input_send_sms_timer_title, new Object[]{Integer.valueOf(this.tuA)}));
        if (this.eeo != null) {
            this.eeo.SO();
            this.eeo.J(1000, 1000);
        } else if (getContext() != null) {
            this.eeo = new al(getContext().getMainLooper(), new 3(this), true);
            this.eeo.J(1000, 1000);
        } else if (this.eeo != null) {
            this.eeo.SO();
        }
    }

    public final void reset() {
        if (this.eeo != null) {
            this.eeo.SO();
        }
        this.meN.setText("");
        this.tuy.setVisibility(8);
        this.tuB = this.tuA;
        this.eVi.setVisibility(0);
    }

    public void setInputType(int i) {
        if (this.meN != null) {
            this.meN.setInputType(i);
        } else {
            x.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        }
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        if (this.meN != null) {
            this.meN.addTextChangedListener(textWatcher);
            return;
        }
        x.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", new Object[]{textWatcher, this.meN});
    }

    public Editable getText() {
        if (this.meN != null) {
            return this.meN.getText();
        }
        x.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        return null;
    }

    public EditText getContentEditText() {
        return this.meN;
    }

    public TextView getTitleTextView() {
        return this.eCm;
    }
}
