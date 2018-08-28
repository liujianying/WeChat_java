package com.tencent.mm.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.p;
import android.support.v4.view.ViewPager.e;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.c.a;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class z$a extends p implements e, a {
    private int nDh = 0;
    final /* synthetic */ z too;
    private AddressUI.a toq;
    private final WxViewPager tor;
    private boolean tos = false;
    boolean[] tot = new boolean[]{true, false, false, false};

    public z$a(z zVar, FragmentActivity fragmentActivity, WxViewPager wxViewPager) {
        this.too = zVar;
        super(fragmentActivity.getSupportFragmentManager());
        this.tor = wxViewPager;
        this.tor.setAdapter(this);
        this.tor.setOnPageChangeListener(this);
    }

    public final int getCount() {
        return 4;
    }

    public final Fragment V(int i) {
        return this.too.DW(i);
    }

    public final void a(int i, float f, int i2) {
        aa a = z.a(this.too);
        if (a.tow != null) {
            a.tow.h(i, f);
        }
        if (0.0f != f) {
            if (this.toq == null) {
                this.toq = (AddressUI.a) this.too.DW(1);
            }
            this.toq.mg(false);
        } else {
            x.v("MicroMsg.LauncherUI.MainTabUI", "onPageScrolled, position = %d, mLastIndex = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(z.b(this.too))});
            if (-1 == z.b(this.too)) {
                this.too.eL(z.b(this.too), z.c(this.too));
                this.too.DU(i);
            } else {
                ah.A(new 1(this, i));
            }
        }
        if (i2 == 0) {
            for (Integer num : z.anU().values()) {
                if (num.intValue() != i) {
                    eM(num.intValue(), 8);
                } else if (!this.tot[num.intValue()]) {
                    eM(num.intValue(), 0);
                }
            }
            return;
        }
        for (Integer num2 : z.anU().values()) {
            if (!(num2.intValue() == i || this.tot[num2.intValue()])) {
                eM(num2.intValue(), 0);
            }
        }
    }

    private void eM(int i, int i2) {
        if (this.too.DW(i) != null) {
            View findViewById = this.too.DW(i).findViewById(R.h.loading_progress_bar);
            if (findViewById != null) {
                findViewById.setVisibility(i2);
            }
        }
    }

    public final void O(int i) {
        x.d("MicroMsg.LauncherUI.MainTabUI", "on page selected changed to %d", new Object[]{Integer.valueOf(i)});
        x.v("MicroMsg.LauncherUI.MainTabUI", "reportSwitch clickCount:%d, pos:%d", new Object[]{Integer.valueOf(this.nDh), Integer.valueOf(i)});
        if (this.nDh <= 0) {
            switch (i) {
                case 0:
                    h.mEJ.k(10957, "5");
                    break;
                case 1:
                    h.mEJ.k(10957, "6");
                    break;
                case 2:
                    h.mEJ.k(10957, "7");
                    break;
            }
        }
        this.nDh--;
        switch (i) {
            case 0:
                h.mEJ.k(10957, "1");
                break;
            case 1:
                h.mEJ.k(10957, "2");
                break;
            case 2:
                h.mEJ.k(10957, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                break;
            case 3:
                h.mEJ.k(10957, "4");
                break;
        }
        this.tos = false;
        z.a(this.too, z.c(this.too));
        z.b(this.too, i);
        z.a(this.too).DY(i);
        z.d(this.too).supportInvalidateOptionsMenu();
        if (z.b(this.too) == 1 && z.c(this.too) != 1) {
            au.HU();
            c.DT().set(340226, Long.valueOf(System.currentTimeMillis()));
        }
        if (z.c(this.too) == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            au.HU();
            if (currentTimeMillis - ai.d((Long) c.DT().get(340226, null)) >= 180000) {
                ((AddressUI.a) this.too.DW(z.c(this.too))).cyb();
            }
        }
        if (z.c(this.too) == 0) {
            au.getNotification().aR(true);
        } else {
            au.getNotification().aR(false);
        }
    }

    public final void N(int i) {
        x.d("MicroMsg.LauncherUI.MainTabUI", "onPageScrollStateChanged state %d", new Object[]{Integer.valueOf(i)});
        if (i == 0 && this.toq != null) {
            this.toq.mg(true);
            this.toq = null;
        }
    }

    public final void oV(int i) {
        if (i == z.c(this.too)) {
            x.d("MicroMsg.LauncherUI.MainTabUI", "on click same index");
            x DW = this.too.DW(i);
            if (DW instanceof AbstractTabChildActivity.a) {
                ((AbstractTabChildActivity.a) DW).coE();
                return;
            }
            return;
        }
        this.tos = true;
        this.nDh++;
        x.v("MicroMsg.LauncherUI.MainTabUI", "onTabClick count:%d", new Object[]{Integer.valueOf(this.nDh)});
        this.tor.k(i, false);
        if (i == 3) {
            int i2;
            com.tencent.mm.s.c.Cp().aV(262145, 266241);
            com.tencent.mm.s.c.Cp().aV(262156, 266241);
            com.tencent.mm.s.c.Cp().aV(262147, 266241);
            com.tencent.mm.s.c.Cp().aV(262149, 266241);
            com.tencent.mm.s.c.Cp().b(aa.a.sZC, 266241);
            boolean aU = com.tencent.mm.s.c.Cp().aU(262156, 266241);
            h hVar = h.mEJ;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(6);
            if (aU) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = "";
            objArr[3] = "";
            objArr[4] = Integer.valueOf(0);
            hVar.h(14872, objArr);
            g.Ek();
            g.Ei().DT().a(aa.a.sZt, Boolean.valueOf(false));
        }
    }
}
