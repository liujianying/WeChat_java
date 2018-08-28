package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ac.z;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r.a;
import com.tencent.mm.storage.r.b;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;

public class BizTimeLineNewMsgUI extends DrawStatusBarActivity implements i {
    private ListView eVT;
    private TextView emptyTipTv;
    private f hrX;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.emptyTipTv = (TextView) findViewById(d.empty_msg_tip_tv);
        this.emptyTipTv.setText(h.biz_time_line_empty_biz_new_msg_tip);
        setMMTitle(getString(h.biz_time_line_new_msg_title));
        this.hrX = new f(this, z.Nf().ckI());
        this.eVT = (ListView) findViewById(d.biz_time_line_new_msg_lv);
        this.eVT.setAdapter(this.hrX);
        this.eVT.setFooterDividersEnabled(false);
        this.eVT.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                o.Pj().br(i);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.eVT.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                q nz = BizTimeLineNewMsgUI.this.hrX.nz(i);
                if (nz == null) {
                    x.e("MicroMsg.BizTimeLineNewMsgUI", "onItemClick info is null");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Chat_User", nz.field_talker);
                intent.putExtra("finish_direct", true);
                com.tencent.mm.bg.d.e(BizTimeLineNewMsgUI.this.mController.tml, ".ui.chatting.ChattingUI", intent);
            }
        });
        setShowView(this.hrX.getCount());
        setBackBtn(new 1(this));
        lF(this.mController.cqm());
    }

    protected final int getLayoutId() {
        return e.biz_time_line_new_msg_activity;
    }

    private void setShowView(int i) {
        if (i <= 0) {
            this.emptyTipTv.setVisibility(0);
            this.eVT.setVisibility(8);
            return;
        }
        this.emptyTipTv.setVisibility(8);
        this.eVT.setVisibility(0);
    }

    public final void avj() {
        if (this.hrX != null) {
            this.hrX.notifyDataSetChanged();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        z.Nf().a(this.hrX.hnE);
        t Nf = z.Nf();
        Nf.dCZ.fV("BizTimeLineSingleMsgInfo", "update BizTimeLineSingleMsgInfo set status = 4 where status != 4");
        a aVar = new a();
        aVar.sNY = b.sOc;
        Nf.b(aVar);
    }

    protected void onResume() {
        super.onResume();
        setShowView(this.hrX.getCount());
    }

    protected void onPause() {
        super.onPause();
    }
}
