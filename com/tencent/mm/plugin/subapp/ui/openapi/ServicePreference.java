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
import java.util.List;

public class ServicePreference extends Preference {
    private Context context;
    List<f> mSx;
    OnItemClickListener osG;
    private OnItemClickListener osH;
    private OnClickListener osI;
    private int osJ;
    private boolean osK;
    private int osL;
    b ota;

    public ServicePreference(Context context) {
        this(context, null);
    }

    public ServicePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ServicePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.osG = null;
        this.osH = null;
        this.osI = null;
        this.osK = false;
        this.osL = 0;
        this.context = context;
        setLayoutResource(R.i.app_preference);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.AppPreference);
        this.osJ = obtainStyledAttributes.getInt(R.n.AppPreference_btn_visibility, 8);
        this.osK = obtainStyledAttributes.getBoolean(R.n.AppPreference_can_delete, false);
        this.osL = obtainStyledAttributes.getResourceId(R.n.AppPreference_empty_wording, 0);
        obtainStyledAttributes.recycle();
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        MMGridView mMGridView = (MMGridView) view.findViewById(R.h.gridview);
        if (mMGridView != null) {
            this.ota = new b(this.context, this.mSx);
            ao.bmf().d(this.ota);
            ao.bmf().c(this.ota);
            mMGridView.setAdapter(this.ota);
            mMGridView.setOnItemClickListener(new 1(this));
            if (this.osK) {
                mMGridView.setOnItemLongClickListener(new 2(this));
            }
            TextView textView = (TextView) view.findViewById(R.h.empty_tv);
            if (this.ota.getCount() == 0) {
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
    }

    public final f xV(int i) {
        if (i < 0 || i >= this.ota.getCount()) {
            return null;
        }
        return (f) this.ota.getItem(i);
    }

    public final void onResume() {
        if (this.ota != null) {
            ao.bmf().c(this.ota);
        }
    }

    public final void onPause() {
        if (this.ota != null) {
            ao.bmf().d(this.ota);
        }
    }
}
