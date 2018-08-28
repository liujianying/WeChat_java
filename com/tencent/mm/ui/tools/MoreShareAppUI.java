package com.tencent.mm.ui.tools;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import java.util.List;

public class MoreShareAppUI extends MMActivity {
    private DragSortListView imm;
    private List<f> tqq;
    private a uAN;

    protected final int getLayoutId() {
        return R.i.more_share_app;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setBackBtn(new 2(this));
        addTextOptionMenu(0, getString(R.l.emoji_sequence), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        this.uAN = new a(this, this.tqq);
        this.imm.setAdapter(this.uAN);
    }

    protected final void initView() {
        setMMTitle(R.l.bottom_sheet_more_share);
        this.imm = (DragSortListView) findViewById(R.h.listview);
        this.imm.setDropListener(new h() {
            public final void cu(int i, int i2) {
                f fVar = (f) MoreShareAppUI.this.uAN.getItem(i);
                a.a(MoreShareAppUI.this.uAN).remove(i);
                MoreShareAppUI.this.uAN.notifyDataSetChanged();
                MoreShareAppUI.this.uAN.insert(fVar, i2);
            }
        });
    }
}
