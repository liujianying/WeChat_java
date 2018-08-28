package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.be.a;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.k;

public class NearbySayHiListUI extends MMActivity implements e {
    private int daw = 0;
    private ListView eIM;
    private View eLM;
    private d hlb = new 3(this);
    private c lBD;
    private bb lCu = null;
    private a lCv;
    private int lCw = 0;
    private int lCx = 0;
    private boolean lCy;
    private long lCz;
    private int limit = 0;
    private p tipDialog = null;

    static /* synthetic */ void j(NearbySayHiListUI nearbySayHiListUI) {
        if (nearbySayHiListUI.lCw == 0) {
            TextView textView = (TextView) nearbySayHiListUI.findViewById(R.h.empty_msg_tip_tv);
            textView.setText(R.l.say_hi_non);
            textView.setVisibility(0);
            nearbySayHiListUI.enableOptionMenu(false);
        }
    }

    public void onCreate(Bundle bundle) {
        int i;
        NearbySayHiListUI nearbySayHiListUI;
        super.onCreate(bundle);
        this.daw = bi.WU(g.AT().getValue("ThresholdToCleanLocation"));
        this.lCy = getIntent().getBooleanExtra("show_clear_header", false);
        this.lCu = com.tencent.mm.az.d.SG();
        setMMTitle(R.l.say_hi_list_lbs_title);
        this.lCx = this.lCu.axd();
        this.lCw = this.lCu.getCount();
        if (a.cbf()) {
            i = this.lCw;
            nearbySayHiListUI = this;
        } else if (this.lCx == 0) {
            i = 8;
            nearbySayHiListUI = this;
        } else {
            i = this.lCx;
            nearbySayHiListUI = this;
        }
        nearbySayHiListUI.limit = i;
        this.lCu.cma();
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.lCw != this.lCu.getCount()) {
            this.lCw = this.lCu.getCount();
            if (this.lCw == 0) {
                TextView textView = (TextView) findViewById(R.h.empty_msg_tip_tv);
                textView.setText(R.l.say_hi_non);
                textView.setVisibility(0);
                enableOptionMenu(false);
            }
            this.lCv.WT();
        }
        this.lCv.notifyDataSetChanged();
        au.DF().a(148, this);
    }

    public void onDestroy() {
        this.lCv.aYc();
        super.onDestroy();
    }

    public void onPause() {
        au.DF().b(148, this);
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.lbs_say_hi_list;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    protected final void initView() {
        this.eIM = (ListView) findViewById(R.h.say_hi_lv);
        if (!a.cbf()) {
            View inflate = getLayoutInflater().inflate(R.i.say_hi_list_footer, null);
            inflate.setOnClickListener(new 1(this, inflate));
            if (this.lCw > 0 && this.limit < this.lCw) {
                this.eIM.addFooterView(inflate);
            }
        }
        addTextOptionMenu(0, getString(R.l.app_clear), new 5(this));
        if (this.lCw == 0) {
            TextView textView = (TextView) findViewById(R.h.empty_msg_tip_tv);
            textView.setText(R.l.say_hi_non);
            textView.setVisibility(0);
            enableOptionMenu(false);
        }
        if (this.lCy && this.daw != 0 && this.lCx >= this.daw && bi.fU(this)) {
            this.eLM = new CleanLocationHeaderView(this);
            this.eLM.setOnClickListener(new 6(this));
            this.eIM.addHeaderView(this.eLM);
        }
        this.lCv = new a(this, this, this.lCu, this.limit);
        this.lCv.setGetViewPositionCallback(new 7(this));
        this.lCv.setPerformItemClickListener(new 8(this));
        this.lCv.a(new 9(this));
        this.eIM.setAdapter(this.lCv);
        this.eIM.setOnItemLongClickListener(new 10(this, new k(this)));
        this.eIM.setOnItemClickListener(new 11(this));
        setBackBtn(new 12(this));
        AnonymousClass2 anonymousClass2 = new OnClickListener() {
            public final void onClick(View view) {
                BackwardSupportUtil.c.a(NearbySayHiListUI.this.eIM);
            }
        };
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        ba baVar = (ba) this.lCv.getItem(adapterContextMenuInfo.position);
        if (baVar == null) {
            x.e("MicroMsg.SayHiListUI", "onItemLongClick, item is null, pos = " + adapterContextMenuInfo.position);
            return;
        }
        contextMenu.add(0, 0, 0, R.l.app_delete);
        this.lCz = baVar.field_svrid;
    }

    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.SayHiListUI", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (i != 0 || i2 != 0) {
            x.w("MicroMsg.SayHiListUI", "[cpan] clear location failed.");
        } else if (((c) lVar).Oh() == 2) {
            h.a(this.mController.tml, getString(R.l.nearby_friend_clear_location_ok), "", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    NearbySayHiListUI.this.setResult(-1);
                    NearbySayHiListUI.this.finish();
                }
            });
            this.lBD = null;
        }
    }
}
