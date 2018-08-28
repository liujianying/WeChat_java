package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public final class a extends LinearLayout {
    private View jzW = findViewById(g.ab_back_container);
    private FTSEditTextView jzX;
    private a jzY;

    public a(Context context) {
        super(context);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(h.fts_actionbar_searchview, this, true);
        this.jzW.setOnClickListener(new 1(this));
        this.jzX = (FTSEditTextView) findViewById(g.fts_edittext);
    }

    public final void setSearchViewListener(a aVar) {
        this.jzY = aVar;
    }

    public final FTSEditTextView getFtsEditText() {
        return this.jzX;
    }
}
