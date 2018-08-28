package com.tencent.mm.ui.widget.a;

import android.support.v7.widget.RecyclerView$t;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.bw.a.f;
import com.tencent.mm.ui.widget.a.d.b;

public class d$b$a extends RecyclerView$t implements OnClickListener {
    TextView eGX;
    ImageView gwj;
    TextView nDf;
    RadioButton uKn;
    ImageView uKo;
    LinearLayout uKp;
    final /* synthetic */ b uKq;

    public d$b$a(b bVar, View view) {
        this.uKq = bVar;
        super(view);
        view.setOnClickListener(this);
        this.eGX = (TextView) view.findViewById(f.title);
        this.gwj = (ImageView) view.findViewById(f.icon);
        this.uKp = (LinearLayout) view.findViewById(f.root);
        if (d.u(bVar.uKm) || d.w(bVar.uKm)) {
            this.nDf = (TextView) view.findViewById(f.desc);
            this.uKn = (RadioButton) view.findViewById(f.radio);
            this.uKo = (ImageView) view.findViewById(f.divider);
        }
    }

    public final void onClick(View view) {
        if (this.uKq.PY != null) {
            this.uKq.PY.onItemClick(null, view, getPosition(), (long) getPosition());
        }
    }
}
