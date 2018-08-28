package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class MailAttachListLinearLayout$1 implements OnClickListener {
    final /* synthetic */ String mhj;
    final /* synthetic */ String mhk;
    final /* synthetic */ String mhl;
    final /* synthetic */ long mhm;
    final /* synthetic */ int mhn;
    final /* synthetic */ String mho;
    final /* synthetic */ MailAttachListLinearLayout mhp;

    MailAttachListLinearLayout$1(MailAttachListLinearLayout mailAttachListLinearLayout, String str, String str2, String str3, long j, int i, String str4) {
        this.mhp = mailAttachListLinearLayout;
        this.mhj = str;
        this.mhk = str2;
        this.mhl = str3;
        this.mhm = j;
        this.mhn = i;
        this.mho = str4;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(MailAttachListLinearLayout.a(this.mhp), AttachDownloadPage.class);
        intent.putExtra("attach_name", this.mhj);
        intent.putExtra("mail_id", this.mhk);
        intent.putExtra("attach_id", this.mhl);
        intent.putExtra("total_size", this.mhm);
        intent.putExtra("is_preview", this.mhn);
        intent.putExtra("is_compress", MailAttachListLinearLayout.Kd(this.mho));
        MailAttachListLinearLayout.a(this.mhp).startActivity(intent);
    }
}
