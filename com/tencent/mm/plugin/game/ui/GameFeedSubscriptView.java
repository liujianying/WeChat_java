package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e$a$a;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.sdk.platformtools.bi;

public class GameFeedSubscriptView extends LinearLayout implements OnClickListener {
    private ImageView hVP;
    private TextView jYA;
    private TextView jYB;
    private TextView jYC;
    private ac jYs;
    private TextView jYx;
    private TextView jYy;
    private LinearLayout jYz;

    public GameFeedSubscriptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(f.game_feed_subscript, this, true);
        this.jYx = (TextView) inflate.findViewById(e.left_subscript);
        this.jYy = (TextView) inflate.findViewById(e.left_subscript_with_box);
        this.jYz = (LinearLayout) inflate.findViewById(e.avatar_sub_script);
        this.hVP = (ImageView) inflate.findViewById(e.avatar);
        this.jYA = (TextView) inflate.findViewById(e.nick_name);
        this.jYB = (TextView) inflate.findViewById(e.user_action);
        this.jYC = (TextView) inflate.findViewById(e.right_subscript);
        this.jYx.setOnClickListener(this);
        this.jYy.setOnClickListener(this);
        this.jYz.setOnClickListener(this);
        this.jYC.setOnClickListener(this);
    }

    public void setData(ac acVar) {
        if (acVar == null || (acVar.jQB == null && acVar.jQC == null)) {
            setVisibility(8);
            return;
        }
        this.jYs = acVar;
        setVisibility(0);
        this.jYx.setVisibility(8);
        this.jYy.setVisibility(8);
        this.jYz.setVisibility(8);
        if (acVar.jQB != null) {
            switch (acVar.jQB.jPN) {
                case 1:
                    this.jYy.setVisibility(0);
                    this.jYy.setText(acVar.jQB.jOS);
                    break;
                case 2:
                    this.jYx.setVisibility(0);
                    this.jYx.setText(acVar.jQB.jOS);
                    break;
                case 3:
                    this.jYz.setVisibility(0);
                    if (!bi.oW(acVar.jQB.jPM)) {
                        e$a$a e_a_a = new e$a$a();
                        e_a_a.dXW = true;
                        com.tencent.mm.plugin.game.e.e.aVj().a(this.hVP, acVar.jQB.jPM, e_a_a.aVk());
                        this.hVP.setVisibility(0);
                    }
                    this.jYA.setText(acVar.jQB.jPe);
                    this.jYB.setText(acVar.jQB.jOS);
                    break;
            }
        }
        if (acVar.jQC != null) {
            this.jYC.setText(acVar.jQC.jOS);
            this.jYC.setVisibility(0);
            return;
        }
        this.jYC.setVisibility(8);
    }

    public void onClick(View view) {
        if (this.jYs != null) {
            if (view.getId() == e.left_subscript || view.getId() == e.left_subscript_with_box || view.getId() == e.avatar_sub_script) {
                if (this.jYs.jQB != null && !bi.oW(this.jYs.jQB.jOU)) {
                    c.an(getContext(), this.jYs.jQB.jOU);
                    qX(1);
                }
            } else if (view.getId() == e.right_subscript && this.jYs.jQC != null && !bi.oW(this.jYs.jQC.jOU)) {
                c.an(getContext(), this.jYs.jQC.jOU);
                qX(2);
            }
        }
    }

    private void qX(int i) {
        String Q;
        if (i == 1) {
            Q = an.Q(this.jYs.jPA, "clickType", "leftCorner");
        } else {
            Q = an.Q(this.jYs.jPA, "clickType", "rightCorner");
        }
        an.a(getContext(), 10, 1024, this.jYs.jPC, 7, this.jYs.jQb, GameIndexListView.getSourceScene(), Q);
    }
}
