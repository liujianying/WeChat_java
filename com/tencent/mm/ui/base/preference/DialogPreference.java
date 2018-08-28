package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.m;

public final class DialogPreference extends Preference {
    private c eIW;
    public a tBK;
    private final d tBM;
    a tBN;

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tBM = new d(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.ChoicePreference, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(m.ChoicePreference_entries, -1);
        if (resourceId != -1) {
            this.tBM.tBI = context.getResources().getStringArray(resourceId);
        }
        this.tBM.tBJ = obtainStyledAttributes.getTextArray(m.ChoicePreference_entryValues);
        obtainStyledAttributes.recycle();
        this.tBM.csh();
    }

    public final void a(a aVar) {
        this.tBK = aVar;
    }

    public final String getValue() {
        return this.tBM.value;
    }

    public final void setValue(String str) {
        this.tBM.value = str;
        c cVar = (c) this.tBM.values.get(str);
        if (cVar == null) {
            this.tBM.lSy = -1;
            return;
        }
        this.tBM.lSy = cVar.id;
    }

    public final void onBindView(View view) {
        c cVar = (c) this.tBM.values.get(this.tBM.value);
        if (cVar != null) {
            setSummary(cVar.text);
        }
        super.onBindView(view);
    }

    protected final void showDialog() {
        ListViewInScrollView listViewInScrollView = (ListViewInScrollView) View.inflate(this.mContext, h.mm_list, null);
        listViewInScrollView.setOnItemClickListener(new 1(this));
        listViewInScrollView.setAdapter(this.tBM);
        c.a aVar = new c.a(this.mContext);
        aVar.abt(getTitle().toString());
        aVar.dR(listViewInScrollView);
        this.eIW = aVar.anj();
        this.eIW.show();
        com.tencent.mm.ui.base.h.a(this.mContext, this.eIW);
    }
}
