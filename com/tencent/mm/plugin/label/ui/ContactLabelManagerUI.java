package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.smtt.sdk.TbsReaderView$ReaderCallback;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactLabelManagerUI extends ContactLabelBaseUI implements OnCreateContextMenuListener, OnItemClickListener, e, d {
    private ListView CU;
    private int OD;
    private int hpr = 0;
    private int hps = 0;
    private a hql;
    private View imD;
    private b kBa = b.kBp;
    private View kBb;
    private View kBc;
    private a kBd;
    private ArrayList<ad> kBe = new ArrayList();
    private HashMap<Integer, Integer> kBf = new HashMap();
    private boolean kBg = true;
    private OnClickListener kBh = new 6(this);
    private j.a kBi = new 7(this);
    private b kBj = new 8(this);
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            x.d("MicroMsg.Label.ContactLabelManagerUI", "handleMessage:%d", new Object[]{Integer.valueOf(message.what)});
            switch (message.what) {
                case TbsReaderView$ReaderCallback.HIDDEN_BAR /*5001*/:
                    ContactLabelManagerUI.this.ge(false);
                    return;
                case TbsReaderView$ReaderCallback.SHOW_BAR /*5002*/:
                    ContactLabelManagerUI.this.FE(ContactLabelManagerUI.this.getString(R.l.app_waiting));
                    return;
                case TbsReaderView$ReaderCallback.COPY_SELECT_TEXT /*5003*/:
                    ContactLabelManagerUI.this.aYM();
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void b(ContactLabelManagerUI contactLabelManagerUI) {
        if (contactLabelManagerUI.kBe == null || contactLabelManagerUI.kBe.isEmpty()) {
            h.mEJ.h(11347, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
        } else {
            h.mEJ.h(11347, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
        }
        x.i("MicroMsg.Label.ContactLabelManagerUI", "dz[dealAddLabel]");
        Intent intent = new Intent();
        intent.putExtra("list_attr", s.s(s.ukF, 1024));
        intent.putExtra("list_type", 1);
        intent.putExtra("titile", contactLabelManagerUI.getString(R.l.label_add_member));
        intent.putExtra("show_too_many_member", false);
        intent.putExtra("scene", 5);
        com.tencent.mm.bg.d.b(contactLabelManagerUI, ".ui.contact.SelectContactUI", intent, 7001);
    }

    protected final int getLayoutId() {
        return R.i.contact_label_manager_ui;
    }

    protected final void initView() {
        this.OD = com.tencent.mm.bp.a.ad(this.mController.tml, R.f.NormalTextSize);
        setMMTitle(getString(R.l.label_all_title));
        addTextOptionMenu(0, getString(R.l.label_new_short), new 9(this));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactLabelManagerUI.this.finish();
                return false;
            }
        });
        this.kBd = new a(this);
        this.imD = findViewById(R.h.label_main);
        this.kBb = findViewById(R.h.label_empty);
        this.kBc = findViewById(R.h.label_new_btn);
        this.kBc.setOnClickListener(this.kBh);
        this.CU = (ListView) findViewById(R.h.label_list);
        this.hql = new a(this);
        this.CU.setOnTouchListener(new 11(this));
        this.CU.setOnItemLongClickListener(new 12(this));
        this.CU.setAdapter(this.kBd);
        this.CU.setOnItemClickListener(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        au.Em().H(new 13(this));
        com.tencent.mm.plugin.label.e.aYJ().c(this.kBi);
    }

    protected void onResume() {
        au.DF().a(636, this);
        au.HU();
        c.FR().a(this.kBj);
        ge(true);
        super.onResume();
    }

    protected void onPause() {
        au.DF().b(636, this);
        au.HU();
        c.FR().b(this.kBj);
        super.onPause();
    }

    protected void onDestroy() {
        com.tencent.mm.plugin.label.e.aYJ().d(this.kBi);
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.kBd != null && i >= 0) {
            ad rM = this.kBd.rM(i);
            if (rM != null) {
                String str = rM.field_labelID;
                String str2 = rM.field_labelName;
                Intent intent = new Intent();
                intent.putExtra("label_id", str);
                intent.putExtra("label_name", str2);
                intent.setClass(this, ContactLabelEditUI.class);
                startActivity(intent);
                if (!bi.oW(str)) {
                    return;
                }
                if (this.kBe == null || this.kBe.isEmpty()) {
                    h.mEJ.h(11347, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                    return;
                }
                h.mEJ.h(11347, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
            }
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int i = ((AdapterContextMenuInfo) contextMenuInfo).position;
        if (this.kBd != null && i >= 0) {
            ad rM = this.kBd.rM(i);
            if (rM != null) {
                contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.j.a(view.getContext(), rM.field_labelName));
                contextMenu.add(0, 0, 0, getString(R.l.app_delete));
                contextMenu.add(0, 1, 1, getString(R.l.app_edit));
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int i2 = ((AdapterContextMenuInfo) menuItem.getMenuInfo()).position;
        if (this.kBd != null && i2 >= 0) {
            ad rM = this.kBd.rM(i2);
            switch (i) {
                case 0:
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.label_delete_confirm), "", getString(R.l.app_delete), getString(R.l.app_cancel), new 2(this, rM), new 3(this));
                    return;
                case 1:
                    Intent intent = new Intent();
                    intent.setClass(this, ContactLabelEditUI.class);
                    intent.putExtra("label_id", rM.field_labelID);
                    intent.putExtra("label_name", rM.field_labelName);
                    startActivity(intent);
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (lVar.getType()) {
            case 636:
                if (i == 0 && i2 == 0) {
                    FI(((com.tencent.mm.plugin.label.b.b) lVar).kAF);
                    return;
                }
                x.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd] delete fail.");
                aYR();
                return;
            default:
                x.w("MicroMsg.Label.ContactLabelManagerUI", "unknow type.");
                return;
        }
    }

    private synchronized void ge(boolean z) {
        x.d("MicroMsg.Label.ContactLabelManagerUI", "loading%s", new Object[]{String.valueOf(z)});
        if (z && this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(TbsReaderView$ReaderCallback.SHOW_BAR, 400);
        }
        au.Em().H(new 4(this, z));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] requestCode:%d resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 7001:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    x.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", new Object[]{stringExtra});
                    if (!bi.oW(stringExtra)) {
                        Intent intent2 = new Intent();
                        intent2.setClass(this, ContactLabelEditUI.class);
                        intent2.putExtra("Select_Contact", stringExtra);
                        startActivity(intent2);
                        break;
                    }
                    break;
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    private void FI(String str) {
        if (com.tencent.mm.plugin.label.e.aYJ().jy(str)) {
            aYM();
            ge(false);
            return;
        }
        x.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteContactLabel] fail.");
        aYR();
    }

    private void aYR() {
        aYM();
        zK(getString(R.l.del_label_failed_msg));
    }
}
