package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.clean.b.b;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CleanChattingUI extends MMActivity implements h {
    private List<c> dataList = new ArrayList();
    private ProgressDialog eHw;
    private Button eOQ;
    private View gVb;
    private CheckBox gVd;
    private TextView gVe;
    private a hSm;
    private ListView hSn;
    private TextView hSo;
    private TextView hSp;
    private boolean hSq = false;

    static /* synthetic */ void b(CleanChattingUI cleanChattingUI) {
        Object arrayList = new ArrayList();
        arrayList.addAll(cleanChattingUI.hSm.gUV);
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        List arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            c om = cleanChattingUI.hSm.om(intValue);
            if (om != null) {
                arrayList2.add(om.username);
                cleanChattingUI.dataList.remove(intValue);
            }
        }
        cleanChattingUI.hSm.aBw();
        cleanChattingUI.hSm.notifyDataSetChanged();
        e.post(new b(arrayList2, null, cleanChattingUI), "delete-clean");
        cleanChattingUI.eHw.setMessage(cleanChattingUI.getString(R.l.clean_progress_tip, new Object[]{"0%"}));
        cleanChattingUI.eHw.show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.CleanChattingUI", "Create!!");
        setMMTitle(R.l.clean_msg_ui_title);
        this.hSn = (ListView) findViewById(R.h.clean_chatting_lv);
        this.hSm = new a(this, this.dataList);
        this.hSn.setAdapter(this.hSm);
        this.hSn.setEmptyView(findViewById(R.h.empty_view));
        this.hSp = (TextView) findViewById(R.h.empty_tip);
        this.gVb = findViewById(R.h.all_select_click_area);
        this.hSo = (TextView) findViewById(R.h.delete_info_tv);
        this.gVd = (CheckBox) findViewById(R.h.all_select_cb);
        this.gVe = (TextView) findViewById(R.h.all_select);
        if (!w.chL()) {
            this.hSo.setTextSize(1, 14.0f);
            this.gVe.setTextSize(1, 14.0f);
        }
        this.eOQ = (Button) findViewById(R.h.del_btn);
        this.eOQ.setEnabled(false);
        setBackBtn(new 1(this));
        this.hSn.setOnItemClickListener(new 2(this));
        this.eOQ.setOnClickListener(new 3(this));
        this.gVb.setOnClickListener(new 4(this));
        getString(R.l.app_tip);
        this.eHw = com.tencent.mm.ui.base.h.a(this, getString(R.l.clean_del_data), false, new 5(this));
        this.eHw.dismiss();
        com.tencent.mm.plugin.report.service.h.mEJ.a(714, 20, 1, false);
    }

    public final void a(HashSet<Integer> hashSet) {
        if (this.hSm == null) {
            x.w("MicroMsg.CleanChattingUI", "on click check box but adapter is null");
            return;
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        long j = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            c om = this.hSm.om(intValue);
            if (om != null) {
                j = om.size + j;
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || j > 0) {
            this.hSo.setText(getString(R.l.delete_info, new Object[]{bi.bF(j)}));
            this.eOQ.setEnabled(true);
            if (hashSet.size() == this.hSm.getCount()) {
                this.gVd.setChecked(true);
                return;
            } else {
                this.gVd.setChecked(false);
                return;
            }
        }
        this.hSo.setText("");
        this.eOQ.setEnabled(false);
        this.gVd.setChecked(false);
    }

    protected void onDestroy() {
        if (this.eHw.isShowing()) {
            this.eHw.dismiss();
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (this.hSm != null && this.dataList.isEmpty()) {
            g.Em().H(new 6(this));
        }
    }

    protected final int getLayoutId() {
        return R.i.clean_chatting_ui;
    }

    public final void cq(final int i, final int i2) {
        ah.A(new Runnable() {
            public final void run() {
                CleanChattingUI.this.eHw.setMessage(CleanChattingUI.this.getString(R.l.clean_progress_tip, new Object[]{((i * 100) / i2) + "%"}));
            }
        });
    }

    public final void ck(long j) {
        x.i("MicroMsg.CleanChattingUI", "%s onDeleteEnd [%d] ", new Object[]{hashCode(), Long.valueOf(j)});
        j.aBt().hQD -= j;
        j.aBt().hQC -= j;
        ah.A(new 8(this, j));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("key_pos", -1);
            long longExtra = intent.getLongExtra("key_delete_size", 0);
            if (intExtra > 0 && intExtra < this.dataList.size()) {
                c cVar = (c) this.dataList.get(intExtra);
                if (cVar != null) {
                    if (cVar.size == longExtra) {
                        this.dataList.remove(intExtra);
                    } else {
                        cVar.size -= longExtra;
                    }
                }
            }
        }
        this.hSm.notifyDataSetChanged();
        super.onActivityResult(i, i2, intent);
    }
}
