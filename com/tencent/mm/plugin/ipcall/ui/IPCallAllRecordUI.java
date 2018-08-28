package com.tencent.mm.plugin.ipcall.ui;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class IPCallAllRecordUI extends MMActivity {
    private String cbH;
    private String cbJ;
    private ListView kus;
    private boolean kut = false;

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cbJ = getIntent().getStringExtra("IPCallAllRecordUI_phoneNumber");
        this.cbH = getIntent().getStringExtra("IPCallAllRecordUI_contactId");
        this.kut = getIntent().getBooleanExtra("IPCallAllRecordUI_isSinglePhoneNumber", false);
        setMMTitle(R.l.ip_call_record_list_title);
        setBackBtn(new 1(this));
        this.kus = (ListView) findViewById(R.h.all_record_list);
        this.kus.setAdapter(new a(this, this));
    }

    protected final int getLayoutId() {
        return R.i.ip_call_allrecord_ui;
    }
}
