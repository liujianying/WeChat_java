package com.tencent.mm.plugin.clean.ui.newui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import java.util.Iterator;

public class CleanChattingUI extends MMActivity implements h {
    private ProgressDialog eHw;
    private Button eOQ;
    private View gVb;
    private CheckBox gVd;
    private TextView gVe;
    private ListView hSn;
    private TextView hSo;
    private e hTq;
    private a hTt;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.aBp();
        x.i("MicroMsg.CleanChattingUI", "Create!!");
        setMMTitle(R.l.clean_ui_title);
        this.hSn = (ListView) findViewById(R.h.clean_chatting_lv);
        this.hTt = new a(this);
        this.hSn.setAdapter(this.hTt);
        this.hSn.setEmptyView(findViewById(R.h.empty_view));
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
        this.hSn.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent(CleanChattingUI.this, CleanChattingDetailUI.class);
                intent.putExtra("key_position", i);
                CleanChattingUI.this.startActivityForResult(intent, 0);
            }
        });
        this.eOQ.setOnClickListener(new 3(this));
        this.gVb.setOnClickListener(new 4(this));
        getString(R.l.app_tip);
        this.eHw = com.tencent.mm.ui.base.h.a(this, getString(R.l.clean_del_data), false, new 5(this));
        this.eHw.dismiss();
    }

    public final void a(HashSet<Integer> hashSet) {
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue < d.aBi().size()) {
                i = (int) (((b) d.aBi().get(intValue)).gTK + ((long) i));
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || i > 0) {
            this.hSo.setText(getString(R.l.delete_info, new Object[]{bi.bF((long) i)}));
            this.eOQ.setEnabled(true);
            if (hashSet.size() == this.hTt.getCount()) {
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
        if (this.hTq != null) {
            this.hTq.aBr();
        }
        d.aBq();
        d.aBo();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.clean_chatting_ui;
    }

    public final void cq(int i, int i2) {
        this.eHw.setMessage(getString(R.l.clean_progress_tip, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void ck(long j) {
        this.eHw.dismiss();
        d.ci(d.aBm() + j);
        d.cf(d.aBj() - j);
        com.tencent.mm.ui.base.h.a(this, getString(R.l.clean_del_data_ok_tip, new Object[]{bi.bF(j)}), "", new 6(this));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.hTt.notifyDataSetChanged();
        super.onActivityResult(i, i2, intent);
    }
}
