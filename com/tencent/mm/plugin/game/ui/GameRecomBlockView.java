package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.game.d.ag;
import com.tencent.mm.plugin.game.d.cv;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f.b;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class GameRecomBlockView extends LinearLayout implements OnClickListener {
    private LayoutInflater Bc = ((LayoutInflater) getContext().getSystemService("layout_inflater"));
    int jNv;
    private ViewGroup mContainer = this;
    private Context mContext;

    public GameRecomBlockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        x.i("MicroMsg.GameRecomBlockView", "initView finished");
    }

    final void a(ag agVar, int i, int i2) {
        this.mContainer.removeAllViews();
        if (bi.cX(agVar.jQF)) {
            setVisibility(8);
            return;
        }
        if (i == 2) {
            an.a(this.mContext, 10, 1021, 0, null, i2, an.Dx(agVar.jPA));
        }
        this.Bc.inflate(f.game_center_4_block_recom, this, true);
        TextView textView = (TextView) findViewById(e.recom_module_title);
        LinearLayout linearLayout = (LinearLayout) findViewById(e.recom_item_layout);
        View findViewById = findViewById(e.recom_more_layout);
        TextView textView2 = (TextView) findViewById(e.recom_more_text);
        if (bi.oW(agVar.jPB)) {
            textView.setVisibility(8);
        } else {
            textView.setText(agVar.jPB);
        }
        if (bi.oW(agVar.jQG)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(agVar.jQG);
        }
        findViewById.setTag(new a(null, 999, agVar.jQH, agVar.jPA, "game_center_mygame_more"));
        findViewById.setOnClickListener(this);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < agVar.jQF.size()) {
                cv cvVar = (cv) agVar.jQF.get(i5);
                if (cvVar != null) {
                    if (linearLayout.getChildCount() < 3) {
                        i3++;
                        LinearLayout linearLayout2 = (LinearLayout) this.Bc.inflate(f.game_center_4_block_recom_item, this, false);
                        linearLayout2.setTag(new a(cvVar.jQb, i3, cvVar.jOU, cvVar.jPA, "game_center_mygame_rank"));
                        linearLayout2.setOnClickListener(this);
                        linearLayout.addView(linearLayout2, new LayoutParams(-1, -2, 1.0f));
                        textView = (TextView) linearLayout2.findViewById(e.recom_item_title);
                        ImageView imageView = (ImageView) linearLayout2.findViewById(e.recom_item_img);
                        TextView textView3 = (TextView) linearLayout2.findViewById(e.recom_item_name);
                        TextView textView4 = (TextView) linearLayout2.findViewById(e.recom_item_desc);
                        switch (i5) {
                            case 0:
                                textView.setTextColor(this.mContext.getResources().getColor(b.game_recom_first_item_color));
                                break;
                            case 1:
                                textView.setTextColor(this.mContext.getResources().getColor(b.game_recom_second_item_color));
                                break;
                            case 2:
                                textView.setTextColor(this.mContext.getResources().getColor(b.game_recom_third_item_color));
                                break;
                        }
                        textView.setText(cvVar.bHD);
                        com.tencent.mm.plugin.game.e.e.aVj().g(imageView, cvVar.jOT);
                        textView3.setText(cvVar.jSv);
                        if (bi.oW(cvVar.jOS)) {
                            textView4.setVisibility(8);
                        } else {
                            textView4.setText(cvVar.jOS);
                        }
                        if (i == 2) {
                            an.a(this.mContext, 10, 1021, i3, cvVar.jQb, i2, an.Dx(cvVar.jPA));
                        }
                    }
                }
                i4 = i5 + 1;
            }
        }
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(b.game_divided_line_color));
        addView(view, new LayoutParams(-1, a.fromDPToPix(getContext(), 5)));
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            x.w("MicroMsg.GameRecomBlockView", "getTag is null");
            return;
        }
        a aVar = (a) view.getTag();
        if (bi.oW(aVar.jumpUrl)) {
            x.w("MicroMsg.GameRecomBlockView", "jumpUrl is null");
            return;
        }
        an.a(this.mContext, 10, 1021, aVar.jOu, c.r(this.mContext, aVar.jumpUrl, aVar.bZM), aVar.appId, this.jNv, an.Dx(aVar.jLt));
    }
}
