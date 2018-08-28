package com.tencent.mm.plugin.clean.ui.newui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CleanChattingDetailUI extends MMActivity implements h {
    private ProgressDialog eHw;
    private Button eOQ;
    private View gVb;
    CheckBox gVd;
    private GridHeadersGridView hSf;
    MMAutoAdjustTextView hSh;
    private b hTo;
    private b hTp;
    private e hTq;
    private int index;

    static /* synthetic */ void b(CleanChattingDetailUI cleanChattingDetailUI) {
        if (d.aBg() != null) {
            Object arrayList = new ArrayList();
            arrayList.addAll(cleanChattingDetailUI.hTo.gUV);
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                arrayList2.add(cleanChattingDetailUI.hTp.hQM.get(intValue));
                cleanChattingDetailUI.hTp.hQM.remove(intValue);
            }
            if (!cleanChattingDetailUI.hTp.aAY()) {
                d.aBi().remove(cleanChattingDetailUI.index);
                x.i("MicroMsg.CleanChattingDetailUI", "Delete username=%s", new Object[]{cleanChattingDetailUI.hTp.username});
            }
            cleanChattingDetailUI.hTo.aBw();
            cleanChattingDetailUI.hTo.notifyDataSetChanged();
            if (cleanChattingDetailUI.hTq != null) {
                cleanChattingDetailUI.hTq.aBr();
            }
            cleanChattingDetailUI.hTq = new e(d.aBg(), cleanChattingDetailUI, arrayList2);
            cleanChattingDetailUI.hTq.start();
            cleanChattingDetailUI.eHw.show();
            cleanChattingDetailUI.eHw.setMessage(cleanChattingDetailUI.getString(R.l.clean_progress_tip, new Object[]{"0%"}));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.aBp();
        this.index = getIntent().getIntExtra("key_position", -1);
        if (this.index < 0) {
            finish();
        } else if (d.aBi() == null) {
            finish();
        } else {
            this.gVb = findViewById(R.h.all_select_click_area);
            this.gVd = (CheckBox) findViewById(R.h.all_select_cb);
            this.hSh = (MMAutoAdjustTextView) findViewById(R.h.delete_info_tv);
            this.eOQ = (Button) findViewById(R.h.del_btn);
            op(0);
            this.hTp = (b) d.aBi().get(this.index);
            if (s.fq(this.hTp.username)) {
                setMMTitle(r.getDisplayName(this.hTp.username, this.hTp.username));
            } else {
                setMMTitle(r.gT(this.hTp.username));
            }
            this.hSf = (GridHeadersGridView) findViewById(R.h.clean_chatting_detail_gv);
            this.hSf.setNumColumns(3);
            this.hTo = new b(this, this.hTp.hQM);
            this.hSf.setOnHeaderClickListener(this.hTo.hRU);
            this.hSf.setOnItemClickListener(this.hTo.hpE);
            this.hSf.setOnScrollListener(this.hTo.hRW);
            this.hSf.setAdapter(this.hTo);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    CleanChattingDetailUI.this.finish();
                    return false;
                }
            });
            this.gVb.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    b a = CleanChattingDetailUI.this.hTo;
                    if (a.gUV.size() == a.gvR.size()) {
                        a.gUV.clear();
                    } else {
                        for (int i = 0; i < a.gvR.size(); i++) {
                            a.gUV.add(Integer.valueOf(i));
                        }
                    }
                    a.aBx();
                    CleanChattingDetailUI.this.hTo.notifyDataSetChanged();
                }
            });
            this.eOQ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    com.tencent.mm.ui.base.h.a(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(R.l.confirm_delete_file), "", CleanChattingDetailUI.this.getString(R.l.delete), CleanChattingDetailUI.this.getString(R.l.cancel), new 1(this), new 2(this));
                }
            });
            getString(R.l.app_tip);
            this.eHw = com.tencent.mm.ui.base.h.a(this, getString(R.l.clean_del_data), false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            this.eHw.dismiss();
        }
    }

    protected final int getLayoutId() {
        return R.i.clean_chatting_detail_ui;
    }

    public final void op(int i) {
        this.eOQ.setEnabled(i > 0);
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

    public final void cq(int i, int i2) {
        this.eHw.setMessage(getString(R.l.clean_progress_tip, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void ck(long j) {
        this.eHw.dismiss();
        d.ci(d.aBm() + j);
        d.cf(d.aBj() - j);
        com.tencent.mm.ui.base.h.a(this, getString(R.l.clean_del_data_ok_tip, new Object[]{bi.bF(j)}), "", new 5(this));
    }
}
