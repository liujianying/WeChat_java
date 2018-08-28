package com.tencent.mm.plugin.sns.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.storage.av;

class SnsTimeLineUI$49 implements Runnable {
    final /* synthetic */ LayoutInflater hHM;
    final /* synthetic */ n nMf;
    final /* synthetic */ bsu nUW;
    final /* synthetic */ long nWp;
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$49(SnsTimeLineUI snsTimeLineUI, LayoutInflater layoutInflater, bsu bsu, n nVar, long j) {
        this.odw = snsTimeLineUI;
        this.hHM = layoutInflater;
        this.nUW = bsu;
        this.nMf = nVar;
        this.nWp = j;
    }

    public final void run() {
        String string;
        View inflate = this.hHM.inflate(g.sns_header_collapse_item, SnsTimeLineUI.x(this.odw), false);
        SnsTimeLineUI.x(this.odw).addView(inflate);
        if (SnsTimeLineUI.x(this.odw).getChildCount() > 0) {
            SnsTimeLineUI.x(this.odw).setVisibility(0);
        }
        String str = "";
        ImageView imageView = (ImageView) inflate.findViewById(f.sns_notify_preview);
        TextView textView = (TextView) inflate.findViewById(f.sns_notify_tips);
        if (this.nUW.sqc.ruA.size() > 0) {
            ate ate = (ate) this.nUW.sqc.ruA.get(0);
            com.tencent.mm.plugin.sns.model.g byl = af.byl();
            int hashCode = this.odw.hashCode();
            av clT = av.clT();
            clT.time = this.nUW.lOH;
            byl.b(ate, imageView, hashCode, clT);
        }
        if (this.nUW.sqc.ruz == 1) {
            textView.setText(j.sns_photo_collapse);
            string = this.odw.getString(j.sns_photo_collapse_hint);
        } else if (this.nUW.sqc.ruz == 15) {
            textView.setText(j.sns_sight_collapse);
            string = this.odw.getString(j.sns_sight_collapse_hint);
        } else {
            string = str;
        }
        inflate.setOnClickListener(new 1(this, string));
    }
}
