#include <jni.h>
#include <string>
#include <iostream>
#include <unistd.h>
#include <android/log.h>
#include <stdio.h>
using namespace std;

static jclass Important;
static jclass Function;
static jmethodID Request;
static string HEADER_KEY = "package";

static string BASE_URL = "https://api.github.com/";
static string GET_POPULAR_API = BASE_URL + "search/repositories";

static void request(JNIEnv *env , jobject serverResponse , jstring requestType , jstring Link ,
                    jobject jsonObject ,
                    jint requestcode , jobject context) {

    env->CallStaticVoidMethod(Function , Request , serverResponse , requestType , Link ,
                              jsonObject , requestcode);
}

static jstring get_package_name(
        JNIEnv *env,
        jobject jActivity
) {
    jclass jActivity_class = env->GetObjectClass(jActivity);

    jmethodID jMethod_id_pn = env->GetMethodID(
            jActivity_class,
            "getPackageName",
            "()Ljava/lang/String;");
    jstring package_name = (jstring) env->CallObjectMethod(
            jActivity,
            jMethod_id_pn);

    return package_name;
}

extern "C" JNIEXPORT void JNICALL
Java_com_example_bs23androidtask102_MainActivity_setUpEnvironment(JNIEnv* env,jobject object) {
    Important = env->FindClass("com/example/bs23androidtask102/Important/Important");
    jmethodID setBaseUrl = env->GetStaticMethodID(Important,"setBaseUrl", "(Ljava/lang/String;)V");
    env->CallStaticVoidMethod(Important,setBaseUrl,env->NewStringUTF(BASE_URL.c_str()));
    jmethodID setApiCall1 = env->GetStaticMethodID(Important,"setGetDesiredList", "(Ljava/lang/String;)V");
    env->CallStaticVoidMethod(Important,setApiCall1,env->NewStringUTF(GET_POPULAR_API.c_str()));
    Function = env->FindClass("com/example/bs23androidtask102/Functions/Functions");
    Request = env->GetStaticMethodID(Function , "Request" ,
                                     "(Lcom/example/bs23androidtask102/Listener/ServerResponse;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;I)V");

    jmethodID setHeaderKey =env->GetStaticMethodID(Important,"setHeaderKey", "(Ljava/lang/String;)V");
    jmethodID setHeader =env->GetStaticMethodID(Important,"setHeader", "(Ljava/lang/String;)V");


    jstring header = get_package_name(env,object);
    env->CallStaticVoidMethod(Important,setHeader,header);
    env->CallStaticVoidMethod(Important,setHeaderKey,env->NewStringUTF(HEADER_KEY.c_str()));



}
extern "C"
JNIEXPORT void JNICALL
Java_com_example_bs23androidtask102_MainActivity_globalRequest(JNIEnv *env, jclass clazz,
                                                               jobject server_response,
                                                               jstring requesttype, jstring link,
                                                               jobject json_object,
                                                               jint requestcode, jobject context) {
    request(env , server_response , requesttype , link , json_object , requestcode , context);

}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_bs23androidtask102_MainActivity_checkResponse(JNIEnv *env, jclass clazz,
                                                               jstring response) {
    // TODO: implement checkResponse()
}