package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bi;

public class TipSayingWidget extends LinearLayout {
    private String cXR;
    private Context context;
    private TextView hND;
    private ImageView kGL;
    private Chronometer kGM;
    private int kGN = 0;

    public TipSayingWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        View inflate = View.inflate(this.context, f.tips_saying, this);
        this.kGL = (ImageView) inflate.findViewById(e.saying_iv);
        this.hND = (TextView) inflate.findViewById(e.sayint_tips);
        this.kGM = (Chronometer) findViewById(e.chronometer);
    }

    public void setCurSaying(String str) {
        if (bi.oW(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        b.p(this.kGL, str);
        if (bi.oW(this.cXR)) {
            this.cXR = q.GF();
        }
        if (this.cXR.equals(str)) {
            this.hND.setText(this.context.getString(h.track_somebody_saying, new Object[]{str}));
            this.kGM.setVisibility(0);
            return;
        }
        this.hND.setText(this.context.getString(h.track_somebody_saying, new Object[]{str}));
        this.kGM.setVisibility(8);
    }
}
