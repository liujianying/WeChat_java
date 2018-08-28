package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.clean.b.b;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CleanChattingDetailUI extends MMActivity implements h {
    private ProgressDialog eHw;
    private Button eOQ;
    private View gVb;
    CheckBox gVd;
    private long hQF;
    private GridHeadersGridView hSf;
    private b hSg;
    MMAutoAdjustTextView hSh;
    private b hSi;
    private int pos;
    private String username;

    static /* synthetic */ void b(CleanChattingDetailUI cleanChattingDetailUI) {
        Object arrayList = new ArrayList();
        arrayList.addAll(cleanChattingDetailUI.hSg.gUV);
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        List arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            i on = cleanChattingDetailUI.hSg.on(intValue);
            if (on != null) {
                arrayList2.add(on);
                cleanChattingDetailUI.hSg.gvR.remove(intValue);
            }
        }
        cleanChattingDetailUI.hSg.aBw();
        cleanChattingDetailUI.hSg.notifyDataSetChanged();
        cleanChattingDetailUI.hSi = new b(null, arrayList2, cleanChattingDetailUI);
        e.post(cleanChattingDetailUI.hSi, "delete-clean");
        cleanChattingDetailUI.eHw.show();
        cleanChattingDetailUI.eHw.setMessage(cleanChattingDetailUI.getString(R.l.clean_progress_tip, new Object[]{"0%"}));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.username = getIntent().getStringExtra("key_username");
        this.pos = getIntent().getIntExtra("key_pos", 0);
        if (bi.oW(this.username)) {
            x.w("MicroMsg.CleanChattingDetailUI", "username is null");
            finish();
            return;
        }
        this.gVb = findViewById(R.h.all_select_click_area);
        this.gVd = (CheckBox) findViewById(R.h.all_select_cb);
        this.hSh = (MMAutoAdjustTextView) findViewById(R.h.delete_info_tv);
        this.eOQ = (Button) findViewById(R.h.del_btn);
        op(0);
        if (s.fq(this.username)) {
            setMMTitle(r.getDisplayName(this.username, this.username));
        } else {
            setMMTitle(r.gT(this.username));
        }
        this.hSf = (GridHeadersGridView) findViewById(R.h.clean_chatting_detail_gv);
        this.hSf.setNumColumns(3);
        this.hSg = new b(this, this.username);
        this.hSf.setOnHeaderClickListener(this.hSg.hRU);
        this.hSf.setOnItemClickListener(this.hSg.hpE);
        this.hSf.setOnScrollListener(this.hSg.hRW);
        this.hSf.setAdapter(this.hSg);
        setBackBtn(new 1(this));
        this.gVb.setOnClickListener(new 2(this));
        this.eOQ.setOnClickListener(new 3(this));
        getString(R.l.app_tip);
        this.eHw = com.tencent.mm.ui.base.h.a(this, getString(R.l.clean_del_data), false, new 4(this));
        this.eHw.dismiss();
        if (this.hSg != null) {
            e.post(new b.b(this.hSg, (byte) 0), "load_clean_detail");
        }
        com.tencent.mm.plugin.report.service.h.mEJ.a(714, 30, 1, false);
    }

    protected final int getLayoutId() {
        return R.i.clean_chatting_detail_ui;
    }

    public final void op(int i) {
        this.eOQ.setEnabled(i > 0);
    }

    protected void onDestroy() {
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
        }
        if (this.hSg != null) {
            this.hSg.isStop = true;
        }
        super.onDestroy();
    }

    public final void cq(int i, int i2) {
        ah.A(new 5(this, i, i2));
    }

    public final void ck(long j) {
        x.i("MicroMsg.CleanChattingDetailUI", "%s onDeleteEnd [%d] ", new Object[]{hashCode(), Long.valueOf(j)});
        j.aBt().hQD -= j;
        j.aBt().hQC -= j;
        this.hQF += j;
        ah.A(new 6(this, j));
    }
}
