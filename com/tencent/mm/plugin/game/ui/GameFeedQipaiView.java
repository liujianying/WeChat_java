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
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.am;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Iterator;

public class GameFeedQipaiView extends LinearLayout implements OnClickListener {
    private TextView gsY;
    private TextView jYp;
    private ImageView jYq;
    private LinearLayout jYr;
    private ac jYs;

    public GameFeedQipaiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.gsY = (TextView) findViewById(e.title);
        this.jYp = (TextView) findViewById(e.more_etc_tv);
        this.jYq = (ImageView) findViewById(e.more_arrow);
        this.jYr = (LinearLayout) findViewById(e.game_item_container);
        this.jYp.setOnClickListener(this);
    }

    public void setData(com.tencent.mm.plugin.game.model.e eVar) {
        if (eVar == null || eVar.jLz == null || eVar.jLz.jQA == null) {
            setVisibility(8);
            return;
        }
        ac acVar = eVar.jLz;
        setVisibility(0);
        this.jYs = acVar;
        if (bi.oW(acVar.jQA.bHD)) {
            this.gsY.setVisibility(8);
        } else {
            this.gsY.setText(acVar.jQA.bHD);
            this.gsY.setVisibility(0);
        }
        if (bi.oW(acVar.jQA.jQG)) {
            this.jYp.setVisibility(8);
            this.jYq.setVisibility(8);
        } else {
            this.jYq.setVisibility(0);
            this.jYp.setVisibility(0);
            this.jYp.setText(acVar.jQA.jQG);
        }
        this.jYr.removeAllViews();
        if (!bi.cX(acVar.jQA.jPz)) {
            Iterator it = acVar.jQA.jPz.iterator();
            while (it.hasNext()) {
                am amVar = (am) it.next();
                View inflate = LayoutInflater.from(getContext()).inflate(f.game_center_4_block_recom_item, this, false);
                inflate.setOnClickListener(this);
                inflate.setTag(Integer.valueOf(acVar.jQA.jPz.indexOf(amVar)));
                this.jYr.addView(inflate, new LayoutParams(-1, -2, 1.0f));
                TextView textView = (TextView) inflate.findViewById(e.recom_item_title);
                ImageView imageView = (ImageView) inflate.findViewById(e.recom_item_img);
                TextView textView2 = (TextView) inflate.findViewById(e.recom_item_name);
                TextView textView3 = (TextView) inflate.findViewById(e.recom_item_desc);
                textView.setVisibility(8);
                com.tencent.mm.plugin.game.e.e.aVj().g(imageView, amVar.jQV);
                textView2.setText(amVar.bHD);
                textView3.setText(amVar.jOS);
            }
        }
        if (!eVar.jLB) {
            an.a(getContext(), 10, 1023, eVar.position, eVar.jLz.jQb, GameIndexListView.getSourceScene(), an.Dx(eVar.jLz.jPA));
            eVar.jLB = true;
        }
    }

    public void onClick(View view) {
        if (this.jYs != null) {
            if (view.getId() != e.more_etc_tv) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue <= this.jYs.jQA.jPz.size() - 1) {
                    am amVar = (am) this.jYs.jQA.jPz.get(intValue);
                    if (!bi.oW(amVar.jOU)) {
                        an.a(getContext(), 10, 1023, intValue + 1, c.an(getContext(), amVar.jOU), amVar.jQb, GameIndexListView.getSourceScene(), an.Dx(this.jYs.jPA));
                    }
                }
            } else if (!bi.oW(this.jYs.jQA.jQZ)) {
                an.a(getContext(), 10, 1023, 999, c.an(getContext(), this.jYs.jQA.jQZ), null, GameIndexListView.getSourceScene(), an.Dx(this.jYs.jPA));
            }
        }
    }
}
