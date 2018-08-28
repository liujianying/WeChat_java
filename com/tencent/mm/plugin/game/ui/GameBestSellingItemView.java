package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.game.d.w;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f;
import com.tencent.mm.plugin.game.model.ac;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.widget.AutoResizeTextView;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bi;

public class GameBestSellingItemView extends LinearLayout implements OnClickListener {
    private e jUA;
    AutoResizeTextView jUs;
    ImageView jUt;
    TextView jUu;
    GameTagListView jUv;
    GameDownloadView jUw;
    View jUx;
    private int jUy;
    private w jUz;

    public GameBestSellingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jUs = (AutoResizeTextView) findViewById(f.e.game_num);
        this.jUt = (ImageView) findViewById(f.e.game_icon);
        this.jUu = (TextView) findViewById(f.e.game_name);
        this.jUv = (GameTagListView) findViewById(f.e.tag_list);
        this.jUw = (GameDownloadView) findViewById(f.e.game_btn_container);
        this.jUx = findViewById(f.e.social_stub);
        this.jUy = c.getScreenWidth(getContext()) - a.fromDPToPix(getContext(), 190);
        setOnClickListener(this);
    }

    public void setData(e eVar) {
        if (eVar == null || eVar.jLz == null || eVar.jLz.jQx == null || bi.cX(eVar.jLz.jQx.jPz)) {
            setVisibility(8);
            return;
        }
        this.jUA = eVar;
        w wVar = (w) eVar.jLz.jQx.jPz.get(eVar.jLA);
        int i = eVar.jLA + 1;
        if (wVar == null || wVar.jOV == null) {
            setVisibility(8);
        } else {
            this.jUz = wVar;
            d a = ac.a(this.jUz.jOV);
            a.scene = 10;
            a.bYq = 1022;
            a.position = this.jUA.jLA + 1;
            this.jUw.setDownloadInfo(new n(a));
            setVisibility(0);
            this.jUs.setText(String.valueOf(i));
            if (i == 1) {
                this.jUs.setTextColor(c.parseColor("#EED157"));
            } else if (i == 2) {
                this.jUs.setTextColor(c.parseColor("#BDC5CB"));
            } else if (i == 3) {
                this.jUs.setTextColor(c.parseColor("#D4B897"));
            } else {
                this.jUs.setTextColor(c.parseColor("#B2B2B2"));
            }
            com.tencent.mm.plugin.game.e.e.aVj().a(this.jUt, wVar.jOV.jPc, a.getDensity(getContext()));
            this.jUu.setText(wVar.jOV.jPe);
            this.jUv.e(wVar.jOV.jPt, this.jUy);
            if (bi.cX(wVar.jQg) && wVar.jQh == null && wVar.jOS == null) {
                this.jUx.setVisibility(8);
            } else {
                if (this.jUx instanceof ViewStub) {
                    this.jUx = ((ViewStub) this.jUx).inflate();
                }
                ((GameFeedSocialInfoView) this.jUx.findViewById(f.e.game_social_info)).setData(wVar);
            }
        }
        if (!eVar.jLB) {
            an.a(getContext(), 10, 1022, eVar.jLA + 1, wVar.jOV.jPc, GameIndexListView.getSourceScene(), an.Dx(eVar.jLz.jPA));
            eVar.jLB = true;
        }
    }

    public void onClick(View view) {
        if (this.jUz != null && !bi.oW(this.jUz.jOV.jOX)) {
            an.a(getContext(), 10, 1022, this.jUA.jLA + 1, c.an(getContext(), this.jUz.jOV.jOX), this.jUz.jOV.jPc, GameIndexListView.getSourceScene(), an.Dx(this.jUA.jLz.jPA));
        }
    }
}
