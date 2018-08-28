package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceManageDeviceUI extends MMActivity {
    private ListView CU;
    private a iDk;

    protected final int getLayoutId() {
        return R.i.exdevice_manage_device_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        setMMTitle(R.l.exdevice_manage_device_title);
        dd ddVar = new dd();
        ddVar.bKK.bKL = true;
        a.sFg.m(ddVar);
        initView();
        au.DF().a(537, this.iDk);
    }

    protected final void initView() {
        this.CU = (ListView) findViewById(R.h.listview);
        this.iDk = new a(this);
        View.inflate(this, R.i.exdevice_bind_device_ui_footer, null);
        this.CU.setAdapter(this.iDk);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.iDk.aQ(ad.aHe().aHJ());
        this.iDk.notifyDataSetChanged();
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(537, this.iDk);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0 || !this.iDk.iDm) {
            return super.onKeyDown(i, keyEvent);
        }
        updateOptionMenuText(0, getString(R.l.app_edit));
        a aVar = this.iDk;
        if (aVar.iDm) {
            aVar.iDm = false;
            ah.A(new 5(aVar));
        }
        return true;
    }
}
