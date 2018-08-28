package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText;

public class InputClearablePreference extends Preference {
    public String fHW;
    private String gEw;
    public String kCg;
    public String kCh;
    public int kCi;
    private int kCj;
    public boolean kCk;
    public MMEditText kCl;
    private ImageView kCm;
    public TextView kCn;
    private int kCo;
    public a kCp;

    public InputClearablePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputClearablePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setText(String str) {
        this.gEw = str;
        if (this.kCl != null && !bi.oW(str)) {
            this.kCl.setText(j.a(this.mContext, this.gEw, this.kCo));
            FJ(this.gEw);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.kCo = a.ad(this.mContext, R.f.HintTextSize);
        this.kCl = (MMEditText) view.findViewById(R.h.edittext);
        this.kCm = (ImageView) view.findViewById(R.h.delete);
        this.kCn = (TextView) view.findViewById(R.h.err_msg);
        if (this.kCl != null) {
            if (this.kCj > 0) {
                this.kCl.setFilters(new InputFilter[]{new LengthFilter(this.kCj), new b(this)});
            } else {
                this.kCl.setFilters(new InputFilter[]{new b(this)});
            }
        }
        this.kCl.addTextChangedListener(new 1(this));
        x.d("MicroMsg.Label.InputClearablePreference", "mText %s", new Object[]{this.gEw});
        setText(this.gEw);
        if (!bi.oW(this.gEw)) {
            this.kCl.setSelection(this.gEw.length());
        }
        if (this.kCk) {
            new ag().postDelayed(new 4(this), 0);
        }
        this.kCl.setHint(this.kCg);
        this.kCm.setOnClickListener(new 2(this));
        if (this.kCn != null) {
            this.kCn.setOnTouchListener(new 3(this));
        }
    }

    private void FJ(String str) {
        boolean z = true;
        if (!bi.oW(str)) {
            int abd = g.abd(str);
            boolean z2 = abd > this.kCi;
            int be = g.be(this.kCi, "");
            int bf = g.bf(this.kCi, str);
            if (this.kCn != null) {
                if (z2) {
                    this.kCn.setText(String.format(this.fHW, new Object[]{Integer.valueOf(be), Integer.valueOf(bf)}));
                    this.kCn.setVisibility(0);
                } else {
                    this.kCn.setVisibility(8);
                }
            }
            if (this.kCp != null) {
                a aVar = this.kCp;
                if (abd > this.kCi) {
                    z = false;
                }
                aVar.gd(z);
            }
        }
    }

    public final void gf(boolean z) {
        if (this.kCn == null) {
            return;
        }
        if (z) {
            this.kCn.setText(this.kCh);
            this.kCn.setVisibility(0);
            return;
        }
        this.kCn.setVisibility(8);
    }
}
