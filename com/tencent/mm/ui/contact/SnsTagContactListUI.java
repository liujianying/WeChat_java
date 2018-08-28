package com.tencent.mm.ui.contact;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public class SnsTagContactListUI extends MMActivity {
    private ListView kBy;
    private a umf;
    private List<Long> umg = new ArrayList();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.sns_tag_see);
        findViewById(R.h.loading_tips_area).setVisibility(8);
        this.kBy = (ListView) findViewById(R.h.address_contactlist);
        long[] longArrayExtra = getIntent().getLongArrayExtra("sns_tag_list");
        if (longArrayExtra == null) {
            finish();
            return;
        }
        for (long valueOf : longArrayExtra) {
            this.umg.add(Long.valueOf(valueOf));
        }
        ((TextView) findViewById(R.h.empty_blacklist_tip_tv)).setVisibility(8);
        findViewById(R.h.address_scrollbar).setVisibility(8);
        this.kBy.setBackgroundColor(getResources().getColor(R.e.white));
        ((View) this.kBy.getParent()).setBackgroundColor(getResources().getColor(R.e.white));
        this.umf = new a(this, this.umg);
        this.kBy.setAdapter(this.umf);
        this.kBy.setVisibility(0);
        this.kBy.setOnItemClickListener(new 1(this));
        setBackBtn(new 2(this));
        showOptionMenu(false);
    }

    public void onResume() {
        super.onResume();
        if (this.umf != null) {
            this.umf.notifyDataSetChanged();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.address;
    }
}
