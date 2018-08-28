package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.label.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;

public class ContactLabelMemberListUI extends MMActivity {
    private TextView gVf;
    private String kBA;
    private String kBB;
    private b kBj = new 2(this);
    private ListView kBy;
    private a kBz;
    private ag mHandler = new 1(this);

    static /* synthetic */ void a(ContactLabelMemberListUI contactLabelMemberListUI, int i) {
        if (contactLabelMemberListUI.kBz != null && i <= contactLabelMemberListUI.kBz.getCount()) {
            ab abVar = contactLabelMemberListUI.kBz.rN(i).guS;
            if (abVar != null && !bi.oW(abVar.field_username) && abVar.field_deleteFlag != 1) {
                if (s.hE(abVar.field_username)) {
                    x.e("MicroMsg.Label.ContactLabelMemberListUI", "error, 4.5 do not contain this contact %s", new Object[]{abVar.field_username});
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", abVar.field_username);
                intent.putExtra("Contact_Alias", abVar.wM());
                intent.putExtra("Contact_Nick", abVar.BK());
                intent.putExtra("Contact_QuanPin", abVar.wQ());
                intent.putExtra("Contact_PyInitial", abVar.wP());
                intent.putExtra("Contact_Sex", abVar.sex);
                intent.putExtra("Contact_Province", abVar.getProvince());
                intent.putExtra("Contact_City", abVar.getCity());
                intent.putExtra("Contact_Signature", abVar.signature);
                a.ezn.d(intent, contactLabelMemberListUI);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.contact_label_member_list_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kBA = getIntent().getStringExtra("label_id");
        this.kBB = getIntent().getStringExtra("label_name");
        setBackBtn(new 3(this));
        addTextOptionMenu(0, getString(R.l.label_manager), new 4(this));
        setMMTitle(this.kBB);
        this.kBy = (ListView) findViewById(R.h.contact_label_member_list);
        this.gVf = (TextView) findViewById(R.h.empty);
        if (bi.oW(this.kBA)) {
            x.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] inite view");
            finish();
        }
        this.kBz = new a(this.mController.tml);
        this.kBy.setAdapter(this.kBz);
        this.kBy.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ContactLabelMemberListUI.a(ContactLabelMemberListUI.this, i);
            }
        });
        this.kBy.setEmptyView(this.gVf);
    }

    protected void onResume() {
        au.HU();
        c.FR().a(this.kBj);
        super.onResume();
        aYT();
    }

    protected void onPause() {
        au.HU();
        c.FR().b(this.kBj);
        super.onPause();
    }

    protected void onDestroy() {
        if (this.kBz != null) {
            this.kBz.aYc();
            this.kBz.tlG = null;
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. requestcode:%d resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 10001:
                if (i2 == -1) {
                    finish();
                    return;
                } else {
                    aYT();
                    return;
                }
            default:
                x.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. unknow requestcode:%d", new Object[]{Integer.valueOf(i)});
                return;
        }
    }

    private void aYT() {
        if (this.kBz != null) {
            this.kBz.kBu = com.tencent.mm.plugin.label.a.a.aYK().FD(this.kBA);
            this.kBz.a(null, null);
        }
        this.kBB = com.tencent.mm.plugin.label.a.a.aYK().Fz(this.kBA);
        if (!bi.oW(this.kBB)) {
            setMMTitle(this.kBB);
        }
    }
}
