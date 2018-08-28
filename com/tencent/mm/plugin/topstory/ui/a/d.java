package com.tencent.mm.plugin.topstory.ui.a;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.video.a;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.c.bnq;
import com.tencent.mm.protocal.c.bth;
import java.io.IOException;

public final class d extends c {
    public TextView jzq;
    public TextView jzr;
    public View oCX;
    public View oCY;
    public View oCZ;
    public View oDa;
    public View oDb;

    public d(View view, a aVar) {
        super(view, aVar);
    }

    public final void cX(View view) {
        super.cX(view);
        this.oCZ = view.findViewById(com.tencent.mm.plugin.topstory.ui.b.d.bottom_layout);
        this.oCX = view.findViewById(com.tencent.mm.plugin.topstory.ui.b.d.bottom_tag_layout);
        this.oCY = view.findViewById(com.tencent.mm.plugin.topstory.ui.b.d.bottom_info_layout);
        this.oDa = view.findViewById(com.tencent.mm.plugin.topstory.ui.b.d.tag_1_ll);
        this.oDb = view.findViewById(com.tencent.mm.plugin.topstory.ui.b.d.tag_2_ll);
        this.jzq = (TextView) view.findViewById(com.tencent.mm.plugin.topstory.ui.b.d.tag_1_tv);
        this.jzr = (TextView) view.findViewById(com.tencent.mm.plugin.topstory.ui.b.d.tag_2_tv);
    }

    protected final void aL() {
        super.aL();
        aQV();
    }

    private void aQV() {
        bnq bnq;
        if (this.ozj.rBV.size() > 0) {
            bnq = (bnq) this.ozj.rBV.get(0);
            this.jzq.setTag(bnq);
            this.jzq.setText(bnq.bSc);
            this.jzq.setVisibility(0);
            this.jzq.setOnClickListener(this.mtE);
            this.oDa.setVisibility(0);
            this.oCX.setVisibility(0);
        } else {
            this.oDa.setVisibility(8);
            this.jzq.setVisibility(8);
            this.oCX.setVisibility(8);
        }
        if (this.ozj.rBV.size() > 1) {
            bnq = (bnq) this.ozj.rBV.get(1);
            this.jzr.setTag(bnq);
            this.jzr.setText(bnq.bSc);
            this.jzr.setOnClickListener(this.mtE);
            this.jzr.setVisibility(0);
            this.oDb.setVisibility(0);
        } else {
            this.oDb.setVisibility(8);
            this.jzr.setVisibility(8);
        }
        this.oCZ.post(new 1(this));
    }

    protected final void cY(View view) {
        super.cY(view);
        if (view.getId() == this.jzq.getId() || view.getId() == this.jzr.getId()) {
            this.oAb.bHR().ozV = true;
            this.oAb.bHS().stopPlay();
            this.oCJ.bIn();
            bnq bnq = (bnq) view.getTag();
            bth a = g.a(this.oAb.bHT());
            a.sqA = p.zK(a.scene);
            a.sqH = this.ozj.sqS;
            a.sqL = bnq.slJ;
            a.sqM = null;
            a.sqN = bnq;
            a.sqP = this.oAb.bHR().ozV;
            Intent intent = new Intent();
            try {
                intent.putExtra("key_context", a.toByteArray());
            } catch (IOException e) {
            }
            p.d(this.oAb.baA(), ".ui.video.TopStoryVideoStreamUI", intent);
            com.tencent.mm.plugin.websearch.api.a.a.kB(28);
            ((b) com.tencent.mm.kernel.g.n(b.class)).getReporter().a(this.oAb.bHT(), this.ozj, this.position, 4, bnq.bSc + ":" + bnq.id);
        }
    }

    public final void z(n nVar) {
        super.z(nVar);
        aQV();
    }
}
