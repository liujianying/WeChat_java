package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h$a;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.h.3;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.m.d;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.h;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMImageView;
import java.util.Iterator;

public class FavoriteFileDetailUI extends BaseFavDetailReportUI implements p, a {
    private long bJA;
    private vx bOz;
    private boolean bUY = true;
    private ag dvh;
    private TextView eMe;
    private ProgressBar eVR;
    private TextView gmo;
    private f hEl = null;
    private g iWQ;
    private k jaf = new k();
    private Button jcf;
    private Button jcg;
    private Button jch;
    private MMImageView jci;
    private TextView jcj;
    private View jck;
    private View jcl;
    private TextView jcm;
    private ImageView jcn;
    private TextView jco;
    private boolean jcp = false;
    private boolean jcq = false;
    private String jcr;
    private String jcs;
    private boolean jct = false;
    private boolean jcu = false;
    private boolean jcv = false;

    static /* synthetic */ void k(FavoriteFileDetailUI favoriteFileDetailUI) {
        String nX = t.nX(b.b(favoriteFileDetailUI.bOz));
        x.i("MicroMsg.FavoriteFileDetailUI", "%d save video now video path %s out path %s", new Object[]{Integer.valueOf(favoriteFileDetailUI.hashCode()), r0, nX});
        if (bi.oW(nX)) {
            Toast.makeText(favoriteFileDetailUI, favoriteFileDetailUI.getString(i.video_file_save_failed), 1).show();
            return;
        }
        Toast.makeText(favoriteFileDetailUI, favoriteFileDetailUI.getString(i.video_file_saved, new Object[]{nX}), 1).show();
        l.a(nX, favoriteFileDetailUI);
    }

    static /* synthetic */ void o(FavoriteFileDetailUI favoriteFileDetailUI) {
        if (favoriteFileDetailUI.getType() == 8 && b.f(favoriteFileDetailUI.bOz) && b.g(favoriteFileDetailUI.bOz)) {
            h$a h_a = favoriteFileDetailUI.jcb;
            h_a.iVM++;
            y yVar = (y) com.tencent.mm.kernel.g.l(y.class);
            ActionBarActivity actionBarActivity = favoriteFileDetailUI.mController.tml;
            g gVar = favoriteFileDetailUI.iWQ;
            wn wnVar = new wn();
            wnVar.scene = favoriteFileDetailUI.jcb.scene;
            wnVar.iVT = favoriteFileDetailUI.jcb.iVT;
            wnVar.index = favoriteFileDetailUI.jcb.index;
            yVar.a(actionBarActivity, gVar, wnVar);
        }
    }

