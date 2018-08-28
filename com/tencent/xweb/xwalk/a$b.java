package com.tencent.xweb.xwalk;

import android.app.ProgressDialog;
import android.content.Context;

class a$b extends l {
    final /* synthetic */ a vEm;
    boolean vEv = false;
    private ProgressDialog vEw;

    public a$b(a aVar, Context context) {
        this.vEm = aVar;
        super(context);
    }

    public final void onXWalkUpdateProgress(int i) {
        super.onXWalkUpdateProgress(i);
        if (!this.vEv) {
            adJ("正在下载runtime");
            this.vEw.setProgress(i);
        }
    }

    public final void onXWalkUpdateFailed(int i) {
        super.onXWalkUpdateFailed(i);
        this.vEw.setCancelable(true);
        this.vEw.setCanceledOnTouchOutside(true);
        adJ("更新失败, error code = :" + i);
    }

    public final void onXWalkUpdateCancelled() {
        super.onXWalkUpdateCancelled();
        this.vEw.setCancelable(true);
        this.vEw.setCanceledOnTouchOutside(true);
        adJ("更新失败, 更新被取消");
    }

    public final void onXWalkUpdateCompleted() {
        super.onXWalkUpdateCompleted();
        adJ("更新完成，点任意位置重启进程生效");
        this.vEw.setCancelable(true);
        this.vEw.setCanceledOnTouchOutside(true);
        this.vEw.setProgress(100);
        this.vEv = true;
    }

    private void adJ(String str) {
        if (this.vEw == null) {
            this.vEw = new ProgressDialog(this.mContext);
            this.vEw.setProgressStyle(1);
            this.vEw.setMessage(str);
            this.vEw.setOnCancelListener(new 1(this));
            this.vEw.setCancelable(false);
            this.vEw.show();
        }
        this.vEw.setMessage(str);
    }
}
