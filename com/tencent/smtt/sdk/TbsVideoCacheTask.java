package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.smtt.export.external.DexLoader;

public class TbsVideoCacheTask {
    public static final String KEY_VIDEO_CACHE_PARAM_FILENAME = "filename";
    public static final String KEY_VIDEO_CACHE_PARAM_FOLDERPATH = "folderPath";
    public static final String KEY_VIDEO_CACHE_PARAM_HEADER = "header";
    public static final String KEY_VIDEO_CACHE_PARAM_URL = "url";
    Context a = null;
    TbsVideoCacheListener b = null;
    private boolean c = false;
    private bd d = null;
    private String e;
    private String f;
    private Object g = null;

    public TbsVideoCacheTask(Context context, Bundle bundle, TbsVideoCacheListener tbsVideoCacheListener) {
        this.a = context;
        this.b = tbsVideoCacheListener;
        if (bundle != null) {
            this.e = bundle.getString("taskId");
            this.f = bundle.getString(KEY_VIDEO_CACHE_PARAM_URL);
        }
        a(bundle);
    }

    private void a(Bundle bundle) {
        if (this.d == null) {
            DexLoader b;
            o.a(true).a(this.a, false, false, null);
            bi a = o.a(true).a();
            if (a != null) {
                b = a.b();
            } else {
                this.b.onVideoDownloadError(this, -1, "init engine error!", null);
                b = null;
            }
            if (b != null) {
                this.d = new bd(b);
            } else {
                this.b.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
            }
        }
        if (this.d != null) {
            this.g = this.d.a(this.a, this, bundle);
            if (this.g == null) {
                this.b.onVideoDownloadError(this, -1, "init task error!", null);
            }
        } else if (this.b != null) {
            this.b.onVideoDownloadError(this, -1, "init error!", null);
        }
    }

    public long getContentLength() {
        if (this.d != null && this.g != null) {
            return this.d.d();
        }
        if (this.b != null) {
            this.b.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
        }
        return 0;
    }

    public int getDownloadedSize() {
        if (this.d != null && this.g != null) {
            return this.d.e();
        }
        if (this.b != null) {
            this.b.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
        }
        return 0;
    }

    public int getProgress() {
        if (this.d != null && this.g != null) {
            return this.d.f();
        }
        if (this.b != null) {
            this.b.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
        }
        return 0;
    }

    public String getTaskID() {
        return this.e;
    }

    public String getTaskUrl() {
        return this.f;
    }

    public void pauseTask() {
        if (this.d != null && this.g != null) {
            this.d.a();
        } else if (this.b != null) {
            this.b.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
        }
    }

    public void removeTask(boolean z) {
        if (this.d != null && this.g != null) {
            this.d.a(z);
        } else if (this.b != null) {
            this.b.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
        }
    }

    public void resumeTask() {
        if (this.d != null && this.g != null) {
            this.d.b();
        } else if (this.b != null) {
            this.b.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
        }
    }

    public void stopTask() {
        if (this.d != null && this.g != null) {
            this.d.c();
        } else if (this.b != null) {
            this.b.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
        }
    }
}
