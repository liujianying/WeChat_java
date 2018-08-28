package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class NoiseDetectMaskView extends RelativeLayout {
    ProgressBar eWx = null;
    private Context mContext = null;
    TextView oFU;
    TextView oFV;
    private b oFW;
    private a oFX;

    public NoiseDetectMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mContext.getSystemService("layout_inflater");
        LayoutInflater.from(this.mContext).inflate(R.i.noise_mask_view, this);
        this.eWx = (ProgressBar) findViewById(R.h.noise_detect_progress);
        this.oFU = (TextView) findViewById(R.h.noise_detect_hint);
        this.oFV = (TextView) findViewById(R.h.noise_detect_retry);
        this.oFV.setOnClickListener(new 1(this));
        findViewById(R.h.left_btn).setOnClickListener(new 2(this));
    }

    public void setOnClickRetryCallback(b bVar) {
        this.oFW = bVar;
    }

    public void setOnCancelDetectCallback(a aVar) {
        this.oFX = aVar;
    }
}
