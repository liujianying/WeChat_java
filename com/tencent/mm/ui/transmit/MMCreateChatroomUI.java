package com.tencent.mm.ui.transmit;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.transmit.a.2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MMCreateChatroomUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private ProgressDialog eHw;
    private int scene;
    private b tOA = new 3(this);
    private List<String> uCX;
    private boolean uDg;
    a uDh;
    private b uDi;
    private boolean uDj;
    private boolean ulC;
    private jw ulD;

    static /* synthetic */ void a(MMCreateChatroomUI mMCreateChatroomUI, final LinkedList linkedList, List list) {
        Assert.assertTrue(linkedList.size() > 0);
        String string = ad.getContext().getString(R.l.chatroom_sys_msg_invite_split);
        List arrayList = new ArrayList();
        arrayList.addAll(linkedList);
        arrayList.addAll(list);
        Object[] objArr = new Object[]{bi.c(aE(arrayList), string)};
        h.a(mMCreateChatroomUI, mMCreateChatroomUI.getString(R.l.fmt_need_verify_multiuser, objArr), mMCreateChatroomUI.getString(R.l.launchchatting_create_chatroom_fail), mMCreateChatroomUI.getString(R.l.fmt_need_verify_alert_confirm), mMCreateChatroomUI.getString(R.l.fmt_need_verify_alert_cancel), true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                MMCreateChatroomUI.a(MMCreateChatroomUI.this, linkedList);
            }
        }, null);
    }

    public final /* bridge */ /* synthetic */ o cyq() {
        return this.uDh;
    }

    protected final void Wj() {
        super.Wj();
        this.uCX = getIntent().getStringArrayListExtra("query_phrase_list");
        this.uDg = getIntent().getBooleanExtra("go_to_chatroom_direct", false);
        this.scene = getIntent().getIntExtra("scene_from", 0);
    }

    protected final void initView() {
        super.initView();
        a aVar = this.uDh;
        for (String str : aVar.uCX) {
            i iVar = new i();
            iVar.handler = aVar.handler;
            iVar.jsv = aVar.lUA;
            iVar.bWm = str;
            iVar.jsu = com.tencent.mm.plugin.fts.a.c.b.jsU;
            iVar.jsq = new int[]{131072};
            iVar.jst.add("filehelper");
            iVar.jst.add(q.GF());
            a search = ((n) g.n(n.class)).search(2, iVar);
            aVar.uCY = new ArrayList();
            aVar.uCY.add(search);
        }
        a(1, getString(R.l.app_ok), new 1(this), s.b.tmX);
        Wp();
        b.a(jw.class.getName(), this.tOA);
    }

    public final void Wp() {
        List cAa = this.uDh.cAa();
        if (cAa.size() > 0) {
            updateOptionMenuText(1, getString(R.l.app_ok) + "(" + cAa.size() + ")");
            if (cAa.size() > 1) {
                enableOptionMenu(1, true);
                return;
            } else {
                enableOptionMenu(1, false);
                return;
            }
        }
        updateOptionMenuText(1, getString(R.l.app_ok));
        enableOptionMenu(1, false);
    }

    protected void onDestroy() {
        this.uDh.finish();
        b.b(jw.class.getName(), this.tOA);
        if (!this.uDj && this.scene == 3) {
            k.fh(false);
        }
        super.onDestroy();
    }

    protected final boolean Wk() {
        return false;
    }

    protected final boolean Wl() {
        return false;
    }

    protected final String Wm() {
        return getString(R.l.select_create_chatroom_title);
    }

    protected final o Wn() {
        if (this.uDh == null) {
            this.uDh = new a(this, this.uCX, this.scene);
        }
        return this.uDh;
    }

    protected final m Wo() {
        if (this.uDi == null) {
            this.uDi = new b(this, this.scene);
        }
        return this.uDi;
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!(aVar instanceof d)) {
            return false;
        }
        d dVar = (d) aVar;
        a aVar2 = this.uDh;
        String str = dVar.fyJ.jrv;
        int i = aVar.position;
        if (aVar2.eCr.contains(str)) {
            a.a aVar3;
            for (int size = aVar2.uCZ.size() - 1; size >= 0; size--) {
                aVar3 = (a.a) aVar2.uCZ.get(size);
                if (i >= aVar3.jta) {
                    break;
                }
            }
            aVar3 = null;
            if (aVar3 == null) {
                return false;
            }
            if (!str.equals(aVar3.uDc)) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!(aVar instanceof d)) {
            return false;
        }
        d dVar = (d) aVar;
        a aVar2 = this.uDh;
        if (aVar2.eCr.contains(dVar.fyJ.jrv)) {
            return true;
        }
        return false;
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

    public final boolean cyx() {
        return true;
    }

    public final void iV(int i) {
        a aVar = this.uDh;
        j jVar = this.uDi.jsk;
        String str = this.uDi.bWm;
        if (!(jVar.jsx.size() == 1 && ((l) jVar.jsx.get(0)).jrv.equals("no_result​"))) {
            a.a aVar2 = new a.a(aVar, (byte) 0);
            aVar2.jsx = jVar.jsx;
            aVar2.jrx = jVar.jrx;
            aVar2.bWm = str;
            aVar.uCZ.add(aVar2);
            int headerViewsCount = i - aVar.ujW.getContentLV().getHeaderViewsCount();
            if (headerViewsCount >= 3) {
                jVar.jsx.add(0, (l) jVar.jsx.remove(headerViewsCount));
                i = aVar.ujW.getContentLV().getHeaderViewsCount();
            }
            aVar.czZ();
            aVar.ujW.getContentLV().post(new 2(aVar, (aVar2.jta + i) + 1));
        }
        cyv();
        cyw();
        YC();
    }

    public final void pf(String str) {
        a aVar = this.uDh;
        aVar.eCr.remove(str);
        for (a.a aVar2 : aVar.uCZ) {
            if (str.equals(aVar2.uDc)) {
                aVar2.uDc = null;
            }
        }
        aVar.notifyDataSetChanged();
        Wp();
    }
}
