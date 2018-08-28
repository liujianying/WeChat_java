package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.sns.i$e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am$a;
import com.tencent.mm.plugin.sns.model.b$b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.av;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

public class SnsStrangerCommentDetailUI extends MMActivity implements b$b {
    private static int obB = 4;
    private ImageView eKk;
    private TextView hEg;
    private ao nLP;
    private n nSE;
    private int nUa = -1;
    private a nYj = new a() {
        public final void a(String str, l lVar) {
            af.aRu().post(new 1(this));
        }
    };
    private long nkI;
    private ab obA;
    private ListView obs;
    private SnsCommentFooter obt;
    private View obu;
    private LinearLayout obv;
    private List<View> obw;
    private a obx;
    private boolean oby = false;
    private boolean obz = false;
    private int source;
    private String talker;

    static /* synthetic */ void a(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI, n nVar, String str) {
        if (str != null && !str.trim().equals("")) {
            am$a.a(snsStrangerCommentDetailUI.talker, 3, str, nVar, snsStrangerCommentDetailUI.source);
        }
    }

    static /* synthetic */ void b(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        String[] strArr = new String[1];
        if (snsStrangerCommentDetailUI.obA == null) {
            snsStrangerCommentDetailUI.obA = new ab();
            return;
        }
        if (!com.tencent.mm.l.a.gd(snsStrangerCommentDetailUI.obA.field_type)) {
            s.e(snsStrangerCommentDetailUI.obA);
        }
        if (snsStrangerCommentDetailUI.obA.BA()) {
            strArr[0] = snsStrangerCommentDetailUI.getString(j.contact_info_moveout_blacklist);
        } else {
            strArr[0] = snsStrangerCommentDetailUI.getString(j.contact_info_movein_blacklist);
        }
        h.a((Context) snsStrangerCommentDetailUI, "", strArr, "", false, new 6(snsStrangerCommentDetailUI));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(j.sns_comment_detial_ui_title);
        this.nkI = getIntent().getLongExtra("INTENT_SNSID", 0);
        this.talker = getIntent().getStringExtra("INTENT_TALKER");
        this.nSE = af.byo().fi(this.nkI);
        this.source = getIntent().getIntExtra("INTENT_SOURCE", -1);
        g.Ek();
        this.obA = ((i) g.l(i.class)).FR().Yg(this.talker);
        if (this.nSE == null || this.talker == null) {
            finish();
            return;
        }
        this.nLP = new ao(this);
        af.byt().c(this.nYj);
        initView();
    }

    public void onResume() {
        af.byj().a(this);
        super.onResume();
    }

    public void onPause() {
        af.byj().b(this);
        super.onPause();
    }

    protected void onDestroy() {
        af.byt().d(this.nYj);
        af.byl().H(this);
        if (this.obx != null) {
            this.obx.aYc();
        }
        super.onDestroy();
    }

    protected final void initView() {
        this.obs = (ListView) findViewById(f.album_comment_list);
        this.obt = (SnsCommentFooter) findViewById(f.comment_footer);
        this.obu = View.inflate(this, com.tencent.mm.plugin.sns.i.g.sns_stranger_comment_detail_header, null);
        this.obv = (LinearLayout) this.obu.findViewById(f.album_list);
        this.eKk = (ImageView) this.obu.findViewById(f.album_avatar_iv);
        this.hEg = (TextView) this.obu.findViewById(f.album_nick_name);
        b.p(this.eKk, this.nSE.field_userName);
        this.hEg.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this, ((com.tencent.mm.plugin.messenger.a.b) g.l(com.tencent.mm.plugin.messenger.a.b.class)).gT(this.nSE.field_userName), this.hEg.getTextSize()));
        bDM();
        for (int i = 0; i < this.obw.size(); i++) {
            ap apVar = new ap();
            apVar.bNH = this.nSE.bBe();
            apVar.index = i;
            apVar.nWx = this.obw;
            ((View) this.obw.get(i)).setTag(apVar);
            ((View) this.obw.get(i)).setOnClickListener(new 9(this));
        }
        this.obs.addHeaderView(this.obu);
        this.obx = new a(this, this);
        this.obs.post(new 10(this));
        this.obs.setAdapter(this.obx);
        this.obs.setOnScrollListener(new 11(this));
        this.obt.setAfterEditAction(new 2(this));
        this.obt.bDl();
        this.obt.setHeartBtnVisibility(8);
        this.obt.setOnCommentSendImp(new 3(this));
        this.obt.setHint(getString(j.sns_reply) + this.talker + getString(j.sns_after_reply));
        1 1 = new 1(this);
        setBackBtn(new 4(this));
        addIconOptionMenu(0, i$e.mm_title_btn_menu, new 5(this));
    }

    private void bDM() {
        this.obv.removeAllViews();
        int b = BackwardSupportUtil.b.b(this, (float) obB);
        List list = this.nSE.bAJ().sqc.ruA;
        this.obw = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            MMImageView mMImageView = new MMImageView(this);
            mMImageView.setPadding(b, b, b, b);
            this.obv.addView(mMImageView, new LayoutParams(-2, -2));
            Bitmap Fw = af.byl().a((ate) list.get(i), mMImageView, hashCode(), av.tbu).Fw();
            if (Fw == null) {
                int i2;
                switch (this.nSE.field_type) {
                    case 1:
                        i2 = i$e.app_attach_file_icon_pic;
                        break;
                    case 2:
                        mMImageView.setImageDrawable(null);
                        i2 = 0;
                        break;
                    case 3:
                        i2 = com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_webpage;
                        break;
                    case 4:
                        i2 = com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_music;
                        break;
                    case 5:
                        i2 = com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_video;
                        break;
                    case 6:
                        i2 = com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_location;
                        break;
                    case 7:
                        i2 = i$e.app_attach_file_icon_pic;
                        break;
                    case 8:
                        mMImageView.setImageDrawable(null);
                        i2 = 0;
                        break;
                    default:
                        i2 = com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_webpage;
                        break;
                }
                if (i2 != 0) {
                    mMImageView.setImageResource(i2);
                }
            } else {
                mMImageView.setImageBitmap(Fw);
            }
            this.obw.add(mMImageView);
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.sns_comment_detail;
    }

    public final void LR(String str) {
        bDM();
    }

    public final void aS(String str, boolean z) {
    }

    public final void bxb() {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsStrangerCommentDetailUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        Cursor managedQuery = managedQuery(intent.getData(), null, null, null, null);
                        if (managedQuery.moveToFirst()) {
                            startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void aT(String str, boolean z) {
    }
}
