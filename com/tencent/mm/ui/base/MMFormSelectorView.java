package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.m;

public class MMFormSelectorView extends LinearLayout {
    private TextView eCm;
    private String eVC;
    private int layout;
    private Context mContext;
    private EditText meN;
    private String title;

    @TargetApi(11)
    public MMFormSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.layout = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.FormItemView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(m.FormItemView_form_title, 0);
        if (resourceId != 0) {
            this.title = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(m.FormItemView_form_hint, 0);
        if (resourceId != 0) {
            this.eVC = context.getString(resourceId);
        }
        this.layout = obtainStyledAttributes.getResourceId(m.FormItemView_form_layout, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
    }

    public MMFormSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        this.eCm = (TextView) findViewById(g.title);
        this.meN = (EditText) findViewById(g.edittext);
        if (this.eCm == null || this.meN == null) {
            x.w("MicroMsg.MMFormSelectorView", "titleTV : %s, contentET : %s", new Object[]{this.eCm, this.meN});
            return;
        }
        if (this.title != null) {
            this.eCm.setText(this.title);
        }
        if (this.eVC != null) {
            this.meN.setHint(this.eVC);
        }
    }

    public void setTitle(String str) {
        if (this.eCm != null) {
            this.eCm.setText(str);
        } else {
            x.e("MicroMsg.MMFormSelectorView", "titleTV is null!");
        }
    }

    public void setHint(String str) {
        if (this.meN != null) {
            this.meN.setHint(str);
        } else {
            x.e("MicroMsg.MMFormSelectorView", "contentET is null!");
        }
    }

    public void setTitle(int i) {
        if (this.eCm != null) {
            this.eCm.setText(i);
        } else {
            x.e("MicroMsg.MMFormSelectorView", "titleTV is null!");
        }
    }

    public void setHint(int i) {
        if (this.meN != null) {
            this.meN.setHint(i);
        } else {
            x.e("MicroMsg.MMFormSelectorView", "contentET is null!");
        }
    }

    public void setText(String str) {
        if (this.meN != null) {
            this.meN.setText(str);
        } else {
            x.e("MicroMsg.MMFormSelectorView", "contentET is null!");
        }
    }

    public String getText() {
        if (this.meN != null) {
            return this.meN.getText().toString();
        }
        x.e("MicroMsg.MMFormSelectorView", "contentET is null!");
        return null;
    }
}
