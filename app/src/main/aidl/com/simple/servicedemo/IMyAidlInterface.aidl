// IMyAidlInterface.aidl
package com.simple.servicedemo;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    int plus(int a, int b);
    String toUpperCase(String str);
    void setData(String data);
}
