package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.preference.Preference;

public class AppPreference extends Preference {
    private Context context;
    int osD;
    a osF;
    OnItemClickListener osG;
    OnItemClickListener osH;
    private OnClickListener osI;
    private int osJ;
    private boolean osK;
    private int osL;

    public AppPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.osG = null;
        this.osH = null;
        this.osI = null;
        this.osD = 0;
        this.osK = false;
        this.osL = 0;
        this.context = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.AppPreference);
        this.osJ = obtainStyledAttributes.getInt(R.n.AppPreference_btn_visibility, 8);
        this.osK = obtainStyledAttributes.getBoolean(R.n.AppPreference_can_delete, false);
        this.osL = obtainStyledAttributes.getResourceId(R.n.AppPreference_empty_wording, 0);
        obtainStyledAttributes.recycle();
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        MMGridView mMGridView = (MMGridView) view.findViewById(R.h.gridview);
        this.osF = new a(this.context, this.osD);
        mMGridView.setAdapter(this.osF);
        mMGridView.setOnItemClickListener(new 1(this));
        if (this.osK) {
            mMGridView.setOnItemLongClickListener(new 2(this));
        }
        TextView textView = (TextView) view.findViewById(R.h.empty_tv);
        if (this.osF.getCount() == 0) {
            textView.setVisibility(0);
            textView.setText(this.osL);
            mMGridView.setVisibility(8);
        } else {
            textView.setVisibility(8);
            mMGridView.setVisibility(0);
        }
        Button button = (Button) view.findViewById(R.h.btn);
        button.setVisibility(this.osJ);
        button.setOnClickListener(this.osI);
    }

    public final f xV(int i) {
        if (i < 0 || i >= this.osF.getCount()) {
            return null;
        }
        return (f) this.osF.getItem(i);
    }

    public final void onResume() {
        if (this.osF != null) {
            ao.bmf().c(this.osF);
        }
    }

    public final void onPause() {
        if (this.osF != null) {
            ao.bmf().d(this.osF);
        }
    }
}
