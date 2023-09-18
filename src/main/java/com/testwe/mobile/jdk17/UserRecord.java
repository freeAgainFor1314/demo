package com.testwe.mobile.jdk17;

public record UserRecord(Long userId,String userName) {

    //编译好后的字节码文件
    /**
     * public UserRecord(Long userId, String userName) {
     *         this.userId = userId;
     *         this.userName = userName;
     *     }
     *
     *     public Long userId() {
     *         return this.userId;
     *     }
     *
     *     public String userName() {
     *         return this.userName;
     *     }
     */


}
