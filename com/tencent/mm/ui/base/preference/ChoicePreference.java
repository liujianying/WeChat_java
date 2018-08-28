package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.m;
import java.util.HashMap;
import junit.framework.Assert;

public final class ChoicePreference extends Preference {
    private int lSy;
    private RadioGroup tBH;
    private CharSequence[] tBI;
    private CharSequence[] tBJ;
    public a tBK;
    String value;
    private final HashMap<CharSequence, b> values;

    public ChoicePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChoicePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.values = new HashMap();
        this.lSy = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.ChoicePreference, i, 0);
        this.tBI = obtainStyledAttributes.getTextArray(m.ChoicePreference_entries);
        this.tBJ = obtainStyledAttributes.getTextArray(m.ChoicePreference_entryValues);
        obtainStyledAttributes.recycle();
        csh();
    }

    public final void a(a aVar) {
        this.tBK = aVar;
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(h.mm_preference_content_choice, viewGroup2);
        this.tBH = (RadioGroup) onCreateView.findViewById(g.group);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.tBJ.length) {
                b bVar = (b) this.values.get(this.tBJ[i2]);
                if (bVar != null) {
                    RadioButton radioButton;
                    if (i2 == 0) {
                        radioButton = (RadioButton) layoutInflater.inflate(h.mm_choice_btn_left, null);
                        bVar.a(radioButton);
                        this.tBH.addView(radioButton);
                    } else if (i2 == this.tBJ.length - 1) {
                        radioButton = (RadioButton) layoutInflater.inflate(h.mm_choice_btn_right, null);
                        bVar.a(radioButton);
                        this.tBH.addView(radioButton);
                    } else {
                        radioButton = (RadioButton) layoutInflater.inflate(h.mm_choice_btn_middle, null);
                        bVar.a(radioButton);
                        this.tBH.addView(radioButton);
                    }
                }
                i = i2 + 1;
            } else {
                this.tBH.setOnCheckedChangeListener(new 1(this));
                return onCreateView;
            }
        }
    }

    private void csh() {
        boolean z;
        int i = 0;
        if (this.tBI == null) {
            this.tBI = new CharSequence[0];
        }
        if (this.tBJ == null) {
            this.tBJ = new CharSequence[0];
        }
        String str = "entries count different";
        if (this.tBI.length == this.tBJ.length) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        this.values.clear();
        while (i < this.tBJ.length) {
            this.values.put(this.tBJ[i], new b(this.tBI[i], 1048576 + i));
            i++;
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.tBH != null) {
            this.tBH.check(this.lSy);
        }
    }

    public final void setValue(String str) {
        this.value = str;
        b bVar = (b) this.values.get(str);
        if (bVar == null) {
            this.lSy = -1;
        } else {
            this.lSy = bVar.id;
        }
    }
}
