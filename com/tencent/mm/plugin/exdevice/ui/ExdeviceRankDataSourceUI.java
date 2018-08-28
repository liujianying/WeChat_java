package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.ScrollView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.q;
import com.tencent.mm.protocal.c.ahz;
import com.tencent.mm.protocal.c.bxh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceRankDataSourceUI extends MMActivity implements e {
    private ListView CU;
    private b iFd;

    static /* synthetic */ boolean a(String str, String str2, bxh bxh) {
        return (bxh == null || str == null || str2 == null || !str.equals(bxh.ruf) || !str2.equals(bxh.reT)) ? false : true;
    }

    protected final int getLayoutId() {
        return R.i.exdevice_rank_data_source_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        setMMTitle(R.l.contact_info_record_data);
        au.DF().a(1267, (e) this);
        initView();
        au.DF().a(new q(), 0);
    }

    protected final void initView() {
        this.CU = (ListView) findViewById(R.h.listview);
        View inflate = View.inflate(this, R.i.exdevice_rank_data_source_ui_header, null);
        View inflate2 = View.inflate(this, R.i.exdevice_rank_data_source_ui_footer, null);
        this.CU.addHeaderView(inflate, null, false);
        this.CU.addFooterView(inflate2, null, false);
        this.iFd = new b();
        this.CU.setAdapter(this.iFd);
        ((ScrollView) findViewById(R.h.scrollview)).scrollTo(0, 0);
        inflate2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ExdeviceRankDataSourceUI.this.startActivityForResult(new Intent(ExdeviceRankDataSourceUI.this.mController.tml, ExdeviceAddDataSourceUI.class), 1);
            }
        });
    }

    public void onBackPressed() {
        a();
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(1267, (e) this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, reqCode(%s), resultCode(%s)", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1 && i2 == -1 && intent != null) {
            long longExtra = intent.getLongExtra("device_mac", 0);
            intent.getIntExtra("step", 0);
            if (longExtra == 0) {
                x.e("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, mac is nil.");
                return;
            }
            String cY = b.cY(longExtra);
            if (cY == null) {
                x.e("MicroMsg.ExdeviceRankDataSourceUI", "invalid mac(%s).", cY);
            } else if (this.iFd.Aw(cY) != null) {
                x.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
            } else {
                com.tencent.mm.plugin.exdevice.h.b cX = ad.aHe().cX(longExtra);
                if (cX == null) {
                    x.w("MicroMsg.ExdeviceRankDataSourceUI", "hard device info is null.(mac : %s)", Long.valueOf(longExtra));
                } else if (this.iFd.cD(cX.field_deviceID, cX.field_deviceType) != null) {
                    x.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
                } else {
                    au.DF().a(1267, (e) this);
                    au.DF().a(new q(), 0);
                }
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar == null) {
            x.e("MicroMsg.ExdeviceRankDataSourceUI", "onSceneEnd, scene is null.");
        } else if (lVar instanceof q) {
            au.DF().b(1267, (e) this);
            if (i == 0 && i2 == 0) {
                int size;
                ahz ahz = (ahz) ((q) lVar).diG.dIE.dIL;
                String str2 = "MicroMsg.ExdeviceRankDataSourceUI";
                String str3 = "onSceneEnd, get sport device list succ.(size : %d)";
                Object[] objArr = new Object[1];
                if (ahz.rGg != null) {
                    size = ahz.rGg.size();
                } else {
                    size = 0;
                }
                objArr[0] = Integer.valueOf(size);
                x.d(str2, str3, objArr);
                runOnUiThread(new 3(this, ahz.rGg));
            }
        }
    }
}
