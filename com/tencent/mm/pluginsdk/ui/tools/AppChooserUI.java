package com.tencent.mm.pluginsdk.ui.tools;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.plugin.downloader.model.l;
import com.tencent.mm.plugin.e.a.d;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class AppChooserUI extends MMActivity {
    private OnDismissListener DJ = new 5(this);
    private PackageManager bgS;
    private String mimeType = null;
    private l qRA = new l() {
        public final void onTaskStarted(long j, String str) {
            AppChooserUI.this.qRu = j;
            g.Ei().DT().set(AppChooserUI.this.a(274560), Long.valueOf(AppChooserUI.this.qRu));
            x.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", new Object[]{String.valueOf(j), str});
        }

        public final void onTaskRemoved(long j) {
            x.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", new Object[]{Long.valueOf(j)});
        }

        public final void b(long j, String str, boolean z) {
            x.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", new Object[]{Long.valueOf(j), str});
            if (!bi.oW(str) && e.cn(str)) {
                g.Ei().DT().set(AppChooserUI.this.a(274560), Long.valueOf(AppChooserUI.this.qRu));
                if (AppChooserUI.this.qRe != null && AppChooserUI.this.qRu == j) {
                    AppChooserUI.this.qRe.qRC = f.qRP;
                    AppChooserUI.this.qRe.notifyDataSetChanged();
                }
            }
        }

        public final void b(long j, int i, boolean z) {
            x.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", new Object[]{Long.valueOf(j)});
            g.Ei().DT().set(AppChooserUI.this.a(274560), Long.valueOf(0));
            if (AppChooserUI.this.qRe != null) {
                AppChooserUI.this.qRe.qRC = f.qRN;
                AppChooserUI.this.qRe.notifyDataSetChanged();
            }
        }

        public final void onTaskPaused(long j) {
            x.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", new Object[]{Long.valueOf(j)});
            g.Ei().DT().set(AppChooserUI.this.a(274560), Long.valueOf(0));
            if (AppChooserUI.this.qRe != null) {
                AppChooserUI.this.qRe.qRC = f.qRN;
                AppChooserUI.this.qRe.notifyDataSetChanged();
            }
        }

        public final void bP(long j) {
        }

        public final void h(long j, String str) {
        }
    };
    a qRe;
    private Intent qRf = null;
    private int qRg;
    private String qRh = null;
    private Bundle qRi = null;
    private r qRj = null;
    private ArrayList<String> qRk = null;
    private c qRl = null;
    private c qRm = new c(this);
    private List<c> qRn;
    private String qRo;
    private int qRp;
    private int qRq;
    private boolean qRr = false;
    private boolean qRs = false;
    private boolean qRt = false;
    private long qRu;
    private e qRv;
    private OnItemClickListener qRw = new 1(this);
    private OnClickListener qRx = new 2(this);
    private OnClickListener qRy = new 3(this);
    private View.OnClickListener qRz = new 4(this);
    private int scene = 0;

    class a extends BaseAdapter {
        List<c> idD = new ArrayList();
        int qRC = f.qRN;

        public a() {
            AppChooserUI.this.bgS = AppChooserUI.this.getPackageManager();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            int i2 = 0;
            c Cu = getItem(i);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(AppChooserUI.this.mController.tml).inflate(Cu.qRI ? d.app_choose_list_recommand_item : d.app_choose_list_item, null);
                b bVar2 = new b(AppChooserUI.this, view);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (Cu.qRH == null) {
                new d(AppChooserUI.this).execute(new c[]{Cu});
            }
            bVar.kbT.setImageDrawable(Cu.qRH);
            bVar.kbU.setText(Cu.qRG);
            if (Cu == null || (!(!Cu.qRI || Cu.oEK || (Cu.qRI && Cu.knb && AppChooserUI.this.qRp >= AppChooserUI.this.qRq)) || Cu.qRJ)) {
                bVar.qRD.setVisibility(0);
                bVar.qRE.setVisibility(8);
                bVar.qRD.setOnClickListener(AppChooserUI.this.qRz);
                if (this.qRC == f.qRN) {
                    if (Cu.qRJ) {
                        bVar.qRD.setText(com.tencent.mm.plugin.e.a.f.app_need_to_update);
                    } else {
                        bVar.qRD.setText(com.tencent.mm.plugin.e.a.f.app_download);
                    }
                    bVar.qRD.setEnabled(true);
                } else if (this.qRC == f.qRO) {
                    bVar.qRD.setText(com.tencent.mm.plugin.e.a.f.app_downloading);
                    bVar.qRD.setEnabled(false);
                } else if (this.qRC == f.qRP) {
                    if (Cu.qRJ) {
                        bVar.qRD.setText(com.tencent.mm.plugin.e.a.f.app_to_update);
                    } else {
                        bVar.qRD.setText(com.tencent.mm.plugin.e.a.f.app_to_install);
                    }
                    bVar.qRD.setEnabled(true);
                }
            } else {
                boolean z;
                bVar.qRD.setVisibility(8);
                bVar.qRE.setVisibility(0);
                RadioButton radioButton = bVar.qRE;
                c c = AppChooserUI.this.qRl;
                if (c instanceof c) {
                    c = c;
                    if (!(c.qRF == null || Cu.qRF == null || !c.qRF.activityInfo.packageName.equals(Cu.qRF.activityInfo.packageName)) || (c.qRI && Cu.qRI)) {
                        z = true;
                        radioButton.setChecked(z);
                    }
                }
                z = false;
                radioButton.setChecked(z);
            }
            if (Cu.qRI) {
                if (AppChooserUI.this.scene == 4) {
                    bVar.kbW.setText(com.tencent.mm.plugin.e.a.f.qq_browser_desc_for_wb);
                } else {
                    bVar.kbW.setText(bi.oV(AppChooserUI.this.qRh));
                }
                TextView textView = bVar.kbW;
                if (bi.oW(AppChooserUI.this.qRh)) {
                    i2 = 8;
                }
                textView.setVisibility(i2);
            } else {
                bVar.kbW.setVisibility(8);
            }
            if (!(AppChooserUI.this.scene == 6 || AppChooserUI.this.qRl == null || !AppChooserUI.this.qRl.equals(Cu))) {
                bVar.qRE.setChecked(true);
            }
            return view;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        /* renamed from: Cu */
        public final c getItem(int i) {
            return this.idD == null ? null : (c) this.idD.get(i);
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            if (getItem(i).qRI) {
                return 1;
            }
            return 0;
        }

        public final int getCount() {
            return this.idD == null ? 0 : this.idD.size();
        }
    }

    public enum f {
        ;

        static {
            qRN = 1;
            qRO = 2;
            qRP = 3;
            qRQ = new int[]{qRN, qRO, qRP};
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        s.cbA();
        s.BE(this.qRg);
        ak.a(getWindow());
        Intent intent = getIntent();
        Parcelable parcelableExtra = intent.getParcelableExtra("targetintent");
        if (parcelableExtra instanceof Intent) {
            this.qRf = (Intent) parcelableExtra;
            CharSequence stringExtra = intent.getStringExtra("title");
            this.qRg = intent.getIntExtra("type", 0);
            this.qRi = intent.getBundleExtra("transferback");
            this.qRk = intent.getStringArrayListExtra("targetwhitelist");
            this.qRs = intent.getBooleanExtra("needupate", false);
            this.mimeType = intent.getStringExtra("mimetype");
            this.scene = intent.getIntExtra("scene", 0);
            if (g.Eg().Dx()) {
                boolean z;
                this.qRo = (String) g.Ei().DT().get(a(274528), "");
                if (!TextUtils.isEmpty(this.qRo) && p.r(this.mController.tml, this.qRo) && (this.qRk == null || this.qRk.isEmpty() || this.qRk.contains(this.qRo))) {
                    Intent intent2 = new Intent(this.qRf);
                    intent2.setPackage(this.qRo);
                    if (bi.k(this, intent2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (!z || this.scene == 6) {
                    boolean z2;
                    this.bgS = getPackageManager();
                    this.qRe = new a();
                    s.cbA();
                    this.qRj = s.v(this.qRg, intent.getBundleExtra("key_recommend_params"));
                    this.qRr = this.qRj.eM(this.mController.tml);
                    this.qRp = ((Integer) g.Ei().DT().get(274496 + this.qRg, Integer.valueOf(0))).intValue();
                    s.cbA();
                    this.qRq = s.BD(this.qRg);
                    x.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", new Object[]{String.valueOf(this.qRr), Integer.valueOf(this.qRp)});
                    this.qRt = !intent.getBooleanExtra("not_show_recommend_app", false);
                    if (this.qRp >= this.qRq) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.qRn = a(this.qRf, cfk(), this.qRk);
                    if (!(z2 || this.qRr)) {
                        g.Ei().DT().set(274496 + this.qRg, Integer.valueOf(this.qRp + 1));
                    }
                    if (this.qRr) {
                        s.cbA();
                        s.BG(this.qRg);
                    } else if (!z2) {
                        s.cbA();
                        s.BF(this.qRg);
                    }
                    if (this.qRn == null || this.qRn.size() != 1 || (cfk() && !this.qRr)) {
                        setTitleVisibility(8);
                        if (this.qRn == null || this.qRn.isEmpty()) {
                            h(4097, null, false);
                            return;
                        }
                        this.qRe.idD = this.qRn;
                        this.qRu = ((Long) g.Ei().DT().get(a(274560), Long.valueOf(0))).longValue();
                        FileDownloadTaskInfo cm = com.tencent.mm.plugin.downloader.model.d.aCU().cm(this.qRu);
                        x.d("MicroMsg.AppChooserUI", "downloadId:" + this.qRu + ", status:" + cm.status);
                        if (3 == cm.status && e.cn(cm.path) && this.qRe != null) {
                            this.qRe.qRC = f.qRP;
                            this.qRe.notifyDataSetChanged();
                        }
                        this.qRv = new e(this, this.mController.tml);
                        e eVar = this.qRv;
                        if (stringExtra != null) {
                            eVar.cZH = stringExtra.toString();
                        } else {
                            eVar.cZH = null;
                        }
                        this.qRv.qRL = this.qRw;
                        this.qRv.qRy = this.qRy;
                        this.qRv.qRM = this.qRx;
                        this.qRv.hAv = this.qRe;
                        this.qRv.DJ = this.DJ;
                        e eVar2 = this.qRv;
                        if (eVar2.qRL != null) {
                            eVar2.qRK.setOnItemClickListener(eVar2.qRL);
                        }
                        if (eVar2.hAv != null) {
                            eVar2.qRK.setAdapter(eVar2.hAv);
                        }
                        eVar2.fad = h.a(eVar2.mContext, true, eVar2.cZH, eVar2.qRK, eVar2.mContext.getString(com.tencent.mm.plugin.e.a.f.app_use_once), eVar2.mContext.getString(com.tencent.mm.plugin.e.a.f.app_use_always), eVar2.qRy, eVar2.qRM, com.tencent.mm.plugin.e.a.a.green_text_color);
                        eVar2.fad.setOnDismissListener(eVar2.DJ);
                        eVar2.fad.show();
                        if (!(this.qRs || !this.qRr || z2)) {
                            this.qRl = this.qRm;
                            this.qRv.kU(true);
                        }
                        com.tencent.mm.plugin.downloader.model.d.aCU();
                        b.a(this.qRA);
                        return;
                    }
                    c cVar = (c) this.qRn.get(0);
                    if (cVar == null) {
                        h(4097, null, false);
                        return;
                    } else if (cVar.qRF != null) {
                        h(-1, cVar.qRF.activityInfo.packageName, false);
                        return;
                    } else {
                        h(4098, null, false);
                        return;
                    }
                }
                h(-1, this.qRo, true);
                return;
            }
            x.e("MicroMsg.AppChooserUI", "acc not ready");
            h(4097, null, false);
            return;
        }
        x.w("ChooseActivity", "Target is not an intent: " + parcelableExtra);
        h(0, null, false);
    }

    protected void onResume() {
        super.onResume();
        if (this.qRs && this.qRf != null && this.qRj.z(this, this.qRf)) {
            x.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
            this.qRs = false;
            this.qRm.qRJ = false;
        }
        this.qRr = this.qRj.eM(this.mController.tml);
        this.qRn = a(this.qRf, cfk(), this.qRk);
        if (this.qRr && this.qRl == null) {
            this.qRl = this.qRm;
            this.qRv.kU(true);
        }
        if (this.qRe != null) {
            this.qRe.idD = this.qRn;
            this.qRe.notifyDataSetChanged();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.downloader.model.d.aCU();
        b.b(this.qRA);
        if (this.qRv != null) {
            this.qRv.fad.dismiss();
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onBackPressed() {
        super.onBackPressed();
        h(0, null, false);
    }

    /* renamed from: Ct */
    final int a(int i) {
        if (this.mimeType != null) {
            return (this.qRg + i) + this.mimeType.hashCode();
        }
        return this.qRg + i;
    }

    private void h(int i, String str, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("selectpkg", str);
        intent.putExtra("isalways", z);
        intent.putExtra("transferback", this.qRi);
        setResult(i, intent);
        finish();
    }

    private boolean cfk() {
        x.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", new Object[]{Boolean.valueOf(this.qRt), Integer.valueOf(this.qRp), Integer.valueOf(this.qRq), Boolean.valueOf(bi.fU(this))});
        if (!this.qRt || this.qRp >= this.qRq || bi.fU(this) || com.tencent.mm.sdk.platformtools.e.bxk == 1) {
            return false;
        }
        return true;
    }

    private List<c> a(Intent intent, boolean z, ArrayList<String> arrayList) {
        List<c> arrayList2 = new ArrayList();
        List queryIntentActivities = this.bgS.queryIntentActivities(intent, 65536);
        com.tencent.mm.pluginsdk.model.s.a cbr = this.qRj.cbr();
        if (!bi.oW(cbr.qzr)) {
            this.qRh = cbr.qzr;
        } else if (cbr.qzq > 0) {
            this.qRh = getResources().getString(cbr.qzq);
        }
        if (cbr.qzp > 0) {
            this.qRm.qRH = getResources().getDrawable(cbr.qzp);
        }
        if (cbr.qzs > 0) {
            this.qRm.qRG = getResources().getString(cbr.qzs);
        } else {
            this.qRm.qRG = cbr.qzt;
        }
        this.qRm.qRI = true;
        this.qRm.oEK = this.qRr;
        if (this.qRr) {
            this.qRm.knb = true;
        }
        if (this.qRs) {
            this.qRm.qRJ = true;
        }
        Object obj = null;
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            int size = queryIntentActivities.size();
            int i = 0;
            while (i < size) {
                Object obj2;
                x.d("MicroMsg.AppChooserUI", "cpan name:%s", new Object[]{((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name});
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                if (resolveInfo != null) {
                    String str = resolveInfo.activityInfo.packageName;
                    if (arrayList == null || arrayList.isEmpty() || arrayList.contains(str)) {
                        if (this.qRj.SK(str)) {
                            this.qRm.qRF = resolveInfo;
                            this.qRm.knb = true;
                            if ((!z && this.qRr) || (!z && this.qRm.knb)) {
                                arrayList2.add(0, this.qRm);
                                obj2 = 1;
                                i++;
                                obj = obj2;
                            }
                        } else {
                            arrayList2.add(new c(this, resolveInfo, this.qRj.a(this.mController.tml, resolveInfo)));
                        }
                    }
                }
                obj2 = obj;
                i++;
                obj = obj2;
            }
        }
        if (z && obj == null) {
            if (this.qRg != 0 || this.mimeType == null) {
                arrayList2.add(0, this.qRm);
            } else {
                arrayList2.add(0, this.qRm);
                if (this.qRs) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11168, new Object[]{Integer.valueOf(2), Integer.valueOf(this.scene)});
                } else {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11168, new Object[]{Integer.valueOf(1), Integer.valueOf(this.scene)});
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            c cVar = (c) arrayList2.get(size2);
            if (cVar.qRF != null) {
                String str2 = cVar.qRF.activityInfo.packageName;
                if (!(bi.oW(str2) || hashSet.add(str2))) {
                    arrayList2.remove(size2);
                }
            }
        }
        return arrayList2;
    }

    private static Drawable a(Resources resources, int i) {
        try {
            return com.tencent.mm.bq.a.b(resources, i);
        } catch (NotFoundException e) {
            return null;
        }
    }

    private Drawable c(ResolveInfo resolveInfo) {
        try {
            Drawable a;
            if (!(resolveInfo.resolvePackageName == null || resolveInfo.icon == 0)) {
                a = a(this.bgS.getResourcesForApplication(resolveInfo.resolvePackageName), resolveInfo.icon);
                if (a != null) {
                    return a;
                }
            }
            int iconResource = resolveInfo.getIconResource();
            if (iconResource != 0) {
                a = a(this.bgS.getResourcesForApplication(resolveInfo.activityInfo.packageName), iconResource);
                if (a != null) {
                    return a;
                }
            }
        } catch (NameNotFoundException e) {
            x.e("MicroMsg.AppChooserUI", "Couldn't find resources for package", new Object[]{e});
        }
        return resolveInfo.loadIcon(this.bgS);
    }
}
