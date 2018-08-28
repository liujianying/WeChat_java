package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactListCustomPreference extends Preference {
    int background = -1;
    OnClickListener mtE;
    private View pYk;
    private final OnTouchListener qJx = new 1(this);

    public ContactListCustomPreference(Context context) {
        super(context);
        setLayoutResource(f.mm_preference_contact_list_custom);
    }

    public ContactListCustomPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutResource(f.mm_preference_contact_list_custom);
    }

    public ContactListCustomPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(f.mm_preference_contact_list_custom);
    }

    public final void setCustomView(View view) {
        if (view != null) {
            this.pYk = view;
        }
    }

    public final void onBindView(View view) {
        ViewGroup viewGroup = (ViewGroup) view;
        if (!(this.pYk == null || this.pYk == null)) {
            viewGroup.removeAllViews();
            if (this.pYk.getParent() != null) {
                ((ViewGroup) this.pYk.getParent()).removeAllViews();
            }
            viewGroup.addView(this.pYk);
            if (this.mtE != null) {
                viewGroup.setOnClickListener(this.mtE);
            } else {
                viewGroup.setOnTouchListener(this.qJx);
            }
        }
        if (this.background >= 0) {
            view.setBackgroundResource(this.background);
        }
    }
}
