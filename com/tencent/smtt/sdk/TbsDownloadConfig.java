package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.xwalk.core.XWalkUpdater;

public class TbsDownloadConfig {
    public static final int CMD_ID_DOWNLOAD_FILE = 101;
    public static final int CMD_ID_FILE_UPLOAD = 100;
    public static final long DEFAULT_RETRY_INTERVAL_SEC = 86400;
    public static final int ERROR_DOWNLOAD = 2;
    public static final int ERROR_INSTALL = 5;
    public static final int ERROR_LOAD = 6;
    public static final int ERROR_NONE = 1;
    public static final int ERROR_REPORTED = 0;
    public static final int ERROR_UNZIP = 4;
    public static final int ERROR_VERIFY = 3;
    private static TbsDownloadConfig b;
    Map<String, Object> a = new HashMap();
    private Context c;
    public SharedPreferences mPreferences;

    private TbsDownloadConfig(Context context) {
        this.mPreferences = context.getSharedPreferences("tbs_download_config", 4);
        this.c = context.getApplicationContext();
        if (this.c == null) {
            this.c = context;
        }
    }

    public static synchronized TbsDownloadConfig getInstance() {
        TbsDownloadConfig tbsDownloadConfig;
        synchronized (TbsDownloadConfig.class) {
            tbsDownloadConfig = b;
        }
        return tbsDownloadConfig;
    }

    public static synchronized TbsDownloadConfig getInstance(Context context) {
        TbsDownloadConfig tbsDownloadConfig;
        synchronized (TbsDownloadConfig.class) {
            if (b == null) {
                b = new TbsDownloadConfig(context);
            }
            tbsDownloadConfig = b;
        }
        return tbsDownloadConfig;
    }

    public void clear() {
        try {
            this.a.clear();
            Editor edit = this.mPreferences.edit();
            edit.clear();
            edit.commit();
        } catch (Exception e) {
        }
    }

    public synchronized void commit() {
        try {
            Editor edit = this.mPreferences.edit();
            for (String str : this.a.keySet()) {
                Object obj = this.a.get(str);
                if (obj instanceof String) {
                    edit.putString(str, (String) obj);
                } else if (obj instanceof Boolean) {
                    edit.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Long) {
                    edit.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof Integer) {
                    edit.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Float) {
                    edit.putFloat(str, ((Float) obj).floatValue());
                }
            }
            edit.commit();
            this.a.clear();
        } catch (Exception e) {
        }
    }

    public synchronized int getDownloadFailedMaxRetrytimes() {
        int i;
        i = this.mPreferences.getInt("tbs_download_failed_max_retrytimes", 0);
        if (i == 0) {
            i = 100;
        }
        return i;
    }

    public synchronized int getDownloadInterruptCode() {
        int i;
        if (this.mPreferences.contains("tbs_download_interrupt_code")) {
            i = this.mPreferences.getInt("tbs_download_interrupt_code", -99);
            if (i == -119 || i == -121) {
                i = this.mPreferences.getInt("tbs_download_interrupt_code_reason", -119);
            }
            if (System.currentTimeMillis() - this.mPreferences.getLong("tbs_download_interrupt_time", 0) > 86400000) {
                i -= 98000;
            }
        } else {
            try {
                i = !new File(new File(this.c.getFilesDir(), "shared_prefs"), "tbs_download_config").exists() ? -97 : !this.mPreferences.contains("tbs_needdownload") ? -96 : XWalkUpdater.ERROR_SET_VERNUM;
            } catch (Throwable th) {
                i = -95;
            }
        }
        i = (this.c == null || !"com.tencent.mobileqq".equals(this.c.getApplicationInfo().packageName) || "CN".equals(Locale.getDefault().getCountry())) ? (i * 1000) + this.mPreferences.getInt("tbs_install_interrupt_code", -1) : -320;
        return i;
    }

    public synchronized long getDownloadMaxflow() {
        int i;
        i = this.mPreferences.getInt("tbs_download_maxflow", 0);
        if (i == 0) {
            i = 20;
        }
        return ((long) (i * 1024)) * 1024;
    }

    public synchronized long getDownloadMinFreeSpace() {
        long j;
        int i = 0;
        synchronized (this) {
            int i2 = this.mPreferences.getInt("tbs_download_min_free_space", 0);
            if (i2 != 0) {
                i = i2;
            }
            j = ((long) (i * 1024)) * 1024;
        }
        return j;
    }

    public synchronized long getDownloadSingleTimeout() {
        long j;
        j = this.mPreferences.getLong("tbs_single_timeout", 0);
        if (j == 0) {
            j = 1200000;
        }
        return j;
    }

    public synchronized int getDownloadSuccessMaxRetrytimes() {
        int i;
        i = this.mPreferences.getInt("tbs_download_success_max_retrytimes", 0);
        if (i == 0) {
            i = 3;
        }
        return i;
    }

    public synchronized long getRetryInterval() {
        return TbsDownloader.getRetryIntervalInSeconds() >= 0 ? TbsDownloader.getRetryIntervalInSeconds() : this.mPreferences.getLong("retry_interval", DEFAULT_RETRY_INTERVAL_SEC);
    }

    public synchronized boolean getTbsCoreLoadRenameFileLockEnable() {
        boolean z = true;
        synchronized (this) {
            try {
                z = this.mPreferences.getBoolean("tbs_core_load_rename_file_lock_enable", true);
            } catch (Exception e) {
            }
        }
        return z;
    }

    public synchronized boolean isOverSea() {
        return this.mPreferences.getBoolean("is_oversea", false);
    }

    public synchronized void setDownloadInterruptCode(int i) {
        try {
            Editor edit = this.mPreferences.edit();
            edit.putInt("tbs_download_interrupt_code", i);
            edit.putLong("tbs_download_interrupt_time", System.currentTimeMillis());
            edit.commit();
        } catch (Exception e) {
        }
    }

    public synchronized void setInstallInterruptCode(int i) {
        Editor edit = this.mPreferences.edit();
        edit.putInt("tbs_install_interrupt_code", i);
        edit.commit();
    }

    public synchronized void setTbsCoreLoadRenameFileLockEnable(boolean z) {
        try {
            Editor edit = this.mPreferences.edit();
            edit.putBoolean("tbs_core_load_rename_file_lock_enable", z);
            edit.commit();
        } catch (Exception e) {
        }
    }
}
