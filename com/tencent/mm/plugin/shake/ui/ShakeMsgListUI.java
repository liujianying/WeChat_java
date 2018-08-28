package com.tencent.mm.plugin.shake.ui;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.k;

public class ShakeMsgListUI extends MMActivity {
    private int bJu;
    private long gVV;
    private TextView hWV;
    private d hlb = new 6(this);
    private int lCw = 0;
    private int lCx = 0;
    private int limit = 0;
    private int mType;
    private g mZM = null;
    private d mZN;
    private ListView mZO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("shake_msg_type", 0);
        this.mZM = m.buD();
        this.lCx = this.mZM.axd();
        this.limit = this.lCx == 0 ? 8 : this.lCx;
        this.lCw = this.mZM.getCount();
        this.bJu = getIntent().getIntExtra("shake_msg_from", 1);
        if (this.bJu == 1) {
            h.mEJ.h(11313, new Object[]{Integer.valueOf(this.lCx), e.bvA()});
        } else {
            h.mEJ.h(11315, new Object[]{Integer.valueOf(this.lCx), e.bvA()});
        }
        g gVar = this.mZM;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(1));
        gVar.diF.update(gVar.getTableName(), contentValues, "status!=? ", new String[]{"1"});
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.lCw != this.mZM.getCount()) {
            this.lCw = this.mZM.getCount();
            if (this.lCw == 0) {
                bvk();
            }
            this.mZN.WT();
        }
        this.mZN.notifyDataSetChanged();
    }

    public void onDestroy() {
        this.mZN.aYc();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.shake_msg_list;
    }

    protected final void initView() {
        setMMTitle(getIntent().getStringExtra("shake_msg_list_title"));
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(R.l.app_clear), new 2(this));
        this.hWV = (TextView) findViewById(R.h.empty_msg_tip_tv);
        if (this.lCw == 0) {
            bvk();
        }
        this.mZO = (ListView) findViewById(R.h.shake_msg_listview);
        View inflate = getLayoutInflater().inflate(R.i.say_hi_list_footer, null);
        inflate.setOnClickListener(new 3(this, inflate));
        if (this.lCw > 0 && this.limit < this.lCw) {
            this.mZO.addFooterView(inflate);
        }
        this.mZN = new d(this);
        this.mZN.mZJ = this.limit;
        this.mZO.setAdapter(this.mZN);
        this.mZO.setOnItemClickListener(new 4(this));
        this.mZO.setOnItemLongClickListener(new 5(this, new k(this)));
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.gVV = ((f) this.mZN.getItem(adapterContextMenuInfo.position)).field_svrid;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.app_delete);
    }

    private void bvk() {
        this.hWV.setText(R.l.shake_msg_list_empty_tips);
        this.hWV.setVisibility(0);
        enableOptionMenu(false);
    }
}
