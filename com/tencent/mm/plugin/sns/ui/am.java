package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.sdk.platformtools.x;

public final class am {
    public static i a(Context context, s sVar, ViewGroup viewGroup, int i) {
        i iVar = null;
        if (sVar != null) {
            switch (sVar.type) {
                case 21:
                    if (sVar.bID == 2) {
                        return new n(context, (b) sVar, viewGroup);
                    }
                    if (sVar.bID == 6) {
                        return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s(context, (l) sVar, viewGroup);
                    }
                    if (sVar.bID == 7) {
                        return new t(context, (k) sVar, viewGroup);
                    }
                    break;
                case f$k.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                    switch (sVar.bID) {
                        case 0:
                            iVar = new w(context, (p) sVar, viewGroup);
                            break;
                        case 1:
                            iVar = new m(context, (p) sVar, viewGroup);
                            break;
                    }
                    break;
                case f$k.AppCompatTheme_colorPrimary /*82*/:
                    iVar = new h(context, sVar, viewGroup);
                    break;
                case 101:
                    iVar = new o(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n) sVar, viewGroup);
                    break;
                case 102:
                    iVar = new c(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m) sVar, viewGroup);
                    break;
                case 103:
                    r rVar = (r) sVar;
                    rVar.bgColor = i;
                    iVar = new q(context, rVar, viewGroup);
                    break;
                case 104:
                    iVar = new e(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e) sVar, viewGroup);
                    break;
                case 132:
                    iVar = new ab(context, (y) sVar, viewGroup);
                    break;
                default:
                    x.i("SnsAdNativeLandingPagesLayoutHelper", "unknown comp type " + sVar.type);
                    break;
            }
        }
        if (iVar != null) {
            return iVar;
        }
        if (sVar instanceof u) {
            iVar = new aa(context, (u) sVar, viewGroup);
            iVar.setBackgroundColor(i);
            return iVar;
        } else if (sVar instanceof l) {
            iVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l(context, (l) sVar, viewGroup);
            iVar.setBackgroundColor(i);
            return iVar;
        } else if (sVar instanceof p) {
            return new w(context, (p) sVar, viewGroup);
        } else {
            if (sVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o) {
                return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o) sVar, viewGroup);
            }
            if (sVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) {
                return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) sVar, viewGroup);
            }
            if (sVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w) {
                return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w) sVar, viewGroup);
            }
            if (sVar instanceof v) {
                return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p(context, (v) sVar, viewGroup);
            }
            if (sVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h) {
                return new g(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h) sVar, viewGroup);
            }
            if (sVar instanceof d) {
                return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d(context, (d) sVar, viewGroup);
            }
            if (sVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t) {
                return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t) sVar, viewGroup);
            }
            return new i(context, sVar, viewGroup);
        }
    }
}
