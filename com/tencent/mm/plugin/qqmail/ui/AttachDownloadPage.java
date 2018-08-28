package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.b.p.c;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AttachDownloadPage extends MMActivity {
    private TextView eBR;
    private ProgressBar eVR;
    private int elC = 0;
    private long emm = 0;
    private long gTK;
    private TextView guR;
    private Button jcf;
    private Button jch;
    private View jck;
    private String mcT;
    private String mcf;
    private long mea;
    private MMImageView mel;
    private ImageView mem;
    private ImageView men;
    private TextView meo;
    private String mep;
    private int meq;
    private boolean mer = false;
    private String mes;
    private boolean met = true;
    private int retryCount = 0;

    static /* synthetic */ void b(AttachDownloadPage attachDownloadPage, String str) {
        String cp = e.cp(str);
        if (cp != null && cp.length() != 0) {
            a.b(attachDownloadPage, str, cp, 3);
        }
    }

    static /* synthetic */ void g(AttachDownloadPage attachDownloadPage) {
        if (attachDownloadPage.mer) {
            Intent intent = new Intent(attachDownloadPage.mController.tml, CompressPreviewUI.class);
            intent.putExtra("mail_id", attachDownloadPage.mcf);
            intent.putExtra("attach_id", attachDownloadPage.mcT);
            intent.putExtra("attach_size", attachDownloadPage.gTK);
            intent.putExtra("attach_name", attachDownloadPage.mes);
            attachDownloadPage.mController.tml.startActivity(intent);
            return;
        }
        String[] strArr = new String[]{"mailid=" + attachDownloadPage.mcf, "attachid=" + attachDownloadPage.mcT, "texttype=html"};
        Intent intent2 = new Intent();
        intent2.putExtra("uri", "/cgi-bin/viewdocument");
        intent2.putExtra("params", strArr);
        intent2.putExtra("baseurl", p.bor());
        intent2.putExtra("method", "get");
        intent2.putExtra("singleColumn", FileExplorerUI.TZ(attachDownloadPage.mes));
        intent2.putExtra("title", attachDownloadPage.mes);
        intent2.setClass(attachDownloadPage, MailWebViewUI.class);
        attachDownloadPage.startActivity(intent2);
    }

    static /* synthetic */ void j(AttachDownloadPage attachDownloadPage) {
        long length = new File(attachDownloadPage.hf(true)).length();
        x.d("MicroMsg.AttachDownloadPage", "cur download size:" + length);
        attachDownloadPage.emm = length;
        attachDownloadPage.eVR.setProgress((int) ((100 * length) / attachDownloadPage.gTK));
        attachDownloadPage.meo.setText(attachDownloadPage.getString(R.l.mail_attach_downloading_speed, new Object[]{bi.bF(length), bi.bF(attachDownloadPage.gTK)}));
        if (attachDownloadPage.elC != 1 || attachDownloadPage.mea == 0) {
            attachDownloadPage.meo.setVisibility(8);
        } else {
            attachDownloadPage.meo.setVisibility(0);
        }
    }

    protected final int getLayoutId() {
        return R.i.attach_download_page;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.meq = getIntent().getIntExtra("is_preview", 0);
        this.mer = getIntent().getBooleanExtra("is_compress", false);
        this.mes = getIntent().getStringExtra("attach_name");
        this.mcf = getIntent().getStringExtra("mail_id");
        this.mcT = getIntent().getStringExtra("attach_id");
        this.gTK = getIntent().getLongExtra("total_size", 0);
        w.bow();
        this.mep = p.getDownloadPath();
        setMMTitle(this.mes);
        initView();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        w.bow().cancel(this.mea);
    }

    protected final void initView() {
        this.mel = (MMImageView) findViewById(R.h.download_type_icon);
        this.jck = findViewById(R.h.download_progress_area);
        this.eVR = (ProgressBar) findViewById(R.h.download_pb);
        this.mem = (ImageView) findViewById(R.h.download_stop_btn);
        this.men = (ImageView) findViewById(R.h.download_restart_btn);
        this.meo = (TextView) findViewById(R.h.attach_download_speed_tv);
        this.jcf = (Button) findViewById(R.h.attach_preview_btn);
        this.jch = (Button) findViewById(R.h.attach_download_btn);
        this.eBR = (TextView) findViewById(R.h.attach_download_status_tv);
        this.guR = (TextView) findViewById(R.h.attach_try_open_tv);
        if (FileExplorerUI.TZ(this.mes)) {
            this.mel.setBackgroundResource(R.k.download_image_icon);
        } else if (FileExplorerUI.Ua(this.mes)) {
            this.mel.setImageResource(R.k.app_attach_file_icon_video);
        } else {
            int SQ = o.SQ(e.cp(this.mes));
            if (SQ > 0) {
                this.mel.setImageResource(SQ);
            } else {
                this.mel.setImageResource(R.k.app_attach_file_icon_unknow);
            }
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AttachDownloadPage.this.finish();
                return true;
            }
        });
        addIconOptionMenu(0, R.k.ofm_send_icon, new 2(this));
        enableOptionMenu(false);
        boH();
        if (this.elC == 1) {
            boC();
        } else {
            boD();
        }
    }

    private void boC() {
        this.jck.setVisibility(0);
        this.jcf.setVisibility(8);
        this.jch.setVisibility(8);
        this.mem.setVisibility(0);
        this.men.setVisibility(8);
        this.meo.setVisibility(8);
        this.eBR.setVisibility(8);
        this.guR.setVisibility(8);
        this.mem.setOnClickListener(new 3(this));
        this.men.setOnClickListener(new 4(this));
    }

    private void boD() {
        if (this.meq == 1) {
            if (FileExplorerUI.TZ(this.mes)) {
                if (this.elC == 3) {
                    Intent intent = new Intent();
                    intent.putExtra("key_favorite", true);
                    intent.putExtra("key_favorite_source_type", 9);
                    intent.putExtra("key_image_path", hf(false));
                    com.tencent.mm.plugin.qqmail.a.a.ezn.d(this.mController.tml, intent);
                    finish();
                    return;
                } else if (this.elC == 0 || this.met) {
                    this.retryCount = 0;
                    this.met = false;
                    boE();
                    boC();
                    return;
                }
            }
            this.jck.setVisibility(8);
            this.eBR.setVisibility(0);
            this.meo.setVisibility(8);
            this.jcf.setVisibility(0);
            this.jch.setVisibility(8);
            this.guR.setVisibility(0);
            this.jcf.setOnClickListener(new 5(this));
            if (this.elC == 3) {
                this.eBR.setText(R.l.mail_attach_preview_status);
                this.guR.setText(R.l.mail_attach_preview_open_downloaded);
                this.guR.setOnClickListener(new 6(this));
                enableOptionMenu(true);
                return;
            }
            this.eBR.setText(R.l.mail_attach_preview_status);
            if (this.elC == 2) {
                this.guR.setText(R.l.mail_attach_preview_open_redownload);
            } else {
                this.guR.setText(R.l.mail_attach_preview_open_notdownload);
            }
            this.guR.setOnClickListener(new 7(this));
        } else if (this.meq == 0) {
            this.jck.setVisibility(8);
            this.jcf.setVisibility(8);
            this.jch.setVisibility(0);
            this.meo.setVisibility(8);
            this.eBR.setVisibility(0);
            this.guR.setVisibility(8);
            if (this.elC == 3) {
                this.jch.setText(R.l.mail_attach_downloaded);
                enableOptionMenu(true);
            } else if (this.elC == 2) {
                this.jch.setText(R.l.mail_attach_redownload);
            } else {
                this.jch.setText(R.l.mail_attach_download);
            }
            this.eBR.setText(R.l.mail_attach_download_status);
            this.jch.setOnClickListener(new 8(this));
        }
    }

    private void boE() {
        boH();
        if (this.elC == 4) {
            if (this.retryCount < 5) {
                this.retryCount++;
                boE();
            } else {
                boD();
            }
        } else if (this.elC == 3) {
            e.i(this.mep, boF() + ".temp", boF());
            this.elC = 3;
            boD();
        }
        Map hashMap = new HashMap();
        hashMap.put("mailid", this.mcf);
        hashMap.put("attachid", this.mcT);
        hashMap.put("username", "");
        hashMap.put("offset", this.emm);
        hashMap.put("datalen", this.gTK);
        hashMap.put("default_attach_name", boF() + ".temp");
        c cVar = new c();
        cVar.mdl = false;
        cVar.mdm = false;
        this.mea = w.bow().a("/cgi-bin/mmdownload", hashMap, cVar, new 9(this));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        a.a(this, i, i2, intent, true, R.l.download_no_match_msg, R.l.download_no_match_title, 3);
    }

    private String boF() {
        String substring;
        int hashCode = this.mcT.hashCode() & 65535;
        int lastIndexOf = this.mes.lastIndexOf(".");
        String str = "";
        if (lastIndexOf != -1) {
            substring = this.mes.substring(0, lastIndexOf);
            str = this.mes.substring(lastIndexOf, this.mes.length());
        } else {
            substring = this.mes;
        }
        return String.format("%s_%d%s", new Object[]{substring, Integer.valueOf(hashCode), str});
    }

    private String hf(boolean z) {
        return this.mep + boF() + (!z ? "" : ".temp");
    }

    private String boG() {
        return this.mep + this.mes;
    }

    private void boH() {
        if (e.cn(hf(true))) {
            this.emm = (long) e.cm(hf(true));
            this.elC = 2;
        } else if (e.cn(hf(false))) {
            this.elC = 3;
        } else if (!e.cn(boG())) {
            this.emm = 0;
            this.elC = 0;
        } else if (((long) e.cm(boG())) == this.gTK) {
            e.i(this.mep, this.mes, boF());
            this.elC = 3;
        } else if (((long) e.cm(boG())) > this.gTK) {
            e.deleteFile(boG());
            this.emm = 0;
            this.elC = 4;
        } else {
            this.emm = 0;
            this.elC = 0;
        }
    }
}
