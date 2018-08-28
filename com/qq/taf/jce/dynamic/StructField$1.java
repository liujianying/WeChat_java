package com.qq.taf.jce.dynamic;

import java.util.Comparator;

class StructField$1 implements Comparator<JceField> {
    StructField$1() {
    }

    public int compare(JceField jceField, JceField jceField2) {
        return jceField.getTag() - jceField2.getTag();
    }
}
