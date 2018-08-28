package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.o;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import java.util.Collections;
import java.util.List;

public class Sort3rdAppUI extends MMActivity {
    private DragSortListView imm;
    private long seU;
    private a tqp;
    private List<f> tqq;

    protected final int getLayoutId() {
        return R.i.sort_3rd_app_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.seU = getIntent().getLongExtra("KFlag", -1);
        initView();
        this.tqq = g.b(this, this.seU, true);
        List fL = ao.cbZ().fL(this.seU);
        if (fL != null && fL.size() > 0) {
            Collections.sort(this.tqq, new 3(this, fL));
        }
        this.tqp = new a(this, this.tqq, this.seU);
        this.imm.setAdapter(this.tqp);
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Sort3rdAppUI.this.finish();
                return true;
            }
        });
        setMMTitle(getString(R.l.actionbar_setting));
        this.imm = (DragSortListView) findViewById(R.h.listview);
        this.imm.setDropListener(new 2(this));
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        if (this.tqp != null) {
            List list = this.tqp.idD;
            o cbZ = ao.cbZ();
            long j = this.seU;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("delete from AppSort");
            stringBuilder.append(" where flag = ").append(j).append(" ");
            cbZ.diF.fV("AppSort", stringBuilder.toString());
            if (list != null && list.size() > 0) {
                au.HU();
                j = c.FO().dO(Thread.currentThread().getId());
                o cbZ2 = ao.cbZ();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < list.size()) {
                        n nVar = new n();
                        nVar.field_flag = this.seU;
                        nVar.field_appId = ((f) list.get(i2)).field_appId;
                        nVar.field_sortId = i2;
                        cbZ2.a(nVar);
                        i = i2 + 1;
                    } else {
                        au.HU();
                        c.FO().gp(j);
                        return;
                    }
                }
            }
        }
    }
}
