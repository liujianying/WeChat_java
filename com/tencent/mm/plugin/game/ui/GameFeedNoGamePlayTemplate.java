package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.f;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class GameFeedNoGamePlayTemplate extends LinearLayout implements OnClickListener {
    private ImageView gER;
    private e jUA;
    GameDownloadView jUw;
    private GameRoundImageView jXY;
    private ImageView jXZ;
    private GameFeedTitleDescView jYl;
    private FrameLayout jYm;
    private RelativeLayout jYn;
    private TextView jYo;

    public GameFeedNoGamePlayTemplate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.jYl = (GameFeedTitleDescView) findViewById(f.e.game_feed_title_desc);
        this.jYm = (FrameLayout) findViewById(f.e.image_ly);
        this.jXY = (GameRoundImageView) findViewById(f.e.cover_image);
        this.jXZ = (ImageView) findViewById(f.e.video_play);
        this.jYn = (RelativeLayout) findViewById(f.e.game_desc_container);
        this.gER = (ImageView) findViewById(f.e.game_icon);
        this.jYo = (TextView) findViewById(f.e.game_name);
        this.jUw = (GameDownloadView) findViewById(f.e.game_download_container);
        setOnClickListener(this);
        this.jYm.setOnClickListener(this);
    }

    public void setData(e eVar) {
        x.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData");
        if (eVar == null || eVar.jLz == null || eVar.jLz.jQw == null) {
            setVisibility(8);
            return;
        }
        x.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData 1");
        this.jUA = eVar;
        ac acVar = eVar.jLz;
        setVisibility(0);
        this.jYl.a(acVar.jQw.bHD, acVar.jQw.jOS, acVar.jQw.jTa);
        this.jYm.setVisibility(0);
        if (bi.oW(acVar.jQw.jOT)) {
            this.jYm.setVisibility(8);
        } else {
            com.tencent.mm.plugin.game.e.e.aVj().a(this.jXY, acVar.jQw.jOT, getResources().getDimensionPixelSize(c.GameMatchImageWidth), getResources().getDimensionPixelSize(c.GameMatchImageHeight), (com.tencent.mm.plugin.game.e.c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
            if (bi.oW(acVar.jQw.jRi)) {
                this.jXZ.setVisibility(8);
            } else {
                this.jXZ.setVisibility(0);
            }
        }
        if (acVar.jQw.jOV != null) {
            this.jYn.setVisibility(0);
            com.tencent.mm.plugin.game.e.e.aVj().a(this.gER, acVar.jQw.jOV.jPc, a.getDensity(getContext()));
            this.jYo.setText(acVar.jQw.jOV.jPe);
            d a = com.tencent.mm.plugin.game.model.ac.a(acVar.jQw.jOV);
            a.scene = 10;
            a.bYq = 1024;
            a.position = this.jUA.position;
            this.jUw.setDownloadInfo(new n(a));
        }
        if (!this.jUA.jLB) {
            an.a(getContext(), 10, 1024, this.jUA.position, this.jUA.jLz.jQb, GameIndexListView.getSourceScene(), an.Dx(this.jUA.jLz.jPA));
            this.jUA.jLB = true;
        }
    }

    public void onClick(View view) {
        if (this.jUA != null && this.jUA.jLz != null && this.jUA.jLz.jQw != null) {
            if (view.getId() == f.e.image_ly && !bi.oW(this.jUA.jLz.jQw.jRi)) {
                an.a(getContext(), 10, 1024, this.jUA.position, com.tencent.mm.plugin.game.e.c.an(getContext(), this.jUA.jLz.jQw.jRi), this.jUA.jLz.jQb, GameIndexListView.getSourceScene(), an.Q(this.jUA.jLz.jPA, "clickType", "middle"));
            } else if (!bi.oW(this.jUA.jLz.jOU)) {
                an.a(getContext(), 10, 1024, this.jUA.position, com.tencent.mm.plugin.game.e.c.an(getContext(), this.jUA.jLz.jOU), this.jUA.jLz.jQb, GameIndexListView.getSourceScene(), an.Q(this.jUA.jLz.jPA, "clickType", "card"));
            }
        }
    }
}
