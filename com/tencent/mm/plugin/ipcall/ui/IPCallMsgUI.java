package com.tencent.mm.plugin.ipcall.ui;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;

public class IPCallMsgUI extends MMActivity {
    private View hFL;
    private boolean hFM = true;
    private ListView kww;
    private a kwx;
    private View kwy;
    private a kwz = new 7(this);

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.ipcall_msg_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i.aXy().c(this.kwz);
        initView();
    }

    public void onDestroy() {
        x.d("MicroMsg.IPCallMsgUI", "msgui onDestroy");
        i.aXy().d(this.kwz);
        this.kwx.aYc();
        h aXy = i.aXy();
        ContentValues contentValues = new ContentValues();
        contentValues.put("isRead", Short.valueOf((short) 1));
        aXy.diF.update(aXy.getTableName(), contentValues, "isRead!=? ", new String[]{"1"});
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.ipcall_msg_ui_title);
        this.kwy = findViewById(R.h.ipcall_msg_empty_view);
        this.kww = (ListView) findViewById(R.h.ipcall_msg_list);
        this.hFL = y.gq(this).inflate(R.i.mm_footerview, null);
        this.kww.addFooterView(this.hFL);
        this.kwx = new a(this, this, new g());
        this.kwx.setGetViewPositionCallback(new 1(this));
        this.kwx.setPerformItemClickListener(new 2(this));
        this.kwx.tlG = new 3(this);
        this.kww.setAdapter(this.kwx);
        this.kww.setOnItemClickListener(new 4(this));
        this.kww.setOnScrollListener(new 5(this));
        if (this.kwx.getCount() == 0) {
            this.kww.setVisibility(8);
            this.kwy.setVisibility(0);
            enableOptionMenu(false);
        } else {
            this.kww.setVisibility(0);
            this.kwy.setVisibility(8);
            enableOptionMenu(true);
        }
        if (this.kwx.ayQ()) {
            this.kww.removeFooterView(this.hFL);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                IPCallMsgUI.this.finish();
                return true;
            }
        });
        if (this.kwx.ayQ()) {
            this.kww.removeFooterView(this.hFL);
        }
    }
}
