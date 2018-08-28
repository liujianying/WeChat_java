package com.tencent.mm.ui.chatting.a;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

public class a$d extends t {
    CheckBox jBR;
    View jBS;
    ImageView mZb;
    final /* synthetic */ a tNI;
    View tNM;
    TextView tNN;
    ImageView tNO;
    View tNP;

    public a$d(a aVar, View view) {
        this.tNI = aVar;
        super(view);
        this.mZb = (ImageView) view.findViewById(R.h.grid_header_item);
        this.tNM = view.findViewById(R.h.video_tips_root);
        this.tNP = view.findViewById(R.h.sight_tips_root);
        this.tNN = (TextView) view.findViewById(R.h.video_time_tv);
        this.tNO = (ImageView) view.findViewById(R.h.grid_selected_item_mask);
        this.jBR = (CheckBox) view.findViewById(R.h.media_cbx);
        this.jBS = view.findViewById(R.h.media_cbx_clickarea);
        this.jBS.setVisibility(8);
        this.jBR.setVisibility(8);
        this.tNM.setVisibility(8);
        this.tNN.setVisibility(8);
        this.tNP.setVisibility(8);
        this.mZb.setOnClickListener(new 1(this, aVar));
        this.jBS.setOnClickListener(new 2(this, aVar));
    }
}
