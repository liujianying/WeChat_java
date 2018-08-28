package com.tencent.mm.plugin.emoji.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.c;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;

public final class h {
    private final String TAG = "MicroMsg.emoji.PayOrDownloadComponent";
    public Context gKE;
    public boolean ihA = false;
    public Fragment ihB;
    public int ihC;
    public long ihD = 0;
    public String ihE = "";
    public b ihF;
    private String ihG;
    private b ihH = new b(2003);
    public String ihI;
    public a ihz;
    private Context rc = ad.getContext();

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        if (aVar != null && aVar.icY != null && this.ihz != null && this.ihz.ien != null) {
            ts tsVar = aVar.icY.iez;
            if (tsVar != null) {
                String str;
                String str2 = tsVar.rem;
                String str3 = tsVar.rwQ;
                String str4 = tsVar.rxb;
                String str5 = tsVar.rxc;
                int aDp = aVar.aDp();
                (aVar.icY == null ? null : Integer.valueOf(aVar.icY.ieB)).intValue();
                c cVar = this.ihz.ien;
                boolean z = cVar.iew;
                boolean z2 = aVar.icY.ieD;
                String str6 = "MicroMsg.emoji.PayOrDownloadComponent";
                String str7 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
                Object[] objArr = new Object[3];
                objArr[0] = str2;
                if (TextUtils.isEmpty(str4)) {
                    str = "";
                } else {
                    str = str4;
                }
                objArr[1] = str;
                objArr[2] = Integer.valueOf(aDp);
                x.i(str6, str7, objArr);
                this.ihG = str2;
                int i;
                ao zd;
                switch (aDp) {
                    case -1:
                        if (e.a(tsVar)) {
                            i = 3;
                        } else if (e.b(tsVar) || (!z && TextUtils.isEmpty(tsVar.rwT))) {
                            i = 3;
                        } else if (z) {
                            zd = cVar.zd(str2);
                            if (TextUtils.isEmpty(zd.taY)) {
                                i = zd.taW;
                            } else {
                                i = 4;
                            }
                        } else {
                            i = 4;
                        }
                        this.ihz.be(str2, i);
                        return;
                    case 0:
                        if (this.ihz != null) {
                            this.ihz.be(str2, 3);
                            return;
                        }
                        return;
                    case 3:
                    case 5:
                        if (com.tencent.mm.plugin.emoji.h.a.d(tsVar)) {
                            com.tencent.mm.plugin.emoji.f.a.aEF();
                            com.tencent.mm.plugin.emoji.f.a.aEG();
                            return;
                        }
                        M(str2, null, str3);
                        if (this.ihz != null) {
                            this.ihz.bf(str2, 0);
                        }
                        x.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{str2});
                        com.tencent.mm.plugin.report.service.h.mEJ.h(12066, new Object[]{Integer.valueOf(0), Integer.valueOf(this.ihC), "", str2, Long.valueOf(this.ihD), this.ihE});
                        return;
                    case 4:
                    case 12:
                        if (!this.ihA) {
                            Intent intent = new Intent();
                            intent.putExtra("key_product_id", str2);
                            if (z) {
                                intent.putExtra("key_currency_type", "");
                                intent.putExtra("key_price", str4);
                            } else {
                                intent.putExtra("key_currency_type", str5);
                                intent.putExtra("key_price", str4);
                            }
                            d.b(this.gKE, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                            this.ihA = true;
                            com.tencent.mm.plugin.report.service.h.mEJ.h(12066, new Object[]{Integer.valueOf(2), Integer.valueOf(this.ihC), "", str2, Long.valueOf(this.ihD), this.ihE});
                            return;
                        }
                        return;
                    case 7:
                        if (z2) {
                            if ((this.ihB != null ? 1 : null) != null) {
                                b bVar = this.ihH;
                                Fragment fragment = this.ihB;
                                x.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
                                Intent intent2 = new Intent();
                                intent2.putExtra("MMActivity.OverrideEnterAnimation", R.a.fast_faded_in);
                                intent2.putExtra("MMActivity.OverrideExitAnimation", R.a.push_down_out);
                                d.a(fragment, ".ui.transmit.SelectConversationUI", intent2, bVar.guC);
                                fragment.getActivity().overridePendingTransition(R.a.push_up_in, R.a.fast_faded_out);
                            } else {
                                this.ihH.p((Activity) this.gKE);
                            }
                            this.ihH.ist = str2;
                            com.tencent.mm.plugin.report.service.h.mEJ.h(12069, new Object[]{Integer.valueOf(1), str2});
                            return;
                        } else if (aVar.icY.ieF) {
                            str4 = aVar.icY.iez.rem;
                            String str8 = aVar.icY.iez.rwQ;
                            str2 = this.ihI;
                            if (this.gKE != null) {
                                i = this.ihC == 9 ? 3 : 4;
                                Intent intent3 = new Intent();
                                intent3.setClass(this.gKE, EmojiStoreV2RewardUI.class);
                                intent3.putExtra("extra_id", str4);
                                intent3.putExtra("extra_name", str8);
                                intent3.putExtra("name", str2);
                                intent3.putExtra("scene", this.ihC);
                                intent3.putExtra("pageType", i);
                                intent3.putExtra("searchID", this.ihD);
                                this.gKE.startActivity(intent3);
                                com.tencent.mm.plugin.report.service.h.mEJ.h(12738, new Object[]{str4, Integer.valueOf(i), Integer.valueOf(this.ihC), Integer.valueOf(0)});
                                return;
                            }
                            x.i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
                            return;
                        } else {
                            return;
                        }
                    case 9:
                        au.DF().a(new q(str2, 2), 0);
                        return;
                    case 10:
                        zd = cVar.zd(str2);
                        if (zd != null) {
                            switch (zd.taX) {
                                case 10233:
                                    str = getString(R.l.emoji_no_on_sale);
                                    break;
                                case 10234:
                                    str = getString(R.l.emoji_google_no_install);
                                    break;
                                case 10235:
                                    str = getString(R.l.emoji_timeout);
                                    break;
                                default:
                                    str = getString(R.l.emoji_unknow);
                                    break;
                            }
                            com.tencent.mm.ui.base.h.b(this.gKE, str, null, true);
                            return;
                        }
                        return;
                    case 11:
                        x.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] cannot action when loading.");
                        return;
                    default:
                        x.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] unkonw product status");
                        return;
                }
            }
        }
    }

    private void M(String str, String str2, String str3) {
        if (this.ihF != null) {
            this.ihF.M(str, str2, str3);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        String str = "";
        int i3 = 0;
        if (intent != null) {
            i3 = intent.getIntExtra("key_err_code", 0);
            x.w("MicroMsg.emoji.PayOrDownloadComponent", "errCode:" + i3);
            str = intent.getStringExtra("key_err_msg");
            x.w("MicroMsg.emoji.PayOrDownloadComponent", "errMsg:" + str);
        }
        String str2 = str;
        this.ihA = false;
        if (i2 == -1) {
            switch (i) {
                case 2001:
                    if (this.ihz != null && this.ihz.ien != null) {
                        if (intent != null && i3 == 0) {
                            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                            ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_response_series_ids");
                            Object obj = null;
                            int size = stringArrayListExtra.size();
                            int i4 = 0;
                            while (i4 < size) {
                                String str3 = (String) stringArrayListExtra.get(i4);
                                str = (String) stringArrayListExtra2.get(i4);
                                ao zd = this.ihz.ien.zd(str3);
                                if (this.ihG.equals(str3)) {
                                    obj = 1;
                                    M(str3, str, zd.ioy);
                                    this.ihz.bf(this.ihG, 0);
                                    com.tencent.mm.ui.base.h.bA(this.gKE, str2);
                                    x.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{str3});
                                    if (stringArrayListExtra.size() > 1) {
                                        x.i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
                                        if (this.ihF != null) {
                                            this.ihF.aEs();
                                        }
                                    }
                                } else {
                                    this.ihz.be(this.ihG, 5);
                                }
                                i4++;
                                obj = obj;
                            }
                            if (obj == null) {
                                zE(str2);
                            }
                            if (com.tencent.mm.model.q.GR()) {
                                com.tencent.mm.plugin.report.service.h.mEJ.a(166, 4, 1, false);
                                return;
                            } else {
                                com.tencent.mm.plugin.report.service.h.mEJ.a(166, 0, 1, false);
                                return;
                            }
                        } else if (intent != null && i3 == 100000002) {
                            M(this.ihG, null, this.ihz.ien.zd(this.ihG).ioy);
                            this.ihz.bf(this.ihG, 0);
                            x.i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{this.ihG});
                            zE(str2);
                            if (com.tencent.mm.model.q.GR()) {
                                com.tencent.mm.plugin.report.service.h.mEJ.a(166, 7, 1, false);
                                return;
                            } else {
                                com.tencent.mm.plugin.report.service.h.mEJ.a(166, 3, 1, false);
                                return;
                            }
                        } else if (intent == null || i3 != 1) {
                            if (!(this.ihG == null || this.ihz == null || this.ihz.ien == null)) {
                                this.ihz.ien.zb(this.ihG);
                                com.tencent.mm.plugin.emoji.a.a yZ = this.ihz.yZ(this.ihG);
                                if (yZ != null) {
                                    yZ.aDu();
                                }
                            }
                            zE(str2);
                            if (com.tencent.mm.model.q.GR()) {
                                com.tencent.mm.plugin.report.service.h.mEJ.a(166, 5, 1, false);
                            } else {
                                com.tencent.mm.plugin.report.service.h.mEJ.a(166, 1, 1, false);
                            }
                            x.i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", new Object[]{str2});
                            return;
                        } else {
                            if (com.tencent.mm.model.q.GR()) {
                                com.tencent.mm.plugin.report.service.h.mEJ.a(166, 6, 1, false);
                            } else {
                                com.tencent.mm.plugin.report.service.h.mEJ.a(166, 2, 1, false);
                            }
                            x.i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
                            return;
                        }
                    }
                    return;
                case 2003:
                    str = this.ihH.ist;
                    if (!bi.oW(str)) {
                        b.a(intent, str, (Activity) this.gKE);
                        com.tencent.mm.plugin.report.service.h.mEJ.h(12069, new Object[]{Integer.valueOf(3), str});
                        return;
                    }
                    return;
                default:
                    x.e("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult unknow request");
                    return;
            }
        } else if (i != 2001) {
        } else {
            if (com.tencent.mm.model.q.GR()) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(166, 6, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.mEJ.a(166, 2, 1, false);
            }
        }
    }

    private void zE(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.l.emoji_play_failed);
        }
        com.tencent.mm.ui.base.h.a(this.gKE, str, "", new 1(this));
    }

    private String getString(int i) {
        return this.rc.getString(i);
    }
}
