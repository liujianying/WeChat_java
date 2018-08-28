package com.tencent.mm.plugin.profile.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.s$d;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.List;

public final class BizBindWxaInfoUI extends DrawStatusBarActivity {
    private TextView lUj;
    private ListView lUk;
    private String lUl;
    private String lUm;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            return;
        }
        this.lUl = getIntent().getStringExtra("extra_username");
        this.lUm = getIntent().getStringExtra("extra_appid");
        setBackBtn(new 1(this));
        setMMTitle(j.contact_info_bind_weapp);
        lF(this.mController.cqm());
        List parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("extra_wxa_entry_info_list");
        View inflate = getLayoutInflater().inflate(h.biz_bind_wxa_info_header, null);
        this.lUj = (TextView) inflate.findViewById(g.titleTv);
        TextView textView = this.lUj;
        int i = j.biz_bind_weapp_provide_service;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(parcelableArrayListExtra != null ? parcelableArrayListExtra.size() : 0);
        textView.setText(getString(i, objArr));
        this.lUk = (ListView) findViewById(g.dataLv);
        this.lUk.addHeaderView(inflate);
        this.lUk.setAdapter(new a(getLayoutInflater(), parcelableArrayListExtra));
        this.lUk.setOnItemClickListener(new 2(this));
        this.mController.contentView.setBackgroundResource(s$d.settings_bg);
    }

    protected final int getLayoutId() {
        return h.biz_bind_wxa_info_ui;
    }
}
