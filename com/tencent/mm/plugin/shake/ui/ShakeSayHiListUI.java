package com.tencent.mm.plugin.shake.ui;

import android.content.ContentValues;
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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.k;

public class ShakeSayHiListUI extends MMActivity {
    private ListView eIM;
    private long gVV;
    private d hlb = new 2(this);
    private int lCw = 0;
    private int lCx = 0;
    private int limit = 0;
    private bp mZg = null;
    private int nbo = 0;
    private b nbp;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nbo = getIntent().getIntExtra("IntentSayHiType", 1);
        if (this.nbo == 1) {
            this.mZg = com.tencent.mm.az.d.SH();
            setMMTitle(R.l.say_hi_list_shake_title);
        } else {
            setMMTitle(R.l.say_hi_list_lbs_title);
        }
        this.lCx = this.mZg.axd();
        this.limit = this.lCx == 0 ? 8 : this.lCx;
        this.lCw = this.mZg.getCount();
        bp bpVar = this.mZg;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(4));
        if (bpVar.diF.update(bpVar.getTableName(), contentValues, "status!=? ", new String[]{"4"}) != 0) {
            bpVar.doNotify();
        }
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.lCw != this.mZg.getCount()) {
            this.lCw = this.mZg.getCount();
            if (this.lCw == 0) {
                TextView textView = (TextView) findViewById(R.h.empty_msg_tip_tv);
                textView.setText(R.l.say_hi_non);
                textView.setVisibility(0);
                enableOptionMenu(false);
            }
            this.nbp.WT();
        }
        this.nbp.notifyDataSetChanged();
    }

    public void onDestroy() {
        this.nbp.aYc();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        if (this.nbp.hkQ != null) {
            this.nbp.hkQ.aYl();
        }
    }

    protected final int getLayoutId() {
        return R.i.lbs_say_hi_list;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    protected final void initView() {
        View inflate = getLayoutInflater().inflate(R.i.say_hi_list_footer, null);
        this.eIM = (ListView) findViewById(R.h.say_hi_lv);
        inflate.setOnClickListener(new 1(this, inflate));
        addTextOptionMenu(0, getString(R.l.app_clear), new 3(this));
        if (this.lCw == 0) {
            TextView textView = (TextView) findViewById(R.h.empty_msg_tip_tv);
            textView.setText(R.l.say_hi_non);
            textView.setVisibility(0);
            enableOptionMenu(false);
        }
        if (this.lCw > 0 && this.limit < this.lCw) {
            this.eIM.addFooterView(inflate);
        }
        this.nbp = new b(this, this.mZg, this.limit);
        this.nbp.setGetViewPositionCallback(new 4(this));
        this.nbp.setPerformItemClickListener(new 5(this));
        this.nbp.a(new 6(this));
        this.eIM.setAdapter(this.nbp);
        this.eIM.setOnItemClickListener(new 7(this));
        this.eIM.setOnItemLongClickListener(new 8(this, new k(this)));
        setBackBtn(new 9(this));
        AnonymousClass10 anonymousClass10 = new OnClickListener() {
            public final void onClick(View view) {
                c.a(ShakeSayHiListUI.this.eIM);
            }
        };
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.gVV = ((bo) this.nbp.getItem(adapterContextMenuInfo.position)).field_svrid;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.app_delete);
    }
}
