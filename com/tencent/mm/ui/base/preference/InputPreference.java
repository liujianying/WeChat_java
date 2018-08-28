package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.w.a.g;

public class InputPreference extends Preference {
    private String otd;
    private a otg;
    private OnClickListener oti;
    private String tCu;
    private EditText tCv;
    private Button tCw;
    private OnEditorActionListener tCx;

    public InputPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oti = new 1(this);
        this.tCx = new 2(this);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.tCv = (EditText) view.findViewById(g.edittext);
        this.tCv.setHint(this.otd);
        this.tCv.setOnEditorActionListener(this.tCx);
        this.tCw = (Button) view.findViewById(g.button);
        this.tCw.setText(this.tCu);
        this.tCw.setOnClickListener(this.oti);
    }
}
