package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.GridView;
import android.widget.ImageButton;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.LinkedList;
import java.util.List;

public class SnsSelectContactDialog extends MMBaseActivity {
    private List<String> dEw = new LinkedList();
    private GridView nZy = null;
    private a nZz = null;

    static /* synthetic */ void b(SnsSelectContactDialog snsSelectContactDialog) {
        Intent intent = new Intent();
        String str = bi.c(snsSelectContactDialog.dEw, ",") + ", " + q.GF();
        intent.putExtra("Contact_Compose", true);
        intent.putExtra("Add_get_from_sns", snsSelectContactDialog.bDH());
        intent.putExtra("List_Type", 1);
        intent.putExtra("Add_address_titile", snsSelectContactDialog.getString(j.address_title_select_contact));
        intent.putExtra("Contact_GroupFilter_Type", "@micromsg.qq.com");
        intent.putExtra("Block_list", str);
        intent.putExtra("sns_address_count", snsSelectContactDialog.dEw.size());
        a.ezn.a(intent, (Activity) snsSelectContactDialog, 1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.sns_chose_pic_ui);
        String stringExtra = getIntent().getStringExtra("Select_Contact");
        if (stringExtra == null || stringExtra.equals("")) {
            this.dEw.clear();
        } else {
            this.dEw = bi.F(stringExtra.split(","));
        }
        this.nZy = (GridView) findViewById(f.content_grid);
        this.nZz = new a(this, this, this.dEw);
        this.nZy.setAdapter(this.nZz);
        this.nZy.setOnItemClickListener(new 1(this));
        this.nZy.setSelection(this.nZz.getCount() - 1);
        ((ImageButton) findViewById(f.close_btn)).setOnClickListener(new 2(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", bi.c(this.dEw, ","));
            setResult(-1, intent);
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean NY(String str) {
        for (Object equals : s.dAV) {
            if (str.equals(equals)) {
                return false;
            }
        }
        if (s.fq(str) || s.hf(str)) {
            return false;
        }
        if (this.dEw == null || !this.dEw.contains(str)) {
            return true;
        }
        return false;
    }

    private String bDH() {
        az FW = ((i) com.tencent.mm.kernel.g.l(i.class)).FW();
        String str = s.dAN;
        List linkedList = new LinkedList();
        for (Object add : s.dAV) {
            linkedList.add(add);
        }
        linkedList.add("weixin");
        linkedList.add("officialaccounts");
        linkedList.add("helper_entry");
        linkedList.add("filehelper");
        Cursor b = FW.b(str, linkedList, "*");
        if (b.getCount() == 0) {
            b.close();
            return "";
        }
        List linkedList2 = new LinkedList();
        b.moveToFirst();
        do {
            ai aiVar = new ai();
            aiVar.d(b);
            if (NY(aiVar.field_username)) {
                linkedList2.add(aiVar.field_username);
                if (linkedList2.size() >= 10) {
                    break;
                }
            }
        } while (b.moveToNext());
        b.close();
        return bi.c(linkedList2, ";");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        List<String> F = bi.F(intent.getStringExtra("Select_Contact").split(","));
                        if (F != null) {
                            if (this.dEw == null) {
                                this.dEw = new LinkedList();
                            }
                            for (String str : F) {
                                if (!this.dEw.contains(str)) {
                                    this.dEw.add(str);
                                }
                            }
                            x.d("MicroMsg.SnsSelectContactDialog", "withList count " + this.dEw.size());
                            if (this.nZz != null) {
                                x.d("MicroMsg.SnsSelectContactDialog", "refresh alertAdapter");
                                this.nZz.refresh();
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("Select_Contact", bi.c(this.dEw, ","));
                            setResult(-1, intent2);
                            finish();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
