package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ac.b;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import java.util.List;

public class EnterpriseBizContactListUI extends MMActivity {
    private long cYb;
    private boolean djO = false;
    private long eiC = 0;
    public String hph;
    private l hpi;
    private EnterpriseBizContactListView hpj;
    private ag hpk;

    protected final int getLayoutId() {
        return e.enterprise_biz_list_sort;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hph = getIntent().getStringExtra("enterprise_biz_name");
        this.cYb = System.currentTimeMillis() / 1000;
        if (this.hpk == null) {
            this.hpk = new ag() {
                public final void handleMessage(Message message) {
                    if (message != null && message.what == 1 && EnterpriseBizContactListUI.this != null && !EnterpriseBizContactListUI.this.isFinishing()) {
                        z.Nk().km(EnterpriseBizContactListUI.this.hph);
                        z.MY();
                        List kC = com.tencent.mm.ac.e.kC(EnterpriseBizContactListUI.this.hph);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < kC.size()) {
                                String str = (String) kC.get(i2);
                                if (s.he(str) && (f.kN(str) || f.eZ(str))) {
                                    z.Nk().km(str);
                                }
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }
            };
        } else {
            this.hpk.removeMessages(1);
        }
        this.hpk.sendEmptyMessageDelayed(1, 500);
    }

    protected void onResume() {
        super.onResume();
        if (s.he(this.hph)) {
            initView();
            if (!this.djO) {
                int intExtra = getIntent().getIntExtra("enterprise_from_scene", 5);
                int i = -1;
                if (this.hpj != null) {
                    i = this.hpj.getContactCount();
                }
                b kn = z.Nh().kn(this.hph);
                int i2 = kn != null ? kn.field_qyUin : 0;
                long j = kn != null ? kn.field_wwCorpId : 0;
                long j2 = kn != null ? kn.field_wwUserVid : 0;
                h.mEJ.h(12892, new Object[]{this.hph, Integer.valueOf(intExtra), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)});
                x.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{this.hph, Integer.valueOf(intExtra), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)});
                this.djO = true;
                return;
            }
            return;
        }
        x.e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", new Object[]{this.hph});
        finish();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        if (this.hpj != null) {
            EnterpriseBizContactListView.release();
        }
        if (this.cYb > 0 && this.eiC > 0) {
            long j = this.eiC - this.cYb;
            b kn = z.Nh().kn(this.hph);
            int i = kn != null ? kn.field_qyUin : 0;
            int i2 = kn != null ? kn.field_userUin : 0;
            h.mEJ.h(13465, new Object[]{"", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(2), Long.valueOf(j)});
            x.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(2), Long.valueOf(j)});
        }
        super.onDestroy();
    }

    public void finish() {
        this.eiC = System.currentTimeMillis() / 1000;
        super.finish();
    }

    protected final void initView() {
        setMMTitle(((i) g.l(i.class)).FR().Yg(this.hph).BK());
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                EnterpriseBizContactListUI.this.YC();
                EnterpriseBizContactListUI.this.finish();
                return true;
            }
        });
        if (!bi.oW(this.hph)) {
            d kH = f.kH(this.hph);
            if (kH != null && kH.LY()) {
                addIconOptionMenu(1, com.tencent.mm.plugin.brandservice.b.h.actionbar_title_new_group_chat, com.tencent.mm.plugin.brandservice.b.g.actionbar_icon_dark_add, new 2(this));
            }
        }
        this.hpj = (EnterpriseBizContactListView) findViewById(com.tencent.mm.plugin.brandservice.b.d.enterprise_new_biz_list_view);
        this.hpj.setFatherBizName(this.hph);
        this.hpj.setExcludeBizChat(false);
        this.hpj.refresh();
        this.hpj.auX();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.g.bcT().l(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.g.bcT().dF(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.widget.snackbar.b.h(this, this.mController.tml.getString(com.tencent.mm.plugin.brandservice.b.h.has_send));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
