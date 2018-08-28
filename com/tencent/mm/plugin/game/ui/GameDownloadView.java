package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.m.b;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;

public class GameDownloadView extends FrameLayout implements OnClickListener {
    private n jWB;
    private b jWz = new 4(this);
    private Button jXG;
    private TextProgressBar jXH;
    private d jXI;

    public GameDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(f.game_download_view, this, true);
        this.jXG = (Button) inflate.findViewById(e.game_download_btn);
        this.jXH = (TextProgressBar) inflate.findViewById(e.game_download_progress);
        this.jXH.setTextSize(14);
        this.jXG.setOnClickListener(this);
        this.jXH.setOnClickListener(this);
        this.jXI = new d(getContext());
        this.jXI.jUg = new 1(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m.b(this.jWz);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m.a(this.jWz);
    }

    public final void refresh() {
        if (this.jWB != null) {
            this.jWB.dC(ad.getContext());
            this.jWB.aTT();
            aUU();
        }
    }

    public void setDownloadInfo(n nVar) {
        this.jWB = nVar;
        c.Em().H(new 2(this));
        aUU();
    }

    private void aUU() {
        ah.A(new 3(this));
    }

    public void onClick(View view) {
        this.jWB.dC(ad.getContext());
        this.jXI.a(this.jWB.jMa, this.jWB);
    }
}
