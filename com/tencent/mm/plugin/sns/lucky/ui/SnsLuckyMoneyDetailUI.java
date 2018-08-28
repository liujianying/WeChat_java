package com.tencent.mm.plugin.sns.lucky.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import java.util.LinkedList;
import java.util.List;

public class SnsLuckyMoneyDetailUI extends LuckyMoneyBaseUI {
    private ListView kLN;
    OnScrollListener kLU = new 1(this);
    private final int kVm = 750;
    private final int kVn = 240;
    private b nmf;

    static /* synthetic */ void bxf() {
    }

    static /* synthetic */ void bxg() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        List FZ = a.FZ(getIntent().getStringExtra("key_feedid"));
        if (!(FZ == null || FZ.size() == 0)) {
            b bVar = this.nmf;
            if (FZ == null) {
                LinkedList linkedList = new LinkedList();
            } else {
                bVar.kLz = FZ;
            }
            bVar.notifyDataSetChanged();
        }
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(c.sns_lucky_detail_ui_status_bar_color));
        }
        setMMSubTitle(null);
    }

    protected final void initView() {
        getResources().getDrawable(e.lucky_money_actionbar_bg);
        setMMTitle(i.sns_lucky_detail_ui_title);
        setBackBtn(new 2(this));
        this.kLN = (ListView) findViewById(f.lucky_money_detail_record_list);
        this.nmf = new b(this.mController.tml);
        this.kLN.setAdapter(this.nmf);
        this.kLN.setOnScrollListener(this.kLU);
        this.kLN.setOnItemClickListener(new 3(this));
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.snslucky_money_detail_ui;
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
