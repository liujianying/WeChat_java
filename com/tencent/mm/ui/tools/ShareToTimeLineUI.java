package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.e$h;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareToTimeLineUI extends AutoLoginActivity implements e {
    private ProgressDialog eHw = null;
    private Intent intent;
    private Intent uBM;

    protected final boolean bjv() {
        if (au.HW() && !au.Dr()) {
            return false;
        }
        x.w("MicroMsg.ShareToTimeLine", "not login");
        czU();
        return true;
    }

    private void czU() {
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.ShareToTimeLine", "launch : fail, intent is null");
            czy();
            finish();
            return;
        }
        String action = intent.getAction();
        Bundle aq = s.aq(intent);
        if (bi.oW(action)) {
            x.e("MicroMsg.ShareToTimeLine", "launch : fail, action is null");
            czy();
            finish();
            return;
        }
        String j = s.j(intent, e$h.thz);
        String resolveType = getIntent().resolveType(this);
        if (bi.oW(resolveType)) {
            czy();
            finish();
        } else if (!resolveType.contains("image")) {
            czy();
            finish();
        } else if (action.equals("android.intent.action.SEND") && aq != null) {
            x.i("MicroMsg.ShareToTimeLine", "send signal: " + action);
            Parcelable parcelable = aq.getParcelable("android.intent.extra.STREAM");
            if (parcelable != null && (parcelable instanceof Uri)) {
                Uri uri = (Uri) parcelable;
                if (bi.n(uri)) {
                    String h = bi.h(this, uri);
                    if (bi.oW(h)) {
                        action = d.a(getContentResolver(), uri, 2);
                    } else {
                        action = h;
                    }
                    if (bi.oW(action) || !bi.Xh(action)) {
                        if (intent.getBooleanExtra("Ksnsupload_empty_img", false)) {
                            L(action, j, 4);
                            return;
                        }
                        czy();
                        finish();
                        return;
                    } else if (aaY(action)) {
                        L(action, j, 0);
                        return;
                    } else {
                        czy();
                        finish();
                        return;
                    }
                }
                x.e("MicroMsg.ShareToTimeLine", "deal : fail, not accept, %s", new Object[]{uri});
                czy();
                finish();
            } else if (intent.getBooleanExtra("Ksnsupload_empty_img", false)) {
                L(null, j, 4);
            } else {
                czy();
                finish();
            }
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && aq != null && aq.containsKey("android.intent.extra.STREAM")) {
            x.i("MicroMsg.ShareToTimeLine", "send multi: " + action);
            ArrayList aj = aj(aq);
            if (aj == null || aj.size() == 0) {
                czy();
                finish();
                return;
            }
            d(aj, j);
        } else {
            x.e("MicroMsg.ShareToTimeLine", "launch : fail, uri is null");
            czy();
            finish();
        }
    }

    private static boolean aaY(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        boolean b = o.b(str, decodeResultLogger);
        if (b || decodeResultLogger.getDecodeResult() < 2000) {
            return b;
        }
        h.mEJ.k(12712, KVStatHelper.getKVStatString(str, 4, decodeResultLogger));
        return b;
    }

    private ArrayList<String> aj(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("android.intent.extra.STREAM");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            x.e("MicroMsg.ShareToTimeLine", "getParcelableArrayList failed");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) ((Parcelable) it.next());
            if (uri == null || !bi.n(uri) || uri.getScheme() == null) {
                x.e("MicroMsg.ShareToTimeLine", "unaccepted uri: " + uri);
            } else {
                String h = bi.h(this, uri);
                if (!bi.oW(h)) {
                    if (aaY(h)) {
                        x.i("MicroMsg.ShareToTimeLine", "multisend file path: " + h);
                        arrayList.add(h);
                    } else {
                        x.w("MicroMsg.ShareToTimeLine", "not image: " + h);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    private void L(String str, String str2, int i) {
        Intent intent = new Intent();
        List arrayList = new ArrayList();
        if (!bi.oW(str)) {
            intent.putExtra("sns_kemdia_path", str);
            intent.putExtra("KFilterId", -1);
            arrayList.add(str);
        }
        if (!bi.oW(str2)) {
            intent.putExtra(e$h.thz, str2);
        }
        if (i == 4 && bi.oW(str) && !bi.oW(str2)) {
            arrayList.add(str2);
        }
        if (!au.HW() || au.Dr()) {
            if (bi.oW(str)) {
                czy();
            } else {
                intent = new Intent(this, ShareToTimeLineUI.class);
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
                intent.addFlags(32768).addFlags(268435456);
                intent.setType("image/*");
                intent.setAction("android.intent.action.SEND");
                MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(268435456).addFlags(32768), intent);
            }
            finish();
        } else {
            intent.putExtra("K_go_to_SnsTimeLineUI", true);
            intent.putExtra("Ksnsupload_source", 12);
            intent.setClassName(this, "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
            this.uBM = intent;
        }
        l lVar = null;
        switch (i) {
            case 0:
                lVar = new com.tencent.mm.modelsimple.d(1, arrayList, cqk());
                break;
            case 4:
                lVar = new com.tencent.mm.modelsimple.d(5, arrayList, cqk());
                break;
        }
        if (lVar != null) {
            au.DF().a(837, this);
            g.DF().a(lVar, 0);
            showDialog();
        }
    }

    private void d(ArrayList<String> arrayList, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            finish();
            return;
        }
        if (arrayList.size() > 9) {
            arrayList.subList(9, arrayList.size()).clear();
        }
        if (!au.HW() || au.Dr()) {
            Intent intent = new Intent(this, ShareToTimeLineUI.class);
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Uri.fromFile(new File((String) it.next())));
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList2);
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.addFlags(32768).addFlags(268435456);
            intent.setType("image/*");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(268435456).addFlags(32768), intent);
            finish();
        } else {
            Intent intent2 = new Intent();
            intent2.putStringArrayListExtra("sns_kemdia_path_list", arrayList);
            if (!bi.oW(str)) {
                intent2.putExtra(e$h.thz, str);
            }
            intent2.putExtra("K_go_to_SnsTimeLineUI", true);
            intent2.putExtra("Ksnsupload_source", 12);
            intent2.setClassName(this, "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
            this.uBM = intent2;
        }
        com.tencent.mm.modelsimple.d dVar = new com.tencent.mm.modelsimple.d(1, arrayList, cqk());
        au.DF().a(837, this);
        g.DF().a(dVar, 0);
        showDialog();
    }

    protected void onDestroy() {
        au.DF().b(837, this);
        super.onDestroy();
    }

    private void czy() {
        Toast.makeText(this, R.l.shareimg_to_timeline_get_res_fail, 1).show();
    }

    protected final boolean A(Intent intent) {
        return true;
    }

    private void showDialog() {
        getString(R.l.app_tip);
        this.eHw = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_waiting), true, new 1(this));
    }

    protected final void a(a aVar, Intent intent) {
        switch (2.hdM[aVar.ordinal()]) {
            case 1:
                this.intent = intent;
                x.i("MicroMsg.ShareToTimeLine", "now permission = %d", new Object[]{Integer.valueOf(bi.getInt(com.tencent.mm.k.g.AT().getValue("SystemShareControlBitset"), 0))});
                if ((bi.getInt(com.tencent.mm.k.g.AT().getValue("SystemShareControlBitset"), 0) & 2) > 0) {
                    x.e("MicroMsg.ShareToTimeLine", "now allowed to share to friend");
                    finish();
                    return;
                }
                x.i("MicroMsg.ShareToTimeLine", "postLogin, text = %s", new Object[]{s.j(intent, "android.intent.extra.TEXT")});
                if (bi.oW(s.j(intent, "android.intent.extra.TEXT"))) {
                    czU();
                    return;
                }
                String format = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[]{URLEncoder.encode(format)});
                showDialog();
                au.DF().a(1200, this);
                au.DF().a(new aa(format, 15, null), 0);
                return;
            default:
                finish();
                return;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ShareToTimeLine", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        au.DF().b(1200, this);
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
        }
        if (lVar instanceof aa) {
            if (i == 0 && i2 == 0) {
                czU();
                return;
            }
            czy();
        } else if (lVar instanceof com.tencent.mm.modelsimple.d) {
            if (!(i == 0 && i2 == 0)) {
                if (lVar.dJd != null) {
                    ol olVar = (ol) ((b) lVar.dJd).dIE.dIL;
                    if (!(olVar == null || bi.oW(olVar.rsN))) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", olVar.rsN);
                        intent.putExtra("showShare", false);
                        intent.putExtra("show_bottom", false);
                        intent.putExtra("needRedirect", false);
                        com.tencent.mm.bg.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
                    }
                }
            }
            startActivity(this.uBM);
        } else {
            return;
        }
        finish();
    }
}
