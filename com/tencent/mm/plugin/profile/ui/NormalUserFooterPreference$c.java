package com.tencent.mm.plugin.profile.ui;

import android.text.TextUtils;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.e;
import java.util.LinkedList;
import junit.framework.Assert;

class NormalUserFooterPreference$c extends a {
    final /* synthetic */ NormalUserFooterPreference lXw;

    static /* synthetic */ void a(NormalUserFooterPreference$c normalUserFooterPreference$c) {
        int i = 0;
        if (((int) NormalUserFooterPreference.a(normalUserFooterPreference$c.lXw).dhP) == 0) {
            au.HU();
            c.FR().U(NormalUserFooterPreference.a(normalUserFooterPreference$c.lXw));
            au.HU();
            c.FR().Yg(NormalUserFooterPreference.a(normalUserFooterPreference$c.lXw).field_username);
        }
        if (((int) NormalUserFooterPreference.a(normalUserFooterPreference$c.lXw).dhP) <= 0) {
            x.e("MicroMsg.NormalUserFooterPreference", "addContact : insert contact failed");
            return;
        }
        if (!com.tencent.mm.l.a.gd(NormalUserFooterPreference.a(normalUserFooterPreference$c.lXw).field_type) && NormalUserFooterPreference.l(normalUserFooterPreference$c.lXw) == 15) {
            com.tencent.mm.plugin.account.friend.a.a pp = b.getAddrUploadStg().pp(NormalUserFooterPreference.a(normalUserFooterPreference$c.lXw).field_username);
            if (pp != null) {
                h hVar = h.mEJ;
                Object[] objArr = new Object[4];
                objArr[0] = NormalUserFooterPreference.a(normalUserFooterPreference$c.lXw).field_username;
                objArr[1] = Integer.valueOf(3);
                if (!bi.oW(pp.Xh())) {
                    i = 1;
                }
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(NormalUserFooterPreference.a(normalUserFooterPreference$c.lXw).csZ.toString().split(",").length >= 5 ? 5 : NormalUserFooterPreference.a(normalUserFooterPreference$c.lXw).csZ.toString().split(",").length);
                hVar.h(12040, objArr);
            }
        }
        s.p(NormalUserFooterPreference.a(normalUserFooterPreference$c.lXw));
        NormalUserFooterPreference normalUserFooterPreference = normalUserFooterPreference$c.lXw;
        au.HU();
        NormalUserFooterPreference.a(normalUserFooterPreference, c.FR().Yg(NormalUserFooterPreference.a(normalUserFooterPreference$c.lXw).field_username));
        normalUserFooterPreference$c.bnA();
    }

    public NormalUserFooterPreference$c(NormalUserFooterPreference normalUserFooterPreference) {
        this.lXw = normalUserFooterPreference;
        super(normalUserFooterPreference);
    }

    protected final void FC() {
        super.FC();
    }

    protected void onDetach() {
        super.onDetach();
    }

    protected void bnA() {
        Assert.assertTrue(!s.hO(NormalUserFooterPreference.a(this.lXw).field_username));
        NormalUserFooterPreference.r(this.lXw).setVisibility(8);
        NormalUserFooterPreference.s(this.lXw).setVisibility(8);
        if (NormalUserFooterPreference.d(this.lXw)) {
            NormalUserFooterPreference.D(this.lXw).setOnClickListener(new 1(this));
            if (com.tencent.mm.l.a.gd(NormalUserFooterPreference.a(this.lXw).field_type)) {
                NormalUserFooterPreference.D(this.lXw).setVisibility(0);
            } else {
                NormalUserFooterPreference.D(this.lXw).setVisibility(8);
            }
            NormalUserFooterPreference.t(this.lXw).setVisibility(8);
            NormalUserFooterPreference.f(this.lXw).setVisibility(8);
            NormalUserFooterPreference.g(this.lXw).setVisibility(8);
            NormalUserFooterPreference.h(this.lXw).setVisibility(8);
            NormalUserFooterPreference.q(this.lXw).setVisibility(8);
            return;
        }
        NormalUserFooterPreference.t(this.lXw).setOnClickListener(new 2(this));
        if (com.tencent.mm.l.a.gd(NormalUserFooterPreference.a(this.lXw).field_type)) {
            NormalUserFooterPreference.t(this.lXw).setVisibility(8);
            NormalUserFooterPreference.f(this.lXw).setVisibility(0);
            if (this.lXw.bnx() || NormalUserFooterPreference.a(this.lXw).field_username.equals(q.GF()) || s.hO(NormalUserFooterPreference.a(this.lXw).field_username) || s.hH(NormalUserFooterPreference.a(this.lXw).field_username) || ab.XR(NormalUserFooterPreference.a(this.lXw).field_username) || s.hd(NormalUserFooterPreference.a(this.lXw).field_username)) {
                NormalUserFooterPreference.h(this.lXw).setVisibility(8);
            } else {
                NormalUserFooterPreference.h(this.lXw).setVisibility(0);
            }
            au.HU();
            if (c.FR().Yj(NormalUserFooterPreference.a(this.lXw).field_username)) {
                NormalUserFooterPreference.k(this.lXw).setVisibility(0);
                NormalUserFooterPreference.a(this.lXw, NormalUserFooterPreference.a(this.lXw).getSource());
            }
        } else {
            NormalUserFooterPreference.t(this.lXw).setVisibility(0);
            NormalUserFooterPreference.f(this.lXw).setVisibility(8);
            NormalUserFooterPreference.g(this.lXw).setVisibility(8);
            NormalUserFooterPreference.h(this.lXw).setVisibility(8);
        }
        if (NormalUserFooterPreference.a(this.lXw).BA()) {
            NormalUserFooterPreference.q(this.lXw).setVisibility(0);
        } else {
            NormalUserFooterPreference.q(this.lXw).setVisibility(8);
        }
    }

