package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.WindowManager;
import android.widget.GridView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.h.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.chatroom.d.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMEditText;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomMemberUI extends MMActivity implements e {
    private static int hOL = 5;
    private boolean bSD;
    private String cZH;
    private o eMS;
    private p fUo;
    private u hLB;
    private boolean hLj;
    private String hMQ;
    private String hNf;
    private int hNg;
    private String hNh;
    private boolean hNi;
    private b hOF;
    private String hOG;
    private String hOH;
    private String hOI;
    private MMEditText hOJ;
    private int hOK;
    private GridView hOy;
    private int tH;
    private String talker;
    private String username;

    static /* synthetic */ void d(SeeRoomMemberUI seeRoomMemberUI) {
        String c = bi.c(m.gI(seeRoomMemberUI.hMQ), ",");
        Intent intent = new Intent();
        intent.putExtra("titile", seeRoomMemberUI.getString(R.l.address_title_select_contact));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", s.ukF);
        intent.putExtra("always_select_contact", c);
        intent.putExtra("scene", 4);
        d.b(seeRoomMemberUI, ".ui.contact.SelectContactUI", intent, 1);
    }

    static /* synthetic */ void e(SeeRoomMemberUI seeRoomMemberUI) {
        h.mEJ.a(219, 8, 1, true);
        List gI = m.gI(seeRoomMemberUI.hMQ);
        String c = bi.c(gI, ",");
        int size = gI.size();
        Intent intent = new Intent();
        intent.putExtra("RoomInfo_Id", seeRoomMemberUI.hMQ);
        intent.putExtra("Is_Chatroom", true);
        intent.putExtra("Chatroom_member_list", c);
        intent.putExtra("room_member_count", size);
        intent.putExtra("Is_RoomOwner", seeRoomMemberUI.hNi);
        intent.putExtra("list_attr", s.ukF);
        intent.putExtra("room_name", seeRoomMemberUI.hMQ);
        intent.putExtra("room_owner_name", seeRoomMemberUI.hLB.field_roomowner);
        intent.setClass(seeRoomMemberUI, SelectDelRoomMemberUI.class);
        seeRoomMemberUI.startActivityForResult(intent, 2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.mEJ.a(219, 2, 1, true);
        au.DF().a(990, this);
        au.DF().a(179, this);
        au.DF().a(120, this);
        au.DF().a(610, this);
        this.hMQ = getIntent().getStringExtra("RoomInfo_Id");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.hOH = getIntent().getStringExtra("Chatroom_member_list");
        this.bSD = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.hLj = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.hNi = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.hNh = getIntent().getStringExtra("room_owner_name");
        this.cZH = getIntent().getStringExtra("Add_address_titile");
        au.HU();
        this.hLB = c.Ga().ih(this.talker == null ? this.hMQ : this.talker);
        this.hNg = getIntent().getIntExtra("room_member_count", 0);
        this.hNf = getIntent().getStringExtra("room_name");
        this.tH = getIntent().getIntExtra("offset", 0);
        this.hOK = getIntent().getIntExtra("first_pos", 0);
        initView();
        if (this.hOF != null) {
            aAT();
            this.hOy.setSelection(this.hOK * hOL < this.hOF.getCount() ? this.hOK * hOL : this.hOF.getCount() - 1);
            this.hOy.postDelayed(new 1(this), 100);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.hOF != null) {
            this.hOF.yr(this.hOJ.getText().toString());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.hOy.setNumColumns(cV(this));
    }

    private static int cV(Context context) {
        if (context == null) {
            return 0;
        }
        int width = (int) ((((float) ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth()) - (context.getResources().getDimension(R.f.ListPadding) * 1.0f)) / ((float) ((int) ((context.getResources().getDimension(R.f.MiddlePadding) * 2.0f) + context.getResources().getDimension(R.f.NormalAvatarSize)))));
        x.i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", new Object[]{Integer.valueOf(width)});
        hOL = width;
        return width;
    }

    protected final void initView() {
        setMMTitle(this.cZH + "(" + this.hNg + ")");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SeeRoomMemberUI.this.setResult(0);
                SeeRoomMemberUI.this.finish();
                return true;
            }
        });
        this.hOJ = (MMEditText) findViewById(R.h.mutiselectcontact_edittext);
        this.hOy = (GridView) findViewById(R.h.chatroom_member_gv);
        this.hOy.setNumColumns(cV(this));
        this.hOy.setColumnWidth(getResources().getDimensionPixelSize(R.f.ListPadding));
        u uVar = this.hLB;
        String str = this.hMQ;
        List linkedList = new LinkedList();
        if (!bi.oW(this.hOG)) {
            linkedList = bi.F(this.hOG.split(","));
        }
        au.HU();
        bl Hg = c.FZ().Hg("@t.qq.com");
        if (Hg != null) {
            linkedList.add(Hg.name);
        }
        this.hOF = new b(this, this, uVar, str, linkedList, this.hNh);
        this.hOJ.addTextChangedListener(new 6(this));
        this.hOy.setOnItemClickListener(new 7(this));
        this.hOy.setOnItemLongClickListener(new 8(this));
        this.hOy.setAdapter(this.hOF);
    }

    private void aAT() {
        au.HU();
        this.hLB = c.Ga().ih(this.talker == null ? this.hMQ : this.talker);
        List gI = m.gI(this.hMQ);
        if (this.hOF != null) {
            this.hOF.aG(gI);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.eMS != null) {
            this.eMS.czQ();
        }
    }

    protected void onDestroy() {
        au.DF().b(990, this);
        au.DF().b(179, this);
        au.DF().b(120, this);
        au.DF().b(610, this);
        if (this.fUo != null && this.fUo.isShowing()) {
            this.fUo.dismiss();
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.see_roommember_ui;
    }

    private void yp(String str) {
        if (str != null && !str.equals("")) {
            List linkedList = new LinkedList();
            linkedList.add(str);
            g gVar = new g(this.hMQ, linkedList);
            getString(R.l.app_tip);
            this.fUo = com.tencent.mm.ui.base.h.a(this, getString(R.l.room_del_member), true, new 9(this, gVar));
            au.DF().a(gVar, 0);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.fUo != null && this.fUo.isShowing()) {
            this.fUo.dismiss();
        }
        a eV = a.eV(str);
        if (eV != null) {
            eV.a(this, null, null);
        } else if (i != 0 || i2 != 0) {
            if (lVar.getType() == 179 && i2 == -66) {
                com.tencent.mm.ui.base.h.b(this, getString(R.l.del_room_mem_err), getString(R.l.app_tip), true);
            }
            if (lVar.getType() == 120) {
                a(i2, (com.tencent.mm.plugin.chatroom.d.d) lVar);
            } else if (lVar.getType() == 610) {
                com.tencent.mm.ui.base.h.b(this, getString(R.l.invite_room_mem_err), getString(R.l.app_tip), true);
            }
        } else if (i == 0 && i2 == 0) {
            switch (lVar.getType()) {
                case 120:
                    a(i2, (com.tencent.mm.plugin.chatroom.d.d) lVar);
                    aAT();
                    break;
                case 179:
                    aAT();
                    break;
                case 610:
                    com.tencent.mm.ui.base.h.b(this, getString(R.l.invite_room_mem_ok), null, true);
                    break;
            }
            if (this.hLB != null) {
                setMMTitle(this.cZH + "(" + this.hLB.Nn().size() + ")");
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    if (!com.tencent.mm.model.s.gW(stringExtra)) {
                        com.tencent.mm.ui.base.h.b(this, getString(R.l.room_member_only_support_weixin), getString(R.l.app_tip), true);
                        return;
                    } else if (yq(stringExtra)) {
                        com.tencent.mm.ui.base.h.b(this, getString(R.l.add_room_mem_memberExits), getString(R.l.app_tip), true);
                        return;
                    } else if (bi.F(stringExtra.split(",")) != null) {
                        String stringExtra2 = intent.getStringExtra("Select_Contact");
                        au.HU();
                        u ih = c.Ga().ih(this.hMQ);
                        if (ih == null) {
                            return;
                        }
                        if (ih.ckN() == 2) {
                            com.tencent.mm.pluginsdk.ui.applet.g.b(this.mController, getString(R.l.request_to_owner_tip), getString(R.l.reason_invite_hint), getString(R.l.app_send), new 10(this, stringExtra2));
                            return;
                        } else {
                            q(stringExtra, null, R.l.adding_room_mem);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                return;
            case 2:
                if (intent != null) {
                    yp(intent.getStringExtra("Select_Contact"));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void q(String str, String str2, int i) {
        if (!com.tencent.mm.model.s.gW(str)) {
            com.tencent.mm.ui.base.h.b(this, getString(R.l.room_member_only_support_weixin), getString(R.l.app_tip), true);
        } else if (yq(str)) {
            com.tencent.mm.ui.base.h.b(this, getString(R.l.add_room_mem_memberExits), getString(R.l.app_tip), true);
        } else {
            List F = bi.F(str.split(","));
            if (F != null) {
                final com.tencent.mm.plugin.chatroom.d.d dVar = new com.tencent.mm.plugin.chatroom.d.d(this.hMQ, F, str2);
                getString(R.l.app_tip);
                this.fUo = com.tencent.mm.ui.base.h.a(this, getString(i), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        au.DF().c(dVar);
                    }
                });
                au.DF().a(dVar, 0);
            }
        }
    }

    private void a(int i, com.tencent.mm.plugin.chatroom.d.d dVar) {
        String str = "";
        String str2 = "";
        String string = ad.getContext().getString(R.l.chatroom_sys_msg_invite_split);
        List list = dVar.hKU;
        List list2 = dVar.hKW;
        List list3 = dVar.bTX;
        if (i != -2012 || ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty()))) {
            Object obj;
            au.HU();
            u ii = c.Ga().ii(this.hMQ);
            if (i == -116 && aAB() && !bi.oW(ii.field_roomowner)) {
                str = getString(R.l.room_member_needupgrade_tip);
                str2 = getString(R.l.room_member_needupgrade);
                obj = 1;
            } else {
                obj = null;
            }
            if (i == -23) {
                str = getString(R.l.room_member_toomuch_tip);
                str2 = getString(R.l.room_member_toomuch);
            }
            if (i == -109) {
                str = getString(R.l.room_member_no_exist_tip);
                str2 = getString(R.l.room_member_no_exist);
            }
            if (i == -122) {
                str = getString(R.l.room_member_toomuch_tip);
                int i2 = R.l.room_member_other_toomuch;
                Object[] objArr = new Object[2];
                str2 = null;
                au.HU();
                ab Yg = c.FR().Yg(this.hLB.field_roomowner);
                if (Yg != null && ((int) Yg.dhP) > 0) {
                    str2 = Yg.field_conRemark;
                }
                if (bi.oW(str2)) {
                    str2 = this.hLB.field_roomowner;
                    if (this.hLB == null) {
                        str2 = null;
                    } else {
                        str2 = this.hLB.gT(str2);
                    }
                }
                if (bi.oW(str2) && Yg != null && ((int) Yg.dhP) > 0) {
                    str2 = Yg.BK();
                }
                if (bi.oW(str2)) {
                    str2 = this.hLB.field_roomowner;
                }
                objArr[0] = str2;
                objArr[1] = Integer.valueOf(ii.ckO());
                str2 = getString(i2, objArr);
            }
            List list4 = dVar.hKV;
            if (list3 == null || list3.size() <= 0 || (list3.size() != dVar.bSU && (list4 == null || list4.size() <= 0 || dVar.bSU != list3.size() + list4.size()))) {
                String str3;
                list4 = dVar.hKV;
                if (list4 != null && list4.size() > 0) {
                    str2 = str2 + getString(R.l.fmt_in_blacklist, new Object[]{bi.c(aE(list4), string)});
                }
                list4 = dVar.bTW;
                if (list4 == null || list4.size() <= 0) {
                    str3 = str2;
                } else {
                    str = getString(R.l.add_room_mem_err);
                    str3 = str2 + getString(R.l.fmt_no_user, new Object[]{bi.c(aE(list4), string)});
                }
                List<String> list5 = dVar.bTU;
                if (list5 != null && list5.size() > 0) {
                    Object obj2;
                    for (String str22 : list5) {
                        if (ab.XR(str22)) {
                            str = getString(R.l.launchchatting_create_chatroom_fail);
                            str3 = getString(R.l.launchchatting_create_chatroom_openim_fail);
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        str = getString(R.l.add_room_mem_err);
                        str3 = str3 + getString(R.l.fmt_invalid_username, new Object[]{bi.c(aE(list5), string)});
                    }
                }
                Collection collection = dVar.hKW;
                if (!(list3 == null || list3.isEmpty()) || (collection != null && collection.size() > 0)) {
                    list = new ArrayList();
                    list.addAll(list3);
                    list.addAll(collection);
                    e(dVar.chatroomName, list3);
                    str3 = str3 + getString(R.l.fmt_chatroom_add_need_verify, new Object[]{bi.c(aE(list), string)});
                    if (list3 != null && list3.isEmpty()) {
                        str3 = null;
                    }
                }
                if (str3 != null && str3.length() > 0) {
                    if (obj != null) {
                        com.tencent.mm.ui.base.h.a(this, str3, str, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                SeeRoomMemberUI seeRoomMemberUI = SeeRoomMemberUI.this;
                                Context context = SeeRoomMemberUI.this;
                                SeeRoomMemberUI.this.hMQ;
                                SeeRoomMemberUI.a(seeRoomMemberUI, context);
                            }
                        }, null);
                    } else {
                        com.tencent.mm.ui.base.h.b(this, str3, str, true);
                    }
                }
                ii.ckN();
                return;
            }
            List linkedList = new LinkedList();
            for (int i3 = 0; i3 < list3.size(); i3++) {
                linkedList.add(list3.get(i3));
            }
            str22 = "";
            String string2 = ad.getContext().getString(R.l.chatroom_sys_msg_invite_split);
            if (!(list4 == null || list4.isEmpty())) {
                str22 = getString(R.l.fmt_chatroom_add_in_blacklist, new Object[]{bi.c(aE(list4), string2)}) + "\n";
            }
            if (!linkedList.isEmpty()) {
                str22 = str22 + getString(R.l.fmt_chatroom_add_need_verify, new Object[]{bi.c(aE(linkedList), string2)});
            }
            com.tencent.mm.ui.base.h.a(this, str22, "", getString(R.l.fmt_add_failure_alert_confirm), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SeeRoomMemberUI.this.aAT();
                }
            });
            e(dVar.chatroomName, linkedList);
            return;
        }
        string = getString(R.l.add_room_mem_err_need_invite);
        String string3 = getString(R.l.invite_alert_ok);
        String string4 = getString(R.l.app_cancel);
        12 12 = new 12(this, dVar, list3, list, list2);
        com.tencent.mm.ui.base.h.a(this, string, null, string3, string4, 12, new 2(this));
    }

    private void e(String str, List<String> list) {
        if (list != null && list.size() > 0) {
            List linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                linkedList.add(list.get(i));
            }
            com.tencent.mm.model.l.a(str, linkedList, getString(R.l.chatroom_sys_msg_invite_error_tip), true, "weixin://findfriend/verifycontact/" + str + "/");
        }
    }

    private static boolean aAB() {
        return bi.getInt(com.tencent.mm.k.g.AT().getValue("ChatroomGlobalSwitch"), 1) == 1;
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

    private boolean yq(String str) {
        boolean z = false;
        if (bi.oV(q.GF()).equals(str)) {
            return true;
        }
        List gI = m.gI(this.hMQ);
        if (gI == null) {
            return false;
        }
        Iterator it = gI.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            if (((String) it.next()).equals(str)) {
                z = true;
            } else {
                z = z2;
            }
        }
    }

    protected static String a(u uVar, String str) {
        if (uVar == null) {
            return "";
        }
        return uVar.gT(str);
    }

    private static Object invokeMethod(Object obj, String str, Object[] objArr, Class[] clsArr) {
        Class cls;
        if (obj == null) {
            return null;
        }
        Method declaredMethod;
        Object invoke;
        cls = obj.getClass();
        while (cls != Object.class) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
                break;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e, "", new Object[0]);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e2, "", new Object[0]);
            }
        }
        declaredMethod = null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            try {
                invoke = declaredMethod.invoke(obj, objArr);
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e3, "", new Object[0]);
                invoke = null;
            } catch (Throwable e32) {
                x.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e32, "", new Object[0]);
                invoke = null;
            } catch (Throwable e322) {
                x.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e322, "", new Object[0]);
            }
            return invoke;
        }
        invoke = null;
        return invoke;
        cls = cls.getSuperclass();
    }
}
