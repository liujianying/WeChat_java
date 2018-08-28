package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.v;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.game.d.dh;
import com.tencent.mm.plugin.game.d.di;
import com.tencent.mm.plugin.game.f$a;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.plugin.game.model.af.a;
import com.tencent.mm.plugin.game.model.an;

public class GameDetailRankLikeView extends LinearLayout implements OnClickListener {
    private int jNv;
    af jWa;
    a jWb;
    private Drawable jWc;
    private Drawable jWd;
    private Animation jWe;
    private ImageView jWf;
    private TextView jWg;
    String mAppId;

    public GameDetailRankLikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jWc = getContext().getResources().getDrawable(d.game_rank_like_btn_hightlight);
        this.jWd = getContext().getResources().getDrawable(d.game_rank_like_btn_gray);
        this.jWe = AnimationUtils.loadAnimation(getContext(), f$a.scale_up_down);
        inflate(getContext(), f.game_detail2_rank_item_like, this);
        setOnClickListener(this);
        this.jWf = (ImageView) findViewById(e.like_btn);
        this.jWg = (TextView) findViewById(e.like_count);
    }

    final void aUT() {
        if (this.jWb != null) {
            if (this.jWb.jNJ) {
                this.jWf.setImageDrawable(this.jWc);
            } else {
                this.jWf.setImageDrawable(this.jWd);
            }
            setCount(this.jWb.jNI);
            return;
        }
        setVisibility(8);
    }

    private void setCount(int i) {
        if (i > 99) {
            this.jWg.setText("99+");
        } else if (i == 0) {
            this.jWg.setText("");
        } else {
            this.jWg.setText(String.valueOf(i));
        }
    }

    public void onClick(View view) {
        if (q.GF().equals(this.jWb.bWJ)) {
            if (this.jWb.jNI > 0) {
                Intent intent = new Intent(getContext(), GameDetailRankLikedUI.class);
                intent.putExtra("extra_appdi", this.mAppId);
                getContext().startActivity(intent);
            }
        } else if (!this.jWb.jNJ) {
            this.jWb.jNJ = true;
            a aVar = this.jWb;
            aVar.jNI++;
            this.jWa.aUq();
            String str = this.mAppId;
            String str2 = this.jWb.bWJ;
            b.a aVar2 = new b.a();
            aVar2.dIG = new dh();
            aVar2.dIH = new di();
            aVar2.uri = "/cgi-bin/mmgame-bin/upfriend";
            aVar2.dIF = 1330;
            b KT = aVar2.KT();
            dh dhVar = (dh) KT.dID.dIL;
            dhVar.jPc = str;
            dhVar.jTu = str2;
            v.a(KT, new 1(this));
            an.a(getContext(), 12, 1203, 1, 2, this.mAppId, this.jNv, null);
            aUT();
            this.jWf.startAnimation(this.jWe);
        }
    }

    public void setSourceScene(int i) {
        this.jNv = i;
    }
}
