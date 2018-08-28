package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mm.ui.y;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class MMDatePickerView extends LinearLayout implements OnClickListener {
    private MMSpinnerDatePicker hZh;
    private Button uGe;
    private Button uGf;
    private Button uGg;

    public MMDatePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MMDatePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = y.gq(context).inflate(h.mm_datepicker_dialog, this);
        this.uGe = (Button) inflate.findViewById(g.year_btn);
        this.uGf = (Button) inflate.findViewById(g.month_btn);
        this.uGg = (Button) inflate.findViewById(g.day_btn);
        this.hZh = (MMSpinnerDatePicker) inflate.findViewById(g.mm_datepicker);
        this.uGe.setOnClickListener(this);
        this.uGf.setOnClickListener(this);
        this.uGg.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == g.year_btn) {
            this.hZh.setPickerMode(0);
        } else if (id == g.month_btn) {
            this.hZh.setPickerMode(1);
        } else {
            this.hZh.setPickerMode(2);
        }
    }
}
