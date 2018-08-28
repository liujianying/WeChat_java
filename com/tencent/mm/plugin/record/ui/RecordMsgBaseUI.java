package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class RecordMsgBaseUI extends BaseFavDetailReportUI {
    protected long bJC = -1;
    protected ListView eVT = null;
    protected h msU;

    protected abstract h bqB();

    protected abstract String bqC();

    protected abstract String bqD();

    protected abstract String bqE();

    protected abstract void bqF();

    protected abstract void c(int i, int i2, Intent intent);

    protected final int getLayoutId() {
        return R.i.record_msg_detail_ui;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        e.k(this);
        super.onCreate(bundle);
        bqA();
        e.l(this);
    }

    protected void bqA() {
        this.msU = bqB();
        this.bJC = getIntent().getLongExtra("message_id", -1);
        this.eVT = (ListView) findViewById(R.h.record_listview);
        bqI();
        String bqD = bqD();
        String bqE = bqE();
        if (bi.oW(bqD) || bi.oW(bqE)) {
            x.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
        } else {
            bqD = bqD.split(" ")[0];
            bqE = bqE.split(" ")[0];
            if (bqD.equals(bqE)) {
                this.msU.msO = false;
            } else {
                bqD = bqD + "~" + bqE;
                this.msU.msO = true;
            }
            setMMSubTitle(bqD);
        }
        View view = new View(this.mController.tml);
        view.setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(R.f.RecordListTopMargin)));
        this.eVT.addHeaderView(view, null, false);
        view = View.inflate(this.mController.tml, R.i.record_listview_footer, null);
        this.eVT.setAdapter(this.msU);
        this.msU.CU = this.eVT;
        this.msU.bqG();
        this.eVT.setOnScrollListener(new 1(this));
        setBackBtn(new 2(this));
        bqF();
        this.eVT.postDelayed(new 3(this, view), 100);
    }

    protected void onResume() {
        super.onResume();
        rz rzVar = new rz();
        if (this.eVT != null) {
            rzVar.ccO.type = 0;
            rzVar.ccO.ccP = this.eVT.getFirstVisiblePosition();
            rzVar.ccO.ccQ = this.eVT.getLastVisiblePosition();
            rzVar.ccO.ccR = this.eVT.getHeaderViewsCount();
            a.sFg.m(rzVar);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.msU != null) {
            h hVar = this.msU;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= hVar.msN.size()) {
                    break;
                }
                b bVar = (b) hVar.msN.valueAt(i2);
                if (bVar != null) {
                    bVar.pause();
                }
                i = i2 + 1;
            }
        }
        rz rzVar = new rz();
        rzVar.ccO.type = 1;
        a.sFg.m(rzVar);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.msU != null) {
            this.msU.destroy();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        c(i, i2, intent);
    }

    protected final void bqI() {
        CharSequence bqC = bqC();
        String string = this.mController.tml.getString(R.l.expose_example);
        if (bqC != null && bqC.endsWith(string) && bqC.lastIndexOf(string) > 0) {
            bqC = bqC.substring(0, bqC.lastIndexOf(string) - 1);
        }
        M(j.a(this.mController.tml, bqC, getResources().getDimensionPixelSize(R.f.BigTextSize)));
    }
}
