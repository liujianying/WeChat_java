package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class d extends a {
    private TextView qvg;
    private View qvh;
    public LinearLayout qvi;

    public d(View view, k kVar) {
        super(view, kVar);
        this.qvi = (LinearLayout) view.findViewById(R.h.note_header_ll);
        this.qvi.setVisibility(0);
        this.qvg = (TextView) view.findViewById(R.h.note_header_tips);
        this.qvh = view.findViewById(R.h.note_header_split_line);
    }

    public final void a(b bVar, int i, int i2) {
        if (bVar.getType() == -3) {
            if (this.qtF.qrC == 3) {
                this.qvi.setVisibility(8);
                return;
            }
            this.qvi.setVisibility(0);
            com.tencent.mm.plugin.wenote.model.a.d dVar = (com.tencent.mm.plugin.wenote.model.a.d) bVar;
            if (dVar.qoS > 0) {
                Context context = this.qvg.getContext();
                long j = dVar.qoS;
                this.qvg.setText(this.qvg.getContext().getString(R.l.note_edit_time) + " " + (j < 3600000 ? "" : DateFormat.format(context.getString(R.l.favorite_longdate), j)));
            }
        }
    }

    public final int caZ() {
        return -3;
    }
}
