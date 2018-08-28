package com.tencent.mm.ui.chatting.a;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;

public class a$a extends t {
    TextView eBP;
    ProgressBar eVR;
    final /* synthetic */ a tNI;

    public a$a(a aVar, View view) {
        this.tNI = aVar;
        super(view);
        this.eBP = (TextView) view.findViewById(R.h.date_info);
        this.eVR = (ProgressBar) view.findViewById(R.h.load_progress);
    }
}
