package com.tencent.mm.plugin.shake.ui;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.k;

public class ShakeTvHistoryListUI extends MMActivity {
    private d hlb = new 5(this);
    private a nbs;
    private ListView nbt;
    private String username;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        this.nbs.aYc();
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.shake_tv_history_list_title);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShakeTvHistoryListUI.this.YC();
                ShakeTvHistoryListUI.this.finish();
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.l.app_clear), new 2(this));
        this.nbt = (ListView) findViewById(R.h.shake_tv_history_listview);
        this.nbs = new a(this, this);
        this.nbt.setAdapter(this.nbs);
        this.nbt.setOnItemClickListener(new 3(this));
        this.nbt.setOnItemLongClickListener(new 4(this, new k(this)));
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.username = ((n) this.nbs.getItem(adapterContextMenuInfo.position)).field_username;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.app_delete);
    }

    protected final int getLayoutId() {
        return R.i.shake_tv_history_list;
    }
}
