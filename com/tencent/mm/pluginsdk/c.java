package com.tencent.mm.pluginsdk;

import com.tencent.mm.plugin.l.a.a;
import com.tencent.mm.plugin.l.a.b;
import java.util.HashMap;

public final class c {
    private static HashMap<String, Integer> qxZ = null;

    public static int Sz(String str) {
        if (qxZ == null) {
            HashMap hashMap = new HashMap();
            qxZ = hashMap;
            hashMap.put("avi", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("m4v", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("vob", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("mpeg", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("mpe", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("asx", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("asf", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("f4v", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("flv", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("mkv", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("wmv", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("wm", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("3gp", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("mp4", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("rmvb", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("rm", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("ra", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("ram", Integer.valueOf(b.app_attach_file_icon_video));
            qxZ.put("mp3pro", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("vqf", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("cd", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("md", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("mod", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("vorbis", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("au", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("amr", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("silk", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("wma", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("mmf", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("mid", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("midi", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("mp3", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("aac", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("ape", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("aiff", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("aif", Integer.valueOf(b.app_attach_file_icon_music));
            qxZ.put("jfif", Integer.valueOf(a.app_attach_file_icon_pic));
            qxZ.put("tiff", Integer.valueOf(a.app_attach_file_icon_pic));
            qxZ.put("tif", Integer.valueOf(a.app_attach_file_icon_pic));
            qxZ.put("jpe", Integer.valueOf(a.app_attach_file_icon_pic));
            qxZ.put("dib", Integer.valueOf(a.app_attach_file_icon_pic));
            qxZ.put("jpeg", Integer.valueOf(a.app_attach_file_icon_pic));
            qxZ.put("jpg", Integer.valueOf(a.app_attach_file_icon_pic));
            qxZ.put("png", Integer.valueOf(a.app_attach_file_icon_pic));
            qxZ.put("bmp", Integer.valueOf(a.app_attach_file_icon_pic));
            qxZ.put("gif", Integer.valueOf(a.app_attach_file_icon_pic));
            qxZ.put("rar", Integer.valueOf(b.app_attach_file_icon_rar));
            qxZ.put("zip", Integer.valueOf(b.app_attach_file_icon_rar));
            qxZ.put("7z", Integer.valueOf(b.app_attach_file_icon_rar));
            qxZ.put("iso", Integer.valueOf(b.app_attach_file_icon_rar));
            qxZ.put("cab", Integer.valueOf(b.app_attach_file_icon_rar));
            qxZ.put("doc", Integer.valueOf(b.app_attach_file_icon_word));
            qxZ.put("docx", Integer.valueOf(b.app_attach_file_icon_word));
            qxZ.put("ppt", Integer.valueOf(b.app_attach_file_icon_ppt));
            qxZ.put("pptx", Integer.valueOf(b.app_attach_file_icon_ppt));
            qxZ.put("xls", Integer.valueOf(b.app_attach_file_icon_excel));
            qxZ.put("xlsx", Integer.valueOf(b.app_attach_file_icon_excel));
            qxZ.put("txt", Integer.valueOf(b.app_attach_file_icon_txt));
            qxZ.put("rtf", Integer.valueOf(b.app_attach_file_icon_txt));
            qxZ.put("pdf", Integer.valueOf(b.app_attach_file_icon_pdf));
        }
        Integer num = (Integer) qxZ.get(str);
        if (num == null) {
            return b.app_attach_file_icon_unknow;
        }
        return num.intValue();
    }

    public static int cbi() {
        return b.app_attach_file_icon_unknow;
    }
}
