package com.tencent.mm.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.bw.a$g;
import com.tencent.mm.bw.a.f;

public final class ag extends LinearLayout {
    private String eVC;
    private ImageButton jfw;
    private ImageView jfx = ((ImageView) findViewById(f.actionbar_up_indicator_btn));
    private Context mContext;
    private EditText tpW;
    private a tpX;

    static /* synthetic */ void b(ag agVar) {
        agVar.tpW.setText("");
        agVar.tpW.setHint(agVar.eVC);
        agVar.jfw.setVisibility(8);
    }

    public ag(Context context) {
        super(context);
        this.mContext = context;
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(a$g.actionbar_search, this, true);
        this.jfx.setOnClickListener(new 1(this));
        this.tpW = (EditText) findViewById(f.search_edit);
        this.tpW.requestFocus();
        this.jfw = (ImageButton) findViewById(f.clear_btn);
        this.jfw.setOnClickListener(new 2(this));
        this.tpW.addTextChangedListener(new 3(this));
    }

    public final void setSearchViewListener(a aVar) {
        this.tpX = aVar;
    }

    public final EditText getSearchEditText() {
        return this.tpW;
    }

    public final void setHint(String str) {
        this.eVC = str;
    }
}
