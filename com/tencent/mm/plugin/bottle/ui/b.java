package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.i;

public final class b extends i {
    TextView ePz = ((TextView) this.view.findViewById(R.h.bottle_dialog_text));
    private Button hlf = ((Button) this.view.findViewById(R.h.bottle_dialog_button));
    private View view;

    public b(Context context) {
        super(context, R.m.noBgDialog);
        this.view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.i.bottle_dialog, null);
        setContentView(this.view, new LayoutParams(-2, -2));
        this.hlf.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                b.this.dismiss();
            }
        });
    }
}
