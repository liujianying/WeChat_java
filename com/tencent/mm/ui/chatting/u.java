package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public final class u {
    SharedPreferences duR;
    public LinearLayout irL = null;
    long iyn = -1;
    Context mContext;
    public String mim;
    String mio;
    String mip;
    public ChatFooterCustom tKI;
    public FrameLayout tKJ;
    public FrameLayout tKK;
    public TextView tKL;
    public ImageView tKM;
    a tKN = a.DEFAULT;
    public int tKO = -1;
    public boolean tKP;
    String tKQ = null;
    public String tKR;
    public OnClickListener tKS = new 1(this);
    public OnClickListener tKT = new 2(this);
    private com.tencent.mm.pluginsdk.ui.tools.i.a tKU = new 7(this);

    private enum a {
        DEFAULT,
        NEED_DOWNLOAD,
        DOWNLOADING,
        NEED_INSTALL,
        INSTALLED,
        NO_URL
    }

    static /* synthetic */ void a(u uVar) {
        x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[handleNoUrl]");
        h.a(uVar.mContext, com.tencent.mm.bp.a.af(uVar.mContext, R.l.chatfooter_mail_no_url_tip), "", com.tencent.mm.bp.a.af(uVar.mContext, R.l.chatfooter_mail_i_know), null);
    }

    static /* synthetic */ void b(u uVar) {
        x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initQQMailDownloadUrlAndMD5]");
        e.post(new 6(uVar), "QQMailDownloadUrlAndMD5");
    }

    public u(ChatFooterCustom chatFooterCustom) {
        this.mContext = chatFooterCustom.getContext();
        this.tKI = chatFooterCustom;
    }

    public final void ctS() {
        if (this.tKN == a.INSTALLED) {
            this.tKM.setImageResource(R.k.promo_icon_qqmail);
        } else {
            this.tKM.setImageResource(R.k.promo_icon_qqmail_uninstall);
        }
    }

    public final void ctT() {
        a aVar;
        if (!p.r(this.mContext, "com.tencent.androidqqmail")) {
            this.duR = this.mContext.getSharedPreferences("QQMAIL", 4);
            this.iyn = this.duR.getLong("qqmail_downloadid", -1);
            if (this.iyn >= 0) {
                FileDownloadTaskInfo cm = d.aCU().cm(this.iyn);
                int i = cm.status;
                this.tKQ = cm.path;
                switch (i) {
                    case 1:
                        aVar = a.DOWNLOADING;
                        break;
                    case 3:
                        if (!com.tencent.mm.a.e.cn(this.tKQ)) {
                            if (!bi.oW(this.mim)) {
                                aVar = a.NEED_DOWNLOAD;
                                break;
                            } else {
                                aVar = a.NO_URL;
                                break;
                            }
                        }
                        aVar = a.NEED_INSTALL;
                        break;
                    default:
                        if (!bi.oW(this.mim)) {
                            aVar = a.NEED_DOWNLOAD;
                            break;
                        } else {
                            aVar = a.NO_URL;
                            break;
                        }
                }
            }
            aVar = bi.oW(this.mim) ? a.NO_URL : a.NEED_DOWNLOAD;
        } else {
            aVar = a.INSTALLED;
        }
        this.tKN = aVar;
        ctS();
        x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", new Object[]{this.tKN.toString()});
        switch (this.tKN) {
            case NEED_INSTALL:
                this.tKL.setText(R.l.chatfooter_mail_install);
                return;
            case DOWNLOADING:
                this.tKL.setText(R.l.chatfooter_mail_downloading);
                return;
            case NEED_DOWNLOAD:
            case INSTALLED:
            case NO_URL:
                i.a(this.tKU);
                return;
            default:
                i.a(this.tKU);
                return;
        }
    }

    public final void ctU() {
        if (this.tKO == 0) {
            this.tKL.setText(R.l.chatfooter_mail_without_unread_count);
        } else if (this.tKO > 99) {
            this.tKL.setText(R.l.chatfooter_mail_with_unread_count_over_99);
        } else {
            this.tKL.setText(String.format(com.tencent.mm.bp.a.af(this.mContext, R.l.chatfooter_mail_with_unread_count), new Object[]{Integer.valueOf(this.tKO)}));
        }
    }
}
