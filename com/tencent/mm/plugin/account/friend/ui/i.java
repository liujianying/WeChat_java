package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.a.b;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.protocal.m$b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class i extends ContentObserver implements e {
    private String bTi;
    private boolean dJO = false;
    private ProgressBar eNA;
    private String eNB = null;
    private String[] eNC;
    public boolean eND = true;
    private int eNE;
    private ag eNF = new 1(this);
    private ContentResolver eNn;
    private boolean eNo = false;
    private boolean eNp = false;
    private c eNq = null;
    private final a eNr;
    private x eNs;
    private x eNt;
    private a eNu;
    private a eNv;
    private String eNw;
    private String eNx;
    private boolean eNy = false;
    private View eNz;
    private Context mContext;
    private int progress = 0;

    public i(int i, Context context, a aVar) {
        super(ag.fetchFreeHandler());
        this.eNE = i;
        this.eNy = false;
        this.mContext = context;
        this.eNC = this.mContext.getResources().getStringArray(b.sms_content);
        this.eNz = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(g.progress_dialog_view, null);
        this.eNA = (ProgressBar) this.eNz.findViewById(f.progress_dialog_bar);
        this.eNr = aVar;
    }

    public final void pE(String str) {
        if (this.eNE == b.eNI || this.eNE == b.eNJ) {
            com.tencent.mm.kernel.g.DF().a(132, this);
        } else {
            com.tencent.mm.kernel.g.DF().a(com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX, this);
        }
        this.bTi = str;
        this.eNo = false;
        this.eNp = false;
        this.eNw = "";
        this.dJO = false;
        if (this.eNE == b.eNI || this.eNE == b.eNJ) {
            int i = 1;
            if (this.eNE == b.eNJ) {
                i = 18;
            }
            this.eNt = new x(this.bTi, i, "", 0, "");
            com.tencent.mm.kernel.g.DF().a(this.eNt, 0);
        } else {
            this.eNv = new a(this.bTi, this.eNy ? 8 : 5, "", 0, "");
            com.tencent.mm.kernel.g.DF().a(this.eNv, 0);
        }
        if (this.eNq == null) {
            this.eNq = h.a(this.mContext, false, this.mContext.getString(j.bind_mcontact_verifing), this.eNz, "", "", null, null);
        } else {
            this.eNq.show();
        }
        this.progress = 0;
        this.eNA.setIndeterminate(false);
        this.eNF.sendEmptyMessage(1000);
    }

    public final void recycle() {
        com.tencent.mm.kernel.g.DF().b(132, this);
        com.tencent.mm.kernel.g.DF().b(com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX, this);
        this.mContext = null;
        this.dJO = true;
        if (this.eNq != null) {
            this.eNq.dismiss();
        }
    }

    private boolean y(int i, String str) {
        switch (i) {
            case -214:
                com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
                if (eV != null) {
                    eV.a(this.mContext, null, null);
                }
                return true;
            case -74:
                h.a(this.mContext, j.bind_mcontact_err_BindPhone_NeedAdjust, j.app_tip, null);
                return true;
            case -59:
                h.a(this.mContext, j.bind_mcontact_err_not_suport_country, j.app_tip, null);
                return true;
            case -57:
            case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                Toast.makeText(this.mContext, j.app_err_system_busy_tip, 0).show();
                return true;
            case -43:
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
                this.dJO = true;
                if (b.eNI == this.eNE || this.eNE == b.eNJ) {
                    com.tencent.mm.kernel.g.Ei().DT().set(4097, "");
                    com.tencent.mm.kernel.g.Ei().DT().set(6, this.bTi);
                    ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
                }
                e(1, new Bundle());
                Toast.makeText(this.mContext, j.bind_mcontact_err_binded, 0).show();
                return true;
            case -41:
                Toast.makeText(this.mContext, j.bind_mcontact_err_format, 0).show();
                return true;
            case -36:
                Toast.makeText(this.mContext, j.bind_mcontact_err_unbinded_notbinded, 0).show();
                return true;
            case -35:
                if (this.eNE == b.eNH) {
                    e(3, new Bundle());
                } else {
                    h.a(this.mContext, j.bind_mcontact_err_binded_by_other, j.bind_mcontact_verify_tip, new 2(this));
                }
                return true;
            case -34:
                Toast.makeText(this.mContext, j.bind_mcontact_err_freq_limit, 0).show();
                return true;
            case IX5WebViewClient.ERROR_AUTHENTICATION /*-4*/:
                if (this.eNy) {
                    e(6, new Bundle());
                    return true;
                }
                break;
        }
        return false;
    }

    private void e(int i, Bundle bundle) {
        if (this.eNE == b.eNI || this.eNE == b.eNJ) {
            com.tencent.mm.kernel.g.DF().a(132, this);
        } else {
            com.tencent.mm.kernel.g.DF().a(com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX, this);
        }
        if (this.eNr != null) {
            this.eNr.e(i, bundle);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (!lVar.equals(this.eNs) && !lVar.equals(this.eNt) && !lVar.equals(this.eNu) && !lVar.equals(this.eNv)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
        } else if (!this.dJO) {
            if (i == 1 || i == 2) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SmsBindMobileObserver", "error net");
                if (this.eNq != null) {
                    this.eNq.dismiss();
                }
                e(4, new Bundle());
            } else if (b.eNI == this.eNE && lVar.getType() == 132) {
                e(i, i2, str, lVar);
            } else if (b.eNJ == this.eNE && lVar.getType() == 132) {
                e(i, i2, str, lVar);
            } else if (b.eNH == this.eNE && lVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX) {
                switch (((a) lVar).Oh()) {
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                        if ((((a) lVar).Oh() == 6 || ((a) lVar).Oh() == 9) && this.eNq != null) {
                            this.eNq.dismiss();
                        }
                        int i3 = ((m$b) ((a) lVar).dJM.Id()).qWH.rhH;
                        if ((i == 0 && i2 == 0) || (i2 == -35 && i3 == 1)) {
                            if (((a) lVar).Oh() == 6) {
                                this.eNB = ((a) lVar).Oj();
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SmsBindMobileObserver", "NetSceneBindOpMobileForReg ticket: " + this.eNB);
                                e(1, new Bundle());
                                return;
                            } else if (((a) lVar).Oh() == 9) {
                                this.eNB = ((a) lVar).Oj();
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SmsBindMobileObserver", "NetSceneBindOpMobileForReg ticket: " + this.eNB);
                                ((a) lVar).getUsername();
                                ((a) lVar).Oi();
                                return;
                            } else if (((a) lVar).Oh() == 5 || ((a) lVar).Oh() == 8) {
                                com.tencent.mm.sdk.platformtools.x.v("MicroMsg.SmsBindMobileObserver", "mobile:" + this.bTi);
                                if (((a) lVar).Oh() == 5 && i2 == -35 && i3 == 1) {
                                    this.eNy = true;
                                    e(5, new Bundle());
                                    return;
                                }
                                return;
                            }
                        }
                        if (((a) lVar).Oh() == 6 || ((a) lVar).Oh() == 9) {
                            if (this.eNq != null) {
                                this.eNq.dismiss();
                            }
                            this.dJO = true;
                            e(2, new Bundle());
                            return;
                        } else if (y(i2, str)) {
                            if (this.eNq != null) {
                                this.eNq.dismiss();
                            }
                            this.dJO = true;
                            return;
                        } else {
                            this.dJO = true;
                            if (this.eNq != null) {
                                this.eNq.dismiss();
                            }
                            Toast.makeText(this.mContext, this.mContext.getString(j.bind_mcontact_verify_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                            return;
                        }
                    default:
                        return;
                }
            } else {
                Assert.assertTrue("code path should not be here!", false);
            }
        }
    }

    private void e(int i, int i2, String str, l lVar) {
        switch (((x) lVar).Oh()) {
            case 1:
            case 2:
            case 18:
            case 19:
                if ((((x) lVar).Oh() == 2 || ((x) lVar).Oh() == 19) && this.eNq != null) {
                    this.eNq.dismiss();
                }
                if (i == 0 && i2 == 0) {
                    if (((x) lVar).Oh() == 2 || ((x) lVar).Oh() == 19) {
                        if (this.eND) {
                            ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
                        }
                        Bundle bundle = new Bundle();
                        if (((x) lVar).Oh() == 2) {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SmsBindMobileObserver", "bind mobile check, ticket %s", new Object[]{((x) lVar).Oj()});
                            bundle.putString("setpwd_ticket", ((x) lVar).Oj());
                        }
                        e(1, bundle);
                        return;
                    } else if (((x) lVar).Oh() == 1 || ((x) lVar).Oh() == 18) {
                        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.SmsBindMobileObserver", "mobile:" + this.bTi);
                        return;
                    }
                }
                if (y(i2, str)) {
                    if (this.eNq != null) {
                        this.eNq.dismiss();
                    }
                    this.dJO = true;
                    return;
                } else if (((x) lVar).Oh() == 2) {
                    if (this.eNq != null) {
                        this.eNq.dismiss();
                    }
                    this.dJO = true;
                    e(2, new Bundle());
                    return;
                } else {
                    this.dJO = true;
                    if (this.eNq != null) {
                        this.eNq.dismiss();
                    }
                    com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null) {
                        eV.a(this.mContext, null, null);
                        return;
                    }
                    Toast.makeText(this.mContext, this.mContext.getString(j.bind_mcontact_verify_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    return;
                }
            default:
                return;
        }
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        if (this.mContext instanceof Activity) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SmsBindMobileObserver", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a((Activity) this.mContext, "android.permission.READ_SMS", 128, "", "")), bi.cjd(), this.mContext});
            if (!com.tencent.mm.pluginsdk.permission.a.a((Activity) this.mContext, "android.permission.READ_SMS", 128, "", "")) {
                return;
            }
        }
        Yh();
    }

    public final void Yh() {
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.SmsBindMobileObserver", "sms number:" + this.eNw);
        if (!this.eNo && !this.dJO && !this.eNp) {
            Uri parse = Uri.parse("content://sms/inbox");
            this.eNn = this.mContext.getContentResolver();
            String[] strArr = new String[]{"body", "_id", "date"};
            String Yi = Yi();
            if (Yi != null && !Yi.equals("")) {
                Cursor query;
                try {
                    query = this.eNn.query(parse, strArr, Yi, null, null);
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SmsBindMobileObserver", "get sms failed");
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.SmsBindMobileObserver", e, "", new Object[0]);
                    query = null;
                }
                if (query != null) {
                    int i = -1;
                    long j = 0;
                    while (query.moveToNext()) {
                        long j2 = query.getLong(2);
                        if (j2 > j) {
                            i = query.getPosition();
                            j = j2;
                        }
                    }
                    this.eNx = null;
                    if (i >= 0) {
                        String group;
                        this.eNp = true;
                        query.moveToPosition(i);
                        Matcher matcher = Pattern.compile("\\d{4,8}").matcher(query.getString(query.getColumnIndex("body")));
                        if (matcher.find()) {
                            group = matcher.group();
                        } else {
                            group = null;
                        }
                        this.eNx = group;
                        if (this.eNq != null) {
                            this.eNq.setCancelable(true);
                        }
                        if (this.eNE == b.eNI || this.eNE == b.eNJ) {
                            hp hpVar = new hp();
                            hpVar.bQV.context = this.mContext;
                            com.tencent.mm.sdk.b.a.sFg.m(hpVar);
                            String str = hpVar.bQW.bQX;
                            hq hqVar = new hq();
                            com.tencent.mm.sdk.b.a.sFg.m(hqVar);
                            this.eNs = new x(this.bTi, this.eNE == b.eNJ ? 19 : 2, this.eNx, "", str, hqVar.bQY.bQZ);
                            com.tencent.mm.kernel.g.DF().a(this.eNs, 0);
                        } else {
                            this.eNu = new a(this.bTi, this.eNy ? 9 : 6, this.eNx, 0, "");
                            com.tencent.mm.kernel.g.DF().a(this.eNu, 0);
                        }
                    }
                    query.close();
                }
            }
        }
    }

    private String Yi() {
        String str;
        String str2 = "( ";
        int i = 0;
        while (i < this.eNC.length) {
            if (i == this.eNC.length - 1) {
                str = str2 + " body like \"%" + this.eNC[i] + "%\" ) ";
            } else {
                str = str2 + "body like \"%" + this.eNC[i] + "%\" or ";
            }
            i++;
            str2 = str;
        }
        str = str2 + " and date > " + (System.currentTimeMillis() - 300000) + " ";
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.SmsBindMobileObserver", "sql where:" + str);
        return str;
    }
}
