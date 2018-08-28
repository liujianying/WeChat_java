package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView$t;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class f$a extends RecyclerView$t {
    public ImageView jBM;
    public ImageView jBN;
    public RelativeLayout jBO;
    public TextView jBP;
    public ImageView jBT;
    public ImageView jBU;
    public ImageView jBV;
    public int jEA;
    public ImageView jEy;
    public View jEz;

    public f$a(View view) {
        super(view);
        this.jEz = view;
        this.jBU = (ImageView) view.findViewById(R.h.gif_mask);
        this.jBV = (ImageView) view.findViewById(R.h.edit_mark_iv);
        this.jEy = (ImageView) view.findViewById(R.h.error_icon_iv);
        this.jBM = (ImageView) view.findViewById(R.h.media_placeholder);
        this.jBN = (ImageView) view.findViewById(R.h.media_thumb);
        this.jBO = (RelativeLayout) view.findViewById(R.h.video_mask);
        this.jBP = (TextView) view.findViewById(R.h.video_mask_tv);
        this.jBT = (ImageView) view.findViewById(R.h.media_mask);
        this.jBT.setBackgroundResource(R.e.half_alpha_black);
        this.jBT.setVisibility(8);
    }
}
