package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;

public final class h extends BaseSmallView {
    private TextView hrV = ((TextView) findViewById(R.h.voip_voice_mini_time_tv));

    public h(Context context) {
        super(context, null);
        LayoutInflater.from(context).inflate(R.i.voip_voice_mini_widget_view, this);
    }

    public final void OJ(String str) {
        this.hrV.setTextSize(1, 14.0f);
        this.hrV.setText(str);
    }

    public final void OI(String str) {
        this.hrV.setTextSize(1, 12.0f);
        this.hrV.setText(str);
    }

    public final void setCaptureView(CaptureView captureView) {
    }

    protected final void bLM() {
    }

    protected final void bLN() {
    }

    protected final void onAnimationEnd() {
    }
}