    protected final int getLayoutId() {
        return m.f.favorite_download_detail_ui;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private void aMJ() {
        this.jcs = getIntent().getStringExtra("key_detail_data_id");
        Iterator it = this.iWQ.field_favProto.rBI.iterator();
        while (it.hasNext()) {
            vx vxVar = (vx) it.next();
            if (vxVar.jdM.equals(this.jcs)) {
                this.bOz = vxVar;
                break;
            }
        }
        if (this.bOz == null) {
            this.bOz = b.c(this.iWQ);
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        this.dvh = new ag();
        this.bJA = getIntent().getLongExtra("key_detail_info_id", -1);
        this.jcq = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
        this.bUY = getIntent().getBooleanExtra("show_share", true);
        this.jcr = getIntent().getStringExtra("fav_note_xml");
        this.iWQ = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(this.bJA);
        if (this.jcq && !bi.oW(this.jcr)) {
            this.iWQ = b.Bf(this.jcr);
        }
        if (this.iWQ == null) {
            x.w("MicroMsg.FavoriteFileDetailUI", "error, cannot find download info");
            finish();
            return;
        }
        String string;
        F(this.iWQ);
        com.tencent.mm.plugin.fav.a.m.w(this.iWQ);
        aMJ();
        this.jcf = (Button) findViewById(e.preview_btn);
        this.jcg = (Button) findViewById(e.open_btn);
        this.jch = (Button) findViewById(e.download_btn);
        this.jci = (MMImageView) findViewById(e.icon_iv);
        this.eMe = (TextView) findViewById(e.name_tv);
        this.gmo = (TextView) findViewById(e.tips_tv);
        this.jcl = findViewById(e.download_stop_btn);
        this.jck = findViewById(e.download_progress_area);
        this.eVR = (ProgressBar) findViewById(e.download_pb);
        this.jcj = (TextView) findViewById(e.download_progress_tips);
        this.jcm = (TextView) findViewById(e.show_ad_sight);
        this.jcn = (ImageView) findViewById(e.fav_file_illegal_image);
        this.jco = (TextView) findViewById(e.fav_file_illegal_tv);
        int type = getType();
        if (4 == type) {
            setMMTitle(i.favorite_video);
        } else if (15 == type) {
            setMMTitle(i.favorite_video);
            findViewById(e.video_container).setBackgroundResource(m.b.black);
            this.eMe.setVisibility(8);
        } else {
            setMMTitle(i.favorite_file);
        }
        if (this.bOz.bjS == 4) {
            this.jci.setImageResource(h.app_attach_file_icon_video);
        } else {
            this.jci.setImageResource(((ab) com.tencent.mm.kernel.g.l(ab.class)).Bu(this.bOz.rzD));
        }
        this.eMe.setText(this.bOz.title);
        wa waVar = this.bOz.rAo;
        if (waVar == null) {
            this.jcm.setVisibility(8);
        } else if (bi.oW(waVar.dyJ)) {
            x.i("MicroMsg.FavoriteFileDetailUI", " there is no attachurl, show more info btn");
            CharSequence charSequence = waVar.dyM;
            String str = waVar.dyN;
            if (bi.oW(charSequence) || bi.oW(str)) {
                this.jcm.setVisibility(8);
            } else {
                this.jcm.setText(charSequence);
                this.jcm.setVisibility(0);
                this.jcm.setOnClickListener(new 1(this, str));
            }
        } else {
            string = getResources().getString(i.sns_ad_sight_full);
            if (waVar.rBq / 60 > 0) {
                string = string + getResources().getString(i.sns_ad_sight_full_m, new Object[]{Integer.valueOf(waVar.rBq / 60)});
            }
            if (waVar.rBq % 60 > 0) {
                string = string + getResources().getString(i.sns_ad_sight_full_s, new Object[]{Integer.valueOf(waVar.rBq % 60)});
            }
            this.jcm.setText(string + getResources().getString(i.sns_ad_sight_full_end));
            this.jcm.setVisibility(0);
            this.jcm.setOnClickListener(new 7(this));
        }
        setBackBtn(new 8(this));
        this.jcg.setOnClickListener(new 9(this));
        string = this.bOz.rzv;
        if (!bi.oW(string)) {
            this.jcf.setOnClickListener(new 10(this, string));
        }
        this.jch.setOnClickListener(new 11(this));
        this.jcl.setOnClickListener(new 12(this));
        if (this.bUY) {
            boolean z2;
            boolean booleanExtra = getIntent().getBooleanExtra("key_detail_can_delete", true);
            int type2 = getType();
            if (type2 == 8) {
                z = this.iWQ.aLd();
            } else if (type2 == 15) {
                z2 = this.iWQ.aLd() && bi.WU(com.tencent.mm.k.g.AT().getValue("SIGHTCannotTransmitForFav")) == 0;
                if (z2 || booleanExtra) {
                    addIconOptionMenu(0, i.top_item_desc_more, d.mm_title_btn_menu, new 13(this, z2, booleanExtra, type2));
                }
            } else if (!(this.iWQ.aLe() || this.iWQ.aLd())) {
                z = false;
            }
            z2 = z;
            addIconOptionMenu(0, i.top_item_desc_more, d.mm_title_btn_menu, new 13(this, z2, booleanExtra, type2));
        }
        eV(false);
    }

    private int getType() {
        if (this.bOz == null) {
            x.w("MicroMsg.FavoriteFileDetailUI", "get type but data item is null");
            return 8;
        } else if (this.bOz.bjS == 0) {
            x.w("MicroMsg.FavoriteFileDetailUI", "get data type, but data item type is 0, info type %d", new Object[]{Integer.valueOf(this.iWQ.field_type)});
            if (4 == this.iWQ.field_type) {
                return 4;
            }
            if (16 != this.iWQ.field_type) {
                return 8;
            }
            if (!(this.bOz == null || this.bOz.rAo == null)) {
                if (!bi.oW(this.bOz.rAo.dyJ)) {
                    return 15;
                }
                if (!bi.oW(this.bOz.rAo.dyN)) {
                    return 15;
                }
            }
            return 4;
        } else if (this.bOz.bjS != 15) {
            return this.bOz.bjS;
        } else {
            if (!(this.bOz == null || this.bOz.rAo == null)) {
                if (!bi.oW(this.bOz.rAo.dyJ)) {
                    return 15;
                }
                if (!bi.oW(this.bOz.rAo.dyN)) {
                    return 15;
                }
            }
            return 4;
        }
    }

    private void eV(boolean z) {
        boolean f = b.f(this.bOz);
        x.i("MicroMsg.FavoriteFileDetailUI", "init status, info type %d, exist:%B path:%s", new Object[]{Integer.valueOf(this.iWQ.field_itemStatus), Boolean.valueOf(f), b.b(this.bOz)});
        if (this.bOz.rAw != 0) {
            aMK();
        } else if (this.iWQ.isDone() || f || !bi.oW(this.bOz.rzo)) {
            if (f) {
                if (!(getType() != 15 || this.bOz.rAo == null || bi.oW(this.bOz.rAo.dyJ) || bi.oW(this.bOz.rAo.dyN))) {
                    this.jcu = true;
                    this.jci.setVisibility(8);
                    this.jck.setVisibility(8);
                    this.jch.setVisibility(8);
                    this.jcf.setVisibility(8);
                    this.jcg.setVisibility(8);
                    this.gmo.setVisibility(8);
                    String b = b.b(this.bOz);
                    x.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.Ab() + " initView: fullpath:" + b);
                    ViewGroup viewGroup = (ViewGroup) findViewById(e.video_container);
                    this.hEl = o.fb(this.mController.tml);
                    LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(13);
                    viewGroup.addView((View) this.hEl, 0, layoutParams);
                    this.hEl.setVideoCallback(new 14(this));
                    x.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.Ab() + " initView :" + b);
                    if (b != null) {
                        this.hEl.stop();
                        this.hEl.setVideoPath(b);
                    }
                    x.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.Ab() + " initView");
                    com.tencent.mm.an.b.PW();
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11444, new Object[]{Integer.valueOf(4)});
                }
                if (getType() != 15 && getType() != 4) {
                    f = b.f(this.bOz) && b.g(this.bOz);
                    if (f) {
                        this.jck.setVisibility(8);
                        this.jch.setVisibility(8);
                        this.jcf.setVisibility(0);
                        this.jcg.setVisibility(8);
                        this.gmo.setVisibility(8);
                        this.jcf.setOnClickListener(new 2(this));
                    } else {
                        this.jck.setVisibility(8);
                        this.jch.setVisibility(8);
                        if (bi.oW(this.bOz.rzv)) {
                            this.jcf.setVisibility(8);
                        } else {
                            this.jcf.setVisibility(0);
                        }
                        this.jcg.setVisibility(0);
                        this.jcb.iVL = true;
                        this.gmo.setVisibility(0);
                    }
                } else if (!this.jcu) {
                    this.jck.setVisibility(8);
                    this.jch.setVisibility(8);
                    this.jcf.setVisibility(8);
                    this.jcg.setVisibility(0);
                    this.jcg.setText(i.favorite_item_preview);
                    this.gmo.setVisibility(8);
                    aMN();
                }
                com.tencent.mm.kernel.g.Em().H(new 3(this));
            } else if (bi.oW(this.bOz.rzo)) {
                aMK();
            } else {
                x.w("MicroMsg.FavoriteFileDetailUI", "? info is done, source file not exist, cdn data url is not null");
                aMM();
            }
        } else if (this.iWQ.aLh()) {
            if (bi.oW(this.bOz.rzo)) {
                aMK();
                if (z) {
                    int type = getType();
                    type = (4 == type || 15 == type) ? i.favorite_record_video_error : i.favorite_record_file_error;
                    com.tencent.mm.ui.base.h.bA(this.mController.tml, getString(type));
                    return;
                }
                return;
            }
            aMM();
            if (z) {
                com.tencent.mm.ui.base.h.bA(this.mController.tml, getString(i.download_fail));
            }
        } else if (this.iWQ.aLg()) {
            aMM();
            if (z) {
                com.tencent.mm.ui.base.h.bA(this.mController.tml, getString(i.fav_upload_fail));
            }
        } else if (this.iWQ.isDownloading() || this.iWQ.aLf()) {
            aML();
        } else {
            x.w("MicroMsg.FavoriteFileDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
            aMM();
        }
    }

    private void aMK() {
        this.jci.setVisibility(8);
        this.eMe.setVisibility(8);
        this.jch.setVisibility(8);
        this.jcf.setVisibility(8);
        this.jcg.setVisibility(8);
        this.jck.setVisibility(8);
        this.gmo.setVisibility(8);
        this.jcn.setVisibility(0);
        this.jco.setVisibility(0);
        if (this.bOz.bjS == 4) {
            this.gmo.setGravity(17);
            this.gmo.setText(i.favorite_out_of_date_video);
            return;
        }
        this.gmo.setGravity(17);
        this.gmo.setText(i.favorite_out_of_date_file);
        if (this.bOz.rAw == 2) {
            this.jco.setText(i.favorite_detail_illegal_big_file);
        } else {
            this.jco.setText(i.favorite_detail_illegal_expired_file);
        }
    }

    private void aML() {
        int progress;
        int i;
        int i2;
        this.jch.setVisibility(8);
        this.jcf.setVisibility(8);
        this.jcg.setVisibility(8);
        this.gmo.setVisibility(8);
        this.jck.setVisibility(0);
        c Br = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(this.bOz.jdM);
        if (Br != null) {
            progress = (int) Br.getProgress();
            i = Br.field_offset;
            i2 = Br.field_totalLen;
        } else {
            i2 = (int) this.bOz.rzJ;
            i = 0;
            progress = 0;
        }
        if (this.iWQ.aLf() && bi.oW(this.bOz.rzo)) {
            b((float) progress, getString(i.favorite_uploading, new Object[]{b.aj((float) i), b.aj((float) i2)}));
            return;
        }
        b((float) progress, getString(i.favorite_downloading, new Object[]{b.aj((float) i), b.aj((float) i2)}));
    }

    private void aMM() {
        this.jck.setVisibility(8);
        this.jcg.setVisibility(8);
        if (bi.oW(this.bOz.rzv)) {
            this.jcf.setVisibility(8);
        } else {
            this.jcf.setVisibility(0);
        }
        this.jch.setVisibility(0);
        c Br = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(this.bOz.jdM);
        if (Br == null || Br.field_offset <= 0) {
            this.jch.setText(this.iWQ.aLg() ? i.favorite_item_upload : i.favorite_item_download);
        } else {
            this.jch.setText(this.iWQ.aLg() ? i.favorite_item_restart_upload : i.favorite_item_restart_download);
        }
        this.gmo.setVisibility(8);
    }

    protected void onDestroy() {
        setResult(0, getIntent().putExtra("key_activity_browse_time", cql()));
        if (this.hEl != null) {
            this.hEl.setVideoCallback(null);
            this.hEl.stop();
            this.hEl.onDetach();
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().c(this);
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().a(this);
        if (this.hEl != null) {
            this.hEl.start();
        }
    }

    protected void onPause() {
        super.onPause();
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().d(this);
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().b(this);
        if (this.hEl != null) {
            this.hEl.stop();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ((ab) com.tencent.mm.kernel.g.l(ab.class)).a(this, i, i2, intent, i.no_match_application_msg, i.no_match_application_title);
        if (i2 == -1 && i == 1) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            com.tencent.mm.ui.base.p a = com.tencent.mm.ui.base.h.a(this.mController.tml, getString(i.favorite_forward_tips), false, null);
            x.d("MicroMsg.FavoriteFileDetailUI", "do share msg, fav msg type %d", new Object[]{Integer.valueOf(getType())});
            4 4 = new 4(this, a);
            int type = getType();
            if (!bi.oW(stringExtra)) {
                for (String str2 : bi.F(stringExtra.split(","))) {
                    if (type == 4 || type == 15) {
                        ActionBarActivity actionBarActivity = this.mController.tml;
                        vx vxVar = this.bOz;
                        if (actionBarActivity == null) {
                            x.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
                        } else if (bi.oW(str2)) {
                            x.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
                        } else if (vxVar == null) {
                            x.w("MicroMsg.FavSendLogic", "want to send fav video, but dataItem is null");
                        } else {
                            com.tencent.mm.kernel.g.Em().H(new 3(vxVar, actionBarActivity, str2, 4));
                        }
                        boolean fq = s.fq(str2);
                        com.tencent.mm.plugin.fav.a.m.a(fq ? com.tencent.mm.plugin.fav.a.m.c.iWy : com.tencent.mm.plugin.fav.a.m.c.iWx, this.iWQ, com.tencent.mm.plugin.fav.a.m.d.iWC, fq ? com.tencent.mm.model.m.gK(str2) : 0);
                    } else {
                        com.tencent.mm.plugin.fav.ui.h.a(this.mController.tml, str2, this.iWQ, this.bOz, 4);
                    }
                    if (!bi.oW(str)) {
                        com.tencent.mm.plugin.messenger.a.g.bcT().D(str2, str, s.hQ(str2));
                    }
                }
                com.tencent.mm.ui.widget.snackbar.b.h(this, getString(i.fav_finish_sent));
            }
        }
    }

    public final void d(c cVar) {
        if (cVar == null || cVar.field_dataId == null) {
            x.w("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, item is null");
            return;
        }
        x.d("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, dataID is %s, field id is %s", new Object[]{this.bOz.jdM, cVar.field_dataId});
        if (!cVar.field_dataId.equals(this.bOz.jdM)) {
            return;
        }
        if (this.iWQ.aLf() && bi.oW(this.bOz.rzo)) {
            b(cVar.getProgress(), getString(i.favorite_uploading, new Object[]{b.aj((float) cVar.field_offset), b.aj((float) cVar.field_totalLen)}));
            return;
        }
        b(cVar.getProgress(), getString(i.favorite_downloading, new Object[]{b.aj((float) cVar.field_offset), b.aj((float) cVar.field_totalLen)}));
        if (this.jcq && com.tencent.mm.vfs.d.cn(cVar.field_path)) {
            this.iWQ.field_itemStatus = 10;
            a("", null);
        }
    }

    private void b(float f, String str) {
        this.dvh.post(new 5(this, f, str));
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        x.i("MicroMsg.FavoriteFileDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[]{str, Long.valueOf(this.iWQ.field_localId)});
        g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(this.iWQ.field_localId);
        if (dy != null || this.jcq) {
            boolean z;
            if (!this.jcq) {
                this.iWQ = dy;
            }
            aMJ();
            c Br = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(this.bOz.jdM);
            if (Br == null) {
                z = false;
            } else if (Br.field_status == 1) {
                z = true;
            } else if (this.bOz.bjS == 8) {
                z = false;
            } else if (this.jcv) {
                z = false;
            } else {
                if (Br.field_status == 4 && ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().Br(this.bOz.jdM).field_extFlag != 0) {
                    b.a(this.iWQ, this.bOz, true);
                    this.jcv = true;
                }
                x.i("MicroMsg.FavoriteFileDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[]{Boolean.valueOf(this.jcv)});
                z = this.jcv;
            }
            if (!z) {
                this.dvh.post(new 6(this));
                return;
            }
            return;
        }
        x.w("MicroMsg.FavoriteFileDetailUI", "error, on notify change, cannot find info");
        finish();
    }

    private void aMN() {
        if (!this.jct) {
            h$a h_a = this.jcb;
            h_a.iVM++;
            this.jct = true;
            Intent intent = new Intent();
            intent.putExtra("key_detail_info_id", this.bJA);
            intent.putExtra("key_detail_fav_path", b.b(this.bOz));
            intent.putExtra("key_detail_fav_thumb_path", b.c(this.bOz));
            intent.putExtra("key_detail_fav_video_duration", this.bOz.duration);
            intent.putExtra("key_detail_statExtStr", this.bOz.bZN);
            b.a(this, ".ui.detail.FavoriteVideoPlayUI", intent);
            finish();
        }
    }
}
