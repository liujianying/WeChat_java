package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a$f;
import com.tencent.mm.plugin.account.a$g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.bind.ui.a.a;
import com.tencent.mm.plugin.account.friend.a.ae;
import com.tencent.mm.plugin.account.friend.a.af;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GoogleFriendUI extends MMActivity implements OnItemClickListener, c, e, a {
    private boolean Ju = false;
    private boolean eEU = false;
    private String eEW;
    private ProgressDialog eEX;
    private int eEZ;
    private TextView eFf;
    private String eFs;
    private ListView eIb;
    private a eIc;
    private String eId;
    private String eIe;
    private af eIf;
    private ArrayList<n> eIg = new ArrayList();
    private HashMap<String, n> eIh = new HashMap();

    protected final int getLayoutId() {
        return a$g.gcontact_friend;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eEW = (String) g.Ei().DT().get(208903, null);
        if (TextUtils.isEmpty(this.eEW)) {
            finish();
        }
        this.eEZ = getIntent().getIntExtra("enter_scene", 0);
        this.eIc = new a(this, this.eEW);
        this.eIc.eHS = this;
        initView();
        this.eEU = m.cl(this);
        if (this.eEU) {
            x.d("MicroMsg.GoogleContact.GoogleFriendUI", "startActivityCheckGooglePlayServices");
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
        } else {
            WU();
        }
        ((o) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).clear();
    }

    protected void onResume() {
        super.onResume();
        g.DF().a(488, this);
        g.DF().a(489, this);
        q.Kp().d(this);
        if (this.eIc != null) {
            this.eIc.WT();
        }
    }

    protected void onStop() {
        super.onStop();
        g.DF().b(488, this);
        g.DF().b(489, this);
        q.Kp().e(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        ((o) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).clear();
    }

    protected final void initView() {
        setMMTitle(j.gcontact_friend_title);
        setBackBtn(new 1(this));
        this.eFf = (TextView) findViewById(a$f.empty);
        this.eIb = (ListView) findViewById(a$f.gcontact_friend_lv);
        this.eIb.setAdapter(this.eIc);
        this.eIb.setOnItemClickListener(this);
        com.tencent.mm.ui.tools.o oVar = new com.tencent.mm.ui.tools.o((byte) 0);
        oVar.uBw = new 2(this);
        a(oVar);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.GoogleContact.GoogleFriendUI", "onItemClick position:%d,", new Object[]{Integer.valueOf(i)});
        if (this.eIc != null) {
            n nVar = (n) this.eIc.getItem(i - this.eIb.getHeaderViewsCount());
            if (nVar != null) {
                String str = nVar.field_username;
                x.d("MicroMsg.GoogleContact.GoogleFriendUI", "jumpToProfile email:%s, username:%s", new Object[]{nVar.field_googlegmail, str});
                ab Yg = ((i) g.l(i.class)).FR().Yg(str);
                Intent intent;
                if ((Yg == null || !com.tencent.mm.l.a.gd(Yg.field_type)) && TextUtils.isEmpty(nVar.field_nickname)) {
                    intent = new Intent(this, InviteFriendUI.class);
                    intent.putExtra("friend_type", 2);
                    intent.putExtra("friend_user_name", str);
                    intent.putExtra("friend_num", nVar.field_googlegmail);
                    intent.putExtra("friend_nick", nVar.field_googlename);
                    intent.putExtra("friend_weixin_nick", nVar.field_nickname);
                    intent.putExtra("friend_googleID", nVar.field_googleid);
                    intent.putExtra("friend_googleItemID", nVar.field_googleitemid);
                    intent.putExtra("friend_scene", 58);
                    intent.putExtra("Contact_Scene", 58);
                    startActivity(intent);
                    return;
                }
                intent = new Intent();
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Nick", nVar.field_nickname);
                intent.putExtra("Contact_ShowFMessageList", true);
                intent.putExtra("verify_gmail", nVar.field_googlegmail);
                intent.putExtra("profileName", nVar.field_googlename);
                intent.putExtra("Contact_Source_FMessage", 58);
                intent.putExtra("Contact_Scene", 58);
                if (str != null && str.length() > 0) {
                    com.tencent.mm.plugin.account.a.a.ezn.d(intent, this.mController.tml);
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.GoogleContact.GoogleFriendUI", "requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 2005) {
            return;
        }
        if (i2 == -1) {
            this.eEU = intent.getBooleanExtra("gpservices", false);
            WU();
            return;
        }
        this.eEU = intent.getBooleanExtra("gpservices", false);
        finish();
    }

    private void WU() {
        x.d("MicroMsg.GoogleContact.GoogleFriendUI", "updateToken");
        if (this.eEU) {
            this.eIe = (String) g.Ei().DT().get(208901, null);
        } else {
            this.eIe = (String) g.Ei().DT().get(208902, null);
            this.eFs = (String) g.Ei().DT().get(208904, null);
        }
        if (TextUtils.isEmpty(this.eIe) || (!this.eEU && TextUtils.isEmpty(this.eFs))) {
            L(BindGoogleContactUI.class);
            finish();
        } else if (this.eEU) {
            WV();
        } else {
            WI();
            new c(this, this.eFs).execute(new Void[0]);
        }
    }

    public final void iZ(int i) {
        if (this.eIc != null) {
            n nVar = (n) this.eIc.getItem(i);
            if (nVar != null) {
                switch (nVar.field_status) {
                    case 0:
                        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this, new 3(this));
                        String str = nVar.field_googleitemid;
                        aVar.qIe = false;
                        aVar.qId = true;
                        aVar.eNh = str;
                        aVar.qIe = false;
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(Integer.valueOf(58));
                        aVar.b(nVar.field_username, linkedList, true);
                        nVar.field_googlecgistatus = 0;
                        ((o) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(nVar);
                        this.eIc.WT();
                        return;
                    case 1:
                        Cursor py = ((o) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).py(nVar.field_googleid);
                        if (py == null || py.getCount() <= 1) {
                            a(nVar, null);
                        } else {
                            a(py, nVar);
                        }
                        if (py != null) {
                            py.close();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        String str2 = "MicroMsg.GoogleContact.GoogleFriendUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = TextUtils.isEmpty(str) ? "" : str;
        x.i(str2, str3, objArr);
        int type = lVar.getType();
        if (i != 0 || i2 != 0) {
            switch (type) {
                case 30:
                case 137:
                    if (i2 == -87) {
                        h.b(this, getString(j.contact_info_biz_join_fans_limit), "", true);
                    } else if ((i2 == -24 || i2 == -101) && !bi.oW(str)) {
                        Toast.makeText(this, str, 1).show();
                    }
                    if (this.eIc != null) {
                        x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[]{((com.tencent.mm.pluginsdk.model.m) lVar).eLb});
                        ((o) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aa(str2, 2);
                        this.eIc.WT();
                        break;
                    }
                    break;
                case 488:
                    ch(false);
                    break;
                case 489:
                    if (this.eIc != null) {
                        x.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[]{Integer.valueOf(((ae) lVar).XP().hbF)});
                        x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[]{r11.eLb});
                        ((o) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aa(str2, 1);
                        this.eIc.WT();
                        break;
                    }
                    break;
                default:
                    x.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
                    break;
            }
        }
        switch (type) {
            case 30:
            case 137:
                if (this.eIc != null) {
                    x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[]{((com.tencent.mm.pluginsdk.model.m) lVar).eLb});
                    ((o) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aa(str2, 1);
                    this.eIc.WT();
                    break;
                }
                break;
            case 488:
                a(((af) lVar).XQ());
                break;
            case 489:
                if (this.eIc != null) {
                    x.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[]{Integer.valueOf(((ae) lVar).XP().hbF)});
                    x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[]{r11.eLb});
                    ((o) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aa(str2, 1);
                    this.eIc.WT();
                    break;
                }
                break;
            default:
                x.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
                break;
        }
        WJ();
    }

    public final void jX(String str) {
        if (this.eIc != null) {
            this.eIc.notifyDataSetChanged();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private void a(Cursor cursor, n nVar) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                n nVar2 = new n();
                nVar2.d(cursor);
                arrayList.add(nVar2.field_googlegmail);
                arrayList2.add(Integer.valueOf(i));
                arrayList3.add(nVar2);
                cursor.moveToNext();
            }
            arrayList2.add(Integer.valueOf(-1));
        }
        ActionBarActivity actionBarActivity = this.mController.tml;
        String string = getResources().getString(j.gcontact_select_email);
        getResources().getString(j.app_cancel);
        h.a(actionBarActivity, string, arrayList, arrayList2, new 4(this, arrayList3, nVar));
    }

    private void a(n nVar, n nVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(nVar.field_googlegmail);
        ae aeVar = new ae(arrayList);
        x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[]{nVar.field_googleitemid});
        g.DF().a(aeVar, 0);
        if (nVar2 == null) {
            aeVar.eLb = nVar.field_googleitemid;
            nVar.field_googlecgistatus = 0;
            ((o) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(nVar);
        } else {
            aeVar.eLb = nVar2.field_googleitemid;
            nVar2.field_googlecgistatus = 0;
            ((o) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).b(nVar2);
        }
        this.eIc.WT();
    }

    private void WV() {
        this.Ju = false;
        WI();
        new b(this, this, this.eIe, (byte) 0).execute(new Void[0]);
    }

    private synchronized void a(are are) {
        x.i("MicroMsg.GoogleContact.GoogleFriendUI", "handleListGoogleContactCGIResponse Count:%d", new Object[]{Integer.valueOf(are.hbF)});
        if (this.eIc != null) {
            this.eIc.WT();
        }
    }

    private void ch(boolean z) {
        CharSequence string;
        this.eFf.setVisibility(0);
        if (!ao.isConnected(this)) {
            string = getString(j.gcontact_network_error_msg);
        } else if (z) {
            string = getString(j.gcontact_empty);
        } else {
            string = getString(j.gcontact_default_error_msg);
        }
        this.eFf.setText(string);
    }

    private void WI() {
        if (this.eEX == null || !this.eEX.isShowing()) {
            getString(j.app_tip);
            this.eEX = h.a(this, getString(j.app_waiting), true, new 5(this));
        }
    }

    private void WJ() {
        if (this.eEX != null && this.eEX.isShowing()) {
            this.eEX.dismiss();
        }
    }
}
