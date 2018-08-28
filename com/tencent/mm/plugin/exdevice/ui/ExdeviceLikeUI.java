package com.tencent.mm.plugin.exdevice.ui;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.exdevice.f.b.a.e;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.g.a;
import java.util.ArrayList;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceLikeUI extends MMActivity {
    private ArrayList<e> iCV;
    private boolean iCW;
    private ListView iCX;
    private a iCY;
    private final int iCZ = 30;
    private String mAppName;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAppName = getIntent().getStringExtra("app_username");
        String stringExtra = getIntent().getStringExtra("key_rank_info");
        String stringExtra2 = getIntent().getStringExtra("key_rank_semi");
        this.iCW = getIntent().getBooleanExtra("key_is_like_read_only", false);
        if (bi.oW(stringExtra)) {
            stringExtra2 = getIntent().getStringExtra("rank_id");
            Assert.assertTrue(!bi.oW(stringExtra2));
            this.iCV = ad.aHj().Ai(stringExtra2);
        } else {
            ArrayList arrayList;
            String str = this.mAppName;
            x.d("MicroMsg.ExdeviceMsgXmlParser", stringExtra);
            if (bi.oW(stringExtra)) {
                x.e("MicroMsg.ExdeviceMsgXmlParser", "like info is null or nil");
            } else {
                a J = a.J(stringExtra, stringExtra2);
                if (J != null) {
                    Map map = J.dwm;
                    ArrayList arrayList2 = new ArrayList();
                    if (!(map == null || map.isEmpty())) {
                        int i = 0;
                        while (true) {
                            stringExtra = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".username");
                            if (bi.oW(stringExtra)) {
                                break;
                            }
                            stringExtra2 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".rankid");
                            String str2 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".liketip");
                            String str3 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".timestamp");
                            e eVar = new e();
                            eVar.field_appusername = str;
                            eVar.field_rankID = stringExtra2;
                            eVar.field_username = stringExtra;
                            eVar.field_timestamp = bi.getInt(str3, 0);
                            eVar.field_liketips = str2;
                            arrayList2.add(eVar);
                            i++;
                        }
                        x.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", Integer.valueOf(i));
                        arrayList = arrayList2;
                        this.iCV = arrayList;
                    }
                }
            }
            arrayList = null;
            this.iCV = arrayList;
        }
        this.iCX = (ListView) findViewById(R.h.exdevice_list);
        this.iCX.setEmptyView(findViewById(R.h.empty));
        this.iCY = new a(this);
        this.iCX.setAdapter(this.iCY);
        if (!this.iCW) {
            this.iCX.setOnItemClickListener(new 3(this));
        }
        this.iCX.setOnItemClickListener(new 4(this));
        setMMTitle(R.l.exdevice_like_title);
        if (!this.iCW) {
            addTextOptionMenu(0, getString(R.l.exdevice_like_see_recent), new 1(this));
        }
        setBackBtn(new 2(this));
    }

    protected final int getLayoutId() {
        return R.i.exdevice_like_ui;
    }
}
