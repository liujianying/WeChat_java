package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.w$a;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SelectContactUI extends MMBaseSelectContactUI implements e {
    private String chatroomName;
    private HashSet<String> eCr;
    private ProgressDialog eHw;
    private List<String> gRN;
    private TextView gmo;
    private int hOX;
    private String hwC;
    private b tOA = new 6(this);
    private String title;
    private int uhk;
    private String ulA;
    private boolean ulB;
    private boolean ulC;
    private jw ulD;
    private boolean ulE;
    private boolean ulF = true;
    private boolean ulG = false;
    private String ulH;
    private AlphaAnimation ulI;
    private AlphaAnimation ulJ;
    private boolean ulK = false;
    private TextView uls;
    private TextView ult;
    private TextView ulu;
    private TextView ulv;
    private HashSet<String> ulw;
    private boolean ulx;
    private boolean uly;
    private String ulz;

    static /* synthetic */ void d(SelectContactUI selectContactUI) {
        if (!selectContactUI.cyC()) {
            List mm = selectContactUI.mm(false);
            mm.remove(q.GF());
            if (mm.size() == 1) {
                selectContactUI.finish();
                selectContactUI.a(ChattingUI.class, new Intent().putExtra("Chat_User", (String) mm.get(0)));
                return;
            }
            selectContactUI.ulD = new jw();
            selectContactUI.ulD.bTO.bTQ = "";
            selectContactUI.ulD.bTO.bTR = mm;
            a.sFg.m(selectContactUI.ulD);
            selectContactUI.getString(R.l.app_tip);
            selectContactUI.eHw = h.a(selectContactUI, selectContactUI.getString(R.l.launchchatting_creating_chatroom), true, new 4(selectContactUI));
        }
    }

    protected final void Wj() {
        super.Wj();
        this.hOX = getIntent().getIntExtra("list_attr", s.ukE);
        this.title = getIntent().getStringExtra("titile");
        this.hwC = getIntent().getStringExtra("sub_title");
        this.uhk = getIntent().getIntExtra("list_type", -1);
        this.ulF = getIntent().getBooleanExtra("show_too_many_member", true);
        if (s.fb(this.hOX, GLIcon.TOP) && s.Hq().size() == 0) {
            s.fc(this.hOX, GLIcon.TOP);
        }
        this.ulx = getIntent().getBooleanExtra("Add_SendCard", false);
        this.uly = getIntent().getBooleanExtra("recommend_friends", false);
        if (this.ulx || this.uly) {
            this.ulz = bi.aG(getIntent().getStringExtra("be_send_card_name"), "");
            this.ulA = bi.aG(getIntent().getStringExtra("received_card_name"), "");
        }
        this.ulB = getIntent().getBooleanExtra("Forbid_SelectChatRoom", false);
        this.gRN = new ArrayList();
        this.eCr = new HashSet();
        this.ulw = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bi.oW(stringExtra)) {
            this.ulw.addAll(bi.F(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!bi.oW(stringExtra)) {
            this.eCr.addAll(bi.F(stringExtra.split(",")));
        }
        Collection hashSet = new HashSet();
        String stringExtra2 = getIntent().getStringExtra("block_contact");
        if (!bi.oW(stringExtra2)) {
            hashSet.addAll(bi.F(stringExtra2.split(",")));
        }
        Collection hashSet2 = new HashSet(hashSet);
        hashSet2.addAll(s.cyz());
        hashSet2.addAll(s.cyA());
        if (this.ulx) {
            hashSet2.removeAll(s.cyz());
        }
        this.gRN.addAll(hashSet2);
        cyB();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        au.DF().a(30, this);
        au.DF().a(138, this);
        b.a(jw.class.getName(), this.tOA);
        x.i("MicroMsg.SelectContactUI", "create!");
        if (!bi.oW(this.hwC)) {
            setMMSubTitle(this.hwC);
        }
        if (s.fb(this.hOX, 64)) {
            a(1, getString(R.l.app_ok), new 17(this), com.tencent.mm.ui.s.b.tmX);
        }
        Wp();
        setBackBtn(new 1(this));
        if (this.uhk != 15) {
            Iterator it = this.eCr.iterator();
            while (it.hasNext()) {
                this.lbw.bm((String) it.next(), false);
            }
        }
    }

    protected void onDestroy() {
        au.DF().b(30, this);
        au.DF().b(138, this);
        b.b(jw.class.getName(), this.tOA);
        super.onDestroy();
    }

    public final void iV(int i) {
        int headerViewsCount = i - getContentLV().getHeaderViewsCount();
        if (headerViewsCount < 0) {
            x.i("MicroMsg.SelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[]{Integer.valueOf(headerViewsCount), Integer.valueOf(i)});
            return;
        }
        com.tencent.mm.ui.contact.a.a FM = cyp().FM(headerViewsCount);
        if (FM == null) {
            return;
        }
        if (FM instanceof j) {
            if (s.fb(this.hOX, 16384)) {
                x.i("MicroMsg.SelectContactUI", "handleClickNonSelect, return the result");
                Intent intent = new Intent();
                String str = "";
                intent.putExtra("Select_Contact", str);
                intent.putExtra("Select_Conv_User", str);
                intent.putExtra("Select_Contact", str);
                setResult(-1, intent);
                finish();
            }
        } else if (FM.guS != null && FM.guS.field_deleteFlag != 1) {
            String str2 = FM.guS.field_username;
            x.i("MicroMsg.SelectContactUI", "ClickUser=%s", new Object[]{str2});
            if (s.fb(this.hOX, 64)) {
                if (!s.fb(this.hOX, 131072) || this.eCr.size() < getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE)) {
                    aaN(str2);
                } else if (!this.ulw.contains(str2)) {
                    cyv();
                    if (this.eCr.contains(str2)) {
                        this.lbw.Ty(str2);
                        this.eCr.remove(str2);
                    } else {
                        str2 = getIntent().getStringExtra("too_many_member_tip_string");
                        if (bi.oW(str2)) {
                            str2 = getString(R.l.select_contact_num_limit_tips, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10))});
                        }
                        h.a(this.mController.tml, str2, getString(R.l.app_remind), new 5(this));
                    }
                }
                Wp();
                cyB();
                cyq().notifyDataSetChanged();
                return;
            }
            dT(bi.F(new String[]{str2}));
        }
    }

    private void cyB() {
        if (!this.ulF) {
            return;
        }
        if (this.uhk == 1 || this.uhk == 0) {
            int size;
            int size2 = this.ulw != null ? this.ulw.size() : 0;
            if (this.eCr != null) {
                size = this.eCr.size();
            } else {
                size = 0;
            }
            size2 += size;
            size = bi.WU(g.AT().getValue("ChatRoomInviteStartCount"));
            if (size > 0 && size2 == size + 1 && !this.ulK) {
                if (this.gmo == null) {
                    this.gmo = (TextView) findViewById(R.h.select_contact_float_tips);
                }
                if (this.gmo.getVisibility() != 0) {
                    this.gmo.setText(R.l.room_add_member_tips);
                    this.gmo.setOnClickListener(new 9(this));
                    if (this.ulI == null) {
                        this.ulI = new AlphaAnimation(0.0f, 1.0f);
                    }
                    this.ulI.setDuration(300);
                    if (this.ulJ != null) {
                        this.ulJ.cancel();
                    }
                    this.gmo.setVisibility(0);
                    this.gmo.startAnimation(this.ulI);
                }
            } else if (size2 < size) {
                cyD();
                this.ulK = false;
            }
        }
    }

    protected final boolean Wk() {
        return false;
    }

    protected final boolean Wl() {
        return true;
    }

    protected final String Wm() {
        return this.title;
    }

    protected final o Wn() {
        boolean z;
        boolean z2 = false;
        c$a c_a = new c$a();
        c_a.uhW = s.fb(this.hOX, 16);
        c_a.uhV = s.fb(this.hOX, 32);
        c_a.uhX = !s.fb(this.hOX, 4);
        if (s.fb(this.hOX, 1)) {
            z = false;
        } else {
            z = true;
        }
        c_a.uhY = z;
        c_a.uhZ = s.fb(this.hOX, 128);
        c_a.uia = s.fb(this.hOX, 1048576);
        if (c_a.uhZ) {
            this.ulG = true;
            c_a.uib = getIntent().getStringExtra("wechat_sport_contact");
            c_a.uic = getIntent().getStringExtra("wechat_sport_recent_like");
            this.ulH = c_a.uib;
        }
        if (getIntent().getBooleanExtra("snsPostWhoCanSee", false) || getIntent().getBooleanExtra("without_openim", false) || getIntent().getIntExtra("scene", 0) == 5) {
            c_a.ugF = "@all.contact.without.chatroom.without.openim";
        }
        List list = this.gRN;
        boolean fb = s.fb(this.hOX, 1);
        boolean fb2 = s.fb(this.hOX, 64);
        if (this.uhk == 15) {
            z2 = true;
        }
        return new c(this, list, fb, fb2, c_a, z2);
    }

    protected final m Wo() {
        if (this.ulG) {
            return new r(this, this.gRN, s.fb(this.hOX, 64), this.ulH);
        }
        return new q(this, this.gRN, s.fb(this.hOX, 64), this.scene);
    }

    public final boolean cyC() {
        if (!this.ulB) {
            return false;
        }
        try {
            h.a(this, getString(R.l.share_openim_card_waring), "", null);
        } catch (Throwable th) {
        }
        return true;
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (s.fb(this.hOX, GLIcon.TOP)) {
            if (this.uls == null) {
                String string;
                OnClickListener 11 = new 11(this);
                if (this.uhk == 14) {
                    string = getString(R.l.address_select_group_card);
                } else {
                    string = getString(R.l.address_history_group_card);
                }
                this.uls = a(listView, 11, string);
            }
            this.uls.setVisibility(i);
        }
        if (s.fb(this.hOX, 512)) {
            if (this.ult == null) {
                this.ult = a(listView, new 12(this), getString(R.l.find_friends_create_pwdgroup));
            }
            this.ult.setVisibility(i);
        }
        if (s.fb(this.hOX, 1024)) {
            if (this.ulu == null) {
                this.ulu = a(listView, new OnClickListener() {
                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClassName(SelectContactUI.this, "com.tencent.mm.ui.contact.GroupCardSelectUI");
                        intent.putExtra("group_select_type", false);
                        SelectContactUI.this.startActivityForResult(intent, 1);
                    }
                }, getString(R.l.address_history_group_card_import));
            }
            this.ulu.setVisibility(i);
        }
        if (s.fb(this.hOX, 2048)) {
            if (this.ulv == null) {
                this.ulv = a(listView, new OnClickListener() {
                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("list_attr", 16384);
                        d.b(SelectContactUI.this, "brandservice", ".ui.BrandServiceIndexUI", intent, 2);
                    }
                }, getString(R.l.address_official_accounts_title));
            }
            this.ulv.setVisibility(i);
            this.ulv.setTextSize(16.0f * com.tencent.mm.bp.a.fe(this.ulv.getContext()));
        }
        if (s.fb(this.hOX, 2048)) {
            if (this.ulv != null) {
                this.ulv.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
            }
        } else if (s.fb(this.hOX, 1024)) {
            if (this.ulu != null) {
                this.ulu.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
            }
        } else if (s.fb(this.hOX, 512)) {
            if (this.ult != null) {
                this.ult.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
            }
        } else if (s.fb(this.hOX, GLIcon.TOP) && this.uls != null) {
            this.uls.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
        }
    }

    private TextView a(ListView listView, OnClickListener onClickListener, String str) {
        View inflate = y.gq(this).inflate(R.i.group_card_item, null);
        inflate.setOnClickListener(onClickListener);
        TextView textView = (TextView) inflate.findViewById(R.h.content_tv);
        textView.setText(str);
        listView.addHeaderView(inflate);
        return textView;
    }

    private boolean dT(final List<String> list) {
        x.i("MicroMsg.SelectContactUI", "handleSelect %s", new Object[]{list});
        if (!s.fb(this.hOX, GLIcon.RIGHT)) {
            return dU(list);
        }
        String string;
        if (list != null) {
            if (list.size() == 1) {
                string = getString(R.l.select_contact_confirm_tips, new Object[]{r.gT((String) list.get(0))});
            } else if (list.size() > 1) {
                String string2 = getString(R.l.app_seperator_marker);
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    if (i == 3) {
                        stringBuilder.append("...");
                        break;
                    }
                    stringBuilder.append(r.gT((String) list.get(i)));
                    if (i < list.size() - 1) {
                        stringBuilder.append(string2);
                    }
                }
                string = getString(R.l.select_contact_confirm_tips, new Object[]{stringBuilder.toString()});
            }
            this.ulE = true;
            h.a(this.mController.tml, string, null, true, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SelectContactUI.this.ulE = SelectContactUI.this.dU(list);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SelectContactUI.this.ulE = false;
                }
            });
            return this.ulE;
        }
        string = null;
        this.ulE = true;
        h.a(this.mController.tml, string, null, true, /* anonymous class already generated */, /* anonymous class already generated */);
        return this.ulE;
    }

    private boolean dU(List<String> list) {
        boolean endsWith;
        Intent intent;
        Intent intent2;
        if (getIntent().getBooleanExtra("Add_SendCard", false)) {
            if (bi.oW(this.ulz)) {
                this.ulz = bi.c(list, ",");
            } else if (bi.oW(this.ulA)) {
                this.ulA = bi.c(list, ",");
            } else {
                x.e("MicroMsg.SelectContactUI", "send card occur error: send:%s | receive:%s", new Object[]{this.ulz, this.ulA});
                return false;
            }
            endsWith = this.ulA.endsWith("@chatroom");
            intent = new Intent();
            intent.putExtra("be_send_card_name", this.ulz);
            intent.putExtra("received_card_name", this.ulA);
            intent.putExtra("Is_Chatroom", endsWith);
            setResult(-1, intent);
            finish();
        } else if (getIntent().getBooleanExtra("snsPostWhoCanSee", false)) {
            x.i("MicroMsg.SelectContactUI", "sns post who can see scene,users=%s", new Object[]{list.toString()});
            ArrayList ml = ml(false);
            ml.remove(q.GF());
            boolean z = false;
            for (String str : list) {
                if (!bi.oW(str)) {
                    if (!(ml.contains(str) || q.GF().equals(str))) {
                        au.HU();
                        ab Yg = c.FR().Yg(str);
                        if (!(Yg == null || ((int) Yg.dhP) == 0 || !com.tencent.mm.l.a.gd(Yg.field_type))) {
                            aaN(str);
                            ml.add(str);
                            endsWith = true;
                            z = endsWith;
                        }
                    }
                }
                endsWith = z;
                z = endsWith;
            }
            if (z) {
                Wp();
                cyp().notifyDataSetChanged();
            } else {
                List ml2 = ml(false);
                ml2.remove(q.GF());
                String c = bi.c(ml2, ",");
                if (bi.cX(ml2)) {
                    intent2 = new Intent();
                    intent2.putExtra("Select_Contact", c);
                    intent2.putExtra("Select_Conv_User", c);
                    intent2.putExtra("Select_Contact", c);
                    intent2.putExtra("Select_Contacts_To_Create_New_Label", c);
                    setResult(0, intent2);
                    finish();
                } else {
                    h.a(this.mController.tml, true, getString(R.l.label_selected_contact_save_label), "", getString(R.l.label_selected_contact_save_btn), getString(R.l.label_selected_contact_cancel_btn), new 2(this, c), new 3(this, c));
                }
            }
        } else if (getIntent().getBooleanExtra("recommend_friends", false)) {
            x.i("MicroMsg.SelectContactUI", "Recommend Friends");
            y.a(this.mController.tml, this.ulA, list);
        } else if (s.fb(this.hOX, 16384)) {
            x.i("MicroMsg.SelectContactUI", "return the result");
            intent2 = new Intent();
            String c2 = bi.c(list, ",");
            intent2.putExtra("Select_Contact", c2);
            intent2.putExtra("Select_Conv_User", c2);
            intent2.putExtra("Select_Contact", c2);
            setResult(-1, intent2);
            finish();
        } else if (getIntent().getBooleanExtra("shareImage", false)) {
            x.i("MicroMsg.SelectContactUI", "Share Image");
            ArrayList ml3 = ml(true);
            ml3.remove(q.GF());
            if (ml3.size() > 0) {
                this.eHw = h.a(this.mController.tml, getString(R.l.main_sending), false, null);
                au.Em().H(new 18(this, ml3));
            }
        } else if (list.size() > 0) {
            x.i("MicroMsg.SelectContactUI", "Launch ChattingUI: users=%s", new Object[]{list.toString()});
            finish();
            intent = new Intent();
            intent.setClass(this, ChattingUI.class);
            intent.putExtra("Chat_User", (String) list.get(0));
            intent.addFlags(67108864);
            startActivity(intent);
        } else {
            x.e("MicroMsg.SelectContactUI", "unkown action: User=%s", new Object[]{list.toString()});
        }
        return true;
    }

    private void Wp() {
        if (!s.fb(this.hOX, 64) || this.eCr.size() <= 0) {
            updateOptionMenuText(1, getString(R.l.app_ok));
            enableOptionMenu(1, false);
            return;
        }
        updateOptionMenuText(1, getString(R.l.app_ok) + "(" + this.eCr.size() + ")");
        int intExtra = getIntent().getIntExtra("min_limit_num", 0);
        if (!s.fb(this.hOX, 262144) || this.eCr.size() >= intExtra) {
            enableOptionMenu(1, true);
        } else {
            enableOptionMenu(1, false);
        }
    }

    private ArrayList<String> ml(boolean z) {
        ArrayList<String> arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        Iterator it = this.eCr.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z || !s.hc(str)) {
                hashSet.add(str);
            } else {
                List<String> gJ = m.gJ(str);
                if (gJ != null) {
                    for (String str2 : gJ) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        arrayList.addAll(hashSet);
        return arrayList;
    }

    private ArrayList<String> mm(boolean z) {
        ArrayList<String> arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        Iterator it = this.eCr.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z || !s.hc(str)) {
                hashSet.add(str);
            } else {
                List<String> gJ = m.gJ(str);
                if (gJ != null) {
                    for (String str2 : gJ) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        hashSet.addAll(this.ulw);
        arrayList.addAll(hashSet);
        return arrayList;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (!bi.ci(this) || w$a.a(this, i, i2, str, 4)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            switch (lVar.getType()) {
                case 138:
                    cyp().notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        } else if (i == 4 && i2 == -24 && !bi.oW(str)) {
            Toast.makeText(this, str, 1).show();
        }
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (aVar.ujX && aVar.guS != null) {
            return this.eCr.contains(aVar.guS.field_username);
        }
        if (aVar.ujY && aVar.guS != null) {
            return this.eCr.contains(aVar.guS.field_username);
        }
        if (aVar instanceof j) {
            return this.eCr.isEmpty();
        }
        return false;
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.ujX || aVar.guS == null) {
            return false;
        }
        return this.ulw.contains(aVar.guS.field_username);
    }

    public final int[] bbG() {
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(131072));
        if (!s.fb(this.hOX, 1)) {
            arrayList.add(Integer.valueOf(131076));
        }
        if (!s.fb(this.hOX, 4)) {
            arrayList.add(Integer.valueOf(131075));
        }
        int[] iArr = new int[arrayList.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return iArr;
            }
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            i = i2 + 1;
        }
    }

    public final void pf(String str) {
        this.eCr.remove(str);
        cyp().notifyDataSetChanged();
        Wp();
    }

    private void aaN(String str) {
        if (!this.ulw.contains(str)) {
            cyv();
            this.lbw.Ty(str);
            if (this.eCr.contains(str)) {
                this.eCr.remove(str);
            } else {
                this.eCr.add(str);
            }
        }
    }

    private static List<String> aE(List<String> list) {
        List<String> linkedList = new LinkedList();
        if (!au.HX()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            au.HU();
            ab Yg = c.FR().Yg(obj2);
            if (!(Yg == null || ((int) Yg.dhP) == 0)) {
                obj2 = Yg.BL();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.SelectContactUI", "requestCode=%d | resultCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            String stringExtra;
            switch (i) {
                case 0:
                    if (!bi.oW(intent.getStringExtra("Select_Conv_User"))) {
                        dT(bi.F(new String[]{intent.getStringExtra("Select_Conv_User")}));
                        return;
                    }
                    return;
                case 1:
                    stringExtra = intent.getStringExtra("Select_Contact");
                    if (!bi.oW(stringExtra)) {
                        dT(bi.F(stringExtra.split(",")));
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        if (!bi.oW(intent.getStringExtra("Select_Contact"))) {
                            dT(bi.F(new String[]{intent.getStringExtra("Select_Contact")}));
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    stringExtra = intent.getStringExtra("Select_Contact");
                    if (bi.oW(stringExtra)) {
                        x.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
                        return;
                    }
                    x.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS select username=%s", new Object[]{stringExtra});
                    if (s.fb(this.hOX, 64)) {
                        for (String str : stringExtra.split(",")) {
                            if (this.eCr.add(str)) {
                                this.lbw.Ty(str);
                            }
                        }
                        Wp();
                        cyp().notifyDataSetChanged();
                        return;
                    }
                    dT(bi.F(new String[]{stringExtra}));
                    return;
                case 4:
                    String stringExtra2 = intent.getStringExtra("Select_Conv_User");
                    Iterator it = this.eCr.iterator();
                    while (it.hasNext()) {
                        this.lbw.Tz((String) it.next());
                    }
                    this.eCr.clear();
                    if (!bi.oW(stringExtra2)) {
                        this.eCr.addAll(bi.F(stringExtra2.split(",")));
                    }
                    Iterator it2 = this.eCr.iterator();
                    while (it2.hasNext()) {
                        this.lbw.bm((String) it2.next(), false);
                    }
                    Wp();
                    return;
                default:
                    return;
            }
        }
    }

    protected final boolean bcN() {
        if (this.ulG) {
            return false;
        }
        return true;
    }

    protected final void Gr(String str) {
        com.tencent.mm.plugin.report.service.h.mEJ.h(11225, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
        Intent intent = new Intent();
        intent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
        intent.putExtra("label", str);
        Collection hashSet = new HashSet();
        hashSet.addAll(ml(s.fb(this.hOX, 8192)));
        hashSet.addAll(this.ulw);
        intent.putExtra("always_select_contact", bi.c(new ArrayList(hashSet), ","));
        intent.putExtra("always_select_contact", bi.c(new ArrayList(hashSet), ","));
        if (s.fb(this.hOX, 64)) {
            intent.putExtra("list_attr", s.s(new int[]{16384, 64, 131072}));
            if (this.uhk == 14) {
                intent.putExtra("max_limit_num", getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE));
            }
        } else {
            intent.putExtra("list_attr", 16384);
        }
        startActivityForResult(intent, 3);
    }

    private void cyD() {
        if (this.gmo == null) {
            this.gmo = (TextView) findViewById(R.h.select_contact_float_tips);
        }
        if (this.gmo.getVisibility() != 8) {
            if (this.ulJ == null) {
                this.ulJ = new AlphaAnimation(1.0f, 0.0f);
                this.ulJ.setAnimationListener(new 10(this));
            }
            this.ulJ.setDuration(300);
            if (this.ulI != null) {
                this.ulI.cancel();
            }
            this.gmo.startAnimation(this.ulJ);
        }
    }
}
