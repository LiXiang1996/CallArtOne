// ITelephony.aidl
package com.lixiang.phonecall;

// Declare any non-default types here with import statements

interface ITelephony {
             boolean endCall();
             void answerRingingCall();
             void silenceRinger();
}