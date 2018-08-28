package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.m.b;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.ui.GameDetailRankUI.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.x;

public class GameRankHeadView extends LinearLayout implements OnClickListener {
    private TextView eGX;
    private d jNS;
    private TextView jVX;
    private n jWB;
    b jWz;
    private TextView kbu;
    private ImageView kbv;

    public GameRankHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.eGX = (TextView) findViewById(e.game_detail_rank_title);
        this.kbu = (TextView) findViewById(e.game_detail_rank_desc);
        this.jVX = (TextView) findViewById(e.game_detail_rank_tag);
        this.kbv = (ImageView) findViewById(e.game_more_icon);
        x.i("MicroMsg.GameRankHeadView", "initView finished");
    }

    private void aUU() {
        if (g.a(getContext(), this.jNS)) {
            if (this.jNS.versionCode > c.DP(this.jNS.field_packageName)) {
                this.jVX.setText(i.game_detail_rank_update);
                return;
            } else {
                this.jVX.setText(i.game_detail_rank_launch);
                return;
            }
        }
        switch (this.jNS.status) {
            case 0:
                if (this.jWB == null) {
                    this.jVX.setVisibility(8);
                    this.kbv.setVisibility(8);
                    return;
                }
                this.jVX.setVisibility(0);
                this.kbv.setVisibility(0);
                switch (this.jWB.status) {
                    case 0:
                        this.jVX.setText(i.game_detail_rank_download);
                        return;
                    case 1:
                        this.jVX.setText(i.game_detail_rank_downloading);
                        return;
                    case 2:
                        this.jVX.setText(i.game_detail_rank_continue);
                        return;
                    case 3:
                        this.jVX.setText(i.game_detail_rank_install);
                        return;
                    default:
                        return;
                }
            default:
                this.jVX.setText(i.game_detail_rank_download);
                return;
        }
    }

    public void setData(a aVar) {
        this.eGX.setText(aVar.jWs);
        this.kbu.setText(aVar.jWt);
        this.jNS = aVar.jWu;
        this.jNS.bYq = 1203;
        this.jNS.position = 2;
        if (this.jWB == null) {
            this.jWB = new n(this.jNS);
        }
        this.jWB.dC(getContext());
        this.jWB.aTT();
        aUU();
        if (this.jWz != null) {
            m.a(this.jWz);
        } else {
            this.jWz = new 1(this);
            m.a(this.jWz);
        }
        this.jVX.setOnClickListener(this);
    }

    public void onClick(View view) {
        new d(getContext()).a(this.jNS, new n(this.jNS));
    }
}
