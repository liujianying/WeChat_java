package com.tencent.mm.plugin.wallet_core.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.g.a.ac;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a {
    ArrayList<b> pAR = new ArrayList();
    private c pAS = new c<ac>() {
        {
            this.sFo = ac.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            while (a.this.pAR != null && a.this.pAR.size() > 0) {
                b bVar2 = (b) a.this.pAR.remove(0);
                if (bVar2 == null) {
                    break;
                }
                Bankcard bankcard = bVar2.paI;
                ImageView imageView = (ImageView) bVar2.pBd.get();
                if (imageView != null) {
                    String str = (String) imageView.getTag(f.wallet_core_bankcard_logo_helper_tag);
                    if (!bi.oW(str) && ((!q.GS() && str.equals(bankcard.field_bankcardType)) || (q.GS() && str.equals(bankcard.field_bankName)))) {
                        e h = bankcard.pmc == null ? q.GS() ? com.tencent.mm.plugin.wallet_core.d.b.h(imageView.getContext(), bankcard.field_bankName, false) : com.tencent.mm.plugin.wallet_core.d.b.h(imageView.getContext(), bankcard.field_bankcardType, bankcard.bOr()) : bankcard.pmc;
                        a aVar = a.this;
                        if (h == null || bVar2 == null || bVar2.pBd == null || bVar2.pBd.get() == null) {
                            x.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
                        } else {
                            x.d("MicroMsg.BankcardLogoHelper", "setLogo bankLogoUrl = " + h.lCU);
                            imageView = (ImageView) bVar2.pBd.get();
                            if (!bi.oW(h.lCU)) {
                                imageView.post(new AnonymousClass2(bVar2, imageView, y.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(h.lCU))));
                                bVar2.pxL = h.lCU;
                                y.a(bVar2);
                            } else if (h.pmq > 0) {
                                imageView.post(new 3(aVar, imageView, h));
                            } else {
                                x.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
                            }
                        }
                        aVar = a.this;
                        if (!(h == null || bVar2 == null || bVar2.pBe == null || bVar2.pBe.get() == null)) {
                            View view = (View) bVar2.pBe.get();
                            view.post(new 4(aVar, view, h, bVar2));
                        }
                        aVar = a.this;
                        if (!(h == null || bVar2 == null || bVar2.pBe == null || bVar2.pBe.get() == null)) {
                            imageView = (ImageView) bVar2.pBf.get();
                            if (imageView != null) {
                                imageView.post(new 5(aVar, h, imageView, bVar2));
                            }
                        }
                    }
                }
            }
            return true;
        }
    };
    public LinkedList<String> pAT;
    public LinkedList<Bankcard> pAU;

    /* renamed from: com.tencent.mm.plugin.wallet_core.e.a$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ImageView ixr;
        final /* synthetic */ b pAW;
        final /* synthetic */ Bitmap pAX;

        AnonymousClass2(b bVar, ImageView imageView, Bitmap bitmap) {
            this.pAW = bVar;
            this.ixr = imageView;
            this.pAX = bitmap;
        }

        public final void run() {
            Bankcard bankcard = this.pAW.paI;
            String str = (String) this.ixr.getTag(f.wallet_core_bankcard_logo_helper_tag);
            if (bi.oW(str) || ((q.GS() || !str.equals(bankcard.field_bankcardType)) && !(q.GS() && str.equals(bankcard.field_bankName)))) {
                x.d("MicroMsg.BankcardLogoHelper", "not match tag: %s, banktype: %s, iv: %s", new Object[]{str, bankcard.field_bankcardType, this.ixr});
                return;
            }
            this.ixr.setImageBitmap(this.pAX);
        }
    }

    static class b implements com.tencent.mm.platformtools.y.a {
        WeakReference<ImageView> pBd;
        WeakReference<View> pBe = null;
        WeakReference<ImageView> pBf = null;
        boolean pBg = false;
        Bankcard paI;
        String pxL;

        b() {
        }

        public final void m(String str, Bitmap bitmap) {
            boolean z = true;
            x.d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish " + str + ", bitmap = " + (bitmap == null));
            if (TextUtils.isEmpty(this.pxL)) {
                x.e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
            } else if (this.pBd != null) {
                String str2;
                ImageView imageView = (ImageView) this.pBd.get();
                String str3 = "MicroMsg.BankcardLogoHelper";
                String str4 = "onGetPictureFinish done notifyKey %s  bitmap is null? %s iv is null? %s iv tag: %s mBankcardLogoUrl %s, checkTagType: %s";
                Object[] objArr = new Object[6];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(bitmap == null);
                if (imageView != null) {
                    z = false;
                }
                objArr[2] = Boolean.valueOf(z);
                if (imageView == null) {
                    str2 = "";
                } else {
                    str2 = imageView.getTag();
                }
                objArr[3] = str2;
                objArr[4] = this.pxL;
                objArr[5] = Boolean.valueOf(this.pBg);
                x.d(str3, str4, objArr);
                if (imageView != null && str != null && str.equals(this.pxL)) {
                    if (!this.pBg) {
                        imageView.post(new 2(this, imageView, bitmap));
                        imageView.setTag(f.wallet_core_bankcard_logo_helper_tag, null);
                    } else if (imageView.getTag(f.wallet_core_bankcard_logo_helper_tag) != null && this.paI != null && this.paI.field_bankcardType != null) {
                        str2 = (String) imageView.getTag(f.wallet_core_bankcard_logo_helper_tag);
                        if (!bi.oW(str2) && str2.equals(this.paI.field_bankcardType)) {
                            imageView.post(new 1(this, imageView, bitmap));
                            imageView.setTag(f.wallet_core_bankcard_logo_helper_tag, null);
                        }
                    }
                }
            }
        }
    }

    public a() {
        com.tencent.mm.sdk.b.a.sFg.b(this.pAS);
    }

    public final void a(Context context, Bankcard bankcard, ImageView imageView) {
        a(context, bankcard, imageView, null, null);
    }

    public final void a(Bankcard bankcard, ImageView imageView) {
        b bVar = new b();
        bVar.paI = bankcard;
        if (imageView != null) {
            imageView.setTag(f.wallet_core_bankcard_logo_helper_tag, bankcard.field_bankcardType);
            bVar.pBd = new WeakReference(imageView);
        }
        e eVar = bankcard.pmc;
        if (eVar == null || bVar.pBd == null || bVar.pBd.get() == null) {
            x.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
            return;
        }
        x.d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + eVar.lCU);
        ImageView imageView2 = (ImageView) bVar.pBd.get();
        if (!bi.oW(eVar.lCU)) {
            bVar.pxL = eVar.lCU;
            bVar.pBg = true;
            Bitmap a = y.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(eVar.lCU));
            if (a != null) {
                imageView2.setImageBitmap(a);
            }
            y.a(bVar);
        } else if (eVar.pmq > 0) {
            imageView2.post(new 6(this, imageView2, eVar));
        } else {
            x.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
        }
    }

    public final void a(Context context, Bankcard bankcard, ImageView imageView, View view, ImageView imageView2) {
        b bVar = new b();
        bVar.pBg = false;
        bVar.paI = bankcard;
        if (imageView != null) {
            imageView.setTag(f.wallet_core_bankcard_logo_helper_tag, bankcard.field_bankcardType);
            bVar.pBd = new WeakReference(imageView);
        }
        if (view != null) {
            bVar.pBe = new WeakReference(view);
        }
        if (imageView2 != null) {
            bVar.pBf = new WeakReference(imageView2);
        }
        this.pAR.add(bVar);
        String str = q.GS() ? bankcard.field_bankName : bankcard.field_bankcardType;
        if (this.pAT != null && this.pAT.contains(str)) {
            x.i("MicroMsg.BankcardLogoHelper", "waiting resp:" + str);
        } else if (a(context, bankcard)) {
            com.tencent.mm.sdk.b.a.sFg.m(new ac());
        } else {
            if (this.pAU == null) {
                this.pAU = new LinkedList();
            }
            this.pAU.add(bankcard);
            if (this.pAT == null) {
                b(context, this.pAU);
            }
        }
    }

    public final void destory() {
        com.tencent.mm.sdk.b.a.sFg.c(this.pAS);
        if (this.pAR != null) {
            this.pAR.clear();
            this.pAR = null;
        }
    }

    private static boolean a(Context context, Bankcard bankcard) {
        e h;
        if (q.GS()) {
            h = com.tencent.mm.plugin.wallet_core.d.b.h(context, bankcard.field_bankName, false);
        } else {
            h = com.tencent.mm.plugin.wallet_core.d.b.h(context, bankcard.field_bankcardType, bankcard.bOr());
        }
        if (h == null || h.pmt) {
            return false;
        }
        return true;
    }

    public final void b(Context context, List<Bankcard> list) {
        if (list != null && list.size() > 0) {
            int size = list.size();
            this.pAT = new LinkedList();
            for (int i = 0; i < size; i++) {
                Bankcard bankcard = (Bankcard) list.get(i);
                if (bankcard.bOs()) {
                    x.i("MicroMsg.BankcardLogoHelper", "ignore balance");
                } else if (!a(context, bankcard)) {
                    x.i("MicroMsg.BankcardLogoHelper", bankcard.field_bankcardType + "'s url is null or need update");
                    this.pAT.add(bankcard.field_bankcardType);
                }
            }
            if (this.pAT.size() > 0) {
                x.i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
                com.tencent.mm.plugin.wallet_core.c.c cVar = new com.tencent.mm.plugin.wallet_core.c.c(this.pAT);
                g.Ek();
                g.Eh().dpP.a(1650, new 7(this, context));
                g.Ek();
                g.Eh().dpP.a(cVar, 0);
                return;
            }
            x.i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
            com.tencent.mm.sdk.b.a.sFg.m(new ac());
        }
    }
}
