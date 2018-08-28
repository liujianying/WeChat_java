package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.readerapp.a;
import com.tencent.mm.plugin.readerapp.a.d;
import com.tencent.mm.plugin.readerapp.a.e;
import com.tencent.mm.protocal.c.auu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;

public class ReaderAppSubscribeUI extends MMActivity {
    private ListView mnE;
    private a mnF;

    protected final int getLayoutId() {
        return e.readerapp_subscribe_list;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.Ei().DT().set(868518890, "in");
        setMMTitle(a.g.contact_info_readerappnews_subscribe);
        initView();
    }

    protected final void initView() {
        this.mnF = new a(this, bi.f((Integer) g.Ei().DT().get(868518889, null)));
        this.mnE = (ListView) findViewById(d.readerapp_subscribe_lv);
        this.mnE.setAdapter(this.mnF);
        this.mnE.setOnItemClickListener(new 1(this));
        this.mnF.notifyDataSetChanged();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ReaderAppSubscribeUI.this.vd(ReaderAppSubscribeUI.this.mnF.mnI);
                return true;
            }
        });
        3 3 = new 3(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.mnF != null) {
            vd(this.mnF.mnI);
        }
        return true;
    }

    private void vd(int i) {
        g.Ei().DT().set(868518889, Integer.valueOf(i));
        auu auu = new auu();
        auu.rXL = i;
        ((i) g.l(i.class)).FQ().b(new h.a(43, auu));
        Intent intent = new Intent();
        intent.putExtra("Contact_User", "newsapp");
        intent.addFlags(67108864);
        com.tencent.mm.plugin.readerapp.b.a.ezn.d(intent, this);
        finish();
    }

    protected void onResume() {
        super.onResume();
        this.mnF.notifyDataSetChanged();
    }
}
