package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

public final class i extends LinearLayout {
    private Context context;
    private int hjO = 0;
    private int nLH = 6;
    private LinearLayout nLI;

    public final void setLineMaxCounte(int i) {
        this.nLH = i;
    }

    public i(Context context) {
        super(context);
        this.context = context;
        setOrientation(1);
    }

    public final void addView(View view) {
        if (this.hjO % this.nLH == 0) {
            this.nLI = new LinearLayout(this.context);
            this.nLI.setOrientation(0);
            this.nLI.addView(view);
            super.addView(this.nLI);
        } else {
            this.nLI.addView(view);
        }
        this.hjO++;
    }
}
