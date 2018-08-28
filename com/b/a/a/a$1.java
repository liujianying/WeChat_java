package com.b.a.a;

import java.io.File;
import java.io.FileFilter;

class a$1 implements FileFilter {
    a$1() {
    }

    public final boolean accept(File file) {
        String name = file.getName();
        if (!name.startsWith("cpu")) {
            return false;
        }
        for (int i = 3; i < name.length(); i++) {
            if (!Character.isDigit(name.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
