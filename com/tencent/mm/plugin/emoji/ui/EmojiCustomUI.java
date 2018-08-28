package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ak.a.c.d;
import com.tencent.mm.ak.a.c.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.HeaderGridView;
import com.tencent.mm.ui.base.HeaderGridView.b;
import com.tencent.mm.ui.base.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class EmojiCustomUI extends MMActivity implements OnItemClickListener, e {
    private l dYr = new 16(this);
    private ProgressDialog eEX;
    private OnClickListener ilA = new 11(this);
    private OnClickListener ilB = new 12(this);
    private final a ilC = new 13(this);
    private final c ilD = new 14(this);
    private d ilE = new d() {
        public final byte[] h(Object... objArr) {
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj != null && (obj instanceof EmojiInfo)) {
                    return com.tencent.mm.plugin.emoji.e.e.aDM().a((EmojiInfo) obj);
                }
            }
            return null;
        }
    };
    private EmojiInfo ilF;
    private int ilk = c.ilR;
    private b ill;
    private HeaderGridView ilm;
    private View iln;
    private Button ilo;
    private Button ilp;
    private com.tencent.mm.plugin.emoji.sync.a.a ilq = com.tencent.mm.plugin.emoji.sync.a.a.ijf;
    private View ilr;
    private TextView ils;
    private Button ilt;
    private boolean ilu = false;
    private boolean ilv = false;
    private boolean ilw = false;
    private a ilx = a.ilN;
    private ArrayList<String> ily = new ArrayList();
    private OnClickListener ilz = new 1(this);
    private ag mHandler = new 17(this);

    static /* synthetic */ void d(EmojiCustomUI emojiCustomUI) {
        String str = "MicroMsg.emoji.EmojiCustomUI";
        String str2 = "topCustom mSelectedList size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(emojiCustomUI.ily == null ? 0 : emojiCustomUI.ily.size());
        x.i(str, str2, objArr);
        if (emojiCustomUI.ily == null || emojiCustomUI.ily.size() <= 0) {
            x.w("MicroMsg.emoji.EmojiCustomUI", "empty seleted list");
            return;
        }
        emojiCustomUI.zM(emojiCustomUI.getString(R.l.emoji_top_loading));
        ArrayList arrayList = emojiCustomUI.ily;
        str2 = "MicroMsg.emoji.EmojiCustomUI";
        String str3 = "topSyncEmoji list size:%d";
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        x.i(str2, str3, objArr2);
        if (arrayList == null || arrayList.size() <= 0) {
            x.i("MicroMsg.emoji.EmojiCustomUI", "empty size.");
        } else {
            au.DF().a(new com.tencent.mm.plugin.emoji.f.c(3, emojiCustomUI.ily), 0);
        }
    }

    static /* synthetic */ void g(EmojiCustomUI emojiCustomUI) {
        x.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateSyncView status:%s]", new Object[]{emojiCustomUI.ilq.toString()});
        if (emojiCustomUI.ilk != c.ilS && !emojiCustomUI.ilv) {
            switch (10.ilJ[emojiCustomUI.ilq.ordinal()]) {
                case 1:
                    emojiCustomUI.ilw = false;
                    emojiCustomUI.enableOptionMenu(0, true);
                    emojiCustomUI.aFH();
                    emojiCustomUI.oN(c.ilR);
                    return;
                case 2:
                    emojiCustomUI.enableOptionMenu(0, false);
                    i.aEx();
                    if (BKGLoaderManager.aDK()) {
                        emojiCustomUI.ilw = false;
                        emojiCustomUI.ilr.setVisibility(0);
                        emojiCustomUI.a(a.ilM);
                        emojiCustomUI.ek(true);
                    } else {
                        i.aEx();
                        if (BKGLoaderManager.aEY() && !emojiCustomUI.ilw) {
                            emojiCustomUI.ilw = true;
                            emojiCustomUI.aFH();
                            emojiCustomUI.a(a.ilN);
                        }
                    }
                    if (emojiCustomUI.ilk != c.ilT) {
                        emojiCustomUI.oN(c.ilT);
                        return;
                    }
                    return;
                case 3:
                    emojiCustomUI.ilw = false;
                    emojiCustomUI.enableOptionMenu(0, false);
                    if (emojiCustomUI.mHandler != null) {
                        emojiCustomUI.mHandler.removeMessages(1003);
                    }
                    emojiCustomUI.ilr.setVisibility(0);
                    emojiCustomUI.ek(false);
                    emojiCustomUI.a(a.ilL);
                    emojiCustomUI.oN(c.ilU);
                    return;
                case 4:
                    emojiCustomUI.ilw = false;
                    emojiCustomUI.enableOptionMenu(0, false);
                    emojiCustomUI.aFH();
                    emojiCustomUI.oN(c.ilU);
                    return;
                case 5:
                    emojiCustomUI.ilw = false;
                    emojiCustomUI.enableOptionMenu(0, true);
                    emojiCustomUI.ilr.setVisibility(0);
                    int cnK = i.aEA().igx.cnK();
                    int i = i.aEx().ije.ijp;
                    emojiCustomUI.ils.setText(R.l.emoji_sync_sdcard_full);
                    emojiCustomUI.ils.setText(String.format(emojiCustomUI.getString(R.l.emoji_sync_sdcard_full), new Object[]{Integer.valueOf(i - cnK), Integer.valueOf(i)}));
                    emojiCustomUI.ilt.setVisibility(4);
                    emojiCustomUI.oN(c.ilU);
                    return;
                case 6:
                    emojiCustomUI.ilw = false;
                    emojiCustomUI.enableOptionMenu(0, true);
                    emojiCustomUI.aFH();
                    emojiCustomUI.oN(c.ilR);
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void j(EmojiCustomUI emojiCustomUI) {
        String str = "MicroMsg.emoji.EmojiCustomUI";
        String str2 = "deleteEmoji mSelectedList size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(emojiCustomUI.ily == null ? 0 : emojiCustomUI.ily.size());
        x.i(str, str2, objArr);
        if (emojiCustomUI.ily == null || emojiCustomUI.ily.size() <= 0) {
            x.w("MicroMsg.emoji.EmojiCustomUI", "empty seleted list");
            return;
        }
        emojiCustomUI.zM(emojiCustomUI.getString(R.l.emoji_delete_loading));
        ArrayList arrayList = emojiCustomUI.ily;
        str2 = "MicroMsg.emoji.EmojiCustomUI";
        String str3 = "deleteSyncEmoji list size:%d";
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        x.i(str2, str3, objArr2);
        if (arrayList == null || arrayList.size() <= 0) {
            x.i("MicroMsg.emoji.EmojiCustomUI", "empty size.");
        } else {
            au.DF().a(new com.tencent.mm.plugin.emoji.f.c(2, emojiCustomUI.ily), 0);
        }
        x.i("MicroMsg.emoji.EmojiCustomUI", "touchBatchEmojiBackup over emoji size. need touch :%b", new Object[]{Boolean.valueOf(emojiCustomUI.ilu)});
        if (emojiCustomUI.ilu) {
            emojiCustomUI.ilu = false;
            au.HU();
            com.tencent.mm.model.c.DT().set(348162, Boolean.valueOf(true));
            com.tencent.mm.plugin.emoji.c.a.aDH();
        }
        emojiCustomUI.aFI();
    }

    private void a(a aVar) {
        x.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateButtonType,button type:%s]", new Object[]{aVar.toString()});
        this.ilx = aVar;
        switch (10.ilI[aVar.ordinal()]) {
            case 1:
                this.ilt.setVisibility(4);
                return;
            case 2:
                this.ilt.setVisibility(0);
                this.ilt.setText(R.l.emoji_sync_start_sync);
                return;
            case 3:
                this.ilt.setVisibility(0);
                this.ilt.setText(R.l.emoji_sync_stop_sync);
                return;
            default:
                return;
        }
    }

    private void ek(boolean z) {
        int cnK = i.aEA().igx.cnK();
        int i = i.aEx().ije.ijp;
        if (cnK != i || z) {
            int i2;
            if (i == 0) {
                i2 = cnK;
            } else {
                i2 = 0;
            }
            i += i2;
            this.ils.setText(String.format(getString(z ? R.l.emoji_sync_syncing_not_in_wifi : R.l.emoji_sync_pause_not_in_wifi), new Object[]{Integer.valueOf(i - cnK), Integer.valueOf(i)}));
            return;
        }
        this.ils.setText(R.l.emoji_sync_sync_start_not_in_wifi);
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        this.ill = new b(this);
        this.ill.aFM();
        initView();
        i.aEx().ej(true);
        oN(c.ilR);
        au.HU();
        x.i("MicroMsg.emoji.EmojiCustomUI", "[cpan] touch batch emoji download from EmojiCustomUI needDownload:%b", new Object[]{Boolean.valueOf(((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sOY, Boolean.valueOf(true))).booleanValue())});
        if (((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sOY, Boolean.valueOf(true))).booleanValue()) {
            au.DF().a(new com.tencent.mm.plugin.emoji.f.e(), 0);
        }
        i.aEA().igx.c(this.ilC);
        h.mEJ.a(406, 9, 1, false);
        h.mEJ.a(406, 11, System.currentTimeMillis() - currentTimeMillis, false);
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.plugin.emoji.sync.a aEx = i.aEx();
        c cVar = this.ilD;
        BKGLoaderManager bKGLoaderManager = aEx.ije;
        if (bKGLoaderManager.ijD == null) {
            bKGLoaderManager.ijD = new HashSet();
        }
        if (!bKGLoaderManager.ijD.contains(cVar)) {
            bKGLoaderManager.ijD.add(cVar);
        }
        aFI();
        au.DF().a(698, this);
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.plugin.emoji.sync.a aEx = i.aEx();
        c cVar = this.ilD;
        BKGLoaderManager bKGLoaderManager = aEx.ije;
        if (bKGLoaderManager.ijD == null) {
            bKGLoaderManager.ijD = new HashSet();
        }
        if (bKGLoaderManager.ijD.contains(cVar)) {
            bKGLoaderManager.ijD.remove(cVar);
        }
        au.DF().b(698, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        i.aEA().igx.d(this.ilC);
        i.aEx().ej(false);
        BKGLoaderManager bKGLoaderManager = i.aEx().ije;
        if (bKGLoaderManager.ijv) {
            bKGLoaderManager.ijv = false;
        }
    }

    protected final int getLayoutId() {
        return R.i.emoji_custom;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final void initView() {
        this.ilr = getLayoutInflater().inflate(R.i.emoji_custom_header, null);
        this.ils = (TextView) this.ilr.findViewById(R.h.sync_status);
        this.ilt = (Button) this.ilr.findViewById(R.h.sync_action_btn);
        this.ilt.setOnClickListener(this.ilz);
        this.ilm = (HeaderGridView) findViewById(R.h.settings_emoticons_custom_grid);
        HeaderGridView headerGridView = this.ilm;
        View view = this.ilr;
        ListAdapter adapter = headerGridView.getAdapter();
        if (adapter == null || (adapter instanceof HeaderGridView$c)) {
            HeaderGridView.a aVar = new HeaderGridView.a((byte) 0);
            b bVar = new b(headerGridView, headerGridView.getContext());
            bVar.addView(view);
            aVar.view = view;
            aVar.tsv = bVar;
            aVar.data = null;
            aVar.isSelectable = false;
            headerGridView.tsu.add(aVar);
            if (adapter != null) {
                ((HeaderGridView$c) adapter).mDataSetObservable.notifyChanged();
            }
            this.ilm.setAdapter$159aa965(this.ill);
            this.ilm.setOnItemClickListener(this);
            this.ilm.setFocusableInTouchMode(false);
            this.iln = findViewById(R.h.settings_emoticons_custom_footer);
            this.ilo = (Button) findViewById(R.h.settings_emoticons_delete);
            this.ilo.setOnClickListener(this.ilA);
            this.ilp = (Button) findViewById(R.h.settings_emoticons_top);
            this.ilp.setOnClickListener(this.ilB);
            return;
        }
        throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.ill != null) {
            int headerViewCount = i - (this.ilm.getHeaderViewCount() * 5);
            if (this.ilk == c.ilR && headerViewCount == this.ill.aFL()) {
                au.HU();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    if (this.ill.aFL() >= n.aEj()) {
                        com.tencent.mm.ui.base.h.a(this, getString(R.l.emoji_upper_limit_warning), "", new 18(this));
                    } else {
                        com.tencent.mm.pluginsdk.ui.tools.l.P(this);
                    }
                    h.mEJ.h(11596, new Object[]{Integer.valueOf(0)});
                } else {
                    s.gH(this);
                    return;
                }
            }
            if (this.ilk == c.ilS && headerViewCount < this.ill.aFL()) {
                EmojiInfo oO = this.ill.oO(headerViewCount);
                d dVar = null;
                if (view != null) {
                    dVar = (d) view.getTag();
                }
                String Xh;
                if (oO.field_catalog == EmojiGroupInfo.tcz) {
                    com.tencent.mm.ui.base.h.i(this.mController.tml, R.l.chatting_can_not_del_sys_smiley, R.l.chatting_can_not_del_sys_smiley).show();
                } else if (this.ily.contains(oO.Xh())) {
                    Xh = oO.Xh();
                    if (this.ily != null) {
                        this.ily.remove(Xh);
                    }
                    if (dVar != null) {
                        dVar.ilY.setChecked(false);
                        this.ill.notifyDataSetChanged();
                    }
                    x.i("MicroMsg.emoji.EmojiCustomUI", "unselected md5:%s", new Object[]{oO.Xh()});
                } else {
                    Xh = oO.Xh();
                    if (this.ily != null) {
                        this.ily.add(Xh);
                    }
                    if (dVar != null) {
                        dVar.ilY.setChecked(true);
                    }
                    x.i("MicroMsg.emoji.EmojiCustomUI", "selected md5:%s", new Object[]{oO.Xh()});
                }
                aFG();
                if (dVar == null) {
                    this.ill.notifyDataSetChanged();
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: requestCode[%d],resultCode:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 205:
                    if (intent != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 3);
                        au.HU();
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.model.c.Gg());
                        com.tencent.mm.plugin.emoji.b.ezn.a(intent2, 206, this, intent);
                        return;
                    }
                    return;
                case 206:
                    if (intent == null) {
                        x.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult MAT_IMAGE_IN_CROP_ACTIVITY return null.");
                        return;
                    }
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    int intExtra = intent.getIntExtra("emoji_type", 0);
                    if (stringExtra != null && stringExtra.length() > 0) {
                        stringExtra = stringExtra.substring(stringExtra.lastIndexOf(47) + 1);
                        StringBuilder stringBuilder = new StringBuilder();
                        au.HU();
                        String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.Gg()).append(stringExtra).toString();
                        this.ilF = i.aEA().igx.Zy(stringExtra);
                        com.tencent.mm.ui.tools.a.b abg = com.tencent.mm.ui.tools.a.b.abg(stringBuilder2);
                        abg.fi = com.tencent.mm.k.b.Ay();
                        abg.Gh(com.tencent.mm.k.b.Az()).a(new 2(this, intExtra, stringExtra));
                        return;
                    }
                    return;
                case 214:
                    if (this.ill != null) {
                        this.ill.aFM();
                        this.ill.notifyDataSetChanged();
                        return;
                    }
                    return;
                default:
                    x.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: not found this requestCode");
                    return;
            }
        }
    }

    public void onBackPressed() {
        if (this.ilk == c.ilS) {
            oN(c.ilR);
        } else {
            super.onBackPressed();
        }
    }

    private void oN(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        this.ilk = i;
        switch (10.ilK[i - 1]) {
            case 1:
                setBackBtn(new 3(this));
                enableBackMenu(true);
                addTextOptionMenu(0, getString(R.l.emoji_store_custom_mgr), new 4(this));
                this.iln.setVisibility(8);
                aFI();
                aFE();
                break;
            case 2:
                setBackBtn(new 5(this));
                addTextOptionMenu(0, getString(R.l.app_finish), new 6(this));
                this.iln.setVisibility(0);
                aFH();
                aFG();
                break;
            case 3:
                aFF();
                break;
            case 4:
                break;
        }
        aFF();
        if (this.ill != null) {
            this.ill.aFM();
            this.ill.notifyDataSetChanged();
        }
        x.d("MicroMsg.emoji.EmojiCustomUI", "updateMode use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    private void aFE() {
        if (this.ily != null) {
            this.ily.clear();
        }
        x.i("MicroMsg.emoji.EmojiCustomUI", "clear md5 list. updateMode NORMAL");
    }

    private void aFF() {
        this.iln.setVisibility(this.ilk == c.ilS ? 0 : 8);
    }

    private void aFG() {
        if (this.ilk == c.ilS) {
            if ((this.ily == null ? 0 : this.ily.size()) > 0) {
                this.ilo.setText(getResources().getString(R.l.app_delete));
                this.ilo.setEnabled(true);
                this.ilp.setEnabled(true);
            } else {
                this.ilo.setText(getResources().getString(R.l.app_delete));
                this.ilo.setEnabled(false);
                this.ilp.setEnabled(false);
            }
            setMMTitle(getResources().getString(R.l.emoji_select_count, new Object[]{Integer.valueOf(r0)}));
        }
    }

    private boolean zL(String str) {
        String str2 = str;
        com.tencent.mm.ui.base.h.a(this.mController.tml, str2, "", "", getString(R.l.i_know_it), null, null);
        return true;
    }

    private void aFH() {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(1003, 0);
        }
    }

    private void aFI() {
        boolean z = true;
        i.aEx();
        if (ao.isConnected(ad.getContext())) {
            if (this.ill == null || this.ill.aFL() <= n.aEj()) {
                z = false;
            } else {
                this.ilu = true;
                this.ilr.setVisibility(0);
                int i = R.l.emoji_sync_delete_emoji;
                this.ils.setTextColor(getResources().getColor(R.e.red));
                this.ils.setText(getString(i, new Object[]{Integer.valueOf(n.aEj())}));
                this.ilt.setVisibility(8);
                this.ill.notifyDataSetChanged();
                enableOptionMenu(0, true);
                this.ilv = true;
            }
            if (!z) {
                this.ilv = false;
                return;
            }
            return;
        }
        aFH();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.emoji.EmojiCustomUI", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (lVar instanceof com.tencent.mm.plugin.emoji.f.c) {
            switch (((com.tencent.mm.plugin.emoji.f.c) lVar).eKI) {
                case 2:
                    aFs();
                    if (i == 0 && i2 == 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < this.ily.size()) {
                                x.i("MicroMsg.emoji.EmojiCustomUI", "mSelectedList md5:%s", new Object[]{this.ily.get(i4)});
                                h.mEJ.k(10613, (String) this.ily.get(i4));
                                i3 = i4 + 1;
                            } else {
                                com.tencent.mm.plugin.emoji.sync.a aEx = i.aEx();
                                ArrayList arrayList = this.ily;
                                BKGLoaderManager bKGLoaderManager = aEx.ije;
                                String str2 = "MicroMsg.BKGLoader.BKGLoaderManager";
                                String str3 = "cleanUploadTasks size%s";
                                Object[] objArr = new Object[1];
                                objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
                                x.i(str2, str3, objArr);
                                if (bKGLoaderManager.ijB != null && arrayList != null && bKGLoaderManager.ijB.size() > 0 && arrayList.size() > 0) {
                                    com.tencent.mm.plugin.emoji.sync.d dVar;
                                    ArrayList arrayList2 = new ArrayList();
                                    Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        String str4 = (String) it.next();
                                        if (!bi.oW(str4)) {
                                            Iterator it2 = bKGLoaderManager.ijB.iterator();
                                            while (it2.hasNext()) {
                                                dVar = (com.tencent.mm.plugin.emoji.sync.d) it2.next();
                                                if (!bi.oW(dVar.getKey()) && dVar.getKey().equalsIgnoreCase(str4)) {
                                                    arrayList2.add(dVar);
                                                }
                                            }
                                        }
                                    }
                                    if (bKGLoaderManager.ijB != null && bKGLoaderManager.ijB.size() > 0 && arrayList2.size() > 0) {
                                        Iterator it3 = arrayList2.iterator();
                                        while (it3.hasNext()) {
                                            bKGLoaderManager.ijB.remove((com.tencent.mm.plugin.emoji.sync.d) it3.next());
                                            x.i("MicroMsg.BKGLoader.BKGLoaderManager", "clean upload task :%s", new Object[]{dVar.getKey()});
                                        }
                                    }
                                    arrayList2.clear();
                                }
                                i.aEA().igx.dt(this.ily);
                                aFE();
                                aFG();
                                this.mHandler.sendEmptyMessageDelayed(1004, 100);
                                return;
                            }
                        }
                    }
                    x.i("MicroMsg.emoji.EmojiCustomUI", "delete failed");
                    zL(getString(R.l.emoji_top_failed));
                    return;
                    break;
                case 3:
                    aFs();
                    if (i == 0 && i2 == 0) {
                        i.aEA().igx.du(this.ily);
                        aFE();
                        aFG();
                        this.mHandler.sendEmptyMessageDelayed(1004, 100);
                        return;
                    }
                    zL(getString(R.l.emoji_top_failed));
                    return;
                default:
                    return;
            }
        }
        x.w("MicroMsg.emoji.EmojiCustomUI", "no emoji operate");
    }

    private void zM(String str) {
        getString(R.l.app_tip);
        this.eEX = com.tencent.mm.ui.base.h.a(this, str, true, new 9(this));
    }

    private void aFs() {
        if (this.eEX != null && this.eEX.isShowing()) {
            this.eEX.dismiss();
        }
    }
}