    protected final void bnF() {
        if (((int) NormalUserFooterPreference.a(this.lXw).dhP) == 0) {
            au.HU();
            if (c.FR().U(NormalUserFooterPreference.a(this.lXw)) != -1) {
                NormalUserFooterPreference normalUserFooterPreference = this.lXw;
                au.HU();
                NormalUserFooterPreference.a(normalUserFooterPreference, c.FR().Yg(NormalUserFooterPreference.a(this.lXw).field_username));
            }
        }
        if (NormalUserFooterPreference.F(this.lXw) || NormalUserFooterPreference.l(this.lXw) == 12) {
            x.d("MicroMsg.NormalUserFooterPreference", "qqNum " + NormalUserFooterPreference.G(this.lXw) + " qqReamrk " + NormalUserFooterPreference.H(this.lXw));
            if (!(NormalUserFooterPreference.G(this.lXw) == 0 || NormalUserFooterPreference.H(this.lXw) == null || NormalUserFooterPreference.H(this.lXw).equals(""))) {
                ao bK = b.getQQListStg().bK(NormalUserFooterPreference.G(this.lXw));
                if (bK == null) {
                    bK = new ao();
                    bK.nickname = "";
                    bK.eLw = NormalUserFooterPreference.G(this.lXw);
                    bK.eLE = NormalUserFooterPreference.H(this.lXw);
                    bK.username = NormalUserFooterPreference.a(this.lXw).field_username;
                    bK.Yc();
                    b.getQQListStg().a(bK);
                } else {
                    bK.eLw = NormalUserFooterPreference.G(this.lXw);
                    bK.eLE = NormalUserFooterPreference.H(this.lXw);
                    bK.username = NormalUserFooterPreference.a(this.lXw).field_username;
                    bK.Yc();
                    b.getQQListStg().a(NormalUserFooterPreference.G(this.lXw), bK);
                }
            }
        } else if (NormalUserFooterPreference.l(this.lXw) == 58 || NormalUserFooterPreference.l(this.lXw) == 59 || NormalUserFooterPreference.l(this.lXw) == 60) {
            b.getGoogleFriendStorage().ab(NormalUserFooterPreference.a(this.lXw).field_username, 1);
        }
        String stringExtra = NormalUserFooterPreference.b(this.lXw).getIntent().getStringExtra("Contact_Mobile_MD5");
        String stringExtra2 = NormalUserFooterPreference.b(this.lXw).getIntent().getStringExtra("Contact_full_Mobile_MD5");
        String oV = bi.oV(stringExtra);
        stringExtra2 = bi.oV(stringExtra2);
        if (!(oV.equals("") && stringExtra2.equals(""))) {
            com.tencent.mm.plugin.account.friend.a.a pq = b.getAddrUploadStg().pq(oV);
            if (pq == null) {
                pq = b.getAddrUploadStg().pq(stringExtra2);
            } else {
                stringExtra2 = oV;
            }
            if (pq != null) {
                b.getAddrUploadStg().a(stringExtra2, pq);
            }
        }
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.lXw.mContext, new 3(this));
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(NormalUserFooterPreference.l(this.lXw)));
        stringExtra = NormalUserFooterPreference.b(this.lXw).getIntent().getStringExtra("source_from_user_name");
        String stringExtra3 = NormalUserFooterPreference.b(this.lXw).getIntent().getStringExtra("source_from_nick_name");
        aVar.qIb = stringExtra;
        aVar.qIc = stringExtra3;
        aVar.qHX = new 4(this, stringExtra, stringExtra3);
        stringExtra3 = NormalUserFooterPreference.b(this.lXw).getIntent().getStringExtra("room_name");
        Object stringExtra4 = NormalUserFooterPreference.b(this.lXw).getIntent().getStringExtra(e.a.ths);
        if (!TextUtils.isEmpty(stringExtra4)) {
            aVar.TC(stringExtra4);
            aVar.b(NormalUserFooterPreference.a(this.lXw).field_username, "", linkedList);
        } else if (TextUtils.isEmpty(stringExtra3)) {
            aVar.TC(NormalUserFooterPreference.a(this.lXw).cta);
            aVar.c(NormalUserFooterPreference.a(this.lXw).field_username, linkedList);
        } else if (TextUtils.isEmpty(aVar.juZ)) {
            au.HU();
            ab Yg = c.FR().Yg(NormalUserFooterPreference.a(this.lXw).field_username);
            stringExtra4 = Yg != null ? bi.aG(Yg.cta, "") : "";
            x.i("MicroMsg.NormalUserFooterPreference", "dkverify footer add:%s chat:%s ticket:%s", new Object[]{NormalUserFooterPreference.a(this.lXw).field_username, stringExtra3, stringExtra4});
            if (TextUtils.isEmpty(stringExtra4)) {
                am.a.dBr.a(NormalUserFooterPreference.a(this.lXw).field_username, stringExtra3, new 5(this, aVar, stringExtra3, linkedList));
                return;
            }
            aVar.TC(stringExtra4);
            aVar.b(NormalUserFooterPreference.a(this.lXw).field_username, stringExtra3, linkedList);
        } else {
            aVar.b(NormalUserFooterPreference.a(this.lXw).field_username, stringExtra3, linkedList);
        }
    }
}
