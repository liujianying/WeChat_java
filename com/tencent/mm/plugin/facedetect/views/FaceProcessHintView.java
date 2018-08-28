package com.tencent.mm.plugin.facedetect.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;

public class FaceProcessHintView extends LinearLayout {
    private h iUx;
    private int iUy;
    private Animation iUz;

    public FaceProcessHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceProcessHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iUx = null;
        this.iUy = 0;
        this.iUz = null;
        setOrientation(0);
        setMinimumHeight(b.b(getContext(), 36.0f));
        this.iUz = AnimationUtils.loadAnimation(context, a.face_zoom_out_from_left);
        this.iUz.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    @SuppressLint({"SetTextI18n"})
    public void setDataAndInvalidate(h hVar) {
        this.iUx = hVar;
        if (this.iUx == null || this.iUx.iNA <= 0) {
            x.e("MicroMsg.FaceProcessHintView", "hy: model invalid");
            return;
        }
        removeAllViews();
        for (int i = 0; i < this.iUx.iNA; i++) {
            View inflate = LayoutInflater.from(getContext()).inflate(g.face_process_hint_item, null, false);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            ((TextView) inflate.findViewById(e.current_process_number)).setText(String.valueOf(i + 1));
            addView(inflate, layoutParams);
        }
        getChildAt(getChildCount() - 1).findViewById(e.face_progress_area).setVisibility(8);
        setCurrentProcessing(0);
        invalidate();
    }

    private void setCurrentProcessing(int i) {
        TextView textView = (TextView) getChildAt(i).findViewById(e.current_process_number);
        textView.setTextColor(getResources().getColor(com.tencent.mm.plugin.facedetect.a.b.white));
        textView.setBackgroundResource(d.face_prefix_number_bg);
    }
}
