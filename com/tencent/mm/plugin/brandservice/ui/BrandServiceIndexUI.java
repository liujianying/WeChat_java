package com.tencent.mm.plugin.brandservice.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.e.i;

public class BrandServiceIndexUI extends MMActivity implements a {
    private int dCn = 251658241;
    private TextView hoY = null;
    private BrandServiceSortView hoZ;
    private boolean hpa = false;
    private boolean hpb = false;

    protected final int getLayoutId() {
        return e.brand_service_index;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dCn = getIntent().getIntExtra("intent_service_type", 251658241);
        this.hpb = s.fb(getIntent().getIntExtra("list_attr", 0), 16384);
        initView();
        z.MY().c(this);
    }

    protected void onResume() {
        if (this.hpa) {
            this.hpa = false;
            this.hoZ.refresh();
        }
        super.onResume();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        sendBroadcast(intent);
        enableOptionMenu(1, true);
    }

    protected void onPause() {
        g.Ek();
        g.Ei().DT().set(233474, Long.valueOf(System.currentTimeMillis()));
        g.Ek();
        g.Ei().DT().set(233473, Long.valueOf(System.currentTimeMillis()));
        g.Ek();
        g.Ei().DT().set(233476, Long.valueOf(System.currentTimeMillis()));
        super.onPause();
    }

    protected void onDestroy() {
        if (g.Eg().Dx()) {
            this.hoZ.release();
            z.MY().d(this);
        }
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(h.address_official_accounts_title);
        this.hoZ = (BrandServiceSortView) findViewById(d.sort_and_search_view);
        this.hoZ.setShowFooterView(true);
        this.hoZ.setReturnResult(this.hpb);
        this.hoY = (TextView) findViewById(d.out_of_date_tv);
        this.hoY.setOnClickListener(new 1(this));
        this.hoY.setVisibility(8);
        setBackBtn(new 2(this));
        addIconOptionMenu(0, h.top_item_desc_search, b.g.actionbar_icon_dark_search, new 3(this));
        addIconOptionMenu(1, h.app_add, b.g.actionbar_icon_dark_add, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (p.zO(0)) {
                    ((com.tencent.mm.plugin.websearch.api.i) g.l(com.tencent.mm.plugin.websearch.api.i.class)).a(ad.getContext(), new 1(this));
                } else {
                    x.e("MicroMsg.BrandService.BrandServiceIndexUI", "fts h5 template not avail");
                }
                BrandServiceIndexUI.this.enableOptionMenu(1, false);
                return true;
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1 && this.hpb) {
            setResult(-1, intent);
            finish();
        }
    }

    public final void a(String str, l lVar) {
        x.v("MicroMsg.BrandService.BrandServiceIndexUI", "On Storage Change, event : %s.", new Object[]{str});
        this.hpa = true;
    }
}
