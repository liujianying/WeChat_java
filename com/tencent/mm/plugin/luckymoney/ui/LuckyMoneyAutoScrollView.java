package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class LuckyMoneyAutoScrollView extends RelativeLayout implements b {
    private View contentView;
    private RelativeLayout kTR;
    private RelativeLayout kTS;
    private RelativeLayout kTT;
    LuckyMoneyAutoScrollItem kTU;
    LuckyMoneyAutoScrollItem kTV;
    LuckyMoneyAutoScrollItem kTW;
    ImageView kTX;
    ImageView kTY;
    ImageView kTZ;
    private String kUa;
    private String kUb;
    private String kUc;
    boolean kUd;
    private a kUe;
    private Context mContext;

    public LuckyMoneyAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.kUa = "0";
        this.kUb = "0";
        this.kUc = "0";
        this.kUd = false;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(g.lucky_money_auto_scroll_view, this);
        this.contentView = inflate;
        this.kTU = (LuckyMoneyAutoScrollItem) inflate.findViewById(f.amount_1);
        this.kTV = (LuckyMoneyAutoScrollItem) inflate.findViewById(f.amount_2);
        this.kTW = (LuckyMoneyAutoScrollItem) inflate.findViewById(f.amount_3);
        this.kTX = (ImageView) inflate.findViewById(f.text_number);
        this.kTY = (ImageView) inflate.findViewById(f.text_number2);
        this.kTZ = (ImageView) inflate.findViewById(f.text_number3);
        this.kTR = (RelativeLayout) inflate.findViewById(f.item_layout_1);
        this.kTS = (RelativeLayout) inflate.findViewById(f.item_layout_2);
        this.kTT = (RelativeLayout) inflate.findViewById(f.item_layout_3);
    }

    public LuckyMoneyAutoScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setFinalText(String str) {
        x.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", new Object[]{str});
        this.kUa = str.substring(0, 1);
        this.kUb = str.substring(2, 3);
        this.kUc = str.substring(3, 4);
        this.kTU.setFinalNumber(bi.getInt(this.kUa, 0));
        this.kTV.setFinalNumber(bi.getInt(this.kUb, 0));
        this.kTW.setFinalNumber(bi.getInt(this.kUc, 0));
        this.kTX.setImageResource(((Integer) LuckyMoneyAutoScrollItem.kTL.get(bi.getInt(this.kUa, 0))).intValue());
        this.kTY.setImageResource(((Integer) LuckyMoneyAutoScrollItem.kTL.get(bi.getInt(this.kUb, 0))).intValue());
        this.kTZ.setImageResource(((Integer) LuckyMoneyAutoScrollItem.kTL.get(bi.getInt(this.kUc, 0))).intValue());
        this.kTX.setVisibility(4);
        this.kTY.setVisibility(4);
        this.kTZ.setVisibility(4);
        this.kTU.setOnScrollEndListener(this);
        this.kTV.setOnScrollEndListener(this);
        this.kTW.setOnScrollEndListener(this);
        x.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", new Object[]{this.kUa, this.kUb, this.kUc});
    }

    public final void a(a aVar) {
        this.kUe = aVar;
        ah.A(new 1(this));
    }

    public final void bbm() {
        if (!this.kUd) {
            this.kUd = true;
            ah.A(new 2(this));
        }
    }

    public final void cO(int i, int i2) {
        if (i > 0 && i2 > 0) {
            LayoutParams layoutParams = (LayoutParams) this.contentView.getLayoutParams();
            layoutParams.height = i2;
            this.contentView.setLayoutParams(layoutParams);
            this.contentView.invalidate();
            layoutParams = (LayoutParams) this.kTR.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.kTR.setLayoutParams(layoutParams);
            this.kTR.invalidate();
            layoutParams = (LayoutParams) this.kTS.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.kTS.setLayoutParams(layoutParams);
            this.kTS.invalidate();
            layoutParams = (LayoutParams) this.kTT.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            layoutParams.leftMargin = 0;
            this.kTT.setLayoutParams(layoutParams);
            this.kTT.invalidate();
        }
    }
}
