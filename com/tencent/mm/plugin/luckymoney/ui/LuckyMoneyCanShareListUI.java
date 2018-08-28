package com.tencent.mm.plugin.luckymoney.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.luckymoney.b.i;
import com.tencent.mm.plugin.luckymoney.b.z;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyCanShareListUI extends LuckyMoneyBaseUI {
    private boolean ikj = false;
    private List<i> kLz = new LinkedList();
    private MMLoadMoreListView kUS;
    private d kUT;
    private boolean kUl = true;
    private String kUu = "";
    private int tH = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        bbr();
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        this.kUS = (MMLoadMoreListView) findViewById(f.lucky_money_my_record_list);
        setMMTitle(getString(a$i.lucky_money_has_can_share_list_title));
        this.kUT = new e(this.mController.tml);
        this.kUS.setAdapter(this.kUT);
        this.kUS.setOnItemClickListener(new 2(this));
        this.kUS.setOnLoadMoreListener(new 3(this));
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof z) || i != 0 || i2 != 0) {
            return false;
        }
        z zVar = (z) lVar;
        List list = zVar.kRl.kQe;
        this.kUu = zVar.kRb;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                this.kLz.add(list.get(i3));
            }
            this.tH += list.size();
            this.kUl = zVar.baZ();
            this.ikj = false;
            this.kUT.bw(this.kLz);
        }
        if (this.kUl) {
            this.kUS.crC();
        } else {
            this.kUS.crD();
        }
        return true;
    }

    protected final int getLayoutId() {
        return g.lucky_money_my_record_ui;
    }

    private void bbr() {
        this.ikj = true;
        if (this.tH == 0) {
            this.kUu = "";
        }
        l(new z(10, this.tH, 3, "", "v1.0", this.kUu));
    }
}
