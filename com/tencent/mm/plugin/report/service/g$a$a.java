package com.tencent.mm.plugin.report.service;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class g$a$a implements FileFilter {
    g$a$a() {
    }

    public final boolean accept(File file) {
        if (Pattern.matches("cpu[0-9]", file.getName())) {
            return true;
        }
        return false;
    }
}
