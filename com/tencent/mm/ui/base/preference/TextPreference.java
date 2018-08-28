package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.w.a.h;

public class TextPreference extends Preference {
    private Context context;
    protected TextView ih;
    protected CharSequence mText;
    protected int rA;

    public TextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        setLayoutResource(h.mm_preference_info);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        return super.onCreateView(viewGroup);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.ih = (TextView) view.findViewById(16908310);
        aL();
    }

    private void aL() {
        if (this.ih != null) {
            this.ih.setText(this.mText);
            this.ih.setGravity(this.rA);
        }
    }

    public final void N(CharSequence charSequence) {
        this.mText = charSequence;
        this.rA = 17;
        aL();
    }
}
