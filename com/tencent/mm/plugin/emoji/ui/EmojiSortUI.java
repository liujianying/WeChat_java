package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView$l;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import java.util.ArrayList;
import java.util.Iterator;

public class EmojiSortUI extends EmojiBaseActivity implements e, a {
    ProgressDialog eEX;
    private com.tencent.mm.plugin.emoji.a.e iml;
    private DragSortListView imm;
    private s imn;
    private h imo = new 4(this);
    private DragSortListView$l imp = new 5(this);
    private ArrayList<EmojiGroupInfo> mData = new ArrayList();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        this.mData = i.aEA().igy.cnt();
        this.imm = (DragSortListView) findViewById(16908298);
        this.imm.setDropListener(this.imo);
        this.imm.setRemoveListener(this.imp);
        this.iml = new com.tencent.mm.plugin.emoji.a.e(this.mController.tml, this.mData);
        this.imm.setAdapter(this.iml);
        i.aEA().igy.c(this);
        au.DF().a(717, this);
    }

    protected void onDestroy() {
        i.aEA().igy.d(this);
        au.DF().b(717, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.emoji_sort;
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        setMMTitle(getString(R.l.settings_emoji_manager));
        addTextOptionMenu(0, getString(R.l.app_finish), new 2(this));
        ((TextView) findViewById(16908310)).setText(R.l.emoji_store_manage_title);
    }

    public final void a(String str, l lVar) {
        if (str != null && str.equals("event_update_group") && this.iml != null) {
            com.tencent.mm.plugin.emoji.a.e eVar = this.iml;
            ArrayList cnt = i.aEA().igy.cnt();
            eVar.clear();
            Iterator it = cnt.iterator();
            while (it.hasNext()) {
                eVar.insert((EmojiGroupInfo) it.next(), eVar.getCount());
            }
            eVar.notifyDataSetChanged();
        }
    }

    public final void k(Message message) {
    }

    public final void l(Message message) {
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.d("MicroMsg.emoji.EmojiSortUI", "ErrType:" + i + "   errCode:" + i2);
        if (this.eEX != null) {
            this.eEX.dismiss();
        }
        if (i == 0 && i == 0) {
            this.iml.aDC();
            finish();
            return;
        }
        com.tencent.mm.ui.base.h.a(this, getString(R.l.emoji_sort_failed), "", new 6(this));
    }
}
