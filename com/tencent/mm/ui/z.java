package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.contact.AddressUI.a;
import com.tencent.mm.ui.conversation.j;
import java.util.HashMap;
import java.util.HashSet;

public final class z {
    private static HashMap<String, Integer> tom;
    private final long ell = 180000;
    public int iUy = -1;
    MMFragmentActivity tiY;
    public aa toc = new aa();
    LauncherUI$d tod;
    boolean toe;
    private HashSet<o> tof = new HashSet();
    CustomViewPager tog;
    a toh;
    private int toi = -1;
    private int toj = -1;
    private int tok = -1;
    c tol = new 1(this);
    public HashMap<Integer, x> ton = new HashMap();

    public final x cqx() {
        return (x) this.ton.get(Integer.valueOf(this.iUy));
    }

    public final void cpC() {
        j jVar = (j) this.ton.get(Integer.valueOf(0));
        if (jVar != null) {
            jVar.cxZ();
            jVar.cyZ();
        }
    }

    public final void cqy() {
        j jVar = (j) this.ton.get(Integer.valueOf(0));
        if (jVar != null) {
            jVar.cza();
        }
    }

    public final void eL(int i, int i2) {
        if (i != i2) {
            x DW = DW(i);
            if (DW != null && (DW instanceof o)) {
                ((o) DW).cps();
            }
            DW = DW(i2);
            if (DW != null && (DW instanceof o)) {
                ((o) DW).cpr();
            }
            k.a(this.tiY, 4, i, "deliverOnTabChange");
            k.a(this.tiY, 3, i2, "deliverOnTabChange");
        }
    }

    public final void DU(int i) {
        x DW = DW(i);
        if (DW != null) {
            if (DW instanceof o) {
                ((o) DW).coK();
            }
            this.toh.tot[i] = true;
        }
    }

    public final void cqz() {
        j jVar = (j) this.ton.get(Integer.valueOf(0));
        ViewGroup viewGroup = (ViewGroup) this.tiY.findViewById(R.h.launcher_container);
        if (viewGroup != null) {
            viewGroup.setImportantForAccessibility(4);
        }
        if (jVar != null) {
            jVar.onHiddenChanged(true);
        }
        k.a(this.tiY, 4, this.iUy, "prepareStartChatting");
        cqy();
        this.toc.cqB();
    }

    static {
        HashMap hashMap = new HashMap();
        tom = hashMap;
        hashMap.put("tab_main", Integer.valueOf(0));
        tom.put("tab_address", Integer.valueOf(1));
        tom.put("tab_find_friend", Integer.valueOf(2));
        tom.put("tab_settings", Integer.valueOf(3));
    }

    public final void ZS(String str) {
        if (str != null && !str.equals("")) {
            DV(((Integer) tom.get(str)).intValue());
        }
    }

    public final void DV(int i) {
        String str = "MicroMsg.LauncherUI.MainTabUI";
        String str2 = "change tab to %d, cur tab %d, has init tab %B, tab cache size %d";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(this.iUy);
        objArr[2] = Boolean.valueOf(this.tog != null);
        objArr[3] = Integer.valueOf(this.ton.size());
        x.i(str, str2, objArr);
        if (this.tog != null && i >= 0) {
            if (this.toh != null && i > this.toh.getCount() - 1) {
                return;
            }
            if (this.iUy != i || this.ton.size() == 0) {
                this.iUy = i;
                this.toc.DY(this.iUy);
                if (this.tog != null) {
                    this.tog.k(this.iUy, false);
                    DU(this.iUy);
                }
                if (this.iUy == 0 && g.Eh().dpP.foreground) {
                    au.getNotification().aR(true);
                } else {
                    au.getNotification().aR(false);
                }
            }
        }
    }

    public final x DW(int i) {
        x xVar = null;
        x.d("MicroMsg.LauncherUI.MainTabUI", "get tab %d", new Object[]{Integer.valueOf(i)});
        if (i < 0) {
            return null;
        }
        if (this.ton.containsKey(Integer.valueOf(i))) {
            return (x) this.ton.get(Integer.valueOf(i));
        }
        Bundle bundle = new Bundle();
        switch (i) {
            case 0:
                bundle.putInt(j.class.getName(), 0);
                xVar = (x) Fragment.instantiate(this.tiY, j.class.getName(), bundle);
                au.getNotification().aR(true);
                break;
            case 1:
                bundle.putInt(a.class.getName(), 1);
                bundle.putBoolean("Need_Voice_Search", true);
                bundle.putBoolean("favour_include_biz", true);
                xVar = (x) Fragment.instantiate(this.tiY, a.class.getName(), bundle);
                break;
            case 2:
                bundle.putInt(h.class.getName(), 2);
                xVar = (x) Fragment.instantiate(this.tiY, h.class.getName(), bundle);
                break;
            case 3:
                bundle.putInt(ab.class.getName(), 3);
                xVar = (x) Fragment.instantiate(this.tiY, ab.class.getName(), bundle);
                break;
        }
        x.v("MicroMsg.LauncherUI.MainTabUI", "createFragment index:%d", new Object[]{Integer.valueOf(i)});
        if (xVar != null) {
            xVar.setParent(this.tiY);
        }
        this.ton.put(Integer.valueOf(i), xVar);
        return xVar;
    }

    public final int cqA() {
        aa aaVar = this.toc;
        return (aaVar.tow == null || aaVar.tow.getMainTabUnread() <= 0) ? 0 : aaVar.tow.getMainTabUnread();
    }

    protected final void cqB() {
        this.toc.cqB();
    }

    protected final void cqC() {
        this.toc.cqC();
    }

    protected final void cqD() {
        this.toc.cqD();
    }

    public final int cqE() {
        int b;
        aa aaVar = this.toc;
        long currentTimeMillis = System.currentTimeMillis();
        if (au.HX()) {
            b = t.b(s.dAN, al.cqV());
            x.d("MicroMsg.LauncherUI", "getMainTabUnreadCount  unread : %d", new Object[]{Integer.valueOf(b)});
        } else {
            x.w("MicroMsg.UnreadCountHelper", "getMainTabUnreadCount, but mmcore not ready");
            b = 0;
        }
        aaVar.DX(b);
        x.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "unreadcheck setConversationTagUnread  last time %d, unread %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(b)});
        return b;
    }
}
