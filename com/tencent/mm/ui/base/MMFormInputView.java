package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.m;

public class MMFormInputView extends LinearLayout {
    private TextView eCm;
    private OnFocusChangeListener jzz;
    private int layout;
    private Context mContext;
    private EditText meN;
    private int qyt;
    private int tuo;
    private int[] tup;

    static /* synthetic */ void c(MMFormInputView mMFormInputView) {
        if (mMFormInputView.tup != null) {
            mMFormInputView.setPadding(mMFormInputView.tup[0], mMFormInputView.tup[1], mMFormInputView.tup[2], mMFormInputView.tup[3]);
        }
    }

    @TargetApi(11)
    public MMFormInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.qyt = -1;
        this.tuo = -1;
        this.layout = -1;
        this.jzz = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.FormItemView, i, 0);
        this.tuo = obtainStyledAttributes.getResourceId(m.FormItemView_form_hint, -1);
        this.qyt = obtainStyledAttributes.getResourceId(m.FormItemView_form_title, -1);
        this.layout = obtainStyledAttributes.getResourceId(m.FormItemView_form_layout, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
    }

    public MMFormInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        this.eCm = (TextView) findViewById(g.title);
        this.meN = (EditText) findViewById(g.edittext);
        if (this.eCm == null || this.meN == null) {
            x.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", this.eCm, this.meN);
        } else {
            if (this.qyt != -1) {
                this.eCm.setText(this.qyt);
            }
            if (this.tuo != -1) {
                this.meN.setHint(this.tuo);
            }
        }
        if (this.meN != null) {
            this.meN.setOnFocusChangeListener(new 1(this));
        }
    }

    public void setFocusListener(OnFocusChangeListener onFocusChangeListener) {
        this.jzz = onFocusChangeListener;
    }

    public void setTitle(String str) {
        if (this.eCm != null) {
            this.eCm.setText(str);
        } else {
            x.e("MicroMsg.MMFormInputView", "titleTV is null!");
        }
    }

    public void setHint(String str) {
        if (this.meN != null) {
            this.meN.setHint(str);
        } else {
            x.e("MicroMsg.MMFormInputView", "contentET is null!");
        }
    }

    public void setTitle(int i) {
        if (this.eCm != null) {
            this.eCm.setText(i);
        } else {
            x.e("MicroMsg.MMFormInputView", "titleTV is null!");
        }
    }

    public void setHint(int i) {
        if (this.meN != null) {
            this.meN.setHint(i);
        } else {
            x.e("MicroMsg.MMFormInputView", "contentET is null!");
        }
    }

    public void setText(String str) {
        if (this.meN != null) {
            this.meN.setText(str);
        } else {
            x.e("MicroMsg.MMFormInputView", "contentET is null!");
        }
    }

    public void setImeOption(int i) {
        if (this.meN != null) {
            this.meN.setImeOptions(i);
        } else {
            x.e("MicroMsg.MMFormInputView", "contentET is null!");
        }
    }

    public void setInputType(int i) {
        if (this.meN != null) {
            this.meN.setInputType(i);
        } else {
            x.e("MicroMsg.MMFormInputView", "contentET is null!");
        }
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        if (textWatcher == null || this.meN == null) {
            x.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", textWatcher, this.meN);
            return;
        }
        this.meN.addTextChangedListener(textWatcher);
    }

    public Editable getText() {
        if (this.meN != null) {
            return this.meN.getText();
        }
        x.e("MicroMsg.MMFormInputView", "contentET is null!");
        return null;
    }

    public EditText getContentEditText() {
        return this.meN;
    }

    public TextView getTitleTextView() {
        return this.eCm;
    }
}
