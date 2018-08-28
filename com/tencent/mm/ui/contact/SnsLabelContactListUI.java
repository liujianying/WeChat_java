package com.tencent.mm.ui.contact;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class SnsLabelContactListUI extends MMActivity {
    private ListView kBy;
    private boy nhb;
    private a ulU;
    private ArrayList<String> ulV = new ArrayList();
    private int ulW;
    private String ulX;
    private b ulY;

    private static class c {
        TextView eMf;
        MaskLayout hPe;
        TextView kuR;
        TextView ume;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ulY = new b(this, (byte) 0);
        a.sFg.b(this.ulY);
        this.ulW = getIntent().getIntExtra("sns_label_sns_info", -1);
        if (this.ulW == -1) {
            finish();
            return;
        }
        hr hrVar = new hr();
        hrVar.bRa.bMQ = this.ulW;
        a.sFg.m(hrVar);
        this.nhb = hrVar.bRb.bRc;
        if (this.nhb == null) {
            return;
        }
        if ((this.nhb.rXx == 3 && this.nhb.smW != null && this.nhb.smW.size() > 0) || (this.nhb.rXx == 5 && this.nhb.rWm != null && this.nhb.rWm.size() > 0)) {
            cyE();
            initView();
        }
    }

    private void cyE() {
        Iterator it;
        if (this.nhb.rXx == 3) {
            this.ulX = getString(R.l.sns_label_can_not_see);
            it = this.nhb.smW.iterator();
            while (it.hasNext()) {
                this.ulV.add(((bhz) it.next()).siM);
            }
        } else if (this.nhb.rXx == 5) {
            this.ulX = getString(R.l.sns_label_can_see);
            it = this.nhb.rWm.iterator();
            while (it.hasNext()) {
                this.ulV.add(((bhz) it.next()).siM);
            }
        }
    }

    protected final void initView() {
        setMMTitle(this.ulX);
        findViewById(R.h.loading_tips_area).setVisibility(8);
        this.kBy = (ListView) findViewById(R.h.address_contactlist);
        ((TextView) findViewById(R.h.empty_blacklist_tip_tv)).setVisibility(8);
        findViewById(R.h.address_scrollbar).setVisibility(8);
        this.kBy.setBackgroundColor(getResources().getColor(R.e.white));
        ((View) this.kBy.getParent()).setBackgroundColor(getResources().getColor(R.e.white));
        setBackBtn(new 1(this));
        showOptionMenu(false);
        if (this.ulV != null && this.ulV.size() != 0) {
            this.ulU = new a(this, this.ulV);
            this.kBy.setAdapter(this.ulU);
            this.kBy.setVisibility(0);
            this.kBy.setOnItemClickListener(new 2(this));
        }
    }

    public void onResume() {
        super.onResume();
        if (this.ulU != null) {
            this.ulU.notifyDataSetChanged();
        }
    }

    protected void onDestroy() {
        a.sFg.c(this.ulY);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.address;
    }
}
