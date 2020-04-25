package com.company;

import myPackage.Save;

public class MyClass {
    @Save
    private int valueInt;
    @Save
    public String valueString;
    @Save
    public long valueLong;

    public int getValueInt() {
        return valueInt;
    }

    public void setValueInt(int valueInt) {
        this.valueInt = valueInt;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    public long getValueLong() { return valueLong; }

    public String setValueLong(long valueLong) { this.valueLong = valueLong;
        return null;
    }

    public String valueLong(int i) {
        return setValueLong(i);
    }
}
