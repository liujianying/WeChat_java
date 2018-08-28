package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.tools.a;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.p;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class RecordMsgFileUI extends MMActivity implements c {
    private long bJC;
    private vx bOz;
    private ag dvh;
    private TextView eMe;
    private ProgressBar eVR;
    private TextView gmo;
    private f hEl = null;
    private Button jcf;
    private Button jcg;
    private Button jch;
    private MMImageView jci;
    private TextView jcj;
    private View jck;
    private View jcl;
    private boolean jcp = false;
    private boolean jct = false;
    private boolean jcu = false;
    private String mediaId;
    private com.tencent.mm.plugin.record.b.f mtf;

    static /* synthetic */ void h(RecordMsgFileUI recordMsgFileUI) {
        int i = 1;
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        if (recordMsgFileUI.getType() == 15) {
            i = 11;
            intent.putExtra("image_path", recordMsgFileUI.bqK());
        } else if (recordMsgFileUI.getType() == 4) {
            intent.putExtra("image_path", recordMsgFileUI.bqK());
        } else {
            intent.putExtra("desc_title", recordMsgFileUI.bOz.title);
            i = 3;
        }
        intent.putExtra("Retr_Msg_Type", i);
        d.b(recordMsgFileUI, ".ui.transmit.SelectConversationUI", intent, 1001);
    }

    protected final int getLayoutId() {
        return R.i.file_download_ui;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dvh = new ag();
        this.mtf = new com.tencent.mm.plugin.record.b.f();
        this.bJC = getIntent().getLongExtra("message_id", -1);
        String stringExtra = getIntent().getStringExtra("record_data_id");
        com.tencent.mm.protocal.b.a.c Ks = h.Ks(getIntent().getStringExtra("record_xml"));
        if (Ks == null) {
            x.w("MicroMsg.RecordMsgFileUI", "get record msg data error, empty");
            finish();
            return;
        }
        Iterator it = Ks.dzs.iterator();
        while (it.hasNext()) {
            vx vxVar = (vx) it.next();
            if (vxVar.jdM.equals(stringExtra)) {
                this.bOz = vxVar;
            }
        }
        if (this.bOz == null) {
            x.w("MicroMsg.RecordMsgFileUI", "get data error, empty");
            finish();
            return;
        }
        boolean z;
        this.mediaId = h.e(this.bOz.jdM, this.bJC, true);
        this.jcf = (Button) findViewById(R.h.preview_btn);
        this.jcg = (Button) findViewById(R.h.open_btn);
        this.jch = (Button) findViewById(R.h.download_btn);
        this.jci = (MMImageView) findViewById(R.h.icon_iv);
        this.eMe = (TextView) findViewById(R.h.name_tv);
        this.gmo = (TextView) findViewById(R.h.tips_tv);
        this.jcl = findViewById(R.h.download_stop_btn);
        this.jck = findViewById(R.h.download_progress_area);
        this.eVR = (ProgressBar) findViewById(R.h.download_pb);
        this.jcj = (TextView) findViewById(R.h.download_progress_tips);
        if (4 == getType()) {
            setMMTitle(R.l.favorite_video);
        } else if (15 == getType()) {
            setMMTitle(R.l.favorite_sight);
            findViewById(R.h.video_container).setBackgroundResource(R.e.black);
        } else {
            setMMTitle(R.l.favorite_file);
        }
        if (getType() == 4) {
            this.jci.setImageResource(R.k.app_attach_file_icon_video);
        } else {
            this.jci.setImageResource(com.tencent.mm.pluginsdk.c.Sz(this.bOz.rzD));
        }
        this.eMe.setText(this.bOz.title);
        setBackBtn(new 1(this));
        this.jcg.setOnClickListener(new 7(this));
        String str = this.bOz.rzv;
        if (!bi.oW(str)) {
            this.jcf.setOnClickListener(new 8(this, str));
        }
        this.jch.setOnClickListener(new 9(this));
        this.jcl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                RecordMsgFileUI.this.aMM();
            }
        });
        if (getType() != 15 || bi.WU(g.AT().getValue("SightForwardEnable")) == 1) {
            addIconOptionMenu(0, R.g.mm_title_btn_menu, new 11(this));
        } else {
            x.w("MicroMsg.RecordMsgFileUI", "can not retransmit sight msg");
        }
        if (bi.oW(this.bOz.rzo) || bi.oW(this.bOz.rzq)) {
            z = true;
        } else {
            z = false;
        }
        boolean z2 = bi.oW(this.bOz.rAG) || bi.oW(this.bOz.rAD);
        if (!z && !z2) {
            aMK();
        } else if (h.d(this.bOz, this.bJC)) {
            enableOptionMenu(true);
            bqJ();
        } else {
            com.tencent.mm.plugin.record.a.f Kr = n.getRecordMsgCDNStorage().Kr(this.mediaId);
            if (Kr == null || 2 == Kr.field_status) {
                aMM();
            } else if (4 == Kr.field_status) {
                aMK();
            } else if (Kr.field_status == 0 || 1 == Kr.field_status) {
                aML();
            } else {
                x.w("MicroMsg.RecordMsgFileUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                aMM();
            }
            enableOptionMenu(false);
        }
        n.getRecordMsgCDNStorage().a(this);
    }

    private int getType() {
        int i = this.bOz.bjS;
        if (i == 15) {
            return 4;
        }
        return i;
    }

    private void aMK() {
        this.jch.setVisibility(8);
        this.jcf.setVisibility(8);
        this.jcg.setVisibility(8);
        this.jck.setVisibility(8);
        this.gmo.setVisibility(0);
        if (this.bOz.bjS == 4) {
            this.gmo.setGravity(17);
            this.gmo.setText(R.l.favorite_out_of_date_video);
            return;
        }
        this.gmo.setGravity(17);
        this.gmo.setText(R.l.favorite_out_of_date_file);
    }

    private void aML() {
        this.jch.setVisibility(8);
        this.jcf.setVisibility(8);
        this.jcg.setVisibility(8);
        this.gmo.setVisibility(8);
        this.jck.setVisibility(0);
        c(n.getRecordMsgCDNStorage().Kr(this.mediaId));
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
        this.jch.setText(R.l.favorite_item_download);
        this.gmo.setVisibility(8);
    }

    private void bqJ() {
        if (!(getType() != 15 || this.bOz.rAo == null || bi.oW(this.bOz.rAo.dyJ) || bi.oW(this.bOz.rAo.dyN))) {
            this.jcu = true;
            this.jci.setVisibility(8);
            this.jck.setVisibility(8);
            this.jch.setVisibility(8);
            this.jcf.setVisibility(8);
            this.jcg.setVisibility(8);
            this.gmo.setVisibility(8);
            String c = h.c(this.bOz, this.bJC);
            x.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.Ab() + " initView: fullpath:" + c);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.h.video_container);
            this.hEl = o.fb(this.mController.tml);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            viewGroup.addView((View) this.hEl, 0, layoutParams);
            this.hEl.setVideoCallback(new 12(this));
            x.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.Ab() + " initView :" + c);
            if (c != null) {
                this.hEl.stop();
                this.hEl.setVideoPath(c);
            }
            x.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.Ab() + " initView");
            if (au.vv() != null) {
                au.vv().xv();
            }
        }
        if (getType() != 15 && getType() != 4) {
            this.jck.setVisibility(8);
            this.jch.setVisibility(4);
            if (bi.oW(this.bOz.rzv)) {
                this.jcf.setVisibility(8);
            } else {
                this.jcf.setVisibility(0);
            }
            this.jcg.setVisibility(0);
            this.gmo.setVisibility(0);
        } else if (!this.jcu) {
            this.jck.setVisibility(8);
            this.jch.setVisibility(8);
            this.jcf.setVisibility(8);
            this.jcg.setVisibility(0);
            this.jcg.setText(R.l.favorite_item_preview);
            this.gmo.setVisibility(8);
            aMN();
        }
    }

    protected void onDestroy() {
        if (this.hEl != null) {
            this.hEl.setVideoCallback(null);
            this.hEl.stop();
            this.hEl.onDetach();
            if (au.vv() != null) {
                au.vv().xu();
            }
        }
        super.onDestroy();
        n.getRecordMsgCDNStorage().b(this);
        this.mtf.destory();
    }

    protected void onResume() {
        super.onResume();
        if (this.hEl != null) {
            this.hEl.start();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.hEl != null) {
            this.hEl.stop();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        a.a(this, i, i2, intent, true, R.l.download_no_match_msg, R.l.download_no_match_title, 5);
        if (i2 == -1 && i == 1001) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            p a = com.tencent.mm.ui.base.h.a(this.mController.tml, getString(R.l.favorite_forward_tips), false, null);
            x.d("MicroMsg.RecordMsgFileUI", "do share msg, fav msg type %d", new Object[]{Integer.valueOf(getType())});
            final 13 13 = new 13(this, a);
            if (!bi.oW(stringExtra)) {
                final List F = bi.F(stringExtra.split(","));
                if (getType() == 4 || getType() == 15) {
                    au.Em().H(new 14(this, F, str, 13));
                } else {
                    au.Em().H(new Runnable() {
                        public final void run() {
                            String c = h.c(RecordMsgFileUI.this.bOz, RecordMsgFileUI.this.bJC);
                            WXFileObject wXFileObject = new WXFileObject();
                            wXFileObject.setFilePath(c);
                            WXMediaMessage wXMediaMessage = new WXMediaMessage();
                            wXMediaMessage.mediaObject = wXFileObject;
                            wXMediaMessage.title = RecordMsgFileUI.this.bOz.title;
                            wXMediaMessage.description = RecordMsgFileUI.this.bOz.desc;
                            wXMediaMessage.thumbData = bi.readFromFile(h.f(RecordMsgFileUI.this.bOz, RecordMsgFileUI.this.bJC));
                            for (String str : F) {
                                l.a(wXMediaMessage, "", "", str, 3, null);
                                com.tencent.mm.plugin.messenger.a.g.bcT().dF(str, str);
                            }
                            ah.A(13);
                        }

                        public final String toString() {
                            return super.toString() + "|onActivityResult2";
                        }
                    });
                }
            }
        }
    }

    private String bqK() {
        File file = new File(h.f(this.bOz, this.bJC));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        return stringBuilder.append(com.tencent.mm.model.c.Gm()).append("web/").append(com.tencent.mm.a.g.u(bi.aG(this.bOz.bJv, "").getBytes())).toString();
    }

    private void c(com.tencent.mm.plugin.record.a.f fVar) {
        int i;
        int i2;
        int i3;
        if (fVar != null) {
            int max = (int) ((((float) fVar.field_offset) / ((float) Math.max(1, fVar.field_totalLen))) * 100.0f);
            i = fVar.field_offset;
            i2 = fVar.field_totalLen;
            i3 = max;
        } else {
            i2 = (int) this.bOz.rzJ;
            i = 0;
            i3 = 0;
        }
        this.dvh.post(new Runnable() {
            public final void run() {
                RecordMsgFileUI.this.eVR.setProgress(i3);
                RecordMsgFileUI.this.jcj.setText(RecordMsgFileUI.this.getString(R.l.favorite_downloading, new Object[]{bi.aj((float) i), bi.aj((float) i2)}));
            }
        });
    }

    public final void a(int i, com.tencent.mm.plugin.record.a.f fVar) {
        if (fVar == null) {
            x.w("MicroMsg.RecordMsgFileUI", "on cdn info changed, but cdn info is null");
            return;
        }
        x.v("MicroMsg.RecordMsgFileUI", "cur mediaid[%s], notify mediaid[%s]", new Object[]{this.mediaId, fVar.field_mediaId});
        if (this.mediaId.equals(fVar.field_mediaId)) {
            switch (fVar.field_status) {
                case 2:
                    this.dvh.post(new 4(this));
                    return;
                case 3:
                    this.dvh.post(new 6(this));
                    return;
                case 4:
                    this.dvh.post(new 5(this));
                    return;
                default:
                    c(fVar);
                    return;
            }
        }
    }

    private void aMN() {
        if (!this.jct) {
            this.jct = true;
            Intent intent = new Intent();
            intent.putExtra("key_detail_fav_path", h.c(this.bOz, this.bJC));
            intent.putExtra("key_detail_fav_thumb_path", h.f(this.bOz, this.bJC));
            intent.putExtra("key_detail_fav_video_duration", this.bOz.duration);
            intent.putExtra("key_detail_statExtStr", this.bOz.bZN);
            intent.putExtra("key_detail_fav_video_scene_from", 1);
            b.a((Context) this, ".ui.detail.FavoriteVideoPlayUI", intent);
            finish();
        }
    }
}
