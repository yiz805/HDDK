package com.hddk.mapper;

import jdk.nashorn.internal.objects.annotations.Where;
import org.apache.ibatis.jdbc.SQL;

public class SqlProvider {
    private final String activity_TABLE = "activity";

    //查询活动的报名记录
    public String GET_Activity_SignUp( int activity_id, Long student_id) {
        return new SQL() {
            {
                SELECT("*");
                FROM("activity_TABLE");
                WHERE("id");

            }
        }.toString();
    }
}
