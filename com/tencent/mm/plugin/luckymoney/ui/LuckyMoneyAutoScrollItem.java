package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public class LuckyMoneyAutoScrollItem extends ListView {
    public static SparseArray<Integer> kTL;
    private int gBZ;
    private a kTF;
    private long kTG;
    private int kTH;
    private CountDownTimer kTI;
    private int kTJ;
    private b kTK;
    private Context mContext;

    static /* synthetic */ int a(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem) {
        int i = luckyMoneyAutoScrollItem.gBZ + 1;
        luckyMoneyAutoScrollItem.gBZ = i;
        return i;
    }

    static {
        SparseArray sparseArray = new SparseArray();
        kTL = sparseArray;
        sparseArray.put(0, Integer.valueOf(e.newyearhonbao_number0));
        kTL.put(1, Integer.valueOf(e.newyearhonbao_number1));
        kTL.put(2, Integer.valueOf(e.newyearhonbao_number2));
        kTL.put(3, Integer.valueOf(e.newyearhonbao_number3));
        kTL.put(4, Integer.valueOf(e.newyearhonbao_number4));
        kTL.put(5, Integer.valueOf(e.newyearhonbao_number5));
        kTL.put(6, Integer.valueOf(e.newyearhonbao_number6));
        kTL.put(7, Integer.valueOf(e.newyearhonbao_number7));
        kTL.put(8, Integer.valueOf(e.newyearhonbao_number8));
        kTL.put(9, Integer.valueOf(e.newyearhonbao_number9));
    }

    public LuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.kTF = null;
        this.kTG = 900;
        this.kTH = 0;
        this.gBZ = 0;
        this.kTK = null;
        this.mContext = context;
        this.kTF = new a(this, (byte) 0);
        setAdapter(this.kTF);
        this.kTJ = (int) ((this.mContext.getResources().getDisplayMetrics().density * 60.0f) + 0.5f);
        x.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: scroll height is: %d", new Object[]{Integer.valueOf(this.kTJ)});
    }

    public LuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setScrollTime(long j) {
        this.kTG = j;
    }

    public static void setResouceMap(SparseArray<Integer> sparseArray) {
        kTL.clear();
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            kTL.put(keyAt, sparseArray.get(keyAt));
        }
    }

    void setOnScrollEndListener(b bVar) {
        this.kTK = bVar;
    }

    public final void bbl() {
        if (this.kTI != null) {
            this.kTI.cancel();
        }
        ah.A(new 1(this, ((long) (this.kTH * 50)) + this.kTG));
    }

    public void setFinalNumber(int i) {
        this.kTH = i;
    }
}
