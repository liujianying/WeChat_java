package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g {

    public static final class c {
        public boolean kWM = false;
        public int kWN = 0;
        public int resourceId = 0;
        public int textColor = Integer.MIN_VALUE;
        public int textSize = Integer.MIN_VALUE;
    }

    static class e implements d {
        c kWH;

        e() {
        }

        public final void a(Context context, ViewGroup viewGroup, ai aiVar) {
            if (!bi.oW(aiVar.name)) {
                View inflate = LayoutInflater.from(context).inflate(com.tencent.mm.plugin.wxpay.a.g.lucky_money_text_oper_view, viewGroup, true);
                TextView textView = (TextView) inflate.findViewById(f.lucky_money_text_oper_wording);
                ImageView imageView = (ImageView) inflate.findViewById(f.lucky_money_text_oper_icon);
                if (bi.oW(aiVar.iconUrl)) {
                    imageView.setVisibility(8);
                } else {
                    o.g(imageView, aiVar.iconUrl);
                    imageView.setVisibility(0);
                }
                if (!(this.kWH == null || this.kWH.textColor == Integer.MIN_VALUE)) {
                    textView.setTextColor(this.kWH.textColor);
                }
                if (this.kWH == null || this.kWH.textSize == Integer.MIN_VALUE) {
                    textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(d.HintTextSize));
                } else {
                    textView.setTextSize(0, (float) this.kWH.textSize);
                }
                textView.setGravity(17);
                textView.setText(aiVar.name);
                if (!bi.oW(aiVar.content)) {
                    textView.setOnClickListener(new 1(this, aiVar, context));
                }
                viewGroup.setVisibility(0);
                h.mEJ.h(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(aiVar.kRD)});
                if (this.kWH != null) {
                    com.tencent.mm.protocal.f.eA(this.kWH.kWN, 0);
                }
            }
        }
    }

    public static void a(Context context, ViewGroup viewGroup, ai aiVar, c cVar) {
        if (aiVar != null) {
            a(context, viewGroup, aiVar, cVar, aiVar.type);
        }
    }

    public static void a(Context context, ViewGroup viewGroup, ai aiVar, c cVar, String str) {
        if (viewGroup != null && aiVar != null) {
            if (aiVar.ddp == 0) {
                x.i("MicroMsg.LuckyMoneyOperationViewMgr", "operInfo enable:" + aiVar.ddp);
                viewGroup.setVisibility(8);
            } else if (!aiVar.type.equalsIgnoreCase(str)) {
                x.i("MicroMsg.LuckyMoneyOperationViewMgr", "not match type:" + aiVar.type + ", " + str);
                viewGroup.setVisibility(8);
            } else if (str.equalsIgnoreCase("Text") || str.equalsIgnoreCase("Native")) {
                e eVar = new e();
                eVar.kWH = cVar;
                eVar.a(context, viewGroup, aiVar);
            } else if (str.equalsIgnoreCase("Pic")) {
                a aVar = new a();
                aVar.kWH = cVar;
                aVar.a(context, viewGroup, aiVar);
            } else if (str.equalsIgnoreCase("Appid")) {
                b bVar = new b();
                bVar.kWH = cVar;
                bVar.a(context, viewGroup, aiVar);
            }
        }
    }
}
