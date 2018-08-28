package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bi;

public class GameFeedGameTemplateView extends LinearLayout implements OnClickListener {
    private TextView hVS;
    private e jUA;
    private int jUy;
    private ImageView jWE;
    private TextView jWF;
    private GameTagListView jXW;
    private FrameLayout jXX;
    private GameRoundImageView jXY;
    private ImageView jXZ;
    private GameFeedSubscriptView jYa;
    private GameDownloadView jYb;

    public GameFeedGameTemplateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jWE = (ImageView) findViewById(f.e.game_icon);
        this.jWF = (TextView) findViewById(f.e.game_name);
        this.jXW = (GameTagListView) findViewById(f.e.game_tag_list);
        this.hVS = (TextView) findViewById(f.e.desc);
        this.jXX = (FrameLayout) findViewById(f.e.video_ly);
        this.jXY = (GameRoundImageView) findViewById(f.e.image);
        this.jXZ = (ImageView) findViewById(f.e.video_play);
        this.jYa = (GameFeedSubscriptView) findViewById(f.e.subscript);
        this.jYb = (GameDownloadView) findViewById(f.e.game_download_container);
        setOnClickListener(this);
        this.jUy = c.getScreenWidth(getContext()) - a.fromDPToPix(getContext(), 175);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setData(e eVar) {
        if (eVar == null || eVar.jLz == null || eVar.jLz.jQv == null) {
            setVisibility(8);
            return;
        }
        this.jUA = eVar;
        ac acVar = eVar.jLz;
        setVisibility(0);
        com.tencent.mm.plugin.game.e.e.aVj().a(this.jWE, acVar.jQv.jOV.jPc, a.getDensity(getContext()));
        this.jWF.setText(acVar.jQv.jOV.jPe);
        this.jXW.e(acVar.jQv.jOV.jPt, this.jUy);
        if (bi.oW(acVar.jQv.jRg)) {
            this.hVS.setVisibility(8);
        } else {
            this.hVS.setText(acVar.jQv.jRg);
            this.hVS.setVisibility(0);
        }
        this.jXX.setVisibility(0);
        if (!bi.oW(acVar.jQv.jRi)) {
            b(this.jXY, acVar.jQv.jOT);
            this.jXZ.setVisibility(0);
        } else if (bi.oW(acVar.jQv.jOT)) {
            this.jXX.setVisibility(8);
        } else {
            b(this.jXY, acVar.jQv.jOT);
            this.jXZ.setVisibility(8);
        }
        this.jXX.setOnClickListener(this);
        this.jYa.setData(acVar);
        d a = com.tencent.mm.plugin.game.model.ac.a(this.jUA.jLz.jQv.jOV);
        a.scene = 10;
        a.bYq = 1024;
        a.position = this.jUA.position;
        this.jYb.setDownloadInfo(new n(a));
        if (!this.jUA.jLB) {
            an.a(getContext(), 10, 1024, this.jUA.position, this.jUA.jLz.jQb, GameIndexListView.getSourceScene(), an.Dx(this.jUA.jLz.jPA));
            this.jUA.jLB = true;
        }
    }

    public void onClick(View view) {
        if (this.jUA != null && this.jUA.jLz != null) {
            if (view.getId() == f.e.video_ly && !bi.oW(this.jUA.jLz.jQv.jRh)) {
                an.a(getContext(), 10, 1024, this.jUA.position, c.an(getContext(), this.jUA.jLz.jQv.jRh), this.jUA.jLz.jQb, GameIndexListView.getSourceScene(), an.Q(this.jUA.jLz.jPA, "clickType", "middle"));
            } else if (!bi.oW(this.jUA.jLz.jOU)) {
                an.a(getContext(), 10, 1024, this.jUA.position, c.an(getContext(), this.jUA.jLz.jOU), this.jUA.jLz.jQb, GameIndexListView.getSourceScene(), an.Q(this.jUA.jLz.jPA, "clickType", "card"));
            }
        }
    }

    private void b(ImageView imageView, String str) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(f.c.GameMatchImageWidth);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(f.c.GameMatchImageHeight);
        com.tencent.mm.plugin.game.e.e.aVj().a(imageView, str, dimensionPixelSize, dimensionPixelSize2, (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
    }
}
