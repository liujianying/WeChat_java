package com.tencent.mm.plugin.account.friend.ui;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.a.o;
import com.tencent.mm.aa.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.a.e;
import com.tencent.mm.plugin.account.a.i;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.ui.d.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f extends d {
    private final int GG;
    private final MMActivity bGc;
    private String eIs;
    private a eMD;
    boolean eML = false;
    private a eMM = new a() {
        public final void d(int i, String str, int i2) {
            x.d("MicroMsg.QQFriendAdapterCaseB", "[cpan] postion:%d qq:%s status:%d", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
            ao aoVar = (ao) f.this.getItem(i);
            if (aoVar == null) {
                x.e("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend is null. qq:%s", new Object[]{str});
                return;
            }
            x.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[]{aoVar.toString()});
            if (aoVar.eLx == 1) {
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(f.this.bGc, new 1(this));
                aVar.eNh = aoVar.eLw;
                aVar.qIe = false;
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(12));
                if (bi.oW(aoVar.getUsername())) {
                    x.w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
                    return;
                }
                aVar.b(aoVar.getUsername(), linkedList, true);
                aoVar.dHO = 1;
                ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(aoVar.eLw, aoVar);
                f.this.WT();
            }
        }
    };

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        ao aoVar = (ao) obj;
        if (aoVar == null) {
            aoVar = new ao();
        }
        aoVar.d(cursor);
        return aoVar;
    }

    public f(MMActivity mMActivity, int i) {
        super(mMActivity, new ao());
        this.bGc = mMActivity;
        this.GG = i;
        this.eML = mMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
        lB(true);
    }

    public final void a(a aVar) {
        this.eMD = aVar;
    }

    public final void pi(String str) {
        this.eIs = bi.oU(str.trim());
        aYc();
        WT();
    }

    protected final void WS() {
        WT();
    }

    public final void WT() {
        aYc();
        if (bi.oW(this.eIs)) {
            setCursor(((ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).z(this.GG, this.eML));
        } else {
            setCursor(((ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).c(this.GG, this.eIs, this.eML));
        }
        if (!(this.eMD == null || this.eIs == null)) {
            this.eMD.ja(getCursor().getCount());
        }
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        ao aoVar = (ao) getItem(i);
        if (view == null) {
            view = View.inflate(this.bGc, com.tencent.mm.plugin.account.a.g.friend_list_item, null);
            b bVar2 = new b(this, view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.eIy = i;
        bVar.account = aoVar.eLw;
        bVar.status = aoVar.eLx;
        bVar.eIH.setText(j.a(this.bGc, aoVar.getDisplayName(), bVar.eIH.getTextSize()));
        bVar.eII.setText(j.a(this.bGc, aoVar.wO(), bVar.eII.getTextSize()));
        if (this.eML) {
            Bitmap aY;
            if (o.cx(bVar.account) != 0) {
                aY = c.aY(aoVar.eLw);
            } else {
                aY = null;
            }
            if (aY == null) {
                bVar.eBM.setImageDrawable(com.tencent.mm.bp.a.f(this.bGc, i.default_avatar));
            } else {
                bVar.eBM.setImageBitmap(aY);
            }
        } else {
            b.a(bVar.eBM, aoVar.getUsername());
        }
        if (!this.eML) {
            switch (aoVar.eLx) {
                case 1:
                case 2:
                    if (!((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yc(aoVar.getUsername()) && !q.GF().equals(aoVar.getUsername())) {
                        if (aoVar.dHO != 2) {
                            bVar.eIA.setClickable(true);
                            bVar.eIA.setBackgroundResource(e.btn_solid_green);
                            bVar.eBR.setText(com.tencent.mm.plugin.account.a.j.friend_add);
                            bVar.eBR.setTextColor(this.bGc.getResources().getColor(com.tencent.mm.plugin.account.a.c.white));
                            break;
                        }
                        bVar.eIA.setClickable(false);
                        bVar.eIA.setBackgroundDrawable(null);
                        bVar.eBR.setText(com.tencent.mm.plugin.account.a.j.friend_waiting_ask);
                        bVar.eBR.setTextColor(this.bGc.getResources().getColor(com.tencent.mm.plugin.account.a.c.lightgrey));
                        break;
                    }
                    bVar.eIA.setClickable(false);
                    bVar.eIA.setBackgroundDrawable(null);
                    bVar.eBR.setText(com.tencent.mm.plugin.account.a.j.friend_added);
                    bVar.eBR.setTextColor(this.bGc.getResources().getColor(com.tencent.mm.plugin.account.a.c.lightgrey));
                    break;
                    break;
            }
            switch (aoVar.dHO) {
                case 0:
                case 2:
                    bVar.eBR.setVisibility(0);
                    bVar.eIJ.setVisibility(4);
                    break;
                case 1:
                    bVar.eBR.setVisibility(4);
                    bVar.eIJ.setVisibility(0);
                    break;
            }
        }
        bVar.eIA.setVisibility(8);
        ao aoVar2 = (ao) getItem(i - 1);
        int i2 = aoVar2 == null ? -1 : aoVar2.dHN;
        String str = "MicroMsg.QQFriendAdapterCaseB";
        String str2 = "qq friend pre:%s";
        Object[] objArr = new Object[1];
        objArr[0] = aoVar2 != null ? aoVar2.toString() : "";
        x.d(str, str2, objArr);
        str = "MicroMsg.QQFriendAdapterCaseB";
        str2 = "qq friend:%s";
        objArr = new Object[1];
        objArr[0] = aoVar != null ? aoVar.toString() : "";
        x.d(str, str2, objArr);
        if (i == 0) {
            CharSequence b = b(aoVar);
            if (bi.oW(b)) {
                x.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[]{aoVar.getUsername(), Integer.valueOf(i)});
                bVar.eIG.setVisibility(8);
            } else {
                bVar.eIG.setVisibility(0);
                bVar.eIG.setText(b);
                bVar.eIG.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        } else {
            boolean z;
            if (aoVar.dHN != i2) {
                z = true;
            } else {
                z = false;
            }
            CharSequence b2 = b(aoVar);
            if (bi.oW(b2) || !z) {
                x.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[]{aoVar.getUsername(), Integer.valueOf(i)});
                bVar.eIG.setVisibility(8);
            } else {
                bVar.eIG.setVisibility(0);
                bVar.eIG.setText(b2);
                bVar.eIG.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        return view;
    }

    private static String b(ao aoVar) {
        if (aoVar.dHN == 123) {
            return "#";
        }
        return String.valueOf((char) aoVar.dHN);
    }

    public final void jX(String str) {
    }
}
