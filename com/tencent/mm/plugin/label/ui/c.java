package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.MMTextView;

public final class c {
    TextView hrM;
    MMTextView kCe;
    LinearLayout kCf;

    public c(View view) {
        this.kCe = (MMTextView) view.findViewById(R.h.label_item_title);
        this.hrM = (TextView) view.findViewById(R.h.label_item_count);
        this.kCf = (LinearLayout) view.findViewById(R.h.label_item_container);
    }
}
