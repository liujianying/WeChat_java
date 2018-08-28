package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.ui.g.c;
import com.tencent.mm.plugin.luckymoney.ui.g.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class g$a implements d {
    c kWH;

    g$a() {
    }

    public final void a(Context context, ViewGroup viewGroup, ai aiVar) {
        if (bi.oW(aiVar.name)) {
            x.w("MicroMsg.LuckyMoneyOperationViewMgr", "BannerPicOperationView attach iconUrl null");
            viewGroup.setVisibility(8);
            return;
        }
        View imageView = new ImageView(context);
        imageView.setScaleType(ScaleType.FIT_XY);
        o.g(imageView, aiVar.name);
        if (!bi.oW(aiVar.content)) {
            imageView.setOnClickListener(new 1(this, aiVar, context));
        }
        imageView.setLayoutParams(new LayoutParams(-1, -1));
        viewGroup.addView(imageView);
        viewGroup.setVisibility(0);
        h.mEJ.h(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(aiVar.kRD));
        if (this.kWH != null) {
            f.eA(this.kWH.kWN, 0);
        }
    }
}
