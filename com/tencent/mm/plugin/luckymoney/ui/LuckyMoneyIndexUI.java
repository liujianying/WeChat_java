package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.plugin.luckymoney.b.x;
import com.tencent.mm.plugin.luckymoney.ui.g.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.s;

public class LuckyMoneyIndexUI extends LuckyMoneyBaseUI {
    private int kTw;
    private LinearLayout kVp;
    private LinearLayout kVq;
    private LinearLayout kVr;

    static /* synthetic */ void a(LuckyMoneyIndexUI luckyMoneyIndexUI, int i) {
        Intent intent = new Intent();
        intent.setClass(luckyMoneyIndexUI.mController.tml, LuckyMoneyPrepareUI.class);
        intent.putExtra("key_way", 3);
        intent.putExtra("key_type", i);
        intent.putExtra("pay_channel", luckyMoneyIndexUI.kTw);
        luckyMoneyIndexUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((b) g.l(b.class)).a(this, null);
        initView();
        b(new x("v1.0", (byte) 0), false);
        this.kTw = getIntent().getIntExtra("pay_channel", -1);
        h.mEJ.h(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
    }

    protected void onResume() {
        super.onResume();
        b bVar = (b) g.l(b.class);
        bVar.a(this, bVar.bRo(), null);
    }

    protected final void initView() {
        setMMTitle(i.lucky_money_title);
        setBackBtn(new 1(this));
        this.kVp = (LinearLayout) findViewById(f.lucky_money_index_tail_opertaion);
        this.kVq = (LinearLayout) findViewById(f.lucky_money_index_middle_opertaion);
        this.kVr = (LinearLayout) findViewById(f.lucky_money_index_banner_opertaion);
        ((Button) findViewById(f.lucky_money_index_normal)).setOnClickListener(new 2(this));
        ((Button) findViewById(f.lucky_money_index_group)).setOnClickListener(new 3(this));
        a(0, getString(i.lucky_money_mine_title), new 4(this), s.b.tne);
        bbu();
    }

    private void bbu() {
        a.bat();
        d baS = a.bau().baS();
        if (baS != null) {
            ImageView imageView = (ImageView) findViewById(f.lucky_money_index_top_decoration);
            if ((baS.kPG & 1) == 1) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.LuckyMoneyIndexUI", "initView: topBg use money bg");
                imageView.setImageResource(e.lucky_money_index_top_decoration);
                return;
            }
            imageView.setImageResource(e.lucky_money_index_topbg_temporary);
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.lucky_money_index_ui;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof x)) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            x xVar = (x) lVar;
            c cVar = new c();
            cVar.textColor = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.lucky_money_index_operation_text_color);
            cVar.kWN = 101;
            g.a(this, this.kVp, xVar.kQa, cVar, "Text");
            cVar = new c();
            cVar.textColor = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.lucky_money_index_operation_text_color);
            cVar.kWN = 100;
            g.a(this, this.kVq, xVar.kRi, cVar, "Text");
            cVar = new c();
            cVar.kWN = 102;
            g.a(this, this.kVr, xVar.kRg, cVar, "Pic");
            bbu();
        }
        return true;
    }
}
