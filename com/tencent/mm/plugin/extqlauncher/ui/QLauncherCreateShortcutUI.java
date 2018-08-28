package com.tencent.mm.plugin.extqlauncher.ui;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.extqlauncher.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.contact.s;
import java.util.List;

public class QLauncherCreateShortcutUI extends MMBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onCreate");
        requestWindowFeature(1);
        setContentView(R.i.create_shortcut);
        Intent intent = new Intent();
        int s = s.s(new int[]{s.ukE, 64, 16384});
        s.fc(s, 1);
        intent.putExtra("list_attr", s);
        intent.putExtra("list_type", 12);
        intent.putExtra("stay_in_wechat", false);
        intent.putExtra("titile", getString(R.l.address_title_select_contact));
        intent.putExtra("block_contact", q.GF());
        d.b(this, ".ui.contact.SelectContactUI", intent, 1);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onActivityResult resultCode = %s", new Object[]{Integer.valueOf(i2)});
        if (i2 != -1) {
            finish();
            return;
        }
        switch (i) {
            case 1:
                if (intent != null) {
                    if (au.HX()) {
                        List list;
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        if (bi.oW(stringExtra)) {
                            list = null;
                        } else {
                            list = bi.F(stringExtra.split(","));
                        }
                        if (list != null && list.size() > 0) {
                            x.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames count " + list.size());
                            String GF = q.GF();
                            try {
                                ContentValues[] contentValuesArr = new ContentValues[list.size()];
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3;
                                    if (i4 >= list.size()) {
                                        getContentResolver().bulkInsert(a.iLP, contentValuesArr);
                                        Toast.makeText(this, R.l.extqlauncher_add_shortcut_success, 0).show();
                                        b.aJl().aJn();
                                        break;
                                    }
                                    au.HU();
                                    ab Yg = c.FR().Yg((String) list.get(i4));
                                    if (Yg == null || ((int) Yg.dhP) <= 0) {
                                        x.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "no such user");
                                        finish();
                                    } else {
                                        String wM = com.tencent.mm.plugin.base.model.b.wM((String) list.get(i4));
                                        if (bi.oW(wM)) {
                                            x.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "null encryptShortcutUser");
                                            finish();
                                            return;
                                        }
                                        ContentValues contentValues = new ContentValues();
                                        contentValues.put("source_key", com.tencent.mm.plugin.base.model.b.hdt);
                                        contentValues.put("owner_id", com.tencent.mm.plugin.base.model.b.wM(GF));
                                        contentValues.put("unique_id", wM);
                                        contentValues.put("container", Integer.valueOf(1));
                                        contentValues.put("item_type", Integer.valueOf(com.tencent.mm.plugin.base.model.b.z(Yg)));
                                        contentValues.put("name", r.a(Yg, (String) list.get(i4)));
                                        contentValues.put("icon_path", com.tencent.mm.aa.q.Kp().c((String) list.get(i4), false, false));
                                        Intent intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
                                        intent2.putExtra("LauncherUI.Shortcut.Username", wM);
                                        intent2.putExtra("LauncherUI.From.Biz.Shortcut", true);
                                        intent2.addFlags(67108864);
                                        contentValues.put("intent", intent2.toUri(0));
                                        contentValuesArr[i4] = contentValues;
                                        i3 = i4 + 1;
                                    }
                                }
                                x.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "no such user");
                                finish();
                                return;
                            } catch (Throwable e) {
                                x.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "bulkInsert shortcut failed, %s", new Object[]{e.getMessage()});
                                x.printErrStackTrace("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", e, "", new Object[0]);
                                Toast.makeText(this, R.l.extqlauncher_add_shortcut_failed, 0).show();
                                break;
                            }
                        }
                        x.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames empty");
                        break;
                    }
                    x.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "account not ready");
                    Toast.makeText(this, R.l.extqlauncher_add_shortcut_failed, 0).show();
                    finish();
                    return;
                }
                break;
        }
        finish();
    }
}
