package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.ui.base.MMAutoHeightViewPager;
import com.tencent.mm.ui.base.MMPageControlView;
import java.util.ArrayList;

public class WalletPayUOpenIntroView extends LinearLayout {
    private ArrayList<View> Vp;
    private Context mContext;
    private MMAutoHeightViewPager pEF;
    private MMPageControlView pEG;
    private a pEH;
    private d[] pEI;

    public WalletPayUOpenIntroView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(a$g.payu_view_open_intro, this, true);
        this.pEF = (MMAutoHeightViewPager) inflate.findViewById(a$f.pager);
        this.pEG = (MMPageControlView) inflate.findViewById(a$f.controller);
        this.pEG.setVisibility(0);
        this.pEF.setOnPageChangeListener(new 1(this));
    }

    public WalletPayUOpenIntroView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setPagerData(d[] dVarArr) {
        this.pEI = dVarArr;
        this.Vp = new ArrayList();
        if (this.pEI != null) {
            for (int i = 0; i < this.pEI.length; i++) {
                this.Vp.add(LayoutInflater.from(this.mContext).inflate(a$g.payu_view_open_intro_item, null));
            }
        }
        this.pEH = new a(this, (byte) 0);
        this.pEF.setAdapter(this.pEH);
        this.pEG.eS(this.pEI == null ? 0 : this.pEI.length, 0);
    }
}
