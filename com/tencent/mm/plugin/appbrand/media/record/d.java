package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class d {
    public static final Long gim = Long.valueOf(259200000);
    public static final Long gin = Long.valueOf(86400000);
    public static final Long gio = Long.valueOf(43200000);
    public static final Long gip = Long.valueOf(240000);
    public static final Long giq = Long.valueOf(60000);
    public static final Long gir = gin;
    public static long gis = 0;
    private static List<String> git = new ArrayList(10);

    static /* synthetic */ void vg() {
        x.i("MicroMsg.Record.AudioRecordCacheClean", "clean audio record file");
        File file = new File(f.giQ, "AudioRecord");
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                x.i("MicroMsg.Record.AudioRecordCacheClean", "none files exist");
                return;
            }
            for (String str : list) {
                if (uw(str)) {
                    x.i("MicroMsg.Record.AudioRecordCacheClean", "file is the block file, don't delete");
                } else {
                    File file2 = new File(file + File.separator + str);
                    if (!file2.exists()) {
                        x.i("MicroMsg.Record.AudioRecordCacheClean", "file not exist");
                    } else if (file2.isDirectory()) {
                        x.i("MicroMsg.Record.AudioRecordCacheClean", "file is directory, don't delete");
                    } else if (System.currentTimeMillis() - file2.lastModified() > gim.longValue()) {
                        x.e("MicroMsg.Record.AudioRecordCacheClean", "Clean 3 days file in record file name=%s, path:%s", new Object[]{file2.getName(), file2.getAbsolutePath()});
                        file2.delete();
                    } else {
                        x.i("MicroMsg.Record.AudioRecordCacheClean", "not delete the file, file is in valid time for 3 day");
                    }
                }
            }
            return;
        }
        x.i("MicroMsg.Record.AudioRecordCacheClean", "AudioRecord is not exist or not Directory");
    }

    public static void ald() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - gis <= gir.longValue()) {
            x.e("MicroMsg.Record.AudioRecordCacheClean", "The last clean time is in AUDIO_RECORD_NO_SCAN_TIME time");
            return;
        }
        x.i("MicroMsg.Record.AudioRecordCacheClean", "start clean audio record file");
        gis = currentTimeMillis;
        e.post(new 1(), "AudioRecordCacheClean");
    }

    private static boolean uw(String str) {
        for (String contains : git) {
            if (str.contains(contains)) {
                return true;
            }
        }
        return false;
    }
}
