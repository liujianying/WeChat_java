package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.df;
import com.tencent.mm.plugin.game.d.dg;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.sdk.platformtools.bi;

public class GameNewClassifyView extends LinearLayout implements OnClickListener {
    private LayoutInflater eMa;
    private int jNv;
    private LinearLayout jeZ;

    public GameNewClassifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.eMa = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.jeZ = (LinearLayout) findViewById(e.game_list);
    }

    public final void a(dg dgVar, int i, int i2) {
        if (dgVar == null || bi.cX(dgVar.jQF)) {
            setVisibility(8);
            return;
        }
        LinearLayout linearLayout;
        this.jNv = i2;
        if (this.eMa == null) {
            this.eMa = (LayoutInflater) getContext().getSystemService("layout_inflater");
        }
        this.jeZ.removeAllViews();
        while (this.jeZ.getChildCount() < dgVar.jQF.size()) {
            linearLayout = (LinearLayout) this.eMa.inflate(f.game_new_classify_item, this, false);
            linearLayout.setOnClickListener(this);
            this.jeZ.addView(linearLayout, new LayoutParams(-2, -2, 1.0f));
        }
        for (int i3 = 0; i3 < this.jeZ.getChildCount(); i3++) {
            if (i3 < dgVar.jQF.size()) {
                this.jeZ.getChildAt(i3).setVisibility(0);
            } else {
                this.jeZ.getChildAt(i3).setVisibility(8);
            }
        }
        for (int i4 = 0; i4 < dgVar.jQF.size(); i4++) {
            linearLayout = (LinearLayout) this.jeZ.getChildAt(i4);
            TextView textView = (TextView) linearLayout.findViewById(e.game_classify_text);
            com.tencent.mm.plugin.game.e.e.aVj().g((ImageView) linearLayout.findViewById(e.game_classify_icon), ((df) dgVar.jQF.get(i4)).jPG);
            textView.setText(((df) dgVar.jQF.get(i4)).bHD);
            linearLayout.setTag(new a(((df) dgVar.jQF.get(i4)).jOU, i4 + 1, ((df) dgVar.jQF.get(i4)).jPA));
        }
        setVisibility(0);
        if (i == 2) {
            an.a(getContext(), 10, 1019, 0, null, this.jNv, null);
        }
    }

    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            if (!bi.oW(aVar.url)) {
                c.an(getContext(), aVar.url);
                an.a(getContext(), 10, 1019, aVar.position, 7, null, this.jNv, an.Dx(aVar.extInfo));
            }
        }
    }
}
